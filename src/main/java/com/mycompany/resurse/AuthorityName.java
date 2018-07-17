/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resurse;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author ADMIN
 */
public enum AuthorityName implements GrantedAuthority{
    ROLE_TENANT, ROLE_ADMIN, ROLE_LANDLORD, ROLE_CLINING;

    @Override
    public String getAuthority() {
        return name();
    }
}
