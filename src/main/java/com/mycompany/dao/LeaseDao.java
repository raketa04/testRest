/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Lease;
import com.mycompany.resurse.Placement;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface LeaseDao {
    List<Lease> findAll();
    Lease findByid(int id);
    List<Lease> findByAccount(int idAccount);
    List<Lease> findByPlacment(int idPlacement);
    Lease add(Lease lease);
}
