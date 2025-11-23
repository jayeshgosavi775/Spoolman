/**
 * AUTHOR - PUNIT MORE
 * DATE - 01-04-2024;
 * DESC - SPOOLMAN-->PROJECT-->9DOTS-->NDT/QAQC-->SPOOL CLEARANCE-->SPOOL CLEARANCE
 * UPDATED - 
 */


package spoolman.Ndt;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pcpl.genericutility.BaseClass;
import com.pcpl.genericutility.Captcha;
import com.pcpl.genericutility.ExcelUtility;
import com.pcpl.genericutility.FileUtility;
import com.pcpl.genericutility.ProgressBar;
import com.pcpl.pomrepository.TestPgold_HomePage;
import com.pcpl.pomrepository.TestPgold_SignIn;
import com.pcpl.spoolman.home.TestSpoolman_Home;
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_Sidebar;
import com.pcpl.spoolman.ndt.spoolclearance.TestSpoolman_SpoolClearance;

public class NDT_SCSpoolClearance extends BaseClass {
	
	@Test
	public void spoolclearance() throws Throwable{
		
// 		IMPLICIT WAIT		
		webdriverutility.implicitWait(driver);
//		LOGIN PAGE
		TestPgold_SignIn signin = new TestPgold_SignIn(driver);	
//		ASSERT TO ASSURE LOGIN PAGE
		System.out.println(ExcelUtility.readStringFromExcel("Sheet1", 3, 1));
		Assert.assertTrue(ExcelUtility.readStringFromExcel("Sheet1", 3, 1).
				equals(driver.getCurrentUrl()),"it does not have same url");
					
		signin.getUser().sendKeys(FileUtility.readCommonData("user"));
		Reporter.log("USERNAME entered with help of file utility"
				+ " USERNAME textfield working propertly",true);
		signin.getPass().sendKeys(ExcelUtility.readStringFromExcel("Sheet1", 2, 1));
		Reporter.log("PASSWORD entered with help of Excel Utility"
					+ " PASSWORD textfield working propertly",true);
//		CAPTCHA AUTOMATE
		Captcha cp = new Captcha(driver);
		cp.captcha();
			
//		HOME PAGE		
		TestPgold_HomePage hp = new TestPgold_HomePage(driver);
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
			
		Actions act = new Actions(driver);
			
		webdriverutility.ClickableElement(driver,hp.getSpoolmanErman());
		webdriverutility.validation(driver,hp.getSpoolmanErman(),"EFA_MFA ");
		hp.getSpoolmanErman().click();		
		Reporter.log("SPOOLMAN-ERMAN is displayed and true",true);
		
		TestSpoolman_Home sm = new TestSpoolman_Home(driver); 
		
		Thread.sleep(500);

		for (WebElement project : sm.getOnGoingProjectList()) {
			
			if (project.getText().equals(ExcelUtility.readFromExcelProject("Sheet1", 1, 1))) {
				project.click();
			break;
			}
			
		}
		
		Reporter.log(" PROJECT IS GETTING SELECTED ",
				sm.getNineDotMenu_BTN().isDisplayed());
		
		webdriverutility.ClickableElement(driver,sm.getNineDotMenu_BTN());
		webdriverutility.validation(driver,sm.getNineDotMenu_BTN(),"9 DOT MENU");		
		sm.getNineDotMenu_BTN().click();
		Reporter.log("NINEDOT MENU is FUNCTIONING PROPERLY ",
				sm.getProjectFr9DotMenu().isDisplayed());

		webdriverutility.ClickableElement(driver,sm.getProjectFr9DotMenu());
		webdriverutility.validation(driver,sm.getProjectFr9DotMenu(),"PROJECT.");		
		sm.getProjectFr9DotMenu().click();
		Reporter.log("NINEDOT MENU PROJECT is FUNCTIONING PROPERLY ",
				sm.getProduction_BTN().isDisplayed());	
		
//		js.executeScript("document.body.style.zoom='90%'");
		
//		js.executeScript("document.body.style.transform = \"scale(0.9)\";");
		
//		Thread.sleep(500);
//		// Zoom out on the page using keyboard shortcuts
//      act.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).perform();		
		
		   // Create a Robot object
        Robot robot = new Robot();
        
        // Zoom out by pressing Ctrl and - keys
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SUBTRACT);
		
