/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;


/**
 *
 * @author ADMIN
 */


public class ComfortsDto implements Serializable {
    
    int idComforts = -1;
    String name;
    
    public ComfortsDto(int idComforts, String name) {
        this.idComforts = idComforts;
        this.name = name;
    }

    public ComfortsDto() {
    }

    public int getIdComforts() {
        return idComforts;
    }

    public void setIdComforts(int idComforts) {
        this.idComforts = idComforts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
}
