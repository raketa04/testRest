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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */

@Entity
@Table(name = "tenant")
public class Tenant {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id_tenant")
    private Integer idTenant =-1;
    
    @Column (name = "last_name")
    private String lastName; 
    
    @Column (name = "first_name")
    private String firstName;
    
    @Column (name = "patronymic")
    private String patronymic;
    
    @Column (name = "phone")
    private String phone;
    
    @OneToOne
    @JoinColumn(name="account")
    private Account account;
    
    @OneToMany(mappedBy = "tenant", cascade=CascadeType.ALL,    orphanRemoval=true)
    private Set<Lease> leases = new HashSet<>();

    public Tenant() {
    }

    public Tenant(Integer idTentant, String lastName, String firstName, String patronymic, String phone, Account account) {
        this.idTenant = idTentant;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.account = account;
    }

    public Integer getIdTenant() {
        return idTenant;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public Account getAccount() {
        return account;
    }

    public Set<Lease> getLeases() {
        return leases;
    }

    public void setIdTenant(Integer idTenant) {
        this.idTenant = idTenant;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setLeases(Set<Lease> leases) {
        this.leases = leases;
    }
    
    public void addLease(Lease lease){
        lease.setTenant(this);
        getLeases().add(lease);
    }
    public void removeLease(Lease lease){
        getLeases().remove(lease);
    }
}
