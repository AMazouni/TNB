package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.demo.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RedevableDao;
import com.example.demo.service.facade.AchatService;
import com.example.demo.service.facade.CategorieService;
import com.example.demo.service.facade.NotificationService;
import com.example.demo.service.facade.QuartierService;
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
	@Autowired
	AchatService achatServiceImpl;
	@Autowired
	CategorieService categorieService;
	@Autowired
	QuartierService quartierService;

	public Redevable findById(Long id) {
		if (!redevableDao.findById(id).isPresent())
			return null;
		else
			return redevableDao.findById(id).get();
	}

	@Override
	public int save(Redevable redevable) {
		TypeRedevable typeRedevable1 = typeRedevableService.findByLibelle(redevable.getTypeRedevable().getLibelle());
		List<Terrain> ter = new ArrayList<Terrain>();
		if (this.findByIdentifiant(redevable.getIdentifiant()) != null) {
			return -1;
		} else if (typeRedevable1 == null) {
			return -2;
		}else {
		List<Terrain> terrains = redevable.getTerrains();
	//	System.out.println(terrains);
		redevable.setTerrains(ter);
		redevable.setTypeRedevable(typeRedevable1);
		redevableDao.save(redevable);
		for (Terrain terrain : terrains) {
			System.out.println(terrain);
			Categorie categorie = categorieService.findById(terrain.getCategorie().getId());
			Quartier quartier = quartierService.findById(terrain.getQuartier().getId());
			terrain.setRedevable(redevable);
			terrain.setCategorie(categorie);
			terrain.setQuartier(quartier);
			terrain.setDernierAnnePaiement(DateUtils.getYear());
		//	System.out.println(terrain);
			terrainService.save(terrain);
		}
		}
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
				if (taxeTNB.getNombreMoisRetard() == nombreMoisDeRetard)
					resultat.add(redevable);
			}
		}
		return resultat;
	}

	public List<Redevable> findRedevablequiaAcheterUnTerrainDeceRedevable(Long id) {
		List<Achat> achats = achatServiceImpl.findAll();
		List<Redevable> result = new ArrayList<Redevable>();
		for (Achat achat : achats) {
			if (achat.getOldredevable().getId() == id)
				result.add(achat.getNewRedevable());
		}
		return result;
	}

	public List<Redevable> findRedevablequiVendreUnTerrainDeceRedevable(Long id) {
		List<Achat> achats = achatServiceImpl.findAll();
		List<Redevable> result = new ArrayList<Redevable>();
		for (Achat achat : achats) {
			if (achat.getNewRedevable().getId() == id)
				result.add(achat.getOldredevable());
		}
		return result;
	}

	@Override
	public Redevable findRedevablequiaAcheterUnTerrainDeceRedevableDansCetteDate(Long id, Date date) {
		List<Achat> achats = achatServiceImpl.findAll();
		Redevable result =new Redevable();
		for (Achat achat : achats) {
			if (achat.getOldredevable().getId() == id && DateUtils.compareDate(achat.getDateachat(), date))
				result = achat.getNewRedevable();
		}
		return result;
	}

	@Override
	public Redevable findRedevablequiVendreUnTerrainDeceRedevableDansCetteDate(Long id, Date date) {
		List<Achat> achats = achatServiceImpl.findAll();
		Redevable result =new Redevable();
		for (Achat achat : achats) {
			if (achat.getNewRedevable().getId() == id && DateUtils.compareDate(achat.getDateachat(), date))
				result = achat.getOldredevable();
		}
		return result;
	}

	@Override
	public List<Redevable> findRedevableVendreUnTerrainDansCetteDate(Date date) {
		List<Achat> achats = achatServiceImpl.findAll();
		List<Redevable> result =new ArrayList<Redevable>();
		for (Achat achat : achats) {
			if ( DateUtils.compareDate(achat.getDateachat(), date))
				result.add(achat.getOldredevable());
		}
		return result;
	}

	@Override
	public List<Redevable> findRedevableAcheterUnTerrainDansCetteDate(Date date) {
		List<Achat> achats = achatServiceImpl.findAll();
		List<Redevable> result =new ArrayList<Redevable>();
		for (Achat achat : achats) {
			if ( DateUtils.compareDate(achat.getDateachat(), date))
				result.add(achat.getNewRedevable());
		}
		return result;
	}

	@Override
	public List<Redevable> findRedevableAcheterCeUnTerrain(Long id) {
		List<Achat> achats = achatServiceImpl.findAll();
		List<Redevable> result =new ArrayList<Redevable>();
		for (Achat achat : achats) {
			if (achat.getTerrain().getId() == id)
				result.add(achat.getNewRedevable());
		}
		return result;
	}

	@Override
	public List<Redevable> findRedevablevendreCeTerrain(Long id) {
		List<Achat> achats = achatServiceImpl.findAll();
		List<Redevable> result =new ArrayList<Redevable>();
		for (Achat achat : achats) {
			if (achat.getTerrain().getId() == id)
				result.add(achat.getOldredevable());
		}
		return result;
	}

	@Override
	public List<Redevable> findRedevableAcheterentreCesDeuxDates(Date date1, Date date2) {
		List<Achat> achats = achatServiceImpl.findAll();
		List<Redevable> result =new ArrayList<Redevable>();
		for (Achat achat : achats) {
			if (DateUtils.getDatebetween(achat.getDateachat(), date1, date2))
				result.add(achat.getNewRedevable());
		}
		return result;
	}

	@Override
	public List<Redevable> findRedevablevendreCesDeuxDate(Date date1, Date date2) {
		List<Achat> achats = achatServiceImpl.findAll();
		List<Redevable> result =new ArrayList<Redevable>();
		for (Achat achat : achats) {
			if (DateUtils.getDatebetween(achat.getDateachat(), date1, date2))
				result.add(achat.getOldredevable());
		}
		return result;
	}

	@Override
	public List<Redevable> findRedevableQuiOntUnTerrainDeCeCategorie(Long id) {
		List<Terrain> terrains = terrainService.findAll();
		List<Redevable> result =new ArrayList<Redevable>();
		for (Terrain terrain : terrains) {
			if (terrain.getCategorie().getId()  == id)
				result.add(terrain.getRedevable());
		}
		return result;
	}

	@Override
	public List<Redevable> findRedevablevendreQuiOntUnTerrainDansCeQuartier(Long id) {
		List<Terrain> terrains = terrainService.findAll();
		List<Redevable> result =new ArrayList<Redevable>();
		for (Terrain terrain : terrains) {
			if (terrain.getQuartier().getId()  == id)
				result.add(terrain.getRedevable());
		}
		return result;
	}

	@Override
	public List<Redevable> findRedevableOntUnTerrainDeCeSurface(BigDecimal surface) {
		List<Terrain> terrains = terrainService.findAll();
		List<Redevable> result =new ArrayList<Redevable>();
		for (Terrain terrain : terrains) {
			if (terrain.getSurface() == surface)
				result.add(terrain.getRedevable());
		}
		return result;
	}

	@Override
	public List<Redevable> findAllRedevablesWithNpTerrains() {
		List<Redevable> redevables = redevableDao.findAll();
		List<Redevable> redevableNpList=new ArrayList<>();
		for (Redevable r:redevables
			 ) {
			if (terrainService.findTerrainsRedevableNonPaye(r.getId()).size()>0){
				Redevable redevable=new Redevable();
				redevable.setId(r.getId());
				redevable.setTypeRedevable(r.getTypeRedevable());
				redevable.setIdentifiant(r.getIdentifiant());
				redevable.setNom(r.getNom());
				redevable.setTaxesTNB(r.getTaxesTNB());
				redevable.setTerrains(terrainService.findTerrainsRedevableNonPaye(r.getId()));
				redevableNpList.add(redevable);
			}
		}
		return redevableNpList;
	}

	@Override
	public List<Redevable> findAllRedevablesWithNotificationsByNotifType(Long idNotificationType) {
		List<Redevable> redevables = redevableDao.findAll();
		List<Redevable> redevableNotifList=new ArrayList<>();
		for (Redevable r:redevables
		) {
			if (terrainService.findTerrainsRedevableNotification(r.getId(),idNotificationType).size()>0){
				Redevable redevable=new Redevable();
				redevable.setId(r.getId());
				redevable.setTypeRedevable(r.getTypeRedevable());
				redevable.setIdentifiant(r.getIdentifiant());
				redevable.setNom(r.getNom());
				redevable.setTaxesTNB(r.getTaxesTNB());
				redevable.setTerrains(terrainService.findTerrainsRedevableNotification(r.getId(),idNotificationType));
				redevableNotifList.add(redevable);
			}
		}
		return redevableNotifList;
	}
}