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

    public interface addPlacment {
    }

    public interface updatePlacment {
    }

    public interface deletePlacment {
    }

    public interface addGetPlacment {
    }

    public interface getPlacment extends addPlacment {
    }

    public interface getPlacmentSearach {
    }


    @Null(groups = {addPlacment.class})
    @NotNull(groups = {updatePlacment.class, LeaseDto.addLease.class})
    @JsonView({PictuteresDto.getPictures.class,addGetPlacment.class, getPlacmentSearach.class,getPlacment.class,  LeaseDto.getLeasePlacmentTenant.class, LeaseDto.getAddLease.class,LeaseDto.getLeaseTenant.class})
    private Integer idPlacement = null;

    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class, getPlacmentSearach.class,getPlacment.class, LeaseDto.getLeasePlacmentTenant.class,LeaseDto.getLeaseTenant.class})
    private String street;

    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class, getPlacmentSearach.class,getPlacment.class, LeaseDto.getLeasePlacmentTenant.class})
    private String house;

    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class, getPlacmentSearach.class,getPlacment.class, LeaseDto.getLeasePlacmentTenant.class})
    private int apartment;

    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class, getPlacmentSearach.class,getPlacment.class,  LeaseDto.getLeasePlacmentTenant.class})
    private int room;
    
    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class, getPlacmentSearach.class,getPlacment.class,  LeaseDto.getLeasePlacmentTenant.class})
    private Integer housing;

    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class})
    private boolean isActive;

    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class, getPlacmentSearach.class,getPlacment.class,  LeaseDto.getLeasePlacmentTenant.class})
    private float payDay;

    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class,getPlacment.class, LeaseDto.getLeasePlacmentTenant.class})
    private float payMonth;

    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class,getPlacment.class, LeaseDto.getLeasePlacmentTenant.class})
    private Integer children;

    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class,getPlacment.class,  LeaseDto.getLeasePlacmentTenant.class})
    private Integer adults;

    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class,getPlacment.class,  LeaseDto.getLeasePlacmentTenant.class})
    private String phonePlacment;

    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class,getPlacment.class, LeaseDto.getLeasePlacmentTenant.class})
    private String alternativePhonePlacement;
    
    @NotNull(groups = {addPlacment.class, updatePlacment.class})
    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class,getPlacment.class, LeaseDto.getLeasePlacmentTenant.class})
    private String profile;

    @Null(groups = {LeaseDto.addLease.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class,getPlacment.class, LeaseDto.getLeasePlacmentTenant.class})
    private Set<ComfortsDto> comfortses = new HashSet<>();

    @NotNull(groups = {addPlacment.class})
    @Null(groups = {updatePlacment.class})
    @JsonView({addGetPlacment.class,LeaseDto.getLeaseTenant.class,getPlacment.class, LeaseDto.getLeasePlacmentTenant.class})
    private CityDto city;

    @NotNull(groups = {addPlacment.class})
    @Null(groups = {updatePlacment.class})
    @JsonView({getPlacment.class,LeaseDto.getLeaseTenant.class, LeaseDto.getLeasePlacmentTenant.class})
    private LandlordDto landlord;

    @Null(groups = {addPlacment.class, updatePlacment.class})
    private LeaseDto lease;

    public PlacementDto() {
    }

    public PlacementDto(Integer idPlacement, String street, String house, int apartment, int room, boolean isActive, float payDay, float payMonth, Integer children, Integer adults, String phonePlacment, String alternativePhonePlacement,String profile,Integer housing, CityDto city, LandlordDto landlord, LeaseDto lease) {
        this.idPlacement = idPlacement;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.room = room;
        this.isActive = isActive;
        this.payDay = payDay;
        this.payMonth = payMonth;
        this.children = children;
        this.adults = adults;
        this.phonePlacment = phonePlacment;
        this.alternativePhonePlacement = alternativePhonePlacement;
        this.city = city;
        this.landlord = landlord;
        this.lease = lease;
        this.profile = profile;
        this.housing = this.housing;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getHousing() {
        return housing;
    }

    public void setHousing(Integer housing) {
        this.housing = housing;
    }

    
    
}
