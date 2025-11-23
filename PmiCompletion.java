package spoolman.Production;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.sisu.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pcpl.genericutility.AllureListener;
import com.pcpl.genericutility.AllureUtil;
import com.pcpl.genericutility.BaseClass;
import com.pcpl.genericutility.FileUtility;
import com.pcpl.genericutility.ListUtility;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import testPgoldLogin.LoginTest;
import util_main.ManagerClass;

@Description("THIS IS THE SCRIPT FOR ")
@Listeners({ AllureListener.class })
@Test(/*timeOut = 500000*/ priority = 2)

public class PmiCompletion extends BaseClass{
	
	public Integer x =1;
	
	@Epic("Epic 1")
	@Feature("Feature :01 -- FRONT RELEASE")
	@Story("Story -- FRONT RELEASE ")
	@Severity(SeverityLevel.CRITICAL)

	public void pmiAll() throws Throwable {
		
// 		IMPLICIT WAIT		
		webdriverutility.implicitWait(driver);

		// LOGIN TEST...
		LoginTest.Logintest();

		//USING MANAGER CLASS...
		ManagerClass mg = new ManagerClass(driver);
		
		webdriverutility.ClickableElement(driver, mg.getHomePage().getSpoolmanErman());
		mg.js.executeScript("arguments[0].scrollIntoView(true);", mg.getHomePage().getSpoolmanErman());
		webdriverutility.validation(driver, mg.getHomePage().getSpoolmanErman(), "SPOOLMAN");
		mg.getHomePage().getSpoolmanErman().click();

//		TestSpool_EnggInput engg = new TestSpool_EnggInput(driver);
//		System.out.println("ENGG. INPUT page is displayed");

		Thread.sleep(500);

		for (WebElement project :  mg.sm.getOnGoingProjectList()) {

			if (project.getText().equals(FileUtility.readCommonData("project"))) {
				project.click();
				break;
			}

		}

		Reporter.log("PROJECT IS GETTING SELECTED ", true);

		// 9DOTS
		webdriverutility.ClickableElement(driver, mg.sm.getNineDotMenu_BTN());
		webdriverutility.validation(driver,  mg.sm.getNineDotMenu_BTN(), "9 DOT MENU");
		mg.sm.getNineDotMenu_BTN().click();
		Reporter.log("NINEDOT MENU is FUNCTIONING PROPERLY ",  mg.sm.getProjectFr9DotMenu().isDisplayed());
	
		// PROJECT TAB 9 DOTS MENU...
		webdriverutility.ClickableElement(driver,mg.sm.getProjectFr9DotMenu());
		webdriverutility.validation(driver, mg.sm.getProjectFr9DotMenu(), "PROJECT.");
		mg.sm.getProjectFr9DotMenu().click();
		Reporter.log("NINEDOT MENU PROJECT is FUNCTIONING PROPERLY ", mg.sm.getProduction_BTN().isDisplayed());

		// PRODUCTION IN PROJECT
		webdriverutility.ClickableElement(driver, mg.sm.getProduction_BTN());
		webdriverutility.validation(driver, mg.sm.getProduction_BTN(), "PRODUCTION");
		mg.sm.getProduction_BTN().click();
		Reporter.log("PRODUCTION is FUNCTIONING PROPERLY ", mg.sm.getPrFitupCompletion().isDisplayed());

		// FITUP
		webdriverutility.ClickableElement(driver, mg.sm.getPrPMICompletion());
		webdriverutility.validation(driver, mg.sm.getPrPMICompletion(), "FitUp Completion");
		mg.sm.getPrPMICompletion().click();
		Reporter.log("FITUP COMPLETION is FUNCTIONING PROPERLY ",mg.sm.getPrPMICompletion().isDisplayed());
		
		
		// WAIT...
		webdriverutility.waitplease(driver, mg.wait.getPleaseWaitModal(), mg.wait.getProgressBar());

		String spool = "A11B-URH1112-01-SP04";
				//1103A-P-110129-02-SP01"
		
		
		//VALIDATING IF THE DATA IS PRESENT IN PMI REPORT...
		//filter 3dots
		webdriverutility.MultipleFilter3Dots(driver,mg.pmiprod.getSelectionSpoolNo_3Dots(), spool);
		
		//FILTER VAL
		mg.csa.assertTrue(webdriverutility.FilterVal(driver,mg.pmiprod.getSelectionSpoolNo_List(), spool),
				"!!!ISSUE...DATA IS NOT SHOWING IN PMI REPORTS...");
		
		//have to validate filter spool firse val karna hai filtered spools in creaiton like selecteed creation me aata hai ki ni like hashmap use karke
//		// ON FITUP SELECTION MAP OF SPOOL NAME LIST AND JOITN NO LIST...
//		HashMap<String, String> hm = ListUtility.ToItterateList(fc.getSelection_SpoolNameList(),
//				fc.getSelection_JointNoList());

		
//		//FILTER CLEAR
//		webdriverutility.MultipleFilter3DotsClear(driver,mg.pmiprod.getSelectionSpoolNo_3Dots());
		
		//SECECTION WINDOW EDIT
		webdriverutility.ClickableElement(driver, mg.pmiprod.getSelectionWindowEdit_BTN());
		webdriverutility.validation(driver, mg.pmiprod.getSelectionWindowEdit_BTN(), "SLECTION EDIT BTN");
		mg.pmiprod.getSelectionWindowEdit_BTN().click();
		Reporter.log("SELECTION EDIT BTN is FUNCTIONING PROPERLY",
		mg.pmiprod.getSelectionColumnSetting_BTN().isDisplayed());
		
		//SELECT ALL CHECKBOX...
		webdriverutility.ClickableElement(driver, mg.pmiprod.getSelectAllRow());
		webdriverutility.validation(driver, mg.pmiprod.getSelectAllRow(), "SELECT ALL CHECKBOX");
		mg.pmiprod.getSelectAllRow().click();
		Reporter.log("SELECT ALL ROW CHECKBOX is FUNCTIONING PROPERLY ", true);

		//CUSTO ASSERT FOR SPOOL LIST VAL ON SELECTION AND CREATION WINDOW...
		mg.csa.assertTrue(mg.list.ListValidation(mg.pmiprod.getSelectionSpoolNo_List(),mg.pmiprod.getCreationSpoolNo_List()),
				"!!!ISSUE...ON PMI REPORT SELECTION SELECTED ARE NOT SHOWN ON CREATION WINDOW...");
		
		//CREATION WINDOW...
		webdriverutility.ClickableElement(driver, mg.pmiprod.getCreationWindowEdit_BTN());
		webdriverutility.validation(driver, mg.pmiprod.getCreationWindowEdit_BTN(), "CREATION EDIT");
		mg.pmiprod.getCreationWindowEdit_BTN().click();
		Reporter.log("CREATION WINDOW EDIT is FUNCTIONING PROPERLY ", true);

		//REPORT DETAIL ...
		webdriverutility.ClickableElement(driver, mg.pmiprod.getReportDetails_BTN());
		webdriverutility.validation(driver, mg.pmiprod.getReportDetails_BTN(), "PMI REPORT DETAILS");
		mg.pmiprod.getReportDetails_BTN().click();
		Reporter.log("REPORT DETAILS is FUNCTIONING PROPERLY ", true);

		Thread.sleep(500);

		//AUTOGENERATE REPORT 
		webdriverutility.ClickableElement(driver, mg.pmiprod.getAutoGenrateReport_CHECKBOX());
		webdriverutility.validation(driver, mg.pmiprod.getAutoGenrateReport_CHECKBOX(), "AUTO GEN CHECKBOX");
		mg.pmiprod.getAutoGenrateReport_CHECKBOX().click();
		Reporter.log(" AUTOGENERATE REPORT DETAILS CHECKBOX is FUNCTIONING PROPERLY ", true);

		//PMI REPORT NO ...
		webdriverutility.ClickableElement(driver, mg.pmiprod.getPMIReportNo_DD());
		webdriverutility.validation(driver, mg.pmiprod.getPMIReportNo_DD(), "REPORT NO. DD");
		mg.pmiprod.getPMIReportNo_DD().click();
		Reporter.log("REPORT NO DD is FUNCTIONING PROPERLY ", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, mg.pmiprod.getPMIReportNo_Input());
		webdriverutility.validation(driver, mg.pmiprod.getPMIReportNo_Input(), "REPORT NO. INPUT");

//		WEB
//		String pmireportno = "RNO_48";
		
//		SETUP
		String pmireportno = "RNO_" + x;

//		String test123 = "Test@1234";

		mg.pmiprod.getPMIReportNo_Input().sendKeys(pmireportno);
		Reporter.log("REPORT NO DD INPUT is FUNCTIONING PROPERLY ", true);
		Thread.sleep(500);
		webdriverutility.ClickableElement(driver, mg.pmiprod.getPMIReportNo_AddBTN());
		webdriverutility.validation(driver, mg.pmiprod.getPMIReportNo_AddBTN(), "REPORT NO. ADD BTN");
		mg.pmiprod.getPMIReportNo_AddBTN().click();
		Reporter.log("REPORT NO ADD is FUNCTIONING PROPERLY ", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, mg.pmiprod.getPMIReportNo_Input());
		mg.pmiprod.getPMIReportNo_Input().sendKeys(Keys.ENTER);

//		webdriverutility.ClickableElement(driver,mg.pmiprod.getAssignWorkFlow_INPUT());
//		webdriverutility.textConfirmation(driver,mg.pmiprod.getAssignWorkFlow_INPUT(),"Workflow_03","Assign Work Flow");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getPMIAgency_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getPMIAgency_INPUT(), "Test@1234", "PMI AGENCY");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getInspectionAgency_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getInspectionAgency_INPUT(), "Test@1234",
				"INSPECTION AGENCY");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getPMIEquipmentNo());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getPMIEquipmentNo(), "Test@1234", "PMI EQUIPMENT NO.");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getSerialNo_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getSerialNo_INPUT(), "Test@1234", "Serial No.");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getCR_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getCR_INPUT(), "Test@1234", "CR No.");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getMO_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getMO_INPUT(), "Test@1234", "MO No.");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getNI_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getNI_INPUT(), "Test@1234", "NI No.");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getMN_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getMN_INPUT(), "Test@1234", "MN No.");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getNB_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getNB_INPUT(), "Test@1234", "NB No.");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getTI_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getTI_INPUT(), "Test@1234", "TI No.");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getV_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getV_INPUT(), "Test@1234", "V No.");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getFE_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getFE_INPUT(), "Test@1234", "FE No.");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getTechnique_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getTechnique_INPUT(), "Test@1234", "TECHNIQUE");

		webdriverutility.ClickableElement(driver, mg.pmiprod.getShopLocation_INPUT());
		webdriverutility.textConfirmation(driver, mg.pmiprod.getShopLocation_INPUT(), "Test@1234", "SHOP LOCATION ");

