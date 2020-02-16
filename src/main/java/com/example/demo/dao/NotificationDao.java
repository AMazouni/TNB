package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Notification;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDao extends JpaRepository<Notification, Long> {
	public List<Notification> findByNotificationTypeNumero(int numero);
	public List<Notification> findByAnneeDepartAndAnneeFin(int anneeDepart,int anneeFin);
	public List<Notification> findByAnneeDepart(int anneeDepart);
	public List<Notification> findByAnneeFin(int anneeFin);
	public Notification findByTerrainId(Long id);



}
