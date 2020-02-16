package com.example.demo.service.facade;

import com.example.demo.bean.Notification;
import com.example.demo.bean.NotificationDetail;

import java.util.Date;
import java.util.List;

public interface NotificationDetailService {
    public List<NotificationDetail> findByNotificationId(Long id);
    public NotificationDetail findByNotificationIdAndAnnee(Long id, int annee);
    public List<NotificationDetail> findByAnnee(int annee);
    public void initNotificationDetails(Notification notification);
}

