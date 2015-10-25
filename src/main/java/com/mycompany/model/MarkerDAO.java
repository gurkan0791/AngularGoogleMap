/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.util.List;

/**
 *
 * @author gurkan0791
 */
public interface MarkerDAO {
    
    
    public void saveOrUpdate(Marker marker);
    public void delete(String markerId);
    public List<Marker> markerListAll();
    
}
