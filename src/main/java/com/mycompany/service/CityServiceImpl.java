/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.CityDao;
import com.mycompany.resurse.City;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    CityDao cityDao;
        
    @Override
    public City findById(int id) {
        return cityDao.findById(id);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public City save(City city) {
        return cityDao.save(city);
    }

    @Override
    public City remove(City city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<City> findByName(String name) {
        return cityDao.findByName(name);
    }
    
}
