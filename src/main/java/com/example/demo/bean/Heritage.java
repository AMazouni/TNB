package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Heritage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Redevable redevableOriginal;
	Terrain terrainOriginal;
	Redevable nouveauRedevable;
	Float pourcentage;
	Terrain nouveauTerrain;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Redevable getRedevableOriginal() {
		return redevableOriginal;
	}
	public void setRedevableOriginal(Redevable redevableOriginal) {
		this.redevableOriginal = redevableOriginal;
	}
	public Terrain getTerrainOriginal() {
		return terrainOriginal;
	}
	public void setTerrainOriginal(Terrain terrainOriginal) {
		this.terrainOriginal = terrainOriginal;
	}
	public Redevable getNouveauRedevable() {
		return nouveauRedevable;
	}
	public void setNouveauRedevable(Redevable nouveauRedevable) {
		this.nouveauRedevable = nouveauRedevable;
	}
	public Float getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(Float pourcentage) {
		this.pourcentage = pourcentage;
	}
	public Terrain getNouveauTerrain() {
		return nouveauTerrain;
	}
	public void setNouveauTerrain(Terrain nouveauTerrain) {
		this.nouveauTerrain = nouveauTerrain;
	}
	public Heritage(Redevable redevableOriginal, Terrain terrainOriginal, Redevable nouveauRedevable,
			Float pourcentage, Terrain nouveauTerrain) {
		super();
		this.redevableOriginal = redevableOriginal;
		this.terrainOriginal = terrainOriginal;
		this.nouveauRedevable = nouveauRedevable;
		this.pourcentage = pourcentage;
		this.nouveauTerrain = nouveauTerrain;
	}
	public Heritage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
