package com.example.demo.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Heritage;
import com.example.demo.bean.Redevable;
import com.example.demo.bean.Terrain;
import com.example.demo.service.facade.HeritageService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/TNB-Api/Heritage")
public class HeritageRest {
	@Autowired
	HeritageService heritageService;
	@GetMapping("/findById/Id/{id}")
	public Heritage findById(@PathVariable("id") Long id) {
		return heritageService.findById(id);
	}
	@GetMapping("/findAll")
	public List<Heritage> findAll() {
		return heritageService.findAll();
	}
	@PostMapping("/save")
	public int save(@RequestBody Heritage heritage) {
		return heritageService.save(heritage);
	}
	@PutMapping("/update/Id/{id}")
	public int update(@PathVariable("id") Long id,@RequestBody Heritage heritage) {
		return heritageService.update(id, heritage);
	}
	@DeleteMapping("/delete/Id/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return heritageService.deleteById(id);
	}
	@GetMapping("/findByRedevableOriginal")
	public List<Heritage> findByRedevableOriginal(@RequestBody Redevable redevableOriginal) {
		return heritageService.findByRedevableOriginal(redevableOriginal);
	}
	@GetMapping("/findByNouveauRedevable")
	public List<Heritage> findByNouveauRedevable(@RequestBody Redevable nouveauRedevable) {
		return heritageService.findByNouveauRedevable(nouveauRedevable);
	}
	@GetMapping("/findByTerrainOriginal")
	public List<Heritage> findByTerrainOriginal(@RequestBody Terrain terrainOriginal) {
		return heritageService.findByTerrainOriginal(terrainOriginal);
	}
    @GetMapping("/findByNouveauTerrain")
	public List<Heritage> findByNouveauTerrain(@RequestBody Terrain nouveauTerrain) {
		return heritageService.findByNouveauTerrain(nouveauTerrain);
	}
    @PostMapping("/saveMultipleHeritage/RedevableOriginalIdentifiant/{RedevableOriginalIdentifiant}"
    		+ "/nouveauxRedevableIdentifiant/{nouveauxRedevableIdentifiant}/pourcentages/{pourcentages}/terrainOriginalId/{terrainOriginalId}")
	public int saveMultipleHeritage(@PathVariable("RedevableOriginalIdentifiant") String RedevableOriginalIdentifiant,@RequestParam("nouveauxRedevableIdentifiant") List<String> nouveauxRedevableIdentifiant,
			@RequestParam("pourcentages") List<Float> pourcentages,@PathVariable("terrainOriginalId") Long terrainOriginalId) {
		return heritageService.saveMultipleHeritage(RedevableOriginalIdentifiant, nouveauxRedevableIdentifiant,
				pourcentages, terrainOriginalId);
	}
	
}
