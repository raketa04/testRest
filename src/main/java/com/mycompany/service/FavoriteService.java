/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Account;
import com.mycompany.resurse.Favorite;
import com.mycompany.resurse.Placement;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface FavoriteService {
    Favorite add(Favorite bookmarks);
    boolean  delete(Favorite bookmarks);
    boolean  isFavorite(Integer placement, Account account);
    List<Placement> findByDirectory(Integer idDirectory);
}
