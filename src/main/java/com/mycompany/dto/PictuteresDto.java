/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

/**
 *
 * @author ADMIN
 */
public class PictuteresDto {
    private int idPicPlacement = -1;
    private String adressPic;

    public PictuteresDto(int idPicPlacement, String adressPic) {
        this.idPicPlacement = idPicPlacement;
        this.adressPic = adressPic;
    }

    public PictuteresDto() {
    }

    public String getAdressPic() {
        return adressPic;
    }

    public int getIdPicPlacement() {
        return idPicPlacement;
    }

    public void setAdressPic(String adressPic) {
        this.adressPic = adressPic;
    }

    public void setIdPicPlacement(int idPicPlacement) {
        this.idPicPlacement = idPicPlacement;
    }
    
    
}
