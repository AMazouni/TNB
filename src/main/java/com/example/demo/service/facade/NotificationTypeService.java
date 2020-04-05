package com.example.demo.service.facade;

import com.example.demo.bean.NotificationType;

import java.util.List;

public interface NotificationTypeService {
    public NotificationType findByNumero(int numero);
    public NotificationType findById(Long id);
    public void initNotificationType();
    public List<NotificationType> findAll();
}
