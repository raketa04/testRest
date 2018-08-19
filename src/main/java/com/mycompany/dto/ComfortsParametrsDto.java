/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;

/**
 *
 * @author ADMIN
 */
public class ComfortsParametrsDto {
    
    @JsonView({PlacementDto.getPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacment.class,LeaseDto.getLeasePlacmentTenant.class})
    private Integer idComfortsParametrs = null;
    @JsonView({PlacementDto.getPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacment.class,LeaseDto.getLeasePlacmentTenant.class})
    private String parametr;

    public ComfortsParametrsDto() {
    }

    public ComfortsParametrsDto(Integer idComfortsParametrs, String parametr) {
        this.idComfortsParametrs = idComfortsParametrs;
        this.parametr = parametr;
    }

    public Integer getIdComfortsParametrs() {
        return idComfortsParametrs;
    }

    public String getParametr() {
        return parametr;
    }

    public void setIdComfortsParametrs(Integer idComfortsParametrs) {
        this.idComfortsParametrs = idComfortsParametrs;
    }

    public void setParametr(String parametr) {
        this.parametr = parametr;
    }

    
}
