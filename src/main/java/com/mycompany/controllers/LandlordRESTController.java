/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.resurse.Landlords;
import com.mycompany.service.LandlordsService;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("user")
public class LandlordRESTController {
    @Autowired
    private LandlordsService landlordsService;
	
    @GetMapping("landlords")
    public ResponseEntity<List<Landlords>> getAllLandors() {
        List<Landlords> list = landlordsService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("landlords/{id}")
    public ResponseEntity<Landlords> getLandlordsById(@PathVariable Long id) {
        Landlords landlords = landlordsService.findByid(id);
        return new ResponseEntity<>(landlords, HttpStatus.OK);
    }
}
