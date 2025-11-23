/**
 * AUTHOR - PUNIT MORE
 * DATE - 01-04-2024;
 * DESC - SPOOLMAN-->PROJECT-->9DOTS-->NDT/QAQC-->SPOOL CLEARANCE-->SPOOL CLEARANCE (SPOOL NDT CLEARANCE)
 * UPDATED - 
 */


package spoolman.Ndt;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.pcpl.genericutility.BaseClass;
import com.pcpl.genericutility.Captcha;
import com.pcpl.genericutility.ExcelUtility;
import com.pcpl.genericutility.FileUtility;
import com.pcpl.pomrepository.TestPgold_HomePage;
import com.pcpl.pomrepository.TestPgold_SignIn;
import com.pcpl.spoolman.home.TestSpoolman_Home;
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_AssignJointsToLOT;
import com.pcpl.spoolman.ndt.spoolclearance.TestSpoolman_SpoolNDTClearance;

public class NDT_SCSpoolNDTClearance extends BaseClass{

	@Test
	public void spoolClearance() throws Throwable {
		
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
	
		TestSpoolmanNDT_AssignJointsToLOT ndt = new TestSpoolmanNDT_AssignJointsToLOT(driver);
		
		webdriverutility.ClickableElement(driver,sm.getNDTSpoolClearance());
		webdriverutility.validation(driver,sm.getNDTSpoolClearance(),"NDT LOT");				
		sm.getNDTSpoolClearance().click();
		Reporter.log("SPOOL CLEARANCE is FUNCTIONING PROPERLY ",true);
	
		Thread.sleep(2000);
		
//		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
//		hp.getExpandSidebar().click();
		
		TestSpoolman_SpoolNDTClearance clearance = new TestSpoolman_SpoolNDTClearance(driver);

		progressbar.waitplease(driver,clearance.getProgressModal());
		
		webdriverutility.ClickableElement(driver,clearance.getSelectionEdit_BTN());
		webdriverutility.validation(driver,clearance.getSelectionEdit_BTN(),"NDT LOT");				
		clearance.getSelectionEdit_BTN().click();
		Reporter.log("SPOOL CLEARANCE EDIT is FUNCTIONING PROPERLY ",true);

		String spool = "2000U-FW-280392-01-SP01";
		
		webdriverutility.ClickableElement(driver,clearance.getSpoolNo3Dots());
		webdriverutility.validation(driver,clearance.getSpoolNo3Dots(),"NDT LOT");				
		clearance.getSpoolNo3Dots().click();
		Reporter.log("SPOOL NO. 3 DOTS is FUNCTIONING PROPERLY ",true);

		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,clearance.getFunnelFilter());
		clearance.getFunnelFilter().click();
				
		webdriverutility.ClickableElement(driver,clearance.getFilterValue());
//		webdriverutility.textConfirmation(driver,contractor.getFilterValue(),s,"FILTER VALUE");
		clearance.getFilterValue().sendKeys(spool);
		
		webdriverutility.ClickableElement(driver,clearance.getFFFilter_BTN());
		clearance.getFFFilter_BTN().click();

		Assert.assertTrue(true,"SPOOL DID NOT GET RELEASED");

		Thread.sleep(500);
		
		js.executeScript("arguments[0].scrollIntoView(true);",clearance.getTableReportObservation());
		
		Thread.sleep(500);
		int j =1;
		String exitFlag = "0";
		for(WebElement repoObs : clearance.getReportObservationList()) {
			
			// Assuming you have retrieved the table data into a String variable named 'tableData'
			String[] actualReports = repoObs.getText().split(",");
			String[] expectedReports = {"Accepted", "Accepted", "Accepted", "Accepted","Accepted","Accepted","Accepted"};

			// Validate each report dynamically
			int minLength = Math.min(actualReports.length, expectedReports.length);
			for (int i = 0; i < minLength; i++) {
			    if (!actualReports[i].trim().equals(expectedReports[i])) {
			        // Handle validation failure
			        System.out.println("Validation failed for report at index " + i);
			        Reporter.log("for " + j + " joint ALL THE REPORTS ARE NOT GETTING ACCEPTED...",true);
			        exitFlag = "1";
			        break ;
			    }			  
			}if (exitFlag =="1")
		    	break;
			
			Reporter.log("for " + j + " joint ALL THE REPORTS ARE BEING ACCEPTED...",true);
			j++;
		}
		
