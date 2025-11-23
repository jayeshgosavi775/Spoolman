/**
 * AUTHOR - PUNIT MORE
 * DATE - 16 -01-2024;
 * DESC - SPOOLMAN-->SELECT PROJECT-->9DOT-->PRODUCT-->FITUP COMPLETION SCRIPT
 * UPDATED - 27-09-2024,PUNIT MORE
 */

package spoolman.Production;

import java.util.HashMap;
import java.util.List;

import org.bouncycastle.math.raw.Mod;
import org.codehaus.stax2.validation.Validatable;
import org.eclipse.sisu.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.collect.Multiset.Entry;
import com.pcpl.genericutility.AllureListener;
import com.pcpl.genericutility.AllureUtil;
import com.pcpl.genericutility.BaseClass;
import com.pcpl.genericutility.Captcha;
import com.pcpl.genericutility.CustomSoftAssert;
import com.pcpl.genericutility.ExcelUtility;
import com.pcpl.genericutility.FileUtility;
import com.pcpl.genericutility.JavaUtility;
import com.pcpl.genericutility.ListUtility;
import com.pcpl.pomrepository.TestPgold_HomePage;
import com.pcpl.pomrepository.TestPgold_SignIn;
import com.pcpl.pomrepository.TestSpoolman_UtilPOM;
import com.pcpl.spoolman.home.TestSpoolman_Home;
import com.pcpl.spoolman.home.TestSpoolman_Wait;
import com.pcpl.spoolman.production.TestSpool_FitupCompletion;
import com.pcpl.spoolman.production.TestSpoolman_PMIModify;
import com.pcpl.spoolman.production.TestSpoolman_PMIReport;
import com.pcpl.spoolman.production.TestSpoolman_ProductionSideBar;
import com.pcpl.spoolman.production.TestSpoolman_fcModiyReport;
import com.pcpl.spoolman.welding.TestSpoolman_WCWVIReport;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingSideBar;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingWPSDetails;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import testPgoldLogin.LoginTest;
import util_main.ManagerClass;

@Description("THIS IS THE SCRIPT FOR ")
@Listeners({ AllureListener.class })
@Test(/*timeOut = 500000*/ priority = 2)
public class FitUp extends BaseClass {

	@Epic("Epic 1")
	@Feature("Feature :01 -- FITUP")
	@Story("Story -- FITUP ")
	@Severity(SeverityLevel.CRITICAL)

