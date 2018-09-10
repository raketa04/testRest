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

public class CityDto{

    public interface findCity{
    }
    @Null(groups = {findCity.class})
    @JsonView({PlacementDto.addGetPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class,LeaseDto.getLeasePlacmentTenant.class})
    private Integer id = null;
    @NotNull(groups = {findCity.class})
    @JsonView({PlacementDto.addGetPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class,LeaseDto.getLeasePlacmentTenant.class})
    private String name;
    @Null(groups = {findCity.class})
    @JsonView({PlacementDto.addGetPlacment.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class,LeaseDto.getLeasePlacmentTenant.class})
    RegionDto region;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    public CityDto(Integer id, String name, RegionDto region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public CityDto() {
    }
    
    
    
}
