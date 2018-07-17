package com.mycompany.resurse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "autority")
public class Authority  implements Serializable {

    @Id
    @Column(name = "id_autority")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_seq")
    @SequenceGenerator(name = "authority_seq", sequenceName = "authority_seq", allocationSize = 1)
    private int id;

    @Column(name = "name")
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @OneToMany(mappedBy = "type_role",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("type_role")
    Set<Account> account = new HashSet<>();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }
    
    
    
    /*
    public Account getUser() {
        return account.iterator().next();
    }

    public void setUser(Account account) {
        this.account.add(account);
    }
    */

    public void setAccount(Set<Account> account) {
        this.account = account;
    }

    public Set<Account> getAccount() {
        return account;
    }
    
    public void addAccount(Account account){
        account.setAuthority(this);
        getAccount().add(account);
    }
    public void removeAccount(Account account){
        getAccount().remove(account);
    }
    
}