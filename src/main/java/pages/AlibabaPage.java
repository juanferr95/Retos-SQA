package pages;

import org.openqa.selenium.By;

public class AlibabaPage {
	public static By getLblValidacionProducto() {
		return lblValidacionProducto;
	}

	private static By lblValidacionProducto=By.xpath("//h1[contains(@class,'module-pdp-title')]");
	private static By txtBuscadorAlibaba = By.xpath("//div[@class='ui-searchbar-main']//input[@class='ui-searchbar-keyword']");

	public static void setBtnBuscadorAlibaba(String productoAlibaba) {
		AlibabaPage.btnBuscadorAlibaba = By.xpath("//h4[contains(@class,'elements-title-normal__outter')]/a[contains(@title,'"+productoAlibaba+"')]");


	}

	//h4[contains(@title,'Xiaomi-auriculares Redmi AirDots 2, auriculares originales con cancelación de ruido y micrófono, auriculares inalámbricos táctiles para videojuegos')]//a
	private static By btnBuscadorAlibaba;
//	private static By lblesultadoProducto = By.xpath("//h1[@class='module-pdp-title']");
//= By.xpath("//h4[@title='Consola de videojuegos estándar y Digital para Playstation 5/ PS5, consola de videojuegos Original de 1TB, gran oferta']//a[@class='elements-title-normal']")
	//h4[@title='']//a[@class='elements-title-normal']
	public static By getTxtBuscadorAlibaba() {
		return txtBuscadorAlibaba;
	}
	
	public static By getBtnBuscadorAlibaba() {
		return btnBuscadorAlibaba;
	}
	
//	public static By getLblesultadoProducto() {
//		return lblesultadoProducto;
//	}
		
}