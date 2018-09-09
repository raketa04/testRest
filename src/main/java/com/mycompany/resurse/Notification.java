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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_notification")
    private Integer idNotification;
    
    @Column (name = "messege")
    private String messege;
    
    @Column (name = "type")
    private String type;
    
    @Column (name = "id")
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "time_create")
    private Date timeCreate;
    
    @Column (name = "is_send")
    private boolean isSend;
    
    @ManyToOne
    @JoinColumn(name="account")
    private Account account;

    public Notification() {
    }

    public Notification(Integer idNotification, String messege, String type, Integer id, Date timeCreate, boolean isSend, Account account) {
        this.idNotification = idNotification;
        this.messege = messege;
        this.type = type;
        this.id = id;
        this.timeCreate = timeCreate;
        this.isSend = isSend;
        this.account = account;
    }

    public Integer getIdNotification() {
        return idNotification;
    }

    public String getMessege() {
        return messege;
    }

    public String getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public boolean isIsSend() {
        return isSend;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setIsSend(boolean isSend) {
        this.isSend = isSend;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }
}
