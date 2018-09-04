/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.sql.Date;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class Search {
    CityDto city;   
    Date start;
    Date end;
    Set <ComfortsDto> comforts ;
    Integer adults;
    Integer children;
    String sorted;

    public Search(CityDto city, Date start, Date end, Set<ComfortsDto> comforts, Integer adults, Integer children,String sorted) {
        this.city = city;
        this.start = start;
        this.end = end;
        this.comforts = comforts;
        this.adults = adults;
        this.children = children;
        this.sorted = sorted;
    }

    public Search() {
    }

    public CityDto getCity() {
        return city;
    }


    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public Set<ComfortsDto> getComforts() {
        return comforts;
    }

    public Integer getAdults() {
        return adults;
    }

    public Integer getChildren() {
        return children;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setComforts(Set<ComfortsDto> comforts) {
        this.comforts = comforts;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public String getSorted() {
        return sorted;
    }

    public void setSorted(String sorted) {
        this.sorted = sorted;
    }

}
