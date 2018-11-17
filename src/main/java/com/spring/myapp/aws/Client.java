package com.spring.myapp.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSClient;

public class Client {

	AWSCredentialsProvider credentials;
	private String accessKey;
	private String secretKey;

	public AWSCredentialsProvider basicAWSCredentials() throws Exception {
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		return new AWSStaticCredentialsProvider(credentials);
	}

	public Client(String accessKey, String secretKey) throws Exception {
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		credentials = basicAWSCredentials();

	}

	public AmazonSQSClient getAmazonSQSClient() throws Exception {

		return new AmazonSQSClient(credentials);
	}

}
