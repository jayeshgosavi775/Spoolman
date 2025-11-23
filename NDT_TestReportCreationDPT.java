/**
 * AUTHOR - PUNIT MORE
 * DATE - 25-01-2024;
 * DESC - PGOLD-->SPOOLMAN-->SELECT PROJECT-->NDT/QAQC-->TEST REPORT OFFERING-->DPT REPORT
 * SCRIPT...
 * UPDATED - 
 */


package spoolman.Ndt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
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
import com.pcpl.spoolman.ndt.reportcreation.TestSpoolmanNDT_TestReportDPT;
import com.pcpl.spoolman.ndt.reportmodify.TestSpoolmanNDT_ModifyReportDPT;
import com.pcpl.spoolman.ndt.reportmodify.TestSpoolmanNDT_ModifyReportRT;

public class NDT_TestReportCreationDPT extends BaseClass {

	@Test
	public void NDT_DPTReportAll() throws Throwable {
		
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
		
		TestSpoolmanNDT_TestReportDPT report = new TestSpoolmanNDT_TestReportDPT(driver);
		
		webdriverutility.ClickableElement(driver,sidebar.getDPTReport_Sidebar());
		webdriverutility.validation(driver,sidebar.getDPTReport_Sidebar(),
				"DPT REPORT SIDEBAR");				
		sidebar.getDPTReport_Sidebar().click();
		Reporter.log("DPT REPORT SIDEBAR LIST is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();
			
		Reporter.log("TOTAL NO OF RECORDS SELECTOIN "+report.getSelectionTotalRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF RECORDS CREATION "+report.getCreationTotalRecords().getText(),true);		
		
		webdriverutility.ClickableElement(driver,report.getSelectionEdit_BTN());
		webdriverutility.validation(driver,report.getSelectionEdit_BTN(),"SELECTION EDIT BTN");				
		report.getSelectionEdit_BTN().click();
		Reporter.log("SELECTION EDIT is FUNCTIONING PROPERLY ",true);
		
		act.moveByOffset(15,15).perform();;
				
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
		
		String spool = "1103R-P-130250-08-SP06";
		
		webdriverutility.ClickableElement(driver,report.getFilterValue());
		report.getFilterValue().sendKeys(spool);
				
		webdriverutility.ClickableElement(driver,report.getFFFilter_BTN());
		webdriverutility.validation(driver,report.getFFFilter_BTN(),"FILTER BTN");						
		report.getFFFilter_BTN().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",report.getFilterValue().isDisplayed());
		
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
		
//		webdriverutility.ClickableElement(driver,report.getCreationEdit_BTN());
//		webdriverutility.validation(driver,report.getCreationEdit_BTN(),"CREATION EDIT");				
//		report.getCreationEdit_BTN().click();
//		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);
		
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
		
		String dpt = "DPT_O1";
		
		report.getReportNo_DDInput().sendKeys(dpt);
		Thread.sleep(500);
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getReportNo_AddNewItem());
		webdriverutility.validation(driver,report.getReportNo_AddNewItem(),"REPORT ADD NEW ITEM");				
		report.getReportNo_AddNewItem().click();
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY",true);
		
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getReportNo_DDInput());			
		report.getReportNo_DDInput().sendKeys(Keys.ENTER);
	
		webdriverutility.ClickableElement(driver,report.getDPTReportDetailsOK_BTN());
		webdriverutility.validation(driver,report.getDPTReportDetailsOK_BTN(),"REPORT OK BTN");				
		report.getDPTReportDetailsOK_BTN().click();
		Reporter.log("REPORTDETAILS OK IS FUNCTIONING PROPERLY",true);
	
		webdriverutility.ClickableElement(driver,report.getCretionDPTRDFile_BTN());
		webdriverutility.validation(driver,report.getCretionDPTRDFile_BTN(),"REPORT FILE BTN");				
		report.getCretionDPTRDFile_BTN().click();
		Reporter.log("REPORTDETAILS FILE IS FUNCTIONING PROPERLY",true);
	
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,report.getObservationDPTRD_DDTXT());
		webdriverutility.validation(driver,report.getObservationDPTRD_DDTXT(),"OBSERVATION DDTXT");				
		report.getObservationDPTRD_DDTXT().sendKeys("A-Accepted"+Keys.ENTER);
		Reporter.log("OBSERVATION FILE IS FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,report.getFileUTOK_BTN());
		webdriverutility.validation(driver,report.getFileUTOK_BTN(),"DPTOK BTN");				
		report.getFileUTOK_BTN().click();
		Reporter.log("UT OK BTN IS FUNCTIONING PROPERLY",true);
		
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
	
		Reporter.log("Please Select Root/Final DISPLAYED",report.getPleaseSelectRootFinal_POPUP().isDisplayed());
		
		report.getPleaseSelectRootFinal_POPUPClose().click();
		
		js.executeScript("arguments[0].scrollIntoView(true);",report.getRootOrFinal_Col());	
		
		
		for (WebElement root : report.getRootOrFinal_TDList()) {
		    if (root.isDisplayed()) 
		    {
		    Thread.sleep(300);
		    root.click();
		
			Thread.sleep(500);
			act.click(root);
			
			webdriverutility.ClickableElement(driver,report.getRootOrFinal_DD());
			webdriverutility.validation(driver,report.getRootOrFinal_DD(),"ROOT OR FINAL DD");				
			report.getRootOrFinal_DD().click();
			Reporter.log("ROOT OR FINAL IS FUNCTIONING PROPERLY",true);
			
			Thread.sleep(500);
				
			List<String> expectedOptions = Arrays.asList("Root", "Final", "Root/Final");
			List<WebElement> actualOptions = report.getROOTORFINAL_DDList();
			List<String> actualOptionsText = actualOptions.stream().map(WebElement::getText).collect(Collectors.toList());
			assertArrayEquals(expectedOptions.toArray(), actualOptionsText.toArray());

			webdriverutility.ClickableElement(driver,report.getFinal_dd());
			report.getFinal_dd().click();
			
		    }	
 
		}
		
		Reporter.log("TOTAL NO OF RECORDS SELECTOIN "+report.getSelectionTotalRecords().getText(),true);
		
		Reporter.log("TOTAL NO OF RECORDS CREATION "+report.getCreationTotalRecords().getText(),true);		

		webdriverutility.ClickableElement(driver,report.getCreationSave_BTN());
		webdriverutility.validation(driver,report.getCreationSave_BTN(),"CREATION SAVE BTN");				
		report.getCreationSave_BTN().click();
		Reporter.log("CREATIVE SAVE BTN IS FUNCTIONING PROPERLY",true);
	
		Reporter.log("DATA SAVED SUCCESSFULLY IS DISPLAYED",report.getDataSavedSuccessfully_POPUP().isDisplayed());
		
		report.getDataSaveSuccessfully_POPUPClose().click();
		
		Reporter.log("ALL GOOD",true);
		
		/*
		 * 
		 */
		
		Thread.sleep(1000);
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		webdriverutility.ClickableElement(driver,sidebar.getDPTViewModifyReport_Sidebar());
		webdriverutility.validation(driver,sidebar.getDPTViewModifyReport_Sidebar(),
				"DPT TEST REPORT MODIFY");				
		sidebar.getDPTViewModifyReport_Sidebar().click();
		Reporter.log("DPT REPORT MODIFY SIDEBAR is FUNCTIONING PROPERLY ",true);

		TestSpoolmanNDT_ModifyReportDPT modifyDPT = new TestSpoolmanNDT_ModifyReportDPT(driver);
		
		webdriverutility.ClickableElement(driver,modifyDPT.getSelectionEdit_BTN());
		webdriverutility.validation(driver,modifyDPT.getSelectionEdit_BTN(),
				"MODIFY SELECTION EDIT");				
		modifyDPT.getSelectionEdit_BTN().click();
		Reporter.log("UT REPORT MODIFY SELECTION EDIT is FUNCTIONING PROPERLY ",true);

		webdriverutility.ClickableElement(driver,modifyDPT.getReportNo3Dots());
		webdriverutility.validation(driver,modifyDPT.getReportNo3Dots(),
				"REPORT NO. 3 DOTS");				
		modifyDPT.getReportNo3Dots().click();
		Reporter.log("REPORT NO 3 DOTS is FUNCTIONING PROPERLY ",true);
	
		webdriverutility.ClickableElement(driver,modifyDPT.getFunnelFilter());
		webdriverutility.validation(driver,modifyDPT.getFunnelFilter(),"3 DOTS FILTER BTN");						
		modifyDPT.getFunnelFilter().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",modifyDPT.getFilterValue().isDisplayed());
		
		Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,modifyDPT.getFilterValue());
		modifyDPT.getFilterValue().sendKeys(dpt);
				
