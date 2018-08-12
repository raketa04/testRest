/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;



/**
 *
 * @author ADMIN
 */
public class LandlordDto {

    private Integer idLandlords = null;
    private String lastName; 
    private String firstName;
    private String patronymic;
    private String phone;
    private boolean clining;
    
    
    public LandlordDto() {
    }
    
    
    public Integer getIdLandlords() {
        return idLandlords;
    }
    
    public void setIdLandlords(Integer idLandlords) {
        this.idLandlords = idLandlords;
    }
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getPatronymic() {
        return patronymic;
    }
     
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setClining(boolean clining) {
        this.clining = clining;
    }

    public boolean getClining() {
        return clining;
    }

    public LandlordDto(Integer idLandlords, String lastName, String firstName, String patronymic, String phone, boolean clining) {
        this.idLandlords = idLandlords;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.clining = clining;
    }
    
    
       
    @Override
    public String toString() {
        return idLandlords + lastName + firstName + patronymic; //To change body of generated methods, choose Tools | Templates.
    }
}
