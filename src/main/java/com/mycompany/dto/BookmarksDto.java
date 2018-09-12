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
public class BookmarksDto {
    
     public interface addBookmarks {
    }
    
    public interface deleteBookmarks{
    }
    
    public interface updateBookmarks{
    }
    
    public interface getBookmarks {
    }
    
    
    @Null(groups = {addBookmarks.class})
    @NotNull(groups = {updateBookmarks.class,deleteBookmarks.class})
    @JsonView({getBookmarks.class,DirectoryDto.getDirectory.class})
    private Integer idBookmarks;

    @NotNull(groups = {addBookmarks.class,updateBookmarks.class,deleteBookmarks.class})
    @JsonView({getBookmarks.class,DirectoryDto.getDirectory.class})
    private String name;
    @NotNull(groups = {addBookmarks.class,updateBookmarks.class,deleteBookmarks.class})
    @JsonView({getBookmarks.class,DirectoryDto.getDirectory.class})
    private Integer placement;
    
    @NotNull(groups = {addBookmarks.class,updateBookmarks.class})
    @Null(groups = {deleteBookmarks.class})
    @JsonView({getBookmarks.class})
    private DirectoryDto directory;

    public BookmarksDto() {
    }

    public BookmarksDto(Integer idBookmarks, String name, Integer placement, DirectoryDto directory) {
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

    public DirectoryDto getDirectory() {
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

    public void setDirectory(DirectoryDto directory) {
        this.directory = directory;
    }
    
    
    
}
