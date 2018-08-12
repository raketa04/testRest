/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.LeaseDao;
import com.mycompany.resurse.Lease;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class LeaseServiceImpl implements LeaseService{

    @Autowired
    LeaseDao leaseDao;
    @Override
    public List<Lease> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lease findByid(int id) {
        return leaseDao.findByid(id);
    }

    @Override
    public List<Lease> findByTenant(int idTenant) {
        return leaseDao.findByTenant(idTenant);
    }

    @Override
    public List<Lease> findByPlacment(int idPlacement) {
        return leaseDao.findByPlacment(idPlacement);
    }

    @Override
    public Lease add(Lease lease) {
        return leaseDao.add(lease);
    }
    
}
