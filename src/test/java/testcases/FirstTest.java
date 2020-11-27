/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    26/11/2020  - Script created.
 */
package testcases;

import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.RioHLDetails;
import pages.SearchPage;
import utilities.Reporter;

public class FirstTest extends TestBase
{
	HomePage        HomePaegObject;
	SearchPage      SearchPageObject;
	RioHLDetails    RioHLDetailsObject;
	String SiteURL =utilities.LoadProperties.userData.getProperty("SiteURL");
	
	@Test
	
	public void FirstTestCase()
	{
		openBrowser(SiteURL);
		HomePaegObject       = new HomePage(driver);
		SearchPageObject     = new SearchPage(driver);
		RioHLDetailsObject   = new RioHLDetails(driver);
		
		
		HomePaegObject.SelectCar();
		SearchPageObject.SelectCarInfo();
		RioHLDetailsObject.ShwoCarPrice();
		Reporter.Log("### First test case passed successfully ###");
	}
}

