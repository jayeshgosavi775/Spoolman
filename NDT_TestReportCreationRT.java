package spoolman.Ndt;

import java.util.HashMap;

import javax.swing.text.MaskFormatter;

import org.bouncycastle.math.raw.Mod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
import com.pcpl.spoolman.home.TestSpoolman_Wait;
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_AssignJointsToLOT;
import com.pcpl.spoolman.ndt.TestSpoolmanNDT_Sidebar;
import com.pcpl.spoolman.ndt.reportcreation.TestSpoolmanNDT_TestReportRT;
import com.pcpl.spoolman.ndt.reportmodify.TestSpoolmanNDT_ModifyReportRT;
import com.pcpl.spoolman.ndt.reportmodify.TestSpoolmanNDT_ModifyReportUT;

public class NDT_TestReportCreationRT extends BaseClass {

	@Test
	public void NDT_RTReportAll() throws Throwable {
		
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
		Thread.sleep(2000);
		sm.getNDTLot().click();
		Reporter.log("NDT LOT is FUNCTIONING PROPERLY ",true);
	
		Thread.sleep(4000);
		
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		TestSpoolmanNDT_Sidebar sidebar = new TestSpoolmanNDT_Sidebar(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getTestReportCreation_Sidebar());
		webdriverutility.validation(driver,sidebar.getTestReportCreation_Sidebar(),
				"TEST REPORT CREATION");	
		sidebar.getTestReportCreation_Sidebar().click();
		Reporter.log("Test REPORT CREATION SIDEBAR is FUNCTIONING PROPERLY ",true);
			
		TestSpoolmanNDT_TestReportRT report = new TestSpoolmanNDT_TestReportRT(driver);
		
		TestSpoolman_Wait wait = new TestSpoolman_Wait(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getRTReport_Sidebar());
		webdriverutility.validation(driver,sidebar.getRTReport_Sidebar(),
				"RT REPORT SIDEBAR");
		Thread.sleep(4000);
		sidebar.getRTReport_Sidebar().click();
		Reporter.log("RT REPORT SIDEBAR LIST is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.disappear(driver, wait.getPleaseWaitModal());
		
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();
			
		Reporter.log("TOTAL NO OF RECORDS SELECTOIN "+report.getSelectionTotalRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF RECORDS CREATION "+report.getCreationTotalRecords().getText(),true);		
		
		Thread.sleep(1500);
		
		webdriverutility.ClickableElement(driver,report.getSelectionEdit_BTN());
		webdriverutility.validation(driver,report.getSelectionEdit_BTN(),"SELECTION EDIT BTN");				
		report.getSelectionEdit_BTN().click();
		Reporter.log("SELECTION EDIT is FUNCTIONING PROPERLY ",true);

//		webdriverutility.ClickableElement(driver,report.getSelectionFilter_BTN());
//		webdriverutility.validation(driver,report.getSelectionFilter_BTN(),"SELECTION FILTER BTN");				
//		report.getSelectionFilter_BTN().click();
//		Reporter.log("SELECTION FILTER is FUNCTIONING PROPERLY ",true);
//		
//		webdriverutility.ClickableElement(driver,report.getLOTNo_DDTXT());
//		webdriverutility.validation(driver,report.getLOTNo_DDTXT(),"LOT-01");				
//		report.getLOTNo_DDTXT().sendKeys("LOT-01"+Keys.ENTER);
//		Reporter.log("LOTNO DDTXT IS FUNCTIONING PROPERLY",true);
//
//		webdriverutility.ClickableElement(driver,report.getOfferingNo_DDTXT());
//		webdriverutility.validation(driver,report.getOfferingNo_DDTXT(),"OFERING NO DDTXT");				
//		report.getOfferingNo_DDTXT().sendKeys("OFFERING_NO-01"+Keys.ENTER);
//		Reporter.log("OFFERINGNO DDTXT IS FUNCTIONING PROPERLY",true);
//		
//		webdriverutility.ClickableElement(driver,report.getJobCardNo_DDTXT());
//		webdriverutility.validation(driver,report.getJobCardNo_DDTXT(),"JOB CARD NO");				
//		report.getJobCardNo_DDTXT().sendKeys("JOBCARD01"+Keys.ENTER);
//		Reporter.log("JOBCARD DDTXT IS FUNCTIONING PROPERLY",true);
//		
//		Thread.sleep(500);
//		
//		webdriverutility.ClickableElement(driver,report.getFilterOK_BTN());
//		webdriverutility.validation(driver,report.getFilterOK_BTN(),"FILTER BTN OK");				
//		report.getFilterOK_BTN().click();
//		Reporter.log("FILTER OK IS FUNCTIONING PROPERLY",true);

		
		webdriverutility.ClickableElement(driver,report.getSelectionSpoolNo3Dots());
		webdriverutility.validation(driver,report.getSelectionSpoolNo3Dots(),"SELECTION 3 dots");				
		report.getSelectionSpoolNo3Dots().click();
		Reporter.log("SELECTION 3 DOTS IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,report.getFunnelFilter());
		webdriverutility.validation(driver,report.getFunnelFilter(),"3 DOTS FILTER BTN");		
		act.moveToElement(report.getFunnelFilter()).perform();;
		report.getFunnelFilter().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",report.getFilterValue().isDisplayed());
		
		Thread.sleep(1000);
		
		String spool = "1103R-HTF-170067-03-SP05";
		
		webdriverutility.ClickableElement(driver,report.getFilterValue());
		report.getFilterValue().sendKeys(spool);
				
		webdriverutility.ClickableElement(driver,report.getFFFilter_BTN());
		webdriverutility.validation(driver,report.getFFFilter_BTN(),"FILTER BTN");						
		report.getFFFilter_BTN().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",report.getFilterValue().isDisplayed());

//		webdriverutility.ClickableElement(driver,report.getSelectionFullscreen_BTN());
//		report.getSelectionFullscreen_BTN().click();
		Thread.sleep(500);
		HashMap<String,String> hm = ListUtility.ToItterateList(report.getSelectionSpoolNoList(),
				report.getSelectionJointNoList());
				
		webdriverutility.ClickableElement(driver,report.getSelectAllRow());
		webdriverutility.validation(driver,report.getSelectAllRow(),"SELECTION SELECT ALL");				
		report.getSelectAllRow().click();
		Reporter.log("SELECT ALL IS FUNCTIONING PROPERLY",true);
		
//		webdriverutility.ClickableElement(driver,report.getCompress_BTN());
//		webdriverutility.validation(driver,report.getCompress_BTN(),"SELECTION compress");				
//		report.getCompress_BTN().click();
//		Reporter.log("COMPRESS IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,report.getCreationEdit_BTN());
		webdriverutility.validation(driver,report.getCreationEdit_BTN(),"CREATION EDIT");				
		report.getCreationEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getCreationReportDetails_BTN());
		webdriverutility.validation(driver,report.getCreationReportDetails_BTN(),"CREATION REPORT DETAILS");				
		report.getCreationReportDetails_BTN().click();
		Reporter.log("CREATION REPORT DETAILS BTN IS FUNCTIONING PROPERLY",true);		
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getAutoGenerate_Checkbox());
		webdriverutility.validation(driver,report.getAutoGenerate_Checkbox(),"AutoGenerate Checkbox");				
		report.getAutoGenerate_Checkbox().click();
		Reporter.log("AutoGenerate Checkbox IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,report.getReportNo_DD());
		webdriverutility.validation(driver,report.getReportNo_DD(),"REPORT NO DD");				
		report.getReportNo_DD().click();
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getReportNo_DDInput());
		webdriverutility.validation(driver,report.getReportNo_DDInput(),"REPORTNO DD INPUT");		
		
		String rt = "RT_O8";
		
		report.getReportNo_DDInput().sendKeys(rt);
		Thread.sleep(500);
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getReportNo_AddNewItem());
		webdriverutility.validation(driver,report.getReportNo_AddNewItem(),"REPORT ADD NEW ITEM");				
		report.getReportNo_AddNewItem().click();
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getReportNo_DDInput());			
		report.getReportNo_DDInput().sendKeys(Keys.ENTER);
	
