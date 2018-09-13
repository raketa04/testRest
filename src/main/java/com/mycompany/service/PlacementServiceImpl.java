/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.ServerSpringApplication;
import com.mycompany.dao.PlacementDao;
import com.mycompany.dto.Search;
import com.mycompany.repository.DirectoryRepository;
import com.mycompany.repository.FavoriteRepository;
import com.mycompany.resurse.Comforts;
import com.mycompany.resurse.Favorite;
import com.mycompany.resurse.Placement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class PlacementServiceImpl implements PlacementService{

    @Autowired
    PlacementDao placementDao;
    
    @Autowired
    FavoriteRepository favoriteRepository;
    
    @Override
    public List<Placement> findAll() {
        return placementDao.findAll();
    }

    @Override
    public List<Placement> findByComforts(Set<Comforts> comfortses) {
        return placementDao.findByComforts(comfortses);
    }

    @Override
    public Placement findById(int id) {
        return placementDao.findById(id);
    }

    @Override
    public Placement save(Placement placement) {
        return placementDao.save(placement);
    }

    @Override
    public boolean delete(Placement placement) {
        return placementDao.delete(placement);
    }

    @Override
    public List<Placement> findByParametr(Search search, int page) {
        return placementDao.findByParametr(search,page);
    }

    @Override
    public Long findNumberByParametr(Search search) {
        return placementDao.findNumberByParametr(search);
    }

    @Override
    public List<Placement> findByIdAccount(int idAccount) {
       return placementDao.findByIdAccount(idAccount);
    }

    @Override
    public boolean addCachePlacment(int idPlacement) {
        ServerSpringApplication.cache.put(idPlacement, idPlacement);
        return true;
    }

    @Override
    public boolean deleteCachePlacment(int idPlacement) {
        ServerSpringApplication.cache.asMap().remove(idPlacement);
        return true;
    }

    @Override
    public List<Placement> findByDirectory(int idDirectory) {
        ArrayList<Integer> placements = new ArrayList<>();
        List<Favorite> favorites = favoriteRepository.findByDirectoryIdDirectory(idDirectory);
        for (Favorite favorite : favorites) {
            placements.add(favorite.getPlacement());
        }
        return placementDao.findByIdPlacements(placements);
    }
    
}
