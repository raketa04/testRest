/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.dto.LeaseDto;
import com.mycompany.resurse.Lease;
import com.mycompany.service.LeaseService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("lease")
public class LeaseRESTController {
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private LeaseService leaseService;
    
    @RequestMapping(value ="add", method = RequestMethod.POST)
    @JsonView(LeaseDto.getAddLease.class)
    public ResponseEntity<LeaseDto> addNewLease(@Validated(LeaseDto.addLease.class)@RequestBody LeaseDto leaseDto) {
        Lease result = leaseService.add(modelMapper.map(leaseDto, Lease.class));
        return new ResponseEntity<>(modelMapper.map(result,LeaseDto.class), HttpStatus.OK);
    }
    @RequestMapping(value ="{id}", method = RequestMethod.GET)
    @JsonView(LeaseDto.getLeasePlacmentTenant.class)
    public ResponseEntity<LeaseDto> getLease(@PathVariable int id) {
        Lease result = leaseService.findByid(id);
        return new ResponseEntity<>(modelMapper.map(result,LeaseDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="placement/{id}", method = RequestMethod.GET)
    @JsonView(LeaseDto.getLeasePlacement.class)
    public ResponseEntity<List<LeaseDto>> getAllLeasePlacment(@PathVariable int id) {
        List<LeaseDto> list = leaseService.findByPlacment(id).stream()
                .map(authority -> modelMapper.map(authority ,LeaseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value ="account/{id}", method = RequestMethod.GET)
    @JsonView(LeaseDto.getLeaseTenant.class)
    public ResponseEntity<List<LeaseDto>> getAllLeaseTenant(@PathVariable int id) {
        List<LeaseDto> list = leaseService.findByAccount(id).stream()
                .map(authority -> modelMapper.map(authority ,LeaseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
 