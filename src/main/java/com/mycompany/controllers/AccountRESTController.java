/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.dto.AccountDto;
import com.mycompany.resurse.Account;
import com.mycompany.service.AccountService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.RequestEntity.method;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author ADMIN
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class AccountRESTController {
    
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountService accountService;
    
    @GetMapping("all")
    public ResponseEntity<List<AccountDto>> getAllLandors() {
        List<AccountDto> list = list = accountService.findAll().stream()
                .map(authority -> modelMapper.map(authority ,AccountDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value ="add", method = RequestMethod.GET)
    public ResponseEntity<AccountDto> addNewUser(@RequestBody AccountDto accountDto) {
        accountDto.setPassword(new BCryptPasswordEncoder().encode(accountDto.getPassword()));
        Account account = accountService.save(modelMapper.map(accountDto, Account.class));
        return new ResponseEntity<>(modelMapper.map(account,AccountDto.class), HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account list = accountService.findById(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
