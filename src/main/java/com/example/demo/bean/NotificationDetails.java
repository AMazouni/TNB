package com.example.demo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class NotificationDetails {
	@Id
	private Long id;
	private Double montantDeBase;
	private Double montantDeRetard;
	private int moisDeRetard;
	@Temporal(TemporalType.DATE)
	private Date annee;
	private Notification notification;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getMontantDeBase() {
		return montantDeBase;
	}
	public void setMontantDeBase(Double montantDeBase) {
		this.montantDeBase = montantDeBase;
	}
	public Double getMontantDeRetard() {
		return montantDeRetard;
	}
	public void setMontantDeRetard(Double montantDeRetard) {
		this.montantDeRetard = montantDeRetard;
	}
	public int getMoisDeRetard() {
		return moisDeRetard;
	}
	public void setMoisDeRetard(int moisDeRetard) {
		this.moisDeRetard = moisDeRetard;
	}
	public Date getAnnee() {
		return annee;
	}
	public void setAnnee(Date annee) {
		this.annee = annee;
	}
	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	public NotificationDetails(Long id, Double montantDeBase, Double montantDeRetard, int moisDeRetard, Date annee,
			Notification notification) {
		super();
		this.id = id;
		this.montantDeBase = montantDeBase;
		this.montantDeRetard = montantDeRetard;
		this.moisDeRetard = moisDeRetard;
		this.annee = annee;
		this.notification = notification;
	}
	public NotificationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
