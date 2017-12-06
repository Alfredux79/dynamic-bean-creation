package io.alfredux.spring.dynamicbean.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.alfredux.spring.dynamicbean.service.ActuatorConfigurationService;

@Controller
public class ReloadConfigurationController {
	
	@Autowired
	ActuatorConfigurationService actuatorConfigurationService;
	
	@GetMapping("reload")
	public ResponseEntity<List<String>> reloadConfiguration(){
		
		ResponseEntity<List<String>> response = new ResponseEntity<>(
				actuatorConfigurationService.readCongiguration(),
				HttpStatus.ACCEPTED
				);
		
		actuatorConfigurationService.reloadBeans();
		
		return response;
	}
}
