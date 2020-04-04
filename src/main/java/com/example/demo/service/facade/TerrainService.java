package com.example.demo.service.facade;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.bean.Terrain;
import org.springframework.stereotype.Service;

@Service

public interface TerrainService {

	public List<Terrain> findAll();
	public Terrain findByid(Long id);
	public int deleteById(Long id);
	public int save(Terrain terrain);
	public List<Terrain> findByRedevableIdentifiant(String identifiant);
	public List<Terrain> findByQuartierLibelle(String libelle);
	public List<Terrain> findBySurface(BigDecimal surface);
	public List<Terrain> findByDernierAnnePaiement(int dernierAnnePaiement);
	public int update(Long id,Terrain terrain);
	public List<Terrain> findByDernierAnnePaiementAndNotificationNotificationTypeNumero(int dernierAnnePaiement,int numero);
	public List<Terrain> findByDernierAnnePaiementAndRedevableIdentifiant(int dernierAnnePaiement,String identifiant);
	public List<Terrain> findByCategorieLibelle(String libelle);
	public List<Terrain> findByDernierAnnePaiementAndQuartierLibelle(int dernierAnnePaiement,String Libelle);
	public List<Terrain> findByDernierAnnePaiementAndQuartierSecteurLibelle(int dernierAnnePaiement,String Libelle);
	public List<Terrain> findAllTerrainsNonPaye();

}