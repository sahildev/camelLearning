package com.spring.myapp.processor;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		
	}

}
