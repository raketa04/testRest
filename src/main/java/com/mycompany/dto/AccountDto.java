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
public class AccountDto {
    
    public interface add{
        
    }
    public interface addLandlord extends add{
    }
    public interface addTentant extends add{
    }

    public interface updateLandlord  {
    }
    
    public interface updateTentant{
    }


    public interface autarificationIn  {
    }
    
    public interface autarificationOut  {
    }
    public interface token extends autarificationOut{
    }
    
    public interface activation  {
    }
    
    @Null(groups = {addLandlord.class ,addTentant.class, autarificationIn.class})
    @NotNull(groups = {updateLandlord.class,updateTentant.class})
    @JsonView({autarificationOut.class})
    private Integer idAccount = null;
    
    @NotNull(groups = {addLandlord.class ,addTentant.class, autarificationIn.class})
    @Null(groups = {updateLandlord.class,updateTentant.class})
    private String password;
    
    @NotNull(groups = {addLandlord.class ,addTentant.class, autarificationIn.class,updateLandlord.class,updateTentant.class,activation.class})
    @JsonView({autarificationOut.class})
    private String email;
    
    @Null(groups = {autarificationIn.class,updateLandlord.class,updateTentant.class})
    @NotNull(groups = {addLandlord.class ,addTentant.class, })
    @JsonView({autarificationOut.class})
    private AuthorityDto type_role;
    
    /*@Null(autarificationIn.class)
    @NotNull({New.class , update.class })
    private boolean activation;
    */
    @Null(groups = {addLandlord.class ,addTentant.class, updateLandlord.class,updateTentant.class, autarificationIn.class})
    @NotNull(groups = {activation.class})
    private String codeActivate;
    
    
    @Null(groups = {addLandlord.class ,addTentant.class, updateLandlord.class,updateTentant.class, autarificationIn.class,activation.class})
    @JsonView({token.class})
    private String token;
    
    @Null(groups = {autarificationIn.class,addTentant.class , updateTentant.class})
    @NotNull(groups = {addLandlord.class , updateLandlord.class})
    @JsonView({autarificationOut.class})
    private LandlordDto landlord;
    
    @Null(groups = {autarificationIn.class, addLandlord.class , updateLandlord.class})
    @NotNull(groups = {addLandlord.class ,addTentant.class, updateLandlord.class,updateTentant.class})
    @JsonView({autarificationOut.class})
    private TenantDto tenant;
   
    
    public AccountDto() {
    }

    public AccountDto(Integer idAccount, String password,String email, AuthorityDto typeRole, boolean activation, LandlordDto landlord, TenantDto tenant, String codeActivate) {
        this.idAccount = idAccount;
        this.password = password;
        this.email = email;
        this.type_role = typeRole;
        //this.activation = activation;
        this.landlord = landlord;
        this.tenant = tenant;
        this.codeActivate = codeActivate;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public String getPassword() {
        return password;
    }

    public AuthorityDto getType_role() {
        return type_role;
    }
/*
    public boolean isActivation() {
        return activation;
    }
*/
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


    public void setType_role(AuthorityDto type_role) {
        this.type_role = type_role;
    }
/*
    public void setActivation(boolean activation) {
        this.activation = activation;
    }
*/
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
