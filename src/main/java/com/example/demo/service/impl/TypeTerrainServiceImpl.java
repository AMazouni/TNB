package com.example.demo.service.impl;

import com.example.demo.bean.TypeTerrain;
import com.example.demo.dao.TypeTerrainDao;
import com.example.demo.service.facade.TypeTerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeTerrainServiceImpl implements TypeTerrainService {
    @Autowired
    TypeTerrainDao typeterraindao;


    @Override
    public List<TypeTerrain> findbyTypeTerrainlibelle(String libelle) {
        return typeterraindao.findbyTypeTerrainlibelle(libelle);
    }

    @Override
    public List<TypeTerrain> findbyTypeTerraincodeReference(String codeReference) {
        return typeterraindao.findbyTypeTerraincodeReference(codeReference);
    }

    @Override
    public List<TypeTerrain> findByTypeTerrainid(Long id) {


        return typeterraindao.findByTypeTerrainid(id);
    }
}