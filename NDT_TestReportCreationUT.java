/**
 * AUTHOR - PUNIT MORE
 * DATE - 13 -03-2024;
 * DESC - SPOOLMAN-->SELECT PROJECT-->9DOT-->NDT/QAQC-->NDT LOT-->TEST REPORT CREATION
 * --> UT REPORT CREATION...
 * UPDATED - 
 */


package spoolman.Ndt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
import com.pcpl.spoolman.ndt.reportcreation.TestSpoolmanNDT_TestReportRT;
import com.pcpl.spoolman.ndt.reportcreation.TestSpoolmanNDT_TestReportUT;
import com.pcpl.spoolman.ndt.reportmodify.TestSpoolmanNDT_ModifyReportUT;

public class NDT_TestReportCreationUT extends BaseClass{
	
	@Test
	public void NDT_UTReportAll() throws Throwable {
		
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
		
		Thread.sleep(1000);

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
	
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		Thread.sleep(2000);
		
		TestSpoolmanNDT_Sidebar sidebar = new TestSpoolmanNDT_Sidebar(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getTestReportCreation_Sidebar());
		webdriverutility.validation(driver,sidebar.getTestReportCreation_Sidebar(),
				"TEST REPORT CREATION");				
		sidebar.getTestReportCreation_Sidebar().click();
		Reporter.log("Test REPORT CREATION SIDEBAR is FUNCTIONING PROPERLY ",true);
	
		Thread.sleep(4000);
		
		TestSpoolmanNDT_TestReportUT report = new TestSpoolmanNDT_TestReportUT(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getUTReport_Sidebar());
		webdriverutility.validation(driver,sidebar.getUTReport_Sidebar(),
				"UT REPORT SIDEBAR");				
		sidebar.getUTReport_Sidebar().click();
		Reporter.log("UT REPORT SIDEBAR LIST is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();
			
		Reporter.log("TOTAL NO OF RECORDS SELECTOIN "+report.getSelectionTotalRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF RECORDS CREATION "+report.getCreationTotalRecords().getText(),true);		
		
		webdriverutility.ClickableElement(driver,report.getSelectionEdit_BTN());
		webdriverutility.validation(driver,report.getSelectionEdit_BTN(),"SELECTION EDIT BTN");				
		report.getSelectionEdit_BTN().click();
		Reporter.log("SELECTION EDIT is FUNCTIONING PROPERLY ",true);
		
/*
 * 
 */

		HashMap<String, String> hm = new HashMap<String, String>();

		for (int i = 0; i < report.getSelectionSpoolNoList().size(); i++) {
		    String spoolNo = report.getSelectionSpoolNoList().get(i).getText();
		    String jointNo = report.getSelectionJointNoList().get(i).getText();
		    
		    hm.put(spoolNo, jointNo);
		    
		    Reporter.log("Spool No: " + spoolNo + " - Joint No: " + jointNo, true);
		}		

	       // Printing all elements of HashMap
        System.out.println("Created hashmap is" + hm);
		
        Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,report.getCreationEdit_BTN());
		webdriverutility.validation(driver,report.getCreationEdit_BTN(),"CREATION EDIT");				
		report.getCreationEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getCreationReportDetails_BTN());
		webdriverutility.validation(driver,report.getCreationReportDetails_BTN(),
				"CREATION REPORT DETAILS");				
		report.getCreationReportDetails_BTN().click();
		Reporter.log("CREATION REPORT DETAILS BTN IS FUNCTIONING PROPERLY",true);	
		
		Reporter.log("PLEASE SELECT AT LEASET ONE RECORD POPUP DISPLAYED",
				report.getPleaseselectatleastoneRecord_POPUP().isDisplayed());
		
		report.getPleaseselectatleastoneRecord_POPUPClose().click();
	
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getSpoolNo3Dots());
		webdriverutility.validation(driver,report.getSpoolNo3Dots(),"SELECTION 3 dots");				
		report.getSpoolNo3Dots().click();
		Reporter.log("SELECTION 3 DOTS IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,report.getFunnelFilter());
		webdriverutility.validation(driver,report.getFunnelFilter(),"3 DOTS FILTER BTN");		
		act.moveToElement(report.getFunnelFilter()).perform();;
		report.getFunnelFilter().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",report.getFilterValue().isDisplayed());
		
		Thread.sleep(1000);
		
		String spool = "1103R-P-130250-07-SP01";
		
		webdriverutility.ClickableElement(driver,report.getFilterValue());
		report.getFilterValue().sendKeys(spool);
				
		webdriverutility.ClickableElement(driver,report.getFFFilter_BTN());
		webdriverutility.validation(driver,report.getFFFilter_BTN(),"FILTER BTN");						
		report.getFFFilter_BTN().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",report.getFilterValue().isDisplayed());

//		webdriverutility.ClickableElement(driver,report.getSelectionFullscreen_BTN());
//		report.getSelectionFullscreen_BTN().click();
		Thread.sleep(500);
				
		webdriverutility.ClickableElement(driver,report.getSelectAllRow());
		webdriverutility.validation(driver,report.getSelectAllRow(),"SELECTION SELECT ALL");				
		report.getSelectAllRow().click();
		Reporter.log("SELECT ALL IS FUNCTIONING PROPERLY",true);			
		
		webdriverutility.ClickableElement(driver,report.getCreationReportDetails_BTN());
		webdriverutility.validation(driver,report.getCreationReportDetails_BTN(),
				"CREATION REPORT DETAILS");				
		report.getCreationReportDetails_BTN().click();
		Reporter.log("CREATION REPORT DETAILS BTN IS FUNCTIONING PROPERLY",true);	
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getAutoGenerate_Checkbox());
		webdriverutility.validation(driver,report.getAutoGenerate_Checkbox(),
				"AutoGenerate Checkbox");				
		report.getAutoGenerate_Checkbox().click();
		Reporter.log("AutoGenerate Checkbox IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,report.getReportNo_DD());
		webdriverutility.validation(driver,report.getReportNo_DD(),"REPORT NO DD");				
		report.getReportNo_DD().click();
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getReportNo_DDInput());
		webdriverutility.validation(driver,report.getReportNo_DDInput(),"REPORTNO DD INPUT");
		
