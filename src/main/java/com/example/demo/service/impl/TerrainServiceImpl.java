package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Terrain;
import com.example.demo.dao.TerrainDao;
import com.example.demo.service.facade.CategorieService;
import com.example.demo.service.facade.QuartierService;
import com.example.demo.service.facade.RedevableService;
import com.example.demo.service.facade.TerrainService;
@Service
public class TerrainServiceImpl implements TerrainService{
	@Autowired
	TerrainDao terrainDao;
	@Autowired
	RedevableService redevableService;
	@Autowired
	QuartierService quartierService;
	@Autowired
	CategorieService categorieService;
	@Override
	public List<Terrain> findAll() {
		return terrainDao.findAll();
	}

	@Override
	public Terrain findByid(Long id) {
		if (terrainDao.findById(id).isPresent()) {
			return terrainDao.findById(id).get();
		} else return null;
	}

	@Override
	public int deleteById(Long id) {
		terrainDao.deleteById(id);
		if (findByid(id) == null) {
			return 1;
		} else return -1;
	}

	@Override
	public int save(Terrain terrain) {
		if (quartierService.findById(terrain.getQuartier().getId()) != null &&
			redevableService.findById(terrain.getRedevable().getId()) != null &&
			categorieService.findById(terrain.getCategorie().getId()) != null)
		{ terrainDao.save(terrain);
		return 1;
		 }
		else return -1;
	}

	@Override
	public List<Terrain> findBySurface(BigDecimal surface) {
		return terrainDao.findBySurface(surface);
	}

	@Override
	public List<Terrain> findByDernierAnnePaiement(int dernierAnnePaiement) {
		return terrainDao.findByDernierAnnePaiement(dernierAnnePaiement);
	}

	@Override
	public int update(Long id, Terrain terrain) {
		if (findByid(id) == null) {
			return -1;
		}
		else {
		terrainDao.save(terrain);
		return 1;
		}
	}

	@Override
	public List<Terrain> findByDernierAnnePaiementAndNotificationNotificationTypeNumero(int dernierAnnePaiement,
			int numero) {
		return terrainDao.findByDernierAnnePaiementAndNotificationNotificationTypeNumero(dernierAnnePaiement, numero);
	}

	@Override
	public List<Terrain> findbyRedevableLibelle(String identifiant) {
		return terrainDao.findByRedevableIdentifiant(identifiant);
	}

	@Override
	public List<Terrain> findByQuartierLibelle(String libelle) {
		return terrainDao.findByQuartierLibelle(libelle);
	}

	@Override
	public List<Terrain> findByDernierAnnePaiementAndRedevableIdentifiant(int dernierAnnePaiement, String identifiant) {
		return terrainDao.findByDernierAnnePaiementAndRedevableIdentifiant(dernierAnnePaiement, identifiant);
	}

	@Override
	public List<Terrain> findByCategorieLibelle(String libelle) {
		return terrainDao.findByCategorieLibelle(libelle);
	}

	@Override
	public List<Terrain> findByDernierAnnePaiementAndQuartierLibelle(int dernierAnnePaiement, String Libelle) {
		return terrainDao.findByDernierAnnePaiementAndQuartierLibelle(dernierAnnePaiement, Libelle);
	}

	@Override
	public List<Terrain> findByDernierAnnePaiementAndQuartierSecteurLibelle(int dernierAnnePaiement, String Libelle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Terrain> findByRedevableIdentifiant(String identifiant) {
		return terrainDao.findByRedevableIdentifiant(identifiant);
	}


}
