package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testBase.BaseClasslogin;
import utils.dispatchUtil;

public class DispatchHousekeepingPage extends BaseClasslogin{
	
	
	@Test
	public void verifyCheckHousekeepingUnitwithvalidResrvation()
	{
	
		dispatchUtil dispatch=new dispatchUtil(driver);
		driver.findElement(By.xpath("//a[@class='datechanger btn btn-default ']")).click();
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='ui-datepicker-calendar']")));
		
		String[] actions =new String[]{"Check In","Check out"};
		
		for (String action : actions) {
			dispatch.selectDate("15","JUNE","2023").selectUnitName("AM223C").selectActoinUnit(action);	
		}		
	
	}

	
	

}
