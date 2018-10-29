package com.spring.myapp.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.myapp.processor.TransactionTypeRouterProcessor;

@Component
public class TransactionRoute extends RouteBuilder {

	@Autowired
	private TransactionTypeRouterProcessor transactionTypeRouterprocessor;

	@Override
	public void configure() throws Exception {
		from("direct:transactionProcessingRoute")
		.routeId("transactionProcessingRoute")
		.description("transactionProcessingRoute")
		.startupOrder(3)
		.log(LoggingLevel.INFO, "Camel body: ${body}")
		.process(transactionTypeRouterprocessor)
		.log(LoggingLevel.INFO, "Successfully finished processing");
	}

}