//		webdriverutility.ClickableElement(driver,mg.pmiprod.getClose_BTN());
//		mg.pmiprod.getClose_BTN().click();

		webdriverutility.ClickableElement(driver, mg.pmiprod.getPMIReportSave_BTN());
		webdriverutility.validation(driver, mg.pmiprod.getPMIReportSave_BTN(), "PMI REPORT SAVE BTN");
		mg.pmiprod.getPMIReportSave_BTN().click();
		Reporter.log("PMI REPORT SAVE BTN SAVE is FUNCTIONING PROPERLY ", true);
		
		//scrolling to PMI OBSERVATION
		Thread.sleep(1000);
		mg.js.executeScript("arguments[0].scrollIntoView(true);",mg.pmiprod.getPMIFitUpObservation_Col());
		
		//ACCEPTING ALL THE OBSERVATION
		for (WebElement field :mg.pmiprod.getPMIFitUpObservation_Fields()) {
			
			field.click();
			webdriverutility.ClickableElement(driver, mg.pmiprod.getPMIFitUpObservation_Input());
			mg.pmiprod.getPMIFitUpObservation_Input().click();
			webdriverutility.ClickableElement(driver, mg.pmiprod.getObs_Accepted());
			mg.pmiprod.getObs_Accepted().click();
			
		}
		
		
		webdriverutility.ClickableElement(driver, mg.pmiprod.getCreationSave_BTN());
		webdriverutility.validation(driver, mg.pmiprod.getCreationSave_BTN(), "CREATION SAVE BTN");
		mg.pmiprod.getCreationSave_BTN().click();
		Reporter.log("CREATION SAVE BTN SAVE is FUNCTIONING PROPERLY ", true);

		// POPUP VAL
		webdriverutility.popupVal(driver);
		
		// Step 1: Store the current URL
		String currentURL = driver.getCurrentUrl();
		
		// Step 2: Open a new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(currentURL);  // Load the current URL in the new tab
		
		// Step 3: Get the window handles
		Set<String> browserList = driver.getWindowHandles();
		String currentBrowser = driver.getWindowHandle();  // Store the original tab's handle

