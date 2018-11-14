package com.spring.myapp.route.TransactionTypeRoutes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.myapp.processor.TransactionUserIntegrationProcessor;

@Component
public class TransactionTypeRouteCT extends RouteBuilder {
	
	@Autowired
	TransactionUserIntegrationProcessor transactionUserIntegrationProcessor;


	@Override
	public void configure() throws Exception {
		from("direct:transactionTypeRouteCT")
			.routeId("transactionTypeRouteCT")
			.startupOrder(5)
			.log(LoggingLevel.DEBUG,"Camel body: ${body}")
			.process(transactionUserIntegrationProcessor)
			.log(LoggingLevel.INFO,"Camel body: ${body}")
			.log(LoggingLevel.DEBUG,"Successfully finished processing type CT");
	}

}
