package com.example.demo.dao;

import com.example.demo.bean.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationTypeDao extends JpaRepository<NotificationType,Long> {
    public NotificationType findByNumero(int numero);
}
