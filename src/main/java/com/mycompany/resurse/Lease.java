/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import java.util.Date;
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
    @Column (name = "id_tenant")
    private Integer idLease = null;
    
    @Temporal(TemporalType.DATE)
    @Column (name = "start_lease")
    private Date startLease;
    
    @Temporal(TemporalType.DATE)
    @Column (name = "end_lease")
    private Date endLease;
    
    @ManyToOne
    @JoinColumn(name="tenant")
    private Tenant tenant;
    
    @ManyToOne
    @JoinColumn(name="placement")
    private Placement placement;
    
    @OneToOne
    @JoinColumn(name="feedback")
    private Feedback feedback;

    public Lease() {
    }

    public Lease(Integer idLease, Date startLease, Date endLease, Tenant tenant, Placement placement, Feedback feedback) {
        this.idLease = idLease;
        this.startLease = startLease;
        this.endLease = endLease;
        this.tenant = tenant;
        this.placement = placement;
        this.feedback = feedback;
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

    public Tenant getTenant() {
        return tenant;
    }

    public Placement getPlacement() {
        return placement;
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

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}
