/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "type_placement")
public class TypePlacament {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_type_placement")
    private Integer idTypePlacament;
    
    @Column (name = "name_type")
    private String nameType;
    
    @OneToMany (mappedBy = "typePlacament",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Placement> placements;

    public TypePlacament() {
    }

    public TypePlacament(Integer idTypePlacament, String nameType, Set<Placement> placements) {
        this.idTypePlacament = idTypePlacament;
        this.nameType = nameType;
        this.placements = placements;
    }

    public Integer getIdTypePlacament() {
        return idTypePlacament;
    }

    public String getNameType() {
        return nameType;
    }

    public Set<Placement> getPlacements() {
        return placements;
    }

    public void setIdTypePlacament(Integer idTypePlacament) {
        this.idTypePlacament = idTypePlacament;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public void setPlacements(Set<Placement> placements) {
        this.placements = placements;
    }
}
