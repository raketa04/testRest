/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.dto.AccountDto;
import com.mycompany.dto.AvatarDto;
import com.mycompany.resurse.Account;
import com.mycompany.resurse.Avatar;
import com.mycompany.security.JwtTokenUtil;
import com.mycompany.security.JwtUser;
import com.mycompany.service.AccountService;
import com.mycompany.service.AvatarService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author ADMIN
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    private AvatarService avatarService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Value("${jwt.header}")
    private String tokenHeader;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @GetMapping("logout")
public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    authenticationManager.authenticate(auth);
    if (auth != null){    
        new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
}
    
    @RequestMapping(value ="activation", method = RequestMethod.POST)
    public ResponseEntity<String> activation(@Validated(AccountDto.activation.class)@RequestBody AccountDto accountDto) {
        String result = accountService.activate(modelMapper.map(accountDto, Account.class));
        if(result ==  "Error code activation!") return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }
    
    
    @RequestMapping(value ="add", method = RequestMethod.POST)
    @JsonView(AccountDto.autarificationOut.class)
    public ResponseEntity<?> addNewUser(@Validated(AccountDto.add.class) @RequestBody AccountDto accountDto) {
        accountDto.setPassword(new BCryptPasswordEncoder().encode(accountDto.getPassword()));
        if(accountService.emailIsUsed(accountDto.getEmail())) return new ResponseEntity<>("email is registered", HttpStatus.BAD_REQUEST);
        Account result = accountService.save(modelMapper.map(accountDto, Account.class));
        Account temp = accountService.findById(result.getIdAccount());
        return new ResponseEntity<>(modelMapper.map(temp, AccountDto.class), HttpStatus.CREATED);
    }
    
        
        
    @RequestMapping(value = "avatar/get/{id}",method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> uploadFile(@PathVariable int id) throws IOException{
        String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory: " + cwd);
        File f = avatarService.findById(id);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(f));
        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + f.getName())
                // Content-Type
                .contentType(MediaType.IMAGE_JPEG)
                // Contet-Length
                .contentLength(f.length()) //
                .body(resource);
    }
    
    @RequestMapping(value ="update", method = RequestMethod.PUT)
    @JsonView(AccountDto.autarificationOut.class)
    public ResponseEntity<AccountDto> updateUser(@RequestBody AccountDto accountDto) {
        if(accountDto.getPassword() != null) accountDto.setPassword(new BCryptPasswordEncoder().encode(accountDto.getPassword()));
        Account result = accountService.save(modelMapper.map(accountDto, Account.class));
        return new ResponseEntity<>(modelMapper.map(result, AccountDto.class), HttpStatus.ACCEPTED);
    }
    
}
