package com.example.demo.ws.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.Categorie;
import com.example.demo.bean.TauxTNB;
import com.example.demo.service.facade.TauxTNBService;

@Repository
@RequestMapping("/TNB-Api/typeredevable")
public class TauxTNBRest {

	@Autowired
	TauxTNBService tauxTNBservice;
	
	public TauxTNB findById(Long id) {
		return tauxTNBservice.findById(id);
	}

	public List<TauxTNB> findAll(){
		return tauxTNBservice.findAll();
	}

	public int save(TauxTNB tauxTNB) {
		return tauxTNBservice.save(tauxTNB);
	}

	public int deleteById(Long id) {
		return tauxTNBservice.deleteById(id);
	}

	public int update(TauxTNB tauxTNB) {
		return tauxTNBservice.update(tauxTNB);
	}
	
	public List<TauxTNB> findByCategorie(Categorie categorie){
		return tauxTNBservice.findByCategorie(categorie);
	}
	
	public List<TauxTNB> findByCategorieId(Long id){
		return tauxTNBservice.findByCategorieId(id);
	}
	
	public List<TauxTNB> findBySurface(Double surface){
		return tauxTNBservice.findBySurface(surface);
	}
	
	public List<TauxTNB> findByDate(Date date){
		return tauxTNBservice.findByDate(date);
	}
	
	public List<TauxTNB> findByDateAndSurface(Double surface,Date date){
		return tauxTNBservice.findByDateAndSurface(surface, date);
	}
	
	public List<TauxTNB> findByDateAndSurfaceAndCategorie(Double surface,Date date,Categorie categorie){
		return tauxTNBservice.findByDateAndSurfaceAndCategorie(surface, date, categorie);
	}
	
	
	
}
