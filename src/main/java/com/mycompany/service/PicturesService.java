/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Pictuteres;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
public interface PicturesService {
    List<Pictuteres> findByPlacement(Integer id);
    byte[] findById (Integer id);
    Pictuteres add(MultipartFile uploadedFileRef, Integer id);
    Pictuteres delete(Pictuteres pic);
}
