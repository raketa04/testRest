/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Comforts;
import com.mycompany.resurse.Placement;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public interface PlacementDao {
    List<Placement> findAll();
    List<Placement> findByRegion(int idRegion);
    List<Placement> findByCity(int idCity);
    List<Placement> findByComforts(Set<Comforts> comfortses);
    Placement findById(int id);
    Placement save(Placement placement);
}
