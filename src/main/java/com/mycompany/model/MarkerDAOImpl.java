/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mycompany.config.MongoConfig;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author gurkan0791
 */
public class MarkerDAOImpl implements MarkerDAO{

    @Override
    public void saveOrUpdate(Marker marker) {
        DBCollection markerCollection = MongoConfig.getMongoConnection().getCollection("markers");
        BasicDBObject document = new BasicDBObject();
	document.put("lat", marker.getLat());
	document.put("lng", marker.getLng());
        document.put("title", marker.getTitle());
        document.put("icon", marker.getIcon());
        document.put("content", marker.getContent());
        
        if (marker.getId().length() > 0) {
            
            BasicDBObject query = new BasicDBObject();
            query.append("_id",  new ObjectId(marker.getId()));
            markerCollection.update(query, document);
        }else{
        markerCollection.insert(document);
        }
    }

    @Override
    public void delete(String markerId) {
       
        DBCollection markerCollection = MongoConfig.getMongoConnection().getCollection("markers");
        BasicDBObject query = new BasicDBObject();
        query.append("_id", new ObjectId(markerId));
        markerCollection.remove(query);
        
    }

    @Override
    public List<Marker> markerListAll() {

        List<Marker> listUser=MongoConfig.getMongoConnection().findAll(Marker.class, "markers");
        return listUser;
    }
    
}
