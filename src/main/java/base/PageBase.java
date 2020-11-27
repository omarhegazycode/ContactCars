/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    15/11/2019  - Script created.
 */
package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Reporter;

public class PageBase 
{
	public JavascriptExecutor jse;
	public Actions actions;
	public static WebDriverWait wait;
	public WebDriver driver;
	public static WebDriver jsWaitDriver;
	public static WebDriverWait jsWait;
	public static JavascriptExecutor jsExec;

	//Super constructor
	public PageBase(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void click(By element)   //Creating Click button function with reporting print
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		String text = driver.findElement(element).getText();
		driver.findElement(element).click();
		Reporter.Log("Action click successfully perfromed on " + "[" +text+"]");

	}
	
	public void type(By element,String input) //Creating function to send  text 
	{
		driver.findElement(element).sendKeys(input);
		Reporter.Log("Action type successfully perfromed with " + "[" +input+"]");
		
	}
	
	public void SelectValue(By element , String selectvalue)  //Creating function to select element from drop list
	{
		Select selectelement = new Select(driver.findElement(element));
		selectelement.selectByValue(selectvalue);
		Reporter.Log("Action type successfully perfromed with " + "[" +selectvalue+"]");
	}
	public void MoveMouse(By element1, By element2) //Creating function to move mouse to element
	{
		Actions act = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
		String text = driver.findElement(element1).getText();
		act.moveToElement(driver.findElement(element1)).perform();
		Reporter.Log("Action type successfully perfromed with " + "[" +text+"]");
		click(element2);
	}
	
	public void UploadRobot(By element, String filepath) throws AWTException
	{    //Creating function to upload files using robot class
		click(element);
		StringSelection str = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		Robot robot = new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
	    robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		
		
	}
}
