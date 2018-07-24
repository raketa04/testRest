/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.City;
import com.mycompany.resurse.Region;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface RegionService {
    List<Region> findAll();
    List<City> getCityByRegion(int idRegion);
}
