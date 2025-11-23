/**
 * AUTHOR - PUNIT MORE
 * DATE - 03 -02-2024;
 * DESC - SPOOLMAN-->SELECT PROJECT-->9DOT-->NDT/QAQC-->NDT LOT-->LOT CREATION SCRIPT
 * UPDATED - 
 */


package spoolman.Ndt;
import org.openqa.selenium.JavascriptExecutor;
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
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_LotCreation;

public class NDT_LotCreation extends BaseClass{

	@Test
	public void ndt_LotCreationAll() throws Throwable {
		
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
		Reporter.log("AUTOMATION PROJECT IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,sm.getNineDotMenu_BTN());
		webdriverutility.validation(driver,sm.getNineDotMenu_BTN(),"9 DOT MENU");		
		sm.getNineDotMenu_BTN().click();
		Reporter.log("NINEDOT MENU is FUNCTIONING PROPERLY ",sm.getProjectFr9DotMenu().isDisplayed());

		webdriverutility.ClickableElement(driver,sm.getProjectFr9DotMenu());
		webdriverutility.validation(driver,sm.getProjectFr9DotMenu(),"PROJECT.");		
		sm.getProjectFr9DotMenu().click();
		Reporter.log("NINEDOT MENU PROJECT is FUNCTIONING PROPERLY ",sm.getProduction_BTN().isDisplayed());	
	
		webdriverutility.ClickableElement(driver,sm.getNDT_QAQC_BTN());
		webdriverutility.validation(driver,sm.getNDT_QAQC_BTN(),"NDT_QAQC");				
		sm.getNDT_QAQC_BTN().click();
		Reporter.log("NDT_QAQC is FUNCTIONING PROPERLY ",sm.getNDTLot().isDisplayed());
	
		TestSpoolmanNDT_LotCreation ndt = new TestSpoolmanNDT_LotCreation(driver);
		
		webdriverutility.ClickableElement(driver,sm.getNDTLot());
		webdriverutility.validation(driver,sm.getNDTLot(),"NDT LOT");				
		sm.getNDTLot().click();
		Reporter.log("NDT LOT is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		TestSpoolmanNDT_Sidebar sidebar = new TestSpoolmanNDT_Sidebar(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getLOTCreation_Sidebar());
		webdriverutility.validation(driver,sidebar.getLOTCreation_Sidebar(),"SIDEBAR");				
		sidebar.getLOTCreation_Sidebar().click();
		Reporter.log("SIDEBAR LOT CREATION is FUNCTIONING PROPERLY ",ndt.getEdit_BTN().isDisplayed());
	
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		webdriverutility.ClickableElement(driver,ndt.getEdit_BTN());
		webdriverutility.validation(driver,ndt.getEdit_BTN(),"EDIT BTN");				
		ndt.getEdit_BTN().click();
		Reporter.log("EDIT BTN is FUNCTIONING PROPERLY ",ndt.getAdd_BTN().isEnabled());

		webdriverutility.ClickableElement(driver,ndt.getAdd_BTN());
		webdriverutility.validation(driver,ndt.getAdd_BTN(),"ADD BTN");				
		ndt.getAdd_BTN().click();
		Reporter.log("ADD BTN is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getSubContractor_TXT01());
		webdriverutility.validation(driver,ndt.getSubContractor_TXT01(),"SUB CONTRACTOR 01");				
		ndt.getSubContractor_TXT01().click();
		Reporter.log("SUB CONTRACTOR is FUNCTIONING PROPERLY ",true);
	 
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,ndt.getSubContractor_TXT01());
		act.click(ndt.getSubContractor_TXT01()).perform();
		
//		webdriverutility.ClickableElement(driver,ndt.getSubContractor2());
//		webdriverutility.validation(driver,ndt.getSubContractor2(),"SUB CONTRACTOR 2");				
//		ndt.getSubContractor2().click();
//		Reporter.log("SUB CONTRACTOR 2 is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,ndt.getAgency_1());
		webdriverutility.validation(driver,ndt.getAgency_1(),"AGENCY_01");				
		ndt.getAgency_1().click();
		Reporter.log("AGENCY_01 is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getLotName_TXT01());
		act.click(ndt.getLotName_TXT01()).perform();
		act.sendKeys("LOT-01").perform();
		Reporter.log("LOT NAME is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getPercentageInspection_TXT01());
		act.click(ndt.getPercentageInspection_TXT01()).perform();
		act.sendKeys("55").perform();
		Reporter.log("PERCENTAGE INSPECTION is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getShopLocation_TXT01());
		act.click(ndt.getShopLocation_TXT01()).perform();
		act.sendKeys("GHATKOPER").perform();
		Reporter.log("SHOP LOCATION is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getSave_BTN());
		webdriverutility.validation(driver,ndt.getSave_BTN(),"SAVE BTN");				
		ndt.getSave_BTN().click();
		Reporter.log("SAVE BTN is FUNCTIONING PROPERLY ",true);

		Reporter.log("SELECT AT LEAST ONE ROW DISPLAYED",ndt.getSelectRowToSave_POPUP().isDisplayed());
		
		webdriverutility.ClickableElement(driver,ndt.getSelectRowToSave_POPUPClose());
		ndt.getSelectRowToSave_POPUPClose().click();
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,ndt.getAdd_BTN());			
		ndt.getAdd_BTN().click();
		Reporter.log("ADD BTN is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getSubContractor_TXT02());			
		ndt.getSubContractor_TXT02().click();
		Reporter.log("SUB CONTRACTOR is FUNCTIONING PROPERLY ",true);
	 
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,ndt.getSubContractor_TXT02());
		act.click(ndt.getSubContractor_TXT02()).perform();
		
//		webdriverutility.ClickableElement(driver,ndt.getSubContractor2());			
//		ndt.getSubContractor2().click();
//		Reporter.log("SUB CONTRACTOR 2 is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getAgency_1());
		webdriverutility.validation(driver,ndt.getAgency_1(),"AGENCY_01");				
		ndt.getAgency_1().click();
		Reporter.log("AGENCY_01 is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getLotName_TXT02());
		act.click(ndt.getLotName_TXT02()).perform();
		act.sendKeys("LOT-02").perform();
		Reporter.log("LOT NAME is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getPercentageInspection_TXT02());
		act.click(ndt.getPercentageInspection_TXT02()).perform();
		act.sendKeys("40").perform();
		Reporter.log("PERCENTAGE INSPECTION is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getShopLocation_TXT02());
		act.click(ndt.getShopLocation_TXT02()).perform();
		act.sendKeys("LADAKH").perform();
		Reporter.log("SHOP LOCATION is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getSelectAllRow());
		webdriverutility.validation(driver,ndt.getSelectAllRow(),"SELECT ALL RECORDS");				
		ndt.getSelectAllRow().click();
		Reporter.log("SELECT ALL is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,ndt.getSave_BTN());
		webdriverutility.validation(driver,ndt.getSave_BTN(),"SAVE BTN");				
		ndt.getSave_BTN().click();
		Reporter.log("SAVE BTN is FUNCTIONING PROPERLY ",true);
		
		Reporter.log("DATA INSERTED SUCCESSFULLY DISPLAYED",ndt.getDataInsertedSuccessfully_PPOPUP().isDisplayed());
		
		webdriverutility.ClickableElement(driver,ndt.getDataInsertedSuccessfully_PPOPUP_Close());
		ndt.getDataInsertedSuccessfully_PPOPUP_Close().click();

		webdriverutility.ClickableElement(driver,ndt.getEdit_BTN());				
		ndt.getEdit_BTN().click();
		Reporter.log("EDIT BTN is FUNCTIONING PROPERLY ",ndt.getAdd_BTN().isEnabled());

		webdriverutility.ClickableElement(driver,ndt.getDelete_BTN());
		webdriverutility.validation(driver,ndt.getDelete_BTN(),"DELETE BTN");				
		ndt.getDelete_BTN().click();
		Reporter.log("DELETE BTN is FUNCTIONING PROPERLY ",true);
		
		Reporter.log("SELECT ROW TO DELETE POPUP IS DISPLAYED",ndt.getSelectRowToDelete_POPUP().isDisplayed());
		
		webdriverutility.ClickableElement(driver,ndt.getSelectRowToDelete_POPUPClose());
		ndt.getSelectRowToDelete_POPUPClose().click();
	
		webdriverutility.ClickableElement(driver,ndt.getSelect2ndRow());
		webdriverutility.validation(driver,ndt.getSelect2ndRow(),"2ND CHECKBOX");				
		ndt.getSelect2ndRow().click();
		Reporter.log("SELECT 2ND ROW is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,ndt.getDelete_BTN());	
		ndt.getDelete_BTN().click();
		Reporter.log("DELETE BTN is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver, ndt.getDeleteCLOSE_BTN());
		ndt.getDeleteCLOSE_BTN().click();
		Reporter.log("DELETE POPUP CLOSE",true);
		
//		Thread.sleep(500);
//		webdriverutility.ClickableElement(driver,ndt.getSelect2ndRow());				
//		ndt.getSelect2ndRow().click();
//		Reporter.log("SELECT 2ND ROW is FUNCTIONING PROPERLY ",true);
		
		Thread.sleep(500);	
		
		webdriverutility.ClickableElement(driver,ndt.getDelete_BTN());
		ndt.getDelete_BTN().click();
		Thread.sleep(500);
//		CHECKING IF THE NO BTN OF DELETE POPUP IS WORNKING 
		webdriverutility.ClickableElement(driver,ndt.getDeleteNO_BTN());
		ndt.getDeleteNO_BTN().click();
		Reporter.log("DELETE POPUP NO button",true);
				
//		webdriverutility.ClickableElement(driver,ndt.getDelete_BTN());
//		ndt.getDelete_BTN().click();
////		CHECKING IF THE YES BTN OF DELETE POPUP IS WORKING
//		webdriverutility.ClickableElement(driver,ndt.getDeleteYES_BTN());
//		ndt.getDeleteYES_BTN().click();
//		Reporter.log("DELETE POPUP YES button ",true);
////		DELETE DATA POPUP CHECK
//		Assert.assertTrue(ndt.getDataDeletedSuccessfully_POPUP().isDisplayed(),"delete data WARNING POPUP did not displayed");
//		
//		ndt.getDataDeletedSuccessfully_POPUPClose().click();
		
		Reporter.log("well done ",true);

		
		
	}
	
}
