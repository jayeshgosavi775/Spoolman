/**
 * AUTHOR - PUNIT MORE
 * DATE - 23-08-2024;
 * DESC - Use the custom annotation to mark the fields that need to be initialized dynamically.
 * UPDATED - 
 */


package com.pcpl.spoolman.production;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pcpl.genericutility.ExcelUtility;
import com.pcpl.genericutility.FindByFromExcel;

public class TestSpoolman_CuttingClearance {

	ExcelUtility excel = new ExcelUtility();
	WebDriver driver;
	
	public TestSpoolman_CuttingClearance(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	/*
	 * Annotations in Java require that the values assigned to their elements are
	 * constant expressions, which means they are determined at compile time. In
	 * your case, you're trying to read the XPath from an Excel file dynamically at
	 * runtime, which is not allowed directly within the annotation.
	 */	
	
//	public void initializeElement(WebDriver driver) throws Throwable{
//	    String xpathValue = excel.readFromGivenExcel("C:\\Users\\user\\eclipse-workspace\\PGold_Automation\\"
//	    		+ "src\\util_main\\resources\\TestPgoldResources\\PGOLD\\Pgold_SignInResources\\Pgold_HomePageResources\\"
//	    		+ "Pgold_Spoolman-Erman\\SpoolmanCuttingClearance.xlsx", "Sheet1", 0, 1);
//	    x = driver.findElement(By.xpath(xpathValue));
//	}
	
	@FindByFromExcel (filePath = "C:\\Users\\user\\eclipse-workspace\\PGold_Automation\\src\\util_main\\resources\\"
			+ "TestPgoldResources\\PGOLD\\Pgold_SignInResources\\Pgold_HomePageResources\\Pgold_Spoolman-Erman\\"
			+ "SpoolmanCuttingClearance.xlsx",sheetName = "Sheet1",row = 1,cell = 0)
	private WebElement SelectionFullscrean_BTN;
	
	@FindByFromExcel (filePath = "C:\\Users\\user\\eclipse-workspace\\PGold_Automation\\src\\util_main\\resources\\"
			+ "TestPgoldResources\\PGOLD\\Pgold_SignInResources\\Pgold_HomePageResources\\Pgold_Spoolman-Erman\\"
			+ "SpoolmanCuttingClearance.xlsx",sheetName = "Sheet1",row = 2,cell = 2)
	private WebElement EDIT_BTN;
	
	
	/**
	 * @return the excel
	 */
	public ExcelUtility getExcel() {
		return excel;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the selectionFullscrean_BTN
	 */
	public WebElement getSelectionFullscrean_BTN() {
		return SelectionFullscrean_BTN;
	}

	/**
	 * @return the eDIT_BTN
	 */
	public WebElement getEDIT_BTN() {
		return EDIT_BTN;
	}
	
}
