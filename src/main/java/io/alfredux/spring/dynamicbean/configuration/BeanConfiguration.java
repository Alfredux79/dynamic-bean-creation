package io.alfredux.spring.dynamicbean.configuration;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.alfredux.spring.dynamicbean.service.ActuatorReaderService;

@Configuration
public class BeanConfiguration  {
    
	private final Logger log = LoggerFactory.getLogger(BeanConfiguration.class);
	
	@Bean(name="restTemplate")
	RestTemplate restTemplate() {
		log.info("Initializing rest template");
		return new RestTemplate();
	}
	
	@Bean(name="runtimeServices")
	public Map<String,ActuatorReaderService> runtimeServices(){
		return new HashMap<>();
	}
	
	
}