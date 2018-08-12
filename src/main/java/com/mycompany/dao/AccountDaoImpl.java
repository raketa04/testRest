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
	List <Account> result =  entityManager.createQuery(hql,Account.class).getResultList();
	return result.get(0);
    }

  
    @Override
    public int save(Account account) {
        if(account.getIdAccount() ==  null){
            Random ran = new Random();
            if(account.getLandlord() != null){
                Landlords landlords = account.getLandlord();
                account.setLandlord(null);
                account.setCodeActivate(Integer.toString(ran.nextInt(10))+ Integer.toString(ran.nextInt(10))+Integer.toString(ran.nextInt(10))+Integer.toString(ran.nextInt(10)));
                entityManager.persist(account);
                entityManager.flush();
                landlords.setAccount(account);
                entityManager.merge(landlords);
            }
            if(account.getTenant() != null){   
                Tenant tenant = account.getTenant();
                account.setTenant(null);
                account.setCodeActivate(Integer.toString(ran.nextInt(10))+ Integer.toString(ran.nextInt(10))+Integer.toString(ran.nextInt(10))+Integer.toString(ran.nextInt(10)));
                entityManager.persist(account);
                entityManager.flush();
                tenant.setAccount(account);
                entityManager.merge(tenant);
            }
            
        }
        else{
            Account updateAccount = entityManager.find(Account.class,account.getIdAccount());
            if(updateAccount.getLandlord() != null){
                if(!updateAccount.getPassword().equals(account.getPassword())) updateAccount.setPassword(account.getPassword());
                if(!updateAccount.getLandlord().getLastName().equals(account.getLandlord().getLastName())) updateAccount.getLandlord().setLastName(account.getLandlord().getLastName());
                if(!updateAccount.getLandlord().getFirstName().equals(account.getLandlord().getFirstName())) updateAccount.getLandlord().setFirstName(account.getLandlord().getFirstName());
                if(!updateAccount.getLandlord().getPatronymic().equals(account.getLandlord().getPatronymic())) updateAccount.getLandlord().setPatronymic(account.getLandlord().getPatronymic());
                if(!updateAccount.getLandlord().getPhone().equals(account.getLandlord().getPhone())) updateAccount.getLandlord().setPhone(account.getLandlord().getPhone());
                if(!updateAccount.getLandlord().getClining() == account.getLandlord().getClining()) updateAccount.getLandlord().setClining(account.getLandlord().getClining());
                entityManager.merge(updateAccount);
            }
            if(updateAccount.getTenant()!= null){
                if(!updateAccount.getTenant().getLastName().equals(account.getTenant().getLastName())) updateAccount.getTenant().setLastName(account.getTenant().getLastName());
                if(!updateAccount.getTenant().getFirstName().equals(account.getTenant().getFirstName())) updateAccount.getTenant().setFirstName(account.getTenant().getFirstName());
                if(!updateAccount.getTenant().getPatronymic().equals(account.getTenant().getPatronymic())) updateAccount.getTenant().setPatronymic(account.getTenant().getPatronymic());
                if(!updateAccount.getTenant().getPhone().equals(account.getTenant().getPhone())) updateAccount.getTenant().setPhone(account.getTenant().getPhone());
                entityManager.merge(updateAccount);
             }
        }
        return account.getIdAccount();
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
        String hql = "FROM Account WHERE login = '" + account.getLogin() +"'";
	Account result =  entityManager.createQuery(hql,Account.class).getResultList().get(0);
        if(account.getCodeActivate().equals(result.getCodeActivate())) {
            result.setActivation(true);
            entityManager.merge(result);
            return "Done!";
        }
        else return "Error code activation!";
    }
    
}
