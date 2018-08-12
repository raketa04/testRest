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

    @PersistenceContext	
    private EntityManager entityManager;
    
    private String getStringParametrSearch(Search search){
        String hql = "";
        boolean b = true;
        if(search.getCity().getName() != null) {
            hql += "where isActive = true and p.city.nameCity Like '" + search.getCity().getName()+"%'";
            b = !b;
        }
        if(search.getAdults() != null ){
            if (b){
                hql += "where isActive = true and p.adults >= "+search.getAdults();
                b = !b;
            }
            else{
                hql += " and p.adults >= "+search.getAdults();
            }
        }
        
        if(search.getChildren()!= null ){
            if (b){
                hql += "where isActive = true and p.children >= "+search.getChildren();
                b = !b;
            }
            else{
                hql += " and  p.children >= "+search.getChildren();
            }
        }
         if(search.getStart() != null){
             if (b){
                hql += "where isActive = true and p.lease.startLease <= "+search.getStart();
                b = !b;
            }
            else{
                hql += " and p.lease.startLease <= "+search.getStart();
            }
         }
        if(search.getEnd()!= null){
             if (b){
                hql += "where isActive = true and p.lease.endLease => "+search.getEnd();
                b = !b;
            }
            else{
                hql += " and p.lease.endLease => "+search.getEnd();
            }
        }    
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
            if(!updatePlacement.getHouse().equals(placement.getHouse())) updatePlacement.setHouse(placement.getHouse());
            if(updatePlacement.getApartment() != placement.getApartment()) updatePlacement.setApartment(placement.getApartment());
            if(updatePlacement.getRoom()!= placement.getRoom()) updatePlacement.setRoom(placement.getRoom());
            if(updatePlacement.getPayDay()!= placement.getPayDay()) updatePlacement.setPayDay(placement.getPayDay());
            if(updatePlacement.getPayMonth()!= placement.getPayMonth()) updatePlacement.setPayMonth(placement.getPayMonth());
            if(updatePlacement.getAdults()!= placement.getAdults()) updatePlacement.setAdults(placement.getAdults());
            if(updatePlacement.getChildern()!= placement.getChildern()) updatePlacement.setChildern(placement.getChildern());
            if(!updatePlacement.getPhonePlacment().equals(placement.getPhonePlacment())) updatePlacement.setPhonePlacment(placement.getPhonePlacment());
            if(!updatePlacement.getAlternativePhonePlacement().equals(placement.getAlternativePhonePlacement())) updatePlacement.setAlternativePhonePlacement(placement.getAlternativePhonePlacement());
            if(!updatePlacement.getComfortses().equals(placement.getComfortses())) updatePlacement.setComfortses(placement.getComfortses());
            if(!updatePlacement.isIsActive() != placement.isIsActive()) updatePlacement.setIsActive(placement.isIsActive());
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
    public List<Placement> findByIdLandlord(int idLandlord) {
        String hql = "FROM Placement where Landlord.idLandlords = " + idLandlord;
	List<Placement> result =  entityManager.createQuery(hql,Placement.class).getResultList();
	return result;
    }



    @Override
    public List<Placement> findByParametr(Search search) {
        String hql = "FROM Placement p " + getStringParametrSearch(search);      
        List <Placement> result = entityManager.createQuery(hql,Placement.class).getResultList();
	return result;
    }

    @Override
    public Integer findNumberByParametr(Search search) {
        String hql = "FROM Placement p " + getStringParametrSearch(search);      
        Integer result = entityManager.createQuery(hql,Placement.class).getResultList().size();
	return result;
    }
    
}
