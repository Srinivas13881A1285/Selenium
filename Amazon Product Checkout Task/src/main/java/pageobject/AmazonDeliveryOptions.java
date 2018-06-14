package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonDeliveryOptions {

	private WebDriver driver;
	private final By continueButton = By.cssSelector(".a-row.a-spacing-medium .sosp-continue-button .a-button-text");

	public AmazonDeliveryOptions(WebDriver driver) {
		this.driver = driver;
	}

	public void cickOnContinue() {
		driver.findElement(continueButton).click();
	}
}
