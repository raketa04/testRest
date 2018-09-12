/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.dto.PlacementDto;
import com.mycompany.dto.TypePlacamentDto;
import com.mycompany.service.TypePlacamentService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("placement")
public class TypePlacementRESTController {
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private TypePlacamentService typePlacamentService;
    
    @RequestMapping(value = "type/all", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<TypePlacamentDto>> getAllType() {
        List<TypePlacamentDto> result = typePlacamentService.findAll().stream()
                .map(authority -> modelMapper.map(authority ,TypePlacamentDto.class))
                .collect(Collectors.toList()); 
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
}
