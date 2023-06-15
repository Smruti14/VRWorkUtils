package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import testBase.BaseClasslogin;
import utils.ElementUtils;

public class ReservationGrid extends BaseClasslogin {
	@Test
	public void validateResrvationGridWithvalidCredentials() throws InterruptedException {
//		ReservationMenu Rmenu = new ReservationMenu(driver);
//		Rmenu.clickReservationMenu();
//		Rmenu.clickReservationGrid();
		ElementUtils ele = new ElementUtils(driver);
		By reservationmenu = By.xpath("//a[@id='mainmenua9 ']");

		ele.doClick(reservationmenu);
		Thread.sleep(3000);
		ele.selectMenuclick(reservationmenu, "Reservation Grid");

		int singleDayWidth = 24;
		int nights = 3;
		String Unitname = "AM223C";

		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));
		WebElement unit = driver.findElement(By
				.xpath("//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_code,'"
						+ Unitname + "')]"));// 240,// 277
		WebElement quote = driver.findElement(By.xpath("//a[@id='quickquotemodelanchor']"));

		// Search unit
		By searchUnitname=By.xpath("//input[@name='username']");
		ele.doSendKeys(searchUnitname, Unitname);

		List<WebElement> allDates = driver.findElements(By.xpath(
				"//div[@class='day-header-holder']/table[@class='table']//tr[contains(@class,'daynumberheader')]//div"));
		// to do MAKE DATE COUNTER DYNAMIC
		int dateCounter = 0;
		for (WebElement e : allDates) {
			String Date = e.getText();
			dateCounter++;
			if (Date.equals("15")) {
				break;
			}
		}
		Actions act2 = new Actions(driver);
		act2
				// initially mouse will be at (0,0)
				.moveByOffset(recervationpoint.getRect().x + (singleDayWidth * dateCounter) + 2,
						unit.getLocation().y + 2)
				// click and hold on current location, will be res div
				.click()

				// move by days + width
				.moveByOffset(singleDayWidth * nights, 5).contextClick().click(quote).perform();
		Thread.sleep(2000);
		
		By continuebutton = By.xpath("//button[@class='btn btn-primary continue']");
		ele.doClick(continuebutton);
	
		// Guest Page
		Thread.sleep(3000);
		By selectGuestName = By.xpath("//input[@id='searchguest']");
		ele.doSendKeys(selectGuestName, "smruti parekh");
		ele.selectGuestClick(selectGuestName, "smruti parekh");
		
		By reservationbutton = By.xpath("//button[contains(@class,'continue')]");
		ele.doClick(reservationbutton);
		By closeQuickQuote=By.xpath("//button[contains(@class,'btn btn-secondary uk-modal-close closemodel')]");
		ele.doClick(closeQuickQuote);
	
	}
	
	
	
	@Test
	public void varifyWithPaymentOption() throws InterruptedException
	{
		ElementUtils ele = new ElementUtils(driver);
		By reservationmenu = By.xpath("//a[@id='mainmenua9 ']");

		ele.doClick(reservationmenu);
		Thread.sleep(3000);
		ele.selectMenuclick(reservationmenu, "Reservation Grid");

		int singleDayWidth = 24;
		int nights = 3;
		String Unitname = "AM223C";

		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));
		WebElement unit = driver.findElement(By
				.xpath("//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_code,'"
						+ Unitname + "')]"));// 240,// 277
		WebElement openReservation = driver.findElement(By.xpath("//div[@id='contextMenu']//a[@id='openreservation']"));

		// Search unit
		By searchUnitname=By.xpath("//input[@name='username']");
		ele.doSendKeys(searchUnitname, Unitname);

		List<WebElement> allDates = driver.findElements(By.xpath(
				"//div[@class='day-header-holder']/table[@class='table']//tr[contains(@class,'daynumberheader')]//div"));
		// to do MAKE DATE COUNTER DYNAMIC
				int dateCounter = 0;
				// now we will iterate all values and will capture the text. We will select when
				// date is 28

				for (WebElement element : allDates) {

					String date = element.getText();
					dateCounter++;
					// System.out.println(date); // once date is 28 then click and break
					if (date.equals("13")) {
						break;
					}
				}

				Actions act2 = new Actions(driver);

				// System.out.println(recervationpoint.getRect().x + " - " +
				// recervationpoint.getRect().y);// 455 - 220
				act2
						// initially mouse will be at (0,0)
						.moveByOffset(recervationpoint.getRect().x + (singleDayWidth * dateCounter), unit.getLocation().y)
						// click and hold on current location, will be res div
						.click()

						// move by days + width
						.moveByOffset(singleDayWidth * nights, 3).contextClick().click(openReservation).build().perform();
				// delete reservation
				
				driver.findElement(By.xpath("//a[normalize-space()='Folio']")).click();
			
				Thread.sleep(2000);
				By clickPayment= By.xpath("//a[@class='ml-2 prepaymentmodalopen']");
			
				ele.doClick(clickPayment);
				By selectpaymentOption=By.xpath("//select[contains(@class,'payment_type')]");
				ele.selectDrp(selectpaymentOption, "Cash");
				
				By clickpay=By.xpath("//input[@class='btn btn-primary paybro']");
				ele.doClick(clickpay);
	}
	@Test
	public void varifyReservationWithCancelOption() throws InterruptedException
	{
		ElementUtils ele = new ElementUtils(driver);
		By reservationmenu = By.xpath("//a[@id='mainmenua9 ']");

		ele.doClick(reservationmenu);
		Thread.sleep(3000);
		ele.selectMenuclick(reservationmenu, "Reservation Grid");

		int singleDayWidth = 24;
		int nights = 3;
		String Unitname = "AM223C";

		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));
		WebElement unit = driver.findElement(By
				.xpath("//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_code,'"
						+ Unitname + "')]"));// 240,// 277
		WebElement openReservation = driver.findElement(By.xpath("//div[@id='contextMenu']//a[@id='openreservation']"));

		// Search unit
		By searchUnitname=By.xpath("//input[@name='username']");
		ele.doSendKeys(searchUnitname, Unitname);

		List<WebElement> allDates = driver.findElements(By.xpath(
				"//div[@class='day-header-holder']/table[@class='table']//tr[contains(@class,'daynumberheader')]//div"));
		// to do MAKE DATE COUNTER DYNAMIC
				int dateCounter = 0;
				// now we will iterate all values and will capture the text. We will select when
				// date is 28

				for (WebElement element : allDates) {

					String date = element.getText();
					dateCounter++;
					// System.out.println(date); // once date is 28 then click and break
					if (date.equals("13")) {
						break;
					}
				}

				Actions act2 = new Actions(driver);

				// System.out.println(recervationpoint.getRect().x + " - " +
				// recervationpoint.getRect().y);// 455 - 220
				act2
						// initially mouse will be at (0,0)
						.moveByOffset(recervationpoint.getRect().x + (singleDayWidth * dateCounter), unit.getLocation().y)
						// click and hold on current location, will be res div
						.click()

						// move by days + width
						.moveByOffset(singleDayWidth * nights, 3).contextClick().click(openReservation).build().perform();
				// delete reservation
				By SelectButton=By.xpath("//a[contains(@class,'mb-2')]");
				ele.clickButton(SelectButton, "Cancel Reservation");
				Thread.sleep(3000);
				By cancelReservation=By.xpath("//select[@name='cancel_reason' and @class='form-control form-select']");
				ele.selectDrp(cancelReservation, "Other");
				By cancelReservationbutton=By.xpath("//a[contains(@class,'cancelres')]");
				ele.doClick(cancelReservationbutton);
	}

}
