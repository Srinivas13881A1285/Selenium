package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class contains amazon cart properties and actions.
 * @author Srinivas_Chintakindhi
 */
public class AmazonCartPage {
	private WebDriver driver;
	private final By proceedToCheckOut = By.name("proceedToCheckout");

	public AmazonCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public final void clickOnProceedToCheckOut() {
		driver.findElement(proceedToCheckOut).click();
	}
}
