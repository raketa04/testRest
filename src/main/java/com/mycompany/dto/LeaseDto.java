/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


/**
 *
 * @author ADMIN
 */
public class LeaseDto {

    public interface addLease{
        
    }
    
    public interface getAddLease{
        
    }
    public interface getLeasePlacmentTenant{
        
    }
    
    public interface getLeaseTenant{
        
    }
    
    public interface getLeasePlacement{
        
    }
    
    @Null(groups = {addLease.class})
    @NotNull(groups = {FeedbackDto.addFeedback.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class})
    private Integer idLease = null;
    
    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class})
    private Long startLease;
    
    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class})
    private Long endLease;
    
    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class})
    private Integer childern;

    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class})
    private Integer adults;

    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class})
    private TenantDto tenant;

    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeaseTenant.class})
    private PlacementDto placement;

    @Null(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getLeasePlacement.class,getLeaseTenant.class})
    private FeedbackDto feedback;

    public LeaseDto() {
    }

    public LeaseDto(Integer idLease, Long startLease,Long endLease, Integer childern, Integer adults , TenantDto tenant, PlacementDto placement, FeedbackDto feedback) {
        this.idLease = idLease;
        this.startLease = startLease;
        this.endLease = endLease;
        this.tenant = tenant;
        this.placement = placement;
        this.feedback = feedback;
        this.adults = adults;
        this.childern =childern;
    }

    public Integer getIdLease() {
        return idLease;
    }

    public Long getStartLease() {
        return startLease;
    }

    public Long getEndLease() {
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

    public void setStartLease(Long startLease) {
        this.startLease = startLease;
    }

    public void setEndLease(Long endLease) {
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