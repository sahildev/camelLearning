package com.spring.myapp.aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQSClient;



@Component("sqsQueue")
public class SqsQueue {
	
	@Value("${amazon.sqs.queue.url}")
	private String queueUrl;
	
	
	@Autowired
	private AmazonSQSClient amazonSQSClient;
	
	public void putMessage(String messageBody){
		
		amazonSQSClient.sendMessage(queueUrl, messageBody);
		
	}

}
