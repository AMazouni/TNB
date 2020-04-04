package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Secteur;

@Repository
public interface SecteurDao extends JpaRepository<Secteur, Long> {
    public Secteur findTopByOrderByIdDesc();
}
