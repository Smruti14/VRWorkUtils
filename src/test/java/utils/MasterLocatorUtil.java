package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MasterLocatorUtil {

	private WebDriver driver;

	public MasterLocatorUtil(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doClick(By locator) {
		getElement(locator).click();

	}
	

}
