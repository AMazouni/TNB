package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Notification;

public interface NotificationDao extends JpaRepository<Notification, Long> {
	public List<Notification> findByNotificationTypeNumero(int numero);
	public List<Notification> findByRedevableId(Long id);
	public List<Notification> findByAnneeDepartAndAnneeFin(Date anneeDepart,Date anneeFin);
	public List<Notification> findByTerrainId(Long id);
	
	//  save Notification(int annee,int numro
}
