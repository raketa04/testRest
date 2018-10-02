/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Feedback;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface  FeedbackDao {
    List <Feedback> findByAccount(Integer idAccount);
    List <Feedback> findByPlacement(Integer idPlacment);
    List <Feedback> findAll(int id);
    float findRating(int id);
    Feedback save(Feedback feedback);
    Feedback getFeedback(Integer idFeedback);
}
