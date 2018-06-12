package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ClearCache {
	private WebDriver driver;
	
	public ClearCache(WebDriver driver) {
		this.driver = driver;
	}
	 
	public void getSettingsPage() {
		driver.get(Constants.CHROME_SETTINGS_PAGE);
	}
	
	public void clickOnDropDown() {
		for(int i=0;i<3;i++) {
			driver.switchTo().activeElement().sendKeys(Keys.TAB);
		}
		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
	}
	
	public void chooseTimeRangeAllTime() {
		for(int i=0;i<4;i++)
			driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
	}
	
	public void clickOnClearData() {
		for(int i=0;i<5;i++)
			driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
	}

	public void  clear_cache() {
	    this.getSettingsPage();
	    this.clickOnDropDown();
	    this.chooseTimeRangeAllTime();
	    this.clickOnClearData();
	}
}