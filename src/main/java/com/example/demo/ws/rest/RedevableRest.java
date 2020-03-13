package com.example.demo.ws.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.Terrain;
import com.example.demo.bean.TypeRedevable;
import com.example.demo.service.facade.RedevableService;

@RestController
@RequestMapping("/TNB-Api/Redevable")
public class RedevableRest {

	@Autowired
	RedevableService redevableService;
	
	@GetMapping("findRedevableNonPayerAyantnombreRetard/{nombreMoisDeRetard}")
	public List<Redevable> findRedevableNonPayerAyantnombreRetard(@PathVariable Integer nombreMoisDeRetard) {
		return redevableService.findRedevableNonPayerAyantnombreRetard(nombreMoisDeRetard);
	}
	@GetMapping("findByTypeRedevableAndNonPayer/{typeRedevable}")
	public List<Redevable> findByTypeRedevableAndNonPayer(@PathVariable TypeRedevable typeRedevable) {
		return redevableService.findByTypeRedevableAndNonPayer(typeRedevable);
	}
	@GetMapping("findRedevablePayerdans/{date}")
	public List<Redevable> findRedevablePayerdans(@DateTimeFormat(pattern =  "dd/MM/yyyy") Date date) {
		return redevableService.findRedevablePayerdans(date);
	}
	@GetMapping("findRedevableAyantNotification/{numeroNotification}")
	public List<Redevable> findRedevableAyantNotification(@PathVariable int numeroNotification) {
		return redevableService.findRedevableAyantNotification(numeroNotification);
	}
	@GetMapping("/findByTypeRedevableLibelle/{libelle}")
	public List<Redevable> findByTypeRedevableLibelle(@PathVariable String libelle) {
		return redevableService.findByTypeRedevableLibelle(libelle);
	}
	@GetMapping("/findRedevablePayer")
	public List<Redevable> findRedevablePayer() {
		return redevableService.findRedevablePayer();
	}
	@GetMapping("/findByNom/{nom}")
	public Redevable findByNom(@PathVariable String nom) {
		return redevableService.findByNom(nom);
	}
	@GetMapping("/findRedevableNonPayer")
	public List<Redevable> findRedevableNonPayer() {
		return redevableService.findRedevableNonPayer();
	}
	@GetMapping("/testpaymentRedevable")
	public Boolean testpaymentRedevable(@RequestBody Redevable redevable) {
		return redevableService.testpaymentRedevable(redevable);
	}
	@GetMapping("/findByTerrain")
	public Redevable findByTerrain(@RequestBody Terrain terrain) {
		return redevableService.findByTerrain(terrain);
	}

	@GetMapping("/findByid/{id}")
	public Redevable findById(@PathVariable("id") Long id) {
		return redevableService.findById(id);
	}

	@PostMapping("/save")
	public int save(@RequestBody Redevable redevable) {
		return redevableService.save(redevable);
	}

	@PutMapping("/update")
	public int update(@RequestBody Redevable redevable) {
		return redevableService.update(redevable);
	}

	@GetMapping("/findbyidentifiant/{id}")
	public Redevable findByIdentifiant(@PathVariable("id") String identifiant) {
		return redevableService.findByIdentifiant(identifiant);
	}

	@GetMapping("/findall")
	public List<Redevable> findAll() {
		return redevableService.findAll();
	}

	@PostMapping("/findbytyperedevable")
	public List<Redevable> findByTypeRedevable(@RequestBody TypeRedevable type) {
		return redevableService.findByTypeRedevable(type);
	}

	@GetMapping("/findbytyperedevable/{id}")
	public List<Redevable> findByTypeRedevableId(@PathVariable("id") Long id) {
		return redevableService.findByTypeRedevableId(id);
	}

	@DeleteMapping("/deletebyidentifiant/{id}")
	public int deleteByIdentifiant(@PathVariable("id") String identifiant) {
		return redevableService.deleteByIdentifiant(identifiant);
	}
}
