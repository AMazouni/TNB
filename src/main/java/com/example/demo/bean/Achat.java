package com.example.demo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Achat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Redevable oldredevable;
	@ManyToOne
	private Redevable newRedevable;
	@ManyToOne
	private Terrain terrain;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateachat;
	private double prix;

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Redevable getOldredevable() {
		return oldredevable;
	}

	public void setOldredevable(Redevable oldredevable) {
		this.oldredevable = oldredevable;
	}

	public Redevable getNewRedevable() {
		return newRedevable;
	}

	public void setNewRedevable(Redevable newRedevable) {
		this.newRedevable = newRedevable;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public Date getDateachat() {
		return dateachat;
	}

	public void setDateachat(Date dateachat) {
		this.dateachat = dateachat;
	}

	public Achat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Achat(Redevable oldredevable, Redevable newRedevable, Terrain terrain, Date dateachat,
			double prix) {
		super();
		this.oldredevable = oldredevable;
		this.newRedevable = newRedevable;
		this.terrain = terrain;
		this.dateachat = dateachat;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Achat [id=" + id + ", oldredevable=" + oldredevable + ", newRedevable=" + newRedevable + ", terrain="
				+ terrain + ", dateachat=" + dateachat + ", prix=" + prix + "]";
	}

}
