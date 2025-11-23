/**
 * AUTHOR - PUNIT MORE
 * DATE - 20-01-2024;
 * DESC - POGOLD-->SPOOLMAN-ERMAN-->SELECT PROJECT-->9DOTS-->PROJECT-->WELDING-->MASTERS
 * -->WELDER-->WELDER DETAILS ALL SCRIPT
 * UPDATED - 
 */

package spoolman.Welding;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
import com.pcpl.spoolman.welding.TestSpoolman_WelderDetails;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingSideBar;
import com.pcpl.spoolman.welding.TestSpoolman_WeldingWPSDetails;

public class MasterWelder_WelderDetails extends BaseClass {

	@Test 
	public void WelderALL() throws Throwable {
			
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
		Reporter.log("AUTOMATION PROJECT IS DISPLAYED",true);
		
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
		
		webdriverutility.ClickableElement(driver,Sidebar.getWelder_Sidebar());
		webdriverutility.validation(driver,Sidebar.getWelder_Sidebar(),"WELDING SIDEBAR");						
		Sidebar.getWelder_Sidebar().click();
		Reporter.log("WELDER SIDEBAR is FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,Sidebar.getWelderDetails_Sidebar());
		webdriverutility.validation(driver,Sidebar.getWelderDetails_Sidebar(),"WELDING SIDEBAR");						
		Sidebar.getWelderDetails_Sidebar().click();
		Reporter.log("WELDER DETAILS SIDEBAR is FUNCTIONING PROPERLY",true);
		
		TestSpoolman_WelderDetails welder = new TestSpoolman_WelderDetails(driver);

		
/*		
	
		
		
		webdriverutility.ClickableElement(driver,welder.getEdit_BTN());
		webdriverutility.validation(driver,welder.getEdit_BTN(),"EDIT BTN");
		welder.getEdit_BTN().click();
		Reporter.log("EDIT BTN is FUNCTIONING PROPERLY",welder.getFilter_BTN().isDisplayed());
		
		webdriverutility.ClickableElement(driver,welder.getADD_BTN());
		webdriverutility.validation(driver,welder.getADD_BTN(),"ADD BTN");
		welder.getADD_BTN().click();
		Reporter.log("EDIT BTN is FUNCTIONING PROPERLY",welder.getSelect1stRow_CHECKBOX().isDisplayed());
		
//		FIRST WELDER
		
		welder.getWelderNo_01().click();
		Thread.sleep(500);
		act.sendKeys("123").perform();;
		
		welder.getWelderName_01().click();
		Thread.sleep(500);
		act.sendKeys("PCM").perform();;
		
		welder.getTestDate_01().click();
		Thread.sleep(500);
		act.sendKeys("25/03/2024").perform();;

		welder.getExpiryDate_01().click();
		Thread.sleep(500);
		act.sendKeys("25/12/2024").perform();;

		welder.getPNo1_01().click();
		Thread.sleep(500);
		act.sendKeys("01").perform();;
		
		welder.getPNo2_01().click();
		Thread.sleep(500);
		act.sendKeys("01").perform();;

		welder.getWeldingPrcess_01().click();
		Thread.sleep(500);
		act.sendKeys("SMAW").perform();;

		js.executeScript("arguments[0].scrollIntoView(true);",welder.getContractorName_01());
		
		welder.getDiaMax_01().click();
		Thread.sleep(500);
		act.sendKeys("100").perform();;

		welder.getThicknessMax_01().click();
		Thread.sleep(500);
		act.sendKeys("100").perform();;
		
		welder.getContractorName_01().click();
		Thread.sleep(500);
		act.sendKeys("JAYESH").perform();;

		webdriverutility.ClickableElement(driver,welder.getSelect1stRow_CHECKBOX());
		webdriverutility.validation(driver,welder.getSelect1stRow_CHECKBOX(),"SELECT 1ST ROW");
		welder.getSelect1stRow_CHECKBOX().click();
		Reporter.log("SELECT 1ST ROW is FUNCTIONING PROPERLY",welder.getDeselect1stRow_CHECKBOX().isDisplayed());
	
		webdriverutility.ClickableElement(driver,welder.getFilter_BTN());
		webdriverutility.validation(driver,welder.getFilter_BTN(),"FILTER BTN");
		welder.getFilter_BTN().click();
		Reporter.log("FILTER BTN is FUNCTIONING PROPERLY",welder.getWDContractorMapping().isDisplayed());
		
		Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,welder.getWDContractorMapping());
		webdriverutility.validation(driver,welder.getWDContractorMapping(),"CONTRACTOR MAPPING HL BTN");
		welder.getWDContractorMapping().click();
		Reporter.log("CONTRACTOR MAPPING HL is FUNCTIONING PROPERLY",true);
	
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,welder.getCNEdit_BTN());
		webdriverutility.validation(driver,welder.getCNEdit_BTN(),"CONTRACTOR MAPPING EDIT BTN");
		welder.getCNEdit_BTN().click();
		Reporter.log("CONTRACTOR MAPPING EDIT BTN is FUNCTIONING PROPERLY",welder.getDBContractorName_BOX().isDisplayed());
	
		webdriverutility.ClickableElement(driver,welder.getDBContractorName_BOX());
		webdriverutility.validation(driver,welder.getDBContractorName_BOX(),"DB CONTRACTOR NAME BOX");
		welder.getDBContractorName_BOX().click();
		Reporter.log("DB CONTRACTOR NAME BOX is FUNCTIONING PROPERLY",welder.getDBContractorName_DD().isDisplayed());
		
		webdriverutility.ClickableElement(driver,welder.getDBContractorName_DD());
		webdriverutility.validation(driver,welder.getDBContractorName_DD(),"CONTRACTOR NAME DD");
		welder.getDBContractorName_DD().click();
//		Reporter.log("DB CONTRACTOR NAME DD is FUNCTIONING PROPERLY",welder.getSubContractor2_dd().isDisplayed());
		Reporter.log("DB CONTRACTOR NAME DD is FUNCTIONING PROPERLY",welder.getAgency1_dd().isDisplayed());
		
//		webdriverutility.ClickableElement(driver,welder.getSubContractor2_dd());
//		webdriverutility.validation(driver,welder.getSubContractor2_dd(),"SUB CONTRACTOR 2ND");
//		welder.getSubContractor2_dd().click();
//		Reporter.log("SUB CONTRACTOR is FUNCTIONING PROPERLY",welder.getSubContractor2_dd().isDisplayed());
	
		webdriverutility.ClickableElement(driver,welder.getAgency1_dd());
		webdriverutility.validation(driver,welder.getAgency1_dd(),"SUB CONTRACTOR 2ND");
		welder.getAgency1_dd().click();
		Reporter.log("SUB CONTRACTOR is FUNCTIONING PROPERLY",true);		
		
		webdriverutility.ClickableElement(driver,welder.getExcelContractorName_BOX());
		webdriverutility.validation(driver,welder.getExcelContractorName_BOX(),"EXCEL CONTRACTOR BOX");
		welder.getExcelContractorName_BOX().click();
		Reporter.log("EXCEL CONTRACTOR BOX is FUNCTIONING PROPERLY",welder.getExcelContractorName_DD().isDisplayed());
	
		webdriverutility.ClickableElement(driver,welder.getExcelContractorName_DD());
		webdriverutility.validation(driver,welder.getExcelContractorName_DD(),"EXCEL CONTRACTOR DD");
		welder.getExcelContractorName_DD().click();
		Reporter.log("EXCEL CONTRACTOR DD is FUNCTIONING PROPERLY",welder.getJAYESH_dd().isDisplayed());
		
		webdriverutility.ClickableElement(driver,welder.getJAYESH_dd());
		webdriverutility.validation(driver,welder.getJAYESH_dd(),"JAYESH CONTRACTOR ");
		welder.getJAYESH_dd().click();
		Reporter.log("EXCEL CONTRACTOR JAYESH is FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,welder.getCNOK_BTN());
		webdriverutility.validation(driver,welder.getCNOK_BTN(),"CN OK BTN");
		welder.getCNOK_BTN().click();
		Reporter.log("EXCEL CONTRACTOR ok is FUNCTIONING PROPERLY",true);
		
//		SAVE FUNCTIONALITY
		
		webdriverutility.ClickableElement(driver,welder.getSAVE_BTN());
		webdriverutility.validation(driver,welder.getSAVE_BTN(),"SAVE BTN");
		welder.getSAVE_BTN().click();
		Reporter.log("SAVE BTN is FUNCTIONING PROPERLY",true);
		
//		SAVE MESSAGE
		
		Reporter.log("DATA SAVE SUCCESSFULLY IS DISPLAYED",welder.getDataSavedSuccessfully_POPUP().isDisplayed());
		welder.getDataSavedSuccessfully_POPUPClose().click();
		
		webdriverutility.ClickableElement(driver,welder.getEdit_BTN());
		welder.getEdit_BTN().click();
		
//		DOWNLOAD FUNCTIONALITY
		
		webdriverutility.ClickableElement(driver,welder.getDOWNLOAD_BTN());
		webdriverutility.validation(driver,welder.getDOWNLOAD_BTN(),"DOWNLOAD BTN");
		welder.getDOWNLOAD_BTN().click();
		Reporter.log("DOWNLOAD BTN is FUNCTIONING PROPERLY",true);
		
//		DOWNLOAD POPUP
		
		Reporter.log("DATA DOWNLOADED SUCCESSFULLY IS DISPLAYED",welder.getExcelDownloadedSuccessfully_POPUP().isDisplayed());
		welder.getExcelDownloadedSuccessfully_POPUPClose().click();
	
		webdriverutility.ClickableElement(driver,welder.getSelect1stRow_CHECKBOX());
		webdriverutility.validation(driver,welder.getSelect1stRow_CHECKBOX(),"1ST CHECKBOX");
		welder.getSelect1stRow_CHECKBOX().click();
		
		webdriverutility.ClickableElement(driver,welder.getDELETE_BTN());
		webdriverutility.validation(driver,welder.getDELETE_BTN(),"DELETE BTN");
		welder.getDELETE_BTN().click();
		Reporter.log("DELETE BTN is FUNCTIONING PROPERLY",true);
	
		Reporter.log("DATA DELETED SUCCESSFULLY IS DISPLAYED",welder.getDataDeletedSuccessfully_POPUP().isDisplayed());
		welder.getDataDeletedSuccessfully_POPUPClose().click();


		
		
 */
		
//		UPLOAD WALA...
		
		webdriverutility.ClickableElement(driver,welder.getEdit_BTN());
		welder.getEdit_BTN().click();
		
		welder.getUPLOAD_BTN().click();
		Reporter.log("UPLOAD BUTTON clickable",true);

		driver.switchTo().frame(0);
		
		Thread.sleep(1500);
//		ACTION CLASS USED TO CLICK ON WITH HELP OF MOUSE AND KEYBOARD	
		act.click(welder.getChooseFile_BTN());
		Reporter.log("CHOOSE FILE from UPLOAD POPUP is clickable",true);
				
		welder.getChooseFile_BTN().sendKeys("C:\\Users\\user\\Desktop\\pcm\\UPLOAD DATA\\SPOOLMAN\\"
				+ "Planning Masters\\RHCU_EPC_ISBL_AND_FEED_OSBL_Welder_6-24-2024 4_50_05 PM.xlsx");
	    
		Thread.sleep(2000);
//		SELECT CLASS USED TO SELECT ELEMENT FROM DROPDOWN
		Select s = new Select(welder.getWorksheet_DD());
		
		s.selectByVisibleText("Sheet1$");
		Reporter.log("Sheet is being selected by select class",true);
		
		webdriverutility.ClickableElement(driver,welder.getAutoMapColumns_BTN());
		welder.getAutoMapColumns_BTN().click();
		Reporter.log("selecting automap CHECKBOX ",true);
		
		webdriverutility.ClickableElement(driver,welder.getProceed_BTN());
		welder.getProceed_BTN().click();
		Reporter.log("proceed button in UPLOAD popup is clickable",true);
		Thread.sleep(2000);
		
////		ASSERT FOR WARNING "SAVE DATA SUCCESSFULLY"		
//		Assert.assertTrue(welder.getDataUploadedSuccessfully_POPUP().isDisplayed(),"data save successfully did not displayed");
////		POPUP CLOSE "SAVE DATA SUCCESSFULLY"		
//		welder.getDataUploadedSuccessfully_POPUPClose().click();				
//		Thread.sleep(2000);
		
//		webdriverutility.ClickableElement(driver,welder.getEdit_BTN());
//		welder.getEdit_BTN().click();
		
		webdriverutility.ClickableElement(driver,welder.getFullScreen_BTN());
		webdriverutility.validation(driver,welder.getFullScreen_BTN(),"FULLSCREEN BTN");
		welder.getFullScreen_BTN().click();
		Reporter.log("FULLSCREEN BTN IS FUNCTIONING PROPERLY ",true);
		
		Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,welder.getCompress_BTN());
		webdriverutility.validation(driver,welder.getCompress_BTN(),"COMPRESS BTN");
		welder.getCompress_BTN().click();
		Reporter.log("COMPRESS BTN IS FUNCTIONING PROPERLY ",true);
	
//		Reporter.log(welder.getTotalRecords().getText(),true);
		
		Reporter.log("ALL DONE",true);
		
		
//		webdriverutility.ClickableElement(driver,welder.getEdit_BTN());
//		welder.getEdit_BTN().click();
		
		js.executeScript("arguments[0].scrollIntoView(true);", welder.getContractorName_Col());
		
		for (WebElement contractor : welder.getContractorName_List()) 
		{
		    if (contractor.isDisplayed()) 
		    {
		    try {
		    Thread.sleep(300);
		    js.executeScript("arguments[0].scrollIntoView(true);",contractor);
		    
		    webdriverutility.ClickableElement(driver, contractor);
		    contractor.click();
		    Thread.sleep(200);
			act.sendKeys("JAYESH").perform();
		    }
//		    catch (InvocationTargetException e) 
//					{
//			e.getCause().printStackTrace();			
//					}
		    
		    catch (Exception e) {		    	 

		       System.out.println("PRINT SOMETHING....WHATEVERR YOU WANT");
		    	e.printStackTrace();
		        
		    }
		    
		    }
		}
			

////		WebDriverWait wait = new WebDriverWait(driver, 10);
//		for (WebElement contractor : welder.getContractorName_List()) {
//		    if (contractor.isDisplayed()) {
//		        try {
//		            Thread.sleep(300);
//		            js.executeScript("arguments[0].scrollIntoView(true);", contractor);
////		            wait.until(ExpectedConditions.elementToBeClickable(contractor));
//		            webdriverutility.ClickableEl  ement(driver, contractor);
//		            contractor.click();
//		            Thread.sleep(200);
//		            act.sendKeys("JAYESH").perform();
//		        } catch (InterruptedException e) {
//		            e.getCause().printStackTrace();
//		        }
////		        catch (Exception e) {
////		            System.out.println("PRINT SOMETHING....WHATEVERR YOU WANT");
////		            e.printStackTrace();
////		        }
//		    }
//		}		
		
		
		
		    
//		    try {
//				act.sendKeys("Agency 1").perform();
//			} catch (Exception e) {
//				
//				System.out.println("TEST"+e+"amjlkln k");
//				e.getCause();
//				e.printStackTrace();
//			}
		    
		  
//		    js.executeScript("arguments[0].value = arguments[1];",contractor,"Agency 1");

		    
		
		
		webdriverutility.ClickableElement(driver,welder.getSelectionSelectAllRow_CHECKBOX());
		webdriverutility.validation(driver,welder.getSelectionSelectAllRow_CHECKBOX(),"SELECT 1ST ROW");
		welder.getSelectionSelectAllRow_CHECKBOX().click();
		Reporter.log("SELECT all ROW is FUNCTIONING PROPERLY",welder.getDeselect1stRow_CHECKBOX().isDisplayed());
	
		webdriverutility.ClickableElement(driver,welder.getFilter_BTN());
		webdriverutility.validation(driver,welder.getFilter_BTN(),"FILTER BTN");
		welder.getFilter_BTN().click();
		Reporter.log("FILTER BTN is FUNCTIONING PROPERLY",welder.getWDContractorMapping().isDisplayed());
		
		Thread.sleep(1000);
		
		webdriverutility.ClickableElement(driver,welder.getWDContractorMapping());
		webdriverutility.validation(driver,welder.getWDContractorMapping(),"CONTRACTOR MAPPING HL BTN");
		welder.getWDContractorMapping().click();
		Reporter.log("CONTRACTOR MAPPING HL is FUNCTIONING PROPERLY",true);
	
		Thread.sleep(500);
		
		webdriverutility.ClickableElement(driver,welder.getCNEdit_BTN());
		webdriverutility.validation(driver,welder.getCNEdit_BTN(),"CONTRACTOR MAPPING EDIT BTN");
		welder.getCNEdit_BTN().click();
		Reporter.log("CONTRACTOR MAPPING EDIT BTN is FUNCTIONING PROPERLY",welder.getDBContractorName_BOX().isDisplayed());
	
		webdriverutility.ClickableElement(driver,welder.getDBContractorName_BOX());
		webdriverutility.validation(driver,welder.getDBContractorName_BOX(),"DB CONTRACTOR NAME BOX");
		welder.getDBContractorName_BOX().click();
		Reporter.log("DB CONTRACTOR NAME BOX is FUNCTIONING PROPERLY",welder.getDBContractorName_DD().isDisplayed());
		
		webdriverutility.ClickableElement(driver,welder.getDBContractorName_DD());
		webdriverutility.validation(driver,welder.getDBContractorName_DD(),"CONTRACTOR NAME DD");
		welder.getDBContractorName_DD().click();
//		Reporter.log("DB CONTRACTOR NAME DD is FUNCTIONING PROPERLY",welder.getSubContractor2_dd().isDisplayed());
		Reporter.log("DB CONTRACTOR NAME DD is FUNCTIONING PROPERLY",welder.getAgency1_dd().isDisplayed());
		
//		webdriverutility.ClickableElement(driver,welder.getSubContractor2_dd());
//		webdriverutility.validation(driver,welder.getSubContractor2_dd(),"SUB CONTRACTOR 2ND");
//		welder.getSubContractor2_dd().click();
//		Reporter.log("SUB CONTRACTOR is FUNCTIONING PROPERLY",welder.getSubContractor2_dd().isDisplayed());
	
		webdriverutility.ClickableElement(driver,welder.getAgency1_dd());
		webdriverutility.validation(driver,welder.getAgency1_dd(),"SUB CONTRACTOR 2ND");
		welder.getAgency1_dd().click();
		Reporter.log("SUB CONTRACTOR is FUNCTIONING PROPERLY",true);		
		
		webdriverutility.ClickableElement(driver,welder.getExcelContractorName_BOX());
		webdriverutility.validation(driver,welder.getExcelContractorName_BOX(),"EXCEL CONTRACTOR BOX");
		welder.getExcelContractorName_BOX().click();
		Reporter.log("EXCEL CONTRACTOR BOX is FUNCTIONING PROPERLY",welder.getExcelContractorName_DD().isDisplayed());
	
		webdriverutility.ClickableElement(driver,welder.getExcelContractorName_DD());
		webdriverutility.validation(driver,welder.getExcelContractorName_DD(),"EXCEL CONTRACTOR DD");
		welder.getExcelContractorName_DD().click();
		Reporter.log("EXCEL CONTRACTOR DD is FUNCTIONING PROPERLY",welder.getJAYESH_dd().isDisplayed());
		
		webdriverutility.ClickableElement(driver,welder.getJAYESH_dd());
		webdriverutility.validation(driver,welder.getJAYESH_dd(),"JAYESH CONTRACTOR ");
		welder.getJAYESH_dd().click();
		Reporter.log("EXCEL CONTRACTOR JAYESH is FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,welder.getCNOK_BTN());
		webdriverutility.validation(driver,welder.getCNOK_BTN(),"CN OK BTN");
		welder.getCNOK_BTN().click();
		Reporter.log("EXCEL CONTRACTOR ok is FUNCTIONING PROPERLY",true);
		
		webdriverutility.ClickableElement(driver,welder.getSAVE_BTN());
		webdriverutility.validation(driver,welder.getSAVE_BTN(),"SAVE BTN");
		welder.getSAVE_BTN().click();
		Reporter.log("SAVE BTN is FUNCTIONING PROPERLY",true);

		}
	  
		
	}
