package com.spring.myapp.route.TransactionTypeRoutes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TransactionTypeRouteLB extends RouteBuilder {


	@Override
	public void configure() throws Exception {
		from("direct:transactionTypeRouteLB")
			.routeId("transactionTypeRouteLB")
			.startupOrder(6)
			.log(LoggingLevel.INFO,"Camel body: ${body}")
			.log(LoggingLevel.INFO,"Successfully finished processing type LB");
	}

}
