package com.example.demo.dao;

import com.example.demo.bean.Notification;
import com.example.demo.bean.NotificationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NotificationDetailDao extends JpaRepository<NotificationDetail,Long> {
    public List<NotificationDetail> findByNotificationId(Long id);
    public NotificationDetail findByNotificationIdAndAnnee(Long id, int annee);
    public List<NotificationDetail> findByAnnee(int annee);
}
