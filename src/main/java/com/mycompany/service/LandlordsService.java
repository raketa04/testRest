/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Landlords;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface  LandlordsService {
    List<Landlords> findAll();
    List<Landlords> findAllWithDetail();
    Landlords findByid(int id);
    Landlords findByIdAccount(int idAccount);
    boolean save(Landlords landlord);
    boolean delete(Landlords landlord);
}
