package com.example.demo.service.facade;

import com.example.demo.bean.TypeTerrain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeTerrainService {

    public List<TypeTerrain> findbyTypeTerrainlibelle(String libelle);
    public List<TypeTerrain> findbyTypeTerraincodeReference(String codeReference);
    public List<TypeTerrain> findByTypeTerrainid(Long id);

}