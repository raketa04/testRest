/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import com.mycompany.resurse.Favorite;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ADMIN
 */
public interface BookmarksRepository extends CrudRepository<Favorite, Integer> {
    List<Favorite> findByDirectory(Integer Direcrory);    
}
