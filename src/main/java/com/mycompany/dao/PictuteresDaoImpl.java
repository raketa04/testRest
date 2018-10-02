/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Pictuteres;
import java.util.List;
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
public class PictuteresDaoImpl implements PictuteresDao{

    @PersistenceContext	
    private EntityManager entityManager;
    @Override
    public List<Pictuteres> findByPlacement(Integer id) {
        String hql = "FROM Pictuteres WHERE Pictuteres.placement.id_placement = " + id;
	List <Pictuteres> result =  entityManager.createQuery(hql,Pictuteres.class).getResultList();
	return result;
    }

    @Override
    public Pictuteres add(Pictuteres pic) {
        entityManager.persist(pic);
        return pic;
    }

    @Override
    public boolean delete(Pictuteres pic) {
        try{
            entityManager.remove(pic);
            return true;
        }
        catch(Exception ex){
            return false;
        }
        
    }

    @Override
    public Pictuteres findById(Integer id) {
       return entityManager.find(Pictuteres.class, id);
    }
    
}
