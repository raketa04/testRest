/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.repository.BookmarksRepository;
import com.mycompany.resurse.Favorite;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */

@Service
public class BookmarksServiceImpl implements BookmarksService{

    
    @Autowired
    BookmarksRepository bookmarksRepository;
    
    @Override
    public Favorite add(Favorite bookmarks) {
        return bookmarksRepository.save(bookmarks);
    }

    @Override
    public Favorite save(Favorite bookmarks) {
        return bookmarksRepository.save(bookmarks);
    }

    @Override
    public boolean delete(Favorite bookmarks) {
        bookmarksRepository.deleteById(bookmarks.getIdBookmarks());
        return true;
    }

    @Override
    public List<Favorite> findByDirectory(Integer idDirectory) {
        return bookmarksRepository.findByDirectory(idDirectory);
    }
    
}
