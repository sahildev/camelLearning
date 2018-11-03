package com.spring.myapp.route.TransactionTypeRoutes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TransactionTypeRouteOZ extends RouteBuilder {


	@Override
	public void configure() throws Exception {
		from("direct:transactionTypeRouteOZ")
			.routeId("transactionTypeRouteOZ")
			.startupOrder(9)
			.log(LoggingLevel.INFO,"Camel body: ${body}")
			.log(LoggingLevel.INFO,"Successfully finished processing type OZ");
	}

}
