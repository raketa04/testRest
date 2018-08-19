/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Lease;
import com.mycompany.resurse.Placement;
import com.mycompany.resurse.Tenant;
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
public class LeaseDaoImpl implements LeaseDao{

    @PersistenceContext	
    private EntityManager entityManager;
    @Override
    public List<Lease> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lease findByid(int id) {
        return entityManager.find(Lease.class, id);
    }

    @Override
    public List<Lease> findByTenant(int idTenant) {
        String hql = "FROM Lease where tenant = " + idTenant;
        System.out.println(hql);
	List<Lease> resultList =  entityManager.createQuery(hql,Lease.class).getResultList();
        return resultList;
    }

    @Override
    public List<Lease> findByPlacment(int idPlacement) {
        String hql = "FROM Lease where placement = " + idPlacement;
        System.out.println(hql);
	List<Lease> resultList =  entityManager.createQuery(hql,Lease.class).getResultList();
        return resultList;
    }

    @Override
    public Lease add(Lease lease) {
        entityManager.persist(lease);
        entityManager.flush();
        entityManager.clear();
        return entityManager.find(Lease.class, lease.getIdLease()) ;
    }
    
}
