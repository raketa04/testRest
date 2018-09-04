/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Avatar;
import com.mycompany.resurse.Pictuteres;
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
public class AvatarDaoImpl implements AvatarDao{

    @PersistenceContext	
    private EntityManager entityManager;
    @Override
    public Avatar findById(Integer id) {
        return entityManager.find(Avatar.class, id);
    }

    @Override
    public Avatar addAvatar(Avatar avatar) {
        entityManager.persist(avatar);
        return avatar;
    }

    @Override
    public Avatar editAvatar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
