/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import java.io.Serializable;
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
@Table(name = "avatar")
public class Avatar implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_avatar")
    private Integer idAvatar;
    
    @Column (name = "adress_avatar")
    private String adress_avatar;
    
    @OneToOne
    @JoinColumn (name = "account")
    private Account account;

    public Avatar() {
    }

    
    public Avatar(Integer idAvatar, String adress_avatar, Account account) {
        this.idAvatar = idAvatar;
        this.adress_avatar = adress_avatar;
        this.account = account;
    }

    public Integer getIdAvatar() {
        return idAvatar;
    }

    public String getAdress_avatar() {
        return adress_avatar;
    }

    public Account getAccount() {
        return account;
    }

    public void setIdAvatar(Integer idAvatar) {
        this.idAvatar = idAvatar;
    }

    public void setAdress_avatar(String adress_avatar) {
        this.adress_avatar = adress_avatar;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
 
}
