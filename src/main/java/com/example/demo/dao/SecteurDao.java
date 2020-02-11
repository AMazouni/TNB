package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Secteur;

public interface SecteurDao extends JpaRepository<Secteur, Long> {

}
