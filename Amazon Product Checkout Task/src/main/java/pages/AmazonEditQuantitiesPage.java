package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.SingleDriverFactory;

public class AmazonEditQuantitiesPage {
	private WebDriver driver = SingleDriverFactory.getDriver();
	private final By continueButton = By.cssSelector(".a-row.a-spacing-medium .sosp-continue-button .a-button-text");

	public void cickOnContinue() {
		driver.findElement(continueButton).click();
	}
	
}
