package com.example.demo.beans;



public class TauxTNB {
	private long id;
	private Categorie categorie;
	private double surfaceMax;
	private double surfaceMin;
	private double montant;
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
	
}
