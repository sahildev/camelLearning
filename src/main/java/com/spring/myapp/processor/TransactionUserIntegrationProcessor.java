package com.spring.myapp.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.spring.myapp.service.TransactionPreProcessorService;

@Component
public class TransactionUserIntegrationProcessor implements Processor {

	private static final Logger log = LoggerFactory.getLogger(TransactionUserIntegrationProcessor.class);

	@Autowired
	TransactionPreProcessorService preprocessorService;

	@Override
	public void process(Exchange exchange) throws Exception {

		log.debug("In [TransactionUserIntegrationProcessor.process]");

		Map<String,String> inputParamMap= (Map<String, String>) exchange.getIn().getBody();
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, List<Map<String,Object>>> response = (Map<String, List<Map<String, Object>>>) restTemplate
				.getForObject("https://randomuser.me/api", Map.class);
		
		log.debug("In [TransactionUserIntegrationProcessor.process]");
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		resultList = response.get("results");
		
		log.info("In [TransactionUserIntegrationProcessor.process]");
		
		Map<String,Object> randomUserMap = new HashMap<String,Object>();
		
		log.info("In [TransactionUserIntegrationProcessor.process]");
		
		
		log.info("In [TransactionUserIntegrationProcessor.process]");
		randomUserMap = resultList.get(0);
		
		String gender = (String) randomUserMap.get("gender");
		log.info("gender :"  + gender);
		
		inputParamMap.put("gender", gender);
		
	}

}
