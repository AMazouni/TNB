package com.example.demo.service.facade;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.beans.Terrain;



public interface TerrainService {
	public List<Terrain> findAll();
	public Terrain findByid(Long id);
	public int deleteById(Long id);
	public void save(Terrain terrain);
	public List<Terrain> findbyRedevableId(Long id);
	public List<Terrain> findByQuartierId(Long id);
	public List<Terrain> findBySurface(BigDecimal surface);
	public List<Terrain> findByDernierAnnePaiement(int dernierAnnePaiement);
	public void update(Long id,Terrain terrain);
}
