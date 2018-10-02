/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Pictuteres;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface PictuteresDao {
    List<Pictuteres> findByPlacement(Integer id);
    Pictuteres findById(Integer id);
    Pictuteres add(Pictuteres pic);
    boolean delete(Pictuteres pic);
}
