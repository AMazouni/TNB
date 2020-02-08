package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Quartier;

public interface QuartierDao extends JpaRepository<Quartier, Long> {

}
