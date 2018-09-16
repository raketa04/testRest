/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 *
 * @author ADMIN
 */
public class FavoriteDto {
    
     public interface addFavorite {
    }
    
    public interface deleteFavorite{
    }
    
    
    
    public interface getFavorite {
    }

    @NotNull(groups = {addFavorite.class,deleteFavorite.class})
    @JsonView({getFavorite.class})
    private Integer placement;
    
    @NotNull(groups = {addFavorite.class})
    @Null(groups = {deleteFavorite.class})
    @JsonView({getFavorite.class})
    private DirectoryDto directory;

    public FavoriteDto() {
    }

    public FavoriteDto( Integer placement, DirectoryDto directory) {
        this.placement = placement;
        this.directory = directory;
    }

    public Integer getPlacement() {
        return placement;
    }

    public DirectoryDto getDirectory() {
        return directory;
    }

    public void setPlacement(Integer placement) {
        this.placement = placement;
    }

    public void setDirectory(DirectoryDto directory) {
        this.directory = directory;
    }
}
