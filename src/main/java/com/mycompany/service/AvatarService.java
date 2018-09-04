/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Avatar;
import java.io.File;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
public interface AvatarService {
    File findById (Integer id);
    Avatar add(MultipartFile uploadedFileRef, Integer id);
    Avatar delete(Avatar avatar);
}
