/**
 * AUTHOR - PUNIT MORE
 * DATE - 03 -02-2024;
 * DESC - SPOOLMAN-->SELECT PROJECT-->9DOT-->NDT/QAQC-->NDT LOT-->ASSIGN JOINTS TO LOT SCRIPT
 * UPDATED - 
 */


package spoolman.Ndt;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_Sidebar;
import com.pcpl.spoolman.production.TestSpool_FitupCompletion;
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_AssignJointsToLOT;
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_LotCreation;

public class NDT_AssignJointsToLOT extends BaseClass {

	@Test
	public void assignJointsToLOT() throws Throwable {
		
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
		
//		webdriverutility.ClickableElement(driver,sm.getMTO_Test());
//		webdriverutility.validation(driver,sm.getMTO_Test(),"PROJECT SELECTED");		
//		sm.getMTO_Test().click();
		
		webdriverutility.ClickableElement(driver,sm.getAutomation_Proj());
		webdriverutility.validation(driver,sm.getAutomation_Proj(),"PROJECT SELECTED");		
		sm.getAutomation_Proj().click();
		Reporter.log("AUTOMATION PROJECT IS FUNCTIONING PROPERLY",true);

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
	
		webdriverutility.ClickableElement(driver,sm.getNDT_QAQC_BTN());
		webdriverutility.validation(driver,sm.getNDT_QAQC_BTN(),"NDT_QAQC");				
		sm.getNDT_QAQC_BTN().click();
		Reporter.log("NDT_QAQC is FUNCTIONING PROPERLY ",sm.getNDTLot().isDisplayed());
	
		TestSpoolmanNDT_AssignJointsToLOT ndt = new TestSpoolmanNDT_AssignJointsToLOT(driver);
		
		webdriverutility.ClickableElement(driver,sm.getNDTLot());
		webdriverutility.validation(driver,sm.getNDTLot(),"NDT LOT");				
		sm.getNDTLot().click();
		Reporter.log("NDT LOT is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		TestSpoolmanNDT_Sidebar sidebar = new TestSpoolmanNDT_Sidebar(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getAssignJointstoLOT_Sidebar());
		webdriverutility.validation(driver,sidebar.getAssignJointstoLOT_Sidebar(),"ASSIGN JOINTS TO LOT SIDEBAR");				
		sidebar.getAssignJointstoLOT_Sidebar().click();
		Reporter.log("SIDEBAR LOT CREATION is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		waitplease();
		hp.getExpandSidebar().click();
		
		Reporter.log("TOTAL NO OF UNASSIGNED RECORDS "+
		ndt.getTotalUnassighnedRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF ASSIGNED RECORDS "+
				ndt.getTotalAssighnedRecords().getText(),true);
		
		
		webdriverutility.ClickableElement(driver,ndt.getContractorEdit_BTN());
		webdriverutility.validation(driver,ndt.getContractorEdit_BTN(),"CONTRACTOR EDIT");				
		ndt.getContractorEdit_BTN().click();
		Reporter.log("CONTRACT EDIT is FUNCTIONING PROPERLY ",true);
		
		Thread.sleep(10000);
		
		webdriverutility.ClickableElement(driver,ndt.getSpoolNo3Dots());
		webdriverutility.validation(driver,ndt.getSpoolNo3Dots(),"SPOOLNO 3 DOTS");				
		ndt.getSpoolNo3Dots().click();
		Reporter.log("NDT 3 DOTS is FUNCTIONING PROPERLY ",true);

//		SPOOL THAT HAS BEEN FRONT RELEASED...
//		String spool = ConstructionReleaseFS.s;
		String spool = "2800R-FW-280013-03-SP01";
				
		webdriverutility.ClickableElement(driver,ndt.getFunnelFilter());
		Thread.sleep(300);
		ndt.getFunnelFilter().click();
				
		webdriverutility.ClickableElement(driver,ndt.getFilterValue());
		Thread.sleep(300);
		ndt.getFilterValue().sendKeys(spool);
		
		webdriverutility.ClickableElement(driver,ndt.getFFFilter_BTN());
		Thread.sleep(300);
		ndt.getFFFilter_BTN().click();
		
		webdriverutility.ClickableElement(driver,ndt.getSCSelectAllRow());
		webdriverutility.validation(driver,ndt.getSCSelectAllRow(),"SELCT ALL RECORDS");				
		ndt.getSCSelectAllRow().click();
		Reporter.log("COTRACT SELECT ALL is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,ndt.getLOTAdd_BTN());
		webdriverutility.validation(driver,ndt.getLOTAdd_BTN(),"ADD/ASSIGN BTN");				
		ndt.getLOTAdd_BTN().click();
		Reporter.log("LOT ADD is FUNCTIONING PROPERLY ",true);
	
		Reporter.log("PLEASE SELECT THE LOT TO WHICH YOU WANT TO ASSIGN THE SPOOLS IS DISPLAYED",
		ndt.getPleaseSelectJointToAssign_POPUP().isDisplayed());
		
		ndt.getPleaseSelectJointToAssign_POPUPClose().click();
		
		webdriverutility.ClickableElement(driver,ndt.getLotNameId_DDTXT());
		webdriverutility.validation(driver,ndt.getLotNameId_DDTXT(),"LOT NAME DDTXT");		
		ndt.getLotNameId_DDTXT().sendKeys("LOT-02");
		Thread.sleep(500);
		ndt.getLotNameId_DDTXT().sendKeys(Keys.ENTER);
		Reporter.log("LOT NAME DDTXT is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getLOTNameEdit_BTN());
		webdriverutility.validation(driver,ndt.getLOTNameEdit_BTN(),"LOT NAME EDIT BTN");		
		Thread.sleep(500);
		ndt.getLOTNameEdit_BTN().click();
		Reporter.log("LOT NAME EDIT BTN is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getLOTAdd_BTN());
		webdriverutility.validation(driver,ndt.getLOTAdd_BTN(),"LOT ADD");				
		ndt.getLOTAdd_BTN().click();
		Reporter.log("LOT ADD is FUNCTIONING PROPERLY ",true);
		
		Reporter.log("TOTAL NO OF UNASSIGNED RECORDS "+
		ndt.getTotalUnassighnedRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF ASSIGNED RECORDS "+
				ndt.getTotalAssighnedRecords().getText(),true);
		
		webdriverutility.ClickableElement(driver,ndt.getLOTNameSave_BTN());
		webdriverutility.validation(driver,ndt.getLOTNameSave_BTN(),"LOT SAVE BTN");				
		ndt.getLOTNameSave_BTN().click();
		Reporter.log("LOT SAVE BTN is FUNCTIONING PROPERLY ",true);

		Reporter.log("DATA SAVED SUCCESSFULLY IS DISPLAYED",
				 ndt.getDataSavedSuccessfully_POPUP().isDisplayed());
		
		ndt.getDataSavedSuccessfully_POPUPClose().click();
	
		webdriverutility.ClickableElement(driver,ndt.getSCFullscreen_BTN());
		webdriverutility.validation(driver,ndt.getSCFullscreen_BTN(),"SC FULLSCREEN BTN");				
		ndt.getSCFullscreen_BTN().click();
		Reporter.log("SELECT CONTRACTOR FULLSCREEN is FUNCTIONING PROPERLY ",true);
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,ndt.getCompress_BTN());
		webdriverutility.validation(driver,ndt.getCompress_BTN(),"SC FULLSCREEN BTN");				
		ndt.getCompress_BTN().click();
		Reporter.log("COMPRESS BTN is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getLOTFullscreen_BTN());
		webdriverutility.validation(driver,ndt.getLOTFullscreen_BTN(),"SC FULLSCREEN BTN");				
		ndt.getLOTFullscreen_BTN().click();
		Reporter.log("LOT FULLSCREEN is FUNCTIONING PROPERLY ",true);
	
		Reporter.log("ALL DONE",true);
		
		
	}
	
	public void waitplease() throws Throwable {

		try {

			TestSpoolmanNDT_AssignJointsToLOT ndt = new TestSpoolmanNDT_AssignJointsToLOT(driver);

			Boolean k = ndt.getProgressModal().isDisplayed();
			System.out.println("Value " + k);
//			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//			System.out.println("Current Line: " + stackTraceElements[1].getLineNumber());
			if (k == true) {
//				((JavascriptExecutor) driver).executeScript("arguments[0].style.zIndex='9999';", overlappingElement);
				// You can also modify other CSS properties here

				Thread.sleep(4500);

			} else if (k == false) {
				System.out.println("keep going...");

			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("keep going...,Catch Wala");

		}

	}

	
	
}
