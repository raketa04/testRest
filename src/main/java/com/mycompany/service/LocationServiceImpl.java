/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.mycompany.dao.CityDao;
import com.mycompany.resurse.Location;
import com.mycompany.resurse.Placement;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class LocationServiceImpl implements LocationService{

    Location location = null;
    
    @Autowired
    CityDao cityDao;
    @Override
    public Location addLocation(Placement placement) {
        try {
            String adress = placement.getCity().getNameCity() + " " + placement.getStreet() + " д." +
                    placement.getHousing() + " " + placement.getHouse();
            
            GeoApiContext context = new GeoApiContext.Builder()
                    .apiKey("AIzaSyD44m9V4ePkQXZKrSXKtAGsBrpEcDyQiyc")
                    .build();
            GeocodingResult[] results =  GeocodingApi.geocode(context,adress).await();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(results[0].geometry.location));
            location.setLat(results[0].geometry.location.lat);
            location.setLng(results[0].geometry.location.lng);
        } catch (ApiException ex) {
            Logger.getLogger(LocationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(LocationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LocationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return location;
        }
    }
    
}
