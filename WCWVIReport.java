/**
 * AUTHOR - PUNIT MORE
 * DATE - 25-01-2024;
 * DESC - PGOLD-->SPOOLMAN-->SELECT PROJECT-->WELDING--->WVI REPORT SCRIPT
 * UPDATED - 
 */


package spoolman.Welding;
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
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_Sidebar;
import com.pcpl.spoolman.welding.TestSpoolman_WCWVIReport;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingSideBar;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingWPSDetails;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingWPSSpec;

import efa_Mfa.ConstructionReleaseFS;

public class WCWVIReport extends BaseClass {
	
	@Test (priority = 3)
	public void WCWVIReportfull() throws Throwable {

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
		
//		webdriverutility.ClickableElement(driver,sm.getMTO_Test());
//		webdriverutility.validation(driver,sm.getMTO_Test(),"PROJECT SELECTED");		
//		sm.getMTO_Test().click();
		
		Thread.sleep(500);
		
		for (WebElement project : sm.getOnGoingProjectList()) {
			
			if (project.getText().equals(ExcelUtility.readFromExcelProject("Sheet1", 1, 1))) {
				project.click();
			break;
			}
			
		}
		
		Reporter.log("PROJECT IS GETTING SELECTED ",
				sm.getNineDotMenu_BTN().isDisplayed());
		
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
		
		TestSpoolman_WCWVIReport report = new TestSpoolman_WCWVIReport(driver);
		
		webdriverutility.ClickableElement(driver,Sidebar.getWPStoSpec_Sidebar());
		webdriverutility.validation(driver,Sidebar.getWPStoSpec_Sidebar(),"WELDING COMPLETION");						
		Sidebar.getWeldingCompletion_Sidebar().click();
		Reporter.log("WELDING COMPLETION IS FUNCTIONING PROPERLY",Sidebar.getWCWVIReport_Sidebar().isDisplayed());
		
		webdriverutility.ClickableElement(driver,Sidebar.getWCWVIReport_Sidebar());
		webdriverutility.validation(driver,Sidebar.getWCWVIReport_Sidebar(),"WC REPORT ");						
		Sidebar.getWCWVIReport_Sidebar().click();
		Reporter.log("WC WVIREPORT IS FUNCTIONING PROPERLY",report.getCreationWindowEdit_BTN().isDisplayed());
		
		
		
//		webdriverutility.waitplease(driver, report.getSelectionWindowEdit_BTN() , report.getSelectionWindowEdit_BTN());
		
//		boolean isVisibleInViewport = ((JavascriptExecutor) driver).executeScript("return arguments[0].isDisplayedInViewport;",
//				report.getSelectionWindowEdit_BTN()).toString().equalsIgnoreCase("true");
//		Assert.assertTrue(isVisibleInViewport, " pleasewait is still there ,Element is not visible in the viewport");
		
		Thread.sleep(4000);
		
		webdriverutility.ClickableElement(driver,report.getSelectionWindowEdit_BTN());
		webdriverutility.validation(driver,report.getSelectionWindowEdit_BTN(),"SELECTION EDIT BTN");						
		report.getSelectionWindowEdit_BTN().click();
		Reporter.log("SELECTION EDIT BTN IS FUNCTIONING PROPERLY",report.getSelectionSelectAll_CHECKBOX().isDisplayed());
	
		webdriverutility.ClickableElement(driver,report.getSpoolNo3Dots());
		webdriverutility.validation(driver,report.getSpoolNo3Dots(),"SELECTION EDIT 3DOTS");						
		report.getSpoolNo3Dots().click();
		Reporter.log("SELECTION EDIT 3dots BTN IS FUNCTIONING PROPERLY",report.getFilter_BTN().isDisplayed());
		
		webdriverutility.ClickableElement(driver,report.getFunnelFilter());
		webdriverutility.validation(driver,report.getFunnelFilter(),"3 DOTS FILTER BTN");						
		report.getFunnelFilter().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",report.getFilterValue().isDisplayed());
	
//		String spool = ConstructionReleaseFS.s;
		String spool = "1103A-P-110127-02-SP02";
						
		webdriverutility.ClickableElement(driver,report.getFilterValue());
		report.getFilterValue().sendKeys(spool);
				
		webdriverutility.ClickableElement(driver,report.getFFFilter_BTN());
		webdriverutility.validation(driver,report.getFFFilter_BTN(),"FILTER BTN");						
		report.getFFFilter_BTN().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",report.getFilterValue().isDisplayed());
		
		webdriverutility.ClickableElement(driver,report.getSelectionSelectAll_CHECKBOX());
		webdriverutility.validation(driver,report.getSelectionSelectAll_CHECKBOX(),"SELECT 1st CHECKBOX");						
		report.getSelectionSelectAll_CHECKBOX().click();
		Reporter.log("SELECTION SELECT ALL CHECKBOX IS FUNCTIONING PROPERLY",true);
		
//		webdriverutility.ClickableElement(driver,report.getSelect1stRow_CHECKBOX());
//		webdriverutility.validation(driver,report.getSelect1stRow_CHECKBOX(),"SELECT 1st CHECKBOX");						
//		report.getSelect1stRow_CHECKBOX().click();
//		Reporter.log("SELECT 1SR ROW CHECKBOX IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getCreationWindowEdit_BTN());
		webdriverutility.validation(driver,report.getCreationWindowEdit_BTN(),"FILTER BTN");						
		report.getCreationWindowEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.validation(driver,report.getWeldingDetails(),"FILTER BTN");						
		js.executeScript("arguments[0].scrollIntoView(true);", report.getWeldingDetails());
		
		for (WebElement webdetails : report.getWeldingDetailsList()) {
		    if (webdetails.isDisplayed()) 
		    {
		    Thread.sleep(300);
		    webdetails.click();
			webdriverutility.ClickableElement(driver,report.getWDWPSNo_DDTXT());
//			report.getWDWPSNo_DDTXT().sendKeys("WPS_01");
			report.getWDWPSNo_DDTXT().sendKeys("STS-WPS-407");
			Thread.sleep(500);
			report.getWDWPSNo_DDTXT().sendKeys(Keys.ENTER);
			Reporter.log("WPS_01",true);
				
			for (WebElement weldingprocess : report.getWDWeldingProcess_CHECKBOXList()) 
				{
		    	Thread.sleep(300);
		    	webdriverutility.ClickableElement(driver,weldingprocess);
				weldingprocess.click();
				System.out.println("welding process click");
				
				}
		    
			for (WebElement WelderNos : report.getWDWelderNo_CHECKBOXList()) 
				{
				Thread.sleep(300);
				webdriverutility.ClickableElement(driver,WelderNos);
				WelderNos.click();
				System.out.println("welder no.");
			
				}				
			
			js.executeScript("arguments[0].scrollIntoView(true);", report.getWDEdit());

			webdriverutility.ClickableElement(driver,report.getWDEdit());
			webdriverutility.validation(driver,report.getWDEdit(),"WD EDIT BTN");						
			report.getWDEdit().click();
			Reporter.log("WD EDIT BTN IS FUNCTIONING PROPERLY",true);
		
			js.executeScript("arguments[0].scrollIntoView(true);", report.getSelectionSelectAllRow_CHECKBOX());
			webdriverutility.ClickableElement(driver,report.getSelectionSelectAllRow_CHECKBOX());
			webdriverutility.validation(driver,report.getSelectionSelectAllRow_CHECKBOX(),"WD SELECT ALL ");						
			report.getSelectionSelectAllRow_CHECKBOX().click();
			Reporter.log("SELECTION SELECT ALL CHECKBOX IS FUNCTIONING PROPERLY",true);
	
			webdriverutility.ClickableElement(driver,report.getWDOk());
			webdriverutility.validation(driver,report.getWDOk(),"WDOK BTN");						
			report.getWDOk().click();
			Reporter.log("WELDING DETAILS OK IS FUNCTIONING PROPERLY",true);

		    }	
 
		}
		
//		webdriverutility.ClickableElement(driver,report.getCreationSave_BTN());
//		webdriverutility.validation(driver,report.getCreationSave_BTN(),"SAVE BTN");						
//		report.getCreationSave_BTN().click();
//		Reporter.log("CREATION SAVE BTN IS FUNCTIONING PROPERLY",true);
//	
//		Reporter.log("DATA SAVED SUCESSFULLY POPUP DISPLAYED");
	
		webdriverutility.ClickableElement(driver,report.getReportDetails_BTN());
		webdriverutility.validation(driver,report.getReportDetails_BTN(),"REPORT DETAILS BTN");						
		report.getReportDetails_BTN().click();
		Reporter.log("REPORT DETAILS OK IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getAutogenerateReportNo_CHECKBOX());
		webdriverutility.validation(driver,report.getAutogenerateReportNo_CHECKBOX(),"AUTOGENERATOR CHECKBOX");						
		report.getAutogenerateReportNo_CHECKBOX().click();
		Reporter.log("AUTOGENERATION CHECKBOX IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,report.getReportNo_DD());
		webdriverutility.validation(driver,report.getReportNo_DD(),"AUTOGENERATOR CHECKBOX");						
		report.getReportNo_DD().click();
		Reporter.log("REPORT NO DD IS FUNCTIONING PROPERLY",true);
		
		String weldRepo = "WVI_57";
		
		webdriverutility.ClickableElement(driver,report.getReportNoDDInput());
		report.getReportNoDDInput().sendKeys(weldRepo);
		Reporter.log("REPORT NO INPUT IS FUNCTIONING PROPERLY",true);

		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getReportNoADD_BTN());
		webdriverutility.validation(driver,report.getReportNoADD_BTN(),"REPORT NO ADD");						
		report.getReportNoADD_BTN().click();
		Reporter.log("REPORT NO ADD IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		report.getReportNoDDInput().sendKeys(Keys.ENTER);
		
		webdriverutility.ClickableElement(driver,report.getObservation_DDTXT());
		webdriverutility.validation(driver,report.getObservation_DDTXT(),"OBSERVATION DDTXT");						
		report.getObservation_DDTXT().sendKeys("Accepted");	
		Reporter.log("OBSERVATION DDTXT IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,report.getCheckInspectionWelding_CHECKBOX());
		webdriverutility.validation(driver,report.getCheckInspectionWelding_CHECKBOX(),"CHECK INSPECTION CHECKBOX");						
		report.getCheckInspectionWelding_CHECKBOX().click();;	
		Reporter.log("CHECK INSPECTION CHECKBOX IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,report.getFitupReportCreationSave_BTN());
		webdriverutility.validation(driver,report.getFitupReportCreationSave_BTN(),"CREATION SAVE BTN");						
		report.getFitupReportCreationSave_BTN().click();;	
		Reporter.log("WVI Report CREATION SAVE BTN IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,report.getCreationSave_BTN());
		webdriverutility.validation(driver,report.getCreationSave_BTN(),"CREATION SAVE BTN");						
		report.getCreationSave_BTN().click();;	
		Reporter.log("CREATION SAVE BTN IS FUNCTIONING PROPERLY",true);

		
		Reporter.log("DATA SAVE SUCCESSFULLY IS DISPLAYED",report.getDataSavedSuccessfully_POPUP().isDisplayed());
		
		report.getDataSavedSuccessfully_POPUPClose().click();
		
		Reporter.log("ALL GOOD",true);			
		
		/*
		 * INTEGRATION TO CHECK IF THE DATA IS GETTING FETCHED IN NDT...
		 */
		
		webdriverutility.ClickableElement(driver,hp.getPGOLDHome_BTN());
		webdriverutility.validation(driver,hp.getPGOLDHome_BTN(),"HOME BTN");
		hp.getPGOLDHome_BTN().click();
		Reporter.log(" PGOLD Home BTN IS FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,hp.getSpoolmanErman());
		webdriverutility.validation(driver,hp.getSpoolmanErman(),"EFA_MFA ");
		hp.getSpoolmanErman().click();		
		Reporter.log("SPOOLMAN-ERMAN is displayed and true",true);
	
//		webdriverutility.ClickableElement(driver,sm.getMTO_Test());
//		webdriverutility.validation(driver,sm.getMTO_Test(),"PROJECT SELECTED");		
//		sm.getMTO_Test().click();
		
		webdriverutility.ClickableElement(driver,sm.getAutomation_Proj());
		webdriverutility.validation(driver,sm.getAutomation_Proj(),"AUTOMATION PROJECT");		
		sm.getAutomation_Proj().click();
		Reporter.log("AUTOMATION PROJ FUNCTIONING PROPERLY",true);

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
	
		TestSpoolmanNDT_AssignJointsToLOT ndt = new TestSpoolmanNDT_AssignJointsToLOT(driver);
		
		webdriverutility.ClickableElement(driver,sm.getNDTLot());
		webdriverutility.validation(driver,sm.getNDTLot(),"NDT LOT");				
		sm.getNDTLot().click();
		Reporter.log("NDT LOT is FUNCTIONING PROPERLY ",true);
	
//		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
//		Thread.sleep(300);
//		hp.getExpandSidebar().click();
//		Reporter.log("EXPAND SIDEBAR FUNCTIONING PROPERLY ",true);

		TestSpoolmanNDT_Sidebar sidebar = new TestSpoolmanNDT_Sidebar(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getAssignJointstoLOT_Sidebar());
		webdriverutility.validation(driver,sidebar.getAssignJointstoLOT_Sidebar(),"ASSIGN JOINTS TO LOT SIDEBAR");				
		sidebar.getAssignJointstoLOT_Sidebar().click();
		Reporter.log("SIDEBAR LOT CREATION is FUNCTIONING PROPERLY ",true);
	
		Thread.sleep(10000);
		
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		webdriverutility.validation(driver,hp.getExpandSidebar(),"expand sidebar");
		hp.getExpandSidebar().click();
		
		Reporter.log("TOTAL NO OF UNASSIGNED RECORDS "+
		ndt.getTotalUnassighnedRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF ASSIGNED RECORDS "+
				ndt.getTotalAssighnedRecords().getText(),true);
		
		
		webdriverutility.ClickableElement(driver,ndt.getContractorEdit_BTN());
		webdriverutility.validation(driver,ndt.getContractorEdit_BTN(),"CONTRACTOR EDIT");				
		ndt.getContractorEdit_BTN().click();
		Reporter.log("CONTRACT EDIT is FUNCTIONING PROPERLY ",true);

		Thread.sleep(3000);
		
		webdriverutility.ClickableElement(driver,ndt.getSpoolNo3Dots());
		webdriverutility.validation(driver,ndt.getSpoolNo3Dots(),"SPOOLNO 3 DOTS");				
		ndt.getSpoolNo3Dots().click();
		Reporter.log("NDT 3 DOTS is FUNCTIONING PROPERLY ",true);

//		SPOOL THAT HAS BEEN FRONT RELEASED...
//		String spool =ConstructionReleaseFS.s;
		
		Thread.sleep(500);
				
//		webdriverutility.ClickableElement(driver,ndt.getFunnelFilter());
//		Thread.sleep(300);
//		ndt.getFunnelFilter().click();
//				
//		webdriverutility.ClickableElement(driver,ndt.getFilterValue());
//		Thread.sleep(300);
//		ndt.getFilterValue().sendKeys(spool);
//		
//		webdriverutility.ClickableElement(driver,ndt.getFFFilter_BTN());
//		Thread.sleep(300);
//		ndt.getFFFilter_BTN().click();
//
//		for(WebElement SpoolNo:ndt.getSpoolNoWeldList()) 
//		{
//		
//		Assert.assertTrue(spool.equals(SpoolNo.getText()),"SPOOL DID NOT GET FETCHED IN NDT");
//		
//		Reporter.log((SpoolNo.getText()+"spool got displayed "),true);
//		
//		
//		}
		
//		Reporter.log("SPOOLS DID GET FETCHED IN NDT",true);
		
		Reporter.log("all good... aur kyahi bole...pak gaya",true);

		
	}

}



/*
 * PLEASE UPDATE SPOOL - 
 * WVI NO - 
 * FOR SMOOTH RUN
 */

