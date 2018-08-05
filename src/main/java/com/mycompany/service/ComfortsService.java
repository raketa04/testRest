/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Comforts;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ComfortsService {
    Comforts findById(int id);
    List<Comforts> findAll();
}
