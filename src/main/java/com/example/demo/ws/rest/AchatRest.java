package com.example.demo.ws.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Achat;
import com.example.demo.service.facade.AchatService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/TNB-Api/Achat/")
public class AchatRest {
	@Autowired
	AchatService achatService;

	@GetMapping("findAll")
	public List<Achat> findAll() {
		return achatService.findAll();
	}

	@PostMapping("save")
	public void save(@RequestBody Achat achat) {
		achatService.save(achat);
	}

	@DeleteMapping("deleteById/{id}/id")
	public int deleteById(@PathVariable Long id) {
		return achatService.deleteById(id);
	}

	@GetMapping("findByTerrainId/{id}/id")
	public List<Achat> findByTerrainId(@PathVariable Long id) {
		return achatService.findByTerrainId(id);
	}

	@GetMapping("findByOldredevableId")
	public List<Achat> findByOldredevableId(@PathVariable Long id) {
		return achatService.findByOldredevableId(id);
	}

	@GetMapping("findByNewredevableId/{id}/id")
	public List<Achat> findByNewRedevableId(@PathVariable Long id) {
		return achatService.findByNewRedevableId(id);
	}

	@GetMapping("findByDateachat/dateachat/{dateachat}")
	public List<Achat> findByDateachat(@PathVariable @DateTimeFormat(pattern =  "yyyy-MM-dd")  Date dateachat) {
		return achatService.findByDateachat(dateachat);
	}

	@PutMapping("acheterTerrain")
	public int acheterTerrain(@RequestBody Achat achat) {
		return achatService.acheterTerrain(achat);
	}

	@GetMapping("findByid")
	public Achat findByid(@PathVariable Long id) {
		return achatService.findByid(id);
	}

}
