package br.com.apipedidos.controller;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Este teste deve ser executado com o sistema em execução
// casocontrário o link não poderá ser acessado
class ClienteControllerTest {

	@Test
	void deveriaAcessaroLinkCliente() {
        System.setProperty("webdriver.chrome.driver", "driverSeleniumChrome/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/cliente");
        browser.quit();
	}

}
