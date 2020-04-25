package com.thiago.teste.guru.desafio2;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.thiago.core.InvokedMethodListener;
import com.thiago.page.guru.PageGuruDragAndDrop;

/*	 DESASFIO 2
 * - Acessar 'http://demo.guru99.com/test/drag_drop.html'
 * - descartar determinados blocos em células especificas na tabela
 */

@Listeners(InvokedMethodListener.class)
public class GuruTestDesafio2 {
	
	@Test
	public void dragAndDropTransaction() throws Exception {
		new PageGuruDragAndDrop()
		.openPage(PageGuruDragAndDrop.class, "http://demo.guru99.com/test/drag_drop.html")
		.realizarTransacao();
	}
}
