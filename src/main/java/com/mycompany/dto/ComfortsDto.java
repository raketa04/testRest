/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.Set;


/**
 *
 * @author ADMIN
 */


public class ComfortsDto implements Serializable {
    
    @JsonView({PlacementDto.addGetPlacment.class})
    private Integer idComforts = null;
    @JsonView({PlacementDto.addGetPlacment.class})
    private String name;
    @JsonView({PlacementDto.addGetPlacment.class})
    private Set <ComfortsParametrsDto> comfortsParametrses;
    
    public ComfortsDto(Integer idComforts, String name,Set <ComfortsParametrsDto> comfortsParametrses) {
        this.idComforts = idComforts;
        this.name = name;
        this.comfortsParametrses = comfortsParametrses;
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

    public Set<ComfortsParametrsDto> getComfortsParametrses() {
        return comfortsParametrses;
    }

    public void setComfortsParametrses(Set<ComfortsParametrsDto> comfortsParametrses) {
        this.comfortsParametrses = comfortsParametrses;
    }
   
}
