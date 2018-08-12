/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import com.mycompany.dao.PlacementDao;
import javax.persistence.CascadeType;
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
@Table(name = "picplacement")
public class Pictuteres {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_pic_placement")
    private Integer idPicPlacement = null;
    
    @Column (name = "adress_pic")
    private String adressPic;
    
    @ManyToOne
    @JoinColumn (name = "placement")
    private Placement placement;

    public Pictuteres(Integer idPicPlacement, String adressPic, Placement placement) {
        this.idPicPlacement = idPicPlacement;
        this.adressPic = adressPic;
        this.placement = placement;
    }

    public Pictuteres() {
    }

    public Integer getIdPicPlacement() {
        return idPicPlacement;
    }

    public String getAdressPic() {
        return adressPic;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setIdPicPlacement(Integer idPicPlacement) {
        this.idPicPlacement = idPicPlacement;
    }

    public void setAdressPic(String adressPic) {
        this.adressPic = adressPic;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    
    
}
