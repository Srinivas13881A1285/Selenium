package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import util.WebDriverFactory;
import util.WebElementWait;

public class AmazonDeliveryOptions {

	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private WebElementWait driverWait =new WebElementWait();
	private final By continueButton = By.cssSelector(".a-row.a-spacing-medium .sosp-continue-button .a-button-text");
	private final By loaderIcon = By.id("loading-spinner-img");

	public void cickOnContinue() {
		driverWait.waitForInvisibility(loaderIcon);
		driver.findElement(continueButton).click();
	}
}
