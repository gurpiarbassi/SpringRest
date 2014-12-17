package com.gurps.library;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Component
@EnableConfigurationProperties
@EnableMongoRepositories(basePackages = "com.gurps.library.repository")
@ConfigurationProperties(prefix = "environments.dev.database")
public class MongoConnectionConfig /* extends AbstractMongoConfiguration */{

	private String ip;
	private String name;
	private int port;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public @Bean MongoFactoryBean mongo() {
		MongoFactoryBean mongo = new MongoFactoryBean();
		mongo.setHost(getIp());

		return mongo;
	}*/

	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(getIp(), getPort()), getName());
	}

}
