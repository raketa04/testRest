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
    
    public interface updateFavorite{
    }
    
    public interface isFavorite{
    }
    
    public interface getFavorite {
    }
    
    
    @Null(groups = {addFavorite.class})
    @NotNull(groups = {updateFavorite.class,deleteFavorite.class})
    @JsonView({getFavorite.class,DirectoryDto.getDirectory.class})
    private Integer idFavorite;

    @NotNull(groups = {addFavorite.class,updateFavorite.class,deleteFavorite.class})
    @JsonView({getFavorite.class,DirectoryDto.getDirectory.class})
    private String name;
    @NotNull(groups = {addFavorite.class,updateFavorite.class,deleteFavorite.class})
    @JsonView({getFavorite.class,DirectoryDto.getDirectory.class,isFavorite.class})
    private Integer placement;
    
    @NotNull(groups = {addFavorite.class,updateFavorite.class})
    @Null(groups = {deleteFavorite.class})
    @JsonView({getFavorite.class,isFavorite.class})
    private DirectoryDto directory;

    public FavoriteDto() {
    }

    public FavoriteDto(Integer idFavorite, String name, Integer placement, DirectoryDto directory) {
        this.idFavorite = idFavorite;
        this.name = name;
        this.placement = placement;
        this.directory = directory;
    }

    public Integer getIdFavorite() {
        return idFavorite;
    }

    public String getName() {
        return name;
    }

    public Integer getPlacement() {
        return placement;
    }

    public DirectoryDto getDirectory() {
        return directory;
    }
    
    public void setIdFavorite(Integer idFavorite) {
        this.idFavorite = idFavorite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlacement(Integer placement) {
        this.placement = placement;
    }

    public void setDirectory(DirectoryDto directory) {
        this.directory = directory;
    }
    
    
    
}
