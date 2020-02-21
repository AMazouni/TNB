package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Terrain;

@Repository
public interface TerrainDao extends JpaRepository<Terrain, Long> {
	public List<Terrain> findByRedevableId(Long id);
	public List<Terrain> findByQuartierId(Long id);
	public List<Terrain> findBySurface(BigDecimal surface);
	public List<Terrain> findByDernierAnnePaiement(int dernierAnnePaiement);
	public List<Terrain> findByDernierAnnePaiementAndNotificationNotificationTypeNumero(int dernierAnnePaiement,int numero);

}
