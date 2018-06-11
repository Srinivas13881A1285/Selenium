package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonCartPage {
	private WebDriver driver;
	private By proceddToCheckOut = By.name("proceedToCheckout");

	public AmazonCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnProceedToCheckOut() {
		driver.findElement(proceddToCheckOut).click();
	}
}
