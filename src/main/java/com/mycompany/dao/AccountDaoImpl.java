/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

/**
 *
 * @author ADMIN
 */

import com.mycompany.resurse.Account;
import com.mycompany.resurse.Authority;
import java.util.List;
import java.util.Random;
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

public class AccountDaoImpl implements AccountDao{

    @PersistenceContext	
    private EntityManager entityManager;
    
    @Override
    public Account findByAccount(String userName) {
        String hql = "FROM Account WHERE email = '" + userName +"'";
	List <Account> result =  entityManager.createQuery(hql,Account.class).getResultList();
	return result.get(0);
    }

    @Override
    public boolean emailIsUsed(String userName) {
        String hql = "FROM Account WHERE email = '" + userName +"'";
	List <Account> result =  entityManager.createQuery(hql,Account.class).getResultList();
	if(result.isEmpty()) return false;
        else return true;
    }
    
    @Override
    public Account save(Account account) {
        if(account.getIdAccount() ==  null){
            Random ran = new Random();
            //account.setCodeActivate(Integer.toString(ran.nextInt(10))+ Integer.toString(ran.nextInt(10))+Integer.toString(ran.nextInt(10))+Integer.toString(ran.nextInt(10)));
            account.setCodeActivate("11111");
            Authority type_role = entityManager.createQuery("FROM Authority WHERE name = '" + account.getType_role().getName() + "'",Authority.class).getSingleResult();
            account.setType_role(type_role);
            entityManager.persist(account);
            return account;
        }
        else{
            Account updateAccount = entityManager.find(Account.class,account.getIdAccount());
            if(!updateAccount.getFIO().equals(account.getFIO())) updateAccount.setFIO(account.getFIO());
            if(!updateAccount.getPhone().equals(account.getPhone())) updateAccount.setPhone(account.getPhone());
            if(!updateAccount.getType_role().getName().equals(account.getType_role().getName())) {
                Authority type_role = entityManager.createQuery("FROM Authority WHERE name = '" + account.getType_role().getName() + "'",Authority.class).getSingleResult();
                updateAccount.setType_role(type_role);
            }
            entityManager.merge(updateAccount);
            return updateAccount;
        }       
    }

    @Override
    public List<Account> findAll() {
        String hql = "FROM Account";
        System.out.println(hql);
	List<Account> resultList =  entityManager.createQuery(hql,Account.class).getResultList();
        
	return resultList;
    }

    @Override
    public String activate(Account account) {
        String hql = "FROM Account WHERE email = '" + account.getEmail() +"'";
	Account result =  entityManager.createQuery(hql,Account.class).getResultList().get(0);
        if(account.getCodeActivate().equals(result.getCodeActivate())) {
            result.setActivation(true);
            entityManager.merge(result);
            return "Done!";
        }
        else return "Error code activation!";
    }

    @Override
    public Account findById(Integer id) {
        return entityManager.find(Account.class, id);
    }
    
}
