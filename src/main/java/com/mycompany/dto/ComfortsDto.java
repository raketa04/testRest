/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;


/**
 *
 * @author ADMIN
 */


public class ComfortsDto implements Serializable {
    
    @JsonView({PlacementDto.addGetPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class,LeaseDto.getLeasePlacmentTenant.class})
    private Integer idComforts = null;
    @JsonView({PlacementDto.addGetPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class,LeaseDto.getLeasePlacmentTenant.class})
    private String name;
    @JsonView({PlacementDto.addGetPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class,LeaseDto.getLeasePlacmentTenant.class})
    private ComfortsGroupDto comfortsGroup;
    @JsonView({PlacementDto.addGetPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class,LeaseDto.getLeasePlacmentTenant.class})
    private TypeComfortsDto typeComforts;
    
    public ComfortsDto(Integer idComforts, String name,ComfortsGroupDto comfortsParametrses,TypeComfortsDto typeComforts) {
        this.idComforts = idComforts;
        this.name = name;
        this.comfortsGroup = comfortsParametrses;
        this.typeComforts = typeComforts;
    }

    public ComfortsDto() {
    }

    public Integer getIdComforts() {
        return idComforts;
    }

    public void setIdComforts(Integer idComforts) {
        this.idComforts = idComforts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComfortsGroupDto getComfortsGroup() {
        return comfortsGroup;
    }

    public void setComfortsGroup(ComfortsGroupDto comfortsGroup) {
        this.comfortsGroup = comfortsGroup;
    }

    public TypeComfortsDto getTypeComforts() {
        return typeComforts;
    }

    public void setTypeComforts(TypeComfortsDto typeComforts) {
        this.typeComforts = typeComforts;
    }

}
