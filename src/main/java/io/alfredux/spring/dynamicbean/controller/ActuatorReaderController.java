package io.alfredux.spring.dynamicbean.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.alfredux.spring.dynamicbean.service.ActuatorConfigurationService;
import io.alfredux.spring.dynamicbean.service.ActuatorReaderService;

@Controller
public class ActuatorReaderController {
	
	private final Logger log = LoggerFactory.getLogger(ActuatorReaderController.class);
	
	@Autowired
	ActuatorConfigurationService actuatorConfigurationService;
	
	@Autowired
	@Qualifier("runtimeServices")
	Map<String,ActuatorReaderService> runtimeServices;
	
	@GetMapping("read/{property}")
	public ResponseEntity<String> readProperty(@PathVariable("property") String property){
		
		log.info("Services: {}", runtimeServices.keySet()); 
		
		ActuatorReaderService service = runtimeServices.get(property);
		
		ResponseEntity<String> response = new ResponseEntity<>(
				service.readProperty(),
				HttpStatus.ACCEPTED
				);
		
		actuatorConfigurationService.reloadBeans();
		
		return response;
	}
}
