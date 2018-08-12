/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Feedback;
import com.mycompany.resurse.Tenant;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface  FeedbackDao {
    List <Feedback> findByTenant(Tenant tenant);
    Feedback save(Feedback feedback); 
}
