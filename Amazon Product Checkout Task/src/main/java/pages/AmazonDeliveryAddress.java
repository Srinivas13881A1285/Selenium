package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonDeliveryAddress {

	private WebDriver driver;
	private final By shipping_Address = By.cssSelector(".ship-to-this-address");

	public AmazonDeliveryAddress(WebDriver driver) {
		this.driver = driver;
	}


	public void selectDeliveryAdddress() {
		driver.findElement(shipping_Address).click();
	}

}
