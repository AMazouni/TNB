package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Terrain;
import com.example.demo.dao.TerrainDao;
import com.example.demo.service.facade.TerrainService;
@Service
public class TerrainServiceImpl implements TerrainService{
	@Autowired
	TerrainDao terrainDao;
	@Override
	public List<Terrain> findAll() {
		return terrainDao.findAll();
	}

	@Override
	public Terrain findByid(Long id) {
		if (terrainDao.findById(id).isPresent()) {
			return terrainDao.findById(id).get();
		} else return null;
	}

	@Override
	public int deleteById(Long id) {
		terrainDao.deleteById(id);
		if (findByid(id) == null) {
			return 1;
		} else return -1;
	}

	@Override
	public void save(Terrain terrain) {
		terrainDao.save(terrain);
	}

	@Override
	public List<Terrain> findbyRedevableId(Long id) {
		return terrainDao.findByRedevableId(id);
	}

	@Override
	public List<Terrain> findByQuartierId(Long id) {
		return terrainDao.findByQuartierId(id);
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
	public int update(Long id, Terrain terrain) {
		if (findByid(id) == null) {
			return -1;
		}
		else {
		terrainDao.save(terrain);
		return 1;
		}
	}

	@Override
	public List<Terrain> findByDernierAnnePaiementAndNotificationNotificationTypeNumero(int dernierAnnePaiement,
			int numero) {
		return terrainDao.findByDernierAnnePaiementAndNotificationNotificationTypeNumero(dernierAnnePaiement, numero);
	}

}
