package com.example.demo.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.TypeRedevable;
import com.example.demo.service.facade.TypeRedevableService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/TNB-Api/typeredevable")
public class TypeRedevableRest {

	@Autowired
	TypeRedevableService typeRedevableService;
	
	@GetMapping("/findByLibelle/{libelle}")
	public TypeRedevable findByLibelle(@PathVariable String libelle) {
		return typeRedevableService.findByLibelle(libelle);
	}
	@GetMapping("/findbyid/{id}")
	public TypeRedevable findById(@PathVariable("id") Long Id) {
		return typeRedevableService.findById(Id);
	}
	@GetMapping("/findall")
	public List<TypeRedevable> findAll(){
		return typeRedevableService.findAll();
	}
	@PostMapping("/save")
	public int save(@RequestBody TypeRedevable typeredevable) {
		return typeRedevableService.save(typeredevable);
	}

	@DeleteMapping(path = "/deletebyidentifiant/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return typeRedevableService.deleteById(id);
	}
	@PutMapping(path = "/update")
	public int update(@RequestBody TypeRedevable typeredevable) {
	 return typeRedevableService.update(typeredevable);	
	}
	
	
}
