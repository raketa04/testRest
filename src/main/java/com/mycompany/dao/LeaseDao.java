/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Lease;
import com.mycompany.resurse.Tenant;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface LeaseDao {
    List<Lease> findAll();
    Lease findByid(int id);
    Lease findByTenant(Tenant tenant);
    Tenant save(Lease lease);
    void delete(Lease lease);
}
