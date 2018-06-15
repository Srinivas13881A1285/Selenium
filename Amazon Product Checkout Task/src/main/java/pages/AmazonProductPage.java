package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.WebDriverFactory;

public class AmazonProductPage {
	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private final By productTitle = By.xpath("//span[@id='productTitle']");
	private final By addToCartButton = By.id("add-to-cart-button");

	public String getProductName() {
		return driver.findElement(productTitle).getText();
	}

	public void clickOnAddToCart() {
		driver.findElement(addToCartButton).click();
	}
}
