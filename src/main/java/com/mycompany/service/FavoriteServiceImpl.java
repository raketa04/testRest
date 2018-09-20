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
import com.mycompany.resurse.Placement;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */

@Service
public class FavoriteServiceImpl implements FavoriteService{

    
    @Autowired
    FavoriteRepository favoriteRepository;
    
    @Autowired
    PlacementService placementService;
    
    @Override
    public Favorite add(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @Override
    public boolean delete(Favorite favorite){
        try{
            Favorite deleteFavorite = favoriteRepository.findByPlacementAndDirectoryIdDirectory(favorite.getPlacement(), favorite.getDirectory().getIdDirectory());
            favoriteRepository.deleteById(deleteFavorite.getIdFavorite());
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return true;
    }

    @Override
    public List<Placement> findByDirectory(Integer idDirectory) { 
        ArrayList<Integer> placements = new ArrayList<>();
        List<Favorite> favorites = favoriteRepository.findByDirectoryIdDirectory(idDirectory);
        for (Favorite favorite : favorites) {
            placements.add(favorite.getPlacement());
        }
        if(favorites.size() > 0) return placementService.findByDirectory(placements);
        else return null;
    }

    @Override
    public boolean isFavorite(Integer placement, Account account) {
        if(favoriteRepository.findByPlacementAndDirectoryAccount(placement, account) != null) return true;
        return false;
    }

    @Override
    public Favorite findByPlacementAndDirectoryIdDirectory(Integer placement, Integer Direcrory) {
        return favoriteRepository.findByPlacementAndDirectoryIdDirectory(placement, Direcrory);
    }
}
