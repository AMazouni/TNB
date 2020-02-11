package com.example.demo.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.service.facade.TaxeTNBService;

@Repository
@RequestMapping("/TNB-Api/taxetnb")
public class TaxeTNBRest {

	@Autowired
	TaxeTNBService taxeTNBService;
	@PostMapping(path = "/findbyterrain")
	public List<TaxeTNB> findByTerrain(@RequestBody Terrain terrain){
		return taxeTNBService.findByTerrain(terrain);
	}
	@GetMapping("/findbyterrain/{id}")
	public List<TaxeTNB> findByTerrainId(@PathVariable("id") Long id){ 
		return taxeTNBService.findByTerrainId(id);
	}
	@PostMapping(path = "/findbyredevable")
	public List<TaxeTNB> findByRedevable(@RequestBody Redevable redevable){
		return taxeTNBService.findByRedevable(redevable);
	}
	@GetMapping("/findbyredevable/{identifiant}")
	public List<TaxeTNB> findByRedevableIdentifiant(@PathVariable("identifiant") String identifiant){
		return taxeTNBService.findByRedevableIdentifiant(identifiant);
	}
	@GetMapping("/findbyannee/{annee}")
	public List<TaxeTNB> findByAnnee(@PathVariable("annee") Integer annee){
		return taxeTNBService.findByAnnee(annee);
	}
	@PostMapping(path = "/save")
	public int save(TaxeTNB taxeTNB) {
		return taxeTNBService.save(taxeTNB);
	}
	@PutMapping(path = "/update")
	public int update(TaxeTNB taxeTNB) {
		return taxeTNBService.update(taxeTNB);
	}
	@DeleteMapping(path = "/delete")
	public int delete(@RequestBody TaxeTNB taxeTNB) {
		return taxeTNBService.delete(taxeTNB);
	}
	@DeleteMapping(path = "/delete/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return taxeTNBService.deleteById(id);
	}
	@GetMapping("/findbyid/{id}")
	public TaxeTNB findById(@PathVariable("id") Long id) {
		return taxeTNBService.findById(id);
	}
	
}
