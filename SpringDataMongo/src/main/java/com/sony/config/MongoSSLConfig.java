/**
 * 
 *//*
package com.sony.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

*//**
 * @author SThangavelu
 *
 *//*
@Configuration
public class MongoSSLConfig extends AbstractMongoConfiguration {

	 (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongoClient()
	 
	@Override
	public MongoClient mongoClient() {
		MongoClientOptions.Builder builder = MongoClientOptions.builder();
		   MongoClientOptions options = builder.sslEnabled(true).build();
		   return new MongoClient("cluster0-oaji1.mongodb.net",options);
	}

	 (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.MongoConfigurationSupport#getDatabaseName()
	 
	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "test";
	}

}
*/