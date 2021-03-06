package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.TypeRedevable;

@Repository
public interface TypeRedevableDao extends JpaRepository<TypeRedevable, Long> {
TypeRedevable findByLibelle(String libelle);
}
