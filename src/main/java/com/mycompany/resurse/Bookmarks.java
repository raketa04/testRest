/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "bookmarks")
public class Bookmarks implements Serializable {
     @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_bookmarks")
    private Integer idBookmarks;
    
    @Column (name = "name")
    private String name;
    
    @Column (name = "placement")
    private Integer placement;
    
    @ManyToOne
    @JoinColumn(name="directory")
    private Directory directory;

    public Bookmarks() {
    }

    public Bookmarks(Integer idBookmarks, String name, Integer placement, Directory directory) {
        this.idBookmarks = idBookmarks;
        this.name = name;
        this.placement = placement;
        this.directory = directory;
    }

    public Integer getIdBookmarks() {
        return idBookmarks;
    }

    public String getName() {
        return name;
    }

    public Integer getPlacement() {
        return placement;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setIdBookmarks(Integer idBookmarks) {
        this.idBookmarks = idBookmarks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlacement(Integer placement) {
        this.placement = placement;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }
    
    
}
