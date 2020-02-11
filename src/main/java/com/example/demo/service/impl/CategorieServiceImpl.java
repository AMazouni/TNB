package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Categorie;
import com.example.demo.dao.CategorieDao;
import com.example.demo.service.facade.CategorieService;
@Service
public class CategorieServiceImpl implements CategorieService {
	@Autowired
	CategorieDao categorieDao;
	@Override
	public Categorie findById(Long id) {
		if (categorieDao.findById(id).isPresent()) {
		return categorieDao.findById(id).get();
		} else return null;
	}

	@Override
	public List<Categorie> findAll() {
		return categorieDao.findAll();
	}

	@Override
	public void save(Categorie categorie) {
		categorieDao.save(categorie);
	}

	@Override
	public void update(Long id, Categorie categorie) {
		categorieDao.save(categorie);
	}

	@Override
	public int deleteById(Long id) {
		categorieDao.deleteById(id);
		if (findById(id) == null) {
			return 1;
		} else return -1;
	}

}
