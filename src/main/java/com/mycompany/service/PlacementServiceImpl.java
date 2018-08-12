/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.PlacementDao;
import com.mycompany.dto.Search;
import com.mycompany.resurse.Comforts;
import com.mycompany.resurse.Placement;
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
    public List<Placement> findByParametr(Search search) {
        return placementDao.findByParametr(search);
    }

    @Override
    public Integer findNumberByParametr(Search search) {
        return placementDao.findNumberByParametr(search);
    }
    
}