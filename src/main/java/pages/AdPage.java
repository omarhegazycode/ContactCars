/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    26/11/2020  - Script created.
 */
package pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;

public class AdPage extends PageBase
{

	public AdPage(WebDriver driver) 
	{
		super(driver);
	}

	By    Brand         = By.id("newadmake");
	By    EngineCC      = By.id("CC");
	By    Model         = By.id("ModelID");
	By    KiloM         = By.id("KiloMeters");
	By    PriceLE       = By.id("Price");
	By    Shape         = By.id("ShapeTypeID");
	By    Year          = By.id("MakeYear");
	By    GearBox       = By.id("GearBoxAutMan");
	By    Doors         = By.id("DoorsNum");
	By    Status        = By.id("Fabrika");
	By    About         = By.id("NotesAr");
	By    Upload        = By.id("pickfiles");
	By    Mobile        = By.id("Telephones");
	By    City          = By.id("cities_1");
	By    Area          = By.id("areas_1");
	By    Robot         = By.id("googleCaptcha");
	By    Agree         = By.id("newadagree");
	By    Save          = By.id("btnSub");


	String    EngineCapacity         =utilities.LoadProperties.userData.getProperty("EngineCapacity");
	String    Kilometers             =utilities.LoadProperties.userData.getProperty("Kilometers");
	String    ThePrice               =utilities.LoadProperties.userData.getProperty("ThePrice");
	String    ShortAbout             =utilities.LoadProperties.userData.getProperty("ShortAbout");
	String    MobileNum              =utilities.LoadProperties.userData.getProperty("MobileNum");

	String imagename1 = "picone.png";
	String imagepath1 = System.getProperty("user.dir")+"\\Uploads\\"+imagename1;
	String imagename2 = "pictwo.png";
	String imagepath2 = System.getProperty("user.dir")+"\\Uploads\\"+imagename2;

	public void MakeAd() throws  AWTException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(Brand));
		SelectValue(Brand, "23");
		SelectValue(Model, "150");
		type(EngineCC, EngineCapacity);
		type(KiloM, Kilometers);
		SelectValue(Shape, "5");
		type(PriceLE, ThePrice);
		SelectValue(Year, "2013");
		click(GearBox);
		click(Doors);
		click(Status);
		type(About, ShortAbout);
		UploadRobot(Upload, imagepath2);
		UploadRobot(Upload, imagepath1);
		type(Mobile, MobileNum);
		SelectValue(City, "1");
		click(Robot);
		SelectValue(Area, "158");
		click(Agree);
		click(Save);




	}


}
