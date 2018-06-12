package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonDeliveryAddress {

	private WebDriver driver;
	private By SHIPPING_ADDRESS = By.cssSelector(".ship-to-this-address");

	public AmazonDeliveryAddress(WebDriver driver) {
		this.driver = driver;
	}


	public void selectDeliveryAdddress() {
		driver.findElement(SHIPPING_ADDRESS).click();
	}

}
