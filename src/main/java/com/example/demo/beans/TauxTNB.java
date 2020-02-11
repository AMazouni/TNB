package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class TauxTNB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Categorie categorie;
	private Double surfaceMax;
	private Double surfaceMin;
	private Double montant;
	private Date dateApp;
	private Date dateFinApp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Double getSurfaceMax() {
		return surfaceMax;
	}
	public void setSurfaceMax(Double surfaceMax) {
		this.surfaceMax = surfaceMax;
	}
	public Double getSurfaceMin() {
		return surfaceMin;
	}
	public void setSurfaceMin(Double surfaceMin) {
		this.surfaceMin = surfaceMin;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Date getDateApp() {
		return dateApp;
	}
	public void setDateApp(Date dateApp) {
		this.dateApp = dateApp;
	}
	public Date getDateFinApp() {
		return dateFinApp;
	}
	public void setDatFinApp(Date datefinApp) {
		this.dateFinApp = datefinApp;
	}
	public TauxTNB(long id, Categorie categorie, double surfaceMax, double surfaceMin, double montant, Date dateApp,
			Date datefinApp) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.surfaceMax = surfaceMax;
		this.surfaceMin = surfaceMin;
		this.montant = montant;
		this.dateApp = dateApp;
		this.dateFinApp = datefinApp;
	}
	public TauxTNB() {
		super();
	}
	
}
