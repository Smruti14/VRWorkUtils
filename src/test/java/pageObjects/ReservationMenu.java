package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReservationMenu extends BasePage{

	public ReservationMenu(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@id='mainmenua9 ']")
	WebElement link_mainReservationMenu;
	
	@FindBy(xpath="//a[@class='menu-item thisactive']")
	WebElement link_reservationGrid;
	
	public void clickReservationMenu()
	{
		link_mainReservationMenu.click();
	}
	public void clickReservationGrid()
	{
		link_reservationGrid.click();
	}

}
