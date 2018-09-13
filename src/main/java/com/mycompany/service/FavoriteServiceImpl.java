/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Favorite;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.repository.FavoriteRepository;
import com.mycompany.resurse.Account;

/**
 *
 * @author ADMIN
 */

@Service
public class FavoriteServiceImpl implements FavoriteService{

    
    @Autowired
    FavoriteRepository favoriteRepository;
    
    @Override
    public Favorite add(Favorite bookmarks) {
        return favoriteRepository.save(bookmarks);
    }

    @Override
    public Favorite save(Favorite bookmarks) {
        return favoriteRepository.save(bookmarks);
    }

    @Override
    public boolean delete(Favorite bookmarks) {
        favoriteRepository.deleteById(bookmarks.getIdFavorite());
        return true;
    }

    @Override
    public List<Favorite> findByDirectory(Integer idDirectory) {
        return favoriteRepository.findByDirectoryIdDirectory(idDirectory);
    }

    @Override
    public boolean isFavorite(Integer placement, Integer account) {
        if(favoriteRepository.findByPlacementAndDirectoryAccountIdAccount(placement, account) != null) return true;
        return false;
    }
    
}
