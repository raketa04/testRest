/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Comforts;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ComfortsDao {
    Comforts findById(int id);
    List<Comforts> findAll();
}
