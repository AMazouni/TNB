package com.example.demo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class NotificationDetail {
	@Id
	private Long id;
	private Double montantBase;
	private Double montantRetard;
	private Double montantTotal;
	private int moisRetard;
	@Temporal(TemporalType.DATE)
	private Date annee;
	@ManyToOne
	private Notification notification;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Double getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
	}
	public int getMoisRetard() {
		return moisRetard;
	}
	public void setMoisRetard(int moisRetard) {
		this.moisRetard = moisRetard;
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
	public NotificationDetail(Long id, Double montantBase, Double montantRetard, Double montantTotal, int moisRetard,
			Date annee, Notification notification) {
		super();
		this.id = id;
		this.montantBase = montantBase;
		this.montantRetard = montantRetard;
		this.montantTotal = montantTotal;
		this.moisRetard = moisRetard;
		this.annee = annee;
		this.notification = notification;
	}
	public NotificationDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
