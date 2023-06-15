package utils;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import customeException.FrameworkException;

public class BrowserUtil {
	static WebDriver driver;

	public WebDriver launchBrowser(String browserName) {
		System.out.println("Browser name is : " + browserName);
		if (browserName == null) {
			System.out.println("Browser can not be null");
			throw new FrameworkException("Browser can not be null");
		}

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--incognito");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cap);
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Please pass the right browser name: " + browserName);
			throw new FrameworkException("NOT VALID BROWSER");

		}
		return driver;
	}

	public void enterUrl(String url) {
		if (url.contains("https")) {
			driver.get(url);
		} else {
			throw new FrameworkException("URL should have http(s)");
		}
	}

	public void enterUrl(URL url) {
		if (String.valueOf(url).contains("http")) {
			driver.navigate().to(url);
		} else {
			throw new FrameworkException("URL should have http(s)");
		}
	}

	public String getPageTitle() {
		return driver.getTitle();

	}

	public String getPageURL() {
		return driver.getCurrentUrl();

	}
	public void quitBrowser()
	{
		driver.quit();
	}
	public void closeBrowser()
	{
		driver.close();
	}
}
