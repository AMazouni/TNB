package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Categorie;

public interface CategorieDao extends JpaRepository<Categorie, Long> {

}
