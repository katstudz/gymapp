package com.gym.exercisesset.configuration;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongo() {
        String client_url = "mongodb://" + "root" + ":" + "root" + "@" +
                "localhost" + ":" + "27017" + "/" + "some-" +
                "mongo";
        MongoClientURI uri = new MongoClientURI(client_url);


        return new MongoClient(uri);


    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "test");
    }
}
