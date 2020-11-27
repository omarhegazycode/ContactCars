/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    26/11/2020  - Script created.
 */
package testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AdPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.Reporter;

public class SecondTest extends TestBase
{
	HomePage        HomePaegObject;
	LoginPage       LoginPageObject;
	AdPage          AdPageObject;
	
	
	
	String SiteURL      =utilities.LoadProperties.userData.getProperty("SiteURL");
	String name         =utilities.LoadProperties.userData.getProperty("name");
	
	
	@Test
	public void SecondTestCase() throws  AWTException
	{
		openBrowser(SiteURL);
		
		HomePaegObject       = new HomePage(driver);
		LoginPageObject      = new LoginPage(driver);
		AdPageObject         = new AdPage(driver);
		
		
		HomePaegObject.MoveToLogin();
		LoginPageObject.Login();
		String FullName = LoginPageObject.GettingText();
		Assert.assertTrue(FullName.contains(name));  //Assert that the title bar contain the Full name after login successfully
		HomePaegObject.MoveToAds();
		AdPageObject.MakeAd();
		Reporter.Log("### Second test case passed successfully ###");
		
	}

}
