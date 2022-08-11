package com.HUSRTbdBiomedica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HUSRTbdBiomedica.app.Dao.IReporte_bajaDao;
import com.HUSRTbdBiomedica.app.entity.Reporte_baja;
@Service
public class Reporte_bajaServiceImp implements IReporte_bajaService{

	@Autowired
	private IReporte_bajaDao Reporte_bajaDao;
	
	@Override
	public List<Reporte_baja> ListReportes() {
		return (List<Reporte_baja>)Reporte_bajaDao.findAll();
	}

	@Override
	public Optional<Reporte_baja> ListReportesbyId(Long id) {
		return null;
	}

	@Override
	public Reporte_baja findOne(Long id) {
		return Reporte_bajaDao.findById(id).orElse(null);
	}

	@Override
	public void save(Reporte_baja reporte_baja) {
		Reporte_bajaDao.save(reporte_baja);
		
	}

	@Override
	public void delete(Long id) {
		Reporte_bajaDao.delete(findOne(id));
		
	}

	@Override
	public List<Reporte_baja> ReportesbyBaja(Long id) {
		return Reporte_bajaDao.findReportesbyBaja(id);
	}

	@Override
	public int countReportesbyBaja(Long id) {
		return Reporte_bajaDao.countReportesbyBaja(id);
	}

	@Override
	public Long LastIdReporteBaja() {
		return Reporte_bajaDao.findLastIdReporte();
	}

	
	
}
