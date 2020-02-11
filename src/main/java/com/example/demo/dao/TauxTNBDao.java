package com.example.demo.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Categorie;
import com.example.demo.beans.TauxTNB;

public interface TauxTNBDao extends JpaRepository<TauxTNB, Long> {

	public List<TauxTNB> findByCategorie(Categorie categorie);

	public List<TauxTNB> findBySurfaceMaxGreaterThanEqualAndSurfaceMinLessThanEqual(double surf1,double surf2);
	
	public List<TauxTNB> findByDateAppBeforeAndDateFinAppAfter(Date date1,Date date2);

	public List<TauxTNB> findByCategorieId(Long id);
	
	
}