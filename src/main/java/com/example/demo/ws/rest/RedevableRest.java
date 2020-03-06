package com.example.demo.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.TypeRedevable;
import com.example.demo.service.facade.RedevableService;

@RestController
@RequestMapping("/TNB-Api/Redevable")
public class RedevableRest {

	@Autowired
	RedevableService redevableService;

	@GetMapping("/findByid/{id}")
	public Redevable findById(@PathVariable("id") Long id) {
		return redevableService.findById(id);
	}

	@PostMapping(path = "/save")
	public int save(@RequestBody Redevable redevable) {
		return redevableService.save(redevable);
	}

	@PutMapping(path = "/update")
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

	@PostMapping(path = "/findbytyperedevable")
	public List<Redevable> findByTypeRedevable(@RequestBody TypeRedevable type) {
		return redevableService.findByTypeRedevable(type);
	}

	@GetMapping(path = "/findbytyperedevable/{id}")
	public List<Redevable> findByTypeRedevableId(@PathVariable("id") Long id) {
		return redevableService.findByTypeRedevableId(id);
	}

	@DeleteMapping(path = "/deletebyidentifiant/{id}")
	public int deleteByIdentifiant(@PathVariable("id") String identifiant) {
		return redevableService.deleteByIdentifiant(identifiant);
	}
}
