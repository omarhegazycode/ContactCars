/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    26/11/2020  - Script created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;

public class SearchPage extends PageBase
{

	public SearchPage(WebDriver driver) 
	{
		super(driver);
	}
	
	By      Carinfo     = By.linkText("1.6 A/T H/L New Shape Sedan");
	
	public void SelectCarInfo()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(Carinfo));
		click(Carinfo);
	}

}
