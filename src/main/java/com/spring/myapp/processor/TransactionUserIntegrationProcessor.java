package com.spring.myapp.processor;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.myapp.aws.SqsQueue;
import com.spring.myapp.service.TransactionPreProcessorService;
import com.spring.myapp.service.UserService;

@Component
public class TransactionUserIntegrationProcessor implements Processor {

	private static final Logger log = LoggerFactory.getLogger(TransactionUserIntegrationProcessor.class);

	@Autowired
	TransactionPreProcessorService preprocessorService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SqsQueue sqsQueue;


	@Override
	public void process(Exchange exchange) throws Exception {

		log.info("In [TransactionUserIntegrationProcessor.process]");

		Map<String,String> inputParamMap= (Map<String, String>) exchange.getIn().getBody();
		Map<String,Object> userDataMap = userService.getRandomUser();
		
		userDataMap.put("transactionMap", inputParamMap);
		
		//log.info("Transaction DataSet : " + userDataMap);
		String userDataString = userDataMap.toString();
		
		//sqsQueue.putMessage(userDataString);
		
		
		
	}

}
