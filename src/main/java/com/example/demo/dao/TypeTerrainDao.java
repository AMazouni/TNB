package com.example.demo.dao;

import com.example.demo.bean.TypeTerrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeTerrainDao extends JpaRepository<TypeTerrain,Long> {
    public List<TypeTerrain> findByLibelle(String libelle);
    public List<TypeTerrain> findByCodeReference(String codeReference);
    public TypeTerrain findByid(Long id);

}