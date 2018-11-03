package com.spring.myapp.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class CarController {

	@Autowired
	CamelContext camelContext;

	@Autowired
	ProducerTemplate producerTemplate;

	@RequestMapping(value = "/getCars/")
	public void startCamel() {

		producerTemplate.sendBody("direct:csvParseRoute");
	}
}
