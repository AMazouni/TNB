package com.example.demo.service.impl;

import com.example.demo.bean.NotificationType;
import com.example.demo.dao.NotificationTypeDao;
import com.example.demo.service.facade.NotificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationTypeServiceImpl implements NotificationTypeService {

    @Autowired
    NotificationTypeDao notificationTypeDao;


    @Override
    public NotificationType findByNumero(int numero) {
        return notificationTypeDao.findByNumero(numero);
    }

    @Override
    public NotificationType findById(Long id) {
        return notificationTypeDao.findByid(id);
    }

    @Override
    public void initNotificationType() {
        if (notificationTypeDao.findByNumero(1) == null && notificationTypeDao.findByNumero(3) == null && notificationTypeDao.findByNumero(2) == null) {
            notificationTypeDao.save(new NotificationType("notif1", 1));
            notificationTypeDao.save(new NotificationType("notif2", 2));
            notificationTypeDao.save(new NotificationType("notif3", 3));

        }
    }

    @Override
    public List<NotificationType> findAll() {
        initNotificationType();
        return notificationTypeDao.findAll();
    }

}
