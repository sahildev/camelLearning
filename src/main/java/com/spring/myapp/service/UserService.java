package com.spring.myapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	public Map<String, Object> getRandomUser() {

		Map<String, String> inputDataObjectMap = null;

		RestTemplate restTemplate = new RestTemplate();
		Map<String, List<Map<String, Object>>> response = (Map<String, List<Map<String, Object>>>) restTemplate
				.getForObject("https://randomuser.me/api", Map.class);

		List<Map<String, Object>> userResultList = new ArrayList<Map<String, Object>>();
		userResultList = response.get("results");

		Map<String, Object> randomUserMap = new HashMap<String, Object>();
		randomUserMap = userResultList.get(0);


		return randomUserMap;

	}

}
