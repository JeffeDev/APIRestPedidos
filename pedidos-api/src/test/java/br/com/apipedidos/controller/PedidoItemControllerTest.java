package br.com.apipedidos.controller;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class PedidoItemControllerTest {

	@Test
	void deveriaAbriroNavegadorEAcessaroLinkitenspedido() {
        System.setProperty("webdriver.chrome.driver", "driverSeleniumChrome/chromedriver.exe");
        
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/itenspedido");
        browser.quit();
	}

}