		webdriverutility.ClickableElement(driver,modifyDPT.getFFFilter_BTN());
		webdriverutility.validation(driver,modifyDPT.getFFFilter_BTN(),"FILTER BTN");						
		modifyDPT.getFFFilter_BTN().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",modifyDPT.getFilterValue().isDisplayed());

		webdriverutility.ClickableElement(driver,modifyDPT.getSelect1stRow());
		webdriverutility.validation(driver,modifyDPT.getSelect1stRow(),"REPORT CHECKBOX");						
		modifyDPT.getSelect1stRow().click();
		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY",true);

		webdriverutility.ClickableElement(driver,modifyDPT.getCreationEdit_BTN());
		webdriverutility.validation(driver,modifyDPT.getCreationEdit_BTN(),"CREATION EDIT BTN");						
		modifyDPT.getCreationEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN IS FUNCTIONING PROPERLY",true);

		
		webdriverutility.ClickableElement(driver,modifyDPT.getCreationFullscreen_BTN());
		modifyDPT.getCreationFullscreen_BTN().click();
		Thread.sleep(500);
		HashMap<String,String> hm1 = ListUtility.ToItterateList(modifyDPT.getModifySpoolNoList(),
				modifyDPT.getModifyJointNoList());
		
//		webdriverutility.ClickableElement(driver,modifyDPT.getCompress_BTN());
//		webdriverutility.validation(driver,modifyDPT.getCompress_BTN(),"CREATION compress BTN");						
//		modifyDPT.getCompress_BTN().click();
//		Reporter.log("CREATION compress BTN IS FUNCTIONING PROPERLY",true);
		
		Reporter.log("SPOOLS AND JOINTS ARE MATCHED "+ ListUtility.areMapsEqual(hm, hm1) ,true);
	
		Reporter.log("VERY NICEE....",true);

		
	}
	
}
