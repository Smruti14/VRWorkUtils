package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import customeException.FrameworkException;

public class ElementUtils {

	private WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doClick(By locator) {
		getElement(locator).click();

	}


	public void selectGuestClick(By locator, String GuestName) {
		By guestDropDown = By.xpath("//span[contains(text(),'"+GuestName+"')]/ancestor::ul[@id='ui-id-1']");
		getElement(guestDropDown).click();
	}
	

	public void selectMenuclick(By locator, String menuName) {
		By ReservationMenu = By.xpath("//a[contains(@class,'menu-item')]/span[@class='link-title'][text()='" + menuName + "']");
		getElement(ReservationMenu).click();
	}
	
	public void doSendKeys(By locator,String value)
	{
		if(value==null)
		{
			System.out.println("value can not be null while using sendKeys method");
			throw new FrameworkException("Value should not be null");
		}
		getElement(locator).sendKeys(value);
	}
	
	public void selectDrp(By locator,String value)
	{
		if(value==null)
		{
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		Select select=new Select(getElement(locator));	
		select.selectByVisibleText(value);
		
	}
	public void clickButton(By locator,String buttonName)
	{
		By clickOnButton=By.xpath("//a[contains(text(),'"+buttonName+"') and contains(@class,'mb-2')]");
		getElement(clickOnButton).click();
	}
	
	
	

	

}
