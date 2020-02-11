package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Categorie;
import com.example.demo.beans.TauxTNB;
import com.example.demo.dao.TauxTNBDao;
import com.example.demo.service.facade.TauxTNBService;

@Service
public class TauxTNBServiceImpl implements TauxTNBService {

	@Autowired
	TauxTNBDao tauxTNBDao;

	@Override
	public TauxTNB findById(Long id) {

		if (tauxTNBDao.findById(id).isPresent())
			return tauxTNBDao.findById(id).get();
		else
			return null;
	}

	@Override
	public List<TauxTNB> findAll() {

		return tauxTNBDao.findAll();
	}

	@Override
	public int save(TauxTNB tauxTNB) {
		if (this.findById(tauxTNB.getId()) != null)
			return 0;
		tauxTNBDao.save(tauxTNB);
		return 1;

	}

	@Override
	public int deleteById(Long id) {
		if (this.findById(id) == null)
			return 0;
		tauxTNBDao.deleteById(id);
		return 1;
	}

	@Override
	public int update(TauxTNB tauxTNB) {
		if (this.findById(tauxTNB.getId()) == null)
			return 0;
		tauxTNBDao.save(tauxTNB);
		return 1;
	}

	@Override
	public List<TauxTNB> findByCategorie(Categorie categorie) {
		return tauxTNBDao.findByCategorie(categorie);
	}

	@Override
	public List<TauxTNB> findByCategorieId(Long id) {

		return tauxTNBDao.findByCategorieId(id);
	}

	@Override
	public List<TauxTNB> findBySurface(Double surface) {
		return tauxTNBDao.findBySurfaceMaxGreaterThanEqualAndSurfaceMinLessThanEqual(surface, surface);
	}

	@Override
	public List<TauxTNB> findByDate(Date date) {
		return tauxTNBDao.findByDateAppBeforeAndDateFinAppAfter(date, date);
	}

	@Override
	public List<TauxTNB> findByDateAndSurface(Double surface, Date date) {
		List<TauxTNB> listByDate = this.findByDate(date);
		List<TauxTNB> listBySurfaceAndDate = this.findBySurface(surface);
		listBySurfaceAndDate.retainAll(listByDate);
		return listBySurfaceAndDate;
	}

	@Override
	public List<TauxTNB> findByDateAndSurfaceAndCategorie(Double surface, Date date, Categorie categorie) {
		List<TauxTNB> listBycategorie = this.findByCategorie(categorie);
		List<TauxTNB> listBySurfaceAndDateAndCategorie = this.findByDateAndSurface(surface, date);
		listBySurfaceAndDateAndCategorie.retainAll(listBycategorie);
		return listBySurfaceAndDateAndCategorie;

	}

}
