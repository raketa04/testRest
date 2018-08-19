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
public class RegionDto {
    
    @JsonView({PlacementDto.addGetPlacment.class,PlacementDto.getPlacment.class,LeaseDto.getLeasePlacmentTenant.class,LeaseDto.getLeaseTenant.class})
    private Integer id = null;
    @JsonView({PlacementDto.addGetPlacment.class,PlacementDto.getPlacment.class,LeaseDto.getLeasePlacmentTenant.class,LeaseDto.getLeaseTenant.class})
    private String name;

    public RegionDto() {
    }

    public RegionDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
