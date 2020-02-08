package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.beans.Categorie;

public interface CategorieService {
	public Categorie findById(Long id);
	public List<Categorie> findAll();
	public void save(Categorie categorie);
	public void update(Long id,Categorie categorie);
	public int deleteById(Long id);
}
