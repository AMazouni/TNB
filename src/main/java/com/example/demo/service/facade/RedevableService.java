package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.beans.Redevable;
import com.example.demo.beans.TypeRedevable;

public interface RedevableService {

	public Redevable findById(Long id);

	public int save(Redevable redevable);

	public int update(Redevable redevable);

	public Redevable findByIdentifiant(String identifiant);

	public List<Redevable> findAll();

	public List<Redevable> findByTypeRedevable(TypeRedevable type);

	public List<Redevable> findByTypeRedevableId(Long id);

	public int deleteByIdentifiant(String identifiant);
}
