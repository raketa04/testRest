/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Lease;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface LeaseService {
    List<Lease> findAll();
    Lease findByid(int id);
    List<Lease> findByTenant(int idTenant);
    List<Lease> findByPlacment(int idPlacement);
    Lease add(Lease lease);
}
