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
public class TypeComfortsDto {

    @JsonView({PlacementDto.addGetPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class,LeaseDto.getLeasePlacmentTenant.class})
    private Integer idTypeComforts = null;
    @JsonView({PlacementDto.addGetPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class,LeaseDto.getLeasePlacmentTenant.class})
    private String typeName;

    public TypeComfortsDto() {
    }

    
    public TypeComfortsDto(Integer idTypeComforts, String typeName) {
        this.idTypeComforts = idTypeComforts;
        this.typeName = typeName;
    }

    public Integer getIdTypeComforts() {
        return idTypeComforts;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setIdTypeComforts(Integer idTypeComforts) {
        this.idTypeComforts = idTypeComforts;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    
    
}
