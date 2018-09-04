/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Search;
import com.mycompany.resurse.Comforts;
import com.mycompany.resurse.Placement;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */

@Transactional
@Repository
public class PlacementDaoImpl implements PlacementDao{

    enum sorted{
        pay_day_ascending,
        pay_day_descending,
        rating_ascending,
        rating_descending,
        popularity_ascending,
        popularity_descending
    }
    @PersistenceContext	
    private EntityManager entityManager;
    
    private String getStringParametrSearch(Search search){
        String hql = "where p.isActive = true ";
        if(search.getCity().getId() != null) {
            hql += "and p.city.idCity = " + search.getCity().getId()+" ";
        }
        if(search.getAdults() != null ){
            hql += " and p.adults >= "+search.getAdults();
        }
        
        if(search.getChildren()!= null ){
            hql += " and p.children >= "+search.getChildren();
        }
        if(search.getStart()!= null || search.getEnd()!= null ){
            if(search.getStart()!= null && search.getEnd() == null){
                hql += " and p.idPlacement not in (Select l.placement From Lease l Where " +search.getStart() +" <= l.endLease)";
            }
            if(search.getStart() == null && search.getEnd() != null){
                hql += " and p.idPlacement not in (Select l.placement From Lease l Where " +search.getEnd()+" >= l.startLease )";
            }
            if(search.getStart()!= null && search.getEnd() != null){
                hql += " and p.idPlacement not in (Select l.placement From Lease l Where (l.startLease between '"+ search.getStart() + "' and '" + search.getEnd() +"') or (l.endLease between '"+ search.getStart() + "' and '" + search.getEnd() +"') or ('" + search.getStart() + "' between l.startLease and  l.endLease) or ('" + search.getEnd() + "' between l.startLease and  l.endLease))";
            }
        }
        if(search.getSorted().equals(sorted.pay_day_ascending.toString())) hql += " Order by p.payDay ASC";
        if(search.getSorted().equals(sorted.pay_day_descending.toString())) hql += " Order by p.payDay DESC";
        if(search.getSorted().equals(sorted.rating_ascending)) hql += " Order by ";
        if(search.getSorted().equals(sorted.rating_descending)) hql += " Order by ";
        if(search.getSorted().equals(sorted.popularity_ascending)) hql += " Order by ";
        if(search.getSorted().equals(sorted.popularity_descending)) hql += " Order by ";
        return hql;
    }
    @Override
    public List<Placement> findAll() {
        String hql = "FROM Placement";
	List<Placement> result =  entityManager.createQuery(hql,Placement.class).getResultList();
	return result;
    }

      @Override
    public List<Placement> findByComforts(Set<Comforts> comfortses) {
        String hql = "FROM Placement ";
        Query query = (Query) entityManager.createQuery(hql,Placement.class); 
        List <Placement> temp = query.getResultList();
        List <Integer> id = new ArrayList<Integer>(); 
        for(Placement placement:temp){
            int i = 0;
            for(Comforts comf:comfortses){
                for(Comforts comfPlacment:placement.getComfortses()){
                    if(comf.getIdComforts() == comfPlacment.getIdComforts()){
                        i++;
                    }   
                }
            }
            if(comfortses.size() == i){
                id.add(placement.getIdPlacement());
            }
        }
        String hql1 = "FROM Placement where isActive = true and idPlacement in (:ids)";
        Query query1 = (Query) entityManager.createQuery(hql1,Placement.class); 
        query1.setParameterList("ids", id);
        List <Placement> result = query1.getResultList();
	return result;
    }

    @Override
    public Placement findById(int id) {
        return entityManager.find(Placement.class, id);
    }

    @Override
    public Placement save(Placement placement) {
        if(placement.getIdPlacement() == null){
           entityManager.persist(placement);
        }
        else{
            Placement updatePlacement = entityManager.find(Placement.class,placement.getIdPlacement());
            if(!updatePlacement.getStreet().equals(placement.getStreet())) updatePlacement.setStreet(placement.getStreet());
            if(updatePlacement.getHouse() != placement.getHouse()) updatePlacement.setHouse(placement.getHouse());
            if(updatePlacement.getApartment() != placement.getApartment()) updatePlacement.setApartment(placement.getApartment());
            if(updatePlacement.getRoom()!= placement.getRoom()) updatePlacement.setRoom(placement.getRoom());
            if(updatePlacement.getPayDay()!= placement.getPayDay()) updatePlacement.setPayDay(placement.getPayDay());
            if(updatePlacement.getPayMonth()!= placement.getPayMonth()) updatePlacement.setPayMonth(placement.getPayMonth());
            if(updatePlacement.getAdults()!= placement.getAdults()) updatePlacement.setAdults(placement.getAdults());
            if(updatePlacement.getChildren() != placement.getChildren()) updatePlacement.setChildren(placement.getChildren());
            if(updatePlacement.getHousing() != placement.getHousing()) updatePlacement.setHousing(placement.getHousing());
            if(!updatePlacement.getPhonePlacment().equals(placement.getPhonePlacment())) updatePlacement.setPhonePlacment(placement.getPhonePlacment());
            if(!updatePlacement.getAlternativePhonePlacement().equals(placement.getAlternativePhonePlacement())) updatePlacement.setAlternativePhonePlacement(placement.getAlternativePhonePlacement());
            if(!updatePlacement.getComfortses().equals(placement.getComfortses())) updatePlacement.setComfortses(placement.getComfortses());
            if(!updatePlacement.isIsActive() != placement.isIsActive()) updatePlacement.setIsActive(placement.isIsActive());
            if(!updatePlacement.getContent().equals(placement.getContent())) updatePlacement.setContent(placement.getContent());
            if(!updatePlacement.getName().equals(placement.getName())) updatePlacement.setName(placement.getName());
            if(updatePlacement.getSleeping_area() != placement.getSleeping_area()) updatePlacement.setSleeping_area(placement.getSleeping_area());
            if(updatePlacement.getArea() != placement.getArea()) updatePlacement.setArea(placement.getArea());
            entityManager.merge(updatePlacement);
        }
        entityManager.flush();
        entityManager.clear();
        Placement result =  entityManager.find(Placement.class, placement.getIdPlacement());
        return result; 
    }

    @Override
    public boolean delete(Placement placement) {
        entityManager.remove(placement);
        return true;
    }
    
    @Override
    public List<Placement> findAllActive() {
        String hql = "FROM Placement where isActive = true";
	List<Placement> result =  entityManager.createQuery(hql,Placement.class).getResultList();
	return result;
    }

    @Override
    public List<Placement> findByIdAccount(int idLandlord) {
        String hql = "FROM Placement where Account.idAccount = " + idLandlord;
	List<Placement> result =  entityManager.createQuery(hql,Placement.class).getResultList();
	return result;
    }



    @Override
    public List<Placement> findByParametr(Search search, int page) {
        String hql = "FROM Placement p " ;
        hql += "" + getStringParametrSearch(search);
        Query query = (Query) entityManager.createQuery(hql,Placement.class);
        query.setFirstResult((page - 1) * 2);
        query.setMaxResults(2);
        List <Placement> result = query.getResultList();
	return result;
    }

    @Override
    public Long findNumberByParametr(Search search) {
        String hql = "Select count(p.idPlacement) FROM Placement p " + getStringParametrSearch(search);      
        Long result = (Long) entityManager.createQuery(hql).getSingleResult();
	return result;
    }
    
}
