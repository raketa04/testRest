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
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */

@Entity
@Table(name = "clining_company")
public class CliningCompany implements Serializable {
     @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_clining_company")
    private Integer idCliningCompany;

    @Column (name = "password")
    private String password;
    
    @Column (name = "email")
    private String email;
    
    @Column (name = "company_name")
    private String companyName; 
    
    @Column (name = "phone")
    private String phone;
     
    
    @Column (name = "adress")
    private String adress;
    
    @OneToMany(mappedBy = "cliningCompany", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Set<CliningCompanyPlacement> cliningCompanyPlacements = new HashSet<>();

    public CliningCompany() {
    }

    public Integer getIdCliningCompany() {
        return idCliningCompany;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhone() {
        return phone;
    }


    public String getAdress() {
        return adress;
    }

    public Set<CliningCompanyPlacement> getCliningCompanyPlacements() {
        return cliningCompanyPlacements;
    }

    public void setIdCliningCompany(Integer idCliningCompany) {
        this.idCliningCompany = idCliningCompany;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCliningCompanyPlacements(Set<CliningCompanyPlacement> cliningCompanyPlacements) {
        this.cliningCompanyPlacements = cliningCompanyPlacements;
    }
    
    
}
