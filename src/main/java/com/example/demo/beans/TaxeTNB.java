package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
@Entity
public class TaxeTNB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Terrain terrain;
	@ManyToOne
	private Redevable redevable;
	private double montant;
	private Date dateTaxeTNB;
	private int annee;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateTaxeTNB() {
		return dateTaxeTNB;
	}
	public void setDateTaxeTNB(Date dateTaxeTNB) {
		this.dateTaxeTNB = dateTaxeTNB;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public TaxeTNB(long id, Terrain terrain, Redevable redevable, double montant, Date dateTaxeTNB, int annee) {
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