//		// Step 4: Switch to the new tab
//		for (String browser : browserList) {
//		    if (!browser.equals(currentBrowser)) {  // Find the new tab
//		        driver.switchTo().window(browser);  // Switch to the new tab
//		        break;  // Exit the loop once the new tab is found
//		    }
//		}
//		
//		// Step 6: Close the original tab (current tab)
//		driver.switchTo().window(currentBrowser);  // Switch back to the original tab (the one you want to close)
//		driver.close();  // Close the original tab
//
//		// Step 7: Switch back to the new tab to continue operations
//		Set<String> remainingTabs = driver.getWindowHandles();  // Get the remaining tab handles
//		for (String tab : remainingTabs) {
//		    if (!tab.equals(currentBrowser)) {  // Switch to the remaining tab (new one)
//		        driver.switchTo().window(tab);
//		        break;  // Exit the loop once we switch to the new tab
//		    }
//		}
	
		
//		//refresh
//		driver.navigate().refresh();

		// WAIT
		webdriverutility.waitplease(driver,mg.wait.getPleaseWaitModal(), mg.wait.getProgressBar());

		webdriverutility.ClickableElement(driver,mg.getHomePage().getExpandSidebar());
		mg.getHomePage().getExpandSidebar().click();

		webdriverutility.ClickableElement(driver, mg.prodSidebar.getViewModifyPMI_SideBar());
		webdriverutility.validation(driver,  mg.prodSidebar.getViewModifyPMI_SideBar(), "VIEW MODIFY PMI SIDEBAR BTN");
		 mg.prodSidebar.getViewModifyPMI_SideBar().click();
		Reporter.log("VIEW MODIFY SIDEBAR is FUNCTIONING PROPERLY ", true);

		Thread.sleep(500);

		// WAIT
		webdriverutility.waitplease(driver, mg.wait.getPleaseWaitModal(), mg.wait.getProgressBar());

		// SIDEBAR EXPAND...
		webdriverutility.ClickableElement(driver, mg.getHomePage().getExpandSidebar());
		 mg.getHomePage().getExpandSidebar().click();

