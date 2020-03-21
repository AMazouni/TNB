package com.example.demo.bean;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property ="libelle")
@Entity
public class Quartier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	@ManyToOne
	private Secteur secteur;
	@JsonProperty(access=Access.WRITE_ONLY)
	@OneToMany(mappedBy = "quartier",fetch = FetchType.LAZY)
	private List<Terrain> terrains = new ArrayList<Terrain>();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	public Quartier(Long id, String libelle, Secteur secteur, List<Terrain> terrains) {
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
