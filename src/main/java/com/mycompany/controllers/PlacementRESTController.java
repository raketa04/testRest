/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.dto.AccountDto;
import com.mycompany.dto.CityDto;
import com.mycompany.dto.ComfortsDto;
import com.mycompany.dto.PlacementDto;
import com.mycompany.dto.Search;
import com.mycompany.dto.SearchDto;
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
import org.springframework.validation.annotation.Validated;
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
    
    @GetMapping("landlord/{id}")
    @JsonView(PlacementDto.getPlacment.class)
    public ResponseEntity<List<PlacementDto>> getLandlordPlacment(@PathVariable int id) {
        List<PlacementDto> list = placementService.findAll().stream()
                .map(authority -> modelMapper.map(authority ,PlacementDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
       
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @JsonView(PlacementDto.getPlacment.class)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PlacementDto> getById(@PathVariable int id) {
        return new ResponseEntity<>(modelMapper.map(placementService.findById(id),PlacementDto.class), HttpStatus.OK);
    }

    
    @RequestMapping(value = "comforts", method = RequestMethod.POST)
    public ResponseEntity<List<PlacementDto>> getByComforts(@RequestBody List<ComfortsDto> comfortsDto) {
        Set<Comforts> comfortses = comfortsDto.stream()
               .map(authority -> modelMapper.map(authority, Comforts.class))
               .collect(Collectors.toSet()); 
        List<PlacementDto> list= placementService.findByComforts(comfortses).stream()
               .map(authority -> modelMapper.map(authority ,PlacementDto.class))
               .collect(Collectors.toList()); 
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value ="search", method = RequestMethod.POST)
    @JsonView(PlacementDto.getPlacmentSearach.class)
    public ResponseEntity<List<PlacementDto>> SearchPlacment (@RequestBody SearchDto search) {
        List<PlacementDto> list= placementService.findByParametr(modelMapper.map(search, Search.class)).stream()
               .map(authority -> modelMapper.map(authority ,PlacementDto.class))
               .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value ="search_number", method = RequestMethod.POST)
    public ResponseEntity<Long> numberSearchPlacment(@RequestBody Search search) {
        return new ResponseEntity<>(placementService.findNumberByParametr(search), HttpStatus.OK);
    }
        
    
    @RequestMapping(value ="add", method = RequestMethod.POST)
    @JsonView(PlacementDto.addGetPlacment.class)
    public ResponseEntity<PlacementDto> addNewPlacement(@Validated(PlacementDto.addPlacment.class)@RequestBody PlacementDto placementDto) {
        Placement placement = placementService.save(modelMapper.map(placementDto, Placement.class));
        Placement result = placementService.findById(placement.getIdPlacement());
        return new ResponseEntity<>(modelMapper.map(result,PlacementDto.class), HttpStatus.OK);
    }
    

    @RequestMapping(value ="update", method = RequestMethod.PUT)
    @JsonView(PlacementDto.addGetPlacment.class)
    public ResponseEntity<PlacementDto> updatePlacement(@Validated(PlacementDto.updatePlacment.class) @RequestBody PlacementDto placementDto) {
        Placement placement = placementService.save(modelMapper.map(placementDto, Placement.class));
        return new ResponseEntity<>(modelMapper.map(placement,PlacementDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePlacement(@Validated(PlacementDto.updatePlacment.class) @RequestBody PlacementDto placementDto) {
        boolean b = placementService.delete(modelMapper.map(placementDto, Placement.class));
        if (b) return new ResponseEntity<>( HttpStatus.OK);
        else return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }
}
