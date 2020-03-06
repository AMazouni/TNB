package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Notification;
import com.example.demo.bean.Redevable;
import com.example.demo.bean.Terrain;
import com.example.demo.bean.TypeRedevable;
import com.example.demo.dao.RedevableDao;
import com.example.demo.service.facade.RedevableService;
import com.example.demo.service.facade.TerrainService;
import com.example.demo.service.facade.TypeRedevableService;

@Service
public class RedevableServiceImpl implements RedevableService {

	@Autowired
	RedevableDao redevableDao;
	@Autowired
	TerrainService terrainService;
	@Autowired
	TypeRedevableService typeRedevableService;


	public Redevable findById(Long id) {
		if (!redevableDao.findById(id).isPresent())
			return null;
		else
			return redevableDao.findById(id).get();
	}

	@Override
	public int save(Redevable redevable) {
		TypeRedevable typeRedevable1 = typeRedevableService.findById(redevable.getTypeRedevable().getId());
		if (this.findByIdentifiant(redevable.getIdentifiant()) != null) {
			return -1;
		}
		if (typeRedevable1 == null) {
			return -2;
		} else {
			redevable.setTypeRedevable(typeRedevable1);
			redevableDao.save(redevable);
			return 1;
		}
	}

	@Override
	public int update(Redevable redevable) {
		if (this.findByIdentifiant(redevable.getIdentifiant()) == null)
			return 0;
		redevableDao.save(redevable);
		return 1;
	}

	@Override
	public int deleteByIdentifiant(String identifiant) {
		if (this.findByIdentifiant(identifiant) == null)
			return 0;
		else {
			redevableDao.delete(findByIdentifiant(identifiant));
			return 1;
		}
	}

	@Override
	public Redevable findByIdentifiant(String identifiant) {
		return redevableDao.findByIdentifiant(identifiant);
	}

	@Override
	public List<Redevable> findByTypeRedevable(TypeRedevable type) {
		return redevableDao.findByTypeRedevable(type);
	}

	@Override
	public List<Redevable> findByTypeRedevableId(Long id) {
		return redevableDao.findByTypeRedevableId(id);
	}

	@Override
	public List<Redevable> findAll() {
		return redevableDao.findAll();
	}

	@Override
	public Redevable findByNom(String nom) {
		return redevableDao.findByNom(nom);
	}

	@Override
	public List<Redevable> findRedevableNonPayer() {
		List<Redevable> redevables = findAll();
		List<Redevable> redevableNonPayer = new ArrayList<Redevable>();
		Calendar calendrier =Calendar.getInstance();
		int anneeEnCours = calendrier.get(Calendar.YEAR);
		for (Redevable redevable : redevables) {
			List<Terrain> terrains = terrainService.findByRedevableIdentifiant(redevable.getIdentifiant());
			for (Terrain terrain : terrains) {
				if (terrain.getDernierAnnePaiement() != anneeEnCours) {
					redevableNonPayer.add(redevable);
				}
			}
		}
		return redevableNonPayer;
	}

	@Override
	public Boolean testpaymentRedevable(Redevable redevable) {
		boolean test = true;
		Calendar calendrier =Calendar.getInstance();
		int anneeEnCours = calendrier.get(Calendar.YEAR);
			List<Terrain> terrains = terrainService.findByRedevableIdentifiant(redevable.getIdentifiant());
			for (Terrain terrain : terrains) {
				if (terrain.getDernierAnnePaiement() != anneeEnCours) {
					test = false;
				}
		}
		return test;
	}

	@Override
	public Redevable findByTerrain(Terrain terrain) {
		Redevable redevable = findById(terrain.getRedevable().getId());
		return redevable;
	}

}