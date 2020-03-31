package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	@OneToMany(mappedBy = "categorie")
	@JsonProperty(access=Access.WRITE_ONLY)
	List<Terrain> terrains = new ArrayList<Terrain>();
	@OneToMany(mappedBy = "categorie")
	@JsonProperty(access=Access.WRITE_ONLY)
	List<TauxTNB> tauxTNB = new ArrayList<TauxTNB>();
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
	public Categorie(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	public Categorie() {
		super();
	}
	
	
}
