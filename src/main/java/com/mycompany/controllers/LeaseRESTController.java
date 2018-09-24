/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.dto.AccountDto;
import com.mycompany.dto.LeaseDto;
import com.mycompany.resurse.Account;
import com.mycompany.resurse.Lease;
import com.mycompany.security.JwtTokenUtil;
import com.mycompany.service.AccountService;
import com.mycompany.service.LeaseService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    
    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Value("${jwt.header}")
    private String tokenHeader;
    
    @RequestMapping(value ="add", method = RequestMethod.POST)
    @JsonView(LeaseDto.getTempLease.class)
    public ResponseEntity<LeaseDto> addNewLease(@Validated(LeaseDto.addLease.class)@RequestBody LeaseDto leaseDto,HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        AccountDto account = modelMapper.map(accountService.findByAccount(username),AccountDto.class);
        leaseDto.setAccount(account);
        Lease result = leaseService.add(modelMapper.map(leaseDto, Lease.class));
        //leaseService.addCacheLease(result);
        return new ResponseEntity<>(modelMapper.map(result,LeaseDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="activate", method = RequestMethod.POST)
    public ResponseEntity<?> activateLease(@Validated(LeaseDto.activateLease.class)@RequestBody LeaseDto leaseDto) {
        boolean result = leaseService.activate(modelMapper.map(leaseDto, Lease.class));
        if (result){
            leaseService.deleteCacheLease(leaseDto.getIdLease());
            return new ResponseEntity<>("done!", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("error!", HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @RequestMapping(value ="delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> deleteLease(@PathVariable int id,HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Account account = accountService.findByAccount(username);
        Lease lease = leaseService.findByIdAccountId(account.getIdAccount(), id);
        if(lease != null){
            if(leaseService.delete(lease)){
                return new ResponseEntity<>("done!", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Время на удаление бронирования истекло", HttpStatus.NOT_FOUND);
            }
        }
        else {
            return new ResponseEntity<>("Нету заказа", HttpStatus.NOT_FOUND);
        }

    }
    
    @RequestMapping(value ="{id}", method = RequestMethod.GET)
    @JsonView(LeaseDto.getLeasePlacmentTenant.class)
    public ResponseEntity<LeaseDto> getLease(@PathVariable int id) {
        Lease result = leaseService.findByid(id);
        return new ResponseEntity<>(modelMapper.map(result,LeaseDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="temp/{id}", method = RequestMethod.GET)
    @JsonView(LeaseDto.getLeasePlacmentTenant.class)
    public ResponseEntity<LeaseDto> getTempLease(@PathVariable int id) {
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
    
    @RequestMapping(value ="account", method = RequestMethod.GET)
    @JsonView(LeaseDto.getLeaseTenant.class)
    public ResponseEntity<Map<String,ArrayList<LeaseDto>>> getAllLeaseAccount(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        List<LeaseDto> list = leaseService.findByAccount(accountService.findByAccount(username).getIdAccount()).stream()
                .map(authority -> modelMapper.map(authority ,LeaseDto.class))
                .collect(Collectors.toList());
        TreeMap<String,ArrayList<LeaseDto>> sendList =  new TreeMap<>();
        ArrayList<LeaseDto> complete  =  new ArrayList<>();
        ArrayList<LeaseDto> future  =  new ArrayList<>();
        ArrayList<LeaseDto> current  =  new ArrayList<>();
        Date d = new Date();
        for(LeaseDto lease:list){
            if(lease.getEndLease() < d.getTime() && lease.getStartLease() < d.getTime()) complete.add(lease);
            if(lease.getEndLease() < d.getTime() && lease.getStartLease() > d.getTime()) current.add(lease);
            if(lease.getStartLease() > d.getTime()) future.add(lease);
        }
        
        sendList.put("complete",complete);
        sendList.put("current",current);
        sendList.put("future",future);
        
        return new ResponseEntity<>(sendList, HttpStatus.OK);
    }
}
 