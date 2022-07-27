package br.com.apipedidos.controller;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * @author: Jefferson César de Souza
 * 			Teste Unitário Usando Selenium
 * 
 * @version:Usar JUnit5 e import org.junit.jupiter.api
 * 			no JUnit 5 uma nova classe chamada Assertions, presente 
 * 			no pacote org.junit.jupiter.api, foi criada e recomenda-se a sua 
 * 			utilização em substituição à antiga classe Assert.
 * 
 * @exception: lança uma exception caso o link não estiver acessível.
 * 			Este teste deve ser executado com o sistema em execução
 * 
 */
class ProdutoControllerTest {

	@Test
	void deveriaAbriroNavegadorEAcessaroLinkproduto() {
        System.setProperty("webdriver.chrome.driver", "driverSeleniumChrome/chromedriver.exe");
        
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/produto");
        browser.quit();
	}

}
