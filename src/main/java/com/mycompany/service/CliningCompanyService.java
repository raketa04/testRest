/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.CliningCompany;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface CliningCompanyService {
    CliningCompany findByAccount(String userName);
    CliningCompany findById(Integer id);
    List<CliningCompany> findAll();
    CliningCompany save(CliningCompany account);
    CliningCompany delete(CliningCompany account);
}
