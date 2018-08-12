/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.dto.AccountDto;
import com.mycompany.resurse.Account;
import com.mycompany.security.JwtTokenUtil;
import com.mycompany.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author ADMIN
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountRESTController {
    
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Value("${jwt.header}")
    private String tokenHeader;

    @GetMapping("login")
    public ResponseEntity<AccountDto> authorization(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        AccountDto account = modelMapper.map(accountService.findByAccount(username), AccountDto.class);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    
    @RequestMapping(value ="activation", method = RequestMethod.POST)
    public ResponseEntity<String> activation(@RequestBody AccountDto accountDto) {
        String result = accountService.activate(modelMapper.map(accountDto, Account.class));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @RequestMapping(value ="add", method = RequestMethod.POST)
    public ResponseEntity<Integer> addNewUser(@RequestBody AccountDto accountDto) {
        accountDto.setPassword(new BCryptPasswordEncoder().encode(accountDto.getPassword()));
        int id = accountService.save(modelMapper.map(accountDto, Account.class));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    
    @RequestMapping(value ="update", method = RequestMethod.PUT)
    public ResponseEntity<Integer> updateUser(@RequestBody AccountDto accountDto) {
        if(accountDto.getPassword() != null) accountDto.setPassword(new BCryptPasswordEncoder().encode(accountDto.getPassword()));
        int id = accountService.save(modelMapper.map(accountDto, Account.class));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    
}
