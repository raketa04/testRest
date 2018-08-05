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
    
    private Integer id = null;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @OneToMany(mappedBy = "type_role", cascade = CascadeType.ALL,orphanRemoval = true)
    Set<Account> account = new HashSet<>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    public void setAccount(Set<Account> account) {
        this.account = account;
    }

    public Set<Account> getAccount() {
        return account;
    }
    
    public void addAccount(Account account){
        account.setType_role(this);
        getAccount().add(account);
    }
    public void removeAccount(Account account){
        getAccount().remove(account);
    }
    
}