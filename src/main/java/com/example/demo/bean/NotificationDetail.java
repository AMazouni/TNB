package com.example.demo.bean;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class NotificationDetail {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private Double montantBase;
	private Double montantRetard;
	private Double montantTotal;
	private int moisRetard;
	private int annee;
	@ManyToOne
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
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
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	public NotificationDetail(Double montantBase, Double montantRetard, Double montantTotal, int moisRetard,
			int annee, Notification notification) {
		super();
		this.montantBase = notification.getMontantBase();
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
