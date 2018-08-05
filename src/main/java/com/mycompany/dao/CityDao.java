/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.City;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface CityDao {
    City findById(int id);
    List<City> findAll();
    List<City> findByName(String name);
    City save(City city);
    City remove(City city);
}
