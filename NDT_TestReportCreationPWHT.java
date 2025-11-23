/**
 * AUTHOR - PUNIT MORE
 * DATE - 03 -02-2024;
 * DESC - SPOOLMAN-->SELECT PROJECT-->9DOT-->NDT/QAQC-->NDT LOT-->TEST REPORT CREATION
 * -->PWHT REPORT script...
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
import com.pcpl.spoolman.ndt.reportcreation.TestSpoolmanNDT_TestReportPWHT;
import com.pcpl.spoolman.ndt.reportmodify.TestSpoolmanNDT_ModifyReportPAUT;
import com.pcpl.spoolman.ndt.reportmodify.TestSpoolmanNDT_ModifyReportPWHT;

public class NDT_TestReportCreationPWHT extends BaseClass{

	@Test
	public void NDT_PWHTReportAll() throws Throwable{
		
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
		
		webdriverutility.ClickableElement(driver,sidebar.getTestReportCreation_Sidebar());
		webdriverutility.validation(driver,sidebar.getTestReportCreation_Sidebar(),
				"TEST REPORT CREATION");				
		sidebar.getTestReportCreation_Sidebar().click();
		Reporter.log("Test REPORT CREATION SIDEBAR is FUNCTIONING PROPERLY ",true);
	
		Thread.sleep(5000);
		
		TestSpoolmanNDT_TestReportPWHT report = new TestSpoolmanNDT_TestReportPWHT(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getPAUTReport_Sidebar());
		webdriverutility.validation(driver,sidebar.getPAUTReport_Sidebar(),
				"PWHT REPORT SIDEBAR");				
		sidebar.getPWHTReport_Sidebar().click();
		Reporter.log("PWHT REPORT SIDEBAR LIST is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();
			
		Reporter.log("TOTAL NO OF RECORDS SELECTOIN "+report.getSelectionTotalRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF RECORDS CREATION "+report.getCreationTotalRecords().getText(),true);		
		
		webdriverutility.ClickableElement(driver,report.getSelectionEdit_BTN());
		webdriverutility.validation(driver,report.getSelectionEdit_BTN(),"SELECTION EDIT BTN");				
		report.getSelectionEdit_BTN().click();
		Reporter.log("SELECTION EDIT is FUNCTIONING PROPERLY ",true);
		
		Thread.sleep(500);
		
		act.moveByOffset(15,15).perform();;
		
		webdriverutility.ClickableElement(driver,report.getCreationEdit_BTN());
		webdriverutility.validation(driver,report.getCreationEdit_BTN(),"CREATION EDIT");				
		report.getCreationEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);
	
//		webdriverutility.ClickableElement(driver,report.getCreationReportDetails_BTN());
//		webdriverutility.validation(driver,report.getCreationReportDetails_BTN(),
//				"CREATION REPORT DETAILS");				
//		report.getCreationReportDetails_BTN().click();
//		Reporter.log("CREATION REPORT DETAILS BTN IS FUNCTIONING PROPERLY",true);	
//		
//		Reporter.log("PLEASE SELECT RECORD POPUP DISPLAYED",
//				report.getPleaseSelectRow_POPUP().isDisplayed());
//		
//		report.getPleaseSelectRow_POPUPClose().click();
		
		webdriverutility.ClickableElement(driver,report.getFile_BTN());
		webdriverutility.validation(driver,report.getFile_BTN(),
				"file DETAILS");				
		report.getFile_BTN().click();
		Reporter.log("file BTN IS FUNCTIONING PROPERLY",true);	
	
		Thread.sleep(500);
		
		Reporter.log("PLEASE SELECT RECORD POPUP DISPLAYED",
				report.getPleaseSelectRow_POPUP().isDisplayed());

		report.getPleaseSelectRow_POPUPClose().click();
		
		webdriverutility.ClickableElement(driver,report.getCreationSave_BTN());
		webdriverutility.validation(driver,report.getCreationSave_BTN(),
				"CREATION save DETAILS");				
		report.getCreationSave_BTN().click();
		Reporter.log("file OK BTN IS FUNCTIONING PROPERLY",true);	
	
		Thread.sleep(500);
		
		Reporter.log("fill master RECORD POPUP DISPLAYED",
				report.getFillMasterData_POPUP().isDisplayed());

		report.getFillMasterData_POPUPClose().click();
		
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getSelectionFullscreen_BTN());
		report.getSelectionFullscreen_BTN().click();
		Thread.sleep(500);
		HashMap<String,String> hm = ListUtility.ToItterateList(report.getSelectionSpoolNoList(),
				report.getSelectionJointNoList());
		
		webdriverutility.ClickableElement(driver,report.getSelectAllRow());
		webdriverutility.validation(driver,report.getSelectAllRow(),"SELECTION SELECT ALL");				
		report.getSelectAllRow().click();
		Reporter.log("SELECT ALL IS FUNCTIONING PROPERLY",true);

		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getCompress_BTN());
		webdriverutility.validation(driver,report.getCompress_BTN(),"SELECTION compress");				
		report.getCompress_BTN().click();
		Reporter.log("COMPRESS IS FUNCTIONING PROPERLY",true);

		Thread.sleep(500);

//		webdriverutility.ClickableElement(driver,report.getCreationEdit_BTN());
//		report.getCreationEdit_BTN().click();
//		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);				
		
		webdriverutility.ClickableElement(driver,report.getCreationReportDetails_BTN());
		webdriverutility.validation(driver,report.getCreationReportDetails_BTN(),
				"CREATION REPORT DETAILS");				
		report.getCreationReportDetails_BTN().click();
		Reporter.log("CREATION REPORT DETAILS BTN IS FUNCTIONING PROPERLY",true);	
		
		Thread.sleep(500);
				
		webdriverutility.ClickableElement(driver,report.getAutoGenerateNo_Checkbox());
		webdriverutility.validation(driver,report.getAutoGenerateNo_Checkbox(),
				"AutoGenerate Checkbox");				
		report.getAutoGenerateNo_Checkbox().click();
		Reporter.log("AutoGenerate Checkbox IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,report.getReportNo_DD());
		webdriverutility.validation(driver,report.getReportNo_DD(),"REPORT NO DD");				
		report.getReportNo_DD().click();
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getReportNo_DDInput());
		webdriverutility.validation(driver,report.getReportNo_DDInput(),"REPORTNO DD INPUT");	
		
		String pwht = "PWHT_O6";
		
		report.getReportNo_DDInput().sendKeys(pwht);
		Thread.sleep(500);
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getReportNo_AddNewItem());
		webdriverutility.validation(driver,report.getReportNo_AddNewItem(),"REPORT ADD NEW ITEM");				
		report.getReportNo_AddNewItem().click();
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getReportNo_DDInput());			
		report.getReportNo_DDInput().sendKeys(Keys.ENTER);
	
		webdriverutility.ClickableElement(driver,report.getReportDetailsOK_BTN());
		webdriverutility.validation(driver,report.getReportDetailsOK_BTN(),"REPORT DETAILS OK BTN");				
		report.getReportDetailsOK_BTN().click();
		Reporter.log("REPORTDETAILS OK IS FUNCTIONING PROPERLY",true);
		
//		webdriverutility.ClickableElement(driver,report.getFile_BTN());
//		webdriverutility.validation(driver,report.getFile_BTN(),"FILE BTN");				
//		report.getFile_BTN().click();
//		Reporter.log("FILE IS FUNCTIONING PROPERLY",true);
//
//		Thread.sleep(500);
//		
//		webdriverutility.ClickableElement(driver,report.getFileCheckAllPWHTBilling_Checkbox());
//		webdriverutility.validation(driver,report.getFileCheckAllPWHTBilling_Checkbox(),"Billing checkbox");				
//		report.getFileCheckAllPWHTBilling_Checkbox().click();
//		Reporter.log("Billing Checkbox IS FUNCTIONING PROPERLY",true);
//
//		webdriverutility.ClickableElement(driver,report.getFileOK_BTN());
//		webdriverutility.validation(driver,report.getFileOK_BTN(),"Billing checkbox");				
//		report.getFileOK_BTN().click();
//		Reporter.log("Billing ok IS FUNCTIONING PROPERLY",true);


		webdriverutility.ClickableElement(driver,report.getReportType_BTN());
		webdriverutility.validation(driver,report.getReportType_BTN(),"REPORT TYPE BTN");				
		report.getReportType_BTN().click();
		Reporter.log("Report Type BTN IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getReportType_DDTXT());
		webdriverutility.validation(driver,report.getReportType_DDTXT(),"REPORT TYPE OK BTN");				
		report.getReportType_DDTXT().sendKeys("Default"+Keys.ENTER);;
		Reporter.log("Report Type DDTXT IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,report.getReportTypeOK_BTN());
		webdriverutility.validation(driver,report.getReportTypeOK_BTN(),"REPORT TYPE OK BTN");				
		report.getReportTypeOK_BTN().click();
		Reporter.log("Report Type OK BTN IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getSelectionFullscreen_BTN());
		webdriverutility.validation(driver,report.getSelectionFullscreen_BTN(),"DPTOK BTN");				
		report.getSelectionFullscreen_BTN().click();
		Reporter.log("SELECTION FULLSCREEN BTN IS FUNCTIONING PROPERLY",true);
	
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getCompress_BTN());
		webdriverutility.validation(driver,report.getCompress_BTN(),"DPTOK BTN");				
		report.getCompress_BTN().click();
		Reporter.log("COMPRESS BTN IS FUNCTIONING PROPERLY",true);

		Thread.sleep(500);

//		webdriverutility.ClickableElement(driver,report.getCreationFullscreen_BTN());
//		webdriverutility.validation(driver,report.getCreationFullscreen_BTN(),"RTOK BTN");				
//		report.getCreationFullscreen_BTN().click();
//		Reporter.log("CREATION FULLSCREEN BTN IS FUNCTIONING PROPERLY",true);
//		
//		Thread.sleep(500);
//		
//		webdriverutility.ClickableElement(driver,report.getCompress_BTN());
//		report.getCompress_BTN().click();
//		Reporter.log("COMPRESS BTN IS FUNCTIONING PROPERLY",true);
		
		Reporter.log("TOTAL NO OF RECORDS SELECTOIN "+report.getSelectionTotalRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF RECORDS CREATION "+report.getCreationTotalRecords().getText(),true);		
	
		webdriverutility.ClickableElement(driver,report.getCreationSave_BTN());
		webdriverutility.validation(driver,report.getCreationSave_BTN(),"CREATION SAVE BTN");				
		report.getCreationSave_BTN().click();
		Reporter.log("CREATIVE SAVE BTN IS FUNCTIONING PROPERLY",true);
	
		Reporter.log("DATA SAVED SUCCESSFULLY IS DISPLAYED",
				report.getSaveDataSuccessfully_POPUP().isDisplayed());
		
		report.getSaveDataSuccessfully_POPUPClose().click();
		
		Reporter.log("ALL GOOD",true);
		

		/*
		 * 
		 */
		
		Thread.sleep(1000);
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		webdriverutility.ClickableElement(driver,sidebar.getPWHTViewModifyReport_Sidebar());
		webdriverutility.validation(driver,sidebar.getPWHTViewModifyReport_Sidebar(),
				"PWHT TEST REPORT MODIFY");				
		sidebar.getPWHTViewModifyReport_Sidebar().click();
		Reporter.log("PWHT REPORT MODIFY SIDEBAR is FUNCTIONING PROPERLY ",true);

		TestSpoolmanNDT_ModifyReportPWHT modifyPWHT = new TestSpoolmanNDT_ModifyReportPWHT(driver);
		
		webdriverutility.ClickableElement(driver,modifyPWHT.getSelectionEdit_BTN());
		webdriverutility.validation(driver,modifyPWHT.getSelectionEdit_BTN(),
				"MODIFY SELECTION EDIT");				
		modifyPWHT.getSelectionEdit_BTN().click();
		Reporter.log("UT REPORT MODIFY SELECTION EDIT is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,modifyPWHT.getReportNo3Dots());
		webdriverutility.validation(driver,modifyPWHT.getReportNo3Dots(),
				"REPORT NO. 3 DOTS");				
		modifyPWHT.getReportNo3Dots().click();
		Reporter.log("REPORT NO 3 DOTS is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,modifyPWHT.getFunnelFilter());
		webdriverutility.validation(driver,modifyPWHT.getFunnelFilter(),"3 DOTS FILTER BTN");						
		modifyPWHT.getFunnelFilter().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",modifyPWHT.getFilterValue().isDisplayed());
		
		Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,modifyPWHT.getFilterValue());
		modifyPWHT.getFilterValue().sendKeys(pwht);
				
		webdriverutility.ClickableElement(driver,modifyPWHT.getFFFilter_BTN());
		webdriverutility.validation(driver,modifyPWHT.getFFFilter_BTN(),"FILTER BTN");						
		modifyPWHT.getFFFilter_BTN().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",modifyPWHT.getFilterValue().isDisplayed());

		webdriverutility.ClickableElement(driver,modifyPWHT.getSelect1stRow());
		webdriverutility.validation(driver,modifyPWHT.getSelect1stRow(),"REPORT CHECKBOX");						
		modifyPWHT.getSelect1stRow().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,modifyPWHT.getCreationEdit_BTN());
		webdriverutility.validation(driver,modifyPWHT.getCreationEdit_BTN(),"CREATION EDIT BTN");						
		modifyPWHT.getCreationEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);

		
		webdriverutility.ClickableElement(driver,modifyPWHT.getCreationFullscreen_BTN());
		modifyPWHT.getCreationFullscreen_BTN().click();
		Thread.sleep(500);
		HashMap<String,String> hm1 = ListUtility.ToItterateList(modifyPWHT.getModifySpoolNoList(),
				modifyPWHT.getModifyJointNoList());
		
//		webdriverutility.ClickableElement(driver,modifyPWHT.getCompress_BTN());
//		webdriverutility.validation(driver,modifyPWHT.getCompress_BTN(),"CREATION compress BTN");						
//		modifyPWHT.getCompress_BTN().click();
//		Reporter.log("CREATION compress BTN IS FUNCTIONING PROPERLY",true);
		
		Reporter.log("SPOOLS AND JOINTS ARE MATCHED "+ ListUtility.areMapsEqual(hm, hm1) ,true);
	
		Reporter.log("VERY NICEE....",true);
	


	}
	
}
