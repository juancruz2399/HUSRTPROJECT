package com.HUSRTbdBiomedica.app.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.HUSRTbdBiomedica.service.IEquipoService;
import com.HUSRTbdBiomedica.service.IReporteService;
import com.HUSRTbdBiomedica.service.ITipo_equipoService;

@Controller
@RequestMapping
public class IndicadoresController {
	@Autowired
	private IEquipoService EquipoService;
	
	@Autowired
	private ITipo_equipoService Tipo_equipoService;
	
	@Autowired
	private IReporteService ReporteService;
	
	@GetMapping("/indicadores")
	public String mostrarmesanoind(Model model,
			RedirectAttributes flash) {
		
		LocalDate Current_Date = LocalDate.now();
		int current_year= Current_Date.getYear();
		int initial_year = current_year;
		int final_year = current_year;
		
		Month current_month = Current_Date.getMonth();
		int Mesfinal = current_month.getValue();
		int Mesinicial = Mesfinal-1;
		int Mesfinal3  = Mesfinal+1;
		String Mesactual = null;
		String Mesanterior = null;
		String Messiguiente = null;
		if (Mesinicial<10 || Mesfinal<10 || Mesfinal3 <10 && Mesinicial!=0) {
			Mesactual="0"+Mesfinal;
			Mesanterior = "0"+Mesinicial;
			Messiguiente = "0"+Mesfinal3;
		}
		
		else if(Mesinicial==0 ) {
			Mesanterior = "12";
			Mesactual = "01";
			initial_year = current_year-1;
			
			
			
		}
		else if(Mesfinal3 ==13) {
			Messiguiente = "01";
			final_year = current_year+1;
			
		}
		
		else {
			Mesanterior = String.valueOf(Mesinicial);
			Mesactual = String.valueOf(Mesfinal);
			
		}
		String fecha_1 = initial_year+"-"+Mesanterior+"-"+"01";
		String fecha_2 = current_year+"-"+Mesactual+"-"+"01";
		String fecha_3 = final_year +"-"+Messiguiente+"-"+"01";
		
		Date fecha1 = Date.valueOf(fecha_1);
		Date fecha2 = Date.valueOf(fecha_2);
		Date fecha3 = Date.valueOf(fecha_3);
		
		
		model.addAttribute("fechaactual",fecha3);
		model.addAttribute("fechaanterior",fecha2);
		int numcmesanterior = ReporteService.countCorrectivos(fecha1, fecha2);
		int numcmesactual = ReporteService.countCorrectivos(fecha2, fecha3);
		float correctivosind = 0;
		if (numcmesanterior==0) {
			correctivosind = 0;
			
		}
		else {
			correctivosind = (float)numcmesactual/numcmesanterior;
		}
		
		int numpreventivosactual = ReporteService.countPreventivos(fecha2, fecha3);
		float correcvspreven = 0;
		if(numpreventivosactual==0) {
			correcvspreven=0;
			
		}
		else {
			correcvspreven = (float)numcmesactual/numpreventivosactual;
			
		}
		
		int numpredictivosactual = ReporteService.countPredictivos(fecha2, fecha3);
		float correcvspredic = 0;
		if(numpredictivosactual==0) {
			correcvspredic=0;
		}
		else {
			correcvspredic = (float)numcmesactual/numpredictivosactual;
			
		}
		int numotrosactual = ReporteService.countOtros(fecha2, fecha3);
		
		int numopindebidacorrectivo = ReporteService.countopindebidacorrectivo(fecha2, fecha3);
		float opincorrecvscorrecactual = 0;
		if(numcmesactual ==0) {
			opincorrecvscorrecactual=0;
		}
		else {
			opincorrecvscorrecactual = (float)numopindebidacorrectivo/numcmesactual;
		}

		int numcausaexcorrectivo = ReporteService.countcausaexcorrectivo(fecha2, fecha3);
		float causaexcorrecvscorrecactual = 0;
		if(numcmesactual==0) {
			causaexcorrecvscorrecactual = 0;
			
		}
		else {
			causaexcorrecvscorrecactual = (float)numcausaexcorrectivo/numcmesactual;
		}
		int previstos = 1;
		if (Mesfinal==1) {
			previstos = EquipoService.numprevEnero();
		}
		else if(Mesfinal==2) {
			previstos = EquipoService.numpreFebrero();
		}
		else if(Mesfinal==3) {
			previstos = EquipoService.numpreMarzo();		
		}
		else if(Mesfinal==4) {
			previstos = EquipoService.numpreAbril();
		}
		else if(Mesfinal==5) {
			previstos = EquipoService.numpreMayo();
		}
		else if(Mesfinal==6) {
			previstos = EquipoService.numpreJunio();
		}
		else if(Mesfinal==7) {
			previstos = EquipoService.numpreJulio();
		}
		else if(Mesfinal==8) {
			previstos = EquipoService.numpreAgosto();
		}
		else if(Mesfinal==9) {
			previstos = EquipoService.numpreSeptiembre();
		}
		else if(Mesfinal==10) {
			previstos = EquipoService.numpreOctubre();
		}
		else if(Mesfinal==11) {
			previstos = EquipoService.numpreNoviembre();
		}
		else if(Mesfinal==12) {
			previstos = EquipoService.numpreDiciembre();
		}		
		else {
			previstos = 1;
		}
		float prevenvsprevistos = (float)numpreventivosactual/previstos;
		
		
		int numdesgastecorrectivo = ReporteService.countdesgastecorrectivo(fecha2, fecha3);
		int numaccesorioscorrectivo = ReporteService.countaccesorioscorrectivo(fecha2, fecha3);
		int numdesconocidocorrectivo = ReporteService.countdesconocidocorrectivo(fecha2, fecha3);
		int numsinfallascorrectivo = ReporteService.countsinfallascorrectivo(fecha2, fecha3);
		int numotrocorrectivo = ReporteService.countotrocorrectivo(fecha2, fecha3);
		
		int numdesgastemes = ReporteService.countdesgaste(fecha2, fecha3);
		int numopindebidames = ReporteService.countopindebida(fecha2, fecha3);
		int numcausaexmes = ReporteService.countcausaex(fecha2, fecha3);
		int numaccesioriosmes = ReporteService.countaccesorios(fecha2, fecha3);
		int numdesconocidomes = ReporteService.countdesconocido(fecha2, fecha3);
		int numsinfallasmes = ReporteService.countsinfallas(fecha2, fecha3);
		int numotromes = ReporteService.countotro(fecha2, fecha3);
		
		Time total_h = ReporteService.tiempopromedio(fecha2, fecha3);
		
		model.addAttribute("tiempopromedio", total_h);
		model.addAttribute("mantprevistos",previstos);
		model.addAttribute("prevenvsprevistos",prevenvsprevistos);
		model.addAttribute("desgaste",numdesgastemes);
		model.addAttribute("opindebida",numopindebidames);
		model.addAttribute("causaexterna",numcausaexmes);
		model.addAttribute("accesorios",numaccesioriosmes);
		model.addAttribute("desconocido",numdesconocidomes);
		model.addAttribute("sinfallas",numsinfallasmes);
		model.addAttribute("otros",numotromes);
		
		model.addAttribute("correctivosdesgaste",numdesgastecorrectivo);
		model.addAttribute("correctivosaccesorios",numaccesorioscorrectivo);
		model.addAttribute("correctivosdesconocido",numdesconocidocorrectivo);
		model.addAttribute("correctivossinfallas",numsinfallascorrectivo);
		model.addAttribute("correctivosotros",numotrocorrectivo);
		
		model.addAttribute("causaexcorrecvscorrecactual",causaexcorrecvscorrecactual);
		model.addAttribute("correctivoscausaexterna",numcausaexcorrectivo);
		
		
		model.addAttribute("correctivosopindebida",numopindebidacorrectivo);
		model.addAttribute("opincorrecvscorrecactual",opincorrecvscorrecactual);		
		model.addAttribute("otrosmactual",numotrosactual);
		model.addAttribute("correcvspredic",correcvspredic);
		model.addAttribute("predictivosmactual",numpredictivosactual);
		model.addAttribute("correcvspreven",correcvspreven);
		model.addAttribute("preventivosmactual",numpreventivosactual);
		model.addAttribute("correctivosmactual",numcmesactual);
		model.addAttribute("correctivosmpasado",numcmesanterior);
		model.addAttribute("correctivos",correctivosind);
		return "indicadores";
		
	}
	@PostMapping("/indicadores")
	public String obtenermesanoind(Model model,
			RedirectAttributes flash, 
			@RequestParam(value="fecha_inicial",defaultValue = "2022-03-01")String fecha_inicial,
			@RequestParam(value="fecha_final",defaultValue = "2022-02-01")String fecha_final) {
		
		
		LocalDate f1 = LocalDate.parse(fecha_inicial);
		int ano = f1.getYear();
		int anoanterior = ano;
		Month mes1 = f1.getMonth();
		int mesactual =mes1.getValue();
		int mesanterior = mesactual-1;
		String mesant = null;
		if (mesanterior<10 && mesanterior!=0) {
			mesant = "0"+mesanterior;
			
		}
		else if(mesanterior==0) {
			mesant="12";
			anoanterior = ano-1;
		}
		else {
			mesant = String.valueOf(mesanterior); 
			
		}
		
		String fecha_1 = anoanterior+"-"+mesant+"-"+"01";
		
		Date fecha1 = Date.valueOf(fecha_1);
		Date fecha2 = Date.valueOf(fecha_inicial);
		Date fecha3 = Date.valueOf(fecha_final);
		System.out.println(fecha1);
		System.out.println(fecha2);
		System.out.println(fecha3);
		
		int numcmesanterior = ReporteService.countCorrectivos(fecha1, fecha2);
		int numcmesactual = ReporteService.countCorrectivos(fecha2, fecha3);
		float correctivosind = 0;
		if (numcmesanterior==0) {
			correctivosind = 0;
			
		}
		else {
			correctivosind =(float)numcmesactual/numcmesanterior;
		}
		
		int numpreventivosactual = ReporteService.countPreventivos(fecha2, fecha3);
		float correcvspreven = 0;
		if(numpreventivosactual==0) {
			correcvspreven=0;
			
		}
		else {
			correcvspreven = (float)numcmesactual/numpreventivosactual;
			
		}
		
		int numpredictivosactual = ReporteService.countPredictivos(fecha2, fecha3);
		float correcvspredic = 0;
		if(numpredictivosactual==0) {
			correcvspredic=0;
		}
		else {
			correcvspredic = (float)numcmesactual/numpredictivosactual;
			
		}
		int numotrosactual = ReporteService.countOtros(fecha2, fecha3);
		
		int numopindebidacorrectivo = ReporteService.countopindebidacorrectivo(fecha2, fecha3);
		float opincorrecvscorrecactual = 0;
		if(numcmesactual ==0) {
			opincorrecvscorrecactual=0;
		}
		else {
			opincorrecvscorrecactual = (float)numopindebidacorrectivo/numcmesactual;
		}
		int numcausaexcorrectivo = ReporteService.countcausaexcorrectivo(fecha2, fecha3);
		float causaexcorrecvscorrecactual = 0;
		if(numcmesactual==0) {
			causaexcorrecvscorrecactual = 0;
			
		}
		else {
			causaexcorrecvscorrecactual = (float)numcausaexcorrectivo/numcmesactual;
		}
		int previstos = 1;
		if (mesactual==1) {
			previstos = EquipoService.numprevEnero();
		}
		else if(mesactual==2) {
			previstos = EquipoService.numpreFebrero();
		}
		else if(mesactual==3) {
			previstos = EquipoService.numpreMarzo();		
		}
		else if(mesactual==4) {
			previstos = EquipoService.numpreAbril();
		}
		else if(mesactual==5) {
			previstos = EquipoService.numpreMayo();
		}
		else if(mesactual==6) {
			previstos = EquipoService.numpreJunio();
		}
		else if(mesactual==7) {
			previstos = EquipoService.numpreJulio();
		}
		else if(mesactual==8) {
			previstos = EquipoService.numpreAgosto();
		}
		else if(mesactual==9) {
			previstos = EquipoService.numpreSeptiembre();
		}
		else if(mesactual==10) {
			previstos = EquipoService.numpreOctubre();
		}
		else if(mesactual==11) {
			previstos = EquipoService.numpreNoviembre();
		}
		else if(mesactual==12) {
			previstos = EquipoService.numpreDiciembre();
		}		
		else {
			previstos = 1;
		}
		float prevenvsprevistos = (float)numpreventivosactual/previstos;
		
		
		int numdesgastecorrectivo = ReporteService.countdesgastecorrectivo(fecha2, fecha3);
		int numaccesorioscorrectivo = ReporteService.countaccesorioscorrectivo(fecha2, fecha3);
		int numdesconocidocorrectivo = ReporteService.countdesconocidocorrectivo(fecha2, fecha3);
		int numsinfallascorrectivo = ReporteService.countsinfallascorrectivo(fecha2, fecha3);
		int numotrocorrectivo = ReporteService.countotrocorrectivo(fecha2, fecha3);
		
		int numdesgastemes = ReporteService.countdesgaste(fecha2, fecha3);
		int numopindebidames = ReporteService.countopindebida(fecha2, fecha3);
		int numcausaexmes = ReporteService.countcausaex(fecha2, fecha3);
		int numaccesioriosmes = ReporteService.countaccesorios(fecha2, fecha3);
		int numdesconocidomes = ReporteService.countdesconocido(fecha2, fecha3);
		int numsinfallasmes = ReporteService.countsinfallas(fecha2, fecha3);
		int numotromes = ReporteService.countotro(fecha2, fecha3);
		
		Time total_h = ReporteService.tiempopromedio(fecha2, fecha3);
		
		Time thorainicio = ReporteService.avghorainicio(fecha2, fecha3);
		Time thorallamado = ReporteService.avghorallamado(fecha2, fecha3);
		LocalTime tinicio = thorainicio.toLocalTime();
		LocalTime tllamado = thorallamado.toLocalTime();
		
		LocalTime trta = tinicio.minusHours(tllamado.getHour());
		LocalTime tiemporespuesta = trta.minusMinutes(tllamado.getMinute());
		
		model.addAttribute("tiempoderespuesta",tiemporespuesta);
		model.addAttribute("tiempopromedio", total_h);
		model.addAttribute("mantprevistos",previstos);
		model.addAttribute("prevenvsprevistos",prevenvsprevistos);
		
		model.addAttribute("desgaste",numdesgastemes);
		model.addAttribute("opindebida",numopindebidames);
		model.addAttribute("causaexterna",numcausaexmes);
		model.addAttribute("accesorios",numaccesioriosmes);
		model.addAttribute("desconocido",numdesconocidomes);
		model.addAttribute("sinfallas",numsinfallasmes);
		model.addAttribute("otros",numotromes);
		
		model.addAttribute("correctivosdesgaste",numdesgastecorrectivo);
		model.addAttribute("correctivosaccesorios",numaccesorioscorrectivo);
		model.addAttribute("correctivosdesconocido",numdesconocidocorrectivo);
		model.addAttribute("correctivossinfallas",numsinfallascorrectivo);
		model.addAttribute("correctivosotros",numotrocorrectivo);
		
		model.addAttribute("causaexcorrecvscorrecactual",causaexcorrecvscorrecactual);
		model.addAttribute("correctivoscausaexterna",numcausaexcorrectivo);
		
		
		model.addAttribute("correctivosopindebida",numopindebidacorrectivo);
		model.addAttribute("opincorrecvscorrecactual",opincorrecvscorrecactual);		
		model.addAttribute("otrosmactual",numotrosactual);
		model.addAttribute("correcvspredic",correcvspredic);
		model.addAttribute("predictivosmactual",numpredictivosactual);
		model.addAttribute("correcvspreven",correcvspreven);
		model.addAttribute("preventivosmactual",numpreventivosactual);
		model.addAttribute("correctivosmactual",numcmesactual);
		model.addAttribute("correctivosmpasado",numcmesanterior);
		model.addAttribute("correctivos",correctivosind);
		
		model.addAttribute("fechaactual",fecha3);
		model.addAttribute("fechaanterior",fecha2);

		return"indicadores";
	}

}
