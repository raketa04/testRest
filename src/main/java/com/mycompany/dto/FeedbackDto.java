/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;

/**
 *
 * @author ADMIN
 */
public class FeedbackDto {
    
    private Integer idFeedback = null;
    private String text;
    private int rating;

    public FeedbackDto() {
    }

    public FeedbackDto(Integer idFeedback, String text, int rating) {
        this.idFeedback = idFeedback;
        this.text = text;
        this.rating = rating;
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
}
