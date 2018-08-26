/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.PictuteresDao;
import com.mycompany.resurse.Pictuteres;
import com.mycompany.resurse.Placement;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
@Service
public class PicturesServiceImpl implements PicturesService{

    @Autowired
    PictuteresDao pictuteresDao ;
    
    @Override
    public List<Pictuteres> findByPlacement(Integer id) {
        return pictuteresDao.findByPlacement(id);
    }

    @Override
    public File findById(Integer id) {
        Pictuteres pictuteres = pictuteresDao.findById(id);
        File outputFile = new File(pictuteres.getAdressPic());
        /*inputStream = new FileInputStream(outputFile);
        byte[] bytes =  new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        String path = "F:\\123.jpg";
        File outputFiletemp = new File(path);
        outputFile.createNewFile();
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(outputFiletemp));
        writer.write(bytes);
        writer.flush();
        writer.close();
        
        return bytes;
        */
        return outputFile;
    }

    @Override
    public Pictuteres add(MultipartFile uploadedFileRef, Integer id) {
        try {
            String fileName = uploadedFileRef.getOriginalFilename();
            Random random = new Random();
            String cwd = System.getProperty("user.dir");
            String path = cwd  + fileName;
            byte[] bytes = uploadedFileRef.getBytes() ;
            File outputFile = new File(path);
            outputFile.createNewFile();
            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(outputFile));
            writer.write(bytes);
            writer.flush();
            writer.close();
            Placement p = new Placement();
            p.setIdPlacement(id);
            Pictuteres pic =new Pictuteres(null, path, p);
            return pictuteresDao.add(pic);
        } catch (IOException ex) {
            Logger.getLogger(PicturesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Pictuteres delete(Pictuteres pic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
