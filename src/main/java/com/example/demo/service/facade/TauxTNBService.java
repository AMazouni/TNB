package com.example.demo.service.facade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.demo.bean.Categorie;
import com.example.demo.bean.TauxTNB;

public interface TauxTNBService {
	public TauxTNB findById(Long id);

	public List<TauxTNB> findAll();

	public int save(TauxTNB tauxTNB);

	public int deleteById(Long id);

	public int update(TauxTNB tauxTNB);
	
	public List<TauxTNB> findByCategorie(Categorie categorie);
	
	public List<TauxTNB> findByCategorieId(Long id);
	
	public List<TauxTNB> findBySurface(BigDecimal surface);
	
	public List<TauxTNB> findByDate(Date date);
	
	public List<TauxTNB> findByDateAndSurface(BigDecimal surface,Date date);
	
	public List<TauxTNB> findByDateAndSurfaceAndCategorie(BigDecimal surface,Date date,Categorie categorie);
}