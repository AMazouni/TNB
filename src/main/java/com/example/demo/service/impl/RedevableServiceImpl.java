package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.bean.TypeRedevable;
import com.example.demo.dao.RedevableDao;
import com.example.demo.service.facade.NotificationService;
import com.example.demo.service.facade.RedevableService;
import com.example.demo.service.facade.TaxeTNBService;
import com.example.demo.service.facade.TerrainService;
import com.example.demo.service.facade.TypeRedevableService;
import com.example.demo.utils.DateUtils;

@Service
public class RedevableServiceImpl implements RedevableService {

	@Autowired
	RedevableDao redevableDao;
	@Autowired
	TerrainService terrainService;
	@Autowired
	TypeRedevableService typeRedevableService;
	@Autowired
	NotificationService notificationService;
	@Autowired
	TaxeTNBService taxeTnbService;

	public Redevable findById(Long id) {
		if (!redevableDao.findById(id).isPresent())
			return null;
		else
			return redevableDao.findById(id).get();
	}

	@Override
	public int save(Redevable redevable) {
		TypeRedevable typeRedevable1 = typeRedevableService.findById(redevable.getTypeRedevable().getId());
		List<Terrain> terrains = new ArrayList<Terrain>();
		terrains = redevable.getTerrains();
		Boolean search = false;
		for (Terrain terrain : terrains) {
			if (terrainService.findByid(terrain.getId()) != null)
				search = true;
		}
		if (this.findByIdentifiant(redevable.getIdentifiant()) != null) {
			return -1;
		} else if (typeRedevable1 == null) {
			return -2;
		} else if (search == false) {
			return -3;
		}
		redevable.setTypeRedevable(typeRedevable1);
		redevableDao.save(redevable);
		return 1;
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
	public List<Redevable> findByTypeRedevableLibelle(String libelle) {
		return redevableDao.findByTypeRedevableLibelle(libelle);
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
		Calendar calendrier = Calendar.getInstance();
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
		Calendar calendrier = Calendar.getInstance();
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

	@Override
	public List<Redevable> findRedevablePayer() {
		List<Redevable> redevables = findAll();
		List<Redevable> redevablePayer = new ArrayList<Redevable>();
		Calendar calendrier = Calendar.getInstance();
		int anneeEnCours = calendrier.get(Calendar.YEAR);
		for (Redevable redevable : redevables) {
			List<Terrain> terrains = terrainService.findByRedevableIdentifiant(redevable.getIdentifiant());
			for (Terrain terrain : terrains) {
				if (terrain.getDernierAnnePaiement() == anneeEnCours) {
					redevablePayer.add(redevable);
				}
			}
		}
		return redevablePayer;
	}

	public List<Redevable> findRedevableAyantNotification(int numeroNotification) {
		List<Redevable> redevables = new ArrayList<Redevable>();
		List<Redevable> resultat = new ArrayList<Redevable>();
		List<Terrain> terrains = new ArrayList<Terrain>();
		redevables = findAll();
		for (Redevable redevable : redevables) {
			terrains = null;
			terrains = redevable.getTerrains();
			for (Terrain terrain : terrains) {
				if (terrain.getNotification().getNotificationType().getNumero() == numeroNotification)
					resultat.add(redevable);

			}
		}
		return resultat;
	}

	@Override
	public List<Redevable> findByTypeRedevableAndNonPayer(TypeRedevable typeRedevable) {
		List<Redevable> redevables = new ArrayList<Redevable>();
		redevables = findRedevableNonPayer();
		List<Redevable> resultat = new ArrayList<Redevable>();
		for (Redevable redevable : redevables) {
			if (redevable.getTypeRedevable() == typeRedevable)
				resultat.add(redevable);
		}
		return resultat;
	}

	public List<Redevable> findRedevablePayerdans(Date date) {
		List<Redevable> redevables = new ArrayList<Redevable>();
		redevables = findAll();
		List<Redevable> resultat = new ArrayList<Redevable>();
		List<TaxeTNB> taxeTNBs = new ArrayList<TaxeTNB>();
		for (Redevable redevable : redevables) {
			taxeTNBs = null;
			taxeTNBs = redevable.getTaxesTNB();
			for (TaxeTNB taxeTNB : taxeTNBs) {
				if (DateUtils.compareDate(taxeTNB.getDateTaxeTNB(), date))
					resultat.add(redevable);
			}
		}
		return resultat;
	}
	@Override
	public List<Redevable> findRedevableNonPayerAyantnombreRetard(Integer nombreMoisDeRetard) {
		List<Redevable> redevables = new ArrayList<Redevable>();
		redevables = findRedevableNonPayer();
		List<TaxeTNB> taxeTNBs = new ArrayList<TaxeTNB>();
		List<Redevable> resultat = new ArrayList<Redevable>();		
		for (Redevable redevable : redevables) {
			taxeTNBs = null;
			taxeTNBs = redevable.getTaxesTNB();
			for (TaxeTNB taxeTNB : taxeTNBs) {
				if(taxeTNB.getNombreMoisRetard()==nombreMoisDeRetard)
					resultat.add(redevable);
			}
	}
		return resultat;
}
	}