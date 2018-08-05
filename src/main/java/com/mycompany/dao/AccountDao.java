/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Account;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface AccountDao {
    Account findByAccount(String userName);
    List<Account> findAll();
    int save(Account account); 
    String activate(Account account); 
}
