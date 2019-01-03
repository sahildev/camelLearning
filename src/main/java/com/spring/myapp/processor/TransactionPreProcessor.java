package com.spring.myapp.processor;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.myapp.service.TransactionPreProcessorService;

@Component
public class TransactionPreProcessor implements Processor {

	private static final Logger log = LoggerFactory.getLogger(TransactionPreProcessor.class);

	@Autowired
	TransactionPreProcessorService preprocessorService;

	@Override
	public void process(Exchange exchange) throws Exception {

		log.debug("In [Preprocessor.process]");

		// Not Needed for now will be required when we trigger process on
		// notification..
		//

		log.info("STARTED PROCESSING MESSAGE : {} AT TIME: {}", exchange.getExchangeId(), new Date().toString());

		Object messageBody = exchange.getIn().getBody();
		if (messageBody == null) {

			log.warn("Message body is null , unexpected condition . Nothing to do.");

			// + throw Exception
		}
		//log.info("Message Body :" + (String) messageBody);
		Map<String, String> messageMap = (Map<String, String>) messageBody;

		//List<Map<String, String>> inputRequestList = preprocessorService.processInputFile(messageMap);
		
		//exchange.setProperty("type", inputRequestList.get(ApplicationConstants.TRANSACTION_PRODUCTMEASURE));
		//exchange.getIn().setBody(inputRequestList);
	}

}
