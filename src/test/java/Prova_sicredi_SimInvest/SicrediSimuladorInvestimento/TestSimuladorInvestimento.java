package Prova_sicredi_SimInvest.SicrediSimuladorInvestimento;

import java.io.File;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestSimuladorInvestimento {
	WebDriver driver;
	WebElement element;
	Map_Simulador_Investimento Map_Simulador_Investimento;

	@Before
	public void setUp() throws Exception {
		File browser = new File("src\\main\\Resource\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", browser.getAbsolutePath());

		driver = new ChromeDriver();
		Map_Simulador_Investimento = new Map_Simulador_Investimento(driver);

		driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

		// maximizar a tela

		driver.manage().window().maximize();
		
		// Page scroll
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("scrollBy(0,550)", "");
	}

	@After
	public void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Test
	public void testdadosValidosPF() throws Exception {

		Map_Simulador_Investimento.clickradioPraVoce();
		Map_Simulador_Investimento.setValorAplicar("15000");
		Map_Simulador_Investimento.setValorInvestir("20000");
		Map_Simulador_Investimento.setTempo("20");
		Map_Simulador_Investimento.clickbtnSubmit();
		Map_Simulador_Investimento.validarResultado();

	}

	@Test
	public void testdadosValidosPJ() throws Exception {

		Map_Simulador_Investimento.clickradioPJ();
		Map_Simulador_Investimento.setValorAplicar("15000");
		Map_Simulador_Investimento.setValorInvestir("20000");
		Map_Simulador_Investimento.setTempo("20");
		Map_Simulador_Investimento.clickbtnSubmit();
		Map_Simulador_Investimento.validarResultado();

	}

	@Test
	public void testCamposObrigatorios() throws Exception {

		Map_Simulador_Investimento.clickradioPJ();
		Map_Simulador_Investimento.setValorAplicar("15000");
		Map_Simulador_Investimento.setValorInvestir("20000");
		Map_Simulador_Investimento.clickbtnSubmit();
		Map_Simulador_Investimento.validaMsgErroTempo();

	}

	@Test
	public void testMsgErroValores() throws Exception {

		Map_Simulador_Investimento.clickradioPJ();
		Map_Simulador_Investimento.setValorAplicar("150");
		Map_Simulador_Investimento.setValorInvestir("200");
		Map_Simulador_Investimento.validaMsgErroValorAplicar();
		Map_Simulador_Investimento.setTempo("20");
		Map_Simulador_Investimento.validaMsgErroValorInvestir();
		Map_Simulador_Investimento.clickbtnSubmit();

	}

	
	  @Test public void testValidarResultadoPeriodoMeses() throws Exception {
	  
	  
	  Map_Simulador_Investimento.clickradioPJ();
	  Map_Simulador_Investimento.setValorAplicar("10000");
	  Map_Simulador_Investimento.setValorInvestir("10000");
	  Map_Simulador_Investimento.setTempo("2");
	  Map_Simulador_Investimento.selecionarPeriodoMes("Meses");
	  Map_Simulador_Investimento.clickbtnSubmit();
	  Map_Simulador_Investimento.validarResultado();
	  Map_Simulador_Investimento.validarTabela();
	  
	  }
	  
	  @Test public void testValidarResultadoPeriodoAnos() throws Exception {
		  
		  
		  Map_Simulador_Investimento.clickradioPJ();
		  Map_Simulador_Investimento.setValorAplicar("10000");
		  Map_Simulador_Investimento.setValorInvestir("10000");
		  Map_Simulador_Investimento.setTempo("2");
		  Map_Simulador_Investimento.selecionarPeriodoAnos();
		  Map_Simulador_Investimento.clickbtnSubmit();
		  Map_Simulador_Investimento.validarResultado();
		  Map_Simulador_Investimento.validarTabela();
		  
		  }
	  @Test public void testValidarLimparFormulario() throws Exception {
		  
		  
		  Map_Simulador_Investimento.clickradioPJ();
		  Map_Simulador_Investimento.setValorAplicar("10000");
		  Map_Simulador_Investimento.setValorInvestir("10000");
		  Map_Simulador_Investimento.setTempo("2");
		  Map_Simulador_Investimento.selecionarPeriodoAnos();
		  Map_Simulador_Investimento.limparFormulario();
		  Map_Simulador_Investimento.validarCampoPraVcSelecionado();
		  Map_Simulador_Investimento.validarCamposVazios();
		  
		  }
	  
	  @Test public void testMsgErroValorMaximo() throws Exception {
		  
		Map_Simulador_Investimento.clickradioPJ();
		Map_Simulador_Investimento.setValorAplicar("9999999999999999999999");
		Map_Simulador_Investimento.setValorInvestir("9999999999999999999999");
		Map_Simulador_Investimento.validaMsgErroValorMaximoAplicar();
		Map_Simulador_Investimento.setTempo("20");
		Map_Simulador_Investimento.validaMsgErroValorMaximoInvestir();
		Map_Simulador_Investimento.clickbtnSubmit();
		  
		  }
	  
	  @Test public void testErroAnosMaximo() throws Exception {
	  	Map_Simulador_Investimento.clickradioPraVoce();
		Map_Simulador_Investimento.setValorAplicar("15000");
		Map_Simulador_Investimento.setValorInvestir("20000");
		Map_Simulador_Investimento.selecionarPeriodoAnos();
		Map_Simulador_Investimento.setTempo("200");
		Map_Simulador_Investimento.clickbtnSubmit();
		Map_Simulador_Investimento.validaMsgErroTempoMaximo();
		
	  }
	  
	  @Test public void testMaximoMeses() throws Exception {
	  Map_Simulador_Investimento.clickradioPJ();
	  Map_Simulador_Investimento.setValorAplicar("10000");
	  Map_Simulador_Investimento.setValorInvestir("10000");
	  Map_Simulador_Investimento.setTempo("999");
	  Map_Simulador_Investimento.selecionarPeriodoMes("Meses");
	  Map_Simulador_Investimento.clickbtnSubmit();
	  Map_Simulador_Investimento.validarResultado();
	  Map_Simulador_Investimento.validarTabela();
	  }
	  
	  @Test public void testRefazerSimulacao() throws Exception {
		  Map_Simulador_Investimento.clickradioPJ();
		  Map_Simulador_Investimento.setValorAplicar("10000");
		  Map_Simulador_Investimento.setValorInvestir("10000");
		  Map_Simulador_Investimento.setTempo("2");
		  Map_Simulador_Investimento.selecionarPeriodoMes("Meses");
		  Map_Simulador_Investimento.clickbtnSubmit();
		  Map_Simulador_Investimento.validarResultado();
		  Map_Simulador_Investimento.validarTabela();
		  Map_Simulador_Investimento.clickbtnRefazerSimulacao();
		  Map_Simulador_Investimento.validarCampoPraVcSelecionado();
		  Map_Simulador_Investimento.validarCamposVazios();
	  }
	  
	  
	}

