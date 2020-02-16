package com.example.demo.ws.rest;

import com.example.demo.bean.NotificationDetail;
import com.example.demo.bean.NotificationType;
import com.example.demo.service.facade.NotificationDetailService;
import com.example.demo.service.facade.NotificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@RequestMapping("/TNB-api/NotificationType")
public class NotificationTypeRest {
    @Autowired
    NotificationTypeService notificationTypeService;
    @GetMapping("/{numero}")
    public NotificationType findByNumero(@PathVariable  int numero) {
        return notificationTypeService.findByNumero(numero);
    }


}
