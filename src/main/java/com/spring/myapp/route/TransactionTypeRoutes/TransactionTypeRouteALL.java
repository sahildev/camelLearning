package com.spring.myapp.route.TransactionTypeRoutes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TransactionTypeRouteALL extends RouteBuilder {


	@Override
	public void configure() throws Exception {
		from("direct:transactionTypeRouteALL")
			.routeId("transactionTypeRouteALL")
			.startupOrder(7)
			//.log(LoggingLevel.INFO,"Camel body: ${body}")
			.log(LoggingLevel.DEBUG,"Successfully finished processing all others");
	}

}
