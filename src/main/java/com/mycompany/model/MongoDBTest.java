/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mycompany.config.MongoConfig;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 *
 * @author gurkan0791
 */
public class MongoDBTest {
    
    
    public  List<Marker> getMarker(){
    ApplicationContext ctx = 
             new AnnotationConfigApplicationContext(MongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        
       
        
        DBCollection markerCollection = mongoOperation.getCollection("markers");
        DBCursor result = markerCollection.find();
        
        while (result.hasNext()) {            
            DBObject tobj = result.next();
            //System.out.println(tobj.get("_id"));
            
        }
        
        List<Marker> listUser = mongoOperation.findAll(Marker.class, "markers");
       
        return listUser;
    
    }
    
    //public static void main(String[] args) {
        
       
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        DB database = mongoClient.getDB("local");
//        DBCollection collection = database.getCollection("markers");
//        DBObject firstDocument = collection.findOne();
//        System.out.println(firstDocument);
        
        
//	System.out.println("4. Number of user = " + listUser.size());
    //}
 
    
}
