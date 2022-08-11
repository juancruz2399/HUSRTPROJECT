package com.HUSRTbdBiomedica.service;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.HUSRTbdBiomedica.app.entity.Reporte;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;






public class PdfGenarator {
	
	private String image = "./src/main/resources/static/images/Escudo_husrt.png";
	
	public ByteArrayOutputStream getPDF(Reporte reporte) throws DocumentException, IOException {

        // Creamos la instancia de memoria en la que se escribirá el archivo temporalmente
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        Document document = new Document(PageSize.LETTER);
        document.setMargins(5, 5, 20, 10);
        
        PdfWriter writer = PdfWriter.getInstance(document, bos);
       
        document.open();
        PdfContentByte contentByte = writer.getDirectContent();
        Image logo = Image.getInstance(image); 
        logo.setAlignment(Image.ALIGN_CENTER);
        
        logo.scaleAbsolute(60, 30);
        contentByte.beginText();
        String codigo = "CÓDIGO IB-F-14";
        String Version = "VERSION: 01";
        String fechaformato = "Fecha:11/05/2020";
        String hospital = "E.S.E HOSPITAL UNIVERSITARIO SAN RAFAEL DE TUNJA";
        String Encabezado = "REPORTE DE MANTENIMIENTO DIGITAL HRCATCH";
        Font fuenteTitulo = new Font();
        fuenteTitulo.setSize(11);
        fuenteTitulo.setStyle(Font.BOLD);
        
        Font fuenteTituloHospital = new Font();
        fuenteTituloHospital.setSize(10);
        fuenteTituloHospital.setStyle(Font.BOLD);

        Font negrita = new Font();
        negrita.setStyle(Font.BOLD);
        negrita.setSize(7);
        
        Font writers = new Font();
        writers.setStyle(Font.NORMAL);
        writers.setSize(8);
        
         


        Chunk titulo1 = new Chunk(hospital);
        Chunk titulo2 = new Chunk(Encabezado);
        
        Chunk code = new Chunk(codigo);
        Chunk vs = new Chunk(Version);
        Chunk date = new Chunk(fechaformato);
        //titulo.setUnderline(2f, -2f);

        titulo1.setFont(fuenteTituloHospital);
        titulo2.setFont(fuenteTitulo);
        code.setFont(negrita);
        vs.setFont(negrita);
        date.setFont(negrita);
        new Chunk(reporte.getAutor_realizado());
        
       

        

        Chunk firma = new Chunk("__________________");

        Chunk nombre = new Chunk();
        nombre.setFont(negrita);

        PdfPTable tabla = new PdfPTable(5);

        PdfPCell celda0 = new PdfPCell(new Phrase(code));
        PdfPCell celda1 = new PdfPCell(new Phrase(titulo1));
        celda1.setColspan(3);
        celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        PdfPCell celda2 = new PdfPCell(logo);
        celda2.setHorizontalAlignment(PdfCell.ALIGN_CENTER);
        PdfPCell celda3 = new PdfPCell(new Phrase(vs));
        
        PdfPCell celda4 = new PdfPCell(new Phrase(titulo2));
        celda4.setColspan(3);
        celda4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        PdfPCell celda5 = new PdfPCell(new Phrase(date));

        tabla.addCell(celda0);
        tabla.addCell(celda1);
        tabla.addCell(celda2);
        tabla.addCell(celda3);
        tabla.addCell(celda4);
        tabla.addCell(celda5);
        
        PdfPTable tabla2 = new PdfPTable(10);
        PdfPCell reportenm = new PdfPCell(new Phrase("REPORTE No."));
        reportenm.setColspan(2);
        PdfPCell numreporte = new PdfPCell(new Phrase(String.valueOf(reporte.getNumero_reporte())));
        numreporte.setColspan(3);
        PdfPCell celdadatename = new PdfPCell(new Phrase("FECHA: "));
        celdadatename.setColspan(2);
        PdfPCell celdadate = new PdfPCell(new Phrase(String.valueOf(reporte.getFecha())));
        celdadate.setColspan(3);
        
        PdfPCell equiponame = new PdfPCell(new Phrase("EQUIPO:"));
        equiponame.setColspan(2);
        PdfPCell equiporta = new PdfPCell(new Phrase(reporte.getNombre_equipo()));
        equiporta.setColspan(3);
        PdfPCell marcaname = new PdfPCell(new Phrase("MARCA"));
        marcaname.setColspan(2);
        PdfPCell marcarta = new PdfPCell(new Phrase(reporte.getMarca()));
        marcarta.setColspan(3); 
        
        PdfPCell modeloname = new PdfPCell(new Phrase("MODELO:"));
        modeloname.setColspan(2);
        PdfPCell modelorta = new PdfPCell(new Phrase(reporte.getModelo()));
        modelorta.setColspan(3);
        PdfPCell seriename = new PdfPCell(new Phrase("SERIE"));
        seriename.setColspan(2);
        PdfPCell serierta = new PdfPCell(new Phrase(reporte.getSerie()));
        serierta.setColspan(3); 
        
        PdfPCell placaname = new PdfPCell(new Phrase("INVENTARIO:"));
        placaname.setColspan(2);
        PdfPCell placarta = new PdfPCell(new Phrase(reporte.getPlaca_inventario()));
        placarta.setColspan(3);
        PdfPCell pname = new PdfPCell(new Phrase("PERIODICIDAD: "));
        pname.setColspan(2);
        PdfPCell prta = new PdfPCell(new Phrase(reporte.getMarca()));
        prta.setColspan(3); 
        
        PdfPCell servicioname = new PdfPCell(new Phrase("SERVICIO:"));
        servicioname.setColspan(2);
        PdfPCell serviciorta = new PdfPCell(new Phrase(reporte.getServicio()));
        serviciorta.setColspan(3);
        PdfPCell ubicacionname = new PdfPCell(new Phrase("UBICACIÓN: "));
        ubicacionname.setColspan(2);
        PdfPCell ubicacionrta = new PdfPCell(new Phrase(reporte.getUbicacion()));
        ubicacionrta.setColspan(3); 
        
        tabla.setSpacingAfter(10);
        
        tabla2.addCell(reportenm);
        tabla2.addCell(numreporte);
        tabla2.addCell(celdadatename);
        tabla2.addCell(celdadate);
        
        tabla2.addCell(equiponame);
        tabla2.addCell(equiporta);
        tabla2.addCell(marcaname);
        tabla2.addCell(marcarta);
        
        tabla2.addCell(modeloname);
        tabla2.addCell(modelorta);
        tabla2.addCell(seriename);
        tabla2.addCell(serierta);
        
        tabla2.addCell(placaname);
        tabla2.addCell(placarta);
        tabla2.addCell(pname);
        tabla2.addCell(prta);

        tabla2.addCell(servicioname);
        tabla2.addCell(serviciorta);
        tabla2.addCell(ubicacionname);
        tabla2.addCell(ubicacionrta);
        
        tabla2.setSpacingAfter(10);
        
        PdfPTable tabla3 = new PdfPTable(7);
        
        PdfPCell tipomname = new PdfPCell(new Phrase("TIPO DE MANTENIMIENTO"));
        tipomname.setColspan(7);
        tipomname.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        int Periodicidad  = reporte.getEquipo().getPeriodicidad();
        String pd = new String();
        String pv = new String();
        String cr = new String();
        String ot = new String();
        if(Periodicidad ==1 ) {
        	pd = "";
        }
        else if(Periodicidad ==2) {
        	
        }
        else if(Periodicidad ==3) {
        	
        }
        else {
        	
        }
        int tipommtto = reporte.getTipo_mantenimiento();
        if(tipommtto ==1 ) {
        	pd = "PREDICTIVO: ";
        	pv = "PREVENTIVO: ";
        	cr = "CORRECTIVO: ";
        	ot = "OTRO: X";
        }
        else if(tipommtto ==2) {
        	pd = "PREDICTIVO: ";
        	pv = "PREVENTIVO: ";
        	cr = "CORRECTIVO: X";
        	ot = "OTRO: ";
        }
        else if(tipommtto ==3) {
        	pd = "PREDICTIVO: ";
        	pv = "PREVENTIVO: X";
        	cr = "CORRECTIVO: ";
        	ot = "OTRO: ";
        }
        else {
        	pd = "PREDICTIVO: X";
        	pv = "PREVENTIVO: ";
        	cr = "CORRECTIVO: ";
        	ot = "OTRO: ";
        }
        PdfPCell predictivo = new PdfPCell(new Phrase(pd));
        predictivo.setColspan(2);
        PdfPCell preventivo = new PdfPCell(new Phrase(pv));
        preventivo.setColspan(2);
        PdfPCell correctivo = new PdfPCell(new Phrase(cr));
        correctivo.setColspan(2); 
        PdfPCell otro = new PdfPCell(new Phrase(ot));
        PdfPCell tipofname = new PdfPCell(new Phrase("TIPO DE FALLA"));
        tipofname.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tipofname.setColspan(7);
        String tipofalla = reporte.getTipo_falla();
        String desgaste = new String();
        String opi = new String();
        String caex = new String();
        String ac = new String();
        String desc = new String();
        String sfall = new String();
        String otf = new String();
    
        if(tipofalla.contains("1") ) {
        	desgaste = "1. DESGASTE: X";
        	opi = "2. OPERACIÓN INDEBIDA: ";
        	caex = "3. CAUSA EXTERNA: ";
        	ac = "4. ACCESORIOS: ";
        	desc = "5. DESCONOCIDO: ";
        	sfall = "6. SIN FALLAS: ";
        	otf = "7. OTRO: ";
        }
        else if(tipofalla.contains("2")) {
        	desgaste = "1. DESGASTE: ";
        	opi = "2. OPERACIÓN INDEBIDA: X";
        	caex = "3. CAUSA EXTERNA: ";
        	ac = "4. ACCESORIOS: ";
        	desc = "5. DESCONOCIDO: ";
        	sfall = "6. SIN FALLAS: ";
        	otf = "7. OTRO: ";
        }
        else if(tipofalla.contains("3")) {
        	desgaste = "1. DESGASTE: ";
        	opi = "2. OPERACIÓN INDEBIDA: ";
        	caex = "3. CAUSA EXTERNA: X";
        	ac = "4. ACCESORIOS: ";
        	desc = "5. DESCONOCIDO: ";
        	sfall = "6. SIN FALLAS: ";
        	otf = "7. OTRO: ";
        }
        else if(tipofalla.contains("4")) {
        	desgaste = "1. DESGASTE: ";
        	opi = "2. OPERACIÓN INDEBIDA: ";
        	caex = "3. CAUSA EXTERNA: ";
        	ac = "4. ACCESORIOS: X";
        	desc = "5. DESCONOCIDO: ";
        	sfall = "6. SIN FALLAS: ";
        	otf = "7. OTRO: ";
        }
        else if(tipofalla.contains("5")) {
        	desgaste = "1. DESGASTE: ";
        	opi = "2. OPERACIÓN INDEBIDA: ";
        	caex = "3. CAUSA EXTERNA: ";
        	ac = "4. ACCESORIOS: ";
        	desc = "5. DESCONOCIDO: X";
        	sfall = "6. SIN FALLAS: ";
        	otf = "7. OTRO: ";
        }
        else if(tipofalla.contains("6")) {
        	desgaste = "1. DESGASTE: ";
        	opi = "2. OPERACIÓN INDEBIDA: ";
        	caex = "3. CAUSA EXTERNA: ";
        	ac = "4. ACCESORIOS: ";
        	desc = "5. DESCONOCIDO: ";
        	sfall = "6. SIN FALLAS: X";
        	otf = "7. OTRO: ";
        }
        else {
        	desgaste = "1. DESGASTE: ";
        	opi = "2. OPERACIÓN INDEBIDA: ";
        	caex = "3. CAUSA EXTERNA: ";
        	ac = "4. ACCESORIOS: ";
        	desc = "5. DESCONOCIDO: ";
        	sfall = "6. SIN FALLAS: ";
        	otf = "7. OTRO: X";
        }
        // Asignamos la variable ByteArrayOutputStream bos donde se escribirá el documento
        PdfPCell f1 = new PdfPCell(new Phrase(desgaste));
   
        PdfPCell f2 = new PdfPCell(new Phrase(opi));
      
        PdfPCell f3 = new PdfPCell(new Phrase(caex));
        
        PdfPCell f4 = new PdfPCell(new Phrase(ac));
        PdfPCell f5 = new PdfPCell(new Phrase(desc));
        PdfPCell f6 = new PdfPCell(new Phrase(sfall));
        PdfPCell f7 = new PdfPCell(new Phrase(otf));
        Paragraph motivo = new Paragraph("MOTIVO DEL LLAMADO: ");
        Paragraph trealizado = new Paragraph("TRABAJO REALIZADO: "+reporte.getTrabajo_realizado());

        trealizado.setLeading(5.0f, 1.0f);
        
        PdfPCell llamado = new PdfPCell(motivo);
        llamado.setColspan(7);
        llamado.setMinimumHeight(30);
      
        
        PdfPCell trabajo = new PdfPCell(trealizado);
        trabajo.setColspan(7);
        tabla3.addCell(tipomname);
        tabla3.addCell(predictivo);
        tabla3.addCell(preventivo);
        tabla3.addCell(correctivo);
        tabla3.addCell(otro);
        
        tabla3.addCell(tipofname);
        tabla3.addCell(f1);
        tabla3.addCell(f2);
        tabla3.addCell(f3);
        tabla3.addCell(f4);
        tabla3.addCell(f5);
        tabla3.addCell(f6);
        tabla3.addCell(f7);
        tabla3.addCell(llamado);
        tabla3.addCell(trabajo);
        tabla3.setSpacingAfter(10);
        
        PdfPTable tabla4 = new PdfPTable(7);
        PdfPCell repuestosname = new PdfPCell(new Phrase("REPUESTOS UTILIZADOS"));
        repuestosname.setColspan(7);
        repuestosname.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        
        PdfPCell descres = new PdfPCell(new Phrase("DESCRIPCIÓN"));
        descres.setColspan(5);
        
        PdfPCell canres = new PdfPCell(new Phrase("CANTIDAD"));
        PdfPCell cegres = new PdfPCell(new Phrase("C. EGRESO"));

        PdfPCell descresrta = new PdfPCell(new Phrase(reporte.getRepuesto_cambiado()));
        descres.setColspan(5);
        
        PdfPCell canresrta = new PdfPCell(new Phrase("N/A"));
        PdfPCell cegresrta = new PdfPCell(new Phrase("N/A"));
        tabla4.addCell(descres);
        tabla4.addCell(canres);
        tabla4.addCell(cegres);
        tabla4.addCell(descresrta);
        tabla4.addCell(canresrta);
        tabla4.addCell(cegresrta);
        tabla4.setSpacingAfter(10);

      
        
        PdfPTable tabla5 = new PdfPTable(1);
        Paragraph obs = new Paragraph("OBSERVACIONES: ");
        PdfPCell Obser = new PdfPCell(obs);
     
        tabla5.addCell(Obser);
        tabla5.setSpacingAfter(10);
        
        PdfPTable tabla6 = new PdfPTable(4);
        
        PdfPCell realizado = new PdfPCell(new Phrase("REALIZADO POR: "));
        realizado.setColspan(2);
        
        PdfPCell recibido = new PdfPCell(new Phrase("RECIBIDO POR: "));
        recibido.setColspan(2);
        
        PdfPCell nombrerea = new PdfPCell(new Phrase(reporte.getAutor_realizado()));

        PdfPCell firmrea = new PdfPCell(new Phrase(firma));
        
        PdfPCell nombrereci = new PdfPCell(new Phrase(reporte.getAutor_recibido()));

        PdfPCell firmreci = new PdfPCell(new Phrase(firma));
       
        tabla6.addCell(realizado);
        tabla6.addCell(recibido);
        tabla6.addCell(nombrerea);
        tabla6.addCell(firmrea);
        tabla6.addCell(nombrereci);
        tabla6.addCell(firmreci);
        
        document.add(tabla);
        
        document.add(tabla2);
        document.add(tabla3);
        document.add(tabla4);
        document.add(tabla5);
        document.add(tabla6);
        
      
  
        contentByte.endText();
        document.close();
        // Retornamos la variable al finalizar
        return bos;
        
    }
	

}
