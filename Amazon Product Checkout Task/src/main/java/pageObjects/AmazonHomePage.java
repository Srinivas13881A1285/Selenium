package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Constants;

public class AmazonHomePage {

	private WebDriver driver;

	private final By SEARCH_BOX = By.id("twotabsearchtextbox");
	private final By SEARCH_SUBMIT = By.xpath("//input[@value='Go']");
	private final By CART = By.id("nav-cart-count");
	private final By SIGN_IN = By.id("nav-link-yourAccount");

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void getAmazonHomePage() {
		driver.get(Constants.AMAZON_WEBSITE);
	}

	public void setSearchBox(String searchFor) {
		driver.findElement(SEARCH_BOX).sendKeys(searchFor);
	}

	public void clickOnSearch() {
		driver.findElement(SEARCH_SUBMIT).click();
	}

	public void searchforProductInAmazon(String productName) {
		this.setSearchBox(productName);
		this.clickOnSearch();
	}

	public void clikOnGlobalCart() {
		driver.findElement(CART).click();
	}

	public void clickOnSignIn() {
		driver.findElement(SIGN_IN).click();
	}

}
