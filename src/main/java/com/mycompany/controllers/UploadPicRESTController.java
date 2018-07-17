/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.annotation.MultipartConfig;
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

public class UploadPicRESTController {
    
    @RequestMapping(method = RequestMethod.POST)
    public String uploadFile(@RequestParam("uploadedFiles") MultipartFile uploadedFileRef) throws IOException{
        if(uploadedFileRef.isEmpty()){
            String fileName = uploadedFileRef.getOriginalFilename();
            String path = "D:/" + fileName;
            byte[] bytes = uploadedFileRef.getBytes() ;
            File outputFile = new File(path);
            outputFile.createNewFile();
            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(outputFile));
            writer.write(bytes);
            writer.flush();
            writer.close();
        }
        /*
        add file name and addres file to  data base
        */
        return "File size";
    }
    /*
    @RequestMapping("/download")
    public String downloadFiles(@RequestParam("uploadedFile") MultipartFile uploadedFileRef) throws IOException{
        return "File size" + totalByte;
    }
    */

} 
