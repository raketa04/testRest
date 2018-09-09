/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.NotificationDao;
import com.mycompany.resurse.Notification;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class notificationServiceImpl  implements  notificationService{

    @Autowired
    NotificationDao notification;
    
    @Override
    public List<Notification> getNotification(Integer id) {
        List<Notification> result = notification.getNotification(id);
        List<Integer> ids = null;
        for(Notification notification :result){
            ids.add(notification.getAccount().getIdAccount());
        }
        notification.deactivateNotification(ids);
        return result;
    }
    
}
