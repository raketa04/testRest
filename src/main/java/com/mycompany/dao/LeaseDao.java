/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Lease;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface LeaseDao {
    List<Lease> findAll();
    Lease findByid(int id);
    Lease findByIdAccountId(int idAccount, int id);
    List<Lease> findByAccount(int idAccount);
    List<Lease> findByPlacment(int idPlacement);
    List<Lease> findByPlacementAccount(int idAccount);
    Lease add(Lease lease);
    boolean delete(Lease lease);
    boolean activate(Lease lease);   
}
