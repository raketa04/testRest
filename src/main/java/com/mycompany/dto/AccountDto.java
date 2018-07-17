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
    int idAccount;
    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    AuthorityDto type_role;
    @NotNull
    private boolean activation;
    
    // Add table tenant !!!!!!!1

    /*
    Set<Landlords> landlord = new HashSet<Landlords>();
    */
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
    
    public AccountDto() {
    }

    public AccountDto(int idAccount, String login, String password, AuthorityDto typeRole, boolean activation) {
        this.idAccount = idAccount;
        this.login = login;
        this.password = password;
        this.type_role = typeRole;
        this.activation = activation;
        //this.landlord = landlord;
    }

    public AuthorityDto getAuthority() {
        return this.type_role;
    }

    public void setAuthority(AuthorityDto authority) {
        this.type_role= authority;
    }

}
