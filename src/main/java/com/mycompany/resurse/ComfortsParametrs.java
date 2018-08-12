/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "comforts_parametrs")
public class ComfortsParametrs {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_comforts_parametrs")
    private Integer idComfortsParametrs = null;
    
    @Column (name = "parametr")
    private String parametr;
    
    @JoinColumn(name = "comforts")
    private Comforts comforts;

    public ComfortsParametrs() {
    }

    public ComfortsParametrs(Integer idComfortsParametrs, String parametr, Comforts comforts) {
        this.idComfortsParametrs = idComfortsParametrs;
        this.parametr = parametr;
        this.comforts = comforts;
    }

    public Integer getIdComfortsParametrs() {
        return idComfortsParametrs;
    }

    public String getParametr() {
        return parametr;
    }

    public Comforts getComforts() {
        return comforts;
    }

    public void setIdComfortsParametrs(Integer idComfortsParametrs) {
        this.idComfortsParametrs = idComfortsParametrs;
    }

    public void setParametr(String parametr) {
        this.parametr = parametr;
    }

    public void setComforts(Comforts comforts) {
        this.comforts = comforts;
    }

    
    
}
