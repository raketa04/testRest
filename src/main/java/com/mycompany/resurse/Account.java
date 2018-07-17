/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "account")
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_account")
    int idAccount = -1;
    
    @Column (name = "login")
    private String login;
    
    @Column (name = "password")
    private String password;
    
    
    @ManyToOne
    @JoinColumn(name = "type_role")
    Authority type_role;
    
    @Column (name = "activation")
    private boolean activation;
    
    // Add table tenant !!!!!!!1

    /*@OneToMany(mappedBy = "account", cascade=CascadeType.ALL,    orphanRemoval=true)
    Set<Landlords> landlord = new HashSet<Landlords>();
    */
    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActivation() {
        return activation;
    }

    public void setActivation(boolean activation) {
        this.activation = activation;
    }

    /*
    public Set<Landlords> getLandlord() {
        return landlord;
    }

    public void setLandlord(Set<Landlords> landlord) {
        this.landlord = landlord;
    }
       
    public void addLandlord(Landlords landlords){
        landlords.setAccount(this);
        getLandlord().add(landlords);
    }
    public void removeLandlord(Landlords landlords){
        getLandlord().remove(landlords);
    }
    */ 
    
    public Account() {
    }

    public Account(int idAccount, String login, String password, Authority typeRole, boolean activation) {
        this.idAccount = idAccount;
        this.login = login;
        this.password = password;
        this.type_role = typeRole;
        this.activation = activation;
        //this.landlord = landlord;
    }

    public Authority getAuthority() {
        return this.type_role;
    }

    public void setAuthority(Authority authority) {
        this.type_role= authority;
    }
   
    
    
}
