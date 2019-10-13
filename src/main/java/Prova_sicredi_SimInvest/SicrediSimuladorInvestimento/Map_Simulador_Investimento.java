package Prova_sicredi_SimInvest.SicrediSimuladorInvestimento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Map_Simulador_Investimento {

	protected static WebDriver driver;
	protected WebDriverWait wait;

	public Map_Simulador_Investimento(WebDriver driver) {

		Map_Simulador_Investimento.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}

	// Mapping page

	@FindBy(how = How.XPATH, using = "//*[@id=\"formInvestimento\"]/div[1]/input[1]")
	WebElement radioPraVoce;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formInvestimento\"]/div[1]/input[2]")
	WebElement radioPJ;

	@FindBy(how = How.ID, using = "valorAplicar")
	WebElement valorAplicar;

	@FindBy(how = How.ID, using = "valorAplicar-error")
	WebElement valorAplicarErro;

	@FindBy(how = How.ID, using = "valorInvestir")
	WebElement valorInvestir;

	@FindBy(how = How.ID, using = "valorInvestir-error")
	WebElement valorInvestirErro;

	@FindBy(how = How.ID, using = "tempo")
	WebElement tempo;

	@FindBy(how = How.ID, using = "tempo-error")
	WebElement tempoErro;
		
	@FindBy(how = How.CSS, using = ".btSelect > .btn")
	WebElement selecionarPeriodos;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formInvestimento\"]/div[5]/ul/li[2]/button")
	WebElement btnSubmit;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formInvestimento\"]/div[5]/ul/li[1]/a")
	WebElement btnLimparFormulario;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[1]/div/div[2]/span[2]")
	WebElement valorResultado;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[1]/div/div[2]/a")
	WebElement btnRefazerSimulacao;
	
	

	// Methods with actions

	public void clickradioPraVoce() {

		wait.until(ExpectedConditions.elementToBeClickable(radioPraVoce)).click();
	}

	public void clickradioPJ() {

		wait.until(ExpectedConditions.elementToBeClickable(radioPJ)).click();
	}

	public void setValorAplicar(String valor) {
		wait.until(ExpectedConditions.elementToBeClickable(valorAplicar)).sendKeys(valor);
	}

	public void validaMsgErroValorAplicar() throws InterruptedException {

		Object validaMsg = wait.until(ExpectedConditions.elementToBeClickable(valorAplicarErro)).getText();
		assertEquals("Valor mínimo de 20.00", validaMsg);
	}
	
	public void validaMsgErroValorMaximoAplicar() throws InterruptedException {

		Object validaMsg = wait.until(ExpectedConditions.elementToBeClickable(valorAplicarErro)).getText();
		assertEquals("Máximo de 9999999.00", validaMsg);
	}

	public void setValorInvestir(String valor) {
		wait.until(ExpectedConditions.elementToBeClickable(valorInvestir)).sendKeys(valor);
	}

	public void validaMsgErroValorInvestir() throws InterruptedException {

		Object validaMsg = wait.until(ExpectedConditions.elementToBeClickable(valorInvestirErro)).getText();
		assertEquals("Valor mínimo de 20.00", validaMsg);
	}
	
	public void validaMsgErroValorMaximoInvestir() throws InterruptedException {

		Object validaMsg = wait.until(ExpectedConditions.elementToBeClickable(valorInvestirErro)).getText();
		assertEquals("Máximo de 9999999.00", validaMsg);
	}

	public void setTempo(String valor) {
		wait.until(ExpectedConditions.elementToBeClickable(tempo)).sendKeys(valor);
	}

	public void validaMsgErroTempo() throws InterruptedException {

		Object validaMsg = wait.until(ExpectedConditions.elementToBeClickable(tempoErro)).getText();
		assertEquals("Obrigatório", validaMsg);
	}
	
	public void validaMsgErroTempoMaximo() throws InterruptedException {

		Object validaMsg = wait.until(ExpectedConditions.elementToBeClickable(tempoErro)).getText();
		assertEquals("Valor esperado não confere", validaMsg);
	}

	public void clickbtnSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
	}

	public boolean validarResultado() {

		wait.until(ExpectedConditions.elementToBeClickable(valorResultado));
		boolean isThere = false;

		try {
			if (valorResultado.isDisplayed()) {
				isThere = true;
			}
		} catch (Exception e) {
			isThere = false;
		}
		return isThere;

	}

	public void validarTabela() {
		
		// Cria lista de objetos do tipo WebElement que recebe as células da tabela acima.
		List<WebElement> celulas = driver.findElements(By.tagName("td"));
		 
		
		for(WebElement c : celulas){
			//Validar se tabela está preenchida
			assertNotNull(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]")));
			//Imprimir o valor de cada célula.
			System.out.println(c.getText());
		
		}
	}

	public void selecionarPeriodoMes (String valor) throws InterruptedException{
		
		wait.until(ExpectedConditions.elementToBeClickable(selecionarPeriodos)).click();
		Thread.sleep(4000);
	    driver.findElement(By.linkText("Meses")).click();
	}
	
	public void selecionarPeriodoAnos() throws InterruptedException{
			
		wait.until(ExpectedConditions.elementToBeClickable(selecionarPeriodos)).click();
		Thread.sleep(4000);
	    driver.findElement(By.linkText("Anos")).click();
	    
		}

	public void limparFormulario (){
		
		wait.until(ExpectedConditions.elementToBeClickable(btnLimparFormulario)).click();
	}
	
	public void validarCampoPraVcSelecionado (){
		
		assertTrue("Radio não selecionado", driver.findElement(By.xpath("//*[@id=\"formInvestimento\"]/div[1]/input[1]")).isSelected());
	}

	public void validarCamposVazios (){
		
	Object MsgValoraplicar = wait.until(ExpectedConditions.elementToBeClickable(valorAplicar)).getText();
	assertEquals("", MsgValoraplicar);
	
	Object MsgValorInvestir = wait.until(ExpectedConditions.elementToBeClickable(valorInvestir)).getText();
	assertEquals("", MsgValorInvestir);
	
	Object MsgTempo = wait.until(ExpectedConditions.elementToBeClickable(tempo)).getText();
	assertEquals("", MsgTempo);
	
	}
	
	public void clickbtnRefazerSimulacao() {
	
		wait.until(ExpectedConditions.elementToBeClickable(btnRefazerSimulacao)).click();
	}

}
