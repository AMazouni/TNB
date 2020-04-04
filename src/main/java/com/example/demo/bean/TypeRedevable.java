package com.example.demo.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
public class TypeRedevable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	@OneToMany (mappedBy = "typeRedevable" )
	@JsonProperty(access=Access.WRITE_ONLY)
	private List<Redevable>  redevables;
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
	public TypeRedevable(String libelle) {
		super();
		this.libelle = libelle;
	}
	public TypeRedevable() {
		super();
	}
	
}
