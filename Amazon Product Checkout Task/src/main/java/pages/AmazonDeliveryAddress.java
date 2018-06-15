package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.WebDriverFactory;

public class AmazonDeliveryAddress {

	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private final By shipping_Address = By.cssSelector(".ship-to-this-address");



	public void selectDeliveryAdddress() {
		driver.findElement(shipping_Address).click();
	}

}
