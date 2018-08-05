/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import javax.validation.constraints.NotNull;


/**
 *
 * @author ADMIN
 */

public class CityDto{

    private int id = -1;
    @NotNull
    private String name;
    @NotNull
    RegionDto region;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    public CityDto(int id, String name, RegionDto region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public CityDto() {
    }
    
    
    
}
