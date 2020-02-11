package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Quartier;

public interface QuartierDao extends JpaRepository<Quartier, Long> {
	public List<Quartier> findBySecteurId(Long secteurId);
}
