/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.ServerSpringApplication;
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
    public List<Lease> findByAccount(int idAccount) {
        return leaseDao.findByAccount(idAccount);
    }

    @Override
    public List<Lease> findByPlacment(int idPlacement) {
        return leaseDao.findByPlacment(idPlacement);
    }

    @Override
    public Lease add(Lease lease) {
        lease.setCodeActivate("1111");
        return leaseDao.add(lease);
    }

    @Override
    public List<Lease> findByPlacementAccount(int idAccount) {
        return leaseDao.findByPlacementAccount(idAccount);
    }

    @Override
    public boolean delete(Lease lease) {
       return leaseDao.delete(lease);
    }
    
    @Override
    public boolean addCacheLease(Lease lease) {
        ServerSpringApplication.cacheLease.put(lease.getIdLease(), lease);
        return true;
    }

    @Override
    public boolean deleteCacheLease(Integer idLease) {
        ServerSpringApplication.cacheLease.asMap().remove(idLease);
        return true;
    }

    @Override
    public String activate(Lease lease) {
        return leaseDao.activate(lease);
    }
    
}
