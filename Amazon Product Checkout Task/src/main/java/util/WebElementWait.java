package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementWait {
	
	private WebDriver driver;
	private WebDriverWait driverWait = new WebDriverWait(driver,20);
	
	public WebElementWait(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForElement(By by) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitForElement(By by, int timeout) {
		WebDriverWait driverWait = new WebDriverWait(driver,timeout);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitForTextPresentInElement(By by, String text) {
		driverWait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
	}
	
	public void waitForPageTitleToContain(String textToBeCOntained) {
		driverWait.until(ExpectedConditions.titleContains(textToBeCOntained));
	}
}
