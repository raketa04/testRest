/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Pictuteres;
import java.io.File;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
public interface PicturesService {
    List<Pictuteres> findByPlacement(Integer id);
    File findById (Integer id);
    Pictuteres add(MultipartFile uploadedFileRef, Integer id);
    boolean delete(Integer idPictuteres);
}
