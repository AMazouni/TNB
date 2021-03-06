package com.example.demo.ws.rest;

import java.util.List;

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

import com.example.demo.bean.Quartier;
import com.example.demo.service.facade.QuartierService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/TNB-Api/Quartier")
public class QuartierRest {
	@Autowired
	QuartierService quartierService;
	@GetMapping("/findBySecteurId/{id}")
	public List<Quartier> findBySecteurId(@PathVariable("id") Long secteurId) {
		return quartierService.findBySecteurId(secteurId);
	}
	@GetMapping("/findById/{id}")
	public Quartier findById(@PathVariable("id") Long id) {
		return quartierService.findById(id);
	}
	@GetMapping("/findAll")
	public List<Quartier> findAll() {
		return quartierService.findAll();
	}
	@DeleteMapping("/deleteById/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return quartierService.deleteById(id);
	}
	@PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Quartier quartier) {
		quartierService.save(quartier);
	}
	
	@PutMapping(path = "/update/{id}")
	public void update(@PathVariable("id") Long id,@RequestBody Quartier quartier) {
		quartierService.update(id, quartier);
	}
	
}
