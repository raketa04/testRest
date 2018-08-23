/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_feedback")
    private Integer idFeedback = null;
    
    @Column (name = "text")
    private String text;
    
    @Column (name = "rating")
    private int rating;
    
    @OneToOne
    @JoinColumn(name = "lease")
    private Lease lease;

    public Feedback() {
    }

    public Feedback(Integer idFeedback, String text, int rating, Lease lease) {
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

    public Lease getLease() {
        return lease;
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

    public void setLease(Lease lease) {
        this.lease = lease;
    }
    
    
}
