package com.spring.myapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.sqs.AmazonSQSClient;
import com.spring.myapp.aws.Client;


@Configuration
public class CommonConfiguration {
	
	
	@Value("${aws.iam.accessKey}")
	private String accessKey;
	
	@Value("${aws.iam.secretKey}")
	private String secretKey;
	
	@Bean(name = "sqsClient")
	public AmazonSQSClient SQSClientLocal() throws Exception {
		Client client = new Client(accessKey, secretKey);
		return client.getAmazonSQSClient();
	}
	

	
}
