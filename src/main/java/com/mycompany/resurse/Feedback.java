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
    
    @OneToOne(mappedBy = "feedback",cascade = CascadeType.ALL, orphanRemoval = true)
    private Lease leases;

    public Feedback() {
    }

    public Feedback(Integer idFeedback, String text, int rating, Lease leases) {
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

    public Lease getLeases() {
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

    public void setLeases(Lease leases) {
        this.leases = leases;
    }
    
    
}
