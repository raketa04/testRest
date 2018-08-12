/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.FeedbackDao;
import com.mycompany.resurse.Feedback;
import com.mycompany.resurse.Placement;
import com.mycompany.resurse.Tenant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    FeedbackDao feedbackDao;
    @Override
    public List<Feedback> findByTenant(Integer idTenant) {
        return feedbackDao.findByTenant(idTenant);
    }

    @Override
    public List<Feedback> findAll(int id) {
        return feedbackDao.findAll(id);
    }

    @Override
    public float findRating(int id) {
        return feedbackDao.findRating(id);
    }

    @Override
    public Feedback save(Feedback feedback) {
        return feedbackDao.save(feedback);
    }

    @Override
    public List<Feedback> findByPlacement(Integer idPlacment) {
        return feedbackDao.findByPlacement(idPlacment);
    }
    
}
