/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.ServerSpringApplication;
import com.mycompany.dto.Search;
import com.mycompany.resurse.Comforts;
import com.mycompany.resurse.Lease;
import com.mycompany.resurse.Placement;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
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
    
    enum sorted{
        pay_day_ascending,
        pay_day_descending,
        rating_ascending,
        rating_descending,
        popularity_ascending,
        popularity_descending
    }
    
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
                hql += " and p.idPlacement not in (Select l.placement From Lease l Where l.isand" +search.getStart() +" <= l.endLease)";
            }
            if(search.getStart() == null && search.getEnd() != null){
                hql += " and p.idPlacement not in (Select l.placement From Lease l Where " +search.getEnd()+" >= l.startLease )";
            }
            if(search.getStart()!= null && search.getEnd() != null){
                hql += " and p.idPlacement not in (Select l.placement From Lease l Where (l.startLease between '"+ search.getStart() + "' and '" + search.getEnd() +"') or (l.endLease between '"+ search.getStart() + "' and '" + search.getEnd() +"') or ('" + search.getStart() + "' between l.startLease and  l.endLease) or ('" + search.getEnd() + "' between l.startLease and  l.endLease))";
            }
        }
        return hql;
    }
    private String getStringOrderSearch(Search search){
        String hql = "";  
        if(search.getSorted() != null){
            if(search.getSorted().equals(sorted.pay_day_ascending.toString())) hql += " Order by p.payDay ASC";
            if(search.getSorted().equals(sorted.pay_day_descending.toString())) hql += " Order by p.payDay DESC";
            if(search.getSorted().equals(sorted.rating_ascending)) hql += " Order by ";
            if(search.getSorted().equals(sorted.rating_descending)) hql += " Order by ";
            if(search.getSorted().equals(sorted.popularity_ascending)) hql += " Order by ";
            if(search.getSorted().equals(sorted.popularity_descending)) hql += " Order by ";
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
        Placement placement = null;
        try{
            placement = entityManager.find(Placement.class, id);
            entityManager.flush();
            System.out.println(placement.getLeases().size());
        }
        finally{
            return placement;
        }
    }

    @Override
    public Placement save(Placement placement) {
        if(placement.getIdPlacement() == null){
           entityManager.persist(placement);
        }
        else{
              entityManager.merge(placement);
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
        
        
        try {
            String hql = "FROM Placement where Placement.account.idAccount = " + idLandlord;
            List<Placement> result =  entityManager.createQuery(hql,Placement.class).getResultList();
            return result;
        }
        catch (NullPointerException ex){
            return null;
        }
            
    }

    @Override
    public List<Placement> findByParametr(Search search, int page) {
        String hql = "FROM Placement p " + getStringParametrSearch(search);

        ArrayList<Integer> id = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : ServerSpringApplication.cache.asMap().entrySet()) {
            System.out.println(id.add(entry.getValue()));
        }
        for (Map.Entry<Integer, Lease> entry : ServerSpringApplication.cacheLease.asMap().entrySet()) {
            System.out.println(id.add(entry.getValue().getPlacement().getIdPlacement()));
        }
        if(id.size() > 0){
            hql += " and p.idPlacement not in (:place) ";  
        }
        hql += getStringOrderSearch(search); 
        System.out.println(hql);
        Query query = (Query) entityManager.createQuery(hql,Placement.class);
        if(id.size() > 0) query.setParameterList("place", id);       
        query.setFirstResult((page - 1) * 2);
        query.setMaxResults(2);
        List <Placement> result = query.getResultList();
	return result;
    }

    @Override
    public Long findNumberByParametr(Search search) {
        String hql = "FROM Placement p " + getStringParametrSearch(search); 
        ArrayList<Integer> id = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : ServerSpringApplication.cache.asMap().entrySet()) {
            System.out.println(id.add(entry.getValue()));
        }
        for (Map.Entry<Integer, Lease> entry : ServerSpringApplication.cacheLease.asMap().entrySet()) {
            System.out.println(id.add(entry.getValue().getPlacement().getIdPlacement()));
        }
        if(id.size() > 0){
            hql += " and p.idPlacement not in (:place) ";  
        }
        hql += getStringOrderSearch(search); 
	System.out.println(hql);   
        Query query = (Query) entityManager.createQuery(hql,Placement.class);
        if(id.size() > 0) query.setParameterList("place", id);  
        Long result =  (long) query.getResultList().size();
	return result;
    }

    @Override
    public List<Placement> findByIdPlacements(List<Integer> placements) {
        String hql = "FROM Placement p where p.idPlacement in (:place)";
        Query query = (Query) entityManager.createQuery(hql,Placement.class);
        query.setParameterList("place", placements);
        System.out.println(hql);
        List <Placement> result = query.getResultList();
	return result;
    }

}
