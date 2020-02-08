package com.example.demo.beans;

import java.util.ArrayList;
import java.util.List;

public class Secteur {
	private long id;
	private String Libelle;
	private List<Quartier> quartiers = new ArrayList<Quartier>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public List<Quartier> getQuartiers() {
		return quartiers;
	}
	public void setQuartiers(List<Quartier> quartiers) {
		this.quartiers = quartiers;
	}
	

}
