package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Terrain;

@Repository
public interface TerrainDao extends JpaRepository<Terrain, Long> {
	public List<Terrain> findByRedevableIdentifiant(String identifiant);
	public List<Terrain> findByQuartierLibelle(String Libelle);
	public List<Terrain> findBySurface(BigDecimal surface);
	public List<Terrain> findByDernierAnnePaiement(int dernierAnnePaiement);
	public List<Terrain> findByDernierAnnePaiementAndNotificationNotificationTypeNumero(int dernierAnnePaiement,int numero);
	public List<Terrain> findByDernierAnnePaiementAndRedevableIdentifiant(int dernierAnnePaiement,String identifiant);
	public List<Terrain> findByCategorieLibelle(String libelle);
	public List<Terrain> findByDernierAnnePaiementAndQuartierLibelle(int dernierAnnePaiement,String Libelle);
	public List<Terrain> findByDernierAnnePaiementAndQuartierSecteurLibelle(int dernierAnnePaiement,String Libelle);

}
