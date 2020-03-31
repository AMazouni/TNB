package com.example.demo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Achat;
import com.example.demo.bean.Redevable;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.AchatDao;
import com.example.demo.service.facade.AchatService;
import com.example.demo.service.facade.RedevableService;
import com.example.demo.service.facade.TerrainService;
import com.example.demo.utils.DateUtils;

@Service
public class AchatServiceImpl implements AchatService {
	@Autowired
	AchatDao achatDao;
	@Autowired
	RedevableService redevableService;
	@Autowired
	TerrainService terrainService;
	@Autowired
	AchatService achatService;

	@Override
	public Achat findByid(Long id) {
		if (achatDao.findById(id).isPresent()) {
			return achatDao.findById(id).get();
		} else
			return null;
	}

	@Override
	public List<Achat> findAll() {
		return achatDao.findAll();
	}

	@Override
	public void save(Achat achat) {
		achatDao.save(achat);
	}

	@Override
	public int deleteById(Long id) {
		achatDao.deleteById(id);
		if (findByid(id) == null) {
			return 1;
		} else
			return -1;
	}

	@Override
	public List<Achat> findByOldredevableId(Long id) {
		return achatDao.findByOldredevableId(id);
	}

	@SuppressWarnings("null")
	@Override
	public List<Achat> findByDateachat(Date dateachat) {
		List<Achat> achats = findAll();
		List<Achat> results = new ArrayList<Achat>();
		for (Achat achat : achats) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate1 = formatter.format(achat.getDateachat());
			Date date1;
			try {
				date1 = formatter.parse(strDate1);
				String strDate2 = formatter.format(dateachat);
				Date date2;
				date2 = formatter.parse(strDate2);
				if (DateUtils.compareDate(date1, date2) == true)
					results.add(achat);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return results;
	}

	@Override
	public int acheterTerrain(Achat achat) {
		Redevable oldRedevable = redevableService.findById(achat.getOldredevable().getId());
		Redevable newRedevable = redevableService.findById(achat.getNewRedevable().getId());
		Terrain terrain = terrainService.findByid(achat.getTerrain().getId());
		if (terrain == null) {
			return -1;
		} else if (terrain.getRedevable().getId() != oldRedevable.getId()) {
			return -2;
		} else if (newRedevable == null) {
			return -3;
		} else if (oldRedevable == null) {
			return -4;
		} else if (newRedevable.getId() == oldRedevable.getId()) {
			return -5;
		} else if (terrain.getDernierAnnePaiement() != DateUtils.getYear()) {
			return -6;
		} else {
			terrain.setRedevable(newRedevable);
			terrainService.save(terrain);
			achat.setNewRedevable(newRedevable);
			achat.setOldredevable(oldRedevable);
			achat.setTerrain(terrain);
			achat.setDateachat(new Date());
			achatService.save(achat);
			return 1;
		}
	}

	@Override
	public List<Achat> findByTerrainId(Long id) {
		return achatDao.findByTerrainId(id);
	}

	@Override
	public List<Achat> findByNewRedevableId(Long id) {
		return achatDao.findByNewRedevableId(id);
	}

}
