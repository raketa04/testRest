/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Favorite;
import com.mycompany.resurse.Directory;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface BookmarksService {
    Favorite add(Favorite bookmarks);
    Favorite save(Favorite bookmarks);
    boolean  delete(Favorite bookmarks);
    List<Favorite> findByDirectory(Integer idDirectory);
}
