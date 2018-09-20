/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import java.io.Serializable;
import javax.persistence.CascadeType;
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
@Table(name = "favorite")
public class Favorite implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_favorite")
    private Integer idFavorite;
    
    
    @Column (name = "placement")
    private Integer placement;
    
    @ManyToOne
    @JoinColumn(name="directory" )
    private Directory directory;

    public Favorite() {
    }

    public Favorite(Integer idFavorite, Integer placement, Directory directory) {
        this.idFavorite = idFavorite;
        this.placement = placement;
        this.directory = directory;
    }

    public Integer getIdFavorite() {
        return idFavorite;
    }


    public Integer getPlacement() {
        return placement;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setIdFavorite(Integer idFavorite) {
        this.idFavorite = idFavorite;
    }


    public void setPlacement(Integer placement) {
        this.placement = placement;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }
    
    
}
