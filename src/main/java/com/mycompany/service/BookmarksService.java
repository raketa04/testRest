/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Bookmarks;
import com.mycompany.resurse.Directory;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface BookmarksService {
    Bookmarks add(Bookmarks bookmarks);
    Bookmarks save(Bookmarks bookmarks);
    boolean  delete(Bookmarks bookmarks);
    List<Bookmarks> findByDirectory(Integer idDirectory);
}
