/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.RegionDao;
import com.mycompany.resurse.City;
import com.mycompany.resurse.Region;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class RegionServiceImpl implements RegionService{

    @Autowired
    RegionDao regionDao;
    
    @Override
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    @Override
    public List<City> getCityByRegion(int idRegion) {
        return regionDao.getCityByRegion(idRegion);
    }
    
}
