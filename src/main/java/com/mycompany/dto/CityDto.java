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

public class CityDto{

    @JsonView({PlacementDto.addGetPlacment.class})
    private Integer id = null;
    @JsonView({PlacementDto.addGetPlacment.class})
    private String name;
    @JsonView({PlacementDto.addGetPlacment.class})
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
