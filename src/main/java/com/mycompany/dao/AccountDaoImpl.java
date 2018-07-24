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

public class AccountDaoImpl implements AccountDao{

    @PersistenceContext	
    private EntityManager entityManager;
    
    @Override
    public Account findByAccount(String userName) {
        String hql = "FROM Account WHERE login = '" + userName +"'";
	Account result =  entityManager.createQuery(hql,Account.class).getResultList().get(0);
	return result;
    }

  
    @Override
    public Account save(Account account) {
        if(account.getIdAccount() == -1){
           entityManager.persist(account);
        }
        else{
            Account updateAccount = entityManager.find(Account.class,account.getIdAccount());
            if(!updateAccount.getPassword().equals(account.getPassword())) updateAccount.setPassword(account.getPassword());
            if(!updateAccount.getLandlord().getLastName().equals(account.getLandlord().getLastName())) updateAccount.getLandlord().setLastName(account.getLandlord().getLastName());
            if(!updateAccount.getLandlord().getFirstName().equals(account.getLandlord().getFirstName())) updateAccount.getLandlord().setFirstName(account.getLandlord().getFirstName());
            if(!updateAccount.getLandlord().getPatronymic().equals(account.getLandlord().getPatronymic())) updateAccount.getLandlord().setPatronymic(account.getLandlord().getPatronymic());
            if(!updateAccount.getLandlord().getPhone().equals(account.getLandlord().getPhone())) updateAccount.getLandlord().setPhone(account.getLandlord().getPhone());
            if(!updateAccount.getLandlord().getClining() == account.getLandlord().getClining()) updateAccount.getLandlord().setClining(account.getLandlord().getClining());
            entityManager.merge(updateAccount);
        }
        return account;  
    }

    @Override
    public List<Account> findAll() {
        String hql = "FROM Account";
        System.out.println(hql);
	List<Account> resultList =  entityManager.createQuery(hql,Account.class).getResultList();
        
	return resultList;
    }
    
}
