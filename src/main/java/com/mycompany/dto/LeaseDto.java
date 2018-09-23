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
    
    public interface getTempLease{
        
    }
    public interface getLeasePlacmentTenant{
        
    }
    
    public interface getLeaseTenant{
        
    }
    
    public interface getLeasePlacement{
        
    }
    
     public interface activateLease{
        
    }
    
    @Null(groups = {addLease.class})
    @NotNull(groups = {FeedbackDto.addFeedback.class,activateLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class,PlacementDto.getPlacementLease.class,getTempLease.class})
    private Integer idLease;
    
    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class,PlacementDto.getPlacementLease.class})
    private Long startLease;
    
    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class,PlacementDto.getPlacementLease.class})
    private Long endLease;
    
    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,PlacementDto.getPlacementLease.class})
    private Integer children;

    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,PlacementDto.getPlacementLease.class})
    private Integer adults;
    
    @Null(groups = {addLease.class,getAddLease.class})
    @NotNull(groups = {activateLease.class})
    private String codeActivate;
    
    @Null(groups = {addLease.class,getAddLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class,PlacementDto.getPlacementLease.class,getTempLease.class})
    private String codePlacement;

    private Long timeCreate;

    @Null(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeasePlacement.class,getLeaseTenant.class,PlacementDto.getPlacementLease.class,getTempLease.class})
    private AccountDto account;

    @NotNull(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getAddLease.class,getLeaseTenant.class,getTempLease.class})
    private PlacementDto placement;

    @Null(groups = {addLease.class})
    @JsonView({getLeasePlacmentTenant.class,getLeasePlacement.class,PlacementDto.getPlacementLease.class})
    private FeedbackDto feedback;

    public LeaseDto() {
    }

    public LeaseDto(Integer idLease, Long startLease, Long endLease, Integer children, Integer adults, String codeActivate, String codePlacement, AccountDto account, PlacementDto placement, FeedbackDto feedback) {
        this.idLease = idLease;
        this.startLease = startLease;
        this.endLease = endLease;
        this.children = children;
        this.adults = adults;
        this.codeActivate = codeActivate;
        this.codePlacement = codePlacement;
        this.account = account;
        this.placement = placement;
        this.feedback = feedback;
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
    
    public PlacementDto getPlacement() {
        return placement;
    }

    public FeedbackDto getFeedback() {
        return feedback;
    }

    public String getCodePlacement() {
        return codePlacement;
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

    public void setPlacement(PlacementDto placement) {
        this.placement = placement;
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

    public void setCodeActivate(String codeActivate) {
        this.codeActivate = codeActivate;
    }

    public String getCodeActivate() {
        return codeActivate;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public void setCodePlacement(String codePlacement) {
        this.codePlacement = codePlacement;
    }
    
    
    
}
