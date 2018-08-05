package com.mycompany.resurse;


import java.io.Serializable;

import static javax. persistence.GenerationType. IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;


import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "landlords")
public class Landlords {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_landlords")
    private long idLandlords =-1;
    
    @Column (name = "last_name")
    private String lastName; 
    
    @Column (name = "first_name")
    private String firstName;
    
    @Column (name = "patronymic")
    private String patronymic;
    
    @Column (name = "phone")
    private String phone;
    
    @OneToOne
    @JoinColumn(name="account")
    private Account account;
    
    @Column(name = "clining")
    private boolean clining;
    
    @OneToMany(mappedBy = "landlord", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Set<Placement> placements = new HashSet<>();

    public long getIdLandlords() {
        return idLandlords;
    }
    
    public void setIdLandlords(long idLandlords) {
        this.idLandlords = idLandlords;
    }
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getPatronymic() {
        return patronymic;
    }
     
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getClining() {
        return clining;
    }

    public void setClining(boolean clining) {
        this.clining = clining;
    }

    public Landlords() {
    }

    
    public Landlords(long idLandlords, String lastName, String firstName, String patronymic, String phone, Account account, boolean clining) {
        this.idLandlords = idLandlords;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.account = account;
        this.clining = clining;
    }
    
    

    public Set<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(Set<Placement> placements) {
        this.placements = placements;
    }
    
    public void addPlacement(Placement placement){
        placement.setLandlord(this);
        getPlacements().add(placement);
    }
    public void removePlacement(Placement placement){
        getPlacements().remove(placement);
    }
    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
       
    @Override
    public String toString() {
        return idLandlords + lastName + firstName + patronymic; //To change body of generated methods, choose Tools | Templates.
    }
    
}
