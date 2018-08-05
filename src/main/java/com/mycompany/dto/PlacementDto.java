/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class PlacementDto {

    private Integer idPlacement = null;

    private String street;

    private String house;

    private int apartment;
    
    private int room; 

    private boolean isActive;
    
    private float payDay;

    private float payMonth;

    private Integer childern;

    private float adults;
    
    private Set<ComfortsDto> comfortses = new HashSet<>();

    private CityDto city;
    
    private LandlordDto landlord;
    
    private LeaseDto lease;

    public PlacementDto(Integer idPlacement, String street, String house, int apartment, int room, boolean isActive, float payDay, float payMonth, Integer childern, float adults, CityDto city, LandlordDto landlord, LeaseDto lease) {
        this.idPlacement = idPlacement;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.room = room;
        this.isActive = isActive;
        this.payDay = payDay;
        this.payMonth = payMonth;
        this.childern = childern;
        this.adults = adults;
        this.city = city;
        this.landlord = landlord;
        this.lease = lease;
    }

    

    public PlacementDto() {
    }

    
    public Integer getIdPlacement() {
        return idPlacement;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public int getApartment() {
        return apartment;
    }

    public int getRoom() {
        return room;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public float getPayDay() {
        return payDay;
    }

    public float getPayMonth() {
        return payMonth;
    }

    public float getAdults() {
        return adults;
    }

    public Integer getChildern() {
        return childern;
    }
    
    public Set<ComfortsDto> getComfortses() {
        return comfortses;
    }

    public CityDto getCity() {
        return city;
    }

    public void setIdPlacement(Integer idPlacement) {
        this.idPlacement = idPlacement;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setPayDay(float payDay) {
        this.payDay = payDay;
    }

    public void setPayMonth(float payMonth) {
        this.payMonth = payMonth;
    }

    public void setAdults(float adults) {
        this.adults = adults;
    }

    public void setChildern(Integer childern) {
        this.childern = childern;
    }

    public void setComfortses(Set<ComfortsDto> comfortses) {
        this.comfortses = comfortses;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    public LandlordDto getLandlord() {
        return landlord;
    }

    public void setLandlord(LandlordDto landlord) {
        this.landlord = landlord;
    }

    public LeaseDto getLease() {
        return lease;
    }

    public void setLease(LeaseDto lease) {
        this.lease = lease;
    }
    
    
    
    
}
