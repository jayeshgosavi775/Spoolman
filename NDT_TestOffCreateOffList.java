/**
 * AUTHOR - PUNIT MORE
 * DATE - 03 -02-2024;
 * DESC - SPOOLMAN-->SELECT PROJECT-->9DOT-->NDT/QAQC-->TEST OFFERING-->CREATE OFFERING LIST SCRIPT
 * UPDATED - 
 */


package spoolman.Ndt;

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
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_TestOfferingCreateOfferingList;
import com.pcpl.spoolman.ndt.reportcreation.TestSpoolmanNDT_TestReportRT;
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_Sidebar;


public class NDT_TestOffCreateOffList extends BaseClass{
	@Test
	public void CreateOfferingListAll() throws Throwable {
		
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
	
		webdriverutility.ClickableElement(driver,sm.getNDT_QAQC_BTN());
		webdriverutility.validation(driver,sm.getNDT_QAQC_BTN(),"NDT_QAQC");				
		sm.getNDT_QAQC_BTN().click();
		Reporter.log("NDT_QAQC is FUNCTIONING PROPERLY ",sm.getNDTLot().isDisplayed());
	
		TestSpoolmanNDT_AssignJointsToLOT ndt = new TestSpoolmanNDT_AssignJointsToLOT(driver);
		
		webdriverutility.ClickableElement(driver,sm.getNDTLot());
		webdriverutility.validation(driver,sm.getNDTLot(),"NDT LOT");				
		sm.getNDTLot().click();
		Reporter.log("NDT LOT is FUNCTIONING PROPERLY ",true);
	
		Thread.sleep(2000);
		
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		TestSpoolmanNDT_Sidebar sidebar = new TestSpoolmanNDT_Sidebar(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getTestOffering_Sidebar());
		webdriverutility.validation(driver,sidebar.getTestOffering_Sidebar(),"TEST OFFERING SIDEBAR");				
		sidebar.getTestOffering_Sidebar().click();
		Reporter.log("TEST OFFRING SIDEBAR is FUNCTIONING PROPERLY ",true);
	
		Thread.sleep(5000);
		
		TestSpoolmanNDT_TestOfferingCreateOfferingList offering = new TestSpoolmanNDT_TestOfferingCreateOfferingList(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getCreateOfferingList_Sidebar());
		webdriverutility.validation(driver,sidebar.getCreateOfferingList_Sidebar(),
				"CREATE OFFERING LIST SIDEBAR");				
		sidebar.getCreateOfferingList_Sidebar().click();
		Reporter.log("CREATION OFFRING SIDEBAR LIST is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();
	
		Thread.sleep(1500);
		
		webdriverutility.ClickableElement(driver,offering.getSelectionEdit_BTN());
		webdriverutility.validation(driver,offering.getSelectionEdit_BTN(),"SELECTION EDIT BTN");				
		offering.getSelectionEdit_BTN().click();
		Reporter.log("SELECTION EDIT is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,offering.getSelectionFilter_BTN());
		webdriverutility.validation(driver,offering.getSelectionFilter_BTN(),"SELECTION FILTER BTN");				
		offering.getSelectionFilter_BTN().click();
		Reporter.log("SELECTION FILTER is FUNCTIONING PROPERLY ",true);
		
		
		webdriverutility.ClickableElement(driver,offering.getTypeofNDTRequired_DDTXT());
		offering.getTypeofNDTRequired_DDTXT().clear();
		

		webdriverutility.ClickableElement(driver,offering.getTypeofNDTRequired_DDTXT());
		webdriverutility.validation(driver,offering.getTypeofNDTRequired_DDTXT(),"TYPE OF NDT REQUIRED");				
		offering.getTypeofNDTRequired_DDTXT().sendKeys("RT/UT/MPT/DPT/PAUT"+Keys.ENTER);;
		Reporter.log("Type of NDT Required is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,offering.getOfferingListSelectionSearch_BTN());
		webdriverutility.validation(driver,offering.getOfferingListSelectionSearch_BTN(),
				"TYPE OF NDT REQUIRED");				
		offering.getOfferingListSelectionSearch_BTN().click();
		Reporter.log("SEARCH BTN is FUNCTIONING PROPERLY ",true);
		
		Thread.sleep(4000);
//		driver.navigate().refresh();
		
		webdriverutility.ClickableElement(driver,offering.getCreationEdit_BTN());
		webdriverutility.validation(driver,offering.getCreationEdit_BTN(),"TYPE OF NDT REQUIRED");				
		offering.getCreationEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,offering.getCreationReportDetails_BTN());
		webdriverutility.validation(driver,offering.getCreationReportDetails_BTN(),
				"TYPE OF NDT REQUIRED");				
		offering.getCreationReportDetails_BTN().click();
		Reporter.log("CREATION REPORT DETAILS BTN is FUNCTIONING PROPERLY ",true);

		Reporter.log("PLEASE SELECT THE RECORD IS DISPLAYED ",
				offering.getPleaseSelectRecordForCreatingtheReport_POPUP().isDisplayed());
		
		offering.getPleaseSelectRecordForCreatingtheReport_POPUPClose().click();
		
//		webdriverutility.ClickableElement(driver,offering.getSelectionEdit_BTN());
//		webdriverutility.validation(driver,offering.getSelectionEdit_BTN(),"SELECTION EDIT BTN");				
//		offering.getSelectionEdit_BTN().click();
//		Reporter.log("SELECTION EDIT is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,offering.getSpoolNo3Dots() );
		webdriverutility.validation(driver,offering.getSpoolNo3Dots(),"SPOOLNO 3 DOTS");				
		offering.getSpoolNo3Dots().click();
		Reporter.log("NDT 3 DOTS is FUNCTIONING PROPERLY ",true);

//		SPOOL THAT HAS BEEN FRONT RELEASED...
//		String spool = ConstructionReleaseFS.s;
		String spool = "1103R-P-130250-08-SP06";
				
		webdriverutility.ClickableElement(driver,ndt.getFunnelFilter());
		Thread.sleep(300);
		ndt.getFunnelFilter().click();
				
		webdriverutility.ClickableElement(driver,ndt.getFilterValue());
		Thread.sleep(300);
		ndt.getFilterValue().sendKeys(spool);
		
		webdriverutility.ClickableElement(driver,ndt.getFFFilter_BTN());
		Thread.sleep(300);
		ndt.getFFFilter_BTN().click();
	
		webdriverutility.ClickableElement(driver,offering.getSelectAllRow());
		webdriverutility.validation(driver,offering.getSelectAllRow(),"SELECT ALL");				
		offering.getSelectAllRow().click();
		Reporter.log("SELECT ALL is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,offering.getCreationReportDetails_BTN());
		webdriverutility.validation(driver,offering.getCreationReportDetails_BTN(),"CREATION REPORT DETAILS");				
		offering.getCreationReportDetails_BTN().click();
		Reporter.log("CREATION REPORT DETAILS BTN is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,offering.getAutogenerateReportNo_Checkbox());
		webdriverutility.validation(driver,offering.getAutogenerateReportNo_Checkbox(),"CREATION REPORT DETAILS");				
		offering.getAutogenerateReportNo_Checkbox().click();
		Reporter.log("AUTOGENERATE REPO NO. BTN is FUNCTIONING PROPERLY ",true);	
		
		webdriverutility.ClickableElement(driver,offering.getOfferingNo_DDTXT());
		webdriverutility.validation(driver,offering.getOfferingNo_DDTXT(),"OFFERING NO DD");				
		offering.getOfferingNo_DDTXT().click();
		Reporter.log("Offering No DD is FUNCTIONING PROPERLY ",true);
		
		String offerNo = "OfferingNo_21";
		
		webdriverutility.ClickableElement(driver,offering.getOfferingNo_INPUT());
		webdriverutility.validation(driver,offering.getOfferingNo_INPUT(),"OFFERING NO INPUT");				
		offering.getOfferingNo_INPUT().sendKeys(offerNo);
		Thread.sleep(500);
		Reporter.log("Offering No INPUT is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,offering.getAddNewItem_BTN());
		webdriverutility.validation(driver,offering.getAddNewItem_BTN(),"ADD NEW ITEMS");				
		offering.getAddNewItem_BTN().click();
		Thread.sleep(500);
		offering.getOfferingNo_INPUT().sendKeys(Keys.ENTER);
		Reporter.log("ADD NEW ITEM is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,offering.getUnit_TXT());
		webdriverutility.textConfirmation(driver,offering.getUnit_TXT(), "UNIT_01", "UNIT TXT");
		
		webdriverutility.ClickableElement(driver,offering.getZoneArea_TXT());
		webdriverutility.textConfirmation(driver,offering.getZoneArea_TXT(), "ZONE-01", "ZONE AREA");
		
		webdriverutility.ClickableElement(driver,offering.getCriteria_TXT());
		webdriverutility.textConfirmation(driver,offering.getCriteria_TXT(), "CRI-01", "CRITERIA");
		
		webdriverutility.ClickableElement(driver,offering.getStageOfTesting_TXT());
		webdriverutility.textConfirmation(driver,offering.getStageOfTesting_TXT(), "SOT-01", "STAGE OF TESTING");
		
		webdriverutility.ClickableElement(driver,offering.getRDOK_BTN());
		webdriverutility.validation(driver,offering.getRDOK_BTN(),"RD OK BTN");				
		offering.getRDOK_BTN().click();
		Reporter.log("RD OK BTN is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,offering.getCreationSave_BTN());
		webdriverutility.validation(driver,offering.getCreationSave_BTN(),"CREATION SAVE BTN");				
		offering.getCreationSave_BTN().click();
		Reporter.log("CREATION SAVE BTN is FUNCTIONING PROPERLY ",true);

		Reporter.log("SAVE DATA SUCCESSFULL IS DISPLAYED",offering.getSaveDataSuccessfully_POPUP().isDisplayed());
		offering.getSaveDataSuccessfully_POPUPClose().click();
		
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
//		waitplease
		Thread.sleep(1500);
		hp.getExpandSidebar().click();
		
		webdriverutility.ClickableElement(driver,sidebar.getTestReportCreation_Sidebar());
		sidebar.getTestReportCreation_Sidebar().click();
		Reporter.log("Test Report CREATION is FUNCTIONING PROPERLY ",true);
		
		webdriverutility.ClickableElement(driver,sidebar.getRTReport_Sidebar());
		sidebar.getRTReport_Sidebar().click();
		Reporter.log("RT Report Sidebar is FUNCTIONING PROPERLY ",true);
		
		TestSpoolmanNDT_TestReportRT report = new TestSpoolmanNDT_TestReportRT(driver);
		
		Thread.sleep(3000);
		
		webdriverutility.ClickableElement(driver,report.getSelectionSpoolNo3Dots());
		webdriverutility.validation(driver,report.getSelectionSpoolNo3Dots(),"SPOOLNO 3 DOTS");				
		report.getSelectionSpoolNo3Dots().click();
		Reporter.log("NDT 3 DOTS is FUNCTIONING PROPERLY ",true);

//		SPOOL THAT HAS BEEN FRONT RELEASED...
//		String spool = ConstructionReleaseFS.s;
				
		webdriverutility.ClickableElement(driver,ndt.getFunnelFilter());
		Thread.sleep(300);
		ndt.getFunnelFilter().click();
				
		webdriverutility.ClickableElement(driver,ndt.getFilterValue());
		Thread.sleep(300);
		ndt.getFilterValue().sendKeys(spool);
		
		webdriverutility.ClickableElement(driver,ndt.getFFFilter_BTN());
		Thread.sleep(300);
		ndt.getFFFilter_BTN().click();
		
		
		
		
	}
	
}
