/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ADMIN
 */
public class TypePlacamentDto {
    @NotNull(groups = {PlacementDto.addPlacment.class,PlacementDto.updatePlacment.class})
    @JsonView({PlacementDto.addGetPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class,LeaseDto.getLeasePlacmentTenant.class})
    private Integer idTypePlacament;
    @JsonView({PlacementDto.addGetPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class,LeaseDto.getLeasePlacmentTenant.class})
    private String nameType;

    public TypePlacamentDto() {
    }

    public TypePlacamentDto(Integer idTypePlacament, String nameType) {
        this.idTypePlacament = idTypePlacament;
        this.nameType = nameType;
    }

    public Integer getIdTypePlacament() {
        return idTypePlacament;
    }

    public String getNameType() {
        return nameType;
    }

    public void setIdTypePlacament(Integer idTypePlacament) {
        this.idTypePlacament = idTypePlacament;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
    
    
}
