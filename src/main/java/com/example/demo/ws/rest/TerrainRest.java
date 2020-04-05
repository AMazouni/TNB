package com.example.demo.ws.rest;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.bean.Redevable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Terrain;
import com.example.demo.service.facade.TerrainService;

@RestController
@CrossOrigin("http://localhost:4200")
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
    @GetMapping("/findByRedevableIdentifiant/{identifiant}")
	public List<Terrain> findbyRedevableLibelle(@PathVariable("identifiant") String identifiant) {
		return terrainService.findByRedevableIdentifiant(identifiant);
	}
    @GetMapping("/findByQuartierLibelle/{libelle}")
	public List<Terrain> findByQuartierLibelle(@PathVariable("libelle") String libelle) {
		return terrainService.findByQuartierLibelle(libelle);
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
    @GetMapping(path = "/findByDernierAnnePaiementAndNotificationType/dernierAnnePaiement/{dernierAnnePaiement}/numero/{numero}")
    public List<Terrain> findByDernierAnnePaiementAndNotificationNotificationTypeNumero(@PathVariable("dernierAnnePaiement") int dernierAnnePaiement,@PathVariable("numero") int numero) {
    	return terrainService.findByDernierAnnePaiementAndNotificationNotificationTypeNumero(dernierAnnePaiement, numero);
    }
    @GetMapping(path = "/findByDernierAnnePaiementAndRedevableIdentifiant/dernierAnnePaiement/{dernierAnnePaiement}/identifiant/{identifiant}")
	public List<Terrain> findByDernierAnnePaiementAndRedevableIdentifiant(@PathVariable("dernierAnnePaiement") int dernierAnnePaiement,@PathVariable("identifiant") String identifiant) {
		return terrainService.findByDernierAnnePaiementAndRedevableIdentifiant(dernierAnnePaiement, identifiant);
	}
    @GetMapping(path = "/findByCategorie/{libelle}")
	public List<Terrain> findByCategorieLibelle(@PathVariable("libelle") String libelle) {
		return terrainService.findByCategorieLibelle(libelle);
	}
    @GetMapping(path = "/findByDernierAnnePaiementAndQuartier/dernierAnnePaiement/{dernierAnnePaiement}/Quartier/{libelle}")
	public List<Terrain> findByDernierAnnePaiementAndQuartierLibelle(@PathVariable("dernierAnnePaiement") int dernierAnnePaiement,@PathVariable("libelle") String Libelle) {
		return terrainService.findByDernierAnnePaiementAndQuartierLibelle(dernierAnnePaiement, Libelle);
	}
    @GetMapping(path = "/findByDernierAnnePaiementAndSecteur/dernierAnnePaiement/{dernierAnnePaiement}/Secteur/{libelle}")
	public List<Terrain> findByDernierAnnePaiementAndQuartierSecteurLibelle(@PathVariable("dernierAnnePaiement") int dernierAnnePaiement,@PathVariable("libelle") String Libelle) {
		return terrainService.findByDernierAnnePaiementAndQuartierSecteurLibelle(dernierAnnePaiement, Libelle);
	}
	@GetMapping(path="/findRedevableTerrainNP/{redevableId}")
	public List<Terrain> findTerrainsRedevableNonPaye(@PathVariable Long redevableId) {
		return terrainService.findTerrainsRedevableNonPaye(redevableId);
	}

    
	
}
