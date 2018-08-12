/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;



/**
 *
 * @author ADMIN
 */
public class TenantDto {

    @NotNull(groups = {AccountDto.updateTentant.class})
    @Null(groups = {AccountDto.addTentant.class})
    @JsonView({AccountDto.autarificationOut.class})
    private Integer idTenant = null;
    
    @NotNull(groups = {AccountDto.addTentant.class,AccountDto.updateTentant.class})
    @JsonView({AccountDto.autarificationOut.class})
    private String FIO;
    @NotNull(groups = {AccountDto.addTentant.class,AccountDto.updateTentant.class})
    @JsonView({AccountDto.autarificationOut.class})
    private String phone;

    private Set<LeaseDto> leases = new HashSet<>();

    public TenantDto() {
    }

    public TenantDto(Integer idTenant, String FIO, String phone) {
        this.idTenant = idTenant;
        this.FIO = FIO;
        this.phone = phone;
    }

    public Integer getIdTenant() {
        return idTenant;
    }

    public String getFIO() {
        return FIO;
    }

    public String getPhone() {
        return phone;
    }

    public Set<LeaseDto> getLeases() {
        return leases;
    }

    public void setIdTenant(Integer idTenant) {
        this.idTenant = idTenant;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLeases(Set<LeaseDto> leases) {
        this.leases = leases;
    }
    
    
}
