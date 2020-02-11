package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.TypeRedevable;
import com.example.demo.dao.RedevableDao;
import com.example.demo.service.facade.RedevableService;
@Service
public class RedevableServiceImpl implements RedevableService {

	@Autowired
	RedevableDao redevableDao;

	public Redevable findById(Long id) {
		if (!redevableDao.findById(id).isPresent())
			return null;
		else
			return redevableDao.findById(id).get();
	}

	@Override
	public int save(Redevable redevable) {
		if (this.findByIdentifiant(redevable.getIdentifiant()) != null)
			return 0;
		redevableDao.save(redevable);
		return 1;
	}

	@Override
	public int update(Redevable redevable) {
		if (this.findByIdentifiant(redevable.getIdentifiant()) == null)
			return 0;
		redevableDao.save(redevable);
		return 1;
	}

	@Override
	public int deleteByIdentifiant(String identifiant) {
		if (this.findByIdentifiant(identifiant) == null)
			return 0;
		else {
			redevableDao.delete(findByIdentifiant(identifiant));
			return 1;
		}
	}

	@Override
	public Redevable findByIdentifiant(String identifiant) {

		return redevableDao.findByIdentifiant(identifiant);
	}

	@Override
	public List<Redevable> findByTypeRedevable(TypeRedevable type) {

		return redevableDao.findByTypeRedevable(type);
	}

	@Override
	public List<Redevable> findByTypeRedevableId(Long id) {

		return redevableDao.findByTypeRedevableId(id);
	}

	@Override
	public List<Redevable> findAll() {

		return redevableDao.findAll();
	}

}
