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

    public interface update{
    }

    public interface autarificationIn  {
    }
    
    public interface autarificationOut  {
    }
    public interface token extends autarificationOut{
    }
    
    public interface activation  {
    }
    
    @Null(groups = {add.class , autarificationIn.class,})
    @NotNull(groups = {update.class,DirectoryDto.addDirectory.class})
    @JsonView({autarificationOut.class,PlacementDto.getPlacement.class,DirectoryDto.getDirectory.class})
    private Integer idAccount;
    
    @NotNull(groups = {add.class , autarificationIn.class})
    @Null(groups = {update.class})
    private String password;
    
    @NotNull(groups = {add.class , autarificationIn.class,update.class,activation.class})
    @JsonView({autarificationOut.class})
    private String email;
    
    @Null(groups = {autarificationIn.class})
    @NotNull(groups = {add.class ,update.class })
    @JsonView({autarificationOut.class})
    private AuthorityDto type_role;
    
    /*@Null(autarificationIn.class)
    @NotNull({New.class , update.class })
    private boolean activation;
    */
    @Null(groups = {add.class,update.class, autarificationIn.class})
    @NotNull(groups = {activation.class})
    private String codeActivate;
    
    
    @Null(groups = {add.class, update.class, autarificationIn.class,activation.class})
    @JsonView({token.class})
    private String token;
    
    @NotNull(groups = {add.class,update.class})
    @JsonView({autarificationOut.class,LeaseDto.getLeasePlacmentTenant.class,LeaseDto.getLeasePlacement.class,LeaseDto.getLeaseTenant.class})
    private String FIO;
    @NotNull(groups = {add.class,update.class})
    @JsonView({AccountDto.autarificationOut.class,LeaseDto.getLeasePlacmentTenant.class,LeaseDto.getLeasePlacement.class,LeaseDto.getLeaseTenant.class})
    private String phone;
   
    @Null(groups = {add.class, update.class, autarificationIn.class,activation.class})
    @JsonView({AccountDto.token.class,LeaseDto.getLeasePlacmentTenant.class,LeaseDto.getLeasePlacement.class,LeaseDto.getLeaseTenant.class})
    private AvatarDto avatar;
    public AccountDto() {
    }

    public AccountDto(Integer idAccount, String password, String email, AuthorityDto type_role, String codeActivate, String token, String FIO, String phone,AvatarDto avatar) {
        this.idAccount = idAccount;
        this.password = password;
        this.email = email;
        this.type_role = type_role;
        this.codeActivate = codeActivate;
        this.token = token;
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

    public AuthorityDto getType_role() {
        return type_role;
    }
/*
    public boolean isActivation() {
        return activation;
    }
*/

    public String getPhone() {
        return phone;
    }

    public String getFIO() {
        return FIO;
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

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public AvatarDto getAvatar() {
        return avatar;
    }

    public void setAvatar(AvatarDto avatar) {
        this.avatar = avatar;
    }
}
