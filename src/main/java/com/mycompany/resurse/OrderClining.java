/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ADMIN
 */

@Entity
@Table(name = "order_clining")
public class OrderClining {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_order_clining")
    private Integer idOrderClining;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "date_create")
    private Date dateCreate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "date_compite")
    private Date dateComplite;
            
    @Column (name = "verified")       
    private boolean verified;
    
    @ManyToOne
    @JoinColumn(name = "clining_placement")
    private CliningCompanyPlacement cliningCompanyPlacement;
    
    @OneToMany(mappedBy = "orderClining", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Set<PicClining> picClinings = new HashSet<>();

    public OrderClining() {
    }

    public Integer getIdOrderClining() {
        return idOrderClining;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public Date getDateComplite() {
        return dateComplite;
    }

    public boolean isVerified() {
        return verified;
    }

    public CliningCompanyPlacement getCliningCompanyPlacement() {
        return cliningCompanyPlacement;
    }

    public Set<PicClining> getPicClinings() {
        return picClinings;
    }

    public void setIdOrderClining(Integer idOrderClining) {
        this.idOrderClining = idOrderClining;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public void setDateComplite(Date dateComplite) {
        this.dateComplite = dateComplite;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setCliningCompanyPlacement(CliningCompanyPlacement cliningCompanyPlacement) {
        this.cliningCompanyPlacement = cliningCompanyPlacement;
    }

    public void setPicClinings(Set<PicClining> picClinings) {
        this.picClinings = picClinings;
    }
    
    
}
