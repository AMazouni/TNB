package com.example.demo.beans;

import java.math.BigDecimal;

public class Terrain {
	private long id;
	private BigDecimal surface;
	private Quartier quartier;
	private Redevable redevable;
	private int dernierAnnePaiement;
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
	
}
