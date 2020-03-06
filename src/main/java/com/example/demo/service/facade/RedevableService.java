package com.example.demo.service.facade;

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

}
