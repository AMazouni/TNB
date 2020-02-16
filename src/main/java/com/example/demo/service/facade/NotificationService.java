package com.example.demo.service.facade;

import com.example.demo.bean.Notification;

import java.util.Date;
import java.util.List;

public interface NotificationService {
    public List<Notification> findByNotificationTypeNumero(int numero);
    public List<Notification> findByAnneeDepartAndAnneeFin(int anneeDepart, int anneeFin);
    public List<Notification> findByAnneeDepart(int anneeDepart);
    public List<Notification> findByAnneeFin(int anneeFin);
    public Notification findByTerrainId(Long id);
    public int giveNotification(Long idTerrain);

}
