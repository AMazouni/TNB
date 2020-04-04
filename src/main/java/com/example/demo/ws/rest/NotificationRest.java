package com.example.demo.ws.rest;

import com.example.demo.bean.Notification;
import com.example.demo.bean.Terrain;
import com.example.demo.service.facade.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
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
    @PostMapping(path="/give" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public int giveNotification(@RequestBody Terrain terrain) {
        return notificationService.giveNotification(terrain);
    }
}
