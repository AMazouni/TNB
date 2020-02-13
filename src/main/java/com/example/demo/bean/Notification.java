package com.example.demo.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private NotificationType notificationType;
	private Redevable redevable;
	private Terrain terrain;
	@Temporal(TemporalType.DATE)	
	private Date anneeDepart;
	@Temporal(TemporalType.DATE)
	private Date anneeFin;
	private Double montantBase;
	private Double montantRetard;
	private int nombreMoisRetard;
	@OneToMany(mappedBy = "notification")
	private List<NotificationDetail> notificationDetails;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public NotificationType getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}
	public Redevable getRedevable() {
		return redevable;
	}
	public void setRedevable(Redevable redevable) {
		this.redevable = redevable;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	public Date getAnneeDepart() {
		return anneeDepart;
	}
	public void setAnneeDepart(Date anneeDepart) {
		this.anneeDepart = anneeDepart;
	}
	public Date getAnneeFin() {
		return anneeFin;
	}
	public void setAnneeFin(Date anneeFin) {
		this.anneeFin = anneeFin;
	}
	public Double getMontantBase() {
		return montantBase;
	}
	public void setMontantBase(Double montantBase) {
		this.montantBase = montantBase;
	}
	public Double getMontantRetard() {
		return montantRetard;
	}
	public void setMontantRetard(Double montantRetard) {
		this.montantRetard = montantRetard;
	}
	public int getNombreMoisRetard() {
		return nombreMoisRetard;
	}
	public void setNombreMoisRetard(int nombreMoisRetard) {
		this.nombreMoisRetard = nombreMoisRetard;
	}
	public List<NotificationDetail> getNotificationDetails() {
		return notificationDetails;
	}
	public void setNotificationDetails(List<NotificationDetail> notificationDetails) {
		this.notificationDetails = notificationDetails;
	}
	public Notification(Long id, NotificationType notificationType, Redevable redevable, Terrain terrain,
			Date anneeDepart, Date anneeFin, Double montantBase, Double montantRetard, int nombreMoisRetard,
			List<NotificationDetail> notificationDetails) {
		super();
		this.id = id;
		this.notificationType = notificationType;
		this.redevable = redevable;
		this.terrain = terrain;
		this.anneeDepart = anneeDepart;
		this.anneeFin = anneeFin;
		this.montantBase = montantBase;
		this.montantRetard = montantRetard;
		this.nombreMoisRetard = nombreMoisRetard;
		this.notificationDetails = notificationDetails;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
