package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.beans.Redevable;
import com.example.demo.beans.TaxeTNB;
import com.example.demo.beans.Terrain;

public interface TaxeTNBService {
	public List<TaxeTNB> findByTerrain(Terrain terrain);

	public List<TaxeTNB> findByTerrainId(Long id);

	public List<TaxeTNB> findByRedevable(Redevable redevable);

	public List<TaxeTNB> findByRedevableIdentifiant(String identifiant);

	public List<TaxeTNB> findByAnnee(Integer annee);

	public int save(TaxeTNB taxeTNB);

	public int update(TaxeTNB taxeTNB);

	public int delete(TaxeTNB taxeTNB);

	public int deleteById(Long id);

	public TaxeTNB findById(Long id);
}
