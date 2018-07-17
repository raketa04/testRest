/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;


import java.io.Serializable;
import static javax. persistence. GenerationType. IDENTITY;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Placement")
public class Placement implements Serializable{
    /**
	 * 
	 */
    int idPlacement, apartment, room;
    String city, street, house;
    Landlords landlord;
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_placement")
    public int getIdPlacement() {
        return idPlacement;
    }

    public void setIdPlacement(int idPlacement) {
        this.idPlacement = idPlacement;
    }

    @Column (name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column (name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column (name = "house")
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Column (name = "apartment")
    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Column (name = "room")
    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    //@ManyToOne
    //@JoinColumn(name="landlords")
    public Landlords getLandlords() {
        return landlord;
    }

    public void setLandlords(Landlords landlord) {
        this.landlord = landlord;
    }

}
