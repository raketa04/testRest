/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Notification;
import com.mycompany.resurse.Placement;
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

public class NotificationDaoImpl implements NotificationDao{

    @PersistenceContext	
    private EntityManager entityManager;
    
    @Override
    public void addNotification(Notification notification) {
        entityManager.persist(notification);
    }

    @Override
    public List<Notification> getNotification(Integer id) {
        String hql = "FROM Notification WHERE account = '" + id +"' and isSend = false";
	List <Notification> result =  entityManager.createQuery(hql,Notification.class).getResultList();
        return result;
    }

    @Override
    public void deactivateNotification(List<Integer> id) {
        String hql1 = "Update Notification Set isSend = true Where account in (:ids)";
        Query query1 = (Query) entityManager.createQuery(hql1,Notification.class); 
        query1.setParameterList("ids", id);
    }
    
}