		String repo = "UT_22";
		
		report.getReportNo_DDInput().sendKeys(repo);
		Thread.sleep(500);
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getReportNo_AddNewItem());
		webdriverutility.validation(driver,report.getReportNo_AddNewItem(),"REPORT ADD NEW ITEM");				
		report.getReportNo_AddNewItem().click();
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getReportNo_DDInput());			
		report.getReportNo_DDInput().sendKeys(Keys.ENTER);
	
		webdriverutility.ClickableElement(driver,report.getUTReportDetailsOK_BTN());
		webdriverutility.validation(driver,report.getUTReportDetailsOK_BTN(),"REPORT OK BTN");				
		report.getUTReportDetailsOK_BTN().click();
		Reporter.log("REPORTDETAILS OK IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getCretionUTRDFile_BTN());
		webdriverutility.validation(driver,report.getCretionUTRDFile_BTN(),"REPORT FILE BTN");				
		report.getCretionUTRDFile_BTN().click();
		Reporter.log("REPORTDETAILS FILE IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getObservationUTRD_DDTXT());
		webdriverutility.validation(driver,report.getObservationUTRD_DDTXT(),"OBSERVATION DDTXT");				
		report.getObservationUTRD_DDTXT().sendKeys("A-Accepted"+Keys.ENTER);
		Reporter.log("OBSERVATION FILE IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,report.getFileUTOK_BTN());
		webdriverutility.validation(driver,report.getFileUTOK_BTN(),"RTOK BTN");				
		report.getFileUTOK_BTN().click();
		Reporter.log("UT OK BTN IS FUNCTIONING PROPERLY",true);
		
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
		Reporter.log("COMPRESSION SAVE BTN IS FUNCTIONING PROPERLY",true);
	
		Reporter.log("DATA SAVED SUCCESSFULLY IS DISPLAYED",report.getDataSavedSuccessfully_POPUP().isDisplayed());
		
		report.getDataSaveSuccessfully_POPUPClose().click();
		
		Reporter.log("ALL GOOD",true);
		
//		
		
		Thread.sleep(1000);
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		webdriverutility.ClickableElement(driver,sidebar.getUTViewModifyReport_Sidebar());
		webdriverutility.validation(driver,sidebar.getUTViewModifyReport_Sidebar(),
				"UT TEST REPORT MODIFY");				
		sidebar.getUTViewModifyReport_Sidebar().click();
		Reporter.log("UT REPORT MODIFY SIDEBAR is FUNCTIONING PROPERLY ",true);

		TestSpoolmanNDT_ModifyReportUT modifyUT = new TestSpoolmanNDT_ModifyReportUT(driver);
		
		webdriverutility.ClickableElement(driver,modifyUT.getSelectionEdit_BTN());
		webdriverutility.validation(driver,modifyUT.getSelectionEdit_BTN(),
				"MODIFY SELECTION EDIT");				
		modifyUT.getSelectionEdit_BTN().click();
		Reporter.log("UT REPORT MODIFY SELECTION EDIT is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,modifyUT.getReportNo3Dots());
		webdriverutility.validation(driver,modifyUT.getReportNo3Dots(),
				"REPORT NO. 3 DOTS");				
		modifyUT.getReportNo3Dots().click();
		Reporter.log("REPORT NO 3 DOTS is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,modifyUT.getFunnelFilter());
		webdriverutility.validation(driver,modifyUT.getFunnelFilter(),"3 DOTS FILTER BTN");						
		modifyUT.getFunnelFilter().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",modifyUT.getFilterValue().isDisplayed());
		
		Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,modifyUT.getFilterValue());
		modifyUT.getFilterValue().sendKeys(repo);
				
		webdriverutility.ClickableElement(driver,modifyUT.getFFFilter_BTN());
		webdriverutility.validation(driver,modifyUT.getFFFilter_BTN(),"FILTER BTN");						
		modifyUT.getFFFilter_BTN().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",modifyUT.getFilterValue().isDisplayed());

		webdriverutility.ClickableElement(driver,modifyUT.getSelect1stRow());
		webdriverutility.validation(driver,modifyUT.getSelect1stRow(),"REPORT CHECKBOX");						
		modifyUT.getSelect1stRow().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,modifyUT.getCreationEdit_BTN());
		webdriverutility.validation(driver,modifyUT.getCreationEdit_BTN(),"CREATION EDIT BTN");						
		modifyUT.getCreationEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);

		HashMap<String, String> hm1 = new HashMap<String, String>();

		for (int i = 0; i < modifyUT.getModifySpoolNoList().size(); i++) 
		{
		    String spoolNo = modifyUT.getModifySpoolNoList().get(i).getText();
		    String jointNo = modifyUT.getModifyJointNoList().get(i).getText();
		    
		    hm1.put(spoolNo, jointNo);
		    
		    Reporter.log("Spool No: " + spoolNo + " - Joint No: " + jointNo, true);
		}		

		Reporter.log("SPOOLS AND JOINTS ARE MATCHED "+ ListUtility.areMapsEqual(hm, hm1) ,true);
		
//		Assert.assertTrue(hm.equals(hm1),"NO. OF SPOOLS ARE NOT SAME");
		
	}

}


