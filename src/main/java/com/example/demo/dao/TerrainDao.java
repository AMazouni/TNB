package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Terrain;

public interface TerrainDao extends JpaRepository<Terrain, Long> {

}
