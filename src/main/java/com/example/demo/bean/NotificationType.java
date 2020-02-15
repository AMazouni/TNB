package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NotificationType {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String libelle;
	private int numero;
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public NotificationType(Long id, String libelle, int numero) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.numero = numero;
	}
	public NotificationType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
