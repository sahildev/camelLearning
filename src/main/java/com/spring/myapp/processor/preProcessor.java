package com.spring.myapp.processor;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class preProcessor implements Processor {
	
	private static final Logger log = LoggerFactory.getLogger(preProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		

		log.info("STARTED PROCESSING MESSAGE : {} AT TIME: {}", exchange.getExchangeId(), new Date().toString());

		Object messageBody = exchange.getIn().getBody();
		if (messageBody == null) {

			log.warn("Message body is null , unexpected condition . Nothing to do.");

			// + throw Exception
		}
		
		log.info("Message Body :"+ (String) messageBody);
		 
	}

}
