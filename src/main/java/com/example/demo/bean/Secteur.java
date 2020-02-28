package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

	
@Entity
public class Secteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String Libelle;
	@OneToMany (mappedBy = "secteur")
	private List<Quartier> quartiers = new ArrayList<Quartier>();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Secteur(Long id, String libelle) {
		super();
		this.id = id;
		Libelle = libelle;
	}
	public Secteur() {
		super();
	}
	

}
