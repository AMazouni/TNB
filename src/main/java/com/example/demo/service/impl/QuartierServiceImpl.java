package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Quartier;
import com.example.demo.dao.QuartierDao;
import com.example.demo.service.facade.QuartierService;
@Service
public class QuartierServiceImpl implements QuartierService {
	@Autowired
	QuartierDao quartierDao;
	@Override
	public List<Quartier> findBySecteurId(Long secteurId) {
		return quartierDao.findBySecteurId(secteurId);
	}

	@Override
	public Quartier findById(Long id) {
		if (quartierDao.findById(id).isPresent()) {
			return quartierDao.findById(id).get();
		}
		else {
			return null;
		}
		
	}

	@Override
	public List<Quartier> findAll() {
		return quartierDao.findAll();
	}

	@Override
	public int deleteById(Long id) {
		quartierDao.deleteById(id);
		if (findById(id) == null) {
			return 1;
		} else return -1;
	}

	
	@Override
	public void save(Quartier quartier) {
		quartierDao.save(quartier);
	}

	@Override
	public void update(Long id,Quartier quartier) {
	    quartierDao.save(quartier);
	}

}
