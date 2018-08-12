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
import com.mycompany.resurse.Landlords;
import com.mycompany.resurse.Tenant;
import java.util.List;
import java.util.Random;
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
    public Account save(Account account) {
        if(account.getIdAccount() ==  null){
            Random ran = new Random();
            if(account.getLandlord() != null){
                //account.setCodeActivate(Integer.toString(ran.nextInt(10))+ Integer.toString(ran.nextInt(10))+Integer.toString(ran.nextInt(10))+Integer.toString(ran.nextInt(10)));
                account.setCodeActivate("11111");
		entityManager.persist(account);
                account.getLandlord().setAccount(account);
                
            }
            if(account.getTenant() != null){   ;
                //account.setCodeActivate(Integer.toString(ran.nextInt(10))+ Integer.toString(ran.nextInt(10))+Integer.toString(ran.nextInt(10))+Integer.toString(ran.nextInt(10)));
               	account.setCodeActivate("11111");
		entityManager.persist(account);
                account.getTenant().setAccount(account);
            }
        }
        else{
            Account updateAccount = entityManager.find(Account.class,account.getIdAccount());
            if(updateAccount.getLandlord() != null){
                if(!updateAccount.getLandlord().getFIO().equals(account.getLandlord().getFIO())) updateAccount.getLandlord().setFIO(account.getLandlord().getFIO());
                if(!updateAccount.getLandlord().getPhone().equals(account.getLandlord().getPhone())) updateAccount.getLandlord().setPhone(account.getLandlord().getPhone());
                if(!updateAccount.getLandlord().getClining() == account.getLandlord().getClining()) updateAccount.getLandlord().setClining(account.getLandlord().getClining());
                entityManager.merge(updateAccount);
            }
            if(updateAccount.getTenant()!= null){
                if(!updateAccount.getTenant().getFIO().equals(account.getTenant().getFIO())) updateAccount.getTenant().setFIO(account.getTenant().getFIO());
                if(!updateAccount.getTenant().getPhone().equals(account.getTenant().getPhone())) updateAccount.getTenant().setPhone(account.getTenant().getPhone());
                entityManager.merge(updateAccount);
             }
        }
        entityManager.flush();
        entityManager.clear();
        Account result = entityManager.find(Account.class, account.getIdAccount());
        return result;
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
