package com.thiago.teste.guru.desafio1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.thiago.core.InvokedMethodListener;
import com.thiago.page.guru.PageGuruHome;

/*	 DESASFIO 1
 * - Acessar http://demo.guru99.com/test/login.html
 * - informar qualquer email e senha e clicar em 'Sign In';
 * - aguardar a nova tela carregar;
 * - validar sucesso do login. 
 */

@Listeners(InvokedMethodListener.class)
public class GuruTestDesafio1 {
	
	@Test
	public void loginSucesso() throws Exception {
		new PageGuruHome()
		.openPage(PageGuruHome.class, "http://demo.guru99.com/test/login.html")
		.acessarLoginGuru("herbsonsilvajp@gmail.com", "123")
		.validarAcessoOK();
	}
}
