/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import com.mycompany.resurse.Account;
import com.mycompany.resurse.Directory;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ADMIN
 */
public interface DirectoryRepository extends CrudRepository<Directory, Integer> {
    List<Directory> findByAccount(Account account);    
}