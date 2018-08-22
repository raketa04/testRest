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
public class ComfortsGroupDto {
    
    @JsonView({PlacementDto.getPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacment.class,LeaseDto.getLeasePlacmentTenant.class})
    private Integer idComfortsGroup = null;
    @JsonView({PlacementDto.getPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacment.class,LeaseDto.getLeasePlacmentTenant.class})
    private String group;

    public ComfortsGroupDto() {
    }

    public ComfortsGroupDto(Integer idComfortsParametrs, String group) {
        this.idComfortsGroup = idComfortsParametrs;
        this.group = group;
    }

    public Integer getIdComfortsGroup() {
        return idComfortsGroup;
    }

    public String getGroup() {
        return group;
    }

    public void setIdComfortsGroup(Integer idComfortsGroup) {
        this.idComfortsGroup = idComfortsGroup;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    
}
