package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;

@Repository
public interface TaxeTNBDao extends JpaRepository<TaxeTNB, Long> {

	public List<TaxeTNB> findByTerrain(Terrain terrain);

	public List<TaxeTNB> findByTerrainId(Long id);

	public List<TaxeTNB> findByRedevable(Redevable redevable);

	public List<TaxeTNB> findByRedevableIdentifiant(String identifiant);

	public List<TaxeTNB> findByAnnee(Integer annee);
	
	public int deleteByTerrainId(Long id);

}
