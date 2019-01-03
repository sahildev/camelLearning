package com.spring.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.sqs.AmazonSQSClient;
import com.spring.myapp.aws.Client;


@Configuration
public class CommonConfiguration {
	
	
	@Bean(name = "sqsClient")
	public AmazonSQSClient SQSClientLocal() throws Exception {
		Client client = new Client("############","#################");
		return client.getAmazonSQSClient();
	}
	

	
}
