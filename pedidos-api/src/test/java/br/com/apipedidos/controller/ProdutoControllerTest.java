package br.com.apipedidos.controller;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ProdutoControllerTest {
	// Teste Unitário Usando Selenium:
	// Este teste deve ser executado com o sistema em execução
	// casocontrário o link não poderá ser acessado
	@Test
	void deveriaAbriroNavegadorEAcessaroLinkproduto() {
        System.setProperty("webdriver.chrome.driver", "driverSeleniumChrome/chromedriver.exe");
        
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/produto");
        browser.quit();
	}

}
