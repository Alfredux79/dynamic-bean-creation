package io.alfredux.spring.dynamicbean.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class ActuatorReaderService {
	
	@Autowired
	RestTemplate restTemplate;
	
	String property;
	
	public String readProperty(){
		try {
			return restTemplate.exchange(
					new URI("http://localhost:8080/actuator/"+property), 
					HttpMethod.GET, 
					new HttpEntity<>(new HttpHeaders()),
					String.class).getBody();
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
