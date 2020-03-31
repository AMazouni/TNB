package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Achat;

@Repository
public interface AchatDao extends JpaRepository<Achat, Long> {

	List<Achat> findByTerrainId(Long id);
	List<Achat> findByOldredevableId(Long id);
	List<Achat> findByNewRedevableId(Long id);
 //   @Query("select a from Achat a where a.dateachat =:dateachat")
	//List<Achat> findByDateachat(@Param(value = "dateachat") Date dateachat);
}
