package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Secteur;
import com.example.demo.dao.SecteurDao;
import com.example.demo.service.facade.SecteurService;
@Service
public class SecteurServiceImpl implements SecteurService {
	@Autowired
	SecteurDao secteurDao;
	@Override
	public List<Secteur> findAll() {
		return secteurDao.findAll();
	}

	@Override
	public Secteur findByid(Long id) {
		if (secteurDao.findById(id).isPresent()) {
			return secteurDao.findById(id).get();
		} else return null;
	}

	@Override
	public int deleteById(Long id) {
		secteurDao.deleteById(id);
		if (findByid(id) == null) {
			return 1;
		} else return -1;
	}

	@Override
	public void save(Secteur secteur) {
		secteurDao.save(secteur);
	}

	@Override
	public void update(Long id, Secteur secteur) {
		secteurDao.save(secteur);
	}

}
