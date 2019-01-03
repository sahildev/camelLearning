package com.spring.myapp.aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;

@Component("sqsQueue")
public class SqsQueue {
	
	@Autowired
	private AmazonSQSClient amazonSQSClient;
	
	public void deleteMessage(String queueUrl, String messageRecieptHandle){
		//Logger.info("deleting SQS queue message" + messageRecieptHandle +" from queue " + queueUrl);
		DeleteMessageRequest deleteMessageRequest = new DeleteMessageRequest(queueUrl,messageRecieptHandle);
		amazonSQSClient.deleteMessage(deleteMessageRequest);
	}

}
