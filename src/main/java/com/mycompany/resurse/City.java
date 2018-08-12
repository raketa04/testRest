/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "city")
public class City implements Serializable{
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_city")
    private Integer idCity = null;

    @Column(name = "name_city")
    private String nameCity;
    
    @ManyToOne
    @JoinColumn(name = "region")
    private Region region;
    
    @OneToMany(mappedBy = "city", cascade=CascadeType.ALL)
    private Set<Placement> placements = new HashSet<>();

    public Integer getIdCity() {
        return idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public Region getRegion() {
        return region;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(Set<Placement> placements) {
        this.placements = placements;
    }
    
    public void addPlacement(Placement placement){
        placement.setCity(this);
        getPlacements().add(placement);
    }
    public void removePlacement(Placement placement){
        getPlacements().remove(placement);
    }
    
}
