/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Account;
import com.mycompany.resurse.Authority;
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
public class AuthorityDaoImpl implements AuthorityDao{

    @PersistenceContext	
    private EntityManager entityManager;
    @Override
    @Transactional(readOnly=true)
    public List<Authority> findAll() {
        String hql = "from Authority";
        System.out.println(hql);
	List<Authority> resultList =  (List<Authority>) entityManager.createQuery(hql).getResultList();
	return resultList;
    }

    @Override
    public boolean save(Authority authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Authority authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
