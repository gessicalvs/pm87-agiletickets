package br.com.caelum.agiletickets.acceptance.page;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.caelum.agiletickets.PreencheBanco;

public class ReservaTest {
	
	public static String BASE_URL = "http://localhost:8080";
	private static WebDriver browser;
	
	@Before
	public void setUp() {
		browser = new FirefoxDriver();
		PreencheBanco.main(new String[0]);
		
	}
	
	@After
	public void teardown() {
	//	browser.close();
	}
	
	@Test
	public void deveAcrescerDezPorcentoNosUltimosCincoIngressos(){
		
		browser.get(BASE_URL);
		
		browser.findElement(By.id("sessoes")).findElements(By.tagName("a")).get(5).click();
		browser.findElement(By.id("qtde")).sendKeys("95");
		browser.findElement(By.tagName("form")).submit();
		
		//Assert.assertEquals(browser.findElement(By.id("qtde")).getAttribute("value"), ("95"));
		
		browser.findElement(By.id("sessoes")).findElements(By.tagName("a")).get(5).click();
		browser.findElement(By.id("qtde")).sendKeys("1");
		browser.findElement(By.tagName("form")).submit();
		 
	
		
		Assert.assertEquals(browser.findElement(By.id("message")).getText(), ("Sessão reservada com sucesso por R$ 50,00"));
		
		
	}
	
	
	
	
	

}
