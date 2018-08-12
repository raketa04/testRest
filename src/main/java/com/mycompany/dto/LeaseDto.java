/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;


/**
 *
 * @author ADMIN
 */
public class LeaseDto {

    private Integer idLease = null;

    private Date startLease;

    private Date endLease;

    private TenantDto tenant;

    private PlacementDto placement;

    private FeedbackDto feedback;

    public LeaseDto() {
    }

    public LeaseDto(Integer idLease, Date startLease, Date endLease, TenantDto tenant, PlacementDto placement, FeedbackDto feedback) {
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

    public TenantDto getTenant() {
        return tenant;
    }

    public PlacementDto getPlacement() {
        return placement;
    }

    public FeedbackDto getFeedback() {
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

    public void setTenant(TenantDto tenant) {
        this.tenant = tenant;
    }

    public void setPlacement(PlacementDto placement) {
        this.placement = placement;
    }

    public void setFeedback(FeedbackDto feedback) {
        this.feedback = feedback;
    }
    
    
}