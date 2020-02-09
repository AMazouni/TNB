package com.example.demo.ws.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.Terrain;
import com.example.demo.service.facade.TerrainService;

@Repository
@RequestMapping("/TNB-Api/Terrain")
public class TerrainRest {
	@Autowired
	TerrainService terrainService;
	@GetMapping("/findAll")
	public List<Terrain> findAll() {
		return terrainService.findAll();
	}
	@GetMapping("/findById/{id}")
	public Terrain findByid(@PathVariable("id") Long id) {
		return terrainService.findByid(id);
	}
	@DeleteMapping("/deleteById/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return terrainService.deleteById(id);
	}
    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Terrain terrain) {
		terrainService.save(terrain);
	}
    @GetMapping("/findByRedevableId/{id}")
	public List<Terrain> findbyRedevableId(@PathVariable("id") Long id) {
		return terrainService.findbyRedevableId(id);
	}
    @GetMapping("/findByQuartierId/{id}")
	public List<Terrain> findByQuartierId(@PathVariable("id") Long id) {
		return terrainService.findByQuartierId(id);
	}
    @GetMapping("/findBySurface/{surface}")
	public List<Terrain> findBySurface(@PathVariable("surface") BigDecimal surface) {
		return terrainService.findBySurface(surface);
	}
    @GetMapping("/findByDernierAnnePaiement/{dernierAnnePaiement}")
	public List<Terrain> findByDernierAnnePaiement(@PathVariable("dernierAnnePaiement") int dernierAnnePaiement) {
		return terrainService.findByDernierAnnePaiement(dernierAnnePaiement);
	}
    @PutMapping(path = "/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable("id") Long id,@RequestBody Terrain terrain) {
		terrainService.update(id, terrain);
	}
	
}
