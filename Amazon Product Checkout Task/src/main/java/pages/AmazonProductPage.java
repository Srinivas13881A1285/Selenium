package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage {
	private WebDriver driver;
	private final By productTitle = By.xpath("//span[@id='productTitle']");
	private final By addToCartButton = By.id("add-to-cart-button");

	public AmazonProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductName() {
		return driver.findElement(productTitle).getText();
	}

	public void clickOnAddToCart() {
		driver.findElement(addToCartButton).click();
	}
}