package com.example.demo.service.facade;

import com.example.demo.bean.NotificationType;

public interface NotificationTypeService {
    public NotificationType findByNumero(int numero);
    public void initNotificationType();
}
