package com.spring.myapp.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserDataRestTemplate {
	
	RestTemplate restTemplate = new RestTemplate();
	String fooResourceUrl
	  = "https://randomuser.me/api";
	ResponseEntity<String> response
	  = restTemplate.getForEntity(fooResourceUrl, String.class);
	
}
