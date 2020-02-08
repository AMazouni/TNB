package com.example.demo.beans;

import java.util.Date;

public class TaxeTNB {
	private long id;
	private Terrain terrain;
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
	


}
