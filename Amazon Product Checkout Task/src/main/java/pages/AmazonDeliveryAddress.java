package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.SingleDriverFactory;

public class AmazonDeliveryAddress {

	private WebDriver driver = SingleDriverFactory.getDriver();
	private final By shipping_Address = By.cssSelector(".ship-to-this-address");



	public void selectDeliveryAdddress() {
		driver.findElement(shipping_Address).click();
	}

}
