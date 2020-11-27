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

public class HomePage extends PageBase
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	By CarBrand       =By.id("ncmakes");
	By CarModel       =By.id("ncmodels");
	By Search         =By.id("btnnewsearch");
	By LogIn          =By.linkText("تسجيل الدخول");
	By LogByAccount   =By.linkText("سجل من خلال كونتكت");
	By AddAd          =By.linkText("اضف اعلانك");
	By CarAd          =By.linkText("اضف سيارة مستعملة");
	
	public void SelectCar()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(CarBrand));
		SelectValue(CarBrand, "10");
		wait.until(ExpectedConditions.visibilityOfElementLocated(CarModel));
		SelectValue(CarModel, "10");
		click(Search);
	}
	
	public void MoveToLogin()
	{
		MoveMouse(LogIn, LogByAccount);
	}
	
	public void MoveToAds()
	{
		click(AddAd);
		click(CarAd);
	}

}
