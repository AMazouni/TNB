package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Heritage;
import com.example.demo.bean.Redevable;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.HeritageDao;
import com.example.demo.service.facade.HeritageService;
import com.example.demo.service.facade.RedevableService;
import com.example.demo.service.facade.TerrainService;
import com.example.demo.utils.DateUtils;

@Service
public class HeritageServiceImpl implements HeritageService {
	@Autowired
	HeritageDao heritageDao;
	@Autowired
	RedevableService redevableService;
	@Autowired
	TerrainService terrainService;

	@Override
	public Heritage findById(Long id) {
		if (heritageDao.findById(id).isPresent())
			return heritageDao.findById(id).get();
		else
			return null;
	}

	@Override
	public List<Heritage> findAll() {
		return heritageDao.findAll();
	}

	@Override
	public int save(Heritage heritage) {
		if (findById(heritage.getId()) != null)
			return -1;
		if (heritage.getNouveauRedevable() == null || heritage.getRedevableOriginal() == null)
			return -2;
		if (heritage.getTerrainOriginal() == null || heritage.getNouveauTerrain() == null)
			return -3;
		if (heritage.getPourcentage() > 1)
			return -4;
		heritageDao.save(heritage);
		return 1;
	}

	@Override
	public int update(Long id, Heritage heritage) {
		if (findById(id) == null)
			return -1;
		if (heritage.getNouveauRedevable() == null || heritage.getRedevableOriginal() == null)
			return -2;
		if (heritage.getTerrainOriginal() == null || heritage.getNouveauTerrain() == null)
			return -3;
		if (heritage.getPourcentage() > 1)
			return -4;
		heritageDao.save(heritage);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		heritageDao.deleteById(id);
		if (findById(id) == null)
			return 1;
		else
			return -1;
	}

	@Override
	public int saveMultipleHeritage(String RedevableOriginalIdentifiant, List<String> nouveauxRedevableIdentifiant,
			List<Float> pourcentages, Long terrainOriginalId) {
		if (redevableService.findByIdentifiant(RedevableOriginalIdentifiant) == null)
			return -1;
		for (String string : nouveauxRedevableIdentifiant) {
			if (redevableService.findByIdentifiant(string) == null)
				return -2;
		}
		Redevable redevableOriginal = redevableService.findByIdentifiant(RedevableOriginalIdentifiant);
		Terrain terrainOriginal = terrainService.findByid(terrainOriginalId);
		if (terrainOriginal.getDernierAnnePaiement() != DateUtils.getYear())
			return -3;
		for (String nouveauRedevableIdentifiant : nouveauxRedevableIdentifiant) {
			for (Float pourcentage : pourcentages) {
				List<TaxeTNB> taxes = new ArrayList<TaxeTNB>();
				double NewSuraceDouble = terrainOriginal.getSurface().doubleValue() * pourcentage;
				NewSuraceDouble = Math.round((NewSuraceDouble * 100) / 100);
				BigDecimal NewSurface = new BigDecimal(NewSuraceDouble);
				Terrain nouveauTerrain = new Terrain(NewSurface, terrainOriginal.getQuartier(),
						redevableService.findByIdentifiant(nouveauRedevableIdentifiant), terrainOriginal.getCategorie(),
						terrainOriginal.getDernierAnnePaiement(), null, taxes);
				terrainService.save(terrainOriginal);
				Heritage heritage = new Heritage(redevableOriginal, terrainOriginal,
						redevableService.findByIdentifiant(nouveauRedevableIdentifiant), pourcentage, nouveauTerrain);
				save(heritage);
			}
		}
		return 1;
	}

	@Override
	public List<Heritage> findByRedevableOriginal(Redevable redevableOriginal) {
		return heritageDao.findByRedevableOriginal(redevableOriginal);
	}

	@Override
	public List<Heritage> findByNouveauRedevable(Redevable nouveauRedevable) {
		return heritageDao.findByNouveauRedevable(nouveauRedevable);
	}

	@Override
	public List<Heritage> findByTerrainOriginal(Terrain terrainOriginal) {
		return heritageDao.findByTerrainOriginal(terrainOriginal);
	}

	@Override
	public List<Heritage> findByNouveauTerrain(Terrain nouveauTerrain) {
		return heritageDao.findByNouveauTerrain(nouveauTerrain);
	}

}
