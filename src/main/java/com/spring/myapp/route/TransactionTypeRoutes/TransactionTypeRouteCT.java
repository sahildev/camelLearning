package com.spring.myapp.route.TransactionTypeRoutes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TransactionTypeRouteCT extends RouteBuilder {


	@Override
	public void configure() throws Exception {
		from("direct:transactionTypeRouteCT")
			.routeId("transactionTypeRouteCT")
			.startupOrder(5)
			.log(LoggingLevel.DEBUG,"Camel body: ${body}")
			.log(LoggingLevel.DEBUG,"Successfully finished processing type CT");
	}

}