		webdriverutility.ClickableElement(driver,report.getRTReportDetailsOK_BTN());
		webdriverutility.validation(driver,report.getRTReportDetailsOK_BTN(),"REPORT OK BTN");				
		report.getRTReportDetailsOK_BTN().click();
		Reporter.log("REPORTDETAILS OK IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getCretionRTRDFile_BTN());
		webdriverutility.validation(driver,report.getCretionRTRDFile_BTN(),"REPORT FILE BTN");				
		report.getCretionRTRDFile_BTN().click();
		Reporter.log("REPORTDETAILS FILE IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getObservationRTRD_DDTXT());
		webdriverutility.validation(driver,report.getObservationRTRD_DDTXT(),"OBSERVATION DDTXT");				
		report.getObservationRTRD_DDTXT().sendKeys("A-Accepted"+Keys.ENTER);
		Reporter.log("OBSERVATION FILE IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,report.getRTOK_BTN());
		webdriverutility.validation(driver,report.getRTOK_BTN(),"RTOK BTN");				
		report.getRTOK_BTN().click();
		Reporter.log("RT OK BTN IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,report.getSelectionFullscreen_BTN());
		webdriverutility.validation(driver,report.getSelectionFullscreen_BTN(),"RTOK BTN");				
		report.getSelectionFullscreen_BTN().click();
		Reporter.log("SELECTION FULLSCREEN BTN IS FUNCTIONING PROPERLY",true);
	
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getCompress_BTN());
		webdriverutility.validation(driver,report.getCompress_BTN(),"RTOK BTN");				
		report.getCompress_BTN().click();
		Reporter.log("COMPRESS BTN IS FUNCTIONING PROPERLY",true);

		Thread.sleep(500);
		
//		webdriverutility.ClickableElement(driver,report.getCreationFullscreen_BTN());
//		webdriverutility.validation(driver,report.getCreationFullscreen_BTN(),"RTOK BTN");				
//		report.getCreationFullscreen_BTN().click();
//		Reporter.log("CREATION FULLSCREEN BTN IS FUNCTIONING PROPERLY",true);
//		
//		webdriverutility.ClickableElement(driver,report.getCompress_BTN());
//		report.getCompress_BTN().click();
//		Reporter.log("COMPRESS BTN IS FUNCTIONING PROPERLY",true);
		
		Reporter.log("TOTAL NO OF RECORDS SELECTOIN "+report.getSelectionTotalRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF RECORDS CREATION "+report.getCreationTotalRecords().getText(),true);		

		webdriverutility.ClickableElement(driver,report.getCreationSave_BTN());
		webdriverutility.validation(driver,report.getCreationSave_BTN(),"CREATION SAVE BTN");				
		report.getCreationSave_BTN().click();
		Reporter.log("COMPRESSION SAVE BTN IS FUNCTIONING PROPERLY",true);
	
//		Reporter.log("DATA SAVED SUCCESSFULLY IS DISPLAYED",report.getDataSavedSuccessfully_POPUP().isDisplayed());
//		
//		report.getDataSaveSuccessfully_POPUPClose().click();
		
		webdriverutility.disappear(driver,wait.getPleaseWaitModal());
		
		Reporter.log("ALL GOOD",true);
		
		Thread.sleep(1000);
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		webdriverutility.ClickableElement(driver,sidebar.getRTViewModifyReport_Sidebar());
		webdriverutility.validation(driver,sidebar.getRTViewModifyReport_Sidebar(),
				"RT TEST REPORT MODIFY");				
		sidebar.getRTViewModifyReport_Sidebar().click();
		Reporter.log("RT REPORT MODIFY SIDEBAR is FUNCTIONING PROPERLY ",true);

		TestSpoolmanNDT_ModifyReportRT modifyRT = new TestSpoolmanNDT_ModifyReportRT(driver);
		
		webdriverutility.ClickableElement(driver,modifyRT.getSelectionEdit_BTN());
		webdriverutility.validation(driver,modifyRT.getSelectionEdit_BTN(),
				"MODIFY SELECTION EDIT");				
		modifyRT.getSelectionEdit_BTN().click();
		Reporter.log("UT REPORT MODIFY SELECTION EDIT is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,modifyRT.getReportNo3Dots());
		webdriverutility.validation(driver,modifyRT.getReportNo3Dots(),
				"REPORT NO. 3 DOTS");				
		modifyRT.getReportNo3Dots().click();
		Reporter.log("REPORT NO 3 DOTS is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,modifyRT.getFunnelFilter());
		webdriverutility.validation(driver,modifyRT.getFunnelFilter(),"3 DOTS FILTER BTN");						
		modifyRT.getFunnelFilter().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",modifyRT.getFilterValue().isDisplayed());
		
		Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,modifyRT.getFilterValue());
		modifyRT.getFilterValue().sendKeys(rt);
				
		webdriverutility.ClickableElement(driver,modifyRT.getFFFilter_BTN());
		webdriverutility.validation(driver,modifyRT.getFFFilter_BTN(),"FILTER BTN");						
		modifyRT.getFFFilter_BTN().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",modifyRT.getFilterValue().isDisplayed());

		webdriverutility.ClickableElement(driver,modifyRT.getSelect1stRow());
		webdriverutility.validation(driver,modifyRT.getSelect1stRow(),"REPORT CHECKBOX");						
		modifyRT.getSelect1stRow().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,modifyRT.getCreationEdit_BTN());
		webdriverutility.validation(driver,modifyRT.getCreationEdit_BTN(),"CREATION EDIT BTN");						
		modifyRT.getCreationEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);

		
		webdriverutility.ClickableElement(driver,modifyRT.getCreationFullscreen_BTN());
		modifyRT.getCreationFullscreen_BTN().click();
		Thread.sleep(500);
		HashMap<String,String> hm1 = ListUtility.ToItterateList(modifyRT.getModifySpoolNoList(),
				modifyRT.getModifyJointNoList());
		
		webdriverutility.ClickableElement(driver,modifyRT.getCompress_BTN());
		webdriverutility.validation(driver,modifyRT.getCompress_BTN(),"CREATION compress BTN");						
		modifyRT.getCompress_BTN().click();
		Reporter.log("CREATION compress BTN IS FUNCTIONING PROPERLY",true);

		
		Reporter.log("SPOOLS AND JOINTS ARE MATCHED "+ ListUtility.areMapsEqual(hm, hm1) ,true);
	
		Reporter.log("VERY NICEE....",true);
		
	}
	
}
