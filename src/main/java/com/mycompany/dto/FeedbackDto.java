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
public class FeedbackDto {
    
    public interface addFeedback{
        
    }

    public interface editFeedback{
        
    }
    
    public interface getFeedback{
        
    }
    
    
    
    @Null(groups = {addFeedback.class})
    @NotNull(groups = {editFeedback.class})
    @JsonView({getFeedback.class,LeaseDto.getLeasePlacmentTenant.class,LeaseDto.getLeasePlacement.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class})
    private Integer idFeedback = null;
    
    @NotNull(groups = {addFeedback.class,editFeedback.class})
     @JsonView({getFeedback.class,LeaseDto.getLeasePlacmentTenant.class,LeaseDto.getLeasePlacement.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class})
    private String text;
    
    @NotNull(groups = {addFeedback.class,editFeedback.class})
    @JsonView({getFeedback.class,LeaseDto.getLeasePlacmentTenant.class,LeaseDto.getLeasePlacement.class,LeaseDto.getLeaseTenant.class,PlacementDto.getPlacement.class})
    private int rating;
    @NotNull(groups = {addFeedback.class})
    @Null(groups = {editFeedback.class})
    //@JsonView({getFeedback.class,LeaseDto.getLeasePlacmentTenant.class,LeaseDto.getLeasePlacement.class,LeaseDto.getLeaseTenant.class})
    LeaseDto lease;

    public FeedbackDto() {
    }

    public FeedbackDto(Integer idFeedback, String text, int rating, LeaseDto lease) {
        this.idFeedback = idFeedback;
        this.text = text;
        this.rating = rating;
        this.lease = lease;
    }

    public Integer getIdFeedback() {
        return idFeedback;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    public void setIdFeedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LeaseDto getLease() {
        return lease;
    }

    public void setLease(LeaseDto lease) {
        this.lease = lease;
    }
}
