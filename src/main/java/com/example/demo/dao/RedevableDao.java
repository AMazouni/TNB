package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.TypeRedevable;

@Repository
public interface RedevableDao extends JpaRepository<Redevable, Long> {
   public Redevable findByIdentifiant(String id); 
	public List<Redevable> findByTypeRedevable (TypeRedevable type);
	public List<Redevable> findByTypeRedevableId (Long id);
}
