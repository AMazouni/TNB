package com.example.demo.ws.rest;

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

import com.example.demo.bean.Secteur;
import com.example.demo.service.facade.SecteurService;

@Repository
@RequestMapping("/TNB-Api/Secteur")
public class SecteurRest {
	@Autowired
	SecteurService secteurService;
	@GetMapping("/findAll")
	public List<Secteur> findAll() {
		return secteurService.findAll();
	}
	@GetMapping("/findById/{id}")
	public Secteur findByid(@PathVariable("id") Long id) {
		return secteurService.findByid(id);
	}
	@DeleteMapping("/deleteById/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return secteurService.deleteById(id);
	}
	@PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Secteur secteur) {
		secteurService.save(secteur);
	}

	@PutMapping(path = "/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable("id") Long id,@RequestBody Secteur secteur) {
		secteurService.update(id, secteur);
	}
	
}
