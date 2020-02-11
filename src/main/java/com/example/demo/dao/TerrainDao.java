package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Terrain;

public interface TerrainDao extends JpaRepository<Terrain, Long> {
	public List<Terrain> findByRedevableId(Long id);
	public List<Terrain> findByQuartierId(Long id);
	public List<Terrain> findBySurface(BigDecimal surface);
	public List<Terrain> findByDernierAnnePaiement(int dernierAnnePaiement);

}
