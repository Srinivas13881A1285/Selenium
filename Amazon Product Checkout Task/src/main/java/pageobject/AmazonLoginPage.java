package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Constants;

public class AmazonLoginPage {

	private WebDriver driver;
	private final By txt_UserName = By.id("ap_email");
	private final By continueButton = By.id("continue");
	private final By txt_Password = By.id("ap_password");
	private final By login = By.id("signInSubmit");

	public AmazonLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUserName(String userName) {
		driver.findElement(txt_UserName).sendKeys(userName);
	}

	public void clickOnContinue() {
		driver.findElement(continueButton).click();
	}

	public void setPassword(String password) {
		driver.findElement(txt_Password).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(login).click();
	}

	public void loginIntoAmazon() {
		this.setUserName(Constants.USERNAME);
		this.clickOnContinue();
		this.setPassword(Constants.PASSWORD);
		this.clickOnLogin();
	}
}
