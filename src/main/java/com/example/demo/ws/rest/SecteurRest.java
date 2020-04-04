package com.example.demo.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.Secteur;
import com.example.demo.service.facade.SecteurService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/TNB-Api/Secteur")
public class SecteurRest {
	@Autowired
	SecteurService secteurService;
	@GetMapping(path = "/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Secteur> findAll() {
		return secteurService.findAll();
	}
	@GetMapping(path = "/findLast",produces = MediaType.APPLICATION_JSON_VALUE)
	public Secteur findLast() {
		return secteurService.findTopByOrderByIdDesc();
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
