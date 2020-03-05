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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.TypeRedevable;
import com.example.demo.service.facade.TypeRedevableService;

@RestController
@RequestMapping("/TNB-Api/typeredevable")
public class TypeRedevableRest {

	@Autowired
	TypeRedevableService typeRedevableService;
	
	@GetMapping("/findbyid/{id}")
	public TypeRedevable findById(@PathVariable("id") Long Id) {
		return typeRedevableService.findById(Id);
	}
	@GetMapping("/findall")
	public List<TypeRedevable> findAll(){
		return typeRedevableService.findAll();
	}
	@PostMapping(path = "/findbytyperedevable")
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