//		// MODIFY OBJECT
//		TestSpoolman_PMIModify Modify = new TestSpoolman_PMIModify(driver);

		// MAIN EDIT
		webdriverutility.ClickableElement(driver, mg.pmiMod.getMainEdit_BTN());
		webdriverutility.validation(driver, mg.pmiMod.getMainEdit_BTN(), "EDIT");
		mg.pmiMod.getMainEdit_BTN().click();
		Reporter.log("EDIT BTN is FUNCTIONING PROPERLY ", true);

		webdriverutility.jsWait(driver);
//		webdriverutility.visibilityOfElement(driver,mg.pmiMod.getMasterDetails());
		mg.js.executeScript("arguments[0].scrollIntoView(true);", mg.pmiMod.getMasterDetails());
		
//		mg.act.moveToElement( mg.pmiMod.getMasterDetails()).perform();

		webdriverutility.ClickableElement(driver,mg.pmiMod.getMainEdit_BTN());
		mg.pmiMod.getMasterDetails().click();
		
//		Thread.sleep(3000);
//		
//		webdriverutility.ClickableElement(driver,mg.pmiMod.getMasterDetailsClose_BTN());
//		webdriverutility.validation(driver,mg.pmiMod.getMasterDetailsClose_BTN(),"CLOSE");											
//		mg.pmiMod.getMasterDetailsClose_BTN().click();
//		Reporter.log("MASTER CLOSE BTN is FUNCTIONING PROPERLY ",true);

		//FILTER 3DOTS
		webdriverutility.MultipleFilter3Dots(driver,mg.pmiMod.getSpoolNo3Dots(), spool);
		
		//FILTER VAL
		webdriverutility.FilterVal(driver,mg.pmiMod.getSpoolNo_List(), spool);
		
		//FILTER 3DOTS
		webdriverutility.MultipleFilter3Dots(driver,mg.pmiMod.getPMIObservatios3Dots(),"Accepted");
		
		//FILTER VAL
		webdriverutility.FilterVal(driver,mg.pmiMod.getSpoolNo_List(), "Accepted");
		
		//allure log
		AllureUtil.attachText("PMI VIEW MODIFY", spool+" is present ");
		
		//REJECTING ALL THE OBSERVATION
		for (WebElement obs :mg.pmiMod.getPMIobsList()) {
			
			obs.click();
			webdriverutility.ClickableElement(driver, mg.pmiMod.getPMIobsList_DD());
			mg.pmiMod.getPMIobsList_DD().click();
//			Thread.sleep(700);
			webdriverutility.ClickableElement(driver, mg.pmiMod.getPMIobs_Rejected());
			mg.pmiMod.getPMIobs_Rejected().click();
			
		}		
				
		//SELECT ALL...
		webdriverutility.ClickableElement(driver, mg.pmiMod.getSelectAllRows_Checkbox());
		webdriverutility.validation(driver, mg.pmiMod.getSelectAllRows_Checkbox(), "CLOSE");
		mg.pmiMod.getSelectAllRows_Checkbox().click();
		Reporter.log("SELECT ALL ROWS CHECKBOX is FUNCTIONING PROPERLY ", true);

		//SAVE...
		webdriverutility.ClickableElement(driver, mg.pmiMod.getMainSave_BTN());
		webdriverutility.validation(driver, mg.pmiMod.getMainSave_BTN(), "CLOSE");
		mg.pmiMod.getMainSave_BTN().click();
		Reporter.log("MASTER CLOSE BTN is FUNCTIONING PROPERLY ", true);

		// POPUP VAL
		webdriverutility.popupVal(driver);
		
		// Step 1: Store the current URL
		String curURL = driver.getCurrentUrl();
		
		// Step 2: Open a new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(curURL);  // Load the current URL in the new tab
		
		// Step 3: Get the window handles
		Set<String> NewbrowserList = driver.getWindowHandles();
		String curBrowser = driver.getWindowHandle();  // Store the original tab's handle
		
		//comment
		for(String here:NewbrowserList) {
			if(!here.equals(curBrowser)) {
				driver.switchTo();
			}
		}
		
		// WAIT
