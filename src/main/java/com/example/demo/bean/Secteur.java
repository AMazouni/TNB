package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

	
@Entity
public class Secteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String Libelle;

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
	
	public Secteur(Long id, String libelle) {
		super();
		this.id = id;
		Libelle = libelle;
	}
	public Secteur() {
		super();
	}
	

}
