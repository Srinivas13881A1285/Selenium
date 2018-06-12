package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
	private WebDriver driver;
	public WebDriver getBrowserDriver(String browserType) {
	switch(browserType) {
		
		case "chrome" 	:	System.setProperty("webdriver.chrome.driver",PropertyReader.getProperty("webdriver.chrome.driver")); 
							driver = new ChromeDriver();
							break;
		case "firefox"	: 
							System.setProperty("webdriver.gecko.driver",PropertyReader.getProperty("webdriver.gecko.driver"));
							DesiredCapabilities capabilities = DesiredCapabilities.firefox();
							capabilities.setCapability("marionette",true);
							driver = new FirefoxDriver(capabilities);
							break;
		case "iexplore" :  System.setProperty("webdriver.ie.driver", PropertyReader.getProperty("webdriver.ie.driver"));
							driver = new InternetExplorerDriver();
							break;
		case "edge"	:		System.setProperty("webdriver.edge.driver",PropertyReader.getProperty("webdriver.edge.driver"));
							driver = new EdgeDriver();
							break;
		default		:     	driver =  null;
				
	}
		
		return driver;
		
	}

}
