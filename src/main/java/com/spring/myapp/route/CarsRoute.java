package com.spring.myapp.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.myapp.processor.preProcessor;

@Component
public class CarsRoute extends RouteBuilder {

	@Autowired
	private preProcessor preProcessor;

	@Override
	public void configure() throws Exception {
		from("direct:getCarsRoute")
		.routeId("getCarsRoute")
		.description("getCarsRoute")
		.startupOrder(2)
		.log(LoggingLevel.INFO, "Camel body: ${body}")
		//.process(preProcessor)
		.log(LoggingLevel.INFO, "Successfully finished processing");
	}

}
