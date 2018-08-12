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
    
    @JsonView({PlacementDto.getPlacment.class})
    private Integer idComfortsParametrs = null;
    @JsonView({PlacementDto.getPlacment.class})
    private String parametrs;

    public ComfortsParametrsDto() {
    }

    public ComfortsParametrsDto(Integer idComfortsParametrs, String parametrs) {
        this.idComfortsParametrs = idComfortsParametrs;
        this.parametrs = parametrs;
    }

    public Integer getIdComfortsParametrs() {
        return idComfortsParametrs;
    }

    public String getParametrs() {
        return parametrs;
    }

    public void setIdComfortsParametrs(Integer idComfortsParametrs) {
        this.idComfortsParametrs = idComfortsParametrs;
    }

    public void setParametrs(String parametrs) {
        this.parametrs = parametrs;
    }

    
}
