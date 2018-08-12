/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Feedback;
import com.mycompany.resurse.Placement;
import com.mycompany.resurse.Tenant;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface FeedbackService {
    List <Feedback> findByTenant(Integer idTentant);
    List <Feedback> findAll(int id);
    List <Feedback> findByPlacement(Integer idPlacment);
    float findRating(int id);
    Feedback save(Feedback feedback); 
}
