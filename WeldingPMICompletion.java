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
import com.pcpl.spoolman.welding.TestSpoolman_PMIReport;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingSideBar;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingWPSDetails;

public class WeldingPMICompletion extends BaseClass{

	@Test
	public void pmiCompletion() throws Throwable{
	
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
		
		TestSpoolman_PMIReport pmi = new TestSpoolman_PMIReport(driver);
		
		webdriverutility.ClickableElement(driver,Sidebar.getPMICompletion_Sidebar());
		webdriverutility.validation(driver,Sidebar.getPMICompletion_Sidebar(),"WELDING COMPLETION");						
		Sidebar.getPMICompletion_Sidebar().click();
		Reporter.log("WELDING COMPLETION IS FUNCTIONING PROPERLY",Sidebar.getWeldingPMIReport_Sidebar().isDisplayed());
		
		webdriverutility.ClickableElement(driver,Sidebar.getWeldingPMIReport_Sidebar());
		webdriverutility.validation(driver,Sidebar.getWeldingPMIReport_Sidebar(),"WELDING COMPLETION");						
		Sidebar.getWeldingPMIReport_Sidebar().click();
		Reporter.log("WELDING COMPLETION IS FUNCTIONING PROPERLY",true);
	
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
	
		Thread.sleep(500);
		
		webdriverutility.validation(driver,pmi.getReportNo_DDINPUT(),"REPORT NOT DD INPUT");
		pmi.getReportNo_DDINPUT().sendKeys("RP_01");
		Reporter.log("REPORT NO DD INPUT IS FUNCTIONING PROPERLY",true);
				
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,pmi.getReport_DDAdd());
		webdriverutility.validation(driver,pmi.getReport_DDAdd(),"REPORT NO ADD");						
		pmi.getReport_DDAdd().click();
		Reporter.log("REPORT DD ADD IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		pmi.getReportNo_DDINPUT().sendKeys(Keys.ENTER);
		
		webdriverutility.ClickableElement(driver,pmi.getPMIEquipmentNo_DD());
		webdriverutility.validation(driver,pmi.getPMIEquipmentNo_DD(),"REPORT NO ADD");						
		pmi.getPMIEquipmentNo_DD().click();
		Reporter.log("REPORT DD ADD IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		
		webdriverutility.validation(driver,pmi.getPMIEquipmentNo_DDINPUT(),"REPORT NO ADD");						
		pmi.getPMIEquipmentNo_DDINPUT().sendKeys("PMI_04");
		Reporter.log("PMI EQUIPMENT DD INPUT IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,pmi.getPMIEquipmentNoDD_ADD());
		webdriverutility.validation(driver,pmi.getPMIEquipmentNoDD_ADD(),"REPORT NO ADD");						
		pmi.getPMIEquipmentNoDD_ADD().click();
		Reporter.log("PMI EQUIPMENT ADD IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,pmi.getPMIEquipmentMake_TXT());
		webdriverutility.textConfirmation(driver,pmi.getPMIEquipmentMake_TXT(),"HGH@123", "PMI EQUIPMENT MAKE");
		Reporter.log("PMI EQUIPMENT MAKE IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,pmi.getSerialNo_TXT());
		webdriverutility.textConfirmation(driver,pmi.getSerialNo_TXT(),"HGH@123", "SERIAL NO");
		Reporter.log("SERIAL NO. IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,pmi.getITRNo_TXT());
		webdriverutility.textConfirmation(driver,pmi.getITRNo_TXT(),"HGH@123", "ITR NO");
		Reporter.log("ITR NO. IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,pmi.getPCWBSNo_TXT());
		webdriverutility.textConfirmation(driver,pmi.getPCWBSNo_TXT(),"HGH@123", "PCWBS NO");
		Reporter.log("PCWBSNo TXT IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,pmi.getTag_IdDescription_TXT());
		webdriverutility.textConfirmation(driver,pmi.getTag_IdDescription_TXT(),"HGH@123", "TAG ID DESCRIPTION");
		
		webdriverutility.ClickableElement(driver,pmi.getReferenceStd_TXT());
		webdriverutility.textConfirmation(driver,pmi.getReferenceStd_TXT(),"HGH@123", "REFERANCE ID");
		
		webdriverutility.ClickableElement(driver,pmi.getNDECompany_TXT());
		webdriverutility.textConfirmation(driver,pmi.getNDECompany_TXT(),"HGH@123", "NDE COMPANY");
	
		webdriverutility.ClickableElement(driver,pmi.getApplicableSpecification_TXT());
		webdriverutility.textConfirmation(driver,pmi.getApplicableSpecification_TXT(),"HGH@123", "APPLICATION SPECIFICATION");

		webdriverutility.ClickableElement(driver,pmi.getSpecificationRanges_TXT());
		webdriverutility.textConfirmation(driver,pmi.getSpecificationRanges_TXT(),"HGH@123", "SPECIFICATION RANGES");
		
		webdriverutility.ClickableElement(driver,pmi.getPMIPercentage_TXT());
		webdriverutility.textConfirmation(driver,pmi.getPMIPercentage_TXT(),"HGH@123", "PMI PERCENTAGE");

		webdriverutility.ClickableElement(driver,pmi.getMasterDetailsSave_BTN());
		webdriverutility.validation(driver,pmi.getMasterDetailsSave_BTN(),"MASTER DETAIL SAVE BTN ");						
		pmi.getMasterDetailsSave_BTN().click();
		Reporter.log("MASTER DETAIL SAVE IS FUNCTIONING PROPERLY",true);
	
//		webdriverutility.ClickableElement(driver,pmi.getCreationSave_BTN());
//		webdriverutility.validation(driver,pmi.getCreationSave_BTN(),"MASTER DETAIL SAVE BTN ");						
//		pmi.getCreationSave_BTN().click();
//		Reporter.log("CREATION SAVE BTN IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,pmi.getSelectionTotalRecords());
		Reporter.log("TOTAL NO OF SELECTED RECORDS "+pmi.getSelectionTotalRecords().getText(),true);
		
		webdriverutility.ClickableElement(driver,pmi.getCreactionTotalRecords());
		Reporter.log("TOTAL NO OF CREATION RECORDS "+pmi.getCreactionTotalRecords().getText(),true);
	
		Reporter.log("ALL GOOD",true);
		
	}
	
}
