package com.example.demo.ws.rest;

import com.example.demo.bean.Quartier;
import com.example.demo.service.facade.TypeTerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.demo.bean.TypeTerrain;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/TNB-Api/TypeTerrain")
public class TypeTerrainRest {
    @Autowired
    TypeTerrainService typeTerrainService;

    @GetMapping("/findbyTypeTerrainlibelle/{libelle}")
    public List<TypeTerrain> findbyTypeTerrainlibelle(@PathVariable("libelle") String libelle) {
        return typeTerrainService.findbyTypeTerrainlibelle(libelle);
    }

    @GetMapping("/findbyTypeTerraincodeReference/{codeReference}")
    public List<TypeTerrain> findbyTypeTerraincodeReference(@PathVariable("codeReference") String codeReference) {
        return typeTerrainService.findbyTypeTerraincodeReference(codeReference);
    }
    @GetMapping("/findByTypeTerrainid/{id}")
    public List<TypeTerrain> findByTypeTerrainid(@PathVariable("id") Long id) {
        return typeTerrainService.findByTypeTerrainid(id);
    }

}
