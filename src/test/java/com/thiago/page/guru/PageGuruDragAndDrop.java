package com.thiago.page.guru;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import com.thiago.util.Utils;

public class PageGuruDragAndDrop extends CorePage<PageGuruDragAndDrop>{
	
	// Habilitar/Desabilitar mensagens no Console
	boolean exibirLog = true;	
	
	public PageGuruDragAndDrop() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);		
	}
	
	// BANK
	@FindBy(xpath = "//*[@id=\"credit2\"]/a")
	private WebElement elementoBank;
	
	// SALES
	@FindBy(xpath = "//*[@id=\"credit1\"]/a")
	private WebElement elementoSales;
	
	// 5000
	@FindBy(xpath = "//*[@id=\"fourth\"]/a")
	private WebElement elementoValue5K;
	
	// DEBIT ACCOUNT
	@FindBy(xpath = "//*[@id=\"bank\"]")
	private WebElement debitSideAccount;
	
	// DEBIT AMOUNT
	@FindBy(xpath = "//*[@id=\"amt7\"]")
	private WebElement debitSideAmount;
	
	// CREDIT ACCOUNT
	@FindBy(xpath = "//*[@id=\"loan\"]/li")
	private WebElement crebitSideAccount;
	
	// CREDIT AMOUNT
	@FindBy(xpath = "//*[@id=\"amt8\"]/li")
	private WebElement crebitSideAmount;

	// SUCCESS
	@FindBy(xpath = "//*[@id=\"equal\"]/a")
	private WebElement btnSuccess;
	
	
	// Forma 2
	public void realizarTransacao() {		
			if (exibirLog) System.out.println();
		Actions action = new Actions(TLDriverFactory.getDriver());
		
		// Debitar 5000 de Bank
		action.dragAndDrop(elementoBank, debitSideAccount).build().perform();
			if (exibirLog) System.out.println("[OK] Elemento 'BANK movido para 'DEBIT SIDE ACCOUNT'.");
		action.dragAndDrop(elementoValue5K, debitSideAmount).build().perform();
			if (exibirLog) System.out.println("[OK] Elemento '5000' movido para 'DEBIT SIDE AMOUNT'.");
		
		// Creditar 5000 para Sales
		action.dragAndDrop(elementoSales, crebitSideAccount).build().perform();
			if (exibirLog) System.out.println("[OK] Elemento 'SALES' movido para 'CREDIT SIDE ACCOUNT'.");
		action.dragAndDrop(elementoValue5K, crebitSideAmount).build().perform();
			if (exibirLog) System.out.println("[OK] Elemento '5000' movido para 'CREDIT SIDE AMOUNT'.");
		
		// Validar Transação
		aguardarElementoVisivel(btnSuccess);
		validarTransacao(btnSuccess, "Perfect!");			
		
		// Salvar Comprovante
		Utils.takeScreenshot("Desafios", "Guru Desafio 2");
			if (exibirLog) System.out.println("[OK] Evidência salva com sucesso.");
			if (exibirLog) System.out.println("[OK] Concluído em " + Utils.getDataHoraAtual());
	}
	
	public void validarTransacao(WebElement elemento, String textoSucesso) {
		aguardarElementoVisivel(elemento);
		Assert.assertEquals(getTextElement(elemento), textoSucesso);
			if (exibirLog) System.out.println("[OK] Texto 'Perfect!' localizado no elemento com sucesso.");
	}
	
	
//	// Forma 1
//	public void realizarTransacao2() {
//			if (exibirLog) System.out.println();
//		Actions action = new Actions(TLDriverFactory.getDriver());		
//
//		// Debitar 5000 de Bank
//		action.clickAndHold(elementoBank).build().perform();
//		action.moveToElement(debitSideAccount).release().build().perform();			
//			if (exibirLog) System.out.println("[OK] Elemento 'BANK movido para 'DEBIT SIDE ACCOUNT'.");
//		
//		action.clickAndHold(elementoValue5K).build().perform();
//		action.moveToElement(debitSideAmount).release().build().perform();
//			if (exibirLog) System.out.println("[OK] Elemento '5000' movido para 'DEBIT SIDE AMOUNT'.");
//		
//		// Creditar 5000 para Sales
//		action.clickAndHold(elementoSales).build().perform();
//		action.moveToElement(crebitSideAccount).release().build().perform();
//			if (exibirLog) System.out.println("[OK] Elemento 'SALES' movido para 'CREDIT SIDE ACCOUNT'.");
//		
//		action.clickAndHold(elementoValue5K).build().perform();
//		action.moveToElement(crebitSideAmount).release().build().perform();
//			if (exibirLog) System.out.println("[OK] Elemento '5000' movido para 'CREDIT SIDE AMOUNT'.");
//		
//		// Validar Transação
//		aguardarElementoVisivel(btnSuccess);
//		validarTransacao(btnSuccess, "Perfect!");
//			if (exibirLog) System.out.println("[OK] Texto 'Perfect!' localizado no elemento com sucesso.");
//		
//		// Salvar Comprovante
//		Utils.takeScreenshot("Desafios", "Guru Desafio 2");
//			if (exibirLog) System.out.println("[OK] Evidência salva com sucesso.");
//			if (exibirLog) System.out.println("[OK] Concluído em " + Utils.getDataHoraAtual());
//	}
	
}
