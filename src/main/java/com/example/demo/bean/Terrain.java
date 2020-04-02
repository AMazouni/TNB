package com.example.demo.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Terrain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private BigDecimal surface;
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	private Quartier quartier;
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	private Redevable redevable;
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	private Categorie categorie;
	private int dernierAnnePaiement;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToOne
	private Notification notification;
	@OneToMany(mappedBy = "terrain")
	@JsonProperty(access=Access.WRITE_ONLY)
	List<TaxeTNB> taxesTNB = new ArrayList<TaxeTNB>();
	@ManyToOne
	private TypeTerrain typeterrain;

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

	public List<TaxeTNB> getTaxesTNB() {
		return taxesTNB;
	}

	public void setTaxesTNB(List<TaxeTNB> taxesTNB) {
		this.taxesTNB = taxesTNB;
	}

	public Terrain(long id, BigDecimal surface, Quartier quartier, Redevable redevable, Categorie categorie,
			int dernierAnnePaiement, Notification notification, List<TaxeTNB> taxesTNB) {
		super();
		this.id = id;
		this.surface = surface;
		this.quartier = quartier;
		this.redevable = redevable;
		this.categorie = categorie;
		this.dernierAnnePaiement = dernierAnnePaiement;
		this.notification = notification;
		this.taxesTNB = taxesTNB;
	}

	public Terrain() {
		super();
	}

	@Override
	public String toString() {
		return "Terrain [id=" + id + ", surface=" + surface + ", quartier=" + quartier + ", redevable=" + redevable
				+ ", categorie=" + categorie + ", dernierAnnePaiement=" + dernierAnnePaiement + ", notification="
				+ notification + ", taxesTNB=" + taxesTNB + "]";
	}
	
	
}
