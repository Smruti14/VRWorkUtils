package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dispatchUtil {
	private WebDriver driver;

	public dispatchUtil(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public  String[] getMonthYear(String monthYearVal)
	{
		return monthYearVal.split(" ");
	}
	public dispatchUtil selectDate(String exDay,String exMonth,String exYear)
	{
		if(exMonth.equals("FEBRUARY") && Integer.parseInt(exDay)>29)
		{
			System.out.println("Please Enter Correct date,Enter date is wrong date " +exMonth + " : " +exDay);
			return this;
		}
		if(Integer.parseInt(exDay)>31)
		{
			System.out.println("Please Enter Correct date,Enter date is wrong date " +exMonth + " : " +exDay);
			return this;
		}
		String monthYearVal=driver.findElement(By.className("ui-datepicker-title")).getText();
	
		while(!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear)))
		{
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			//driver.findElement(By.xpath("//a[@title='Prev']")).click();
			monthYearVal=driver.findElement(By.className("ui-datepicker-title")).getText();
		}
		try {
		driver.findElement(By.xpath("//a[text()='"+exDay+"']")).click();
		}
		catch(Exception e)
		{
			System.out.println("Please Enter Correct date,Enter date is wrong date " +exMonth + " : " +exDay);
		}
		return this;
	}
	public dispatchUtil selectpastDate(String exDay,String exMonth,String exYear)
	{
		if(exMonth.equals("FEBRUARY") && Integer.parseInt(exDay)>29)
		{
			System.out.println("Please Enter Correct date,Enter date is wrong date " +exMonth + " : " +exDay);
			return this;
		}
		if(Integer.parseInt(exDay)>31)
		{
			System.out.println("Please Enter Correct date,Enter date is wrong date " +exMonth + " : " +exDay);
			return this;

		}
		String monthYearVal=driver.findElement(By.className("ui-datepicker-title")).getText();
	
		while(!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear)))
		{
			//driver.findElement(By.xpath("//a[@title='Next']")).click();
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
			monthYearVal=driver.findElement(By.className("ui-datepicker-title")).getText();
		}
		try {
		driver.findElement(By.xpath("//a[text()='"+exDay+"']")).click();
		}
		catch(Exception e)
		{
			System.out.println("Please Enter Correct date,Enter date is wrong date " +exMonth + " : " +exDay);
		}
		return this;
	}
	public  dispatchUtil selectUnitName(String unitName)
	{
		By inspectionUnitName = By.xpath("//table[@class='eventstable']//tr[@class='removeable type-insp']//span[contains(text(),'"+ unitName + "')]");
		getElement(inspectionUnitName).click();
		return this;

	}
	public dispatchUtil selectActoinUnit(String actionName)
	{
		By selectActionName=By.xpath("//a[contains(text(),'"+actionName+"')  and contains(@class,'checkonaction')]");
		getElement(selectActionName).click();
		return this;

	}
	
	public dispatchUtil wait(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
}

