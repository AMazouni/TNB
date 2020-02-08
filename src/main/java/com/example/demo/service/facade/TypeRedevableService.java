package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.beans.TypeRedevable;

public interface TypeRedevableService {

	public TypeRedevable findById(Long Id);

	public List<TypeRedevable> findAll();

	public int save(TypeRedevable typeredevable);

	public int deleteById(Long Id);

	public int update(TypeRedevable typeredevable);
}
