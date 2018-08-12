/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author ADMIN
 */
public class TenantDto {

    private Integer idTenant = null;
    
    private String lastName; 
    
    private String firstName;

    private String patronymic;

    private String phone;

    private AccountDto account;

    private Set<LeaseDto> leases = new HashSet<>();

    public TenantDto() {
    }

    public TenantDto(Integer idTenant, String lastName, String firstName, String patronymic, String phone, AccountDto account) {
        this.idTenant = idTenant;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.account = account;
    }

    public Integer getIdTenant() {
        return idTenant;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public AccountDto getAccount() {
        return account;
    }

    public Set<LeaseDto> getLeases() {
        return leases;
    }

    public void setIdTenant(Integer idTenant) {
        this.idTenant = idTenant;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }

    public void setLeases(Set<LeaseDto> leases) {
        this.leases = leases;
    }
    
    
}
