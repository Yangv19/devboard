package com.vincentdevboard.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import static com.vincentdevboard.app.auth.Constants.DB_SOURCE;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoDBConfig {
	
	@Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://root:dbUserPassword123@" + DB_SOURCE + ":27017/devboard?authSource=admin");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
          .applyConnectionString(connectionString)
          .build();
        
        return MongoClients.create(mongoClientSettings);
    }
	
	@Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "devboard");
    }
}
