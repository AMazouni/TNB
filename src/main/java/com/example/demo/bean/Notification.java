package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private NotificationType notificationType;
	@OneToOne
	private Terrain terrain;
	private int anneeDepart;
	private int anneeFin;
	private Double montantBase;
	private Double montantRetard;
	private int nombreMoisRetard;
	@OneToMany(mappedBy = "notification")
	List<NotificationDetail> notificationDetails = new ArrayList<NotificationDetail>();


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
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	public int getAnneeDepart() {
		return anneeDepart;
	}
	public void setAnneeDepart(int anneeDepart) {
		this.anneeDepart = anneeDepart;
	}
	public int getAnneeFin() {
		return anneeFin;
	}
	public void setAnneeFin(int anneeFin) {
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
	public Notification(NotificationType notificationType, Terrain terrain,
			int anneeDepart, int anneeFin, Double montantBase, Double montantRetard, int nombreMoisRetard) {
		super();
		this.notificationType = notificationType;
		this.terrain = terrain;
		this.anneeDepart = anneeDepart;
		this.anneeFin = anneeFin;
		this.montantBase = montantBase;
		this.montantRetard = montantRetard;
		this.nombreMoisRetard = nombreMoisRetard;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
