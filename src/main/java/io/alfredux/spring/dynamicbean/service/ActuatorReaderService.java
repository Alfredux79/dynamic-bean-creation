package io.alfredux.spring.dynamicbean.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Scope("prototype")
public class ActuatorReaderService {
	
	@Autowired
	RestTemplate restTemplate;
	
	String property;
	
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

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
