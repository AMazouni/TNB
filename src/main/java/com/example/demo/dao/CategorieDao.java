package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Categorie;

public interface CategorieDao extends JpaRepository<Categorie, Long> {

}
