/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "directory")
public class Directory implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_directory")
    private Integer idDirectory;
    
    @Column (name = "name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name="account")
    private Account account;
    
    @OneToMany(mappedBy = "directory", cascade=CascadeType.REMOVE,    orphanRemoval=true)
    private Set<Favorite> favorites = new HashSet<>();

    public Directory() {
    }

    public Directory(Integer idDirectory, String name, Account account) {
        this.idDirectory = idDirectory;
        this.name = name;
        this.account = account;
    }

    public Integer getIdDirectory() {
        return idDirectory;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setIdDirectory(Integer idDirectory) {
        this.idDirectory = idDirectory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(Account account) {
        this.account = account;
    } 

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }
    
    
}
