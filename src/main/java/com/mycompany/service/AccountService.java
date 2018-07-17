/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Account;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface AccountService {
    List<Account> findAllWithDetail();
    Account findById(Long id);
    List<Account> findAll();
    Account save(Account account);
    Account delete(Account account);
}
