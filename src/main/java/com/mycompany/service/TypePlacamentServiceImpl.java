/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.repository.TypePlacementRepository;
import com.mycompany.resurse.TypePlacament;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class TypePlacamentServiceImpl implements TypePlacamentService{

    @Autowired
    TypePlacementRepository placementRepository;
    @Override
    public List<TypePlacament> findAll() {
        return  placementRepository.findAll();
    }
    
}
