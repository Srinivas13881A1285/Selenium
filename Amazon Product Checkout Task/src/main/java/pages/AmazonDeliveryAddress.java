package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.WebDriverFactory;
import util.WebElementWait;

public class AmazonDeliveryAddress {

	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private WebElementWait driverWait = new WebElementWait();
	private final By shipping_Address = By.cssSelector(".ship-to-this-address");
	private final By loaderIcon = By.id("loading-spinner-img");



	public void selectDeliveryAdddress() {
		driverWait.waitForInvisibility(loaderIcon);
		driver.findElement(shipping_Address).click();
	}

	
}
