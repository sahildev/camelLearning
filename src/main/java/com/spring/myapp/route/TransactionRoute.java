package com.spring.myapp.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.myapp.processor.TransactionPreProcessor;
import com.spring.myapp.processor.TransactionTypeRouterProcessor;

@Component
public class TransactionRoute extends RouteBuilder {

	@Autowired
	private TransactionPreProcessor preprocessor;
	@Autowired
	private TransactionTypeRouterProcessor transactionTypeRouterProcessor;

	@Override
	public void configure() throws Exception {
		from("direct:transactionProcessingRoute")
		.routeId("transactionProcessingRoute")
		.description("transactionProcessingRoute")
		.startupOrder(3)
		.log(LoggingLevel.INFO, "Camel body: ${body}")
		.process(preprocessor)
		.split(body())
		.process(transactionTypeRouterProcessor)
		  .choice()
          .when(header("type").isEqualTo("CT"))
              .to("direct:transactionTypeRouteCT")
          .when(header("type").isEqualTo("LB"))
              .to("direct:transactionTypeRouteLB")
          .when(header("type").isEqualTo("LT"))
              .to("direct:transactionTypeRouteLT")
           .when(header("type").isEqualTo("OZ"))
              .to("direct:transactionTypeRouteOZ")
          .otherwise()
              .to("direct:transactionTypeRouteALL")
		.log(LoggingLevel.INFO, "Successfully finished processing");
	}

}
