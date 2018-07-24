/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Authority;
import com.mycompany.resurse.City;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface CityService {
    City findById(int id);
    List<City> findAll();
    City save(City city);
    City remove(City city);
}
