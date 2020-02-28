package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class NotificationType {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String libelle;
	private int numero;
	@OneToMany(mappedBy = "notificationType")
	private List<Notification> notifications = new ArrayList<Notification>();


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
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	public NotificationType(String libelle, int numero) {
		super();
		this.libelle = libelle;
		this.numero = numero;
	}
	public NotificationType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
