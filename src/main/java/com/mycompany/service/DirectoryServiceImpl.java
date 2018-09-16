/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.AccountDao;
import com.mycompany.repository.DirectoryRepository;
import com.mycompany.resurse.Account;
import com.mycompany.resurse.Directory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class DirectoryServiceImpl implements DirectoryService{

    @Autowired
    DirectoryRepository directoryRepository;
    @Autowired
    AccountDao accountDao;
    
    @Override
    public Directory add(Directory directory) {
        return directoryRepository.save(directory);
    }

    @Override
    public Directory save(Directory directory) {
        Directory temp = directoryRepository.findById(directory.getIdDirectory()).get();
        if(!temp.getName().equals(directory.getName())) temp.setName(directory.getName());  
        return directoryRepository.save(temp);
    }

    @Override
    public boolean delete(Directory directory) {
        directoryRepository.deleteById(directory.getIdDirectory());
        return true;
    }

    @Override
    public List<Directory> findByAccount(Account account) {
        return directoryRepository.findByAccount(account);
    }
    
}
