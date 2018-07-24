/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

;
import com.mycompany.dto.CityDto;
import com.mycompany.service.CityService;
import com.mycompany.service.RegionService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CityDto> getCityById(@PathVariable int id) {
        return new ResponseEntity<>(modelMapper.map(cityService.findById(id),CityDto.class), HttpStatus.OK);
    }
    @RequestMapping(value = "/byRegion/{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CityDto>> getCityByIdRegion(@PathVariable int id) {
         List<CityDto> list = regionService.getCityByRegion(id).stream()
                .map(authority -> modelMapper.map(authority ,CityDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
