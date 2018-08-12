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
    private Integer idAccount = null;
    @NotNull
    private String login;
    @NotNull
    private String password;
            
    private String email;        
    AuthorityDto type_role;
    private boolean activation;
    private String codeActivate; 
    
    private LandlordDto landlord;
    
    private TenantDto tenant;
   
    public AccountDto() {
    }

    public AccountDto(Integer idAccount, String login, String password,String email, AuthorityDto typeRole, boolean activation, LandlordDto landlord, TenantDto tenant, String codeActivate) {
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

    public AuthorityDto getType_role() {
        return type_role;
    }

    public boolean isActivation() {
        return activation;
    }

    public LandlordDto getLandlord() {
        return landlord;
    }

    public TenantDto getTenant() {
        return tenant;
    }

    public String getCodeActivate() {
        return codeActivate;
    }
    
    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType_role(AuthorityDto type_role) {
        this.type_role = type_role;
    }

    public void setActivation(boolean activation) {
        this.activation = activation;
    }

    public void setLandlord(LandlordDto landlord) {
        this.landlord = landlord;
    }

    public void setTenant(TenantDto tenant) {
        this.tenant = tenant;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setCodeActivate(String codeActivate) {
        this.codeActivate = codeActivate;
    }
    
    
    
}
