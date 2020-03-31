package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Secteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	@OneToMany (mappedBy = "secteur",fetch = FetchType.LAZY)
	@JsonProperty(access=Access.WRITE_ONLY)
	private List<Quartier> quartiers = new ArrayList<Quartier>();

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
	
	
	public List<Quartier> getQuartiers() {
		return quartiers;
	}
	public void setQuartiers(List<Quartier> quartiers) {
		this.quartiers = quartiers;
	}
	
	public Secteur(Long id, String libelle, List<Quartier> quartiers) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.quartiers = quartiers;
	}
	public Secteur() {
		super();
	}
	

}
