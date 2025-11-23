/**
 * AUTHOR - PUNIT MORE
 * DATE - 30-01-2024;
 * DESC - PGOLD-->SPOOLMAN-->SELECT PROJECT-->WELDING--->MASTERS--->WPS-->WPS SPEC SCRIPT
 * UPDATED - 
 */


package spoolman.Welding;

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
import com.pcpl.pomrepository.TestPgold_HomePage;
import com.pcpl.pomrepository.TestPgold_SignIn;
import com.pcpl.spoolman.home.TestSpoolman_Home;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingSideBar;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingWPSDetails;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingWPSSpec;

public class MasterWPS_WPSSpec extends BaseClass {

	@Test
	public void wpsSpecAll() throws Throwable {

// 		IMPLICIT WAIT		
		webdriverutility.implicitWait(driver);
//		LOGIN PAGE
		TestPgold_SignIn signin = new TestPgold_SignIn(driver);	
//		ASSERT TO ASSURE LOGIN PAGE
		System.out.println(ExcelUtility.readStringFromExcel("Sheet1", 3, 1));
		Assert.assertTrue(ExcelUtility.readStringFromExcel("Sheet1", 3, 1).equals(driver.getCurrentUrl()),"it does not have same url");
					
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
		Reporter.log("Automation project displayed ",true);
		
		webdriverutility.ClickableElement(driver,sm.getNineDotMenu_BTN());
		webdriverutility.validation(driver,sm.getNineDotMenu_BTN(),"9 DOT MENU");		
		sm.getNineDotMenu_BTN().click();
		Reporter.log("NINEDOT MENU is FUNCTIONING PROPERLY ",sm.getProjectFr9DotMenu().isDisplayed());

		webdriverutility.ClickableElement(driver,sm.getProjectFr9DotMenu());
    	webdriverutility.validation(driver,sm.getProjectFr9DotMenu(),"PROJECT.");		
		sm.getProjectFr9DotMenu().click();
		Reporter.log("NINEDOT MENU PROJECT is FUNCTIONING PROPERLY ",sm.getProduction_BTN().isDisplayed());	
	
		webdriverutility.ClickableElement(driver,sm.getWelding_BTN());
		webdriverutility.validation(driver,sm.getWelding_BTN(),"WELDING BTN");				
		sm.getWelding_BTN().click();
		Reporter.log("WELDING BTN is FUNCTIONING PROPERLY ",sm.getWeldingMaster().isDisplayed());
		
		webdriverutility.ClickableElement(driver,sm.getWeldingMaster());
		webdriverutility.validation(driver,sm.getWeldingMaster(),"WELDING MASTER");						
		sm.getWeldingMaster().click();
		Reporter.log("WELDING MASTER is FUNCTIONING PROPERLY ",true);

		TestSpoolman_WeldingWPSDetails wps = new TestSpoolman_WeldingWPSDetails(driver);
		
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();
		
		TestSpoolman_WeldingSideBar Sidebar = new TestSpoolman_WeldingSideBar(driver);
		
		TestSpoolman_WeldingWPSSpec spec = new TestSpoolman_WeldingWPSSpec(driver);
		
		webdriverutility.ClickableElement(driver,Sidebar.getWPStoSpec_Sidebar());
		webdriverutility.validation(driver,Sidebar.getWPStoSpec_Sidebar(),"WPS TO SPEC");						
		Sidebar.getWPStoSpec_Sidebar().click();
		Reporter.log("WPS TO SPEC is FUNCTIONING PROPERLY",spec.getEdit_BTN().isDisplayed());
	
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();
		
		webdriverutility.ClickableElement(driver,spec.getSearchWPS_DD());
		webdriverutility.validation(driver,spec.getSearchWPS_DD(),"WPS DD");						
		spec.getSearchWPS_DD().click();
		Reporter.log("WPS DD is FUNCTIONING PROPERLY",spec.getWPS_01().isDisplayed());
	
		webdriverutility.ClickableElement(driver,spec.getWPS_01());
		webdriverutility.validation(driver,spec.getWPS_01(),"WPS 01");						
		spec.getWPS_01().click();
		Reporter.log("WPS DD is FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,spec.getEdit_BTN());
		webdriverutility.validation(driver,spec.getEdit_BTN(),"EDIT BTN");						
		spec.getEdit_BTN().click();
		Reporter.log("EDIT BTN is FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,spec.getADD_BTN());
		webdriverutility.validation(driver,spec.getADD_BTN(),"ADD BTN");						
		spec.getADD_BTN().click();
		Reporter.log("ADD BTN is FUNCTIONING PROPERLY",true);

		Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,spec.getModifyWPSSelectAll_CHECKBOX());
		webdriverutility.validation(driver,spec.getModifyWPSSelectAll_CHECKBOX(),"MODIFY SELECT ALL");						
		spec.getModifyWPSSelectAll_CHECKBOX().click();
		Reporter.log("SELECT ALL is FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,spec.getModifyWPSClose_BTN());
		webdriverutility.validation(driver,spec.getModifyWPSClose_BTN(),"MODIFY SELECT ALL");						
		spec.getModifyWPSClose_BTN().click();
		Reporter.log("MODIFY WPS CLOSE is FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,spec.getADD_BTN());
		spec.getADD_BTN().click();
		
		Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,spec.getModifyWPSSelectAll_CHECKBOX());
		webdriverutility.validation(driver,spec.getModifyWPSSelectAll_CHECKBOX(),"SELECT ALL");						
		spec.getModifyWPSSelectAll_CHECKBOX().click();
		Reporter.log("SELECT ALL is FUNCTIONING PROPERLY",true);
		
		for (WebElement line : spec.getModifySelectedList()) {
		    if (line.isSelected()) {
		    	System.out.println(line+"is DISPLAYED");
		    	Thread.sleep(500);
		       continue;
		    }
		}
		Reporter.log("MODIFY SELECT ALL IS SELCTING ALL",true);

				
		webdriverutility.ClickableElement(driver,spec.getModifyWPSADD_BTN());
		webdriverutility.validation(driver,spec.getModifyWPSADD_BTN(),"SELECT ALL");						
		spec.getModifyWPSADD_BTN().click();
		Reporter.log("MODIFY WPS ADD is FUNCTIONING PROPERLY",true);
		
		Reporter.log("DATA SAVED SUCCESSFULLY DISPLAYED",spec.getDataSavedSuccessfully_POPUP().isDisplayed());
		
		spec.getDataSavedSuccessfully_POPUPClose().click();;
		
//		webdriverutility.ClickableElement(driver,spec.getEdit_BTN());
//		spec.getEdit_BTN().click();
		
		webdriverutility.ClickableElement(driver,spec.getFullScreen_BTN());
		webdriverutility.validation(driver,spec.getFullScreen_BTN(),"FULLSCREEND BTN");						
		spec.getFullScreen_BTN().click();
		Reporter.log("FULLSCREEN is FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,spec.getSearchWPS_DD());
		spec.getSearchWPS_DD().click();
		Reporter.log("SEARCH WPS DD is FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,spec.getWPS_02());
		webdriverutility.validation(driver,spec.getWPS_02(),"WPS_02");						
		spec.getWPS_02().click();
		Reporter.log("WPS 02 is FUNCTIONING PROPERLY",true);
		
		Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,spec.getSearchWPS_DD());
		spec.getSearchWPS_DD().click();
		Reporter.log("SEARCH WPS DD is FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,spec.getWPS_01());
		webdriverutility.validation(driver,spec.getWPS_01(),"WPS_01");						
		spec.getWPS_01().click();
		Reporter.log("WPS 01 is FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,spec.getCompress_BTN());
		webdriverutility.validation(driver,spec.getCompress_BTN(),"COMPRESS");						
		spec.getCompress_BTN().click();
		Reporter.log("COMPRESS is FUNCTIONING PROPERLY",true);

		Thread.sleep(1000);;
		
		webdriverutility.ClickableElement(driver,spec.getSelectAllRow_CHECKBOX());
		webdriverutility.validation(driver,spec.getSelectAllRow_CHECKBOX(),"SELECT ALL");						
		spec.getSelectAllRow_CHECKBOX().click();

		for (WebElement line : spec.getSelectedSpecList()) {
		    if (line.isSelected()) {
		    	System.out.println(line+"is DISPLAYED");
		    	Thread.sleep(500);
		       continue;
		    }
		}
		Reporter.log("SELECT ALL is FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,spec.getDELETE_BTN());
		webdriverutility.validation(driver,spec.getDELETE_BTN(),"DELETE BTN");						
		spec.getDELETE_BTN().click();
		Reporter.log("DELETE is FUNCTIONING PROPERLY",spec.getDataDeletedSuccessfully_POPUP().isDisplayed());
	
		Reporter.log("DATA DELETE SUCESSFULLY DISPLAYED",spec.getDataDeletedSuccessfully_POPUP().isDisplayed());
		
		Thread.sleep(500);
		
		spec.getDataDeletedSuccessfully_POPUPClose().click();
		
		Reporter.log("ALL GOOD",true);

	}
	
}
