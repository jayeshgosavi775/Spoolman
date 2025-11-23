/**
 * AUTHOR - PUNIT MORE
 * DATE - 03 -02-2024;
 * DESC - SPOOLMAN-->SELECT PROJECT-->9DOT-->NDT/QAQC-->NDT LOT-->TEST OFFERING
 * -->PWHT OFFERING SCRIPT...
 * UPDATED - 
 */


package spoolman.Ndt;

import java.util.HashMap;

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
import com.pcpl.genericutility.ListUtility;
import com.pcpl.pomrepository.TestPgold_HomePage;
import com.pcpl.pomrepository.TestPgold_SignIn;
import com.pcpl.spoolman.home.TestSpoolman_Home;
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_AssignJointsToLOT;
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_Sidebar;
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_TestOfferingPWHTOffering;

public class NDT_TestOffPWHTOff extends BaseClass {

	@Test
	public void PWHTOfferingAll() throws Throwable {
		

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
		
		for (WebElement project : sm.getOnGoingProjectList()) 
		{
			
			if (project.getText().equals(ExcelUtility.readFromExcelProject("Sheet1", 1, 1))) 
			{
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
		
		webdriverutility.ClickableElement(driver,sidebar.getTestOffering_Sidebar());
		webdriverutility.validation(driver,sidebar.getTestOffering_Sidebar(),
				"TEST OFFERING SIDEBAR");				
		sidebar.getTestOffering_Sidebar().click();
		Reporter.log("TEST OFFRING SIDEBAR is FUNCTIONING PROPERLY ",true);
	
		Thread.sleep(5000);
		
		TestSpoolmanNDT_TestOfferingPWHTOffering offering = 
				                 new TestSpoolmanNDT_TestOfferingPWHTOffering(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getNDTPWHTOfferingList_Sidebar());
		webdriverutility.validation(driver,sidebar.getNDTPWHTOfferingList_Sidebar(),
				"CREATE OFFERING LIST SIDEBAR");				
		sidebar.getNDTPWHTOfferingList_Sidebar().click();
		Reporter.log("PWHT OFFRING SIDEBAR is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();
		
		
		Reporter.log("TOTAL NO OF RECORDS SELECTOIN "
		+offering.getSelectionTotalRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF RECORDS CREATION "
		+offering.getCreationTotalRecords().getText(),true);				
		
	
//		webdriverutility.ClickableElement(driver,offering.getSelectionEdit_BTN());
//		webdriverutility.validation(driver,offering.getSelectionEdit_BTN(),
//				"SELECTION EDIT BTN");				
//		offering.getSelectionEdit_BTN().click();
//		Reporter.log("SELECTION EDIT is FUNCTIONING PROPERLY ",true);
		
		Thread.sleep(500);
		
		act.moveByOffset(15,15).perform();;
		
		webdriverutility.ClickableElement(driver,offering.getCreationEdit_BTN());
		webdriverutility.validation(driver,offering.getCreationEdit_BTN(),"CREATION EDIT");				
		offering.getCreationEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,offering.getCreationReportDetails_BTN());
		webdriverutility.validation(driver,offering.getCreationReportDetails_BTN(),
				"CREATION REPORT DETAILS");				
		offering.getCreationReportDetails_BTN().click();
		Reporter.log("CREATION REPORT DETAILS BTN IS FUNCTIONING PROPERLY",true);	
		
		Reporter.log("PLEASE SELECT AT LEASET ONE RECORD POPUP DISPLAYED",
				offering.getPleaseselectatleastonerecord_POPUP().isDisplayed());
		
		offering.getPleaseselectatleastonerecord_POPUPClose().click();
	
		Thread.sleep(500);
				
//		webdriverutility.ClickableElement(driver,offering.getCreationEdit_BTN());
//		webdriverutility.validation(driver,offering.getCreationEdit_BTN(),"CREATION EDIT");				
//		offering.getCreationEdit_BTN().click();
//		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,offering.getCreationSave_BTN());
		webdriverutility.validation(driver,offering.getCreationSave_BTN(),"REPORT NO DD");				
		offering.getCreationSave_BTN().click();
		Reporter.log("CREATION SAVE BTN IS FUNCTIONING PROPERLY",true);

		Reporter.log("PLEASE SELECT AT LEASET ONE RECORD TO SAVE POPUP DISPLAYED",
				offering.getPleaseselecttheofferingNumber_POPUP().isDisplayed());
		
		offering.getPleaseselecttheofferingNumber_POPUPClose().click();
		
		
		webdriverutility.ClickableElement(driver,offering.getSpoolNo3Dots() );
		webdriverutility.validation(driver,offering.getSpoolNo3Dots(),"SPOOLNO 3 DOTS");				
		offering.getSpoolNo3Dots().click();
		Reporter.log("NDT 3 DOTS is FUNCTIONING PROPERLY ",true);

//		SPOOL THAT HAS BEEN FRONT RELEASED...
//		String spool = ConstructionReleaseFS.s;
		String spool = "1103R-CD-130321-01-SP01";
				
		webdriverutility.ClickableElement(driver,offering.getFunnelFilter());
		Thread.sleep(300);
		offering.getFunnelFilter().click();
				
		webdriverutility.ClickableElement(driver,offering.getFilterValue());
		Thread.sleep(300);
		offering.getFilterValue().sendKeys(spool);
		
		webdriverutility.ClickableElement(driver,offering.getFFFilter_BTN());
		Thread.sleep(300);
		offering.getFFFilter_BTN().click();
		
		webdriverutility.ClickableElement(driver,offering.getSelectionFullscreen_BTN());
		offering.getSelectionFullscreen_BTN().click();
		Thread.sleep(500);
		HashMap<String,String> hm = ListUtility.ToItterateList(offering.getSelectionSpoolNoList(),
				offering.getSelectionSpoolNoList());
		
		webdriverutility.ClickableElement(driver,offering.getSelectAllRow());
		webdriverutility.validation(driver,offering.getSelectAllRow(),"SELECTION SELECT ALL");				
		offering.getSelectAllRow().click();
		Reporter.log("SELECT ALL IS FUNCTIONING PROPERLY",true);

		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,offering.getCompress_BTN());
		webdriverutility.validation(driver,offering.getCompress_BTN(),"SELECTION compress");				
		offering.getCompress_BTN().click();
		Reporter.log("COMPRESS IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,offering.getSelectAllRow());
		webdriverutility.validation(driver,offering.getSelectAllRow(),"SELECTION SELECT ALL");				
		offering.getSelectAllRow().click();
		Reporter.log("SELECT ALL IS FUNCTIONING PROPERLY",true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver,offering.getCreationReportDetails_BTN());
		webdriverutility.validation(driver,offering.getCreationReportDetails_BTN(),"CREATION REPORT DETAILS");				
		offering.getCreationReportDetails_BTN().click();
		Reporter.log("CREATION REPORT DETAILS BTN is FUNCTIONING PROPERLY ",true);
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,offering.getAutoGenerateNo_Checkbox());
		webdriverutility.validation(driver,offering.getAutoGenerateNo_Checkbox(),"CREATION REPORT DETAILS");				
		offering.getAutoGenerateNo_Checkbox().click();
		Reporter.log("AUTOGENERATE REPO NO. BTN is FUNCTIONING PROPERLY ",true);	
		
		webdriverutility.ClickableElement(driver,offering.getOfferingNo_DD());
		webdriverutility.validation(driver,offering.getOfferingNo_DD(),"OFFERING NO DD");				
		offering.getOfferingNo_DD().click();
		Reporter.log("Offering No DD is FUNCTIONING PROPERLY ",true);
	
		
		String OfferingNo = "OFFERING_NO-04";
		
		
		webdriverutility.ClickableElement(driver,offering.getOfferingNo_INPUT());
		webdriverutility.validation(driver,offering.getOfferingNo_INPUT(),"OFFERING NO INPUT");				
		offering.getOfferingNo_INPUT().sendKeys(OfferingNo);
		Thread.sleep(500);
		Reporter.log("Offering No INPUT is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,offering.getOfferingAddNewItem_BTN());
		webdriverutility.validation(driver,offering.getOfferingAddNewItem_BTN(),"ADD NEW ITEMS");				
		offering.getOfferingAddNewItem_BTN().click();
		Thread.sleep(500);
		offering.getOfferingNo_INPUT().sendKeys(Keys.ENTER);
		Reporter.log("ADD NEW ITEM is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,offering.getReportDetailsOK_BTN());
		webdriverutility.validation(driver,offering.getReportDetailsOK_BTN(),"REPORT DETAILS OK");				
		offering.getReportDetailsOK_BTN().click();
		Reporter.log("REPORT DETAILS OK is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,offering.getSelectionFullscreen_BTN());
		webdriverutility.validation(driver,offering.getSelectionFullscreen_BTN(),"SELECTION FULLSCREEN");				
		offering.getSelectionFullscreen_BTN().click();
		Reporter.log("SELECTION FULLSCREEN BTN IS FUNCTIONING PROPERLY",true);
	
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,offering.getCompress_BTN());
		webdriverutility.validation(driver,offering.getCompress_BTN(),"COMPRESS BTN");				
		offering.getCompress_BTN().click();
		Reporter.log("COMPRESS BTN IS FUNCTIONING PROPERLY",true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver,offering.getCreationFullscreen_BTN());
		webdriverutility.validation(driver,offering.getCreationFullscreen_BTN(),"CREATION FULLSCREEN");				
		offering.getCreationFullscreen_BTN().click();
		Reporter.log("CREATION FULLSCREEN BTN IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,offering.getCompress_BTN());
		offering.getCompress_BTN().click();
		Reporter.log("COMPRESS BTN IS FUNCTIONING PROPERLY",true);
		
		Reporter.log("TOTAL NO OF RECORDS SELECTOIN "
		+offering.getSelectionTotalRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF RECORDS CREATION "
		+offering.getCreationTotalRecords().getText(),true);		
	
		webdriverutility.ClickableElement(driver,offering.getCreationSave_BTN());
		webdriverutility.validation(driver,offering.getCreationSave_BTN(),"CREATION SAVE BTN");				
		offering.getCreationSave_BTN().click();
		Reporter.log("CREATION SAVE BTN is FUNCTIONING PROPERLY ",true);

		Reporter.log("SAVE DATA SUCCESSFULL IS DISPLAYED",
				offering.getSaveDataSuccessfully_POPUP().isDisplayed());
		offering.getSaveDataSuccessfully_POPUPClose().click();

		
		
		
		
		
		
	}
	
}
