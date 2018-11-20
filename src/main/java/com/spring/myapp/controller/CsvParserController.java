package com.spring.myapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvParserController {
	
	@Autowired
	CamelContext camelContext;
	
	@Autowired
	ProducerTemplate producerTemplate;
	
	@RequestMapping(value = "/csv/")
	public void startCamel() {
		
		Map<String,String> TriggerPathMap = new HashMap();
		TriggerPathMap.put("path", "Triggered csv parser");
		producerTemplate.sendBody("direct:csvParseRoute", TriggerPathMap);
	}
}