	public void fitupALL() throws Throwable {

// 		IMPLICIT WAIT		
		webdriverutility.implicitWait(driver);

		// LOGIN TEST...
		LoginTest.Logintest();

//		HOME PAGE		
		TestPgold_HomePage hp = new TestPgold_HomePage(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Actions act = new Actions(driver);

		TestSpoolman_Wait wait = new TestSpoolman_Wait(driver);

		CustomSoftAssert csa = new CustomSoftAssert(driver);

		ListUtility list = new ListUtility(driver);

		TestSpoolman_UtilPOM spoolutil = new TestSpoolman_UtilPOM(driver);
		
		ManagerClass mg = new ManagerClass(driver);

		webdriverutility.ClickableElement(driver, hp.getSpoolmanErman());
		webdriverutility.validation(driver, hp.getSpoolmanErman(), "EFA_MFA ");
		hp.getSpoolmanErman().click();
		Reporter.log("SPOOLMAN-ERMAN is displayed and true", true);

		TestSpoolman_Home sm = new TestSpoolman_Home(driver);

		Thread.sleep(500);

		for (WebElement project : sm.getOnGoingProjectList()) {

			if (project.getText().equals(FileUtility.readCommonData("project"))) {
				project.click();
				break;
			}

		}

		Reporter.log("PROJECT IS GETTING SELECTED ", true);

		// 9DOTS
		webdriverutility.ClickableElement(driver, sm.getNineDotMenu_BTN());
		webdriverutility.validation(driver, sm.getNineDotMenu_BTN(), "9 DOT MENU");
		sm.getNineDotMenu_BTN().click();
		Reporter.log("NINEDOT MENU is FUNCTIONING PROPERLY ", sm.getProjectFr9DotMenu().isDisplayed());

		// PROJECT TAB 9 DOTS MENU...
		webdriverutility.ClickableElement(driver, sm.getProjectFr9DotMenu());
		webdriverutility.validation(driver, sm.getProjectFr9DotMenu(), "PROJECT.");
		sm.getProjectFr9DotMenu().click();
		Reporter.log("NINEDOT MENU PROJECT is FUNCTIONING PROPERLY ", sm.getProduction_BTN().isDisplayed());

		// PRODUCTION IN PROJECT
		webdriverutility.ClickableElement(driver, sm.getProduction_BTN());
		webdriverutility.validation(driver, sm.getProduction_BTN(), "PRODUCTION");
		sm.getProduction_BTN().click();
		Reporter.log("PRODUCTION is FUNCTIONING PROPERLY ", sm.getPrFitupCompletion().isDisplayed());

		// FITUP
		webdriverutility.ClickableElement(driver, sm.getPrFitupCompletion());
		webdriverutility.validation(driver, sm.getPrFitupCompletion(), "FitUp Completion");
		sm.getPrFitupCompletion().click();
//		Reporter.log("FITUP COMPLETION is FUNCTIONING PROPERLY ", sm.getPrFitupCompletion().isDisplayed());

		// FITUP COMPLETION FC
		TestSpool_FitupCompletion fc = new TestSpool_FitupCompletion(driver);

		// WAIT
//		webdriverutility.waitplease(driver, wait.getProgressBar(), wait.getPleaseWaitModal());
		webdriverutility.waitForProgressToDiss(driver, wait.getProgressBar());

		// FITUP PAGE DISPLAYED
		Allure.step("FITUP COMPLETION PAGE DISPLAYED ...");

//		// FITUP SELECTION GRID PRINT...
//		list.printList(driver, fc.getSelectionWindowHeaders_List());
//
//		// VAL FOR GRID
//		csa.assertTrue(
//				list.compareLists(
//						ExcelUtility.readRowData("C:\\Users\\user\\eclipse-workspace\\"
//								+ "Pgold_Spoolman\\src\\util_main\\resources\\Production\\val.xlsx", 1),
//						list.webElementToString(fc.getSelectionWindowHeaders_List())),
//				"!!!ISSUE FITUP SELECTION WINDOW" + " GRID HEADER DID NOT MATCH...");
//
//		// FITUP CREATION GRID PRINT...
//		list.printList(driver, fc.getCreationWindowHeaders_List());
//
//		// VAL FOR GRID
//		csa.assertTrue(
//				list.compareLists(
//						ExcelUtility.readRowData("C:\\Users\\user\\eclipse-workspace\\"
//								+ "Pgold_Spoolman\\src\\util_main\\resources\\Production\\val.xlsx", 4),
//						list.webElementToString(fc.getCreationWindowHeaders_List())),
//				"!!!ISSUE FITUP CREATION WINDOW" + " GRID HEADER DID NOT MATCH...");

		// TC DIRECT SAVING...
		String f1 = "Fitup Not Done Joints";

		Reporter.log("APPLIED FILTER -- " + fc.getAppliedFiltersText().getText(), true);
		// APPLIED FILTER ...
		csa.assertTrue(f1.equals(fc.getAppliedFiltersText().getText()),
				"!!!ISSUE..." + "APPLIED IS FILTER IS NOT SHOWN OR INCORRECT...");

		// SELECTION WINDOW EDIT
		webdriverutility.ClickableElement(driver, fc.getSelectionWindowEdit_BTN());
		webdriverutility.validation(driver, fc.getSelectionWindowEdit_BTN(), "Selection Edit BTN");
		fc.getSelectionWindowEdit_BTN().click();
		Reporter.log("SELECT WINDOW EDIT BTN is FUNCTIONING PROPERLY", fc.getSelectionWindowEdit_BTN().isDisplayed());

//		SPOOL THAT HAS BEEN FRONT RELEASED...
		String spool1 = "A11B-URH1112-01-SP01";//for funcional
//		String spool1 = "1200R-P-120235-01-SP01";//for setup
//		String spool = ConstructionReleaseFS.s;
//		System.out.println (ConstructionReleaseFS.s);

		// 3DOTS FILTER
		webdriverutility.MultipleFilter3Dots(driver, fc.getSpoolName3Dots(), spool1);

		Assert.assertTrue(spool1.equals(fc.getSpoolNameFR().getText()), "!!!ISSUE...SPOOL DID NOT GET RELEASED");

		// FILTER VAL
//		csa.assertTrue(webdriverutility.FilterVal(driver,, spool));

		// ON FITUP SELECTION MAP OF SPOOL NAME LIST AND JOITN NO LIST...
		HashMap<String, String> HSMP1 = ListUtility.ToItterateList(fc.getSelection_SpoolNameList(),
				fc.getSelection_JointNoList());

		Reporter.log("SPOOLS GOT FRONT RELEASED", true);

		Thread.sleep(1600);

		// SELECT ALL
		webdriverutility.ClickableElement(driver, fc.getSelectAllRow_CHECKBOX());
		webdriverutility.validation(driver, fc.getSelectAllRow_CHECKBOX(), "SELECT ALL");
		fc.getSelectAllRow_CHECKBOX().click();
		Reporter.log("SELECT ALL CHECKBOX is FUNCTIONING PROPERLY", true);
		Thread.sleep(3000);

		// WAIT
//		webdriverutility.waitplease(driver, wait.getProgressBar(), wait.getPleaseWaitModal());
		webdriverutility.waitForProgressToDiss(driver, wait.getProgressBar());

		// CREATION EDIT
		webdriverutility.ClickableElement(driver, fc.getCreationWindowEdit_BTN());
		webdriverutility.validation(driver, fc.getCreationWindowEdit_BTN(), "CREATION WINDOW EDIT");
		fc.getCreationWindowEdit_BTN().click();
		Reporter.log("CREATION WINDOW EDIT BTN is FUNCTIONING PROPERLY", fc.getReportDetails_BTN().isDisplayed());

		// ON FITUP CREATION creating spool name list and joint no. list map...
		HashMap<String, String> HSMP2 = ListUtility.ToItterateList(fc.getCreation_SpoolNameList(),
				fc.getCreation_JointNoList());

		// ASSERT VAL FOR MAP SPOOL NAME AND JOITN NO VAL...
		csa.assertTrue(ListUtility.areMapsEqual(HSMP1, HSMP2), "!!!ISSUE...ASSERT VAL FOR SELECTION TO CREATION...");

		// CREATION SAVE ...
		webdriverutility.ClickableElement(driver, fc.getCreationSave_BTN());
		webdriverutility.validation(driver, fc.getCreationSave_BTN(), "CREATION SAVE BTN");
		fc.getCreationSave_BTN().click();
		Reporter.log("FITUP CREATION SAVE BTN IS FUNCTIONING PROPERLY", true);

				
		webdriverutility.ClickableElement(driver,fc.getRportNoIsNotFilledPopup_Yes());
		fc.getRportNoIsNotFilledPopup_Yes().click();
			
		Thread.sleep(600);

		// POPUP VAL...
		webdriverutility.popupVal(driver);

		// AGAIN GOING TO FILTER AND CHECK IF THE FILTERED SPOOL IS PRESENT IN THE FITUP
		// DONE JOINTS...

		// WAIT
//		webdriverutility.waitplease(driver, wait.getProgressBar(), wait.getPleaseWaitModal());
		webdriverutility.waitForProgressToDiss(driver, wait.getProgressBar());

//		// SELECTION WINDOW EDIT
//		webdriverutility.ClickableElement(driver, fc.getSelectionWindowEdit_BTN());
//		webdriverutility.validation(driver, fc.getSelectionWindowEdit_BTN(), "Selection Edit BTN");
//		fc.getSelectionWindowEdit_BTN().click();
//		Reporter.log("SELECT WINDOW EDIT BTN is FUNCTIONING PROPERLY", fc.getSelectionWindowEdit_BTN().isDisplayed());

		// SELECTION FILTER...
		webdriverutility.ClickableElement(driver, fc.getSelectionFilter_BTN());
		webdriverutility.validation(driver, fc.getSelectionFilter_BTN(), "Selection Edit BTN");
		fc.getSelectionFilter_BTN().click();
		Reporter.log("SELECT WINDOW EDIT BTN is FUNCTIONING PROPERLY", fc.getSelectionWindowEdit_BTN().isDisplayed());

		// SELECTION FILTER...
		webdriverutility.ClickableElement(driver, fc.getFRSelectionClose_BTN());
		webdriverutility.validation(driver, fc.getFRSelectionClose_BTN(), "Selection Edit BTN");
		fc.getFRSelectionClose_BTN().click();
		Reporter.log("FR SELECTION CLOSE BTN is FUNCTIONING PROPERLY", true);

		Thread.sleep(1000);

		// SELECTION FILTER...
		webdriverutility.ClickableElement(driver, fc.getSelectionFilter_BTN());
		webdriverutility.validation(driver, fc.getSelectionFilter_BTN(), "Selection Edit BTN");
		fc.getSelectionFilter_BTN().click();
		Reporter.log("SELECT WINDOW EDIT BTN is FUNCTIONING PROPERLY", fc.getSelectionWindowEdit_BTN().isDisplayed());

		// NOT ENTERING ANY JOB CARD...
//		webdriverutility.ClickableElement(driver, fc.getFRSelectionJobCard_DDTXT());
//		webdriverutility.textConfirmation(driver, fc.getFRSelectionJobCard_DDTXT(), " " ,"FITUP SELECTION JOB CARD");
//		Reporter.log("FILL MASTER MODULE DD INPUT IS FUNCTIONING PROPERLY", true);

		// FILTER FITUP DONE JOINTS
		String f = "Fitup Done Joints";

		//
		webdriverutility.ClickableElement(driver, fc.getFRSelectionView_DDTXT());
		webdriverutility.textConfirmation(driver, fc.getFRSelectionView_DDTXT(), f, "FITUP SELECTION JOB CARD");
		Reporter.log("FILL MASTER MODULE DD INPUT IS FUNCTIONING PROPERLY", true);
		Thread.sleep(600);
		fc.getFRSelectionView_DDTXT().sendKeys(Keys.ENTER);

		// SEARCH CLICK...
		webdriverutility.ClickableElement(driver, fc.getFRSelectionSearch_BTN());
		webdriverutility.validation(driver, fc.getFRSelectionSearch_BTN(), "FR SELECTION SEARCH");
		fc.getFRSelectionSearch_BTN().click();
		Reporter.log("SELECT WINDOW EDIT BTN is FUNCTIONING PROPERLY", fc.getFRSelectionSearch_BTN().isDisplayed());

		// WAIT
//		webdriverutility.waitplease(driver, wait.getProgressBar(), wait.getPleaseWaitModal());
		webdriverutility.waitForProgressToDiss(driver, wait.getProgressBar());

		// APPLIED FILTER DISPLAYED ON ...
		webdriverutility.ClickableElement(driver, fc.getAppliedFiltersText());
		webdriverutility.validation(driver, fc.getAppliedFiltersText(), "APPLIED FILTER");
		Reporter.log("APPLIED FILTER -- " + fc.getAppliedFiltersText().getText(), true);

		// VAL FOR APPLIED FILTER TO CHECK IF IT SHOWING PROPER FILTER...
		csa.assertTrue(f.equals(fc.getAppliedFiltersText().getText()),
				"!!!ISSUE..." + "APPLIED FILTER IS NOT SHOWN OR DID NOT MATCHED...");

		// 3DOTS FILTER
		webdriverutility.MultipleFilter3Dots(driver, fc.getSpoolName3Dots(), spool1);

		// ON FITUP SELECTION MAP OF SPOOL NAME LIST AND JOITN NO LIST...
		HashMap<String, String> FRDONEJ = ListUtility.ToItterateList(fc.getSelection_SpoolNameList(),
				fc.getSelection_JointNoList());

		// ASSERT VAL FOR MAP SPOOL NAME AND JOITN NO VAL...
		csa.assertTrue(ListUtility.areMapsEqual(HSMP1, FRDONEJ),
				"!!!ISSUE...ASSERT VAL FOR FITUP DONE JOINTS SPOOLS DID NOT DISPLAYED...");

		Allure.step("TC FOR...Fitup Done Joints...");

		// REFRESH
		driver.navigate().refresh();

		// WAIT
//		webdriverutility.waitplease(driver, wait.getProgressBar(), wait.getPleaseWaitModal());
		webdriverutility.waitForProgressToDiss(driver, wait.getProgressBar());

		// 2ND TC IN WHICH MANUALLY ENTERING REPORT NO...

		// SELECTION WINDOW EDIT
		webdriverutility.ClickableElement(driver, fc.getSelectionWindowEdit_BTN());
		webdriverutility.validation(driver, fc.getSelectionWindowEdit_BTN(), "Selection Edit BTN");
		fc.getSelectionWindowEdit_BTN().click();
		Reporter.log("SELECT WINDOW EDIT BTN is FUNCTIONING PROPERLY", fc.getSelectionWindowEdit_BTN().isDisplayed());

//		SPOOL THAT HAS BEEN FRONT RELEASED...
//		String spool2 = "1310A-P-131137-01-SP01";//for util_main
//		String spool2 = "1300A-N-142167-02-SP02";//for setup
		String spool2 = "A51A-SW5175-06-SP01"; //for functional 2nd spool
//		String spool = ConstructionReleaseFS.s;
//		System.out.println (ConstructionReleaseFS.s);

		// 3DOTS FILTER
		webdriverutility.MultipleFilter3Dots(driver, fc.getSpoolName3Dots(), spool2);

		Assert.assertTrue(spool2.equals(fc.getSpoolNameFR().getText()), "!!!ISSUE...SPOOL DID NOT GET RELEASED");

		// FILTER VAL
//		csa.assertTrue(webdriverutility.FilterVal(driver,, spool));

		// ON FITUP SELECTION MAP OF SPOOL NAME LIST AND JOITN NO LIST...
		HashMap<String, String> hm = ListUtility.ToItterateList(fc.getSelection_SpoolNameList(),
				fc.getSelection_JointNoList());

		Reporter.log("SPOOLS GOT FRONT RELEASED", true);

		Thread.sleep(4500);

		// SELECT ALL
		webdriverutility.ClickableElement(driver, fc.getSelectAllRow_CHECKBOX());
		webdriverutility.validation(driver, fc.getSelectAllRow_CHECKBOX(), "SELECT ALL");
		fc.getSelectAllRow_CHECKBOX().click();
		Reporter.log("SELECT ALL CHECKBOX is FUNCTIONING PROPERLY", true);
		Thread.sleep(3000);

		// WAIT
//		webdriverutility.waitplease(driver, wait.getProgressBar(), wait.getPleaseWaitModal());
		webdriverutility.waitForProgressToDiss(driver, wait.getProgressBar());

		// CREATION EDIT
		webdriverutility.ClickableElement(driver, fc.getCreationWindowEdit_BTN());
		webdriverutility.validation(driver, fc.getCreationWindowEdit_BTN(), "CREATION WINDOW EDIT");
		fc.getCreationWindowEdit_BTN().click();
		Reporter.log("CREATION WINDOW EDIT BTN is FUNCTIONING PROPERLY", fc.getReportDetails_BTN().isDisplayed());

		// TC TO THICKNESS VAL ADN WELD LENGHT VAL

		// scroll to thickness
		act.scrollToElement(fc.getCreationPart_1ItemType_Col()).perform();
//		js.executeScript("arguments[0].scrollIntoView(true);", fc.getCreationWeldLength_Col());

		webdriverutility.ClickableElement(driver, fc.getCreationThickness_1stRow());
		fc.getCreationThickness_1stRow().click();

		webdriverutility.ClickableElement(driver, fc.getCreationThickness_Input());
		fc.getCreationThickness_Input().clear();

//		act.moveToElement(fc.getCreationThickness_Input()).click().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE).perform();

		webdriverutility.ClickableElement(driver, fc.getCreationThickness_1stRow());
		fc.getCreationThickness_1stRow().click();

		// ENTERING -VE VAL
		fc.getCreationThickness_Input().sendKeys("-");

		// popup val
		webdriverutility.popupVal(driver);

		webdriverutility.ClickableElement(driver, fc.getCreationThickness_1stRow());
		fc.getCreationThickness_1stRow().click();

		// CUSTOM ASSERT FOR THICKNESS -VE
		csa.assertTrue(fc.getCreationThickness_Input().getAttribute("value").isEmpty());

//		webdriverutility.ClickableElement(driver,fc.getCreationThickness_1stRow());
//		fc.getCreationThickness_1stRow().click();

		// ENTERING APHABETS VAL
		fc.getCreationThickness_Input().sendKeys("ABcd");
		csa.assertTrue(fc.getCreationThickness_Input().getAttribute("value").isEmpty());

		webdriverutility.ClickableElement(driver, fc.getCreationThickness_Col());
		fc.getCreationThickness_Col().click();

//		//scroll to WELDING
//		act.scrollToElement(fc.getCreationWeldLength_Col()).perform();
//		js.executeScript("arguments[0].scrollIntoView(true);", fc.getCreationWeldLength_Col());

		// Scroll down until the target element is in view
		while (!fc.getCreationPart_1ItemType_Col().isDisplayed()) {
			act.sendKeys(Keys.ARROW_RIGHT).perform();
			
			act.scrollToElement(fc.getCreationWeldLength_1stRow()).perform();
			// Optionally, you could add a small pause here without using try-catch
			// Just to allow the page to load, but no sleep is included here
			// You can also adjust this logic if needed
		}

		webdriverutility.ClickableElement(driver, fc.getCreationWeldLength_1stRow());
		fc.getCreationWeldLength_1stRow().click();

		webdriverutility.ClickableElement(driver, fc.getCreationWeldLength_Input());
		fc.getCreationWeldLength_Input().clear();

//		act.moveToElement(fc.getCreationThickness_Input()).click().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE).perform();

		webdriverutility.ClickableElement(driver, fc.getCreationWeldLength_1stRow());
		fc.getCreationWeldLength_1stRow().click();

		// ENTERING -VE VAL
		fc.getCreationWeldLength_Input().sendKeys("-");

		// popup val
		webdriverutility.popupVal(driver);

		webdriverutility.ClickableElement(driver, fc.getCreationWeldLength_1stRow());
		fc.getCreationWeldLength_1stRow().click();

		// CSA FOR WELDING SHOULD NOT ACCEPT -VE VAL
		csa.assertTrue(fc.getCreationWeldLength_Input().getAttribute("value").isEmpty());

		// ENTERING APHABETES VAL
		fc.getCreationWeldLength_Input().sendKeys("AAbb");
		// CSA FOR ALPHABETS...
		csa.assertTrue(fc.getCreationWeldLength_Input().getAttribute("value").isEmpty());

		// refrshing
		driver.navigate().refresh();

		// WAIT
//		webdriverutility.waitplease(driver, wait.getProgressBar(), wait.getPleaseWaitModal());
		webdriverutility.waitForProgressToDiss(driver, wait.getProgressBar());

		// SELECTION WINDOW EDIT
		webdriverutility.ClickableElement(driver, fc.getSelectionWindowEdit_BTN());
		fc.getSelectionWindowEdit_BTN().click();

		// 3DOTS FILTER
		webdriverutility.MultipleFilter3Dots(driver, fc.getSpoolName3Dots(), spool2);

		// SELECT ALL
		webdriverutility.ClickableElement(driver, fc.getSelectAllRow_CHECKBOX());
		fc.getSelectAllRow_CHECKBOX().click();
		Thread.sleep(3000);

		// CREATION EDIT
		webdriverutility.ClickableElement(driver, fc.getCreationWindowEdit_BTN());
		fc.getCreationWindowEdit_BTN().click();

		Allure.step("THICKNESS -VE VAL AND ALPHABETS VAL FOR FITUP COMPLETION... NICE");

		// ON FITUP CREATION creating spool name list and joint no. list map...
		HashMap<String, String> hm1 = ListUtility.ToItterateList(fc.getCreation_SpoolNameList(),
				fc.getCreation_JointNoList());

		AllureUtil.takeScreenshot(driver, "screen");

		// ASSERT VAL FOR MAP SPOOL NAME AND JOITN NO VAL...
		csa.assertTrue(ListUtility.areMapsEqual(hm, hm1), "!!!ISSUE...ASSERT VAL FOR SELECTION TO CREATION...");

		// REPORT DETAILS BTN
		webdriverutility.ClickableElement(driver, fc.getReportDetails_BTN());
		webdriverutility.validation(driver, fc.getReportDetails_BTN(), "CREATION WINDOW EDIT");
		fc.getReportDetails_BTN().click();
		Reporter.log("CREATION WINDOW REPORT DETAIL BTN is FUNCTIONING PROPERLY", true);

		Thread.sleep(1500);

		// AUTO GENERATE REPORT NO CHEKBOX
		webdriverutility.ClickableElement(driver, fc.getAutogenerateReportNo_CHECKBOX());
		webdriverutility.validation(driver, fc.getAutogenerateReportNo_CHECKBOX(), "AUTO GENERATED CHECKBOX");
		act.click(fc.getAutogenerateReportNo_CHECKBOX()).perform();

//		fc.getAutogenerateReportNo_CHECKBOX().click();    
		Reporter.log("AUTO GENERATED CHECKBOX IS FUNCTIONING PROPERLY", true);

		// REPORT NO DD
		webdriverutility.ClickableElement(driver, fc.getReportNo_DD());
		webdriverutility.validation(driver, fc.getReportNo_DD(), "REPORT NO. DD");
		fc.getReportNo_DD().click();
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY", true);

		// FOR ME TO CHANGE INPUT EVERYTIME
		String x = "1";

		String reportno = "AA_" + x;

		// REPORT NO DD INPUT...
		webdriverutility.ClickableElement(driver, fc.getReportNoDDInput());
		webdriverutility.textConfirmation(driver, fc.getReportNoDDInput(), reportno, "REPORT NO. DD input ");
		Reporter.log("REPORT NO. DD input IS FUNCTIONING PROPERLY", true);

		Thread.sleep(1500);

		// REPORT NO ADD BTN...
		webdriverutility.ClickableElement(driver, fc.getReportNoADD_BTN());
		webdriverutility.validation(driver, fc.getReportNoADD_BTN(), "REPORT NO. ADD btn");
		fc.getReportNoADD_BTN().click();
		Reporter.log("REPORT NO. SDD btn IS FUNCTIONING PROPERLY", true);

		fc.getReportNoDDInput().sendKeys(Keys.ENTER);

		// APPLY ALL OBSERVATION DDTXT...
		webdriverutility.ClickableElement(driver, fc.getApplyAllObservation_DDTXT());
		webdriverutility.validation(driver, fc.getApplyAllObservation_DDTXT(), "APPLY ALL OBSERVATION");
		fc.getApplyAllObservation_DDTXT().sendKeys("Accepted" + Keys.ENTER);
		Reporter.log("APPLY ALL OBSERVATION DD TXT IS FUNCTIONING PROPERLY", true);

		// FITUP REPORT CREATION SAVE BTN...
		webdriverutility.ClickableElement(driver, fc.getFitupReportCreationSave_BTN());
		webdriverutility.validation(driver, fc.getFitupReportCreationSave_BTN(), "FITUP CREATION SAVE BTN");
		fc.getFitupReportCreationSave_BTN().click();
		Reporter.log("FITUP REPORT CREATION SAVE BTN IS FUNCTIONING PROPERLY", true);

//		//FULLSCREEN ...
//		webdriverutility.ClickableElement(driver,fc.getSelectionFullscrean_BTN());
//		webdriverutility.validation(driver,fc.getSelectionFullscrean_BTN(),"SELECTION SAVE BTN");						
//		fc.getSelectionFullscrean_BTN().click();
//		Reporter.log("SELECTION FULLSCREEN BTN IS FUNCTIONING PROPERLY",true);
//		
//		Thread.sleep(500);
//		
//		//COMPRESS..
//		webdriverutility.ClickableElement(driver,fc.getFitupCompletionCompress_BTN());
//		webdriverutility.validation(driver,fc.getFitupCompletionCompress_BTN(),"COMPRESSION BTN");						
//		fc.getFitupCompletionCompress_BTN().click();
//		Reporter.log("FITUP COMPLETION COMPRESS IS FUNCTIONING PROPERLY",true);
//		 
//		//CREATION FULLSCREEN		
//		webdriverutility.ClickableElement(driver,fc.getCreationFullscrean_BTN());						
//		fc.getCreationFullscrean_BTN().click();
//		Reporter.log("FITUP FULLSCREEN SAVE BTN IS FUNCTIONING PROPERLY",true);
//		
//		//COMPLETION COMPRESS...
//		webdriverutility.ClickableElement(driver,fc.getFitupCompletionCompress_BTN());
//		fc.getFitupCompletionCompress_BTN().click();
//		Reporter.log("FITUP COMPLETION COMPRESS IS FUNCTIONING PROPERLY",true);

		// POPUP CLOSE
		webdriverutility.ClickableElement(driver, spoolutil.getPopupClose_BTN());
		spoolutil.getPopupClose_BTN().click();
		Reporter.log("POPUP CLOSE FUNCTIONING PROPERLY", true);

		webdriverutility.ClickableElement(driver, fc.getFitupReportCreationSave_BTN());
		fc.getFitupReportCreationSave_BTN().click();

		// POPUP NO
		webdriverutility.ClickableElement(driver, spoolutil.getPopupNo_BTN());
		spoolutil.getPopupNo_BTN().click();
		Reporter.log("POPUP NO FUNCTIONING PROPERLY", true);

//		webdriverutility.ClickableElement(driver, fc.getFitupReportCreationSave_BTN());
//		fc.getFitupReportCreationSave_BTN().click();
//
//		// POPUP YES...
//		webdriverutility.ClickableElement(driver, spoolutil.getPopupYes_BTN());
//		spoolutil.getPopupYes_BTN().click();
//		Reporter.log("POPUP YES FUNCTIONING PROPERLY", true);
//
//		// POPUP VAL
//		webdriverutility.popupVal(driver);
//		in previous flow there was popup close for fill master ... that it was mandatory ot fill fill master
//		now it is not mandatory so no popval and hav eto change in script
		
		// FILL MASTER DETAILS COLLAPSE...
		webdriverutility.ClickableElement(driver, fc.getFillMasterDetailsCollapse());
		webdriverutility.validation(driver, fc.getCreationSave_BTN(), "FILL MASTER COLLAPSE");
		fc.getFillMasterDetailsCollapse().click();
		Reporter.log("FILL MASTER COLLAPSE BTN IS FUNCTIONING PROPERLY", true);

		// YARD DD..
		webdriverutility.ClickableElement(driver, fc.getFM_YardDD());
		fc.getFM_YardDD().click();
		Reporter.log("FILL MASTER YARD DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		// YARD DD INPUT
		webdriverutility.ClickableElement(driver, fc.getFM_YardDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_YardDDInput(), "YD_" + x, "YARD INPUT");
		Reporter.log("FILL MASTER YARD DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		// FM ADD NEW ITEM
		webdriverutility.ClickableElement(driver, fc.getFM_YardAddNewItem());
		fc.getFM_YardAddNewItem().click();
		Reporter.log("FILL MASTER YARD ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_YardDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		MODULE NO
		webdriverutility.ClickableElement(driver, fc.getFM_ModuleNoDD());
		fc.getFM_ModuleNoDD().click();
		Reporter.log("FILL MASTER MODULE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_ModuleNoDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_ModuleNoDDInput(), "MO_" + x, "MODULE INPUT");
		Reporter.log("FILL MASTER MODULE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_ModuleNoAddNewItem());
		fc.getFM_ModuleNoAddNewItem().click();
		Reporter.log("FILL MASTER MODULE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_ModuleNoDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		RFINO
		webdriverutility.ClickableElement(driver, fc.getFM_RFINoDD());
		fc.getFM_RFINoDD().click();
		Reporter.log("FILL MASTER RFI NO DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_RFINoDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_RFINoDDInput(), "RFI_" + x, "RFI NO. INPUT");
		Reporter.log("FILL MASTER RFI NO DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_RFINoAddNewItem());
		fc.getFM_RFINoAddNewItem().click();
		Reporter.log("FILL MASTER RFI NO ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_RFINoDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		RFI DATE...

//		RFI DATE VALIDATION
		csa.assertTrue(fc.getFM_DateOfRFI().getAttribute("value").equals(JavaUtility.TodaysDate()));

		Thread.sleep(500);

//		LOCATION DD...
		webdriverutility.ClickableElement(driver, fc.getFM_LocationDD());
		fc.getFM_LocationDD().click();
		Reporter.log("FILL MASTER LOCATION DD IS FUNCTIONING PROPERLY", true);

		String location = "NewLoctn";

		Thread.sleep(500);
		// LOCATION DD INPUT
		webdriverutility.ClickableElement(driver, fc.getFM_LocationDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_LocationDDInput(), location, "LOCATION DD INPUT");
		Reporter.log("FILL MASTER LOCATION DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
		// ADD NEW ITEM...
		webdriverutility.ClickableElement(driver, fc.getFM_LocationAddNewItem());
		fc.getFM_LocationAddNewItem().click();
		Reporter.log("FILL MASTER LOCATION ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_LocationDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

		Thread.sleep(500);
//		INFECTION DATE VALIDATION...
		csa.assertTrue(fc.getFM_InspectionDate().getAttribute("value").equals(JavaUtility.TodaysDate()));

		Thread.sleep(500);
//		CODE/SPEC 
		webdriverutility.ClickableElement(driver, fc.getFM_CodeSpecDD());
		fc.getFM_CodeSpecDD().click();
		Reporter.log("FILL MASTER SPEC/CODE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_CodeSpecDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_CodeSpecDDInput(), "COD_" + x, "SPEC/CODE INPUT");
		Reporter.log("FILL MASTER SPEC/CODE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
		// ADD NEW ITEM...
		webdriverutility.ClickableElement(driver, fc.getFM_CodeSpecAddNewItem());
		fc.getFM_CodeSpecAddNewItem().click();
		Reporter.log("FILL MASTER SPEC/CODE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_CodeSpecDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		PROCEDURE
		webdriverutility.ClickableElement(driver, fc.getFM_ProcedureDD());
		fc.getFM_ProcedureDD().click();
		Reporter.log("FILL MASTER PROCEDURE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_ProcedureDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_ProcedureDDInput(), "PRO_" + x, "PROCEDURE INPUT");
		Reporter.log("FILL MASTER PROCEDURE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
		// ADD NEW ITEM...
		webdriverutility.ClickableElement(driver, fc.getFM_ProcedureAddNewItem());
		fc.getFM_ProcedureAddNewItem().click();
		Reporter.log("FILL MASTER PROCEDURE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_ProcedureDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		ACCEPTANCE CRITERIA
		webdriverutility.ClickableElement(driver, fc.getFM_AcceptCriteriaDD());
		fc.getFM_AcceptCriteriaDD().click();
		Reporter.log("FILL MASTER ACCEPTANCE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_AcceptCriteriaDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_AcceptCriteriaDDInput(), "A_" + x, "ACCEPTANCE INPUT");
		Reporter.log("FILL MASTER ACCEPTANCE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
		// ADD NEW ITEM...
		webdriverutility.ClickableElement(driver, fc.getFM_AcceptCriteriaAddNewItem());
		fc.getFM_AcceptCriteriaAddNewItem().click();
		Reporter.log("FILL MASTER ACCEPTANCE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_AcceptCriteriaDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

		// FITUP REPORT CREATION SAVE ...
		webdriverutility.ClickableElement(driver, fc.getFitupReportCreationSave_BTN());
		webdriverutility.validation(driver, fc.getFitupReportCreationSave_BTN(), "FITUP CREATION SAVE BTN");
		fc.getFitupReportCreationSave_BTN().click();
		Reporter.log("FITUP REPORT CREATION SAVE BTN IS FUNCTIONING PROPERLY", true);

		// POPUP CLOSE..
		webdriverutility.ClickableElement(driver, spoolutil.getPopupClose_BTN());
		spoolutil.getPopupClose_BTN().click();
		Reporter.log("POPUP CLOSE FUNCTIONING PROPERLY", true);

		webdriverutility.ClickableElement(driver, fc.getFitupReportCreationSave_BTN());
		fc.getFitupReportCreationSave_BTN().click();

		// POPUP NO...
		webdriverutility.ClickableElement(driver, spoolutil.getPopupNo_BTN());
		spoolutil.getPopupNo_BTN().click();
		Reporter.log("POPUP NO FUNCTIONING PROPERLY", true);

		webdriverutility.ClickableElement(driver, fc.getFitupReportCreationSave_BTN());
		fc.getFitupReportCreationSave_BTN().click();

		// POPUP YES...
		webdriverutility.ClickableElement(driver, spoolutil.getPopupYes_BTN());
		spoolutil.getPopupYes_BTN().click();
		Reporter.log("POPUP YES FUNCTIONING PROPERLY", true);

		// CREATION SAVE ...
		webdriverutility.ClickableElement(driver, fc.getCreationSave_BTN());
		webdriverutility.validation(driver, fc.getCreationSave_BTN(), "CREATION SAVE BTN");
		fc.getCreationSave_BTN().click();
		Reporter.log("FITUP CREATION SAVE BTN IS FUNCTIONING PROPERLY", true);

//		//SIGNATURE POPUP NO...
//		webdriverutility.ClickableElement(driver,fc.getSignaturePOPUPNo());
//		webdriverutility.validation(driver,fc.getSignaturePOPUPNo(),"SIGNATURE POPUP NO");						
//		fc.getSignaturePOPUPNo().click();
//		Reporter.log("SIGNATURE NO BTN IS FUNCTIONING PROPERLY",true);

//		POPUP VAL		
		webdriverutility.popupVal(driver);

		// SIDEBAR EXPAND..
		webdriverutility.ClickableElement(driver, hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		// SIDEBAR FITUMP VIEW MODIFY REPORT...
		webdriverutility.ClickableElement(driver, fc.getSideBarFitupViewModifyReport());
		webdriverutility.validation(driver, fc.getSideBarFitupViewModifyReport(), "SIDEBAR FITUP FITUP VIEW MODIFY");
		fc.getSideBarFitupViewModifyReport().click();
		Reporter.log("SIDEBAR FITUP VIEW MODE IS FUNCTIONING PROPERLY", true);

		// SIDEBAR EXPAND...
		webdriverutility.ClickableElement(driver, hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		// OBJECT MODIFY REPORT...
		TestSpoolman_fcModiyReport Modify = new TestSpoolman_fcModiyReport(driver);

		Thread.sleep(600);

		// SELECTION TOTAL NO OF RECORDS...
		Reporter.log("selection total no of records" + Modify.getSelectionTotalNoOfRecords().getText(), true);

		// CREATION TOTAL NO OF RECORDS...
		Reporter.log("creation total no of records" + Modify.getCreationtotalNoOfRecords().getText(), true);

		// SELECTION WINDOW EDIT...
		webdriverutility.ClickableElement(driver, Modify.getSelectionWindowEdit_BTN());
		webdriverutility.validation(driver, Modify.getSelectionWindowEdit_BTN(), "SELECTION WINDOW EDIT BTN");
		Modify.getSelectionWindowEdit_BTN().click();
		Reporter.log("SELECTION WINDOW EDIT IS FUNCTIONING PROPERLY", true);

		// FILTER 3 DOTS
		webdriverutility.MultipleFilter3Dots(driver, Modify.getModifyReportNo3Dots(), reportno);

		Thread.sleep(1000);

		// REPORT VALIDATION IF THE REPORT IS GETTIGN FILTERED AND SHOWING IT ON ...
		Assert.assertTrue(webdriverutility.FilterVal(driver, Modify.getModifyReportNo_List(), reportno),
				"ISSUE!!! FILTER REPORT IS NOT SHOWED IN MODIFY...");

//		commenting it cause i dont want to carry new spools everytime
		webdriverutility.ClickableElement(driver, Modify.getSelect1stRow());
		Modify.getSelect1stRow().click();
		Reporter.log("1st row is getting selected ", true);

		Thread.sleep(10000);

		Reporter.log("SELECTION TOTAL NO OF RECORDS " + Modify.getSelectionTotalNoOfRecords().getText(), true);

		Reporter.log("CREATTION TOTAL NO OF RECORDS " + Modify.getCreationtotalNoOfRecords().getText(), true);

		// CREATION WINDOW EDIT...
		webdriverutility.ClickableElement(driver, Modify.getCreationWindowEdit_BTN());
		webdriverutility.validation(driver, Modify.getCreationWindowEdit_BTN(), "CREATION WINDOW EDIT BTN");
		Modify.getCreationWindowEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN is FUNCTIONING PROPERLY", true);

		// SELECT ALL
		webdriverutility.ClickableElement(driver, Modify.getSelectAllRow());
		Modify.getSelectAllRow().click();

//		List<WebElement> list = Modify.getCreationListSelected();

		// Verify that all checkboxes are selected

		for (WebElement line : Modify.getCreationListSelected()) {
			if (line.isSelected()) {
				System.out.println(line.getText() + " is DISPLAYED");
				continue;
			}
		}
		Reporter.log("LINE ID's DISPLAYING in CREATION WINDOW", true);

		// HASHMAP FROM MODIFY SPOOLNO AND JOINT NO....
		HashMap<String, String> hm2 = ListUtility.ToItterateList(Modify.getCreationSpool_NoList(),
				Modify.getCreationJoint_NoList());

		// SPOOL NAME AND JOITN NO VAL ON MODIFY...
		Assert.assertTrue(ListUtility.areMapsEqual(hm, hm2),
				"!!!ISSUE...REPORT NO IS NOT CONTAINING SAME SPOOL NO AND JOINTS" + " FOR SAME REPORT...");

		// CREATION SAVE...
		webdriverutility.ClickableElement(driver, Modify.getCreationSave_BTN());
		webdriverutility.validation(driver, Modify.getCreationSave_BTN(), "CREATION SAVE BTN");
		Modify.getCreationSave_BTN().click();
		Reporter.log("CREATION SAVE BTN is FUNCTIONING PROPERLY", true);

//		POPUP VAL
		webdriverutility.visibilityOfElement(driver,mg.spoolutil.getPOPUP_Message());			
		webdriverutility.popupVal(driver);

		// TC TO VALIDATE THICKNESS AND WELD LENGTH -VE AND ALPHABET VAL...

//		webdriverutility.ClickableElement(driver, Modify.getCreationWindowEdit_BTN());
//		Modify.getCreationWindowEdit_BTN().click();

		// scroll to thickness
		// USE SENDKESY KEYS .ARROW IT IS BETTER
		act.scrollToElement(Modify.getFitUpRectificationDate_Col()).perform();
//		js.executeScript("arguments[0].scrollIntoView(true);", Modify.getCreationWeldLength_Col());
//		while (!Modify.getFitUpRectificationDate_Col().isDisplayed()) {
//			act.sendKeys(Keys.ARROW_RIGHT).perform();
//			// Optionally, you could add a small pause here without using try-catch
//			// Just to allow the page to load, but no sleep is included here
//			// You can also adjust this logic if needed
//		}

		webdriverutility.ClickableElement(driver, Modify.getThickness_1stRow());
		Modify.getThickness_1stRow().click();

		webdriverutility.ClickableElement(driver, Modify.getThickness_Input());
		Modify.getThickness_Input().clear();

//		act.moveToElement(Modify.getCreationThickness_Input()).click().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE).perform();

		webdriverutility.ClickableElement(driver, Modify.getThickness_1stRow());
		Modify.getThickness_1stRow().click();

		// ENTERING -VE VAL
		Modify.getThickness_Input().sendKeys("-");

		// popup val
		webdriverutility.popupVal(driver);

		webdriverutility.ClickableElement(driver, Modify.getThickness_1stRow());
		Modify.getThickness_1stRow().click();

		// CUSTOM ASSERT FOR THICKNESS -VE
		csa.assertTrue(Modify.getThickness_Input().getAttribute("value").isEmpty());

//		webdriverutility.ClickableElement(driver,Modify.getCreationThickness_1stRow());
//		Modify.getCreationThickness_1stRow().click();

		// ENTERING APHABETS VAL
		Modify.getThickness_Input().sendKeys("ABcd");
		csa.assertTrue(Modify.getThickness_Input().getAttribute("value").isEmpty());

		webdriverutility.ClickableElement(driver, Modify.getThickness_Col());
		Modify.getThickness_Col().click();

//		//scroll to WELDING
//		act.scrollToElement(Modify.getCreationWeldLength_Col()).perform();
//		js.executeScript("arguments[0].scrollIntoView(true);", Modify.getCreationWeldLength_Col());

		// Scroll down until the target element is in view
		while (!Modify.getFitUpRectificationDate_Col().isDisplayed()) {
			act.sendKeys(Keys.ARROW_RIGHT).perform();
			// Optionally, you could add a small pause here without using try-catch
			// Just to allow the page to load, but no sleep is included here
			// You can also adjust this logic if needed
		}

		webdriverutility.ClickableElement(driver, Modify.getWeldLength_1stRow());
		Modify.getWeldLength_1stRow().click();

		webdriverutility.ClickableElement(driver, Modify.getWeldLength_Input());
		Modify.getWeldLength_Input().clear();

//		act.moveToElement(Modify.getCreationThickness_Input()).click().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE).perform();

		webdriverutility.ClickableElement(driver, Modify.getWeldLength_1stRow());
		Modify.getWeldLength_1stRow().click();

		// ENTERING -VE VAL
		webdriverutility.ClickableElement(driver, Modify.getWeldLength_Input());
		Modify.getWeldLength_Input().sendKeys("-");

		// popup val
		webdriverutility.popupVal(driver);

		webdriverutility.ClickableElement(driver, Modify.getWeldLength_1stRow());
		Modify.getWeldLength_1stRow().click();

		// CSA FOR WELDING SHOULD NOT ACCEPT -VE VAL
		csa.assertTrue(Modify.getWeldLength_Input().getAttribute("value").isEmpty());

		// ENTERING APHABETES VAL
		Modify.getWeldLength_Input().sendKeys("AAbb");
		// CSA FOR ALPHABETS...
		csa.assertTrue(Modify.getWeldLength_Input().getAttribute("value").isEmpty());

		// refrshing
		driver.navigate().refresh();

//		Reporter.log("DATA SAVED SUCCESSFULLY DISPLAYED ", fc.getDataSavedSuccessfully_POPUP().isDisplayed());
		Thread.sleep(500);
//		fc.getDataSavedSuccessfully_POPUPClose().click();

		// ALLURE STEP
		Allure.step("TC VIEW MODIFY TO VALIDATE THICKNESS AND WELD LENGTH -VE AND ALPHABET VAL...");

		// ALLURE STEP
		Allure.step("FITUP REPORT SAVING WITH MANUAL REPORT NO. VAL ON MODIFY...");

		// SIDEBAR EXPAND
		webdriverutility.ClickableElement(driver, hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		// FITUP REPORT SIDEBAR...
		webdriverutility.ClickableElement(driver, fc.getSideBarFitupReport());
		fc.getSideBarFitupReport().click();

		// WAIT
//		webdriverutility.waitplease(driver, wait.getProgressBar(), wait.getPleaseWaitModal());
		webdriverutility.waitForProgressToDiss(driver, wait.getProgressBar());

		// SELECTION WINDOW EDIT
		webdriverutility.ClickableElement(driver, fc.getSelectionWindowEdit_BTN());
		webdriverutility.validation(driver, fc.getSelectionWindowEdit_BTN(), "Selection Edit BTN");
		fc.getSelectionWindowEdit_BTN().click();
		Reporter.log("SELECT WINDOW EDIT BTN is FUNCTIONING PROPERLY", fc.getSelectionWindowEdit_BTN().isDisplayed());

//		SPOOL THAT HAS BEEN FRONT RELEASED...
		String spool3 = "A22B-PL3105-03-SP03";//FOR FUNCTINAL
//		String spool = ConstructionReleaseFS.s;
//		System.out.println (ConstructionReleaseFS.s);

		// 3DOTS FILTER
		webdriverutility.MultipleFilter3Dots(driver, fc.getSpoolName3Dots(), spool3);

		// FILTER VAL
//		csa.assertTrue(webdriverutility.FilterVal(driver,, spool));

		// ON FITUP SELECTION MAP OF SPOOL NAME LIST AND JOITN NO LIST...
		HashMap<String, String> TC3HM1 = ListUtility.ToItterateList(fc.getSelection_SpoolNameList(),
				fc.getSelection_JointNoList());

		Reporter.log("SPOOLS GOT FRONT RELEASED", true);

		Thread.sleep(4500);

		// SELECT ALL
		webdriverutility.ClickableElement(driver, fc.getSelectAllRow_CHECKBOX());
		webdriverutility.validation(driver, fc.getSelectAllRow_CHECKBOX(), "SELECT ALL");
		fc.getSelectAllRow_CHECKBOX().click();
		Reporter.log("SELECT ALL CHECKBOX is FUNCTIONING PROPERLY", true);
		Thread.sleep(3000);

		// WAIT
//		webdriverutility.waitplease(driver, wait.getProgressBar(), wait.getPleaseWaitModal());
		webdriverutility.waitForProgressToDiss(driver, wait.getProgressBar());

		// CREATION EDIT
		webdriverutility.ClickableElement(driver, fc.getCreationWindowEdit_BTN());
		webdriverutility.validation(driver, fc.getCreationWindowEdit_BTN(), "CREATION WINDOW EDIT");
		fc.getCreationWindowEdit_BTN().click();
		Reporter.log("CREATION WINDOW EDIT BTN is FUNCTIONING PROPERLY", fc.getReportDetails_BTN().isDisplayed());

		// ON FITUP CREATION creating spool name list and joint no. list map...
		HashMap<String, String> TC3HM2 = ListUtility.ToItterateList(fc.getCreation_SpoolNameList(),
				fc.getCreation_JointNoList());

		AllureUtil.takeScreenshot(driver, "screen");

		// ASSERT VAL FOR MAP SPOOL NAME AND JOITN NO VAL...
		csa.assertTrue(ListUtility.areMapsEqual(TC3HM1, TC3HM2), "!!!ISSUE...ASSERT VAL FOR SELECTION TO CREATION...");

		// REPORT DETAILS BTN
		webdriverutility.ClickableElement(driver, fc.getReportDetails_BTN());
		webdriverutility.validation(driver, fc.getReportDetails_BTN(), "CREATION WINDOW EDIT");
		fc.getReportDetails_BTN().click();
		Reporter.log("CREATION WINDOW REPORT DETAIL BTN is FUNCTIONING PROPERLY", true);

		Thread.sleep(1500);

		// AUTO GENERATE REPORT NO CHEKBOX NOT CLIKCICKING CAUSE WE DONT WANT IT...
//		webdriverutility.ClickableElement(driver, fc.getAutogenerateReportNo_CHECKBOX());
//		webdriverutility.validation(driver, fc.getAutogenerateReportNo_CHECKBOX(), "AUTO GENERATED CHECKBOX");
//		act.click(fc.getAutogenerateReportNo_CHECKBOX()).perform();

		csa.assertTrue(fc.getAutogenerateReportNo_CHECKBOX().isSelected(),
				"AUTO GENERATE CHECKBOX IS UNCHECKED EVEN WHEN" + "IT SHOULD BE CHECKED");
		Reporter.log(
				"AUTO GENERATE REPORT NO. CHECKBOX IS CHECKED..." + fc.getAutogenerateReportNo_CHECKBOX().isSelected(),
				true);

//		fc.getAutogenerateReportNo_CHECKBOX().click();    
		Reporter.log("AUTO GENERATED CHECKBOX IS FUNCTIONING PROPERLY", true);

		// FOR ME TO CHANGE INPUT EVERYTIME
		int i = 200 - Integer.valueOf(x);

		String y = String.valueOf(i);

		String reportno2 = fc.getReportNo_AutoGenerated().getText();

		Thread.sleep(1500);

		// APPLY ALL OBSERVATION DDTXT...
		webdriverutility.ClickableElement(driver, fc.getApplyAllObservation_DDTXT());
		webdriverutility.validation(driver, fc.getApplyAllObservation_DDTXT(), "APPLY ALL OBSERVATION");
		fc.getApplyAllObservation_DDTXT().sendKeys("Accepted" + Keys.ENTER);
		Reporter.log("APPLY ALL OBSERVATION DD TXT IS FUNCTIONING PROPERLY", true);

//		// FITUP REPORT CREATION SAVE BTN...
//		webdriverutility.ClickableElement(driver, fc.getFitupReportCreationSave_BTN());
//		webdriverutility.validation(driver, fc.getFitupReportCreationSave_BTN(), "FITUP CREATION SAVE BTN");
//		fc.getFitupReportCreationSave_BTN().click();
//		Reporter.log("FITUP REPORT CREATION SAVE BTN IS FUNCTIONING PROPERLY", true);
//
//		// POPUP YES...
//		webdriverutility.ClickableElement(driver, spoolutil.getPopupYes_BTN());
//		spoolutil.getPopupYes_BTN().click();
//		Reporter.log("POPUP YES FUNCTIONING PROPERLY", true);
//
//		// POPUP VAL
//		webdriverutility.popupVal(driver);

		// FILL MASTER DETAILS COLLAPSE...
		webdriverutility.ClickableElement(driver, fc.getFillMasterDetailsCollapse());
		webdriverutility.validation(driver, fc.getCreationSave_BTN(), "FILL MASTER COLLAPSE");
		fc.getFillMasterDetailsCollapse().click();
		Reporter.log("FILL MASTER COLLAPSE BTN IS FUNCTIONING PROPERLY", true);

		// YARD DD..
		webdriverutility.ClickableElement(driver, fc.getFM_YardDD());
		fc.getFM_YardDD().click();
		Reporter.log("FILL MASTER YARD DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		// YARD DD INPUT
		webdriverutility.ClickableElement(driver, fc.getFM_YardDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_YardDDInput(), "YD_" + y, "YARD INPUT");
		Reporter.log("FILL MASTER YARD DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		// FM ADD NEW ITEM
		webdriverutility.ClickableElement(driver, fc.getFM_YardAddNewItem());
		fc.getFM_YardAddNewItem().click();
		Reporter.log("FILL MASTER YARD ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_YardDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		MODULE NO
		webdriverutility.ClickableElement(driver, fc.getFM_ModuleNoDD());
		fc.getFM_ModuleNoDD().click();
		Reporter.log("FILL MASTER MODULE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_ModuleNoDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_ModuleNoDDInput(), "MO_" + y, "MODULE INPUT");
		Reporter.log("FILL MASTER MODULE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_ModuleNoAddNewItem());
		fc.getFM_ModuleNoAddNewItem().click();
		Reporter.log("FILL MASTER MODULE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_ModuleNoDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		RFINO
		webdriverutility.ClickableElement(driver, fc.getFM_RFINoDD());
		fc.getFM_RFINoDD().click();
		Reporter.log("FILL MASTER RFI NO DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_RFINoDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_RFINoDDInput(), "RFI_" + y, "RFI NO. INPUT");
		Reporter.log("FILL MASTER RFI NO DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_RFINoAddNewItem());
		fc.getFM_RFINoAddNewItem().click();
		Reporter.log("FILL MASTER RFI NO ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_RFINoDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		RFI DATE...

//		RFI DATE VALIDATION
		csa.assertTrue(fc.getFM_DateOfRFI().getAttribute("value").equals(JavaUtility.TodaysDate()));

		Thread.sleep(500);

//		LOCATION DD...
		webdriverutility.ClickableElement(driver, fc.getFM_LocationDD());
		fc.getFM_LocationDD().click();
		Reporter.log("FILL MASTER LOCATION DD IS FUNCTIONING PROPERLY", true);

		String TC3location = "New_LoC";

		Thread.sleep(500);
		// LOCATION DD INPUT
		webdriverutility.ClickableElement(driver, fc.getFM_LocationDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_LocationDDInput(), TC3location, "LOCATION DD INPUT");
		Reporter.log("FILL MASTER LOCATION DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
		// ADD NEW ITEM...
		webdriverutility.ClickableElement(driver, fc.getFM_LocationAddNewItem());
		fc.getFM_LocationAddNewItem().click();
		Reporter.log("FILL MASTER LOCATION ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_LocationDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

		Thread.sleep(500);
//		INFECTION DATE VALIDATION...
		csa.assertTrue(fc.getFM_InspectionDate().getAttribute("value").equals(JavaUtility.TodaysDate()));

		Thread.sleep(500);
//		CODE/SPEC 
		webdriverutility.ClickableElement(driver, fc.getFM_CodeSpecDD());
		fc.getFM_CodeSpecDD().click();
		Reporter.log("FILL MASTER SPEC/CODE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_CodeSpecDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_CodeSpecDDInput(), "COD_" + y, "SPEC/CODE INPUT");
		Reporter.log("FILL MASTER SPEC/CODE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
		// ADD NEW ITEM...
		webdriverutility.ClickableElement(driver, fc.getFM_CodeSpecAddNewItem());
		fc.getFM_CodeSpecAddNewItem().click();
		Reporter.log("FILL MASTER SPEC/CODE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_CodeSpecDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		PROCEDURE
		webdriverutility.ClickableElement(driver, fc.getFM_ProcedureDD());
		fc.getFM_ProcedureDD().click();
		Reporter.log("FILL MASTER PROCEDURE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_ProcedureDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_ProcedureDDInput(), "PRO_" + y, "PROCEDURE INPUT");
		Reporter.log("FILL MASTER PROCEDURE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
		// ADD NEW ITEM...
		webdriverutility.ClickableElement(driver, fc.getFM_ProcedureAddNewItem());
		fc.getFM_ProcedureAddNewItem().click();
		Reporter.log("FILL MASTER PROCEDURE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_ProcedureDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		ACCEPTANCE CRITERIA
		webdriverutility.ClickableElement(driver, fc.getFM_AcceptCriteriaDD());
		fc.getFM_AcceptCriteriaDD().click();
		Reporter.log("FILL MASTER ACCEPTANCE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_AcceptCriteriaDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_AcceptCriteriaDDInput(), "A_" + y, "ACCEPTANCE INPUT");
		Reporter.log("FILL MASTER ACCEPTANCE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
		// ADD NEW ITEM...
		webdriverutility.ClickableElement(driver, fc.getFM_AcceptCriteriaAddNewItem());
		fc.getFM_AcceptCriteriaAddNewItem().click();
		Reporter.log("FILL MASTER ACCEPTANCE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_AcceptCriteriaDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

		// FITUP REPORT CREATION SAVE ...
		webdriverutility.ClickableElement(driver, fc.getFitupReportCreationSave_BTN());
		webdriverutility.validation(driver, fc.getFitupReportCreationSave_BTN(), "FITUP CREATION SAVE BTN");
		fc.getFitupReportCreationSave_BTN().click();
		Reporter.log("FITUP REPORT CREATION SAVE BTN IS FUNCTIONING PROPERLY", true);

		// POPUP YES...
		webdriverutility.ClickableElement(driver, spoolutil.getPopupYes_BTN());
		spoolutil.getPopupYes_BTN().click();
		Reporter.log("POPUP YES FUNCTIONING PROPERLY", true);

		// CREATION SAVE ...
		webdriverutility.ClickableElement(driver, fc.getCreationSave_BTN());
		webdriverutility.validation(driver, fc.getCreationSave_BTN(), "CREATION SAVE BTN");
		fc.getCreationSave_BTN().click();
		Reporter.log("FITUP CREATION SAVE BTN IS FUNCTIONING PROPERLY", true);

//		//SIGNATURE POPUP NO...
//		webdriverutility.ClickableElement(driver,fc.getSignaturePOPUPNo());
//		webdriverutility.validation(driver,fc.getSignaturePOPUPNo(),"SIGNATURE POPUP NO");						
//		fc.getSignaturePOPUPNo().click();
//		Reporter.log("SIGNATURE NO BTN IS FUNCTIONING PROPERLY",true);

//		POPUP VAL		
		webdriverutility.popupVal(driver);

//		//SIDEBAR EXPAND..
//		webdriverutility.ClickableElement(driver, hp.getExpandSidebar());
//		hp.getExpandSidebar().click();

		// SIDEBAR FITUMP VIEW MODIFY REPORT...
		webdriverutility.ClickableElement(driver, fc.getSideBarFitupViewModifyReport());
		webdriverutility.validation(driver, fc.getSideBarFitupViewModifyReport(), "SIDEBAR FITUP FITUP VIEW MODIFY");
		fc.getSideBarFitupViewModifyReport().click();
		Reporter.log("SIDEBAR FITUP VIEW MODE IS FUNCTIONING PROPERLY", true);

		// SIDEBAR EXPAND...
		webdriverutility.ClickableElement(driver, hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		Thread.sleep(600);

		// SELECTION TOTAL NO OF RECORDS...
		Reporter.log("selection total no of records" + Modify.getSelectionTotalNoOfRecords().getText(), true);

		// CREATION TOTAL NO OF RECORDS...
		Reporter.log("creation total no of records" + Modify.getCreationtotalNoOfRecords().getText(), true);

		// SELECTION WINDOW EDIT...
		webdriverutility.ClickableElement(driver, Modify.getSelectionWindowEdit_BTN());
		webdriverutility.validation(driver, Modify.getSelectionWindowEdit_BTN(), "SELECTION WINDOW EDIT BTN");
		Modify.getSelectionWindowEdit_BTN().click();
		Reporter.log("SELECTION WINDOW EDIT IS FUNCTIONING PROPERLY", true);

		// FILTER 3 DOTS
		webdriverutility.MultipleFilter3Dots(driver, Modify.getModifyReportNo3Dots(), reportno2);

		Thread.sleep(1000);

		// REPORT VALIDATION IF THE REPORT IS GETTIGN FILTERED AND SHOWING IT ON ...
		Assert.assertTrue(webdriverutility.FilterVal(driver, Modify.getModifyReportNo_List(), reportno2),
				"ISSUE!!! FILTER REPORT IS NOT SHOWED IN MODIFY...");

//		commenting it cause i dont want to carry new spools everytime
		webdriverutility.ClickableElement(driver, Modify.getSelect1stRow());
		Modify.getSelect1stRow().click();
		Reporter.log("1st row is getting selected ", true);

		Thread.sleep(10000);

		Reporter.log("SELECTION TOTAL NO OF RECORDS " + Modify.getSelectionTotalNoOfRecords().getText(), true);

		Reporter.log("CREATTION TOTAL NO OF RECORDS " + Modify.getCreationtotalNoOfRecords().getText(), true);

		// CREATION WINDOW EDIT...
		webdriverutility.ClickableElement(driver, Modify.getCreationWindowEdit_BTN());
		webdriverutility.validation(driver, Modify.getCreationWindowEdit_BTN(), "CREATION WINDOW EDIT BTN");
		Modify.getCreationWindowEdit_BTN().click();
		Reporter.log("CREATION EDIT BTN is FUNCTIONING PROPERLY", true);

		// SELECT ALL
		webdriverutility.ClickableElement(driver, Modify.getSelectAllRow());
		Modify.getSelectAllRow().click();

//		List<WebElement> list = Modify.getCreationListSelected();

		// Verify that all checkboxes are selected

		for (WebElement line : Modify.getCreationListSelected()) {
			if (line.isSelected()) {
				System.out.println(line.getText() + " is DISPLAYED");
				continue;
			}
		}
		Reporter.log("LINE ID's DISPLAYING in CREATION WINDOW", true);

		// HASHMAP FROM MODIFY SPOOLNO AND JOINT NO....
		HashMap<String, String> TC3HM3 = ListUtility.ToItterateList(Modify.getCreationSpool_NoList(),
				Modify.getCreationJoint_NoList());

		// SPOOL NAME AND JOITN NO VAL ON MODIFY...
		Assert.assertTrue(ListUtility.areMapsEqual(TC3HM1, TC3HM3),
				"!!!ISSUE...REPORT NO IS NOT CONTAINING SAME SPOOL NO AND JOINTS" + " FOR SAME REPORT...");

		// CREATION SAVE...
		webdriverutility.ClickableElement(driver, Modify.getCreationSave_BTN());
		webdriverutility.validation(driver, Modify.getCreationSave_BTN(), "CREATION SAVE BTN");
		Modify.getCreationSave_BTN().click();
		Reporter.log("CREATION SAVE BTN is FUNCTIONING PROPERLY", true);

//		POPUP VAL		
		webdriverutility.popupVal(driver);

//		Reporter.log("DATA SAVED SUCCESSFULLY DISPLAYED ", fc.getDataSavedSuccessfully_POPUP().isDisplayed());
		Thread.sleep(500);
//		fc.getDataSavedSuccessfully_POPUPClose().click();

		Allure.step("FITUP REPORT SAVING WITH AUTO REPORT NO. VAL ON MODIFY...");

		// TC FOR REJECTING OBSERVATION FOR SPOOL JOINT AND CHECKING IF IT IS GETTING
		// BACK IN FITUP COMPLETION

		webdriverutility.ClickableElement(driver, Modify.getCreationWindowEdit_BTN());
		Modify.getCreationWindowEdit_BTN().click();

		// GETTING FIRST VALUE JOINT...

		// You’re seeing Optional[01] because you’re directly converting the Optional
		// returned by findFirst() to a String using String.valueOf().
		// When you do this, it converts the Optional itself to a string representation,
		// which is why you see Optional[01].
		// SO I WONT BE ABLE TO USE BELOW METHOD..
//		String Spool_No = String.valueOf(TC3HM3.keySet().stream().findFirst());
//		String Report_joint = String.valueOf((TC3HM3.values().stream().findFirst()));

		String Spool_No = TC3HM3.keySet().stream().findFirst() // Get the first KEY as an Optional
				.map(String::valueOf) // Map the value to a String if present
				.orElse("default_value"); // Provide a default value if empty
		// NOW IT WILL SEND ME ONLY 01

		String Report_joint = TC3HM3.values().stream().findFirst() // Get the first value as an Optional
				.map(String::valueOf) // Map the value to a String if present
				.orElse("default_value"); // Provide a default value if empty

//		//UNDERSTAND THIS PROPERLY
//		TC3HM3.entrySet().stream().findFirst().ifPresent((entry -> System.out.println("First entry: Key = " + entry.getKey() + ", Value = " + entry.getValue())));

		System.out.println("FIRST SPOOL " + Spool_No);

		System.out.println("FIRST JOINT " + Report_joint);

		// joints 3dots ...
		webdriverutility.ClickableElement(driver, Modify.getJointsNo3DOTS());
		webdriverutility.MultipleFilter3Dots(driver, Modify.getJointsNo3DOTS(), Report_joint);

		// FILTER VAL
		csa.assertTrue(webdriverutility.FilterVal(driver, Modify.getJointNo_List(), Report_joint),
				"!!!ISSUEEE...REPORT JOINT NO IS NOT GETTING FILTERED...");

		//CREATION EDIT...
		webdriverutility.ClickableElement(driver,Modify.getCreationWindowEdit_BTN());
		Modify.getCreationWindowEdit_BTN().click();
		
		// SCROLL TO OBSERVATION...
		act.moveToElement(Modify.getObservation_Col()).perform();

		// CLICKING FIRST OBSERCATION CAN ALSO DO IT WITH BOTH FILTERS SPOOL AND JOINT
		// TO REJECT PERTICULAR SPOOL
		webdriverutility.ClickableElement(driver, Modify.getFirstObservation());
		Modify.getFirstObservation().click();

		// CLICKING OBSERCATION DD...
		webdriverutility.ClickableElement(driver, Modify.getObsercation_DD());
		Modify.getObsercation_DD().click();
		
		Thread.sleep(600);

		// REJECTING WITHOUT SELECTING THE ROW IT SHOULD GIVE US POPUP TO SELECT ROW
		webdriverutility.ClickableElement(driver, Modify.getObs_Rejected());
		Modify.getObs_Rejected().click();

		// SAVE
		webdriverutility.ClickableElement(driver, Modify.getCreationSave_BTN());
		Modify.getCreationSave_BTN().click();

		// POPUP VAL...
		webdriverutility.popupVal(driver);
		
//		//FILTER JOINT
//		webdriverutility.ClickableElement(driver,Modify.getJointsNo3DOTS());
//		webdriverutility.MultipleFilter3Dots(driver,Modify.getJointsNo3DOTS(),Report_joint);
//		
//		//FILTER VAL
//		csa.assertTrue(webdriverutility.FilterVal(driver,Modify.getCreationJoint_NoList(), Report_joint),"!!!ISSUEEE...REPORT JOINT NO IS NOT GETTING FILTERED...");

		// SELECTING FIRST ROW...
		webdriverutility.ClickableElement(driver, Modify.getSelect1stRow());
		Modify.getSelect1stRow().click();

		// SAVE
		webdriverutility.ClickableElement(driver, Modify.getCreationSave_BTN());
		Modify.getCreationSave_BTN().click();

		// POPUP VAL...
		webdriverutility.popupVal(driver);

		// CREATION EDIT
		webdriverutility.ClickableElement(driver, Modify.getCreationWindowEdit_BTN());
		Modify.getCreationWindowEdit_BTN().click();

		// joints 3dots ...
		webdriverutility.ClickableElement(driver, Modify.getJointsNo3DOTS());
		webdriverutility.MultipleFilter3Dots(driver, Modify.getJointsNo3DOTS(), Report_joint);

		csa.assertTrue(webdriverutility.FilterVal(driver, Modify.getJointNo_List(), Report_joint),
				"!!!ISUEEE FILTERED SPOOL SHOULD NOT GET REMOVED FROM THE VIEW MODIFY"
						+ "BUT IT IS STILL GOT REMOVED FROM OBSERVATION AS SHOWN...");

		// FILTER VAL
		Boolean b = webdriverutility.FilterVal(driver, Modify.getJointNo_List(), Report_joint);

//		if (b) {

//		// SCROLL TO OBSERVATION...
//		act.moveToElement(Modify.getObservation_Col()).perform();

//		// SCROLL TO OBSERVATION
		while (!Modify.getObservation_Col().isDisplayed()) {
			act.sendKeys(Keys.ARROW_RIGHT).perform();
			// Optionally, you could add a small pause here without using try-catch
			// Just to allow the page to load, but no sleep is included here
			// You can also adjust this logic if needed
		}

		// EXTRACTING OBSERCATION VALLUE IN FILTERED SPOOL
		webdriverutility.ClickableElement(driver, Modify.getFirstObservation());
		String obsercationValForFilteredJoint = Modify.getFirstObservation().getText();
//			csa.assertTrue(true,"!!!ISSUEEE SPOOL NO -- "+ Spool_No + "& JOINT NO IS-- "+Report_joint + "HAVING OBSERVATION AS " + obsercationValForFilteredJoint);

		csa.assertTrue(obsercationValForFilteredJoint.trim().equals("Rejected"),
				"!!!ISSUE...IN VIEWL MODIFY FILTERED SPOOL JOINT IS SHOWING DIFFERENT OBSERVATION...");

		AllureUtil.takeScreenshot(driver, "!!!ISSUEEE SPOOL NO -- " + Spool_No + "& JOINT NO IS-- " + Report_joint
				+ "HAVING OBSERVATION AS " + obsercationValForFilteredJoint);
//		}

		// SIDEBAR EXPAND
		webdriverutility.ClickableElement(driver, hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		// FITUP REPORT SIDEBAR...
		webdriverutility.ClickableElement(driver, fc.getSideBarFitupReport());
		fc.getSideBarFitupReport().click();

		// VALIDATING IN FITUP REPORT IF IT IS REALLY GETTING REJECTED...
		webdriverutility.ClickableElement(driver, fc.getSpoolName3Dots());
		webdriverutility.MultipleFilter3Dots(driver, fc.getSpoolName3Dots(), Spool_No);

		// VALIDATING IN FITUP REPORT IF IT IS REALLY GETTING REJECTED...
		webdriverutility.ClickableElement(driver, fc.getJointNo3DOTS());
		webdriverutility.MultipleFilter3Dots(driver, fc.getJointNo3DOTS(), Report_joint);

		// FILTER VAL...
		csa.assertTrue(webdriverutility.FilterVal(driver, fc.getSelection_SpoolNameList(), Spool_No),
				"!!!ISUEEEE ...FILTERED SPOOL IS NOT PRESENT IN FITUP CLRETION AFTER"
						+ "REJECTING IT FROM VIEW MODIFY...");
		
		csa.assertTrue(webdriverutility.FilterVal(driver,fc.getSelection_JointNoList(), Report_joint),"!!!ISUEEEE ...FILTERED joint IS NOT PRESENT IN FITUP"
				+ "CLRETION AFTER REJECTING IT FROM VIEW MODIFY...");

		Allure.step("TC FOR REJECTING OBSERVATION FOR SPOOL JOINT AND CHECKING IF IT IS PRESENT BACK IN FITUP...");

		//TC FOR REJECTED SPOOL JOINT--> ADDING IT AGAIN IN SAME REPORT--> IT SHOULD GIVE YOU ERROR POPUP...
		
		//EDIT
		webdriverutility.ClickableElement(driver,fc.getSelectionWindowEdit_BTN());
		fc.getSelectionWindowEdit_BTN().click();		
		
		// SELECT ALL
		webdriverutility.ClickableElement(driver, fc.getSelectAllRow_CHECKBOX());
		fc.getSelectAllRow_CHECKBOX().click();
		Thread.sleep(3000);

		// CREATION EDIT
		webdriverutility.ClickableElement(driver, fc.getCreationWindowEdit_BTN());
		fc.getCreationWindowEdit_BTN().click();


		// REPORT DETAILS BTN
		webdriverutility.ClickableElement(driver, fc.getReportDetails_BTN());
		webdriverutility.validation(driver, fc.getReportDetails_BTN(), "CREATION WINDOW EDIT");
		fc.getReportDetails_BTN().click();
		Reporter.log("CREATION WINDOW REPORT DETAIL BTN is FUNCTIONING PROPERLY", true);

		Thread.sleep(1500);

		// AUTO GENERATE REPORT NO CHEKBOX
		webdriverutility.ClickableElement(driver, fc.getAutogenerateReportNo_CHECKBOX());
		webdriverutility.validation(driver, fc.getAutogenerateReportNo_CHECKBOX(), "AUTO GENERATED CHECKBOX");
		act.click(fc.getAutogenerateReportNo_CHECKBOX()).perform();

//		fc.getAutogenerateReportNo_CHECKBOX().click();    
		Reporter.log("AUTO GENERATED CHECKBOX IS FUNCTIONING PROPERLY", true);

		// REPORT NO DD
		webdriverutility.ClickableElement(driver, fc.getReportNo_DD());
		webdriverutility.validation(driver, fc.getReportNo_DD(), "REPORT NO. DD");
		fc.getReportNo_DD().click();
		Reporter.log("REPORT NO. DD IS FUNCTIONING PROPERLY", true);

		// FOR ME TO CHANGE INPUT EVERYTIME
		
		int j = 300 - Integer.valueOf(x);

		String z = String.valueOf(j);

		// REPORT NO DD INPUT...
		webdriverutility.ClickableElement(driver, fc.getReportNoDDInput());
		webdriverutility.textConfirmation(driver, fc.getReportNoDDInput(), reportno2, "REPORT NO. DD input ");
		Reporter.log("REPORT NO. DD input IS FUNCTIONING PROPERLY", true);

		Thread.sleep(1500);

//		// REPORT NO ADD BTN...
//		webdriverutility.ClickableElement(driver, fc.getReportNoADD_BTN());
//		webdriverutility.validation(driver, fc.getReportNoADD_BTN(), "REPORT NO. ADD btn");
//		fc.getReportNoADD_BTN().click();
//		Reporter.log("REPORT NO. SDD btn IS FUNCTIONING PROPERLY", true);

		fc.getReportNoDDInput().sendKeys(Keys.ENTER);

		// APPLY ALL OBSERVATION DDTXT...
		webdriverutility.ClickableElement(driver, fc.getApplyAllObservation_DDTXT());
		webdriverutility.validation(driver, fc.getApplyAllObservation_DDTXT(), "APPLY ALL OBSERVATION");
		fc.getApplyAllObservation_DDTXT().sendKeys("Accepted" + Keys.ENTER);
		Reporter.log("APPLY ALL OBSERVATION DD TXT IS FUNCTIONING PROPERLY", true);

//		// FITUP REPORT CREATION SAVE BTN...
//		webdriverutility.ClickableElement(driver, fc.getFitupReportCreationSave_BTN());
//		webdriverutility.validation(driver, fc.getFitupReportCreationSave_BTN(), "FITUP CREATION SAVE BTN");
//		fc.getFitupReportCreationSave_BTN().click();
//		Reporter.log("FITUP REPORT CREATION SAVE BTN IS FUNCTIONING PROPERLY", true);
//
//		// POPUP YES...
//		webdriverutility.ClickableElement(driver, spoolutil.getPopupYes_BTN());
//		spoolutil.getPopupYes_BTN().click();
//		Reporter.log("POPUP YES FUNCTIONING PROPERLY", true);
//
//		// POPUP VAL
//		webdriverutility.popupVal(driver);

		// FILL MASTER DETAILS COLLAPSE...
		webdriverutility.ClickableElement(driver, fc.getFillMasterDetailsCollapse());
		webdriverutility.validation(driver, fc.getCreationSave_BTN(), "FILL MASTER COLLAPSE");
		fc.getFillMasterDetailsCollapse().click();
		Reporter.log("FILL MASTER COLLAPSE BTN IS FUNCTIONING PROPERLY", true);

		// YARD DD..
		webdriverutility.ClickableElement(driver, fc.getFM_YardDD());
		fc.getFM_YardDD().click();
		Reporter.log("FILL MASTER YARD DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		// YARD DD INPUT
		webdriverutility.ClickableElement(driver, fc.getFM_YardDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_YardDDInput(), "YD_" + z, "YARD INPUT");
		Reporter.log("FILL MASTER YARD DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		// FM ADD NEW ITEM
		webdriverutility.ClickableElement(driver, fc.getFM_YardAddNewItem());
		fc.getFM_YardAddNewItem().click();
		Reporter.log("FILL MASTER YARD ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_YardDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		MODULE NO
		webdriverutility.ClickableElement(driver, fc.getFM_ModuleNoDD());
		fc.getFM_ModuleNoDD().click();
		Reporter.log("FILL MASTER MODULE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_ModuleNoDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_ModuleNoDDInput(), "MO_" + z, "MODULE INPUT");
		Reporter.log("FILL MASTER MODULE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_ModuleNoAddNewItem());
		fc.getFM_ModuleNoAddNewItem().click();
		Reporter.log("FILL MASTER MODULE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_ModuleNoDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		RFINO
		webdriverutility.ClickableElement(driver, fc.getFM_RFINoDD());
		fc.getFM_RFINoDD().click();
		Reporter.log("FILL MASTER RFI NO DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_RFINoDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_RFINoDDInput(), "RFI_" + z, "RFI NO. INPUT");
		Reporter.log("FILL MASTER RFI NO DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_RFINoAddNewItem());
		fc.getFM_RFINoAddNewItem().click();
		Reporter.log("FILL MASTER RFI NO ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_RFINoDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		RFI DATE...

//		RFI DATE VALIDATION
		csa.assertTrue(fc.getFM_DateOfRFI().getAttribute("value").equals(JavaUtility.TodaysDate()));

		Thread.sleep(500);

//		LOCATION DD...
		webdriverutility.ClickableElement(driver, fc.getFM_LocationDD());
		fc.getFM_LocationDD().click();
		Reporter.log("FILL MASTER LOCATION DD IS FUNCTIONING PROPERLY", true);


		Thread.sleep(500);
		// LOCATION DD INPUT
		
//		String Loc = "JAA";
		webdriverutility.ClickableElement(driver, fc.getFM_LocationDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_LocationDDInput(), location, "LOCATION DD INPUT");
		Reporter.log("FILL MASTER LOCATION DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
//		// ADD NEW ITEM...
//		webdriverutility.ClickableElement(driver, fc.getFM_LocationAddNewItem());
//		fc.getFM_LocationAddNewItem().click();
//		Reporter.log("FILL MASTER LOCATION ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_LocationDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

		Thread.sleep(500);
//		INFECTION DATE VALIDATION...
		csa.assertTrue(fc.getFM_InspectionDate().getAttribute("value").equals(JavaUtility.TodaysDate()));

		Thread.sleep(500);
//		CODE/SPEC 
		webdriverutility.ClickableElement(driver, fc.getFM_CodeSpecDD());
		fc.getFM_CodeSpecDD().click();
		Reporter.log("FILL MASTER SPEC/CODE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_CodeSpecDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_CodeSpecDDInput(), "COD_" + z, "SPEC/CODE INPUT");
		Reporter.log("FILL MASTER SPEC/CODE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
		// ADD NEW ITEM...
		webdriverutility.ClickableElement(driver, fc.getFM_CodeSpecAddNewItem());
		fc.getFM_CodeSpecAddNewItem().click();
		Reporter.log("FILL MASTER SPEC/CODE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_CodeSpecDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		PROCEDURE
		webdriverutility.ClickableElement(driver, fc.getFM_ProcedureDD());
		fc.getFM_ProcedureDD().click();
		Reporter.log("FILL MASTER PROCEDURE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_ProcedureDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_ProcedureDDInput(), "PRO_" + z, "PROCEDURE INPUT");
		Reporter.log("FILL MASTER PROCEDURE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
		// ADD NEW ITEM...
		webdriverutility.ClickableElement(driver, fc.getFM_ProcedureAddNewItem());
		fc.getFM_ProcedureAddNewItem().click();
		Reporter.log("FILL MASTER PROCEDURE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_ProcedureDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

//		ACCEPTANCE CRITERIA
		webdriverutility.ClickableElement(driver, fc.getFM_AcceptCriteriaDD());
		fc.getFM_AcceptCriteriaDD().click();
		Reporter.log("FILL MASTER ACCEPTANCE DD IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);

		webdriverutility.ClickableElement(driver, fc.getFM_AcceptCriteriaDDInput());
		webdriverutility.textConfirmation(driver, fc.getFM_AcceptCriteriaDDInput(), "A_" + z, "ACCEPTANCE INPUT");
		Reporter.log("FILL MASTER ACCEPTANCE DD INPUT IS FUNCTIONING PROPERLY", true);

		Thread.sleep(500);
		// ADD NEW ITEM...
		webdriverutility.ClickableElement(driver, fc.getFM_AcceptCriteriaAddNewItem());
		fc.getFM_AcceptCriteriaAddNewItem().click();
		Reporter.log("FILL MASTER ACCEPTANCE ADD NEW ITEM DD IS FUNCTIONING PROPERLY", true);

		fc.getFM_AcceptCriteriaDDInput().sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value = arguments[1];",fc.getFM_YardDDInput(),Keys.ENTER);

		// FITUP REPORT CREATION SAVE ...
		webdriverutility.ClickableElement(driver, fc.getFitupReportCreationSave_BTN());
		webdriverutility.validation(driver, fc.getFitupReportCreationSave_BTN(), "FITUP CREATION SAVE BTN");
		fc.getFitupReportCreationSave_BTN().click();
		Reporter.log("FITUP REPORT CREATION SAVE BTN IS FUNCTIONING PROPERLY", true);


		// POPUP YES...
		webdriverutility.ClickableElement(driver, spoolutil.getPopupYes_BTN());
		spoolutil.getPopupYes_BTN().click();
		Reporter.log("POPUP YES FUNCTIONING PROPERLY", true);

		// CREATION SAVE ...
		webdriverutility.ClickableElement(driver, fc.getCreationSave_BTN());
		webdriverutility.validation(driver, fc.getCreationSave_BTN(), "CREATION SAVE BTN");
		fc.getCreationSave_BTN().click();
		Reporter.log("FITUP CREATION SAVE BTN IS FUNCTIONING PROPERLY", true);

//		//SIGNATURE POPUP NO...
//		webdriverutility.ClickableElement(driver,fc.getSignaturePOPUPNo());
//		webdriverutility.validation(driver,fc.getSignaturePOPUPNo(),"SIGNATURE POPUP NO");						
//		fc.getSignaturePOPUPNo().click();
//		Reporter.log("SIGNATURE NO BTN IS FUNCTIONING PROPERLY",true);

//		POPUP VAL		
		webdriverutility.popupVal(driver);

		Allure.step("TC FOR REJECTED SPOOL JOINT--> ADDING IT AGAIN IN SAME REPORT--> IT SHOULD GIVE YOU ERROR POPUP...");
		
		AllureUtil.attachText("yooooo", "very nice");

		
		//14-10-2024
		
		// SIDEBAR FITUMP VIEW MODIFY REPORT...
		webdriverutility.ClickableElement(driver, fc.getSideBarFitupViewModifyReport());
		webdriverutility.validation(driver, fc.getSideBarFitupViewModifyReport(), "SIDEBAR FITUP FITUP VIEW MODIFY");
		fc.getSideBarFitupViewModifyReport().click();
		Reporter.log("SIDEBAR FITUP VIEW MODE IS FUNCTIONING PROPERLY", true);

		// SIDEBAR EXPAND...
		webdriverutility.ClickableElement(driver, hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		Thread.sleep(600);

		// SELECTION TOTAL NO OF RECORDS...
		Reporter.log("selection total no of records" + Modify.getSelectionTotalNoOfRecords().getText(), true);

		// CREATION TOTAL NO OF RECORDS...
		Reporter.log("creation total no of records" + Modify.getCreationtotalNoOfRecords().getText(), true);

		// SELECTION WINDOW EDIT...
		webdriverutility.ClickableElement(driver, Modify.getSelectionWindowEdit_BTN());
		webdriverutility.validation(driver, Modify.getSelectionWindowEdit_BTN(), "SELECTION WINDOW EDIT BTN");
		Modify.getSelectionWindowEdit_BTN().click();
		Reporter.log("SELECTION WINDOW EDIT IS FUNCTIONING PROPERLY", true);

		// FILTER 3 DOTS
		webdriverutility.MultipleFilter3Dots(driver, Modify.getModifyReportNo3Dots(), reportno2);

		Thread.sleep(1000);

		// REPORT VALIDATION IF THE REPORT IS GETTIGN FILTERED AND SHOWING IT ON ...
		Assert.assertTrue(webdriverutility.FilterVal(driver, Modify.getModifyReportNo_List(), reportno2),
				"ISSUE!!! FILTER REPORT IS NOT SHOWED IN MODIFY...");

//		commenting it cause i dont want to carry new spools everytime
		webdriverutility.ClickableElement(driver, Modify.getSelect1stRow());
		Modify.getSelect1stRow().click();

		Thread.sleep(5000);

		Reporter.log("SELECTION TOTAL NO OF RECORDS " + Modify.getSelectionTotalNoOfRecords().getText(), true);

		Reporter.log("CREATTION TOTAL NO OF RECORDS " + Modify.getCreationtotalNoOfRecords().getText(), true);

		// CREATION WINDOW EDIT...
		webdriverutility.ClickableElement(driver, Modify.getCreationWindowEdit_BTN());
		Modify.getCreationWindowEdit_BTN().click();

		webdriverutility.ClickableElement(driver,Modify.getSpoolNo3DOTS());
		webdriverutility.MultipleFilter3Dots(driver,Modify.getSpoolNo3DOTS(), Spool_No);
		
		webdriverutility.ClickableElement(driver,Modify.getJointsNo3DOTS());
		webdriverutility.MultipleFilter3Dots(driver,Modify.getJointsNo3DOTS(), Report_joint);

		csa.assertTrue( webdriverutility.FilterVal(driver, Modify.getCreationJoint_NoList(), Report_joint),"!!!ISSUE "
				+ "FILTER REPORT JOINT DID NOT MATCH...");
		
		webdriverutility.ClickableElement(driver,Modify.getSelectAllRow());
		Modify.getSelectAllRow().click();
					
		// SCROLL TO OBSERVATION...
		act.moveToElement(Modify.getObservation_Col()).perform();

		// CLICKING FIRST OBSERCATION CAN ALSO DO IT WITH BOTH FILTERS SPOOL AND JOINT
		// TO REJECT PERTICULAR SPOOL
		webdriverutility.ClickableElement(driver, Modify.getFirstObservation());
		Modify.getFirstObservation().click();

		// CLICKING OBSERCATION DD...
		webdriverutility.ClickableElement(driver, Modify.getObsercation_DD());
		Modify.getObsercation_DD().click();
		
		Thread.sleep(600);

		// REJECTING WITHOUT SELECTING THE ROW IT SHOULD GIVE US POPUP TO SELECT ROW
		webdriverutility.ClickableElement(driver, Modify.getObs_Accepted());
		Modify.getObs_Accepted().click();


//		// SELECTING FIRST ROW...
//		webdriverutility.ClickableElement(driver, Modify.getSelectAllRow());
//		Modify.getSelectAllRow().click();

		// SAVE
		webdriverutility.ClickableElement(driver, Modify.getCreationSave_BTN());
		Modify.getCreationSave_BTN().click();

		// POPUP VAL...
		webdriverutility.popupVal(driver);

		// CREATION EDIT
		webdriverutility.ClickableElement(driver, Modify.getCreationWindowEdit_BTN());
		Modify.getCreationWindowEdit_BTN().click();

		// joints 3dots ...
		webdriverutility.ClickableElement(driver, Modify.getJointsNo3DOTS());
		webdriverutility.MultipleFilter3Dots(driver, Modify.getJointsNo3DOTS(), Report_joint);

		csa.assertTrue(webdriverutility.FilterVal(driver, Modify.getJointNo_List(), Report_joint),
				"!!!ISUEEE FILTERED SPOOL IS NOT PRESENT IN THE GRID");


//		// SCROLL TO OBSERVATION
		while (!Modify.getObservation_Col().isDisplayed()) {
			act.sendKeys(Keys.ARROW_RIGHT).perform();
			// Optionally, you could add a small pause here without using try-catch
			// Just to allow the page to load, but no sleep is included here
			// You can also adjust this logic if needed
		}

		// EXTRACTING OBSERCATION VALLUE IN FILTERED SPOOL
		webdriverutility.ClickableElement(driver, Modify.getFirstObservation());
		String obsercationValForFilteredJointAccepted = Modify.getFirstObservation().getText();
//			csa.assertTrue(true,"!!!ISSUEEE SPOOL NO -- "+ Spool_No + "& JOINT NO IS-- "+Report_joint + "HAVING OBSERVATION AS " + obsercationValForFilteredJoint);

		csa.assertTrue(obsercationValForFilteredJointAccepted.trim().equals("Accepted"),
				"!!!ISSUE...IN VIEWL MODIFY FILTERED SPOOL JOINT IS SHOWING DIFFERENT OBSERVATION...");

		AllureUtil.takeScreenshot(driver, "!!!ISSUEEE SPOOL NO -- " + Spool_No + "& JOINT NO IS-- " + Report_joint
				+ "HAVING OBSERVATION AS " + obsercationValForFilteredJointAccepted);

		
		// SIDEBAR EXPAND
		webdriverutility.ClickableElement(driver, hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		// FITUP REPORT SIDEBAR...
		webdriverutility.ClickableElement(driver, fc.getSideBarFitupReport());
		fc.getSideBarFitupReport().click();

		// VALIDATING IN FITUP REPORT IF IT IS REALLY GETTING REJECTED...
		webdriverutility.ClickableElement(driver, fc.getSpoolName3Dots());
		webdriverutility.MultipleFilter3Dots(driver, fc.getSpoolName3Dots(), Spool_No);

		// VALIDATING IN FITUP REPORT IF IT IS REALLY GETTING REJECTED...
		webdriverutility.ClickableElement(driver, fc.getJointNo3DOTS());
		webdriverutility.MultipleFilter3Dots(driver, fc.getJointNo3DOTS(), Report_joint);

		// FILTER VAL...
		csa.assertFalse(webdriverutility.FilterVal(driver, fc.getSelection_SpoolNameList(), Spool_No),
				"!!!ISUEEEE ...FILTERED SPOOL IS PRESENT IN FITUP CREATION EVEN AFTER"
						+ "ACCEPTING IT FROM VIEW MODIFY...");
		
		Allure.step("TC FOR ACCEPTING OBSERVATION FOR SPOOL JOINT IN VIEW MODIFY AND CHECKING IF IT IS GETTING REMOVED FROM FITUP CREAIION...");

		Reporter.log("YOUUUU",true);
		
		csa.assertAll();


	}

}

/*
 * please update spoolno = reportnot = pmireportno = everytime for smooth
 * functionality for this i have give @TEST at class as well the login val that
 * i am picking from pgold automation maven project as well in base class i am
 * using
 * 
 * @beforeclass and @afterclass
 */


// HAVE TO UPDATE SPOOL NO. LINE NO 182 , 334

