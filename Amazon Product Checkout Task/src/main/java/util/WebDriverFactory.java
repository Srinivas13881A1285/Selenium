package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
	private static WebDriver driverInstance = null;

	private WebDriverFactory() {
	}

	public static void setDriverInstance(String browserType) {
		if (driverInstance == null) {
			switch (Browser.valueOf(browserType.toUpperCase())) {

			case CHROME:
				System.setProperty("webdriver.chrome.driver", PropertyReader.getDriverPath("webdriver.chrome.driver"));
				driverInstance = new ChromeDriver();
				break;
			case FIREFOX:
				System.setProperty("webdriver.gecko.driver", PropertyReader.getDriverPath("webdriver.gecko.driver"));
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				driverInstance = new FirefoxDriver(capabilities);
				break;

			case IEXPLORER:
				System.setProperty("webdriver.ie.driver", PropertyReader.getDriverPath("webdriver.ie.driver"));
				driverInstance = new InternetExplorerDriver();
				break;

			case EDGE:
				System.setProperty("webdriver.edge.driver", PropertyReader.getDriverPath("webdriver.edge.driver"));
				driverInstance = new EdgeDriver();
				break;

			default:
				driverInstance = null;
			}

		}

	}

	public static WebDriver getDriverInstance() {
		return driverInstance;
	}

}
