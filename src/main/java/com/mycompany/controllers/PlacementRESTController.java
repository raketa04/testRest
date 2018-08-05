/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.dto.AccountDto;
import com.mycompany.dto.CityDto;
import com.mycompany.dto.ComfortsDto;
import com.mycompany.dto.PlacementDto;
import com.mycompany.resurse.Account;
import com.mycompany.resurse.Comforts;
import com.mycompany.resurse.Placement;
import com.mycompany.service.PlacementService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("placement")
public class PlacementRESTController {
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private PlacementService placementService;
    
    @GetMapping("all")
    public ResponseEntity<List<PlacementDto>> getAllPlacement() {
        List<PlacementDto> list = placementService.findAll().stream()
                .map(authority -> modelMapper.map(authority ,PlacementDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "byRegion/{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PlacementDto>> getByIdRegion(@PathVariable int id) {
         List<PlacementDto> list = placementService.findByRegion(id).stream()
                .map(authority -> modelMapper.map(authority ,PlacementDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PlacementDto> getById(@PathVariable int id) {
        return new ResponseEntity<>(modelMapper.map(placementService.findById(id),PlacementDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value = "byCity/{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PlacementDto>> getByIdCity(@PathVariable int id) {
         List<PlacementDto> list = placementService.findByCity(id).stream()
                .map(authority -> modelMapper.map(authority ,PlacementDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "comforts", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<PlacementDto>> getByComforts(@RequestBody List<ComfortsDto> comfortsDto) {
        Set<Comforts> comfortses = comfortsDto.stream()
               .map(authority -> modelMapper.map(authority, Comforts.class))
               .collect(Collectors.toSet()); 
        
        List<PlacementDto> list= placementService.findByComforts(comfortses).stream()
               .map(authority -> modelMapper.map(authority ,PlacementDto.class))
               .collect(Collectors.toList()); 
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @RequestMapping(value ="add", method = RequestMethod.POST)
    public ResponseEntity<PlacementDto> addNewPlacement(@RequestBody PlacementDto placementDto) {
        Placement account = placementService.save(modelMapper.map(placementDto, Placement.class));
        return new ResponseEntity<>(modelMapper.map(account,PlacementDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="update", method = RequestMethod.PUT)
    public ResponseEntity<PlacementDto> updateUser(@RequestBody PlacementDto placementDto) {
        Placement account = placementService.save(modelMapper.map(placementDto, Placement.class));
        return new ResponseEntity<>(modelMapper.map(account,PlacementDto.class), HttpStatus.OK);
    }
}
