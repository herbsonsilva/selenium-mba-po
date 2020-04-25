package com.thiago.page.guru;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;

public class PageGuruHome extends CorePage<PageGuruHome>{

	public PageGuruHome() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement inputEmail;
	
	@FindBy(id = "passwd")
	private WebElement inputPassword;
	
	@FindBy(id = "SubmitLogin")
	private WebElement btnLogin;
	
	public PageGuruSuccess acessarLoginGuru(String email, String senha) {
		preencherCampo(inputEmail, email);
		preencherCampo(inputPassword, senha);
		click(btnLogin);
		return new PageGuruSuccess();		
	}
	
}
