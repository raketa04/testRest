/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.CityDto;
import com.mycompany.dto.ComfortsDto;
import com.mycompany.dto.Search;
import com.mycompany.resurse.Comforts;
import com.mycompany.resurse.Lease;
import com.mycompany.resurse.Placement;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    
    @Override
    public List<Placement> findAll() {
        String hql = "FROM Placement";
	List<Placement> result =  entityManager.createQuery(hql,Placement.class).getResultList();
	return result;
    }

    @Override
    public List<Placement> findByRegion(int idRegion) {
        String hql = "FROM Placement p where isActive = true and p.city.region = "+idRegion;
	List<Placement> result =  entityManager.createQuery(hql,Placement.class).getResultList();
	return result;
    }

    @Override
    public List<Placement> findByCity(int idCity) {
        String hql = "FROM Placement p where isActive = true and p.city = "+idCity;
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
            if(updatePlacement.getCity() != placement.getCity()) updatePlacement.setCity(placement.getCity());
            if(!updatePlacement.getComfortses().equals(placement.getComfortses())) updatePlacement.setComfortses(placement.getComfortses());
            entityManager.merge(updatePlacement);
        }
        return placement;  
    }

    @Override
    public boolean delete(Placement placement) {
        entityManager.remove(placement);
        return true;
    }

    @Override
    public Placement invertState(Placement placement) {
        placement.setIsActive(!placement.isIsActive());
        entityManager.merge(placement);
        return placement;
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
    public List<Placement> findByDate(Lease lease) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Placement> findByParametr(Search search) {
        String hql = "FROM Placement p";
        boolean b = true;
        if(search.getCity().getId() != null) {
            if (b){
               hql += "where isActive = true and p.city = " + search.getCity().getId();
               b = !b;
            }
            else{
                if (search.getCity().getRegion().getId() != null){
                    if (b){
                        hql += "where isActive = true and p.city.region = "+search.getRegion().getId();
                        b = !b;
                    }
                }
            }
        }
        if(search.getAdults() != null ){
            if (b){
                hql += "where isActive = true and p.adults= "+search.getAdults();
                b = !b;
            }
            else{
                hql += " and p.adults= "+search.getAdults();
            }
        }
        
        if(search.getChildren()!= null ){
            if (b){
                hql += "where isActive = true and p.children= "+search.getChildren();
                b = !b;
            }
            else{
                hql += " and  p.children= "+search.getChildren();
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
        
        List<Placement> resultTemp =  entityManager.createQuery(hql,Placement.class).getResultList();
        List <Integer> id = new ArrayList<Integer>(); 
        for(Placement placement:resultTemp){
            int i = 0;
            for(ComfortsDto comf:search.getComforts()){
                for(Comforts comfPlacment:placement.getComfortses()){
                    if(comf.getIdComforts() == comfPlacment.getIdComforts()){
                        i++;
                    }   
                }
            }
            if(search.getComforts().size() == i){
                id.add(placement.getIdPlacement());
            }
        }
        String hql1 = "FROM Placement where isActive = true and idPlacement in (:ids)";
        Query query1 = (Query) entityManager.createQuery(hql1,Placement.class); 
        query1.setParameterList("ids", id);
        List <Placement> result = query1.getResultList();
	return result;
    }
    
}
