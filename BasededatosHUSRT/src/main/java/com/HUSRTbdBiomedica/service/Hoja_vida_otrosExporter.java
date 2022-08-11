package com.HUSRTbdBiomedica.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.HUSRTbdBiomedica.app.entity.Hoja_vida_otros;

public class Hoja_vida_otrosExporter {
	
	private XSSFWorkbook workbook;
	
	private XSSFSheet sheet;
	
	private List<Hoja_vida_otros> listhvotros;

	public Hoja_vida_otrosExporter(List<Hoja_vida_otros> listhvotros) {
		this.listhvotros = listhvotros;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Hojas_vida_otros");
	}
	private void writeHeaderRow() {
		Row row = sheet.createRow(0);
		
		Cell cell = row.createCell(0);		
		cell.setCellValue("ID");
		
		cell = row.createCell(1);
		cell.setCellValue("SERIE");
		
		cell = row.createCell(2);
		cell.setCellValue("NOMBRE");
		
		cell = row.createCell(3);
		cell.setCellValue("MARCA");
		
		cell = row.createCell(4);
		cell.setCellValue("MODELO");
		
		cell = row.createCell(5);
		cell.setCellValue("ANO FABRICACION");
		
		cell = row.createCell(6);
		cell.setCellValue("PLACA INVENTARIO");
		
		cell = row.createCell(7);
		cell.setCellValue("DEPARTAMENTO");
		
		cell = row.createCell(8);
		cell.setCellValue("MUNICIPIO");
		
		cell = row.createCell(9);
		cell.setCellValue("DIRECCION");
		
		cell = row.createCell(10);
		cell.setCellValue("TELEFONO");
		
		cell = row.createCell(11);
		cell.setCellValue("UBICACION");
		
		cell = row.createCell(12);
		cell.setCellValue("CODIGO INTERNACIONAL");
		
		cell = row.createCell(13);
		cell.setCellValue("SERVICIO");
		
		cell = row.createCell(14);
		cell.setCellValue("E-MAIL");
		
		cell = row.createCell(15);
		cell.setCellValue("CONTRATO");
		
		cell = row.createCell(16);
		cell.setCellValue("COMPRA DIRECTA");
		
		cell = row.createCell(17);
		cell.setCellValue("CONVENIO");
		
		cell = row.createCell(18);
		cell.setCellValue("DONADO");
		
		cell = row.createCell(19);
		cell.setCellValue("ASIGNADO POR EL MINISTERIO");
		
		cell = row.createCell(20);
		cell.setCellValue("ASIGNADO POR LA GOBERNACION");
		
		cell = row.createCell(21);
		cell.setCellValue("COMODATO");
		
		cell = row.createCell(22);
		cell.setCellValue("FECHA DE COMPRA");
		
		cell = row.createCell(23);
		cell.setCellValue("FECHA DE INSTALACIÓN");
		
		cell = row.createCell(24);
		cell.setCellValue("FECHA DE INICIO OPERACIÓN");
		
		cell = row.createCell(25);
		cell.setCellValue("FECHA VENCIMIENTO GARANTÍA");
		
		cell = row.createCell(26);
		cell.setCellValue("COSTO DE COMPRA");
		
		cell = row.createCell(27);
		cell.setCellValue("REGISTRO INVIMA");
		
		cell = row.createCell(28);
		cell.setCellValue("FABRICANTE");
		
		cell = row.createCell(29);
		cell.setCellValue("PAIS");
		
		cell = row.createCell(30);
		cell.setCellValue("PROVEEDOR");
		
		cell = row.createCell(31);
		cell.setCellValue("TELEFONO PROVEEDOR");
		
		cell = row.createCell(32);
		cell.setCellValue("CORREO PROVEEDOR");
		
		cell = row.createCell(33);
		cell.setCellValue("CIUDAD PROVEEDOR");
		
		cell = row.createCell(34);
		cell.setCellValue("REPRESENTANTE");
		
		cell = row.createCell(35);
		cell.setCellValue("TELEFONO REPRESENTANTE");
		
		cell = row.createCell(36);
		cell.setCellValue("VOLTAJE MAXIMO OPERACION");
		
		cell = row.createCell(37);
		cell.setCellValue("VOLTAJE MINIMO OPERACION");
		
		cell = row.createCell(38);
		cell.setCellValue("CORRIENTE MAXIMA OPERACION");
		
		cell = row.createCell(39);
		cell.setCellValue("CORRIENTE MINIMA OPERACION");
		
		cell = row.createCell(40);
		cell.setCellValue("POTENCIA CONSUMIDA");
		
		cell = row.createCell(41);
		cell.setCellValue("FRECUENCIA");
		
		cell = row.createCell(42);
		cell.setCellValue("PRESION");
		
		cell = row.createCell(43);
		cell.setCellValue("VELOCIDAD");
		
		cell = row.createCell(44);
		cell.setCellValue("TEMPERATURA");
		
		cell = row.createCell(45);
		cell.setCellValue("PESO");
		
		cell = row.createCell(46);
		cell.setCellValue("CAPACIDAD");
		
		cell = row.createCell(47);
		cell.setCellValue("OTROS");
		
		cell = row.createCell(48);
		cell.setCellValue("ELECTRICIDAD");
		
		cell = row.createCell(49);
		cell.setCellValue("ENERGIA SOLAR");
		
		cell = row.createCell(50);
		cell.setCellValue("AGUA");
		
		cell = row.createCell(51);
		cell.setCellValue("GAS");
		
		cell = row.createCell(52);
		cell.setCellValue("VAPOR AGUA");
		
		cell = row.createCell(53);
		cell.setCellValue("DERIVADOS DEL PETROLEO");
		
		cell = row.createCell(54);
		cell.setCellValue("OTRAS FUENTES");
		
		cell = row.createCell(55);
		cell.setCellValue("FIJO");
		
		cell = row.createCell(56);
		cell.setCellValue("PORTATIL");
		
		cell = row.createCell(57);
		cell.setCellValue("MEDICO");
		
		cell = row.createCell(58);
		cell.setCellValue("BASICO");
		
		cell = row.createCell(59);
		cell.setCellValue("APOYO");
		
		cell = row.createCell(60);
		cell.setCellValue("I");
		
		cell = row.createCell(61);
		cell.setCellValue("IIA");
		
		cell = row.createCell(62);
		cell.setCellValue("IIB");
		
		cell = row.createCell(63);
		cell.setCellValue("III");
		
		cell = row.createCell(64);
		cell.setCellValue("ELECTRICO");
		
		cell = row.createCell(65);
		cell.setCellValue("ELECTRONICO");
		
		cell = row.createCell(66);
		cell.setCellValue("MECANICO");
		
		cell = row.createCell(67);
		cell.setCellValue("ELECTROMECANICO");
		
		cell = row.createCell(68);
		cell.setCellValue("HIDRAULICO");
		
		cell = row.createCell(69);
		cell.setCellValue("NEUMATICO");
		
		cell = row.createCell(70);
		cell.setCellValue("VAPOR");
		
		cell = row.createCell(71);
		cell.setCellValue("SOLAR");
		
		cell = row.createCell(72);
		cell.setCellValue("DIAGNOSTICO");
		
		cell = row.createCell(73);
		cell.setCellValue("TRATAMIENTO Y MANTENIMIENTO DE LA VIDA");
		
		cell = row.createCell(74);
		cell.setCellValue("REHABILITACION");
		
		cell = row.createCell(75);
		cell.setCellValue("PREVENCION");
		
		cell = row.createCell(76);
		cell.setCellValue("ANALISIS DE LABORATORIO");
		
		cell = row.createCell(77);
		cell.setCellValue("TRIMESTRAL");
		
		cell = row.createCell(78);
		cell.setCellValue("CUATRIMESTRAL");
		
		cell = row.createCell(79);
		cell.setCellValue("SEMESTRAL");
		
		cell = row.createCell(80);
		cell.setCellValue("ANUAL");
		
		cell = row.createCell(81);
		cell.setCellValue("PROPIO");
		
		cell = row.createCell(82);
		cell.setCellValue("CONTRATADO");
		
		cell = row.createCell(83);
		cell.setCellValue("COMODATO");
		
		cell = row.createCell(84);
		cell.setCellValue("GARANTIA");
		
		cell = row.createCell(85);
		cell.setCellValue("HOSPITAL");
		
		cell = row.createCell(86);
		cell.setCellValue("PROVEEDOR");
		
		cell = row.createCell(87);
		cell.setCellValue("OTRO");
		
		cell = row.createCell(88);
		cell.setCellValue("OPERACIONAL-USUARIO");
		
		cell = row.createCell(89);
		cell.setCellValue("TECNICO");
		
		cell = row.createCell(90);
		cell.setCellValue("SI REQUIERE C/V");
		
		cell = row.createCell(91);
		cell.setCellValue("NO REQUIERE C/V");
		
		cell = row.createCell(92);
		cell.setCellValue("C/V SEMESTRAL");
		
		cell = row.createCell(93);
		cell.setCellValue("C/V ANUAL");
		
		cell = row.createCell(94);
		cell.setCellValue("ACCESORIOS 1");
		
		cell = row.createCell(95);
		cell.setCellValue("ACCESORIOS 2");
		
		cell = row.createCell(96);
		cell.setCellValue("ACCESORIOS 3");
		
		cell = row.createCell(97);
		cell.setCellValue("ACCESORIOS 4");
		
		
	}
	private void writeDataRows() {
		int rowCount = 1;
		for(Hoja_vida_otros hoja_vida:listhvotros) {
			
			Row row = sheet.createRow(rowCount++);
			
			Cell cell = row.createCell(0);
			cell.setCellValue(hoja_vida.getId_Hoja_vida_otros());
			
			cell = row.createCell(1);
			cell.setCellValue(hoja_vida.getSerie_otros());
			
			cell = row.createCell(2);
			cell.setCellValue(hoja_vida.getNombre_equipo_otros());
			
			cell = row.createCell(3);
			cell.setCellValue(hoja_vida.getMarca_otros());
			
			cell = row.createCell(4);
			cell.setCellValue(hoja_vida.getModelo_otros());
			
			cell = row.createCell(5);
			cell.setCellValue(hoja_vida.getAno_fabricacion_otros());
			
			cell = row.createCell(6);
			cell.setCellValue(hoja_vida.getPlaca_inventario_otros());
			
			cell = row.createCell(7);
			cell.setCellValue(hoja_vida.getDepartamento_otros());
			
			cell = row.createCell(8);
			cell.setCellValue(hoja_vida.getMunicipio_otros());

			cell = row.createCell(9);
			cell.setCellValue(hoja_vida.getDireccion_otros());
			
			cell = row.createCell(10);
			cell.setCellValue(hoja_vida.getTelefonoinstitucion_otros());
			
			cell = row.createCell(11);
			cell.setCellValue(hoja_vida.getUbicacioninstitucion_otros());
			
			cell = row.createCell(12);
			cell.setCellValue(hoja_vida.getCodinternacional_otros());
			
			cell = row.createCell(13);
			cell.setCellValue(hoja_vida.getServicioinstitucion_otros());
			
			cell = row.createCell(14);
			cell.setCellValue(hoja_vida.getEmailinstitucion_otros());
			
			cell = row.createCell(15);
			cell.setCellValue(hoja_vida.getContrato_otros());
			
			cell = row.createCell(16);
			cell.setCellValue(hoja_vida.isCompraddirecta_otros());
			
			cell = row.createCell(17);
			cell.setCellValue(hoja_vida.isConvenio_otros());
			
			cell = row.createCell(18);
			cell.setCellValue(hoja_vida.isDonado_otros());
			
			cell = row.createCell(19);
			cell.setCellValue(hoja_vida.isAsignadoporministerio_otros());
			
			cell = row.createCell(20);
			cell.setCellValue(hoja_vida.isAsignadoporgobernacion_otros());
			
			cell = row.createCell(21);
			cell.setCellValue(hoja_vida.isComodato_otros());
			
			cell = row.createCell(22);
			cell.setCellValue(hoja_vida.getFecha_compra_otros());
			
			cell = row.createCell(23);
			cell.setCellValue(hoja_vida.getFecha_instalacion_otros());
			
			cell = row.createCell(24);
			cell.setCellValue(hoja_vida.getFecha_iniciooperacion_otros());
			
			cell = row.createCell(25);
			cell.setCellValue(hoja_vida.getFecha_vencimientogarantia_otros());
			
			cell = row.createCell(26);
			cell.setCellValue(hoja_vida.getCosto_compra_otros());
			
			cell = row.createCell(27);
			cell.setCellValue(hoja_vida.getRegistro_invima_otros());
			
			cell = row.createCell(28);
			cell.setCellValue(hoja_vida.getFabricante_otros());
			
			cell = row.createCell(29);
			cell.setCellValue(hoja_vida.getPaisfabricante_otros());
			
			cell = row.createCell(30);
			cell.setCellValue(hoja_vida.getProveedor_otros());
			
			cell = row.createCell(31);
			cell.setCellValue(hoja_vida.getTelefonoproveedor_otros());
			
			cell = row.createCell(32);
			cell.setCellValue(hoja_vida.getCorreoproveedor_otros());
			
			cell = row.createCell(33);
			cell.setCellValue(hoja_vida.getCiudadproveedor_otros());
			
			cell = row.createCell(34);
			cell.setCellValue(hoja_vida.getRepresentante_otros());
			
			cell = row.createCell(35);
			cell.setCellValue(hoja_vida.getTelefonorepresentante_otros());
			
			cell = row.createCell(36);
			cell.setCellValue(hoja_vida.getVmaxoperacion_otros());
			
			cell = row.createCell(37);
			cell.setCellValue(hoja_vida.getVminoperacion_otros());
			
			cell = row.createCell(38);
			cell.setCellValue(hoja_vida.getImaxoperacion_otros());
			
			cell = row.createCell(39);
			cell.setCellValue(hoja_vida.getIminoperacion_otros());
			
			cell = row.createCell(40);
			cell.setCellValue(hoja_vida.getWconsumida_otros());
			
			cell = row.createCell(41);
			cell.setCellValue(hoja_vida.getFrecuencia_otros());
			
			cell = row.createCell(42);
			cell.setCellValue(hoja_vida.getPresion_otros());
			
			cell = row.createCell(43);
			cell.setCellValue(hoja_vida.getVelocidad_otros());
			
			cell = row.createCell(44);
			cell.setCellValue(hoja_vida.getTemperatura_otros());
			
			cell = row.createCell(45);
			cell.setCellValue(hoja_vida.getPeso_otros());
			
			cell = row.createCell(46);
			cell.setCellValue(hoja_vida.getCapacidad_otros());
			
			cell = row.createCell(47);
			cell.setCellValue(hoja_vida.getOtrosdatostecnicos_otros());
			
			cell = row.createCell(48);
			cell.setCellValue(hoja_vida.isFuenteaelectricidad_otros());
			
			cell = row.createCell(49);
			cell.setCellValue(hoja_vida.isFuenteaenergiasolar_otros());
			
			cell = row.createCell(50);
			cell.setCellValue(hoja_vida.isFuenteaagua_otros());
			
			cell = row.createCell(51);
			cell.setCellValue(hoja_vida.isFuenteagas_otros());
			
			cell = row.createCell(52);
			cell.setCellValue(hoja_vida.isFuenteavaporagua_otros());
			
			cell = row.createCell(53);
			cell.setCellValue(hoja_vida.isFuenteaderivadospetroleo_otros());
			
			cell = row.createCell(54);
			cell.setCellValue(hoja_vida.isFuenteaotros_otros());
			
			cell = row.createCell(55);
			cell.setCellValue(hoja_vida.isEquipotipofijo_otros());
			
			cell = row.createCell(56);
			cell.setCellValue(hoja_vida.isEquipotipoportatil_otros());
			
			cell = row.createCell(57);
			cell.setCellValue(hoja_vida.isUsomedico_otros());

			cell = row.createCell(58);
			cell.setCellValue(hoja_vida.isUsobasico_otros());
			
			cell = row.createCell(59);
			cell.setCellValue(hoja_vida.isUsoapoyo_otros());
			
			cell = row.createCell(60);
			cell.setCellValue(hoja_vida.isRiesgoi_otros());
			
			cell = row.createCell(61);
			cell.setCellValue(hoja_vida.isRiesgoiia_otros());
			
			cell = row.createCell(62);
			cell.setCellValue(hoja_vida.isRiesgoiib_otros());
			
			cell = row.createCell(63);
			cell.setCellValue(hoja_vida.isRiesgoiii_otros());
			
			cell = row.createCell(64);
			cell.setCellValue(hoja_vida.isClaseelectrico_otros());
			
			cell = row.createCell(65);
			cell.setCellValue(hoja_vida.isClaseelectronico_otros());
			
			cell = row.createCell(66);
			cell.setCellValue(hoja_vida.isClasemecanico_otros());
			
			cell = row.createCell(67);
			cell.setCellValue(hoja_vida.isClaseelectromecanico_otros());
			
			cell = row.createCell(68);
			cell.setCellValue(hoja_vida.isClasehidraulico_otros());
			
			cell = row.createCell(69);
			cell.setCellValue(hoja_vida.isClaseneumatico_otros());
			
			cell = row.createCell(70);
			cell.setCellValue(hoja_vida.isClasevapor_otros());
			
			cell = row.createCell(71);
			cell.setCellValue(hoja_vida.isClasesolar_otros());
			
			cell = row.createCell(72);
			cell.setCellValue(hoja_vida.isBiomedicdiagnostico_otros());
			
			cell = row.createCell(73);
			cell.setCellValue(hoja_vida.isBiomedictratamiento_otros());
			
			cell = row.createCell(74);
			cell.setCellValue(hoja_vida.isBiomedicrehabilitacion_otros());
			
			cell = row.createCell(75);
			cell.setCellValue(hoja_vida.isBiomedicprevencion_otros());
			
			cell = row.createCell(76);
			cell.setCellValue(hoja_vida.isBiomedicanalisis_otros());
			
			cell = row.createCell(77);
			cell.setCellValue(hoja_vida.isPtrimestral_otros());
			
			cell = row.createCell(78);
			cell.setCellValue(hoja_vida.isPcuatrimestral_otros());
			
			cell = row.createCell(79);
			cell.setCellValue(hoja_vida.isPsemestral_otros());
			
			cell = row.createCell(80);
			cell.setCellValue(hoja_vida.isPanual_otros());
			
			cell = row.createCell(81);
			cell.setCellValue(hoja_vida.isMapropio_otros());
			
			cell = row.createCell(82);
			cell.setCellValue(hoja_vida.isMacontratado_otros());
			
			cell = row.createCell(83);
			cell.setCellValue(hoja_vida.isMacomodato_otros());
			
			cell = row.createCell(84);
			cell.setCellValue(hoja_vida.isMagarantia_otros());
			
			cell = row.createCell(85);
			cell.setCellValue(hoja_vida.isProphospital_otros());
			
			cell = row.createCell(86);
			cell.setCellValue(hoja_vida.isPropproveedor_otros());
			
			cell = row.createCell(87);
			cell.setCellValue(hoja_vida.isPropotro_otros());
			
			cell = row.createCell(88);
			cell.setCellValue(hoja_vida.isManual_operacion_otros());
			
			cell = row.createCell(89);
			cell.setCellValue(hoja_vida.isManual_tecnico_otros());
			
			cell = row.createCell(90);
			cell.setCellValue(hoja_vida.isRequierecalibracion_otros());
			
			cell = row.createCell(91);
			cell.setCellValue(hoja_vida.isNorequierecalibracion_otros());
			
			cell = row.createCell(92);
			cell.setCellValue(hoja_vida.isPcalsemestral_otros());
			
			cell = row.createCell(93);
			cell.setCellValue(hoja_vida.isPcalanual_otros());
			
			cell = row.createCell(94);
			cell.setCellValue(hoja_vida.getAccesorio1_otros());
			
			cell = row.createCell(95);
			cell.setCellValue(hoja_vida.getAccesorio2_otros());
			
			cell = row.createCell(96);
			cell.setCellValue(hoja_vida.getAccesorio3_otros());
			
			cell = row.createCell(97);
			cell.setCellValue(hoja_vida.getAccesorio4_otros());
		}
				
		
	}
	public void export(HttpServletResponse response) throws IOException {
		writeHeaderRow();
		writeDataRows();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	
	

}