//		webdriverutility.waitplease(driver, mg.wait.getPleaseWaitModal(), mg.wait.getProgressBar());
		webdriverutility.waitForProgressToDiss(driver,mg.wait.getProgressBar());
	
		webdriverutility.ClickableElement(driver,mg.getHomePage().getExpandSidebar());
		mg.getHomePage().getExpandSidebar().click();

		webdriverutility.ClickableElement(driver, mg.prodSidebar.getPMICompletion_SideBar());
		mg.prodSidebar.getPMICompletion_SideBar().click();
			
		webdriverutility.ClickableElement(driver, mg.prodSidebar.getPMIReport_SideBar());
		mg.prodSidebar.getPMIReport_SideBar().click();

		// WAIT
//		webdriverutility.waitplease(driver, mg.wait.getPleaseWaitModal(), mg.wait.getProgressBar());
		webdriverutility.waitForProgressToDiss(driver,mg.wait.getProgressBar());

		//comment
		webdriverutility.ClickableElement(driver,mg.spoolutil.getEdit_BTN());
		mg.spoolutil.getEdit_BTN().click();
		
		//filter 3dots
		webdriverutility.MultipleFilter3Dots(driver,mg.pmiprod.getSelectionSpoolNo_3Dots(), spool);
		
		//comment
		webdriverutility.ClickableElement(driver,mg.spoolutil.getExpand());
		mg.spoolutil.getExpand().click();
		
		//FILTER VAL
		mg.csa.assertTrue(webdriverutility.FilterVal(driver,mg.pmiprod.getSelectionSpoolNo_List(), spool),
				"!!!ISSUE...DATA IS NOT SHOWING IN PMI REPORTS...");
		
		driver.close();
		
		Reporter.log("all good", true);

		/*
		 * INTEGRATION CHECK
		 */

