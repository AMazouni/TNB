package com.example.demo.service.facade;

import java.util.List;
import com.example.demo.bean.Heritage;
import com.example.demo.bean.Redevable;
import com.example.demo.bean.Terrain;

public interface HeritageService {
	public Heritage findById(Long id);

	public List<Heritage> findAll();

	public int save(Heritage heritage);

	public int update(Long id, Heritage heritage);

	public int deleteById(Long id);

	public List<Heritage> findByRedevableOriginal(Redevable redevableOriginal);

	public List<Heritage> findByNouveauRedevable(Redevable nouveauRedevable);

	public List<Heritage> findByTerrainOriginal(Terrain terrainOriginal);

	public List<Heritage> findByNouveauTerrain(Terrain nouveauTerrain);
	
	public int saveMultipleHeritage(String RedevableOriginalIdentifiant,List<String> nouveauxRedevableIdentifiant,List<Float> pourcentages,Long terrainOriginalId);
}
