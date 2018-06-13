package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.WebElementWait;

public class AmazonDeliveryOptions {

	private WebDriver driver;
	private WebElementWait driverWait;
	private final By continueButton = By.cssSelector(".a-row.a-spacing-medium .sosp-continue-button .a-button-text");

	public AmazonDeliveryOptions(WebDriver driver) {
		this.driver = driver;
	}

	public void cickOnContinue() {
		driverWait.waitForElement(continueButton,50);
		driver.findElement(continueButton).click();
	}
}
