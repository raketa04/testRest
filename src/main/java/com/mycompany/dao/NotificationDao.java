/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.resurse.Notification;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NotificationDao {
   public void addNotification(Notification notification);
   public List<Notification> getNotification(Integer id);
   public void deactivateNotification(List<Integer> id);
}
