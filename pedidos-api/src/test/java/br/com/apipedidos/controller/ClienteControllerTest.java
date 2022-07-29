package br.com.apipedidos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
class ClienteControllerTest {
    private static final String URL_CLIENTE = "http://localhost:8080/cliente";
    private WebDriver browser;

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "driverSeleniumChrome/chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach(){
        this.browser = new ChromeDriver();
        browser.navigate().to(URL_CLIENTE);

    }

    @AfterEach
    public void afterEach(){
        this.browser.quit();
    }
    
	@Test
	void deveriaAbriroNavegadorEAcessaroLinkCliente() {
        browser.navigate().to(URL_CLIENTE);
	}

}
