/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.repository.CliningCompanyRepository;
import com.mycompany.resurse.CliningCompany;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class CliningCompanyServiceImpl implements  CliningCompanyService{

    @Autowired
    CliningCompanyRepository companyRepository;
    
    @Override
    public CliningCompany findByAccount(String userName) {
        return companyRepository.findByEmail(userName);
    }

    @Override
    public CliningCompany findById(Integer id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public List<CliningCompany> findAll() {
        List<CliningCompany> result = (List<CliningCompany>) companyRepository.findAll();
        return result;
    }

    @Override
    public CliningCompany save(CliningCompany account) {
        return  companyRepository.save(account);
    }

    @Override
    public CliningCompany delete(CliningCompany account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
