/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;


import com.mycompany.dao.CityDao;
import com.mycompany.resurse.City;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.mycompany.resurse.Location;
import com.mycompany.resurse.Placement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
//        
//        try {
//            String url = "http://maps.google.com/maps/api/geocode/json?address=";
//            url += cityDao.findById(placement.getCity().getIdCity()).getNameCity();
//            url += " " + placement.getStreet();
//            url += " " + placement.getHouse();
//            URL obj = new URL(url);
//            HttpRequest<String> httpRequest = HttpRequestBuilder.createGet(uri, String.class)
//                .responseDeserializer(ResponseDeserializer.ignorableDeserializer()).build();
//            String input = response.toString();
//            JSONObject jsonObj = new JSONObject(input);
//            double lat = (double) jsonObj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lat");
//            double lng = (double) jsonObj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lng");
//            location.setLat(lat);
//            location.setLng(lng);
//            
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(LocationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(LocationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (JSONException ex) {
//            Logger.getLogger(LocationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return location;
    }
    
}
