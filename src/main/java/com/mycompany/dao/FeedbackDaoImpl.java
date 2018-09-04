/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Feedback;
import com.mycompany.resurse.Lease;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */

@Transactional
@Repository
public class FeedbackDaoImpl implements FeedbackDao{

    @PersistenceContext	
    private EntityManager entityManager;
    @Override
    public List<Feedback> findByAccount(Integer idAccount) {
        String hql = "FROM Feedback f where f.leases.account = :acc";
        Query query = (Query) entityManager.createQuery(hql,Feedback.class);
        query.setParameter("acc", idAccount); 
	List<Feedback> result =  query.getResultList();
	return result;
    }
    
    

    @Override
    public Feedback save(Feedback feedback) {
        if(feedback.getIdFeedback() == null){
           Lease lease = entityManager.find(Lease.class, feedback.getLease().getIdLease());
           feedback.setLease(lease);
           entityManager.persist(feedback);
        }
        else{
            Feedback updateFeedback = entityManager.find(Feedback.class,feedback.getIdFeedback());
            if(updateFeedback.getRating() == feedback.getRating()) updateFeedback.setRating(feedback.getRating());
            if(updateFeedback.getText().equals(feedback.getText())) updateFeedback.setText(feedback.getText());
            entityManager.merge(updateFeedback);
        }
        return feedback;
    }

    @Override
    public List<Feedback> findAll(int id) {
        String hql = "FROM Feedback f where f.lease.placement.idPlacement = :placement";
        Query query = (Query) entityManager.createQuery(hql,Feedback.class);
        query.setParameter("placement", id); 
	List<Feedback> result =  query.getResultList();
	return result;
    }

    @Override
    public float findRating(int id) {
        String hql = "FROM Feedback f where f.lease.placement.idPlacement = 3";
        Query query = (Query) entityManager.createQuery(hql,Feedback.class);
        //query.setParameter("placement", id); 
	List<Feedback> result =  query.getResultList();
        int sum = 0;
        for(Feedback feedback:result){
            sum += feedback.getRating();
        }
	return sum/result.size();
    }

    @Override
    public List<Feedback> findByPlacement(Integer idPlacment) {
         String hql = "FROM Feedback f where f.leases.placement = :plac";
        Query query = (Query) entityManager.createQuery(hql,Feedback.class);
        query.setParameter("plac", idPlacment); 
	List<Feedback> result =  query.getResultList();
	return result;
    }
    
}
