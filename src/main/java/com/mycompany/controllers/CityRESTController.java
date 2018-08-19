/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

;
import com.mycompany.dto.AccountDto;
import com.mycompany.dto.CityDto;
import com.mycompany.service.CityService;
import com.mycompany.service.RegionService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("city")
public class CityRESTController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private  CityService cityService;
    @Autowired
    private  RegionService regionService;
    
    @GetMapping("all")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CityDto>> getAllCity() {
        List<CityDto> list = cityService.findAll().stream()
                .map(authority -> modelMapper.map(authority ,CityDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "findbyname", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity <List<CityDto>> getCityByName(@Validated(CityDto.findCity.class)@RequestBody CityDto cityDto) {
        List<CityDto> list = cityService.findByName(cityDto.getName()).stream()
                .map(authority -> modelMapper.map(authority ,CityDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
}
