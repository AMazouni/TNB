package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

@Entity
public class TauxTNB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Categorie categorie;
	private double surfaceMax;
	private double surfaceMin;
	private double montant;
	private Date dateApp;
	private Date datefinApp;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public double getSurfaceMax() {
		return surfaceMax;
	}
	public void setSurfaceMax(double surfaceMax) {
		this.surfaceMax = surfaceMax;
	}
	public double getSurfaceMin() {
		return surfaceMin;
	}
	public void setSurfaceMin(double surfaceMin) {
		this.surfaceMin = surfaceMin;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateApp() {
		return dateApp;
	}
	public void setDateApp(Date dateApp) {
		this.dateApp = dateApp;
	}
	public Date getDatefinApp() {
		return datefinApp;
	}
	public void setDatefinApp(Date datefinApp) {
		this.datefinApp = datefinApp;
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
		this.datefinApp = datefinApp;
	}
	public TauxTNB() {
		super();
	}
	
}
