package com.example.demo.service.impl;

import com.example.demo.bean.Notification;
import com.example.demo.bean.NotificationDetail;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.dao.NotificationDetailDao;
import com.example.demo.service.facade.NotificationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NotificationDetailServiceImpl implements NotificationDetailService {
    @Autowired
    NotificationDetailDao notificationDetailDao;
    @Autowired
    TaxeTNBServiceImpl taxeTNBService;

    @Override
    public List<NotificationDetail> findByNotificationId(Long id) {
        return notificationDetailDao.findByNotificationId(id);
    }

    @Override
    public NotificationDetail findByNotificationIdAndAnnee(Long id, int annee) {
        return notificationDetailDao.findByNotificationIdAndAnnee(id,annee);
    }

    @Override
    public List<NotificationDetail> findByAnnee(int annee) {
        return notificationDetailDao.findByAnnee(annee);
    }



    @Override
    public void initNotificationDetails(Notification notification) {
        for (int i = notification.getAnneeDepart(); i <notification.getAnneeFin()+1 ; i++) {
            if (findByNotificationIdAndAnnee(notification.getId(),i)==null){
            	TaxeTNB tmp=new TaxeTNB();
                tmp.setAnnee(i);
                tmp.setTerrain(notification.getTerrain());
                TaxeTNB taxeTNB=taxeTNBService.payerSim(tmp);
                NotificationDetail notificationDetail=new NotificationDetail(notification.getMontantBase(),taxeTNB.getMontantRetard(),taxeTNB.getMontantTotal(),taxeTNB.getNombreMoisRetard(),i,notification);
                notificationDetailDao.save(notificationDetail);
            }
        }
    }
}
