/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.repository.BookmarksRepository;
import com.mycompany.resurse.Bookmarks;
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
    public Bookmarks add(Bookmarks bookmarks) {
        return bookmarksRepository.save(bookmarks);
    }

    @Override
    public Bookmarks save(Bookmarks bookmarks) {
        return bookmarksRepository.save(bookmarks);
    }

    @Override
    public boolean delete(Bookmarks bookmarks) {
        bookmarksRepository.deleteById(bookmarks.getIdBookmarks());
        return true;
    }

    @Override
    public List<Bookmarks> findByDirectory(Integer idDirectory) {
        return bookmarksRepository.findByDirectory(idDirectory);
    }
    
}
