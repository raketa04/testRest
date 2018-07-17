/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Landlords;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface LandlordsDao {
    List<Landlords> findAll();
    List<Landlords> findAllWithDetail();
    Landlords findByid(Long id);
    Landlords save(Landlords landlord);
    void delete(Landlords landlord);
}
