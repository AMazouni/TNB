package com.example.demo.ws.rest;

import com.example.demo.bean.Notification;
import com.example.demo.bean.NotificationDetail;
import com.example.demo.service.facade.NotificationDetailService;
import com.example.demo.service.facade.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/TNB-api/NotificationDetail")
public class NotificationDetailRest {
    @Autowired
    NotificationDetailService notificationDetailService;
    @GetMapping("/{id}")
    public List<NotificationDetail> findByNotificationId(@PathVariable Long id) {
        return notificationDetailService.findByNotificationId(id);
    }
    @GetMapping("/{id}/{annee}")
    public NotificationDetail findByNotificationIdAndAnnee(@PathVariable Long id,@PathVariable int annee) {
        return notificationDetailService.findByNotificationIdAndAnnee(id, annee);
    }
    @GetMapping("/{annee}")
    public List<NotificationDetail> findByAnnee(@PathVariable int annee) {
        return notificationDetailService.findByAnnee(annee);
    }




}
