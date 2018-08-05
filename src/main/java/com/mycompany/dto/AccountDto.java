/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 *
 * @author ADMIN
 */
public class AccountDto {
    @Null
    private int idAccount = -1;
    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    AuthorityDto type_role;
    @NotNull
    private boolean activation;
    // Add table tenant !!!!!!!1

    @NotNull
    private LandlordDto landlord;
    
    public long getIdAccount() {
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
    public AccountDto() {
    }

    public AccountDto(int idAccount, String login, String password, AuthorityDto typeRole, boolean activation, LandlordDto landlord) {
        this.idAccount = idAccount;
        this.login = login;
        this.password = password;
        this.type_role = typeRole;
        this.activation = activation;
        this.landlord = landlord;
    }

    public AuthorityDto getAuthority() {
        return this.type_role;
    }

    public void setAuthority(AuthorityDto authority) {
        this.type_role= authority;
    }

    public void setType_role(AuthorityDto type_role) {
        this.type_role = type_role;
    }

    public void setLandlord(LandlordDto landlord) {
        this.landlord = landlord;
    }

    public LandlordDto getLandlord() {
        return landlord;
    }
    
}
