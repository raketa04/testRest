/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.ComfortsDao;
import com.mycompany.resurse.Comforts;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ComfortsServiceImpl implements ComfortsService{

    @Autowired
    ComfortsDao comfortsDao;
    @Override
    public Comforts findById(int id) {
        return comfortsDao.findById(id);
    }

    @Override
    public List<Comforts> findAll() {
        return comfortsDao.findAll();
    }
    
}
