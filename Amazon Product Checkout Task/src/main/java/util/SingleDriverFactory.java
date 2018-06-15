package util;

import org.openqa.selenium.WebDriver;

public class SingleDriverFactory {
	private static WebDriverFactory webDriverFactory;
	private static String browserType;
	private static ExcelReader excelReader;
	private static WebDriver driver;
	
	static {
		
		excelReader = new ExcelReader();
		webDriverFactory = new WebDriverFactory();
		// reading browser name  from excel in which test case to be executed.
		// getting specified driver from factory WebDriverFactory.
		browserType = excelReader.getBrowserName();
		driver = webDriverFactory.getBrowserDriver(browserType);
	
	}
	
	
	public static WebDriver getDriver(){
		return driver;
	}
}
