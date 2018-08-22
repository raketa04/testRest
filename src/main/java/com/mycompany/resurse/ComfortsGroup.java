/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "comforts_group")
public class ComfortsGroup {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_comforts_group")
    private Integer idComfortsGroup = null;
    
    @Column (name = "group")
    private String group;
    
    @OneToMany (mappedBy = "comfortsGroup",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set <Comforts> comforts = new HashSet<> ();

    public ComfortsGroup() {
    }

    public ComfortsGroup(Integer idComfortsParametrs, String group, Set <Comforts> comforts) {
        this.idComfortsGroup = idComfortsParametrs;
        this.group = group;
        this.comforts = comforts;
    }

    public Integer getIdComfortsGroup() {
        return idComfortsGroup;
    }

    public String getGroupgetGroup() {
        return group;
    }

    public Set <Comforts> getComforts() {
        return comforts;
    }

    public void setIdComfortsGroup(Integer idComfortsGroup) {
        this.idComfortsGroup = idComfortsGroup;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setComforts(Set <Comforts> comforts) {
        this.comforts = comforts;
    }

    public void addComforts(Comforts comforts){
        comforts.setComfortsGroup(this);
        getComforts().add(comforts);
    }
    public void removePlacement(Comforts comforts){
        getComforts().remove(comforts);
    }
    
}
