package com.example.demo.service.facade;

import java.util.Date;
import java.util.List;

import com.example.demo.bean.Achat;

public interface AchatService {
	public List<Achat> findAll();
	public void save(Achat achat);
//	public void update(Long id,Achat achat);
	public int deleteById(Long id);
	List<Achat> findByTerrainId(Long id);
	List<Achat> findByOldredevableId(Long id);
	List<Achat> findByDateachat(Date dateachat);
	int acheterTerrain(Achat achat);
	Achat findByid(Long id);
	List<Achat> findByNewRedevableId(Long id);
}
