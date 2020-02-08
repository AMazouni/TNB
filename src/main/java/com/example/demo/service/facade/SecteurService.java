package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.beans.Secteur;



public interface SecteurService {
	public List<Secteur> findAll();
	public Secteur findByid(Long id);
	public int deleteById(Long id);
	public void save(Secteur secteur);
	public Secteur findByQuartiersId(Long id);
	public void update(Long id,Secteur secteur);
}
