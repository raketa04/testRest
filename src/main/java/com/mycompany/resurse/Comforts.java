/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */

@Entity
@Table(name = "comforts")
public class Comforts implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_comforts")
    private Integer idComforts = null;
    
    @Column (name = "name")
    private String name;
    
    @ManyToMany
    @JoinTable(name = "Placement_has_comforts",
            joinColumns = @JoinColumn (name = "comforts_idcomforts"),
            inverseJoinColumns = @JoinColumn(name = "Placement_id_placement"))
    public Set<Placement> placements = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "group")
    private ComfortsGroup comfortsGroup;
    
    @ManyToOne
    @JoinColumn(name = "type")
    private TypeComforts typeComforts;
    
    public Comforts(Integer idComforts, String name,Set<Placement> placements,ComfortsGroup comfortsParametrs,TypeComforts typeComforts) {
        this.idComforts = idComforts;
        this.name = name;
        this.comfortsGroup = comfortsGroup;
        this.placements = placements;
        this.typeComforts = typeComforts;
    }

    public Comforts() {
    }

    
    public Integer getIdComforts() {
        return idComforts;
    }

    public void setIdComforts(Integer idComforts) {
        this.idComforts = idComforts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(Set<Placement> placements) {
        this.placements = placements;
    }

    public ComfortsGroup getComfortsGroup() {
        return comfortsGroup;
    }

    public void setComfortsGroup(ComfortsGroup comfortsGroup) {
        this.comfortsGroup = comfortsGroup;
    }

    public TypeComforts getTypeComforts() {
        return typeComforts;
    }

    public void setTypeComforts(TypeComforts typeComforts) {
        this.typeComforts = typeComforts;
    }
    
}
