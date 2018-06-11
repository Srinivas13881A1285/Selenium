package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearchResultsPage {
	private WebDriver driver;
	private By productLinks = By.cssSelector(".s-access-title");

	public AmazonSearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getProductLinks() {
		return driver.findElements(productLinks);
	}

	public void clickOnProductLink(WebElement webElement) {
		webElement.click();
	}

	public String getProductLinkText(WebElement webElement) {
		return webElement.getText();
	}
}
