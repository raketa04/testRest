/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Account;
import com.mycompany.resurse.City;
import com.mycompany.resurse.Comforts;
import com.mycompany.resurse.Placement;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        String hql = "FROM Placement p where p.city.region = "+idRegion;
	List<Placement> result =  entityManager.createQuery(hql,Placement.class).getResultList();
	return result;
    }

    @Override
    public List<Placement> findByCity(int idCity) {
        String hql = "FROM Placement p where p.city = "+idCity;
	List<Placement> result =  entityManager.createQuery(hql,Placement.class).getResultList();
	return result;
    }

    @Override
    public List<Placement> findByComforts(Set<Comforts> comfortses) {
        Iterator<Comforts> itr = comfortses.iterator();
        String parametr = "where ";
        while(itr.hasNext()){
            parametr += "c.idComforts ="+itr.next().getIdComforts();
            if (itr.hasNext())parametr +=  " and ";
        }
        
        String hql = "FROM Placement p left join fetch p.comfortses c "+ parametr;
	List<Placement> result =  entityManager.createQuery(hql,Placement.class).getResultList();
	return result;
    }

    @Override
    public Placement findById(int id) {
        return entityManager.find(Placement.class, id);
    }

    @Override
    public Placement save(Placement placement) {
        if(placement.getIdPlacement() == -1){
           entityManager.persist(placement);
        }
        else{
            Placement updatePlacement = entityManager.find(Placement.class,placement.getIdPlacement());
            //add update collums
            entityManager.merge(updatePlacement);
        }
        return placement;  
    }
    
}
