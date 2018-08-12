/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 *
 * @author ADMIN
 */
public class PlacementDto {
    public interface addPlacment{
    }

    public interface updatePlacment{
    }
    
    public interface deletePlacment{
    }
     
    public interface addGetPlacment{
    }
    public interface getPlacment extends addPlacment{
    }
    
    public interface getPlacmentSearach{
    }
    
    public interface getPlacmentTenant{
    }

    @Null(groups ={addPlacment.class})
    @NotNull(groups ={updatePlacment.class,})
    @JsonView({addGetPlacment.class,getPlacmentSearach.class,getPlacmentTenant.class})
    private Integer idPlacement = null;

    @NotNull(groups ={addPlacment.class, updatePlacment.class})
    @JsonView({addGetPlacment.class,getPlacmentSearach.class,getPlacmentTenant.class})
    private String street;
    
    @NotNull(groups ={addPlacment.class, updatePlacment.class})
    @JsonView({addGetPlacment.class,getPlacmentSearach.class,getPlacmentTenant.class})
    private String house;
    
    @NotNull(groups ={addPlacment.class, updatePlacment.class})
    @JsonView({addGetPlacment.class,getPlacmentSearach.class,getPlacmentTenant.class})
    private int apartment;
    
    @NotNull(groups ={addPlacment.class, updatePlacment.class})
    @JsonView({addGetPlacment.class,getPlacmentSearach.class,getPlacmentTenant.class})
    private int room; 

    @NotNull(groups ={addPlacment.class, updatePlacment.class})
    @JsonView({addGetPlacment.class})
    private boolean isActive;
    
    @NotNull(groups ={addPlacment.class, updatePlacment.class})
    @JsonView({addGetPlacment.class,getPlacmentSearach.class,getPlacmentTenant.class})
    private float payDay;

    @NotNull(groups ={addPlacment.class, updatePlacment.class})
    @JsonView({addGetPlacment.class,getPlacmentTenant.class})
    private float payMonth;

    @NotNull(groups ={addPlacment.class, updatePlacment.class})
    @JsonView({addGetPlacment.class,getPlacmentTenant.class})
    private Integer childern;

    @NotNull(groups ={addPlacment.class, updatePlacment.class})
    @JsonView({addGetPlacment.class,getPlacmentTenant.class})
    private Integer adults;

    @NotNull(groups ={addPlacment.class, updatePlacment.class})
    @JsonView({addGetPlacment.class,getPlacmentTenant.class})
    private String phonePlacment;

    @NotNull(groups ={addPlacment.class, updatePlacment.class})
    @JsonView({addGetPlacment.class,getPlacmentTenant.class})
    private String alternativePhonePlacement;
    
    @JsonView({addGetPlacment.class,getPlacmentTenant.class})
    private Set<ComfortsDto> comfortses = new HashSet<>();

    @NotNull(groups ={addPlacment.class})
    @Null(groups ={updatePlacment.class})
    @JsonView({addGetPlacment.class,getPlacmentTenant.class})
    private CityDto city;
    
    @NotNull(groups ={addPlacment.class})
    @Null(groups ={updatePlacment.class})
    @JsonView({getPlacment.class,getPlacmentTenant.class})
    private LandlordDto landlord;
    
    @Null(groups ={addPlacment.class,updatePlacment.class})
    private LeaseDto lease;

    public PlacementDto() {
    }

    public PlacementDto(Integer idPlacement, String street, String house, int apartment, int room, boolean isActive, float payDay, float payMonth, Integer childern, Integer adults, String phonePlacment, String alternativePhonePlacement, CityDto city, LandlordDto landlord, LeaseDto lease) {
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
        this.phonePlacment = phonePlacment;
        this.alternativePhonePlacement = alternativePhonePlacement;
        this.city = city;
        this.landlord = landlord;
        this.lease = lease;
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

    public Integer getAdults() {
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

    public void setAdults(Integer adults) {
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

    public String getAlternativePhonePlacement() {
        return alternativePhonePlacement;
    }

    public String getPhonePlacment() {
        return phonePlacment;
    }

    public void setAlternativePhonePlacement(String alternativePhonePlacement) {
        this.alternativePhonePlacement = alternativePhonePlacement;
    }

    public void setPhonePlacment(String phonePlacment) {
        this.phonePlacment = phonePlacment;
    }
    
    
}
