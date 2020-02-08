package com.example.demo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Quartier {
	private long id;
	private String libelle;
	@ManyToOne
	private Secteur secteur;
	@OneToMany
	private List<Terrain> terrains = new ArrayList<Terrain>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Secteur getSecteur() {
		return secteur;
	}
	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
	public List<Terrain> getTerrains() {
		return terrains;
	}
	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}
	public Quartier(long id, String libelle, Secteur secteur, List<Terrain> terrains) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.secteur = secteur;
		this.terrains = terrains;
	}
	public Quartier() {
		super();
	}
	
	
}
