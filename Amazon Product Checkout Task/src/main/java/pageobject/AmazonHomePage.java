package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Constants;

public class AmazonHomePage {

	private WebDriver driver;
	private final By searchBox = By.id("twotabsearchtextbox");
	private final By searchSubmit = By.xpath("//input[@value='Go']");
	private final By cartIcon = By.id("nav-cart-count");
	private final By signIn = By.id("nav-link-yourAccount");

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void getAmazonHomePage() {
		driver.get(Constants.AMAZON_WEBSITE);
	}

	public void setSearchBox(String searchFor) {
		driver.findElement(searchBox).sendKeys(searchFor);
	}

	public void clickOnSearch() {
		driver.findElement(searchSubmit).click();
	}

	public void searchforProductInAmazon(String productName) {
		this.setSearchBox(productName);
		this.clickOnSearch();
	}

	public void clikOnGlobalCart() {
		driver.findElement(cartIcon).click();
	}

	public void clickOnSignIn() {
		driver.findElement(signIn).click();
	}

}
