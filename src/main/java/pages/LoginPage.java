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

import base.PageBase;
import utilities.Reporter;

public class LoginPage extends PageBase 
{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	By    Email          = By.id("Email");
	By    Password       = By.id("Password");
	By    LoginButton    = By.id("btnlogin");
	By    Bar            =By.className("top-bar");
	
	String username   =utilities.LoadProperties.userData.getProperty("username");
	String PW         =utilities.LoadProperties.userData.getProperty("PW");
	
	public void Login()
	{
		type(Email, username);
		type(Password, PW);
		click(LoginButton);
	}
	public String GettingText()    
	{
		String title = driver.findElement(Bar).getText();
		Reporter.Log("Action Getting text successfully : " + "[" +title+"]");
		return title;
		
	}

}
