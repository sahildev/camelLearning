package com.spring.myapp.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.myapp.processor.TransactionTypeRouterProcessor;

@Component
public class CsvParseRoute extends RouteBuilder {
	
	@Autowired
	private TransactionTypeRouterProcessor preProcessor;

	@Override
	public void configure() throws Exception {
		from("direct:csvParseRoute")
			.routeId("csvParseRoute")
			.description("abc")
			.startupOrder(1)
			.log(LoggingLevel.INFO,"Camel body: ${body}")
			.process(preProcessor)
			.log(LoggingLevel.INFO,"Successfully finished processing");
	}

}
