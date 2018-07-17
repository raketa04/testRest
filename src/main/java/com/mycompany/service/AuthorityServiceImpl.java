/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.AuthorityDao;
import com.mycompany.resurse.Authority;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class AuthorityServiceImpl implements AuthorityService{
    
    @Autowired
    AuthorityDao authorityDao;
    
    @Override
    public List<Authority> findAll() {
        return authorityDao.findAll();
    }
    
}
