/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.resurse.Notification;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface notificationService {
    public List<Notification> getNotification(Integer id);
}
