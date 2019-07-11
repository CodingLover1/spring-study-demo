package com.ws.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongodbConfig {

    @Bean
    public MongoDbFactory userMongoDbFactory(@Value("${user.mongodb.host}") String host,
                                             @Value("${user.mongodb.port}") int port,
                                             @Value("${user.mongodb.database}")String database){

        return new SimpleMongoDbFactory(new MongoClient(host,port),database);
    }

    @Bean
    @Qualifier("userMongoTemplate")
    public MongoTemplate userMongoTemplate(MongoDbFactory mongoDbFactory){
        return new MongoTemplate(mongoDbFactory);
    }
}
