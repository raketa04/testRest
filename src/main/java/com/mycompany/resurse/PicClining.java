/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */

@Entity
@Table(name = "pic_clining")
public class PicClining {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_pic_clining")
    private Integer idPicClining ;
    
    @Column (name = "adress_pic")
    private String adressPic;
    
    @ManyToOne
    @JoinColumn(name = "order")
    private OrderClining orderClining;

    public PicClining() {
    }

    public Integer getIdPicClining() {
        return idPicClining;
    }

    public String getAdressPic() {
        return adressPic;
    }

    public OrderClining getOrderClining() {
        return orderClining;
    }

    public void setIdPicClining(Integer idPicClining) {
        this.idPicClining = idPicClining;
    }

    public void setAdressPic(String adressPic) {
        this.adressPic = adressPic;
    }

    public void setOrderClining(OrderClining orderClining) {
        this.orderClining = orderClining;
    }
    
    
}
