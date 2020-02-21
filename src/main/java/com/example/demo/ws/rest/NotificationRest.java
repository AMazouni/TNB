package com.example.demo.ws.rest;

import com.example.demo.bean.Notification;
import com.example.demo.service.facade.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TNB-api/Notification")
public class NotificationRest {
    @Autowired
    NotificationService notificationService;
    @GetMapping("/NotificationType/{numero]")
    public List<Notification> findByNotificationTypeNumero(@PathVariable  int numero) {
        return notificationService.findByNotificationTypeNumero(numero);
    }
    @GetMapping("/{anneeDepart}/{anneeFin}")
    public List<Notification> findByAnneeDepartAndAnneeFin(@PathVariable int anneeDepart,@PathVariable int anneeFin) {
        return notificationService.findByAnneeDepartAndAnneeFin(anneeDepart, anneeFin);
    }
    @GetMapping("/{anneeDepart}")
    public List<Notification> findByAnneeDepart(@PathVariable int anneeDepart) {
        return notificationService.findByAnneeDepart(anneeDepart);
    }
    @GetMapping("/{anneeFin}")
    public List<Notification> findByAnneeFin(@PathVariable int anneeFin) {
        return notificationService.findByAnneeFin(anneeFin);
    }
    @GetMapping("/Terrain/{id}")
    public Notification findByTerrainId(@PathVariable  Long id) {
        return notificationService.findByTerrainId(id);
    }
    @PostMapping("/")
    public int giveNotification(@RequestBody Long idTerrain) {
        return notificationService.giveNotification(idTerrain);
    }
}
