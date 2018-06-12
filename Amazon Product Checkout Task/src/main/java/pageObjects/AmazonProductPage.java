package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage {
	private WebDriver driver;

	private By PRODUCT_TITLE = By.xpath("//span[@id='productTitle']");
	private By ADD_TO_CART_BUTTON = By.id("add-to-cart-button");

	public AmazonProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductName() {
		return driver.findElement(PRODUCT_TITLE).getText();
	}

	public void clickOnAddToCart() {
		driver.findElement(ADD_TO_CART_BUTTON).click();
	}
}
