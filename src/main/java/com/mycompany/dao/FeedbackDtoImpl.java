/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Feedback;
import com.mycompany.resurse.Tenant;
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
public class FeedbackDtoImpl implements FeedbackDao{

    @PersistenceContext	
    private EntityManager entityManager;
    @Override
    public List<Feedback> findByTenant(Tenant tenant) {
        String hql = "FROM Feedback f where f.leases.tenant = :ten";
        Query query = (Query) entityManager.createQuery(hql,Feedback.class);
        query.setParameter("ten", tenant); 
	List<Feedback> result =  query.getResultList();
	return result;
    }

    @Override
    public Feedback save(Feedback feedback) {
        if(feedback.getIdFeedback() == -1){
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
    
}
