package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.WebDriverFactory;


public class AmazonSearchResultsPage {
	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private By PRODUCT_LINKS = By.cssSelector(".s-access-title");


	public List<WebElement> getProductLinks() {
		return driver.findElements(PRODUCT_LINKS);
	}

	public void clickOnProductLink(WebElement webElement) {
		webElement.click();
	}

	public String getProductLinkText(WebElement webElement) {
		return webElement.getText();
	}
}
