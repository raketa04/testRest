/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.City;
import com.mycompany.resurse.Placement;
import com.mycompany.resurse.Region;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface RegionDao {
    List<Region> findAll();
    List<City> getCityByRegion(int idRegion);
}
