package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Redevable;
import com.example.demo.beans.TaxeTNB;
import com.example.demo.beans.Terrain;
import com.example.demo.dao.TaxeTNBDao;
import com.example.demo.service.facade.TaxeTNBService;

@Service
public class TaxeTNBServiceImpl implements TaxeTNBService {

	@Autowired
	TaxeTNBDao taxeTNBDao;

	@Override
	public List<TaxeTNB> findByTerrain(Terrain terrain) {
		return taxeTNBDao.findByTerrain(terrain);
	}

	@Override
	public List<TaxeTNB> findByTerrainId(Long id) {
		return taxeTNBDao.findByTerrainId(id);
	}

	@Override
	public List<TaxeTNB> findByRedevable(Redevable redevable) {
		return taxeTNBDao.findByRedevable(redevable);
	}

	@Override
	public List<TaxeTNB> findByRedevableIdentifiant(String identifiant) {
		return taxeTNBDao.findByRedevableIdentifiant(identifiant);
	}

	@Override
	public List<TaxeTNB> findByAnnee(Integer annee) {
		return taxeTNBDao.findByAnnee(annee);
	}

	@Override
	public int save(TaxeTNB taxeTNB) {
		if (this.findById(taxeTNB.getId()) != null)
			return 0;
		taxeTNBDao.save(taxeTNB);
		return 1;
	}

	@Override
	public int update(TaxeTNB taxeTNB) {
		if (this.findById(taxeTNB.getId()) == null)
			return 0;
		taxeTNBDao.save(taxeTNB);
		return 1;
	}

	@Override
	public int delete(TaxeTNB taxeTNB) {
		if (this.findById(taxeTNB.getId()) == null)
			return 0;
		taxeTNBDao.delete(taxeTNB);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		if (this.findById(id) == null)
			return 0;
		taxeTNBDao.deleteById(id);
		return 1;
	}

	@Override
	public TaxeTNB findById(Long id) {
		if (taxeTNBDao.findById(id).isPresent())
			return taxeTNBDao.findById(id).get();
		else
		return null;
	}

}
