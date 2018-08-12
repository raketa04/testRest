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
public class LandlordDto {

    @NotNull(groups = {AccountDto.updateLandlord.class,PlacementDto.addPlacment.class})
    @Null(groups = {AccountDto.addLandlord.class})
    @JsonView({AccountDto.autarificationOut.class,PlacementDto.getPlacment.class})
    private Integer idLandlords = null;
    @NotNull(groups = {AccountDto.addLandlord.class ,AccountDto.updateLandlord.class})
    @JsonView({AccountDto.autarificationOut.class,PlacementDto.getPlacment.class})
    private String FIO;
    @NotNull(groups = {AccountDto.addLandlord.class ,AccountDto.updateLandlord.class})
    @JsonView({AccountDto.autarificationOut.class,PlacementDto.getPlacment.class})
    private String phone;
    @NotNull(groups = {AccountDto.addLandlord.class ,AccountDto.updateLandlord.class})
    @JsonView({AccountDto.autarificationOut.class,PlacementDto.getPlacment.class})
    private boolean clining;
    
    
    public LandlordDto() {
    }
    
    
    public Integer getIdLandlords() {
        return idLandlords;
    }
    
    public void setIdLandlords(Integer idLandlords) {
        this.idLandlords = idLandlords;
    }
    public String getFIO() {
        return FIO;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setClining(boolean clining) {
        this.clining = clining;
    }

    public boolean getClining() {
        return clining;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    
    public LandlordDto(Integer idLandlords, String FIO, String phone, boolean clining) {
        this.idLandlords = idLandlords;
        this.FIO = FIO;
        this.phone = phone;
        this.clining = clining;
    }
}
