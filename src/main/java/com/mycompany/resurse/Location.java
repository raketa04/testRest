/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_location")
    private Integer idLocation = null;
    
    @Column (name = "lat")
    private double lat;
    
    @Column (name = "lng")
    private double lng;
    
    @OneToOne(mappedBy = "location", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Placement placement;

    public Location(Integer idLocation, double lat, double lng, Placement placement) {
        this.idLocation = idLocation;
        this.lat = lat;
        this.lng = lng;
        this.placement = placement;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    } 
}
