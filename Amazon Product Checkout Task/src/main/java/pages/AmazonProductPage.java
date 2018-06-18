package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.WebDriverFactory;
import util.WebElementWait;

public class AmazonProductPage {
	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private WebElementWait webElementWait = new WebElementWait();
	private final By productTitle = By.xpath("//span[@id='productTitle']");
	private final By addToCartButton = By.id("add-to-cart-button");
	private final By loaderIcon = By.id("loading-spinner-img");

	public String getProductName() {
		webElementWait.waitForElementVisibility(productTitle);
		return driver.findElement(productTitle).getText();
	}

	public void clickOnAddToCart() {
		driver.findElement(addToCartButton).click();
		webElementWait.waitForInvisibility(loaderIcon);	
	}
}
