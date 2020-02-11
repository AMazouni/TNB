package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.bean.TypeRedevable;

public interface TypeRedevableService {

	public TypeRedevable findById(Long Id);

	public List<TypeRedevable> findAll();

	public int save(TypeRedevable typeredevable);

	public int deleteById(Long id);

	public int update(TypeRedevable typeredevable);
}
