package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.*;

import com.gargoylesoftware.htmlunit.svg.SvgAltGlyphItem;
import org.openqa.selenium.By;

import driver.SeleniumWebDriver;
import pages.AlibabaPage;
import utils.Excel;

public class AlibabaSteps {
	public static String defaultWindows;
	private static ArrayList<Map<String, String>> lecturaExcelH1 = new ArrayList<Map<String, String>>();

	public static void escribirEnTexto(By elemento, String texto) {
		SeleniumWebDriver.driver.findElement(elemento).sendKeys(texto);
	}

	public static void clickEnElemento(By elemento) {
		SeleniumWebDriver.driver.findElement(elemento).click();
	}

	public static String obtenerTextoDeElemento(By elemento) {

		boolean validarElemento = false;
		String textElemento = "";
		while (validarElemento == false) {
			try {
				textElemento = SeleniumWebDriver.driver.findElement(elemento).getText();
				validarElemento = true;
			} catch (Exception e) {

			}
		}
		return textElemento;

	}

	 public static void validarTextoEnPantalla(By elemento, String texto) {

		 boolean validarTexto = false;
		 if(obtenerTextoDeElemento(elemento).contains(texto)) {
			 validarTexto = true;
		 }
		 assertTrue("no son iguales", validarTexto);
	 }




	public static void cambiarmeDeVentana() {
		String defaultWindows = SeleniumWebDriver.driver.getWindowHandle();
		java.util.Set<String> lista = SeleniumWebDriver.driver.getWindowHandles();
		Iterator<String> Il = lista.iterator();
		while(Il.hasNext()) {
			String child_windows = Il.next();

			if (!defaultWindows.equals(child_windows)) {
				SeleniumWebDriver.driver.switchTo().window(child_windows);
			}

		}
	}


	public static void volverAlaVentana(){
		SeleniumWebDriver.driver.switchTo().window(defaultWindows);
	}


	public static void buscarPalabraEnAlibaba() {

		try {
			lecturaExcelH1 = Excel.readExcel("C:\\Users\\juan\\Desktop\\trabajo_automatizacion.xlsx", "Hoja1");

		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < lecturaExcelH1.size(); i++) {
			escribirEnTexto(AlibabaPage.getTxtBuscadorAlibaba(), lecturaExcelH1.get(i).get("abc"));


			System.out.println(lecturaExcelH1.get(i).get("abc"));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Robot robot = null;
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(10000);
				AlibabaPage.setBtnBuscadorAlibaba(lecturaExcelH1.get(i).get("nombres"));
				System.out.println(lecturaExcelH1.get(i).get("nombres"));
				Thread.sleep(3000);
				clickEnElemento(AlibabaPage.getBtnBuscadorAlibaba());
				Thread.sleep(4000);
				cambiarmeDeVentana();
				validarTextoEnPantalla(AlibabaPage.getLblValidacionProducto(),lecturaExcelH1.get(i).get("nombres"));
				System.out.println("mensaje de validacion");
				System.out.println(AlibabaPage.getLblValidacionProducto());

			} catch (AWTException | InterruptedException e) {
				e.printStackTrace();
			}
//			clickEnElemento(AlibabaPage.getBtnBuscadorAlibaba());
//			validarTextoEnPantalla(AlibabaPage.getLblesultadoProducto(), "Consola de videojuegos estándar y Digital para Playstation 5/ PS5, consola de videojuegos Original de 1TB, gran oferta");

		}
	}
	
}