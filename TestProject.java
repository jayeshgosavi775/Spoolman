package spoolman.Welding;

import org.openqa.selenium.JavascriptExecutor;
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

public class TestProject extends BaseClass{

	
@Test	
public void projECT() throws Throwable{
//		IMPLICIT WAIT		
	webdriverutility.implicitWait(driver);
//	LOGIN PAGE
	TestPgold_SignIn signin = new TestPgold_SignIn(driver);	
//	ASSERT TO ASSURE LOGIN PAGE
	System.out.println(ExcelUtility.readStringFromExcel("Sheet1", 3, 1));
	Assert.assertTrue(ExcelUtility.readStringFromExcel("Sheet1", 3, 1).equals(driver.getCurrentUrl()),"it does not have same url");
				
	signin.getUser().sendKeys(FileUtility.readCommonData("user"));
	Reporter.log("USERNAME entered with help of file utility"
			+ " USERNAME textfield working propertly",true);
	signin.getPass().sendKeys(ExcelUtility.readStringFromExcel("Sheet1", 2, 1));
	Reporter.log("PASSWORD entered with help of Excel Utility"
				+ " PASSWORD textfield working propertly",true);
//	CAPTCHA AUTOMATE
	Captcha cp = new Captcha(driver);
	cp.captcha();
		
//	HOME PAGE		
	TestPgold_HomePage hp = new TestPgold_HomePage(driver);
		
	JavascriptExecutor js = (JavascriptExecutor) driver;
		
	Actions act = new Actions(driver);
		
	webdriverutility.ClickableElement(driver,hp.getSpoolmanErman());
	webdriverutility.validation(driver,hp.getSpoolmanErman(),"EFA_MFA ");
	hp.getSpoolmanErman().click();		
	Reporter.log("SPOOLMAN-ERMAN is displayed and true",true);
	
	TestSpoolman_Home sm = new TestSpoolman_Home(driver); 
	
//	webdriverutility.ClickableElement(driver,sm.getMTO_Test());
//	webdriverutility.validation(driver,sm.getMTO_Test(),"PROJECT SELECTED");		
//	sm.getMTO_Test().click();
	
	Thread.sleep(500);

	for (WebElement project : sm.getOnGoingProjectList()) {
		
		if (project.getText().equals(ExcelUtility.readFromExcelProject("Sheet2", 1, 1))) {
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

}
	
}
