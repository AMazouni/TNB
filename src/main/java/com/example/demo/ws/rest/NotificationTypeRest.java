package com.example.demo.ws.rest;

import com.example.demo.bean.NotificationDetail;
import com.example.demo.bean.NotificationType;
import com.example.demo.service.facade.NotificationDetailService;
import com.example.demo.service.facade.NotificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/TNB-api/NotificationType")
public class NotificationTypeRest {
    @Autowired
    NotificationTypeService notificationTypeService;
    @GetMapping("/{numero}")
    public NotificationType findByNumero(@PathVariable  int numero) {
        return notificationTypeService.findByNumero(numero);
    }


}
