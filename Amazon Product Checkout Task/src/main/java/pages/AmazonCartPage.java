package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.WebDriverFactory;

/**
 * This class contains amazon cart properties and actions.
 * @author Srinivas_Chintakindhi
 */
public class AmazonCartPage {
	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private final By proceedToCheckOut = By.name("proceedToCheckout");
	
	public final void clickOnProceedToCheckOut() {
		driver.findElement(proceedToCheckOut).click();
	}
}
