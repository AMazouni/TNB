package com.example.demo.service.facade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.Terrain;
import com.example.demo.bean.TypeRedevable;

public interface RedevableService {

	public Redevable findById(Long id);

	public int save(Redevable redevable);

	public int update(Redevable redevable);

	public Redevable findByIdentifiant(String identifiant);

	public List<Redevable> findAll();

	public List<Redevable> findByTypeRedevable(TypeRedevable type);

	public List<Redevable> findByTypeRedevableId(Long id);

	public int deleteByIdentifiant(String identifiant);

	public Redevable findByNom(String nom);

	public List<Redevable> findRedevableNonPayer();

	public Boolean testpaymentRedevable(Redevable redevable);

	public Redevable findByTerrain(Terrain terrain);

	public List<Redevable> findByTypeRedevableLibelle(String libelle);

	public List<Redevable> findRedevablePayer();

	public List<Redevable> findRedevableAyantNotification(int numeroNotification);

	public List<Redevable> findByTypeRedevableAndNonPayer(TypeRedevable typeRedevable);

	public List<Redevable> findRedevablePayerdans(Date date);

	public List<Redevable> findRedevableNonPayerAyantnombreRetard(Integer nombreMoisDeRetard);

	public List<Redevable> findRedevablequiaAcheterUnTerrainDeceRedevable(Long id);

	public List<Redevable> findRedevablequiVendreUnTerrainDeceRedevable(Long id);

	public Redevable findRedevablequiaAcheterUnTerrainDeceRedevableDansCetteDate(Long id, Date date);

	public Redevable findRedevablequiVendreUnTerrainDeceRedevableDansCetteDate(Long id, Date date);

	public List<Redevable> findRedevableVendreUnTerrainDansCetteDate(Date date);

	public List<Redevable> findRedevableAcheterUnTerrainDansCetteDate(Date date);

	public List<Redevable> findRedevableAcheterCeUnTerrain(Long id);

	public List<Redevable> findRedevablevendreCeTerrain(Long id);

	public List<Redevable> findRedevableAcheterentreCesDeuxDates(Date date1, Date date2);

	public List<Redevable> findRedevablevendreCesDeuxDate(Date date1, Date date2);

	public List<Redevable> findRedevableQuiOntUnTerrainDeCeCategorie(Long id);

	public List<Redevable> findRedevablevendreQuiOntUnTerrainDansCeQuartier(Long id);

	List<Redevable> findRedevableOntUnTerrainDeCeSurface(BigDecimal surface);
}
