/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.mycompany.resurse.AuthorityName;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 *
 * @author ADMIN
 */
public class AuthorityDto {
    
    @Null
    private Integer id = null;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }
    
}
