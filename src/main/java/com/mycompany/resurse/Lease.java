/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;


import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "lease")
public class Lease {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_lease")
    private Integer idLease = null;
    
    @Temporal(TemporalType.DATE)
    @Column (name = "start_lease")
    private Date startLease;
    
    @Temporal(TemporalType.DATE)
    @Column (name = "end_lease")
    private Date endLease;
    
    @Column (name = "children")
    private Integer children;
    
    @Column (name = "adults")
    private Integer adults;
    
    @ManyToOne
    @JoinColumn(name="account")
    private Account account;
    
    @ManyToOne
    @JoinColumn(name="placement")
    private Placement placementLease;
    
    @OneToOne(mappedBy = "lease", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Feedback feedback;

    public Lease() {
    }

    public Lease(Integer idLease, Date startLease, Date endLease, Integer children, Integer adults, Account account, Placement placement, Feedback feedback) {
        this.idLease = idLease;
        this.startLease = startLease;
        this.endLease = endLease;
        this.account = account;
        this.placementLease = placement;
        this.feedback = feedback;
        this.adults = adults;
        this.children = children;
    }

    

    public Integer getIdLease() {
        return idLease;
    }

    public Date getStartLease() {
        return startLease;
    }

    public Date getEndLease() {
        return endLease;
    }

    public Account getAccount() {
        return account;
    }

    

    public Placement getPlacementLease() {
        return placementLease;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setIdLease(Integer idLease) {
        this.idLease = idLease;
    }

    public void setStartLease(Date startLease) {
        this.startLease = startLease;
    }

    public void setEndLease(Date endLease) {
        this.endLease = endLease;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setPlacementLease(Placement placementLease) {
        this.placementLease = placementLease;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Integer getAdults() {
        return adults;
    }

    public Integer getChildren() {
        return children;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
