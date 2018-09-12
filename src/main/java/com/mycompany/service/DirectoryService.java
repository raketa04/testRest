/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Directory;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface DirectoryService {
    Directory add(Directory directory);
    Directory save(Directory directory);
    boolean  delete(Directory directory);
    List<Directory> findByAccount(Integer idAccount);
}