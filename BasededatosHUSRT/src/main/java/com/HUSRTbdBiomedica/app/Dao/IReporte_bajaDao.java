package com.HUSRTbdBiomedica.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HUSRTbdBiomedica.app.entity.Reporte_baja;

@Repository
public interface IReporte_bajaDao extends CrudRepository<Reporte_baja,Long> {
	
	@Query("SELECT COUNT(rb) from Reporte_baja rb")
    public int countAll();
    
    @Query("SELECT COUNT(rb) FROM Reporte_baja rb "+
    		"INNER JOIN Baja b ON rb.baja.id_Baja=b.id_Baja "+
    		"WHERE b.id_Baja=?1")
    public int countReportesbyBaja(Long id);
    
    @Query("SELECT rb FROM Reporte_baja rb " + 
    		"INNER JOIN Baja b ON rb.baja.id_Baja=b.id_Baja " + 
    		"WHERE b.id_Baja=?1")    
    public List<Reporte_baja> findReportesbyBaja(Long id);
    
    @Query("SELECT MAX(rb.id_Reporte_baja) FROM Reporte_baja rb")
    public Long findLastIdReporte();
    

}
