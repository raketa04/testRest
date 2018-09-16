/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.dto.FavoriteDto;
import com.mycompany.dto.DirectoryDto;
import com.mycompany.dto.PlacementDto;
import com.mycompany.resurse.Favorite;
import com.mycompany.resurse.Directory;
import com.mycompany.resurse.Placement;
import com.mycompany.security.JwtTokenUtil;
import com.mycompany.service.AccountService;
import com.mycompany.service.FavoriteService;
import com.mycompany.service.DirectoryService;
import java.util.List;
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
@RequestMapping("account")
public class DirectoryRESTController {
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private DirectoryService directoryService;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Value("${jwt.header}")
    private String tokenHeader;
    
    @Autowired
    private FavoriteService favoriteService;
    
    @RequestMapping(value ="directory/add", method = RequestMethod.POST)
    @JsonView(DirectoryDto.getDirectoryAdd.class)
    public ResponseEntity<?> addNewDirectory(@Validated(DirectoryDto.addDirectory.class) @RequestBody DirectoryDto directoryDto,HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Directory add = modelMapper.map(directoryDto, Directory.class);
        add.setAccount(accountService.findByAccount(username));
        Directory result = directoryService.add(add);
        return new ResponseEntity<>(modelMapper.map(result, DirectoryDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="directory/update", method = RequestMethod.POST)
    @JsonView(DirectoryDto.getDirectoryUpdate.class)
    public ResponseEntity<?> updateDirectory(@Validated(DirectoryDto.updateDirectory.class) @RequestBody DirectoryDto directoryDto) {
        Directory result = directoryService.save(modelMapper.map(directoryDto, Directory.class));
        return new ResponseEntity<>(modelMapper.map(result, DirectoryDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="directory/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteDirectory(@Validated(DirectoryDto.deleteDirectory.class) @RequestBody DirectoryDto directoryDto) {
        boolean b = directoryService.delete(modelMapper.map(directoryDto, Directory.class));
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @RequestMapping(value ="directory", method = RequestMethod.GET)
    @JsonView(DirectoryDto.getDirectory.class)
    public ResponseEntity<?> getDirectoryAccount(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        List<DirectoryDto> result = directoryService.findByAccount(accountService.findByAccount(username)).stream()
            .map(authority -> modelMapper.map(authority ,DirectoryDto.class))
            .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(value ="directory/{id}", method = RequestMethod.GET)
    @JsonView(PlacementDto.getPlacmentSearach.class)
    public ResponseEntity<?> getPlacementDirectory(@PathVariable int id) {
        List<Placement> temp = favoriteService.findByDirectory(id);
        if(temp != null){
            List<PlacementDto> result = favoriteService.findByDirectory(id).stream()
                .map(authority -> modelMapper.map(authority ,PlacementDto.class))
                .collect(Collectors.toList());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("", HttpStatus.OK);
        }
    }
    
    @RequestMapping(value ="directory/favorite/add", method = RequestMethod.POST)
    @JsonView(FavoriteDto.getFavorite.class)
    public ResponseEntity<?> addNewFavorite(@Validated(FavoriteDto.addFavorite.class) @RequestBody FavoriteDto favoriteDto) {
        Favorite result = favoriteService.add(modelMapper.map(favoriteDto, Favorite.class));
        return new ResponseEntity<>(modelMapper.map(result, FavoriteDto.class), HttpStatus.OK);
    }
    
    
    @RequestMapping(value ="directory/favorite/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteFavorite(@Validated(DirectoryDto.deleteDirectory.class) @RequestBody FavoriteDto favoriteDto) {
        boolean b = favoriteService.delete(modelMapper.map(favoriteDto, Favorite.class));
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    
    @RequestMapping(value ="directory/favorite/placement/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> isFavorite(HttpServletRequest request, @PathVariable int id) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        boolean b = favoriteService.isFavorite(id, accountService.findByAccount(username));
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    

}
