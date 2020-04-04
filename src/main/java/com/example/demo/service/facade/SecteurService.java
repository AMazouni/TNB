package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.bean.Secteur;



public interface SecteurService {
	public List<Secteur> findAll();
	public Secteur findByid(Long id);
	public Secteur findTopByOrderByIdDesc();
	public int deleteById(Long id);
	public void save(Secteur secteur);
	public void update(Long id,Secteur secteur);
}
