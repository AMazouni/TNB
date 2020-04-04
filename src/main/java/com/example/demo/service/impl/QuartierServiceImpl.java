package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Quartier;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.QuartierDao;
import com.example.demo.service.facade.QuartierService;
import com.example.demo.service.facade.SecteurService;
import com.example.demo.service.facade.TerrainService;

@Service
public class QuartierServiceImpl implements QuartierService {
	@Autowired
	QuartierDao quartierDao;
	@Autowired
	SecteurService secteurService;
	@Autowired
	TerrainService terrainService;

	@Override
	public List<Quartier> findBySecteurId(Long secteurId) {
		return quartierDao.findBySecteurId(secteurId);
	}

	@Override
	public Quartier findById(Long id) {
		if (quartierDao.findById(id).isPresent()) {
			return quartierDao.findById(id).get();
		} else {
			return null;
		}

	}

	@Override
	public List<Quartier> findAll() {
		return quartierDao.findAll();
	}

	@Override
	@Transactional
	public int deleteById(Long id) {
		Quartier foundQuartier = findById(id);
		for (Terrain terrain : foundQuartier.getTerrains()) {
			terrainService.deleteById(terrain.getId());
		}
		quartierDao.deleteById(id);
		if (findById(id) == null) {
			return 1;
		} else
			return -1;
	}

	@Override
	@Transactional
	public int save(Quartier quartier) {

		if (secteurService.findByid(quartier.getSecteur().getId()) == null || quartier.getSecteur() == null)
			return -2; // se le secteur donné au quartier n'exist pas ou est null
		if (quartier.getLibelle() == null || quartier.getLibelle().equals(""))
			return -3; // si le Libelle donné est null ou vide
		quartierDao.save(quartier);
		if (quartier.getTerrains().size() > 0) {
			for (Terrain terrain : quartier.getTerrains()) {
				if (!terrain.getQuartier().getId().equals(quartier.getId()))
					terrain.setQuartier(quartier);
				// si le quartier donné au terrain est different du quartier qu'on veut
				// sauvegarder
				if (terrainService.findByid(terrain.getId()) == null)
					terrainService.save(terrain);
				// on sauvegarde le terrain seulement si il est pas deja dans la base de donne,
				// car chaque terrain dans la DB appartient deja
				// a un quartier different
			}
		}
		return 1;
	}

	@Override
	@Transactional
	public int update(Long id, Quartier quartier) {
		if (findById(quartier.getId()) == null)
			return -1; // Si le quartier n'exist pas dans la base de donne
		if (secteurService.findByid(quartier.getSecteur().getId()) == null || quartier.getSecteur() == null)
			return -2; // se le secteur donné au quartier n'exist pas ou est null
		if (quartier.getLibelle() == null || quartier.getLibelle() == "")
			return -3; // si le Libelle donné est null ou vide
		quartierDao.save(quartier);
		if (quartier.getTerrains().size() > 0) {
			for (Terrain terrain : quartier.getTerrains()) {
				if (terrain.getQuartier().getId() != quartier.getId())
					terrain.setQuartier(quartier);
				// si le quartier donné au terrain est different du quartier que voulons
				// mettre a jour
				if (terrainService.findByid(terrain.getId()) != null) terrainService.update(terrain.getId(), terrain);
				else terrainService.save(terrain);
				// si le terrain exist dans la BD on le met a jour sinon on le sauvegarde
			}
		}
		return 1;
	}
}
