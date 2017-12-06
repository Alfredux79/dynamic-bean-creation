package io.alfredux.spring.dynamicbean.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import io.alfredux.spring.dynamicbean.repository.ReaderConfigurationRepository;

@Service
public class ActuatorConfigurationService {

	private final Logger log = LoggerFactory.getLogger(ActuatorConfigurationService.class);

	@Autowired
	@Qualifier("runtimeServices")
	Map<String,ActuatorReaderService> runtimeServices;
	
	@Autowired
	ReaderConfigurationRepository readerConfigurationRepository;

	@Autowired
	ApplicationContext context;
	
	@Autowired 
	ListableBeanFactory beanFactory;
	
	public List<String> readCongiguration() {
		return readerConfigurationRepository.findAll().stream().map(c -> c.getProperty()).collect(Collectors.toList());
	}

	public void reloadBeans() {
		for(String configItem:readCongiguration()) {
			log.info("Loading config item {}",configItem);
			runtimeServices.put(configItem,(generateReaderService(configItem)));
			
		}
		log.info("Loaded beans: {}",runtimeServices);
		
	}
	
	public ActuatorReaderService generateReaderService(String configItem) {
		ActuatorReaderService service = context.getAutowireCapableBeanFactory().createBean(ActuatorReaderService.class);
		service.setProperty(configItem);
		return service;
	}

}
