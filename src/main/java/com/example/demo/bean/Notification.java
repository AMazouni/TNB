package com.example.demo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private NotificationType notificationType;
	private Redevable redevable;
	private Terrain terrain;
	@Temporal(TemporalType.DATE)	
	private Date anneeDepart;
	@Temporal(TemporalType.DATE)
	private Date anneeFin;
	private Double montantDeBase;
	private Double montantDeRetard;
	private int nombreMoisDeRetard;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public NotificationType getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}
	public Redevable getRedevable() {
		return redevable;
	}
	public void setRedevable(Redevable redevable) {
		this.redevable = redevable;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	public Date getAnneeDepart() {
		return anneeDepart;
	}
	public void setAnneeDepart(Date anneeDepart) {
		this.anneeDepart = anneeDepart;
	}
	public Date getAnneeFin() {
		return anneeFin;
	}
	public void setAnneeFin(Date anneeFin) {
		this.anneeFin = anneeFin;
	}
	public Double getMontantDeBase() {
		return montantDeBase;
	}
	public void setMontantDeBase(Double montantDeBase) {
		this.montantDeBase = montantDeBase;
	}
	public Double getMontantDeRetard() {
		return montantDeRetard;
	}
	public void setMontantDeRetard(Double montantDeRetard) {
		this.montantDeRetard = montantDeRetard;
	}
	public int getNombreMoisDeRetard() {
		return nombreMoisDeRetard;
	}
	public void setNombreMoisDeRetard(int nombreMoisDeRetard) {
		this.nombreMoisDeRetard = nombreMoisDeRetard;
	}
	public Notification(Long id, NotificationType notificationType, Redevable redevable, Terrain terrain,
			Date anneeDepart, Date anneeFin, Double montantDeBase, Double montantDeRetard, int nombreMoisDeRetard) {
		super();
		this.id = id;
		this.notificationType = notificationType;
		this.redevable = redevable;
		this.terrain = terrain;
		this.anneeDepart = anneeDepart;
		this.anneeFin = anneeFin;
		this.montantDeBase = montantDeBase;
		this.montantDeRetard = montantDeRetard;
		this.nombreMoisDeRetard = nombreMoisDeRetard;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
