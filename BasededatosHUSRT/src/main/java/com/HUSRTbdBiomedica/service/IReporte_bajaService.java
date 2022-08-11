package com.HUSRTbdBiomedica.service;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import com.HUSRTbdBiomedica.app.entity.Reporte_baja;


public interface IReporte_bajaService {

	public List<Reporte_baja>ListReportes();
	public Optional<Reporte_baja>ListReportesbyId(Long id);
	public Reporte_baja findOne(Long id);
	public void save(Reporte_baja reporte_baja);
	public void delete(Long id);
	public List<Reporte_baja>ReportesbyBaja(Long id);
	public int countReportesbyBaja(Long id);
	public Long LastIdReporteBaja();
}
