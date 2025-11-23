/**
 * AUTHOR - PUNIT MORE
 * DATE - 20-01-2024;
 * DESC - POGOLD-->SPOOLMAN-ERMAN-->SELECT PROJECT-->9DOTS-->PROJECT-->WELDING-->MASTERS
 * --> WELDING MASTER SCRIPT
 * UPDATED - 
 */

package spoolman.Welding;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.pcpl.genericutility.BaseClass;
import com.pcpl.genericutility.Captcha;
import com.pcpl.genericutility.DownloadUtility;
import com.pcpl.genericutility.ExcelUtility;
import com.pcpl.genericutility.FileUtility;
import com.pcpl.pomrepository.TestPgold_HomePage;
import com.pcpl.pomrepository.TestPgold_SignIn;
import com.pcpl.spoolman.home.TestSpoolman_Home;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingWPSDetails;

public class MasterWPS_WPSDetails extends BaseClass {
	
	@Test 
	public void WeldingWPSMasterAll() throws Throwable {
			
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
		
		Thread.sleep(1500);
		
//		webdriverutility.ClickableElement(driver,sm.getWeldingMaster());
//		sm.getWeldingMaster().click();

		TestSpoolman_WeldingWPSDetails wps = new TestSpoolman_WeldingWPSDetails(driver);
		
		webdriverutility.ClickableElement(driver,hp.getExpandSidebar());
		hp.getExpandSidebar().click();

		webdriverutility.ClickableElement(driver,wps.getEdit_BTN());
		webdriverutility.validation(driver,wps.getEdit_BTN(),"EDIT BTN");						
		wps.getEdit_BTN().click();
		Reporter.log("EDIT BTN is FUNCTIONING PROPERLY ",true);
/*		
		webdriverutility.ClickableElement(driver,wps.getADD_BTN());
		webdriverutility.validation(driver,wps.getADD_BTN(),"ADD BTN");						
		wps.getADD_BTN().click();
		Reporter.log("ADD BTN is FUNCTIONING PROPERLY ",true);		
		
		wps.getWPSNo_1().click();
		Thread.sleep(500);
		act.sendKeys("WPS_01").perform();;
		
		wps.getRevNo_1().click();
		Thread.sleep(500);
		act.sendKeys("0").perform();;
		
		wps.getPNO_01_1().click();
		Thread.sleep(500);
		act.sendKeys("1").perform();;
		
		wps.getPNO_02_1().click();
		Thread.sleep(500);
		act.sendKeys("1").perform();;

		wps.getWeldingProcess_1().click();
		Thread.sleep(500);
		act.sendKeys("SMAW").perform();;

		wps.getDiaMin_1().click();
		Thread.sleep(500);
		act.sendKeys("0").perform();;

		wps.getDiaMax_1().click();
		Thread.sleep(500);
		act.sendKeys("10").perform();;
		
		wps.getThicknessMin_1().click();
		Thread.sleep(500);
		act.sendKeys("0").perform();;

		wps.getThicknessMax_1().click();
		Thread.sleep(500);
		act.sendKeys("10").perform();;

		js.executeScript("arguments[0].scrollIntoView(true);",wps.getJointType_1());
		
		webdriverutility.ClickableElement(driver,wps.getADD_BTN());
		webdriverutility.validation(driver,wps.getADD_BTN(),"ADD BTN");						
		wps.getADD_BTN().click();
		Reporter.log("ADD BTN is FUNCTIONING PROPERLY ",true);		
		
		wps.getWPSNo_2().click();
		Thread.sleep(500);
		act.sendKeys("WPS_02").perform();;
		
		wps.getRevNo_2().click();
		Thread.sleep(500);
		act.sendKeys("0").perform();;
		
		wps.getPNO_01_2().click();
		Thread.sleep(500);
		act.sendKeys("1").perform();;
		
		wps.getPNO_02_2().click();
		Thread.sleep(500);
		act.sendKeys("1").perform();;

		wps.getWeldingProcess_2().click();
		Thread.sleep(500);
		act.sendKeys("GTAW").perform();;
		
		wps.getDiaMin_2().click();
		Thread.sleep(500);
		act.sendKeys("0").perform();;

		wps.getDiaMax_2().click();
		Thread.sleep(500);
		act.sendKeys("10").perform();;
		
		wps.getThicknessMin_2().click();
		Thread.sleep(500);
		act.sendKeys("0").perform();;

		wps.getThicknessMax_2().click();
		Thread.sleep(500);
		act.sendKeys("10").perform();;

		js.executeScript("arguments[0].scrollIntoView(true);",wps.getJointType_1());

		webdriverutility.ClickableElement(driver,wps.getADD_BTN());
		webdriverutility.validation(driver,wps.getADD_BTN(),"ADD BTN");						
		wps.getADD_BTN().click();
		Reporter.log("ADD BTN is FUNCTIONING PROPERLY ",true);		
		
		wps.getWPSNo_3().click();
		Thread.sleep(500);
		act.sendKeys("WPS_03").perform();;
		
		wps.getRevNo_3().click();
		Thread.sleep(500);
		act.sendKeys("0").perform();;
		
		wps.getPNO_01_3().click();
		Thread.sleep(500);
		act.sendKeys("1").perform();;
		
		wps.getPNO_02_3().click();
		Thread.sleep(500);
		act.sendKeys("1").perform();;

		wps.getWeldingProcess_3().click();
		Thread.sleep(500);
		act.sendKeys("SAW").perform();;

		wps.getDiaMin_3().click();
		Thread.sleep(500);
		act.sendKeys("0").perform();;

		wps.getDiaMax_3().click();
		Thread.sleep(500);
		act.sendKeys("10").perform();;
		
		wps.getThicknessMin_3().click();
		Thread.sleep(500);
		act.sendKeys("0").perform();;

		wps.getThicknessMax_3().click();
		Thread.sleep(500);
		act.sendKeys("10").perform();;

		js.executeScript("arguments[0].scrollIntoView(true);",wps.getJointType_1());
		
		webdriverutility.ClickableElement(driver,wps.getSelect1stRow_CHECKBOX());
		wps.getSelectionSelectAllRow_CHECKBOX().click();
		
		webdriverutility.ClickableElement(driver,wps.getSAVE_BTN());
		webdriverutility.validation(driver,wps.getSAVE_BTN(),"SAVE BTN");
		wps.getSAVE_BTN().click();
		Reporter.log("SAVE BTN IS FUNCTIONING PROPERLY",true);		
		
		Assert.assertTrue(wps.getDataSavedSuccsessfully_POPUP().isDisplayed(),
				"DATA SAVE SUCCESSFULLY DISPLAYED");
		
		Thread.sleep(500);
		
		wps.getDataSavedSuccsessfully_POPUPClose().click();
	
		webdriverutility.ClickableElement(driver,wps.getEdit_BTN());
		wps.getEdit_BTN().click();		
			
		webdriverutility.ClickableElement(driver,wps.getFullScreen_BTN());
		webdriverutility.validation(driver,wps.getFullScreen_BTN(),"FULLSCREEN BTN");
		wps.getFullScreen_BTN().click();
		Reporter.log("FULLSCREEN BTN is FUNCTIONING PROPERLY",true);
		Thread.sleep(1000);
						
		webdriverutility.ClickableElement(driver,wps.getSelect1stRow_CHECKBOX());
		webdriverutility.validation(driver,wps.getSelect1stRow_CHECKBOX(),"1st Checkbox");
		wps.getSelect1stRow_CHECKBOX().click();
		Reporter.log("SELECT 1ST CHECKBOX",true);

		Thread.sleep(2500);
		webdriverutility.ClickableElement(driver,wps.getDELETE_BTN());
		webdriverutility.validation(driver,wps.getDELETE_BTN(),"DELETE BTN");
		wps.getDELETE_BTN().click();
//		act.click(wps.getDELETE_BTN()).perform();
//		act.sendKeys(wps.getDELETE_BTN(),Keys.ENTER).perform();;
//		act.doubleClick(wps.getDELETE_BTN()).perform();
		Reporter.log("DELETE BTN is FUNCTIONING PROPERLY",true);
		
		Reporter.log("DATA DETELETED SUCCESSFULLY DISPLAYED",
				wps.getDataDeletedSuccessfully_POPUP().isDisplayed());
		
		wps.getDataDeletedSuccessfully_POPUP().click();
		
//		driver.navigate().refresh();
		
//		webdriverutility.ClickableElement(driver,wps.getEdit_BTN());
//		wps.getEdit_BTN().click();		
//		
//		webdriverutility.ClickableElement(driver,wps.getCompress_BTN());
//		webdriverutility.validation(driver,wps.getCompress_BTN(),"COMPRESS BTN");
//		wps.getCompress_BTN().click();
//		Reporter.log("COMPRESS BTN is FUNCTIONING PROPERLY",true);

		
//		UPLOAD CLICK
		
		wps.getEdit_BTN().click();
		
		webdriverutility.validation(driver,wps.getUpload_BTN(),"UPLOAD BTN");
		wps.getUpload_BTN().click();
		Reporter.log("UPLOAD BUTTON Functioning properly",true);

		driver.switchTo().frame(0);
		
		Thread.sleep(1500);
//		ACTION CLASS USED TO CLICK ON WITH HELP OF MOUSE AND KEYBOARD	

		act.click(wps.getChooseFile_BTN());
		Reporter.log("CHOOSE FILE from UPLOAD POPUP is clickable",true);
				
		wps.getChooseFile_BTN().sendKeys("C:\\Users\\user\\Desktop\\pcm\\UPLOAD DATA\\1. PLANNING MASTER\\11. WPS MASTER.xlsx");
	    
		Thread.sleep(2000);
//		SELECT CLASS USED TO SELECT ELEMENT FROM DROPDOWN
		Select s = new Select(wps.getWorksheet_DD());
		
		s.selectByVisibleText("Sheet1$");
		Reporter.log("Sheet is being selected by select class",true);
		
		Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,wps.getAutoMapColumns_BTN());
		wps.getAutoMapColumns_BTN().click();
		Reporter.log("selecting automap CHECKBOX ",true);
		
		webdriverutility.ClickableElement(driver,wps.getProceed_BTN());
		webdriverutility.validation(driver,wps.getProceed_BTN(),"PROCEED BTN");	
//		js.executeScript("arguments[0].click();",wps.getProceed_BTN());
//		act.click(wps.getProceed_BTN()).perform();		
		wps.getProceed_BTN().click();
//		wps.getProceed_BTN().sendKeys(Keys.ENTER);
//		Reporter.log("proceed button in UPLOAD popup IS FUNCTIONING PROPERLY",true);
//		Thread.sleep(2000);
		
////		ASSERT FOR WARNING "SAVE DATA SUCCESSFULLY"		
//		Assert.assertTrue(wps.getDataUploadedSuccessfully_POPUP().isDisplayed(),
//				"data save successfully popup did not displayed");
////		POPUP CLOSE "SAVE DATA SUCCESSFULLY"		
//		wps.getDataUploadedSuccessfully_POPUPClose().click();	
*/		
		webdriverutility.ClickableElement(driver,wps.getDownload_BTN());
		webdriverutility.validation(driver,wps.getDownload_BTN(),"UPLOAD BTN");
		wps.getDownload_BTN().click();
		Reporter.log("DOWNLOAD BUTTON Functioning properly",true);

//		ASSERT FOR WARNING " DATA exported SUCCESSFULLY"		
		Assert.assertTrue(wps.getExcelDownloadedSuccessfully_POPUP().isDisplayed(),
			"data save successfully popup did not displayed");
//		POPUP CLOSE "SAVE DATA SUCCESSFULLY"		
		wps.getExcelDownloadedSuccessfully_POPUPClose().click();	
		Thread.sleep(5000);
		DownloadUtility dl = new DownloadUtility(driver);
		dl.DownloadVal();
		
		driver.navigate().back();
		
		Reporter.log("ALL GOOD ",true);
		
		
		
	}
	
}	
	
