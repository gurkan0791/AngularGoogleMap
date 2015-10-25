/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.model.Marker;
import com.mycompany.model.MarkerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author gurkan0791
 */

@Controller
public class DatabaseController {
    
    @Autowired
    private MarkerDAO markerDAO;
    
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String index(@ModelAttribute Marker marker,ModelMap map) {
        //MongoDBTest  mongoDBTest = new MongoDBTest();
        
        map.put("msg", "Hello Spring 4 Web MVC!");
        map.put("mark", markerDAO.markerListAll());
        //map.put("mark", mongoDBTest.getMarker());
        return "index";
    }
    @RequestMapping(value = "/insert" , method = RequestMethod.GET) 
    public String insert(@ModelAttribute Marker marker){
        
       markerDAO.saveOrUpdate(marker);
        
        
//        System.out.println("Marker Bilgi : "+marker.getTitle()+"\n"+marker.getContent()+"\n"+marker.getIcon()
//        +"\n"+marker.getId()+"\n"+marker.getLat()+"\n"+marker.getLng());
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET, params = {"id"})
    public String delete(@RequestParam("id") String id){
        
        //System.out.println("Delete id :"+ id);
        markerDAO.delete(id);
        return "redirect:/";
    }
    
}
