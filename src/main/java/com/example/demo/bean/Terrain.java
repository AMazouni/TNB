package com.example.demo.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Terrain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private BigDecimal surface;
	@ManyToOne
	private Quartier quartier;
	@ManyToOne
	private Redevable redevable;
	@ManyToOne
	private Categorie categorie;
	private int dernierAnnePaiement;
	@OneToOne
	private Notification notification;
	@OneToMany(mappedBy = "terrain")
	List<TaxeTNB> taxesTNB = new ArrayList<TaxeTNB>();

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getSurface() {
		return surface;
	}
	public void setSurface(BigDecimal surface) {
		this.surface = surface;
	}
	public Quartier getQuartier() {
		return quartier;
	}
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
	public Redevable getRedevable() {
		return redevable;
	}
	public void setRedevable(Redevable redevable) {
		this.redevable = redevable;
	}
	public int getDernierAnnePaiement() {
		return dernierAnnePaiement;
	}
	public void setDernierAnnePaiement(int dernierAnnePaiement) {
		this.dernierAnnePaiement = dernierAnnePaiement;
	}
	public Terrain(long id, BigDecimal surface, Quartier quartier, Redevable redevable, int dernierAnnePaiement,Notification notification) {
		super();
		this.id = id;
		this.surface = surface;
		this.quartier = quartier;
		this.redevable = redevable;
		this.dernierAnnePaiement = dernierAnnePaiement;
		this.notification=notification;
	}
	public Terrain() {
		super();
	}
	
	
}
