package stepDefinitions;

import cucumber.api.java.en.*;
import driver.SeleniumWebDriver;
import net.thucydides.core.annotations.Steps;
import steps.AlibabaSteps;

public class BuscadorAlibabaStepDefinitions {
	
	@Steps
	AlibabaSteps googleSteps = new AlibabaSteps();
	
	@Given("^que me encuentro en la pagina de Alibaba con la url (.*)$")
	public void queMeEncuentroEnLaPaginaDeAlibabaConLaUrlhttpsSpanishAlibabaCom(String url) {
		SeleniumWebDriver.ChromeWebDriver(url);
	}


	@When("^busco el proudcto en el buscador$")
	public void buscoElProudctoEnElBuscador() throws InterruptedException {
		AlibabaSteps.buscarPalabraEnAlibaba();
	}

	@Then("^podre ver el producto en pantalla$")
	public void podreVerElProductoEnPantalla() {
		SeleniumWebDriver.driver.quit();
	}


}