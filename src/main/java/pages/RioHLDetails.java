package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import utilities.Reporter;

public class RioHLDetails extends PageBase
{

	public RioHLDetails(WebDriver driver) 
	{
		super(driver);
	}
	
	By      price      = By.linkText("6,942 ج.م./شهر");
	
	public String ShwoCarPrice()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(price));
	    String       CarPrice     = driver.findElement(price).getText();
		Reporter.Log("Action Getting text successfully : " + "[" +CarPrice+"]");
		Reporter.Log("The monthly instalment for financing the car Will be : " + "[" +CarPrice+"]");
		return CarPrice;
	}
	
}
