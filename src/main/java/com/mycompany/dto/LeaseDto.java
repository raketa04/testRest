/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class,PlacementDto.getPlacement.class})
    private Integer idLease = null;
    
    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class,PlacementDto.getPlacement.class})
    private Long startLease;
    
    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class,PlacementDto.getPlacement.class})
    private Long endLease;
    
    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class,PlacementDto.getPlacement.class})
    private Integer children;

    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class,PlacementDto.getPlacement.class})
    private Integer adults;

    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,PlacementDto.getPlacement.class})
    private AccountDto account;

    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeaseTenant.class})
    private PlacementDto placementLease;

    @Null(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getLeasePlacement.class,getLeaseTenant.class,PlacementDto.getPlacement.class})
    private FeedbackDto feedback;

    public LeaseDto() {
    }

    public LeaseDto(Integer idLease, Long startLease,Long endLease, Integer children, Integer adults , AccountDto account, PlacementDto placement, FeedbackDto feedback) {
        this.idLease = idLease;
        this.startLease = startLease;
        this.endLease = endLease;
        this.account = account;
        this.placementLease = placement;
        this.feedback = feedback;
        this.adults = adults;
        this.children =children;
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

    public AccountDto getAccount() {
        return account;
    }

    public Integer getAdults() {
        return adults;
    }

    public Integer getChildren() {
        return children;
    }
    
    public PlacementDto getPlacementLease() {
        return placementLease;
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

    public void setAccount(AccountDto account) {
        this.account = account;
    }

    public void setPlacementLease(PlacementDto placementLease) {
        this.placementLease = placementLease;
    }

    public void setFeedback(FeedbackDto feedback) {
        this.feedback = feedback;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public void setChildern(Integer children) {
        this.children = children;
    }
    
    
}
