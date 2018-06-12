package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.AmazonCartPage;
import pageobject.AmazonDeliveryAddress;
import pageobject.AmazonDeliveryOptions;
import pageobject.AmazonHomePage;
import pageobject.AmazonLoginPage;
import pageobject.AmazonPayment;
import pageobject.AmazonProductPage;
import pageobject.AmazonSearchResultsPage;
import util.ClearCache;
import util.ExcelReader;
import util.WebDriverFactory;


public class AmazonTest {
	private WebDriverFactory factoryPattern;
	private String browserType;
	private WebDriver driver;
	private List<WebElement> productLinks;
	private List<String> numberOfOpenedTabs;
	private AmazonHomePage amazonHomePage;
	private AmazonSearchResultsPage amazonSearchResultsPage;
	private AmazonProductPage amazonProductPage;
	private AmazonCartPage amazonCartPage;
	private AmazonLoginPage amazonLoginPage;
	private AmazonDeliveryAddress amazonDeliveryAddress;
	private AmazonDeliveryOptions amazonDeliveryOptions;
	private AmazonPayment amazonPayment;
	private ExcelReader excelReader;
	private ClearCache clearCache;
	private String productName;
	

	@BeforeTest
	public void setup()  {
		factoryPattern = new WebDriverFactory();
		excelReader = new ExcelReader();
		browserType = excelReader.getBrowserType();
		driver = factoryPattern.getBrowserDriver(browserType);
		driver.manage().window().maximize();
		clearCache = new ClearCache(driver);
		clearCache.clearBrowsingData();
	}
	

	@Test
	public void buyingItems() {
		this.amazonLogin();
		this.searchForProduct();
		this.chooseRandomProduct();
		this.addToCart();
		this.deliveryOptionsAndCheckOut();
	}

	@AfterTest
	public void afterMethod() {
		driver.quit();
	}
	
	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(productLinks.size() - 1);
	}

	
	private void searchForProduct() {
		productName = excelReader.getProductName();
		amazonHomePage.searchforProductInAmazon(productName);
		productLinks = amazonSearchResultsPage.getProductLinks();
	}


	private void chooseRandomProduct() {
		int randomNumber = this.getRandomNumber();
		amazonSearchResultsPage.clickOnProductLink(productLinks.get(randomNumber));
	}
	
	private void amazonLogin() {
		amazonHomePage = new AmazonHomePage(driver);
		amazonSearchResultsPage = new AmazonSearchResultsPage(driver);
		amazonHomePage.getAmazonHomePage();
		amazonHomePage.clickOnSignIn();
		amazonLoginPage = new AmazonLoginPage(driver);
		amazonLoginPage.loginIntoAmazon();
	}

	private void addToCart() {
		amazonProductPage = new AmazonProductPage(driver);
		numberOfOpenedTabs = new ArrayList<String>(driver.getWindowHandles());
		if (numberOfOpenedTabs.size() > 1) {
			driver.switchTo().window(numberOfOpenedTabs.get(1));
			this.clickOnCartIcon();
			driver.close();
			driver.switchTo().window(numberOfOpenedTabs.get(0));
		} else {
			this.clickOnCartIcon();
		}
		
	}
	
	private void deliveryOptionsAndCheckOut() {
		amazonHomePage.clikOnGlobalCart();
		amazonCartPage = new AmazonCartPage(driver);
		amazonCartPage.clickOnProceedToCheckOut();
		amazonDeliveryAddress = new AmazonDeliveryAddress(driver);
		amazonDeliveryAddress.selectDeliveryAdddress();
		amazonDeliveryOptions = new AmazonDeliveryOptions(driver) ;
		amazonDeliveryOptions.cickOnContinue();
		amazonPayment = new AmazonPayment(driver);
		amazonPayment.choosePaymentOption();
	}
	
	private void clickOnCartIcon() {
		try {
			amazonProductPage.clickOnAddToCart();
		} catch (NoSuchElementException e) {
			System.out.println("add cart button is not present");
		}
	}

}
