/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Lease;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    public List<Lease> findByAccount(int idAccount) {
        String hql = "FROM Lease where account = " + idAccount;
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

    @Override
    public List<Lease> findByPlacementAccount(int idAccount) {
        String hql = "FROM Lease l where l.placement.account = " + idAccount;
        System.out.println(hql);
	List<Lease> resultList =  entityManager.createQuery(hql,Lease.class).getResultList();
        return resultList;
    }

    @Override
    public boolean delete(Lease lease) {
        entityManager.remove(lease);
        return true;
    }

    @Override
    public  boolean activate(Lease lease) {
        Lease result = entityManager.find(Lease.class, lease.getIdLease());
        if(result.getCodeActivate().equals(lease.getCodeActivate())){
           result.setActive(true);
           entityManager.merge(result);
           return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Lease findByIdAccountId(int idAccount, int id) {
        String hql = "FROM Lease l where l.account = " + idAccount + " and idLease = " + id;
        System.out.println(hql);
        try{
            Lease result =  entityManager.createQuery(hql,Lease.class).getSingleResult();
            return result;
        }
        catch (NoResultException ex){
            return null;
        }
        
    }

}
