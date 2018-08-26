/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.resurse.Placement;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 *
 * @author ADMIN
 */
public class PictuteresDto {
    
    public interface addPictures {
    }
    
    public interface deletePictures {
    }
    
    public interface getPictures {
    }
    
    @NotNull(groups = {deletePictures.class})
    @JsonView({getPictures.class,PlacementDto.getPlacment.class,PlacementDto.getPlacmentSearach.class})
    private Integer idPicPlacement = null;

    public PictuteresDto(Integer idPicPlacement) {
        this.idPicPlacement = idPicPlacement;
    }

    public Integer getIdPicPlacement() {
        return idPicPlacement;
    }


    public void setIdPicPlacement(Integer idPicPlacement) {
        this.idPicPlacement = idPicPlacement;
    }

    public PictuteresDto() {
    }
    
    
    
}
