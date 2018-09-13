/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.dto.AccountDto;
import com.mycompany.dto.BookmarksDto;
import com.mycompany.dto.DirectoryDto;
import com.mycompany.resurse.Favorite;
import com.mycompany.resurse.Directory;
import com.mycompany.service.BookmarksService;
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
    private BookmarksService bookmarksService;
    
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
    
    @RequestMapping(value ="bookmarks/add", method = RequestMethod.POST)
    @JsonView(BookmarksDto.getBookmarks.class)
    public ResponseEntity<?> addNewBookmarks(@Validated(BookmarksDto.addBookmarks.class) @RequestBody BookmarksDto bookmarksDto) {
        Favorite result = bookmarksService.add(modelMapper.map(bookmarksDto, Favorite.class));
        return new ResponseEntity<>(modelMapper.map(result, BookmarksDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="bookmarks/update", method = RequestMethod.POST)
    @JsonView(BookmarksDto.getBookmarks.class)
    public ResponseEntity<?> updateBookmarks(@Validated(BookmarksDto.updateBookmarks.class) @RequestBody BookmarksDto bookmarksDto) {
        Favorite result = bookmarksService.save(modelMapper.map(bookmarksDto, Favorite.class));
        return new ResponseEntity<>(modelMapper.map(result, BookmarksDto.class), HttpStatus.OK);
    }
    
    @RequestMapping(value ="bookmarks/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteDirectory(@Validated(DirectoryDto.deleteDirectory.class) @RequestBody BookmarksDto bookmarksDto) {
        boolean b = bookmarksService.delete(modelMapper.map(bookmarksDto, Favorite.class));
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @RequestMapping(value ="bookmarks/{id}", method = RequestMethod.GET)
    @JsonView(BookmarksDto.getBookmarks.class)
    public ResponseEntity<?> getBookmarksDirectory(@PathVariable Integer id) {
        List<BookmarksDto> result =  bookmarksService.findByDirectory(id).stream()
               .map(authority -> modelMapper.map(authority ,BookmarksDto.class))
               .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
