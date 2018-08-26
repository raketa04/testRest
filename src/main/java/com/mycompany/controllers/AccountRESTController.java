/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.dto.AccountDto;
import com.mycompany.resurse.Account;
import com.mycompany.security.JwtTokenUtil;
import com.mycompany.security.JwtUser;
import com.mycompany.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
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
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Value("${jwt.header}")
    private String tokenHeader;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @GetMapping("logout")
    @JsonView(AccountDto.autarificationOut.class)
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken temp = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        temp.setAuthenticated(false);
        authenticationManager.authenticate(temp);
        return new ResponseEntity<>("logout", HttpStatus.OK);
    }
    
    @RequestMapping(value ="activation", method = RequestMethod.POST)
    public ResponseEntity<String> activation(@Validated(AccountDto.activation.class)@RequestBody AccountDto accountDto) {
        String result = accountService.activate(modelMapper.map(accountDto, Account.class));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    
    @RequestMapping(value ="add", method = RequestMethod.POST)
    @JsonView(AccountDto.autarificationOut.class)
    public ResponseEntity<AccountDto> addNewUser(@Validated(AccountDto.add.class) @RequestBody AccountDto accountDto) {
        accountDto.setPassword(new BCryptPasswordEncoder().encode(accountDto.getPassword()));
        Account result = accountService.save(modelMapper.map(accountDto, Account.class));
        Account temp = accountService.findById(result.getIdAccount());
        return new ResponseEntity<>(modelMapper.map(temp, AccountDto.class), HttpStatus.OK);
    }
    
    
    
    @RequestMapping(value ="update", method = RequestMethod.PUT)
    @JsonView(AccountDto.autarificationOut.class)
    public ResponseEntity<AccountDto> updateUser(@RequestBody AccountDto accountDto) {
        if(accountDto.getPassword() != null) accountDto.setPassword(new BCryptPasswordEncoder().encode(accountDto.getPassword()));
        Account result = accountService.save(modelMapper.map(accountDto, Account.class));
        return new ResponseEntity<>(modelMapper.map(result, AccountDto.class), HttpStatus.OK);
    }
    
}
