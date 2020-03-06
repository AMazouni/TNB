package com.example.demo.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Categorie;
import com.example.demo.service.facade.CategorieService;

@RestController
@RequestMapping("/TNB-Api/Categorie")
public class CategorieRest {
	@Autowired
	CategorieService categorieService;
	@GetMapping("/findById/{id}")
	public Categorie findById(@PathVariable("id") Long id) {
		return categorieService.findById(id);
	}
	@GetMapping("/findAll")
	public List<Categorie> findAll() {
		return categorieService.findAll();
	}
	@PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Categorie categorie) {
		categorieService.save(categorie);
	}
	@PutMapping(path = "/update/{id}")
	public void update(@PathVariable("id") Long id,@RequestBody Categorie categorie) {
		categorieService.update(id, categorie);
	}
	@DeleteMapping("/deleteById/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return categorieService.deleteById(id);
	}
	
}
