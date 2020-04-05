package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.bean.Redevable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.TerrainDao;
import com.example.demo.service.facade.CategorieService;
import com.example.demo.service.facade.QuartierService;
import com.example.demo.service.facade.RedevableService;
import com.example.demo.service.facade.TaxeTNBService;
import com.example.demo.service.facade.TerrainService;
import com.example.demo.utils.DateUtils;

@Service
public class TerrainServiceImpl implements TerrainService {
	@Autowired
	TerrainDao terrainDao;
	@Autowired
	RedevableService redevableService;
	@Autowired
	QuartierService quartierService;
	@Autowired
	CategorieService categorieService;
	@Autowired
	TaxeTNBService taxeTNBservice;

	@Override
	public List<Terrain> findAll() {
		return terrainDao.findAll();
	}

	@Override
	public Terrain findByid(Long id) {
		if (terrainDao.findById(id).isPresent()) {
			return terrainDao.findById(id).get();
		} else
			return null;
	}

	@Override
	public int deleteById(Long id) {
		taxeTNBservice.deleteByTerrainId(id);
		terrainDao.deleteById(id);
		if (findByid(id) == null) {
			return 1;
		} else
			return -1;
	}

	@Override
	@Transactional
	public int save(Terrain terrain) {
		if (findByid(terrain.getId()) != null)
			return -1;
		if (quartierService.findById(terrain.getQuartier().getId()) == null
				|| redevableService.findById(terrain.getRedevable().getId()) == null
				|| categorieService.findById(terrain.getCategorie().getId()) == null)
			return -2;
		if (terrain.getSurface() == null)
			return -3;
		terrainDao.save(terrain);
		for (TaxeTNB taxeTNB : terrain.getTaxesTNB()) {
			if (taxeTNB.getTerrain().getId() != terrain.getId()) taxeTNB.setTerrain(terrain);
			if (taxeTNBservice.findById(taxeTNB.getId()) == null) taxeTNBservice.save(taxeTNB);
		}
		return 1;
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
	@Transactional
	public int update(Long id, Terrain terrain) {
		if (findByid(terrain.getId()) == null)
			return -1;
		if (quartierService.findById(terrain.getQuartier().getId()) == null
				|| redevableService.findById(terrain.getRedevable().getId()) == null
				|| categorieService.findById(terrain.getCategorie().getId()) == null)
			return -2;
		if (terrain.getSurface() == null)
			return -3;
		terrainDao.save(terrain);
		for (TaxeTNB taxeTNB : terrain.getTaxesTNB()) {
			if (taxeTNB.getTerrain().getId() != terrain.getId()) taxeTNB.setTerrain(terrain);
			if (taxeTNBservice.findById(taxeTNB.getId()) == null) taxeTNBservice.save(taxeTNB);
			else taxeTNBservice.update(taxeTNB);
		}
		return 1;
	}


	@Override
	public List<Terrain> findByDernierAnnePaiementAndNotificationNotificationTypeNumero(int dernierAnnePaiement,
			int numero) {
		return terrainDao.findByDernierAnnePaiementAndNotificationNotificationTypeNumero(dernierAnnePaiement, numero);
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
		return terrainDao.findByDernierAnnePaiementAndQuartierSecteurLibelle(dernierAnnePaiement,Libelle);
	}

	@Override
	public List<Terrain> findByRedevableIdentifiant(String identifiant) {
		return terrainDao.findByRedevableIdentifiant(identifiant);
	}

	@Override
	public List<Terrain> findAllTerrainsNonPaye() {
		List<Terrain> terrains = findAll();
		List<Terrain> terrainsNonPaye = new ArrayList<Terrain>();
		for (Terrain terrain : terrains) {
			if (terrain.getDernierAnnePaiement() != DateUtils.getYear()) terrainsNonPaye.add(terrain);
		}
		return terrainsNonPaye;
	}

	@Override
	public List<Terrain> findTerrainsRedevableNonPaye(Long redevableId) {
		Redevable redevable=redevableService.findById(redevableId);
		List<Terrain> terrains = redevable.getTerrains();
		List<Terrain> terrainsNonPaye = new ArrayList<Terrain>();
		for (Terrain terrain : terrains) {
			if (terrain.getDernierAnnePaiement() != DateUtils.getYear()) terrainsNonPaye.add(terrain);
		}
		return terrainsNonPaye;
	}

	@Override
	public void saveWithNotif(Terrain terrain) {
		terrainDao.save(terrain);
	}

}
