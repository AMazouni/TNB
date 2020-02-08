package com.example.demo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
@Entity
public class Secteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String Libelle;
	@OneToMany
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
	public Secteur(long id, String libelle, List<Quartier> quartiers) {
		super();
		this.id = id;
		Libelle = libelle;
		this.quartiers = quartiers;
	}
	public Secteur() {
		super();
	}
	

}
