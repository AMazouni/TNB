package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.TauxTNB;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.TaxeTNBDao;
import com.example.demo.service.facade.RedevableService;
import com.example.demo.service.facade.TauxTNBService;
import com.example.demo.service.facade.TaxeTNBService;
import com.example.demo.service.facade.TerrainService;
import com.example.demo.utils.DateUtils;

@Service
public class TaxeTNBServiceImpl implements TaxeTNBService {

	@Autowired
	TaxeTNBDao taxeTNBDao;

	@Autowired
	TauxTNBService tauxTNBService;
	@Autowired
	RedevableService redevableService;
	@Autowired
	TerrainService terrainService;

	@Override
	public List<TaxeTNB> findByTerrain(Terrain terrain) {
		return taxeTNBDao.findByTerrain(terrain);
	}

	@Override
	public List<TaxeTNB> findByTerrainId(Long id) {
		return taxeTNBDao.findByTerrainId(id);
	}

	@Override
	public List<TaxeTNB> findByRedevable(Redevable redevable) {
		return taxeTNBDao.findByRedevable(redevable);
	}

	@Override
	public List<TaxeTNB> findByRedevableIdentifiant(String identifiant) {
		return taxeTNBDao.findByRedevableIdentifiant(identifiant);
	}

	@Override
	public List<TaxeTNB> findByAnnee(Integer annee) {
		return taxeTNBDao.findByAnnee(annee);
	}

	@Override
	public int save(TaxeTNB taxeTNB) {
		if (this.findById(taxeTNB.getId()) != null)
			return 0;
		else if (taxeTNB.getAnnee() == null || taxeTNB.getDateTaxeTNB() == null || taxeTNB.getMontant() == null
				|| taxeTNB.getMontantRetard() == null || taxeTNB.getMontantTotal() == null
				|| taxeTNB.getNombreMoisRetard() == null || taxeTNB.getRedevable() == null
				|| taxeTNB.getTauxTNB() == null || taxeTNB.getTerrain() == null)
			return -1;
		else if (redevableService.findByIdentifiant(taxeTNB.getRedevable().getIdentifiant()) == null
				|| terrainService.findByid(taxeTNB.getTerrain().getId()) == null
				|| tauxTNBService.findById(taxeTNB.getTauxTNB().getId()) == null)
			return -2;
		taxeTNBDao.save(taxeTNB);
		return 1;
	}

	@Override
	public int update(TaxeTNB taxeTNB) {
		if (this.findById(taxeTNB.getId()) == null)
			return 0;
		taxeTNBDao.save(taxeTNB);
		return 1;
	}

	@Override
	public int delete(TaxeTNB taxeTNB) {
		if (this.findById(taxeTNB.getId()) == null)
			return 0;
		taxeTNBDao.delete(taxeTNB);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		if (this.findById(id) == null)
			return 0;
		taxeTNBDao.deleteById(id);
		return 1;
	}

	@Override
	public TaxeTNB findById(Long id) {
		if (taxeTNBDao.findById(id).isPresent())
			return taxeTNBDao.findById(id).get();
		else
			return null;
	}

	@Override
	public TaxeTNB payerSim(TaxeTNB taxeTNB) {
		Integer annee = taxeTNB.getAnnee();
		Long idTerrain = taxeTNB.getTerrain().getId();
		TaxeTNB payeSim = new TaxeTNB();
		payeSim.setTerrain(terrainService.findByid(idTerrain));
		Date date = DateUtils.getDateByYear(annee);
		TauxTNB taux = tauxTNBService.findByDateAndSurfaceAndCategorie(payeSim.getTerrain().getSurface(), date,
				payeSim.getTerrain().getCategorie()).get(0);
		payeSim.setTauxTNB(taux);
		payeSim.setDateTaxeTNB(new Date());
		payeSim.setAnnee(annee);
		payeSim.setTerrain(terrainService.findByid(idTerrain));
		payeSim.setRedevable(terrainService.findByid(idTerrain).getRedevable());
		payeSim.setNombreMoisRetard(DateUtils.getMonthsDiff(date));
		Double montant = payeSim.getTauxTNB().getMontant() * payeSim.getTerrain().getSurface().doubleValue();
		payeSim.setMontant(montant);
		Double montantRetard = payeSim.getTauxTNB().getMontantRetard() * payeSim.getTerrain().getSurface().doubleValue()
				* payeSim.getNombreMoisRetard().doubleValue();
		payeSim.setMontantRetard(montantRetard);
		payeSim.setMontantTotal(montantRetard + montant);
		return payeSim;
	}


	@Override
	public int deleteByTerrainId(Long id) {
		return taxeTNBDao.deleteByTerrainId(id);
	}

	@Override
	public int payer(TaxeTNB taxeTNB) {
		
		return save(payerSim(taxeTNB));
	}



}
