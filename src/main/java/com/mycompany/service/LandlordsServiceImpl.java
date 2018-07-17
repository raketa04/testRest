/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.LandlordsDao;
import com.mycompany.resurse.Landlords;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */

@Service
public class LandlordsServiceImpl implements LandlordsService{
    @Autowired
    LandlordsDao landlordsDao;
    @Override
    public List<Landlords> findAll() {
        return  landlordsDao.findAll();
    }

    @Override
    public List<Landlords> findAllWithDetail() {
       return  landlordsDao.findAllWithDetail();
    }

    @Override
    public Landlords findByid(Long id) {
        return  landlordsDao.findByid(id);
    }

    @Override
    public boolean save(Landlords landlord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Landlords landlord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
