package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericFunction {
	
	WebDriver driver;
	WebDriverWait driverWait ;
	public GenericFunction(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public void waitForElement(By by) {
		driverWait = new WebDriverWait(driver,20);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitForElement(By by, int timeout) {
		WebDriverWait driverWait = new WebDriverWait(driver,timeout);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitForTextPresentInElement(By by, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
	}
	
	public void waitForPageTitleToContain(String textToBeCOntained) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(textToBeCOntained));
	}
}
