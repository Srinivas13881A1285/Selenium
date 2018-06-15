package uitest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AmazonCartPage;
import pages.AmazonDeliveryAddress;
import pages.AmazonDeliveryOptions;
import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonPayment;
import pages.AmazonProductPage;
import pages.AmazonSearchResultsPage;
import util.ClearCache;
import util.Constants;
import util.SingleDriverFactory;


public class AmazonTest {
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
	private ClearCache clearCache;
	private String productName;


	@BeforeTest
	public void setup()  {
		driver = SingleDriverFactory.getDriver();
		driver.manage().window().maximize();
		// clearing data since cookies and sessions stored during last visit to this site.
		clearCache = new ClearCache(driver);
		clearCache.clearBrowsingData();
	}
	

	@Test
	public void buyingItems() {
		amazonLogin();
		searchForProduct();
		chooseRandomProduct();
		addToCart();
		deliveryOptionsAndCheckOut();
		assertEquals(this.checkForErrorBox(), true);
	}

	private boolean checkForErrorBox() {
		return amazonPayment.checkErrorDisplay();
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
		productName = Constants.PRODUCT_NAME;
		amazonHomePage.searchforProductInAmazon(productName);
		productLinks = amazonSearchResultsPage.getProductLinks();
	}


	private void chooseRandomProduct() {
		int randomNumber = this.getRandomNumber();
		amazonSearchResultsPage.clickOnProductLink(productLinks.get(randomNumber));
	}
	
	private void amazonLogin() {
		amazonHomePage = new AmazonHomePage();
		amazonSearchResultsPage = new AmazonSearchResultsPage();
		amazonHomePage.getAmazonHomePage();
		amazonHomePage.clickOnSignIn();
		amazonLoginPage = new AmazonLoginPage();
		amazonLoginPage.loginIntoAmazon();
	}

	private void addToCart() {
		amazonProductPage = new AmazonProductPage();
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
		amazonCartPage = new AmazonCartPage();
		amazonCartPage.clickOnProceedToCheckOut();
		amazonDeliveryAddress = new AmazonDeliveryAddress();
		amazonDeliveryAddress.selectDeliveryAdddress();
		amazonDeliveryOptions = new AmazonDeliveryOptions() ;
		amazonDeliveryOptions.cickOnContinue();
		amazonPayment = new AmazonPayment();
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