		Thread.sleep(2500);
		
		webdriverutility.ClickableElement(driver,sm.getNDT_QAQC_BTN());
		webdriverutility.validation(driver,sm.getNDT_QAQC_BTN(),"NDT_QAQC");				
		sm.getNDT_QAQC_BTN().click();
		Reporter.log("NDT_QAQC is FUNCTIONING PROPERLY ",sm.getNDTLot().isDisplayed());
			
		webdriverutility.ClickableElement(driver,sm.getNDTSpoolClearance());
		webdriverutility.validation(driver,sm.getNDTSpoolClearance(),"NDT LOT");				
		sm.getNDTSpoolClearance().click();
		Reporter.log("SPOOL CLEARANCE is FUNCTIONING PROPERLY ",true);
		
		TestSpoolman_SpoolClearance clearance = new TestSpoolman_SpoolClearance(driver);
	
		Thread.sleep(2000);
		
		progressbar.waitplease(driver,clearance.getProgressModal());
		
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();
		
		TestSpoolmanNDT_Sidebar sidebar = new TestSpoolmanNDT_Sidebar(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getSubSpoolClearance_Sidebar());
		webdriverutility.validation(driver,sidebar.getSubSpoolClearance_Sidebar(),"spool clearance inside spool clearance");				
		sidebar.getSubSpoolClearance_Sidebar().click();
		Reporter.log("SPOOL CLEARANCE is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		webdriverutility.ClickableElement(driver,clearance.getSelectionEdit_BTN());
		webdriverutility.validation(driver,clearance.getSelectionEdit_BTN(),"spool clearance EDIT");				
		clearance.getSelectionEdit_BTN().click();
		Reporter.log("SPOOL CLEARANCE edit is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,clearance.getSave_BTN());
		webdriverutility.validation(driver,clearance.getSave_BTN(),"spool clearance SAVE");				
		clearance.getSave_BTN().click();
		Reporter.log("SPOOL CLEARANCE SAVE BTN is FUNCTIONING PROPERLY ",true);

		Reporter.log("NO RECORD TO SAVE POPUP DISPLAYED "+clearance.getNoRecordsToSave_POPUP().isDisplayed(),true);
		
		webdriverutility.ClickableElement(driver,clearance.getNoRecordsToSave_POPUPClose());
		clearance.getNoRecordsToSave_POPUPClose().click();
		
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].scrollIntoView(true);",clearance.getSpoolClearanceStatus_Col());
		
		for(WebElement spoolCheck : clearance.getSpoolClearanceCheckboxList()) 
		{
			
			if(!spoolCheck.isSelected()) 
			{
				spoolCheck.click();
			}		
			
		}
		
		webdriverutility.ClickableElement(driver,clearance.getSave_BTN());
		webdriverutility.validation(driver,clearance.getSave_BTN(),"spool clearance inside spool clearance");				
		clearance.getSave_BTN().click();
		Reporter.log("SPOOL CLEARANCE SAVE BTN is FUNCTIONING PROPERLY ",true);
	
//		Reporter.log("DATA SAVED SUCCESSFULLY POPUP DISPLAYED "+clearance.getDataSavedSuccessfully_POPUP().isDisplayed(),true);
//		
//		webdriverutility.ClickableElement(driver,clearance.getDataSavedSuccessfully_POPUPClose());
//		clearance.getDataSavedSuccessfully_POPUPClose().click();

		Reporter.log("NO RECORD TO SAVE POPUP DISPLAYED "+clearance.getNoRecordsToSave_POPUP().isDisplayed(),true);
		
		webdriverutility.ClickableElement(driver,clearance.getNoRecordsToSave_POPUPClose());
		clearance.getNoRecordsToSave_POPUPClose().click();
		
		webdriverutility.ClickableElement(driver,clearance.getSelectAllRow());
		webdriverutility.validation(driver,clearance.getSelectAllRow(),"SELECT ALL CHECKBOX");				
		clearance.getSelectAllRow().click();
		Reporter.log("SELECT ALL CHECKBOX is FUNCTIONING PROPERLY ",true);


	}

}
