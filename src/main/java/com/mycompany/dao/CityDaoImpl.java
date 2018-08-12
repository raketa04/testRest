/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Account;
import com.mycompany.resurse.City;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Transactional
@Repository
public class CityDaoImpl implements CityDao{

    @PersistenceContext	
    private EntityManager entityManager;
    @Override
    public City findById(int id) {
        return entityManager.find(City.class, id);
    }

    @Override
    public List<City> findAll() {
        String hql = "FROM City";
        System.out.println(hql);
	List<City> resultList =  entityManager.createQuery(hql,City.class).getResultList();
	return resultList;
    }

    @Override
    public City save(City city) {
        if(city.getIdCity() == -1){
           entityManager.persist(city);
        }
        else{
            City updateCity = entityManager.find(City.class,city.getIdCity());
            if(!updateCity.getNameCity().equals(city.getNameCity())) updateCity.setNameCity(city.getNameCity());
            if(!updateCity.getRegion().equals(city.getRegion())) updateCity.setRegion(city.getRegion());
            entityManager.merge(updateCity);
        }
        return city;
    }

    @Override
    public City remove(City city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<City> findByName(String name) {
        String hql = "FROM City Where nameCity Like '"+ name+ "%'" ;
        Query query = entityManager.createQuery(hql,City.class);
	List<City> resultList =  query.getResultList();
	return resultList;
    }
    
}
