/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;



import com.mycompany.dto.ComfortsDto;
import com.mycompany.service.ComfortsService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("comforts")
public class ComfortsRESTController {
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private ComfortsService comfortsService;
    
    @GetMapping("all")
    public ResponseEntity<List<ComfortsDto>> getAllCity() {
        List<ComfortsDto> list = comfortsService.findAll().stream()
                .map(authority -> modelMapper.map(authority ,ComfortsDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
