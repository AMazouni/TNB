package com.example.demo.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class TauxTNB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Categorie categorie;
	private BigDecimal surfaceMax;
	private BigDecimal surfaceMin;
	private Double montant;
	private Double montantRetard;
	@Temporal(TemporalType.DATE)
	private Date dateApp;
	@Temporal(TemporalType.DATE)
	private Date dateFinApp;
	@OneToMany(mappedBy = "tauxTNB")
	private List<TaxeTNB> taxesTNB = new ArrayList<TaxeTNB>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Double getMontantRetard() {
		return montantRetard;
	}
	public void setMontantRetard(Double montantRetard) {
		this.montantRetard = montantRetard;
	}
	public void setDateFinApp(Date dateFinApp) {
		this.dateFinApp = dateFinApp;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public BigDecimal getSurfaceMax() {
		return surfaceMax;
	}
	public void setSurfaceMax(BigDecimal surfaceMax) {
		this.surfaceMax = surfaceMax;
	}
	public BigDecimal getSurfaceMin() {
		return surfaceMin;
	}
	public void setSurfaceMin(BigDecimal surfaceMin) {
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
	
	public List<TaxeTNB> getTaxesTNB() {
		return taxesTNB;
	}
	public void setTaxesTNB(List<TaxeTNB> taxesTNB) {
		this.taxesTNB = taxesTNB;
	}
	public TauxTNB(long id, Categorie categorie, BigDecimal surfaceMax, BigDecimal surfaceMin, double montant, Date dateApp,
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
