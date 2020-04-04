package com.example.demo.bean;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
public class Redevable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String identifiant;
	private String nom;
	@ManyToOne
	private TypeRedevable typeRedevable;
	@OneToMany(mappedBy = "redevable")
	@JsonProperty(access= Access.WRITE_ONLY)
	List<Terrain> terrains = new ArrayList<Terrain>();
	@OneToMany(mappedBy = "redevable")
	@JsonProperty(access=Access.WRITE_ONLY)
	List<TaxeTNB> taxesTNB = new ArrayList<TaxeTNB>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public List<TaxeTNB> getTaxesTNB() {
		return taxesTNB;
	}
	public void setTaxesTNB(List<TaxeTNB> taxesTNB) {
		this.taxesTNB = taxesTNB;
	}
	public Redevable(String identifiant, String nom, TypeRedevable typeRedevable) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.typeRedevable = typeRedevable;
	}
	public Redevable() {
		super();
	}
	
	
}
