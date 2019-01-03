package com.spring.myapp.aws;


import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.sqs.AmazonSQSClient;

public class Client {

	//private static Logger logger = Logger.getLogger(Client.class);

	AWSCredentialsProvider credentials;

	private String accessKey;

	private String secretKey;

	public AWSCredentialsProvider basicAWSCredentials() throws Exception {
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		return new AWSStaticCredentialsProvider(credentials);
	}

	public Client(String accessKey, String secretKey) throws Exception {

//		logger.info("Creating CLIENT bean for development Environment !");
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		credentials = basicAWSCredentials();

	}
	

	public AmazonSQSClient getAmazonSQSClient() throws Exception {
		
		return new AmazonSQSClient(credentials);
	}
	
	private ClientConfiguration getClientConfiguration(){
		ClientConfiguration config = new ClientConfiguration();
		return config;
	}
/*
	public AmazonS3Client getAmazonS3client() throws Exception {
		
		return new AmazonS3Client(credentials);
	}
	
	*/
}