//		//PGOLD HOME ...
//		webdriverutility.ClickableElement(driver, mg.getHomePage().getPGOLDHome_BTN());
//		webdriverutility.validation(driver, mg.getHomePage().getPGOLDHome_BTN(), "HOME BTN");
//		mg.getHomePage().getPGOLDHome_BTN().click();
//		Reporter.log(" PGOLD Home BTN IS FUNCTIONING PROPERLY ", true);
//
//		//SPOOLMAN ERMAN ...
//		webdriverutility.ClickableElement(driver, mg.getHomePage().getSpoolmanErman());
//		webdriverutility.validation(driver, mg.getHomePage().getSpoolmanErman(), "SPOOLMAN");
//		mg.getHomePage().getSpoolmanErman().click();
//		Reporter.log("SPOOLMAN-ERMAN is displayed and true", true);
//
//		Thread.sleep(500);
//
//		//PROJECT SELCTION...
//		for (WebElement project : mg.sm.getOnGoingProjectList()) {
//
//			if (project.getText().equals(FileUtility.readCommonData("project"))) {
//				project.click();
//				break;
//			}
//
//		}
//
//		Reporter.log("PROJECT IS GETTING SELECTED ", true);
//
//		//9DOTS CLICK...
//		webdriverutility.ClickableElement(driver, mg.sm.getNineDotMenu_BTN());
//		webdriverutility.validation(driver, mg.sm.getNineDotMenu_BTN(), "9 DOT MENU");
//		mg.sm.getNineDotMenu_BTN().click();
//		Reporter.log("NINEDOT MENU is FUNCTIONING PROPERLY ", mg.sm.getProjectFr9DotMenu().isDisplayed());
//
//		//PROJECT IN 9DOTS
//		webdriverutility.ClickableElement(driver, mg.sm.getProjectFr9DotMenu());
//		webdriverutility.validation(driver, mg.sm.getProjectFr9DotMenu(), "PROJECT.");
//		mg.sm.getProjectFr9DotMenu().click();
//		Reporter.log("NINEDOT MENU PROJECT is FUNCTIONING PROPERLY ", mg.sm.getProduction_BTN().isDisplayed());
//
//		//WELDING ...
//		webdriverutility.ClickableElement(driver, mg.sm.getWelding_BTN());
//		webdriverutility.validation(driver, mg.sm.getWelding_BTN(), "WELDING BTN");
//		mg.sm.getWelding_BTN().click();
//		Reporter.log("WELDING BTN is FUNCTIONING PROPERLY ", mg.sm.getWeldingMaster().isDisplayed());
//
//		//WELDING MASTER
//		webdriverutility.ClickableElement(driver, mg.sm.getWeldingMaster());
//		webdriverutility.validation(driver, mg.sm.getWeldingMaster(), "WELDING MASTER");
//		mg.sm.getWeldingMaster().click();
//		Reporter.log("WELDING MASTER is FUNCTIONING PROPERLY ", true);
//
////		//WPS OBJECT...
////		TestSpoolman_WeldingWPSDetails wps = new TestSpoolman_WeldingWPSDetails(driver);
//
//		//SIDEBAR EXPAND
//		webdriverutility.ClickableElement(driver, mg.getHomePage().getExpandSidebar());
//		mg.getHomePage().getExpandSidebar().click();
//
////		TestSpoolman_WeldingSideBar Sidebar = new TestSpoolman_WeldingSideBar(driver);
//
////		//REPORT OBJECT...
////		TestSpoolman_WCWVIReport report = new TestSpoolman_WCWVIReport(driver);
//
//		//WELDING COMPLETION
//		webdriverutility.ClickableElement(driver, mg.weldSidebar.getWPStoSpec_Sidebar());
//		webdriverutility.validation(driver, mg.weldSidebar.getWPStoSpec_Sidebar(), "WELDING COMPLETION");
//		mg.weldSidebar.getWeldingCompletion_Sidebar().click();
//		Reporter.log("WELDING COMPLETION IS FUNCTIONING PROPERLY", mg.weldSidebar.getWCWVIReport_Sidebar().isDisplayed());
//
//		//WCWVI REPORT...
//		webdriverutility.ClickableElement(driver, mg.weldSidebar.getWCWVIReport_Sidebar());
//		webdriverutility.validation(driver, mg.weldSidebar.getWCWVIReport_Sidebar(), "WC REPORT ");
//		mg.weldSidebar.getWCWVIReport_Sidebar().click();
//		Reporter.log("WC WVIREPORT IS FUNCTIONING PROPERLY", mg.wcWVI_Report.getCreationWindowEdit_BTN().isDisplayed());
//
//		webdriverutility.ClickableElement(driver, mg.wcWVI_Report.getSelectionWindowEdit_BTN());
//		webdriverutility.validation(driver, mg.wcWVI_Report.getSelectionWindowEdit_BTN(), "SELECTION EDIT BTN");
//		Thread.sleep(3000);
//		mg.wcWVI_Report.getSelectionWindowEdit_BTN().click();
//		Reporter.log("SELECTION EDIT BTN IS FUNCTIONING PROPERLY",
//				mg.wcWVI_Report.getSelectionSelectAll_CHECKBOX().isDisplayed());
//
////		webdriverutility.ClickableElement(driver, report.getSpoolNo3Dots());
////		webdriverutility.validation(driver, report.getSpoolNo3Dots(), "SELECTION EDIT 3DOTS");
////		report.getSpoolNo3Dots().click();
////		Reporter.log("SELECTION EDIT 3dots BTN IS FUNCTIONING PROPERLY", report.getFilter_BTN().isDisplayed());
////
////		Thread.sleep(500);
////
////		webdriverutility.ClickableElement(driver, report.getFunnelFilter());
////		webdriverutility.validation(driver, report.getFunnelFilter(), "3 DOTS FILTER BTN");
////		report.getFunnelFilter().click();
////		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY", report.getFilterValue().isDisplayed());
////
////		Thread.sleep(500);
////
////		webdriverutility.ClickableElement(driver, report.getFilterValue());
////		report.getFilterValue().sendKeys(spool);
////
////		webdriverutility.ClickableElement(driver, report.getFFFilter_BTN());
////		webdriverutility.validation(driver, report.getFFFilter_BTN(), "FILTER BTN");
////		report.getFFFilter_BTN().click();
////		Reporter.log("FILTER BTN IS FUNCTIONING PROPERLY", report.getFilterValue().isDisplayed());
//
//		//FILTER 3DOTS
//		webdriverutility.MultipleFilter3Dots(driver,mg.wcWVI_Report.getSpoolNo3Dots(), spool);
//		
//		webdriverutility.ClickableElement(driver, mg.wcWVI_Report.getSelectionFullscrean_BTN());
//		webdriverutility.validation(driver, mg.wcWVI_Report.getSelectionFullscrean_BTN(), "FILTER BTN");
//		mg.wcWVI_Report.getSelectionFullscrean_BTN().click();
//		Reporter.log("SELECTION FULLSCREEN IS FUNCTIONING PROPERLY", mg.wcWVI_Report.getFilterValue().isDisplayed());
//
////		for (WebElement spoolNo : report.getSpoolNoToVerifyList()) {
////
////			Assert.assertTrue(spool.equals(spoolNo.getText()), "SPOOL DID NOT GET RELEASED");
////
////			Reporter.log((spoolNo.getText() + " spool got displayed "), true);
////
////		}
//		
//		//FILTER VAL
//		webdriverutility.FilterVal(driver,mg.wcWVI_Report.getSpoolNoToVerifyList(), spool);
//
//		mg.csa.assertAll();
//
//		Reporter.log("SPOOL IS PRESENT IN WELDING REPORT", true);
//
//		Reporter.log("all good... PROBLEM wo hota kya he re pagle", true);
		
		x++;
	}
}
