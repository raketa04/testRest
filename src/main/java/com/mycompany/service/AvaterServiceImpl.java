/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.AvatarDao;
import com.mycompany.resurse.Account;
import com.mycompany.resurse.Avatar;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class AvaterServiceImpl implements AvatarService{

    @Autowired
    AvatarDao avatarDao ;
    
    @Override
    public File findById(Integer id) {
        Avatar avatar = avatarDao.findById(id);
         File outputFile = new File(avatar.getAdress_avatar());
        return outputFile;
    }

    @Override
    public Avatar add(MultipartFile uploadedFileRef, Integer id) {
        String path = null;
        String fileName = uploadedFileRef.getOriginalFilename();
            Random random = new Random();
            String cwd = System.getProperty("user.dir");
            path = cwd  + "/src/main/resources/mavenproject.jpg";
            
        /*try {
            path = cwd  + fileName;
            byte[] bytes = uploadedFileRef.getBytes() ;
            File outputFile = new File(path);
            outputFile.createNewFile();
            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(outputFile));
            writer.write(bytes);
            writer.flush();
            writer.close();
            
            
    }   catch (IOException ex) {
            Logger.getLogger(AvatarServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        Account p = new Account();
        p.setIdAccount(id);
        Avatar avatar =new Avatar(null, path, p);
        return avatarDao.addAvatar(avatar);
    }
    
    @Override
    public Avatar delete(Avatar avatar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
