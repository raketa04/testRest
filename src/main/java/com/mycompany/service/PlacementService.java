/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dto.Search;
import com.mycompany.resurse.Comforts;
import com.mycompany.resurse.Placement;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public interface PlacementService {
    List<Placement> findAll();
    List<Placement> findByComforts(Set<Comforts> comfortses);
    List<Placement> findByParametr(Search search);
    Long findNumberByParametr(Search search);
    Placement findById(int id);
    Placement save(Placement placement);
    boolean delete(Placement placement);
}
