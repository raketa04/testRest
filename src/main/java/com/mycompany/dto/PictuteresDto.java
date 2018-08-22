/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.resurse.Placement;

/**
 *
 * @author ADMIN
 */
public class PictuteresDto {
    
    public interface getPictures {
    }
    
    @JsonView({getPictures.class})
    private Integer idPicPlacement = null;
    @JsonView({getPictures.class})
    private String adressPic;
    @JsonView({getPictures.class})
    private Placement placement;

    public PictuteresDto(Integer idPicPlacement, String adressPic, Placement placement) {
        this.idPicPlacement = idPicPlacement;
        this.adressPic = adressPic;
        this.placement = placement;
    }

    public Integer getIdPicPlacement() {
        return idPicPlacement;
    }

    public String getAdressPic() {
        return adressPic;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setIdPicPlacement(Integer idPicPlacement) {
        this.idPicPlacement = idPicPlacement;
    }

    public void setAdressPic(String adressPic) {
        this.adressPic = adressPic;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }
    
    
    
}
