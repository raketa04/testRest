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
import javax.persistence.OneToOne;

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
    private Integer idAccount = null;
    
    @Column (name = "login")
    private String login;
    
    @Column (name = "password")
    private String password;
    
    @Column (name = "email")
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "type_role")
    private Authority type_role;
    
    @Column (name = "activation")
    private boolean activation;
    
    @Column (name = "code_activate")
    private String codeActivate;

    @OneToOne(mappedBy = "account",  cascade = {CascadeType.ALL},  orphanRemoval=true)
    private Landlords landlord;
    
    @OneToOne(mappedBy = "account", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Tenant tenant;

    
    public Account() {
    }

    public Account(Integer idAccount, String login, String password, String email, Authority typeRole, boolean activation, Landlords landlord, Tenant tenant, String codeActivate) {
        this.idAccount = idAccount;
        this.login = login;
        this.password = password;
        this.email = email;
        this.type_role = typeRole;
        this.activation = activation;
        this.landlord = landlord;
        this.tenant = tenant;
        this.codeActivate = codeActivate;
    }

    public Integer getIdAccount() {
        return idAccount;

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Authority getType_role() {
        return type_role;
    }

    public boolean getActivation() {
        return activation;
    }

    public Landlords getLandlord() {
        return landlord;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void IdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType_role(Authority type_role) {
        this.type_role = type_role;
    }

    public void setActivation(boolean activation) {
        this.activation = activation;
    }

    public void setLandlord(Landlords landlord) {
        this.landlord = landlord;
    }
    
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodeActivate() {
        return codeActivate;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public void setCodeActivate(String codeActivate) {
        this.codeActivate = codeActivate;
    }

     
    
    
}
