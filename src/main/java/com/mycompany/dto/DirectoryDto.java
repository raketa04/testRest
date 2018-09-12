/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 *
 * @author ADMIN
 */
public class DirectoryDto {

     public interface addDirectory {
    }
    
    public interface deleteDirectory{
    }
    
    public interface updateDirectory{
    }
    
    public interface getDirectory {
    }
    
    public interface getDirectoryAdd {
    }
    
    public interface getDirectoryUpdate{
    }
    
    @Null(groups = {addDirectory.class})
    @NotNull(groups = {updateDirectory.class,deleteDirectory.class,BookmarksDto.updateBookmarks.class})
    @JsonView({getDirectoryAdd.class,getDirectory.class,BookmarksDto.getBookmarks.class,getDirectoryUpdate.class})
    private Integer idDirectory = null;
    
    @NotNull(groups = {addDirectory.class,updateDirectory.class})
    @Null(groups = {deleteDirectory.class})
    @JsonView({getDirectoryAdd.class,getDirectory.class,getDirectoryUpdate.class})
    private String name;
    
    @Null(groups = {addDirectory.class,updateDirectory.class,deleteDirectory.class})
    @JsonView({getDirectory.class})
    private Set<BookmarksDto> bookmarkses;
    
    @NotNull(groups = {addDirectory.class})
    @Null(groups = {updateDirectory.class,deleteDirectory.class})
    @JsonView({getDirectoryAdd.class})
    private AccountDto account;

    public DirectoryDto() {
    }

    public DirectoryDto(Integer idDirectory, String name, Set<BookmarksDto> bookmarkses, AccountDto account) {
        this.idDirectory = idDirectory;
        this.name = name;
        this.bookmarkses = bookmarkses;
        this.account = account;
    }

    public Integer getIdDirectory() {
        return idDirectory;
    }

    public String getName() {
        return name;
    }

    public Set<BookmarksDto> getBookmarkses() {
        return bookmarkses;
    }

    public AccountDto getAccount() {
        return account;
    }

    public void setIdDirectory(Integer idDirectory) {
        this.idDirectory = idDirectory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBookmarkses(Set<BookmarksDto> bookmarkses) {
        this.bookmarkses = bookmarkses;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }

    
}
