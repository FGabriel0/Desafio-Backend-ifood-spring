package com.example.Desafio_BackEnd_Ifood.config.mongoDB;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class mongoDBConfig {
	
	@Bean
	public MongoDatabaseFactory mongoConfigure() {
		return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/product-catalog");
	}
	
	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoConfigure());
	}
}
