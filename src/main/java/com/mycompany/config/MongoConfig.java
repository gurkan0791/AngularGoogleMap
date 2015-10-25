/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.config;

import com.mongodb.MongoClient;
import com.mycompany.model.MarkerDAO;
import com.mycompany.model.MarkerDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 *
 * @author gurkan0791
 */
@Configuration
public class MongoConfig {
    
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "local");
    }
    
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {		
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;		
    }
    
    @Bean
    public MarkerDAO getContactDAO() {
        return new MarkerDAOImpl();
    }

    public static MongoOperations getMongoConnection(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        return mongoOperation;
    }
    
}
