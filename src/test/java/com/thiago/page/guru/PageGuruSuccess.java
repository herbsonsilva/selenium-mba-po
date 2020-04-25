package com.thiago.page.guru;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;

public class PageGuruSuccess extends CorePage<PageGuruSuccess>{
	
	public PageGuruSuccess() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "/html/body/div[2]/div/div/h3")
	private WebElement msgSucesso;
	
	public void validarAcessoOK() {
		aguardarElementoVisivel(msgSucesso);
		Assert.assertEquals(getTextElement(msgSucesso), "Successfully Logged in...");
	}
}
