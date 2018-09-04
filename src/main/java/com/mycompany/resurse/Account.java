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
    private Integer idAccount;
    
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

    @Column (name = "FIO")
    private String FIO; 
    
    @Column (name = "phone")
    private String phone;

    @OneToMany(mappedBy = "account", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Set<Placement> placements = new HashSet<>();

    @OneToMany(mappedBy = "account", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Set<Lease> leases = new HashSet<>();
    
    @OneToOne(mappedBy = "account", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Avatar avatar;
    
    public Account() {
    }

    public Account(Integer idAccount, String password, String email, Authority type_role, boolean activation, String codeActivate, String FIO, String phone, Avatar avatar) {
        this.idAccount = idAccount;
        this.password = password;
        this.email = email;
        this.type_role = type_role;
        this.activation = activation;
        this.codeActivate = codeActivate;
        this.FIO = FIO;
        this.phone = phone;
        this.avatar = avatar;
    }

    public Integer getIdAccount() {
        return idAccount;

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

    public void IdAccount(Integer idAccount) {
        this.idAccount = idAccount;
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

    public boolean isActivation() {
        return activation;
    }

    public String getFIO() {
        return FIO;
    }

    public String getPhone() {
        return phone;
    }

    public Set<Placement> getPlacements() {
        return placements;
    }

    public Set<Lease> getLeases() {
        return leases;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPlacements(Set<Placement> placements) {
        this.placements = placements;
    }

    public void setLeases(Set<Lease> leases) {
        this.leases = leases;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }   
}
