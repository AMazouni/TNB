package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.beans.Quartier;


public interface QuartierService {
	public List<Quartier> findBySecteurId(Long secteurId);
	public Quartier findById(Long id);
	public List<Quartier> findAll();
	public int deleteById(Long id);
	public void save(Quartier quartier);
	public Quartier findByTerrainsId(Long id);
	public void update(Long id,Quartier quartier);
}
