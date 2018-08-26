/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.dto.PictuteresDto;
import com.mycompany.resurse.Pictuteres;
import com.mycompany.service.AccountService;
import com.mycompany.service.PicturesService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */

@RestController
@RequestMapping("file")

public class PicRESTController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PicturesService picturesService;
    
    @RequestMapping(value = "addPic",method = RequestMethod.POST)
    @JsonView(PictuteresDto.getPictures.class)
    public ResponseEntity <PictuteresDto> uploadFile(@RequestParam("uploadedFile") MultipartFile uploadedFileRef,@RequestParam("placement") Integer id) throws IOException{
        if(!uploadedFileRef.isEmpty()&& uploadedFileRef.getOriginalFilename().substring(uploadedFileRef.getOriginalFilename().lastIndexOf('.')+1).equals("jpg")){
            Pictuteres pictuteres = picturesService.add(uploadedFileRef, id);
            return new ResponseEntity<>(modelMapper.map(pictuteres, PictuteresDto.class),HttpStatus.OK);
        }
        else{
            return null;
        }
    }
    /*
    @RequestMapping("/download")
    public String downloadFiles(@RequestParam("uploadedFile") MultipartFile uploadedFileRef) throws IOException{
        return "File size" + totalByte;
    }
    

    @RequestMapping(value = "getPic/{id}",method = RequestMethod.GET)
     public ResponseEntity <byte[]> uploadFile(@PathVariable int id) throws IOException{  
        return new ResponseEntity<> (picturesService.findById(id), HttpStatus.OK);
    }
     */
    @RequestMapping(value = "getPic/{id}",method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> uploadFile(@PathVariable int id) throws IOException{
        String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory: " + cwd);
        File f = picturesService.findById(id);
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
    /*
    @RequestMapping(value = "deletePic/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<> deleteFile(@PathVariable int id) throws IOException{ 
        File f = picturesService.findById(id);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(f));
 
        return ResponseEntity.ok()
    }
*/
} 
