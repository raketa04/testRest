/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Comforts;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */

@Transactional
@Repository
public class ComfortsDaoImpl implements ComfortsDao{
    
    @PersistenceContext	
    private EntityManager entityManager;
    
    @Override
    public Comforts findById(int id) {
        return entityManager.find(Comforts.class, id);
    }

    @Override
    public List<Comforts> findAll() {
        String hql = "FROM Comforts";
        System.out.println(hql);
	List<Comforts> resultList =  entityManager.createQuery(hql,Comforts.class).getResultList();
	return resultList;
    }
    
}
