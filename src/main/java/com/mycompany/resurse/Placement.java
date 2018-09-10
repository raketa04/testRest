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
import static javax. persistence. GenerationType. IDENTITY;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Placement")
public class Placement implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_placement")
    private Integer idPlacement;
    
    @Column (name = "street")
    private String street;
    
    @Column (name = "house")
    private int house;
    
    @Column (name = "apartment")
    private int apartment;
    
    @Column (name = "room")
    private int room; 
    
    @Column (name = "isActive")
    private boolean isActive;
    
    @Column (name = "pay_day")
    private float payDay;
    
    @Column (name = "pay_month")
    private float payMonth;
    
    @Column (name = "children")
    private Integer children;
    
    @Column (name = "adults")
    private Integer adults;
    
    @Column (name = "phone_placement")
    private String phonePlacment;
    
    @Column (name = "alternative_phone_placement")
    private String alternativePhonePlacement;
    
    @Column (name = "content")
    private String content;
    
    @Column (name = "housing")
    private String housing;
    
    @Column (name = "clining")
    private boolean clining;
    
    @Column (name = "sleeping_area")
    private Integer sleeping_area;
    
    @Column (name = "area")
    private Float area;
    
    @Column (name = "name")
    private String name;
    
    @ManyToMany
    @JoinTable(name = "Placement_has_comforts",
            joinColumns = @JoinColumn (name = "Placement_id_placement"),
            inverseJoinColumns = @JoinColumn(name = "comforts_idcomforts"))
    private Set<Comforts> comfortses;
    
    @ManyToOne()
    @JoinColumn(name="account")
    private Account account;

    @ManyToOne
    @JoinColumn(name="city")
    private City city;
    
    @OneToMany (mappedBy = "placement",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pictuteres> pictutereses;
    
    @OneToMany (mappedBy = "placement",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Lease> leases;
    
    @OneToOne
    @JoinColumn (name = "location")
    private Location location;
    
    public Integer getIdPlacement() {
        return idPlacement;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
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

    public Integer getChildren() {
        return children;
    }

    public Integer getAdults() {
        return adults;
    }
    
    

    public float getPayMonth() {
        return payMonth;
    }

    public City getCity() {
        return city;
    }
    
    public Set<Comforts> getComfortses() {
        return comfortses;
    }

    public Account getAccount() {
        return account;
    }

    public Location getLocation() {
        return location;
    }

    public Float getArea() {
        return area;
    }

    public Integer getSleeping_area() {
        return sleeping_area;
    }

    public boolean getClining() {
        return clining;
    }

    public Placement(Integer idPlacement, String street, int house, int apartment, int room, boolean isActive, float payDay, float payMonth, Integer children, Integer adults, String phonePlacment, String alternativePhonePlacement, String content, String housing, boolean clining, Integer sleeping_area, Float area, String name, Set<Comforts> comfortses, Account account, City city, Set<Pictuteres> pictutereses, Set<Lease> leases, Location location) {
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
        this.content = content;
        this.housing = housing;
        this.clining = clining;
        this.sleeping_area = sleeping_area;
        this.area = area;
        this.name = name;
        this.comfortses = comfortses;
        this.account = account;
        this.city = city;
        this.pictutereses = pictutereses;
        this.leases = leases;
        this.location = location;
    }

   


    public void setIdPlacement(Integer idPlacement) {
        this.idPlacement = idPlacement;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(int house) {
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

    public void setComfortses(Set<Comforts> comfortses) {
        this.comfortses = comfortses;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCity(City city) {
        this.city = city;
    }   

    public Set<Pictuteres> getPictutereses() {
        return pictutereses;
    }

    public void setPictutereses(Set<Pictuteres> pictutereses) {
        this.pictutereses = pictutereses;
    }

    public void addPictuteres(Pictuteres pictuteres){
        pictuteres.setPlacement(this);
        getPictutereses().add(pictuteres);
    }
    public void removePlacement(Pictuteres pictuteres){
        getPictutereses().remove(pictuteres);
    }

    public Set<Lease> getLeases() {
        return leases;
    }

    public void setLeases(Set<Lease> leases) {
        this.leases = leases;
    }

    public void addLease(Lease lease){
        lease.setPlacement(this);
        getLeases().add(lease);
    }
    public void removeLease(Lease lease){
        getLeases().remove(lease);
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public void setArea(Float area) {
        this.area = area;
    }

    public void setClining(boolean clining) {
        this.clining = clining;
    }

    public void setSleeping_area(Integer sleeping_area) {
        this.sleeping_area = sleeping_area;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }
        
    
    public Placement() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
