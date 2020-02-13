package com.example.demo.dao;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Categorie;
import com.example.demo.bean.TauxTNB;

public interface TauxTNBDao extends JpaRepository<TauxTNB, Long> {

	public List<TauxTNB> findByCategorie(Categorie categorie);

	public List<TauxTNB> findBySurfaceMaxGreaterThanEqualAndSurfaceMinLessThanEqual(BigDecimal surf1,BigDecimal surf2);
	
	public List<TauxTNB> findByDateAppBeforeAndDateFinAppAfter(Date date1,Date date2);

	public List<TauxTNB> findByCategorieId(Long id);
	
	
}