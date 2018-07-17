/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Landlords;

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
public class LandlordsDaoImpl implements LandlordsDao{

    @PersistenceContext	
    private EntityManager entityManager;	
	
    @Override
    public Landlords findByid(Long id) {
	return entityManager.find(Landlords.class, id);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Landlords> findAll() {
	String hql = "FROM landlords";
        System.out.println(hql);
	List<Landlords> resultList =  entityManager.createQuery(hql,Landlords.class).getResultList();
	return resultList;
    }    

    @Override
    public List<Landlords> findAllWithDetail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Landlords save(Landlords landlord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Landlords landlord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
