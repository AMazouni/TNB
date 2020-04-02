package com.example.demo.dao;

import com.example.demo.bean.TypeTerrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeTerrainDao extends JpaRepository<TypeTerrain,Long> {
    public List<TypeTerrain> findbyTypeTerrainlibelle(String libelle);
    public List<TypeTerrain> findbyTypeTerraincodeReference(String codeReference);
    public List<TypeTerrain> findByTypeTerrainid(Long id);

}