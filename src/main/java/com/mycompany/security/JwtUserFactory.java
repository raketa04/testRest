package com.mycompany.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.mycompany.resurse.Authority;
import com.mycompany.resurse.Account;
import java.util.ArrayList;
import java.util.Date;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(Account account) {
        ArrayList<Authority> temp = new ArrayList<Authority>();
        temp.add(account.getType_role());
        return new JwtUser(
                account.getIdAccount(),
                account.getLogin(),
                account.getPassword(),
                mapToGrantedAuthorities(temp),
                account.getActivation(),
                new Date(0)
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
