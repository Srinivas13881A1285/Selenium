package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
	private WebDriver driver;
	@SuppressWarnings("deprecation")
	public WebDriver getBrowserDriver(String browserType) {
	switch(Test.valueOf(browserType.toUpperCase())) { 
		
		case CHROME 	:	System.setProperty("webdriver.chrome.driver",PropertyReader.getDriverPath("webdriver.chrome.driver")); 
							driver = new ChromeDriver();
							break;
		case FIREFOX	: 
							System.setProperty("webdriver.gecko.driver",PropertyReader.getDriverPath("webdriver.gecko.driver"));
							DesiredCapabilities capabilities = DesiredCapabilities.firefox();
							capabilities.setCapability("marionette",true);
							driver = new FirefoxDriver(capabilities);
							break;
		case IEXPLORER :  System.setProperty("webdriver.ie.driver", PropertyReader.getDriverPath("webdriver.ie.driver"));
							driver = new InternetExplorerDriver();
							break;
		case EDGE	:		System.setProperty("webdriver.edge.driver",PropertyReader.getDriverPath("webdriver.edge.driver"));
							driver = new EdgeDriver();
							break;
		default		:     	driver =  null;
				
	}
		
		return driver;
		
	}

}

