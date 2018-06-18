package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementWait {
	
	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private WebDriverWait driverWait = new WebDriverWait(driver,20);
	
	public void waitForElementPresence(By by) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitForElementPresence(By by, int timeout) {
		WebDriverWait driverWait = new WebDriverWait(driver,timeout);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitForElementVisibility(By by) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitForElementVisibility(By by,int timeout) {
		WebDriverWait driverWait = new WebDriverWait(driver,timeout);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitForElementVisibility(WebElement webElement) {
		driverWait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	
	public void waitForElementVisibility(WebElement webElement,int timeout) {
		WebDriverWait driverWait = new WebDriverWait(driver,timeout);
		driverWait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void waitForTextPresentInElement(By by, String text) {
		driverWait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
	}
	
	public void waitForPageTitleToContain(String textToBeCOntained) {
		driverWait.until(ExpectedConditions.titleContains(textToBeCOntained));
	}
	
	public void waitUntilAttributeToBe(By by,String attributeName,String attributeValue) {
		driverWait.until(ExpectedConditions.attributeToBe(by, attributeName, attributeValue));
	}

	public void waitForInvisibility(By by) {
		driverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void waitForPresenceOfAllElements(By by) {
		driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}
}
