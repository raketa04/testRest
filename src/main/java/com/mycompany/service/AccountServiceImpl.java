/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.AccountDao;
import com.mycompany.resurse.Account;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountDao AccountDao;

    @Override
    public List<Account> findAllWithDetail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account findById(Integer id) {
        return AccountDao.findById(id);
    }

    @Override
    public Account save(Account account) {
        return  AccountDao.save(account);
    }

    @Override
    public Account delete(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> findAll() {
        return  AccountDao.findAll();
    } 

    @Override
    public Account findByAccount(String userName) {
        return  AccountDao.findByAccount(userName);
    }

    @Override
    public String activate(Account account) {
        return AccountDao.activate(account);
    }

    @Override
    public boolean emailIsUsed(String userName) {
        return AccountDao.emailIsUsed(userName);
    }
}
