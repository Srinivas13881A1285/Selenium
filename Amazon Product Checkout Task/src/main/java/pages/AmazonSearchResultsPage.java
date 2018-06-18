package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.WebDriverFactory;
import util.WebElementWait;


public class AmazonSearchResultsPage {
	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private WebElementWait webElementWait = new WebElementWait();
	private By productLinks = By.cssSelector(".s-access-title");
	private final By loaderIcon = By.id("loading-spinner-img");


	public List<WebElement> getProductLinks() {
		webElementWait.waitForPresenceOfAllElements(productLinks);
		return driver.findElements(productLinks);
	}

	public void clickOnProductLink(WebElement webElement) {
		webElementWait.waitForElementVisibility(webElement);
		webElement.click();
		webElementWait.waitForInvisibility(loaderIcon);
	}

	public String getProductLinkText(WebElement webElement) {
		return webElement.getText();
	}

	public boolean isSearchSuccessFul(String productName) {
		List<WebElement>products = getProductLinks();
		long count = products.stream().filter((WebElement e) -> e.getText().toLowerCase().contains(productName))
				.count();
		return count == products.size();
	}
}
