package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.bean.Quartier;


public interface QuartierService {
	public List<Quartier> findBySecteurId(Long secteurId);
	public Quartier findById(Long id);
	public List<Quartier> findAll();
	public int deleteById(Long id);
	public int save(Quartier quartier);
	public int update(Long id,Quartier quartier);
}
