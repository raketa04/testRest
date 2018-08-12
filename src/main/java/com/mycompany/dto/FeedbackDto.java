/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

/**
 *
 * @author ADMIN
 */
public class FeedbackDto {
    
    private Integer idFeedback = null;
    private String text;
    private int rating;
    private LeaseDto leases;

    public FeedbackDto() {
    }

    public FeedbackDto(Integer idFeedback, String text, int rating, LeaseDto leases) {
        this.idFeedback = idFeedback;
        this.text = text;
        this.rating = rating;
        this.leases = leases;
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

    public LeaseDto getLeases() {
        return leases;
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

    public void setLeases(LeaseDto leases) {
        this.leases = leases;
    }
    
    
    
}
