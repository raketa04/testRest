/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "clining_company_placement")
public class CliningCompanyPlacement {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_clining_company_placement")
    private Integer idCliningCompanyPlacement;
    
    @OneToOne
    @JoinColumn (name = "placement")
    private Placement placement;
    
    @ManyToOne
    @JoinColumn(name = "clining_company")
    private CliningCompany cliningCompany;
    
    @OneToMany(mappedBy = "cliningCompanyPlacement", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Set<OrderClining> orderClinings = new HashSet<>();

    public CliningCompanyPlacement() {
    }

    public Integer getIdCliningCompanyPlacement() {
        return idCliningCompanyPlacement;
    }

    public Placement getPlacement() {
        return placement;
    }

    public CliningCompany getCliningCompany() {
        return cliningCompany;
    }

    public Set<OrderClining> getOrderClinings() {
        return orderClinings;
    }

    public void setIdCliningCompanyPlacement(Integer idCliningCompanyPlacement) {
        this.idCliningCompanyPlacement = idCliningCompanyPlacement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    public void setCliningCompany(CliningCompany cliningCompany) {
        this.cliningCompany = cliningCompany;
    }

    public void setOrderClinings(Set<OrderClining> orderClinings) {
        this.orderClinings = orderClinings;
    }
    
    
}
