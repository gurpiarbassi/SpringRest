package com.gurps.library.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Component
@EnableConfigurationProperties
@EnableMongoRepositories(basePackages = "com.gurps.library.domain")
@ConfigurationProperties(prefix="environments.dev.database")
public class MongoConnectionConfig extends AbstractMongoConfiguration {

	private String ip;
	private String name;
	
	public MongoConnectionConfig(){
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getIp(){
		return this.ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected String getDatabaseName() {
		return getName();
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(getIp());
	}
	
	
	
}
