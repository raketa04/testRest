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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "type_comforts")
public class TypeComforts {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_type_comforts")
    private Integer idTypeComforts = null;
    
    @Column (name = "type_name")
    private String typeName;
    
    @OneToMany (mappedBy = "typeComforts",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set <Comforts> comforts = new HashSet<> ();

    public TypeComforts(Integer idTypeComforts, String typeName,Set <Comforts> comforts) {
        this.idTypeComforts = idTypeComforts;
        this.typeName = typeName;
        this.comforts = comforts;
    }

    

    public TypeComforts() {
    }

    public Integer getIdTypeComforts() {
        return idTypeComforts;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setIdTypeComforts(Integer idTypeComforts) {
        this.idTypeComforts = idTypeComforts;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setComforts(Set<Comforts> comforts) {
        this.comforts = comforts;
    }

    public Set<Comforts> getComforts() {
        return comforts;
    }
}
