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
    
    @OneToMany(mappedBy = "comforts", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Set<ComfortsParametrs> comfortsParametrses = new HashSet<>();
    
    public Comforts(Integer idComforts, String name,Set<Placement> placements, Set <ComfortsParametrs> comfortsParametrs) {
        this.idComforts = idComforts;
        this.name = name;
        this.comfortsParametrses = comfortsParametrses;
        this.placements = placements;
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

    public Set<ComfortsParametrs> getComfortsParametrses() {
        return comfortsParametrses;
    }

    public void setComfortsParametrses(Set<ComfortsParametrs> comfortsParametrses) {
        this.comfortsParametrses = comfortsParametrses;
    }

    public void addComfortsParametrs(ComfortsParametrs comfortsParametrs){
        comfortsParametrs.setComforts(this);
        getComfortsParametrses().add(comfortsParametrs);
    }
    public void removeComfortsParametrs(ComfortsParametrs comfortsParametrs){
        getComfortsParametrses().remove(comfortsParametrs);
    }
}
