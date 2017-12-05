package io.alfredux.spring.dynamicbean.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.alfredux.spring.dynamicbean.repository.ReaderConfigurationRepository;

@Service
public class ActuatorConfigurationService {

	@Autowired
	ReaderConfigurationRepository readerConfigurationRepository;
		
	public List<String> readCongiguration(){
		return readerConfigurationRepository.findAll().stream()
				.map(c -> c.getProperty()).collect(Collectors.toList());
	}

}
