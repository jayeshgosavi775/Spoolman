/**
 * AUTHOR - PUNIT MORE
 * DATE - 30-01-2024;
 * DESC - PGOLD-->SPOOLMAN-->SELECT PROJECT-->WELDING--->WELDING PMI SCRIPT...
 * UPDATED - 
 */


package spoolman.Welding;

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
import com.pcpl.spoolman.welding.TestSpoolman_WCWVIReport;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingPMIOffering;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingSideBar;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingWPSDetails;

public class WeldingPMIOffering extends BaseClass {
	
	@Test
	public void pmiofferingall() throws Throwable {
		
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
		
		com.pcpl.spoolman.home.TestSpoolman_Home sm = new com.pcpl.spoolman.home.TestSpoolman_Home(driver); 
		
		webdriverutility.ClickableElement(driver,sm.getMTO_Test());
		webdriverutility.validation(driver,sm.getMTO_Test(),"PROJECT SELECTED");		
		sm.getMTO_Test().click();
		
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
		
		TestSpoolman_WeldingPMIOffering pmi = new TestSpoolman_WeldingPMIOffering(driver);
		
		webdriverutility.ClickableElement(driver,Sidebar.getWeldingPMIOffering_MainSidebar());
		webdriverutility.validation(driver,Sidebar.getWeldingPMIOffering_MainSidebar(),"WELDING PMI OFFERING");						
		Sidebar.getWeldingPMIOffering_MainSidebar().click();
		Reporter.log("PMI OFFERING MAIN IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,Sidebar.getPMIOfferingReport_Sidebar());
		webdriverutility.validation(driver,Sidebar.getPMIOfferingReport_Sidebar(),"PMI OFFERING REPORT");						
		Sidebar.getPMIOfferingReport_Sidebar().click();
		Reporter.log("PMI OFFERING REPORT IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,pmi.getSelectionWindowEdit_BTN());
		webdriverutility.validation(driver,pmi.getSelectionWindowEdit_BTN(),"SELECTION EDIT");						
		pmi.getSelectionWindowEdit_BTN().click();
		Reporter.log("SELECTION EDIT BTN IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,pmi.getSelectAllRow());
		webdriverutility.validation(driver,pmi.getSelectAllRow(),"SELECT ALL");						
		pmi.getSelectAllRow().click();
		Reporter.log("SELECT ALL IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,pmi.getCreationWindowEdit_BTN());
		webdriverutility.validation(driver,pmi.getCreationWindowEdit_BTN(),"CREATION EDIT BTN");						
		pmi.getCreationWindowEdit_BTN().click();
		Reporter.log("CREATE EDIT IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,pmi.getReportDetails_BTN());
		webdriverutility.validation(driver,pmi.getReportDetails_BTN(),"REPORT DETAILS");						
		pmi.getReportDetails_BTN().click();
		Reporter.log("REPORT DETAILS BTN IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,pmi.getAutoGenerateId_CHECKBOX());
		webdriverutility.validation(driver,pmi.getAutoGenerateId_CHECKBOX(),"AUTOGENERATED CHECKBOX");						
		pmi.getAutoGenerateId_CHECKBOX().click();
		Reporter.log("AUTO GENERATE CHECKBOX IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,pmi.getReportNo_DD());
		webdriverutility.validation(driver,pmi.getReportNo_DD(),"REPORT NO DD");						
		pmi.getReportNo_DD().click();
		Reporter.log("REPORT NO DD IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.validation(driver,pmi.getReportNo_DDINPUT(),"REPORT NOT DD INPUT");
		pmi.getReportNo_DDINPUT().sendKeys("PMI_03");
		Reporter.log("REPORT NO DD INPUT IS FUNCTIONING PROPERLY",true);
				
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,pmi.getReport_DDAdd());
		webdriverutility.validation(driver,pmi.getReport_DDAdd(),"REPORT NO ADD");						
		pmi.getReport_DDAdd().click();
		Reporter.log("REPORT DD ADD IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		pmi.getReportNo_DDINPUT().sendKeys(Keys.ENTER);
		
		webdriverutility.ClickableElement(driver,pmi.getReportStartDate());
		webdriverutility.validation(driver,pmi.getReportStartDate(),"REPORT NO DD");						
		pmi.getReportStartDate().sendKeys("14/02/2024");
		Reporter.log("REPORT START DATE IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,pmi.getPMIOfferingOK_BTN());
		webdriverutility.validation(driver,pmi.getPMIOfferingOK_BTN(),"REPORT NO DD");						
		pmi.getPMIOfferingOK_BTN().click();
		Reporter.log("REPORT OK BTN IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,pmi.getCreationSave_BTN());
		webdriverutility.validation(driver,pmi.getCreationSave_BTN(),"REPORT NO DD");						
		pmi.getCreationSave_BTN().click();
		Reporter.log("CREATION SAVE BTN IS FUNCTIONING PROPERLY",true);
		
		Reporter.log("DATA SAVE SUCCESSFULLY IS DISPLAYED",pmi.getDataSavedSuccessfully_POPUP().isDisplayed());
		
		webdriverutility.ClickableElement(driver,pmi.getDataSavedSuccessfully_POPUPClose());
		pmi.getDataSavedSuccessfully_POPUPClose().click();
		
		
		
		
		
		
		
	}

}
