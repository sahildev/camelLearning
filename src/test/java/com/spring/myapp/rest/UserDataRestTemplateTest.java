package com.spring.myapp.rest;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class UserDataRestTemplateTest {

	private RestTemplate restTemplate;

	@Test
	public void givenResourceUrl_whenSendGetForRequestEntity_thenStatusOk() throws IOException {
		// String fooResourceUrl= "https://randomuser.me/api";
		// final ResponseEntity<String> response =
		// restTemplate.getForEntity(fooResourceUrl, String.class);
		// assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

		final Logger log = LoggerFactory.getLogger(UserDataRestTemplateTest.class);

		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> response = (Map<String, String>) restTemplate
				.getForObject("https://randomuser.me/api", Map.class);
		/*
		 * Map<String, String> response = (Map<String, String>) restTemplate
		 
				.getForObject("http://services.groupkt.com/country/get/iso2code/IN", Map.class);
				
				*/
		log.info("==== RESTful API Response using Spring RESTTemplate START =======");
		log.info(response.toString());
		log.info("==== RESTful API Response using Spring RESTTemplate END =======");

	}

}
