package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClearCache {
	WebDriver driver;
	GenericFunction genericFunction = new GenericFunction(driver);
	private By CLEAR_DATA = By.id("clearBrowsingDataConfirm");
	public ClearCache(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clickOnClearData() {
		genericFunction.waitForElement(CLEAR_DATA);
		driver.findElement(CLEAR_DATA).click();
	}
	 
	public void getSettingsPage() {
		driver.get("chrome://settings/clearBrowserData");
	}

	public void  clear_cache() {
	    this.getSettingsPage();
	    this.clickOnClearData();
	}
}