package com.example.demo.beans;

import java.util.ArrayList;
import java.util.List;

public class Redevable {
	private long id;
	private String identifiant;
	private String nom;
	private TypeRedevable typeRedevable;
	private List<Terrain> terrains = new ArrayList<Terrain>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public TypeRedevable getTypeRedevable() {
		return typeRedevable;
	}
	public void setTypeRedevable(TypeRedevable typeRedevable) {
		this.typeRedevable = typeRedevable;
	}
	public List<Terrain> getTerrains() {
		return terrains;
	}
	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}
	
}
