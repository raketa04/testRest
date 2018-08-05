/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;


import com.mycompany.dto.AuthorityDto;
import com.mycompany.resurse.Authority;
import com.mycompany.service.AuthorityService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("aut")
public class AuthorityRESTController {
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private AuthorityService authorityService;
	
    @GetMapping("all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AuthorityDto>> getAllAuthority() {
        List<AuthorityDto> list = authorityService.findAll().stream()
                .map(authority -> modelMapper.map(authority ,AuthorityDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
