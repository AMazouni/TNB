package com.example.demo.service.impl;

import com.example.demo.bean.Notification;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.NotificationDao;
import com.example.demo.service.facade.NotificationService;
import com.example.demo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationDetailServiceImpl notificationDetailService;
    @Autowired
    NotificationDao notificationDao;
    @Autowired
    TerrainServiceImpl terrainService;
    @Autowired
    NotificationTypeServiceImpl notificationTypeService;
    @Autowired
    TaxeTNBServiceImpl taxeTNBService;


    @Override
    public List<Notification> findByNotificationTypeNumero(int numero) {
        return notificationDao.findByNotificationTypeNumero(numero);
    }

    @Override
    public List<Notification> findByAnneeDepartAndAnneeFin(int anneeDepart, int anneeFin) {
        return notificationDao.findByAnneeDepartAndAnneeFin(anneeDepart,anneeFin);
    }

    @Override
    public List<Notification> findByAnneeDepart(int anneeDepart) {
        return notificationDao.findByAnneeDepart(anneeDepart);
    }

    @Override
    public List<Notification> findByAnneeFin(int anneeFin) {
        return notificationDao.findByAnneeFin(anneeFin);
    }

    @Override
    public Notification findByTerrainId(Long id) {
        return notificationDao.findByTerrainId(id);
    }

    @Override
    public int giveNotification(Long idTerrain) {
        Terrain terrain=terrainService.findByid(idTerrain);
        notificationTypeService.initNotificationType();
        TaxeTNB tmp=new TaxeTNB();
        tmp.setAnnee(terrain.getDernierAnnePaiement());
        tmp.setTerrain(terrain);
        TaxeTNB taxeTNB=taxeTNBService.payerSim(tmp);
        if (terrain.getNotification()==null){
            Notification notification=new Notification(notificationTypeService.findByNumero(1),terrain,terrain.getDernierAnnePaiement(), DateUtils.getYear(),taxeTNB.getMontant(),taxeTNB.getMontantRetard(),taxeTNB.getNombreMoisRetard());
            notificationDao.save(notification);
            notificationDetailService.initNotificationDetails(notification);
                return 1;
        }else if (terrain.getNotification().getNotificationType().getNumero()==1){
            return update(terrain, taxeTNB, 2);
        }else if(terrain.getNotification().getNotificationType().getNumero()==2){
            return update(terrain, taxeTNB, 3);
        }else {
            return 0;
        }

    }

    private int update(Terrain terrain, TaxeTNB taxeTNB, int i) {
        Notification notification=terrain.getNotification();
        notification.setAnneeFin(DateUtils.getYear());
        notification.setMontantRetard(taxeTNB.getMontantRetard());
        notification.setNombreMoisRetard(taxeTNB.getNombreMoisRetard());
        notification.setNotificationType(notificationTypeService.findByNumero(i));
        notificationDao.save(notification);
        notificationDetailService.initNotificationDetails(notification);
        return 1;
    }

	@Override
	public List<NotificationService> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
