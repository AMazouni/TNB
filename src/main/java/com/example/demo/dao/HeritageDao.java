package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Heritage;
import com.example.demo.bean.Redevable;
import com.example.demo.bean.Terrain;

@Repository
public interface HeritageDao extends JpaRepository<Heritage, Long> {
	public List<Heritage> findByRedevableOriginal(Redevable redevableOriginal);

	public List<Heritage> findByNouveauRedevable(Redevable nouveauRedevable);

	public List<Heritage> findByTerrainOriginal(Terrain terrainOriginal);

	public List<Heritage> findByNouveauTerrain(Terrain nouveauTerrain);
}
