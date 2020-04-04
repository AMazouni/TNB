package com.example.demo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class TaxeTNB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Terrain terrain;
	@ManyToOne
	private Redevable redevable;
	private Double montant;
	private Double montantRetard;
	private Double montantTotal;
	private Integer nombreMoisRetard;
	@ManyToOne
	private TauxTNB tauxTNB;
	@Temporal(TemporalType.DATE)
	private Date dateTaxeTNB;
	private Integer annee;
	
	
	
	public Double getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
	}
	public Integer getNombreMoisRetard() {
		return nombreMoisRetard;
	}
	public void setNombreMoisRetard(Integer nombreMoisRetard) {
		this.nombreMoisRetard = nombreMoisRetard;
	}
	public TauxTNB getTauxTNB() {
		return tauxTNB;
	}
	public void setTauxTNB(TauxTNB tauxTNB) {
		this.tauxTNB = tauxTNB;
	}
	public Double getMontantRetard() {
		return montantRetard;
	}
	public void setMontantRetard(Double montantRetard) {
		this.montantRetard = montantRetard;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	public Redevable getRedevable() {
		return redevable;
	}
	public void setRedevable(Redevable redevable) {
		this.redevable = redevable;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Date getDateTaxeTNB() {
		return dateTaxeTNB;
	}
	public void setDateTaxeTNB(Date dateTaxeTNB) {
		this.dateTaxeTNB = dateTaxeTNB;
	}
	public Integer getAnnee() {
		return annee;
	}
	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public TaxeTNB(Terrain terrain, Redevable redevable, Double montant, Double montantRetard,
			Double montantTotal, Integer nombreMoisRetard, TauxTNB tauxTNB, Date dateTaxeTNB, Integer annee) {
		super();
		this.terrain = terrain;
		this.redevable = redevable;
		this.montant = montant;
		this.montantRetard = montantRetard;
		this.montantTotal = montantTotal;
		this.nombreMoisRetard = nombreMoisRetard;
		this.tauxTNB = tauxTNB;
		this.dateTaxeTNB = dateTaxeTNB;
		this.annee = annee;
	}
	public TaxeTNB() {
		super();
	}
	


}
