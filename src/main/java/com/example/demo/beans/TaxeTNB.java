package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


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
	private Date dateTaxeTNB;
	private Integer annee;
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
	public TaxeTNB(Long id, Terrain terrain, Redevable redevable, Double montant, Date dateTaxeTNB, Integer annee) {
		super();
		this.id = id;
		this.terrain = terrain;
		this.redevable = redevable;
		this.montant = montant;
		this.dateTaxeTNB = dateTaxeTNB;
		this.annee = annee;
	}
	public TaxeTNB() {
		super();
	}
	


}
