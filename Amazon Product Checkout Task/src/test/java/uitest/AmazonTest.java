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
import util.Constants;
import util.ExcelReader;
import util.WebDriverFactory;

public class AmazonTest {
	private WebDriver driver = null;
	private List<WebElement> productLinks = null;
	private List<String> numberOfOpenedTabs = null;
	private AmazonHomePage amazonHomePage = null;
	private AmazonSearchResultsPage amazonSearchResultsPage = null;
	private AmazonProductPage amazonProductPage = null;
	private AmazonCartPage amazonCartPage = null;
	private AmazonLoginPage amazonLoginPage = null;
	private AmazonDeliveryAddress amazonDeliveryAddress = null;
	private AmazonDeliveryOptions amazonDeliveryOptions = null;
	private AmazonPayment amazonPayment = null;
	private ExcelReader excelReader = null;
	private String browserName = null;
	private String productName = null;
	private int randomNumber = 0;

	@BeforeTest
	public void setup() {
		excelReader = new ExcelReader();
		browserName = excelReader.getBrowserName();
		WebDriverFactory.setDriverInstance(browserName);
		driver = WebDriverFactory.getDriverInstance();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		productName = Constants.PRODUCT_NAME;
		amazonCartPage = new AmazonCartPage();
		amazonHomePage = new AmazonHomePage();
		amazonDeliveryAddress = new AmazonDeliveryAddress();
		amazonDeliveryOptions = new AmazonDeliveryOptions();
		amazonLoginPage = new AmazonLoginPage();
		amazonPayment = new AmazonPayment();
		amazonProductPage = new AmazonProductPage();
		amazonSearchResultsPage = new AmazonSearchResultsPage();
		
	}

	@Test(priority = 1)
	public void loginIntoAmazon() {
		amazonLogin();
		assertEquals(amazonHomePage.isLogined(), true, "Login Failed");
	}

	@Test(priority = 2)
	public void searchForTheProduct() {
		searchForProduct(productName);
		assertEquals(amazonSearchResultsPage.isSearchSuccessFul(Constants.PRODUCT_NAME), true, "search failed");
	}

	@Test(priority = 3)
	public void addingToCart() {
		chooseRandomProduct();
		addToCart();
		String randomProductName = productLinks.get(randomNumber).getText();
		amazonHomePage.clikOnGlobalCart();
		assertEquals(amazonCartPage.isElementAdded(randomProductName), true);
	}

	@Test(priority = 4)
	public void deliveryAndPayment() {
		deliveryOptionsAndCheckOut();
		assertEquals(checkForErrorBox(), true);
	}

	@AfterTest
	public void afterMethod() {
		driver.quit();
	}

	private boolean checkForErrorBox() {
		return amazonPayment.checkErrorDisplay();
	}

	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(productLinks.size() - 1);
	}

	private void searchForProduct(String productName) {
		amazonHomePage.searchforProductInAmazon(productName);
		productLinks = amazonSearchResultsPage.getProductLinks();
	}

	private void chooseRandomProduct() {
		randomNumber = getRandomNumber();
		amazonSearchResultsPage.clickOnProductLink(productLinks.get(randomNumber));
	}

	private void amazonLogin() {
		amazonHomePage.getAmazonHomePage();
		amazonHomePage.clickOnSignIn();
		amazonLoginPage.loginIntoAmazon();
	}

	private void addToCart() {
		numberOfOpenedTabs = new ArrayList<String>(driver.getWindowHandles());
		if (numberOfOpenedTabs.size() > 1) {
			driver.switchTo().window(numberOfOpenedTabs.get(1));
			clickOnCartIcon();
			driver.close();
			driver.switchTo().window(numberOfOpenedTabs.get(0));
		} else {
			clickOnCartIcon();
		}

	}

	private void deliveryOptionsAndCheckOut() {
		amazonHomePage.clikOnGlobalCart();
		amazonCartPage = new AmazonCartPage();
		amazonCartPage.clickOnProceedToCheckOut();
		amazonDeliveryAddress.selectDeliveryAdddress();
		amazonDeliveryOptions.cickOnContinue();
		amazonPayment.choosePaymentOption();
	}

	private void clickOnCartIcon() {
		try {
			amazonProductPage.clickOnAddToCart();
		} catch (NoSuchElementException e) {
			System.out.println("Add Cart Button is not present");
		}
	}

}
