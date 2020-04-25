package com.thiago.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.thiago.driver.TLDriverFactory;



/**
 * Classe com metodos de apoio, que otimizam a codificacao das classes de pagina
 * 
 * @author thiago.freire
 * 
 */
public abstract class Utils {

	public static String extrairStackTrace(Exception e) {
		StackTraceElement[] stack = e.getStackTrace();
		String exception = "";
		for (StackTraceElement s : stack) {
			exception = exception + s.toString() + "\n\t\t";
		}
		return exception;
	}

	
	/**
	 * Metodo para capturar screenshot
	 * @param driver 
	 * 
	 * @param fileName
	 *            - Nome do arquivo
	 */
	public static void takeScreenshot(WebDriver driver, String casoDeteste, String nomeEvidencia) {
		new TLDriverFactory();
		File scrFile = ((TakesScreenshot) TLDriverFactory.getDriver())
				.getScreenshotAs(OutputType.FILE);
		try {
			String pastaImages = "Evidencias/"+casoDeteste+"/"+nomeEvidencia+".jpg";
					
			String pastaResultado = "resultadoTest/" + pastaImages;
					
			File fileDestino = new File(pastaResultado);
			FileUtils.copyFile(scrFile,fileDestino,true);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void takeScreenshot(String casoDeteste, String nomeEvidencia) {
		new TLDriverFactory();
		File scrFile = ((TakesScreenshot) TLDriverFactory.getDriver())
				.getScreenshotAs(OutputType.FILE);	    
		try {
			String pastaImages = "Evidencias/"+casoDeteste+"/"+nomeEvidencia+getDataHoraAtual_ToEndOfFileNames()+".jpg";
					
			String pastaResultado = "resultadoTest/" + pastaImages;
					
			File fileDestino = new File(pastaResultado);
			FileUtils.copyFile(scrFile,fileDestino,true);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static Date getData(){
		Calendar cal = Calendar.getInstance();
		
		return cal.getTime();
	}
	
	public static String getDataAtual() {
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat("ddMMyyyy");
			Calendar calendar = new GregorianCalendar();
			Date data = new Date();
			calendar.setTime(data);
			return formatDate.format(data);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getDataHoraAtual() {
		try {
			LocalDateTime dataHoraAtual = LocalDateTime.now();
		    DateTimeFormatter formatDataHora = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    return dataHoraAtual.format(formatDataHora);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getDataHoraAtual_ToEndOfFileNames() {
		try {
			LocalDateTime dataHoraAtual = LocalDateTime.now();
		    DateTimeFormatter formatDataHora = DateTimeFormatter.ofPattern(" yyyy-MM-dd HH:mm:ss");
		    return dataHoraAtual.format(formatDataHora);
		} catch (Exception e) {
			return null;
		}
	}
}
