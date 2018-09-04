/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.resurse.AuthorityName;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ADMIN
 */
public class AuthorityDto {
    @NotNull(groups = {AccountDto.add.class, AccountDto.autarificationIn.class,AccountDto.update.class,AccountDto.activation.class})
    @Enumerated(EnumType.STRING)
    @JsonView({AccountDto.autarificationOut.class})
    private AuthorityName name;

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }
    
}
