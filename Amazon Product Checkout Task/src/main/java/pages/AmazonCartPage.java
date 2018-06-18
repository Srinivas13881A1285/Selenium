package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.WebDriverFactory;
import util.WebElementWait;

/**
 * This class contains amazon cart properties and actions.
 * @author Srinivas_Chintakindhi
 */
public class AmazonCartPage {
	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private WebElementWait webElementWait = new WebElementWait();
	private final By proceedToCheckOut = By.name("proceedToCheckout");
	private final By itemsInCartPage = By.cssSelector(".a-size-medium.sc-product-title.a-text-bold");
	private final By loaderIcon = By.id("loading-spinner-img");
	
	public final void clickOnProceedToCheckOut() {
		driver.findElement(proceedToCheckOut).click();
		webElementWait.waitForInvisibility(loaderIcon);
	}
	
	public final List<WebElement> getCartItems() {
		webElementWait.waitForInvisibility(loaderIcon);
		webElementWait.waitForPresenceOfAllElements(itemsInCartPage);
		List<WebElement> cartItems = driver.findElements(itemsInCartPage);
		return cartItems;
	}
	
	public boolean isElementAdded(String randomProductName) {
		System.out.println("method called");
		List<WebElement> cartItems = getCartItems();
		boolean itemPresent = false;
		for (WebElement we : cartItems) {
			System.out.println(we.getText());
			if (we.getText().equals(randomProductName)) {
				itemPresent = true;
				break;
			}
			cartItems = getCartItems();
		}
		return itemPresent;
	}
}
