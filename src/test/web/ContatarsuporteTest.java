package test.web;// Generated by Selenium IDE

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
public class ContatarsuporteTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void contatarsuporte() throws InterruptedException {
    // DEFINIÇÃO DO TEMPO DE ESPERA PARA OS ELEMENTOS APARECEREM
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    driver.get("https://testando.eveclass.com/pt");
    // ALTERAÇÃO DE REDIMENSIONAR JANELA PARA MAXIMIZAR
    driver.manage().window().maximize();
    // AGUARDAR ATE O TEMPO DE ESPERA PARA O BOTAO COMEÇAR AGORA APARECER
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span/span/span[contains(.,'Começar Agora')]][1]")));
    driver.findElement(By.xpath("//a[span/span/span[contains(.,'Começar Agora')]][1]")).click();
    // AGUARDAR ANTES DE CLICAR EM CONTATO
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@text='Contato']")));
    driver.findElement(By.xpath("//a[@text='Contato']")).click();
    // AGUARDAR ANTES DE PREENCHER OS CAMPOS
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'nome-i-')]")));
    driver.findElement(By.xpath("//input[contains(@id,'nome-i-')]")).click();
    driver.findElement(By.xpath("//input[contains(@id,'nome-i-')]")).sendKeys("Luciano");
    driver.findElement(By.xpath("//input[contains(@id,'email-i-')]")).sendKeys("teste@teste.com");
    driver.findElement(By.xpath("//textarea[contains(@id,'mensagem-i-')]")).sendKeys("msg teste");
    // AGUARDAR BOTAO ENVIAR
    WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[span/span/span[contains(.,'Enviar')]][1]")));
    // SCROLLAR ATE O BOTAO ENVIAR [DESCER A PAGINA]
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
    driver.findElement(By.xpath("//button[span/span/span[contains(.,'Enviar')]][1]")).click();
    // AGUARDAR A MENSAGEM DE CONFIRMAÇÃO SER EXIBIDA
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(.,'O email foi enviado!') and @id='swal2-content']")));
    vars.put("resposta", driver.findElement(By.xpath("//div[contains(.,'O email foi enviado!') and @id='swal2-content']")).getText());
    assertEquals(vars.get("resposta").toString(), "O email foi enviado! Responderemos o mais breve possível.");
    // CONGELAR A TELA POR 3 SEGUNDOS PRRA ADMIRAR O TESTE COMPLETO
    Thread.sleep(3000); //VALOR EM MILISEGUNDOS
  }
}
