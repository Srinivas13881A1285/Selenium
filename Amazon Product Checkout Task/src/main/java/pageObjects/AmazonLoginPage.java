package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonLoginPage {

	private WebDriver driver;
	private By USERNAME = By.id("ap_email");
	private By CONTINUE = By.id("continue");
	private By PASSWORD = By.id("ap_password");
	private By LOGIN = By.id("signInSubmit");

	public AmazonLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	

	public void setUserName(String userName) {
		driver.findElement(USERNAME).sendKeys("srinusreenivas552@gmail.com");
	}

	public void clickOnContinue() {
		driver.findElement(CONTINUE).click();
	}

	public void setPassword(String password) {
		driver.findElement(PASSWORD).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(LOGIN).click();
	}

	public void loginIntoAmazon() {
		this.setUserName("srinusreenivas552@gmail.com");
		this.clickOnContinue();
		this.setPassword("Jaico123");
		this.clickOnLogin();
	}
}