		Thread.sleep(500);
		
		js.executeScript("arguments[0].scrollIntoView(true);",clearance.getTableJointNDTStatus());
		
		int k = 1;
		for(WebElement jointndt : clearance.getJointNDTStatusList()) {
		 
			if(jointndt.getText().trim().equals("Cleared"))
				Reporter.log(k+" joint is Cleared",true);
			else{
				Reporter.log(k+" joint is NotCleared",true);
			}
			k++;	
		}
		
		Thread.sleep(500);
		
		js.executeScript("arguments[0].scrollIntoView(true);",clearance.getTableSpoolNDTStatus());	
		
		int m = 1;
		for(WebElement spoolndt : clearance.getSpoolNDTStatusList()) {
		 
			if(spoolndt.getText().equals("Cleared"))
				Reporter.log(m+" joint Spool NDT status is Cleared",true);
			else{
				Reporter.log(m+" joint Spool NDT Status is NotCleared",true);
			}
			m++;	
		}
		
		Thread.sleep(500);
		
		js.executeScript("arguments[0].scrollIntoView(true);",clearance.getTableLotClearanceStatus());
		
		int n = 1;
		for(WebElement lotstatus : clearance.getLotClearanceStatusList()) {
		 
			String[] lot = {"Not Assigned","Partially Cleared","Cleared"};
			
			for(int i= 0;i<lot.length;i++) 
			{
			if(!lotstatus.getText().equals(lot[i])) {				
				}						
			}
			Reporter.log(n+" lot is "+lotstatus.getText(),true);	
			n++;	
		}
		
		webdriverutility.ClickableElement(driver,clearance.getSelectAllRow());
		webdriverutility.validation(driver,clearance.getSelectAllRow(),"SELECT ALL CHECKBOX");				
		clearance.getSelectAllRow().click();
		Reporter.log("Select All Checkbox is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,clearance.getSetNDT_BTN());
		webdriverutility.validation(driver,clearance.getSetNDT_BTN(),"SET NDT");				
		clearance.getSetNDT_BTN().click();
		Reporter.log("SET NDT BTN is FUNCTIONING PROPERLY ",true);

		Thread.sleep(2000);
		
//		webdriverutility.ClickableElement(driver,clearance.getSelectionFullscreen_BTN());
//		webdriverutility.validation(driver,clearance.getSelectionFullscreen_BTN(),"FULLSCREEN BTN");				
//		clearance.getSelectionFullscreen_BTN().click();
//		Reporter.log("FULLSCREEN BTN is FUNCTIONING PROPERLY ",true);
//
//		Thread.sleep(1000);
//		
//		webdriverutility.ClickableElement(driver,clearance.getSelectionCompress_BTN());
//		webdriverutility.validation(driver,clearance.getSelectionCompress_BTN(),"COMPRESS BTN");				
//		clearance.getSelectionCompress_BTN().click();
//		Reporter.log("compresss BTN is FUNCTIONING PROPERLY ",true);

		Thread.sleep(3000);
		
		js.executeScript("arguments[0].scrollIntoView(true);",clearance.getTableJointNDTStatus());
		
		int p = 1;
		for(WebElement jointndt : clearance.getJointNDTStatusList()) {
		 
			if(jointndt.getText().trim().equals("Cleared")) {
				Reporter.log(p+" joint is Cleared",true);
				}
			else{
				Reporter.log(p+" joint is NotCleared",true);
			}
			p++;	
		}
		
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].scrollIntoView(true);",clearance.getTableSpoolNDTStatus());	
		
		int q = 1;
		for(WebElement spoolndt : clearance.getSpoolNDTStatusList()) {
		 
			if(spoolndt.getText().trim().equals("Cleared")) {
				Reporter.log(q+" joint Spool NDT status is Cleared",true);
				}
			else{
				Reporter.log(q+" joint Spool NDT Status is NotCleared",true);
			}
			q++;	
		}
		
		Thread.sleep(500);

		Reporter.log("TOTAL NO. OF RECORDS "+ clearance.getTotalNoOfRecords().getText(),true);

//		webdriverutility.ClickableElement(driver,clearance.getSave_BTN());
//		webdriverutility.validation(driver,clearance.getSave_BTN(),"SAVE BTN");				
//		clearance.getSave_BTN().click();
//		Reporter.log("SAVE BTN is FUNCTIONING PROPERLY ",true);

		
		
		
	}
	
}
