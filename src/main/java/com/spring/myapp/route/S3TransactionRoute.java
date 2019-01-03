package com.spring.myapp.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQSClient;
import com.spring.myapp.processor.TransactionPreProcessor;
import com.spring.myapp.processor.TransactionTypeRouterProcessor;

@Component
public class S3TransactionRoute extends RouteBuilder {

	@Autowired
	private TransactionPreProcessor preprocessor;
	
	@Autowired
	private TransactionTypeRouterProcessor transactionTypeRouterProcessor;
	
	@Value("${aws.sqs.s3TransactionQueueName}")
	private String queue;
	
	@Value("${aws.account.id}")
	private String acctId;
	
	@Autowired
	private AmazonSQSClient sqsClient;
	

	@Override
	public void configure() throws Exception {
		from("aws-sqs://notification_queue?amazonSQSClient=#sqsClient&queueOwnerAWSAccountId=350349760748&region=US_EAST_1&deleteAfterRead=false&maxMessagesPerPoll=10")
		.routeId("S3transactionProcessingRoute")
		.description("S3transactionProcessingRoute")
		.startupOrder(3)
		.autoStartup(true)
		.log(LoggingLevel.INFO, "Camel body: ${body}")
		.process(preprocessor);
	
		
	}

}
