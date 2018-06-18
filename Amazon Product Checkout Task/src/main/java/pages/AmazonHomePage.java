package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.ExcelReader;
import util.WebDriverFactory;
import util.WebElementWait;

public class AmazonHomePage {

	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private WebElementWait webElementWait = new WebElementWait();
	private ExcelReader excelReader;
	private final By searchBox = By.id("twotabsearchtextbox");
	private final By searchSubmit = By.xpath("//input[@value='Go']");
	private final By cartIcon = By.id("nav-cart-count");
	private final By signIn = By.id("nav-link-yourAccount");
	private final By loaderIcon = By.id("loading-spinner-img");
	private final By userName = By.cssSelector("#nav-link-yourAccount .nav-line-1");

	public void getAmazonHomePage() {
		excelReader = new ExcelReader();
		driver.get(excelReader.getAmazonUrl());
	}

	public void setSearchBox(String searchFor) {
		driver.findElement(searchBox).sendKeys(searchFor);
	}

	public void clickOnSearch() {
		driver.findElement(searchSubmit).click();
	}

	public void searchforProductInAmazon(String productName) {
		setSearchBox(productName);
		clickOnSearch();
		webElementWait.waitForInvisibility(loaderIcon);
	}

	public void clikOnGlobalCart() {
		driver.findElement(cartIcon).click();
		webElementWait.waitForInvisibility(loaderIcon);
	}

	public void clickOnSignIn() {
		driver.findElement(signIn).click();
	}

	public String getUserName() {
		return driver.findElement(userName).getText();
	}
	
	public boolean isLogined() {
		return !driver.findElement(userName).getText().equalsIgnoreCase("Hello , Sign in");
	}
}
