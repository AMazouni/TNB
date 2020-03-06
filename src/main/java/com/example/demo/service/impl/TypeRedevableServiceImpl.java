package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.TypeRedevable;
import com.example.demo.dao.TypeRedevableDao;
import com.example.demo.service.facade.TypeRedevableService;
@Service
public class TypeRedevableServiceImpl implements TypeRedevableService {
	@Autowired
	TypeRedevableDao typeRedevableDao;

	@Override
	public TypeRedevable findById(Long Id) {
		if (typeRedevableDao.findById(Id).isPresent())
			return typeRedevableDao.findById(Id).get();
		else
			return null;
	}

	@Override
	public List<TypeRedevable> findAll() {
		return typeRedevableDao.findAll();
	}

	@Override
	public int save(TypeRedevable typeRedevable) {
		if (this.findById(typeRedevable.getId()) != null)
			return 0;

		typeRedevableDao.save(typeRedevable);
		return 1;

	}

	@Override
	public int deleteById(Long Id) {
		if (this.findById(Id) != null)
			return 0;
		typeRedevableDao.deleteById(Id);	
		return 0;
	}

	@Override
	public int update(TypeRedevable typeRedevable) {
		if (this.findById(typeRedevable.getId()) == null)
			return 0;

		typeRedevableDao.save(typeRedevable);
		return 1;
	}

}
