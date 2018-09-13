/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.dto.FavoriteDto;
import com.mycompany.dto.DirectoryDto;
import com.mycompany.resurse.Favorite;
import com.mycompany.resurse.Directory;
import com.mycompany.service.FavoriteService;
import com.mycompany.service.DirectoryService;
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
@RequestMapping("account/directory")
public class DirectoryRESTController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DirectoryService directoryService;
    
    @Autowired
    private FavoriteService favoriteService;
    
    @RequestMapping(value ="add", method = RequestMethod.POST)
    @JsonView(DirectoryDto.getDirectoryAdd.class)
    public ResponseEntity<?> addNewDirectory(@Validated(DirectoryDto.addDirectory.class) @RequestBody DirectoryDto directoryDto) {
        Directory result = directoryService.add(modelMapper.map(directoryDto, Directory.class));
        return new ResponseEntity<>(modelMapper.map(result, DirectoryDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="update", method = RequestMethod.POST)
    @JsonView(DirectoryDto.getDirectoryUpdate.class)
    public ResponseEntity<?> updateDirectory(@Validated(DirectoryDto.updateDirectory.class) @RequestBody DirectoryDto directoryDto) {
        Directory result = directoryService.save(modelMapper.map(directoryDto, Directory.class));
        return new ResponseEntity<>(modelMapper.map(result, DirectoryDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteDirectory(@Validated(DirectoryDto.deleteDirectory.class) @RequestBody DirectoryDto directoryDto) {
        boolean b = directoryService.delete(modelMapper.map(directoryDto, Directory.class));
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @RequestMapping(value ="{id}", method = RequestMethod.GET)
    @JsonView(DirectoryDto.getDirectory.class)
    public ResponseEntity<?> getDirectoryAccount(@PathVariable Integer id) {
        List<DirectoryDto> result = directoryService.findByAccount(id).stream()
               .map(authority -> modelMapper.map(authority ,DirectoryDto.class))
               .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(value ="favorite/add", method = RequestMethod.POST)
    @JsonView(FavoriteDto.getFavorite.class)
    public ResponseEntity<?> addNewBookmarks(@Validated(FavoriteDto.addFavorite.class) @RequestBody FavoriteDto favoriteDto) {
        Favorite result = favoriteService.add(modelMapper.map(favoriteDto, Favorite.class));
        return new ResponseEntity<>(modelMapper.map(result, FavoriteDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="favorite/update", method = RequestMethod.POST)
    @JsonView(FavoriteDto.getFavorite.class)
    public ResponseEntity<?> updateBookmarks(@Validated(FavoriteDto.updateFavorite.class) @RequestBody FavoriteDto favoriteDto) {
        Favorite result = favoriteService.save(modelMapper.map(favoriteDto, Favorite.class));
        return new ResponseEntity<>(modelMapper.map(result, FavoriteDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="favorite/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteDirectory(@Validated(DirectoryDto.deleteDirectory.class) @RequestBody FavoriteDto favoriteDto) {
        boolean b = favoriteService.delete(modelMapper.map(favoriteDto, Favorite.class));
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @RequestMapping(value ="favorite/{id}", method = RequestMethod.GET)
    @JsonView(FavoriteDto.getFavorite.class)
    public ResponseEntity<?> getBookmarksDirectory(@PathVariable Integer id) {
        List<FavoriteDto> result =  favoriteService.findByDirectory(id).stream()
               .map(authority -> modelMapper.map(authority ,FavoriteDto.class))
               .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(value ="favorite/placement", method = RequestMethod.POST)
    public ResponseEntity<?> isFavorite(@Validated(DirectoryDto.deleteDirectory.class) @RequestBody FavoriteDto favoriteDto) {
        boolean b = favoriteService.isFavorite(favoriteDto.getPlacement(), favoriteDto.getDirectory().getAccount().getIdAccount());
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    

}
