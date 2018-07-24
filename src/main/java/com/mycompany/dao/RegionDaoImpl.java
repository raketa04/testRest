/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Account;
import com.mycompany.resurse.City;
import com.mycompany.resurse.Region;
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
public class RegionDaoImpl implements  RegionDao{

    @PersistenceContext	
    private EntityManager entityManager;

    @Override
    public List<Region> findAll() {
        String hql = "FROM Region";
        System.out.println(hql);
	return entityManager.createQuery(hql,Region.class).getResultList();
    }

    @Override
    public List<City> getCityByRegion(int idRegion) {
        String hql = "FROM City WHERE region = " + idRegion ;
        return entityManager.createQuery(hql,City.class).getResultList();
    }
    
}
