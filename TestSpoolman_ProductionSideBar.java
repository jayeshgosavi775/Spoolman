/**
 * AUTHOR - PUNIT MORE
 * DATE - 11-01-2024;
 * DESC - SPOOLMAN-ERMAN --> 9DOT-->PROJECT-->PRODUCTION-->POM REPOSITORY
 * UPDATED - 
 */


package com.pcpl.spoolman.production;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestSpoolman_ProductionSideBar {

	WebDriver driver;
	
	public TestSpoolman_ProductionSideBar(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy (id = "topmenuCollapse")
	private WebElement TopExpand_BTN;
	
	@FindBy (id = "FitupCompletion")
	private WebElement FitupCompletion_SideBar;
	
	@FindBy (xpath = "//span[text()=\"Fitup Report\"]/..")
	private WebElement FitupReport_SideBar;
	
	@FindBy (id = "PMICompletion")
	private WebElement PMICompletion_SideBar;
	
	@FindBy (xpath = "//span[text()=\"PMI Report\"]/..")
	private WebElement PMIReport_SideBar;
	
	@FindBy (xpath = "//span[text()=\"View/Modify PMI\"]/..")
	private WebElement ViewModifyPMI_SideBar;
	
	@FindBy (id = "ProductionPMIReportInspection")
	private WebElement PMIReportInspection_SideBar;
	
	@FindBy (id = "CuttingClearance")
	private WebElement CuttingClearance_SideBar;
	
	@FindBy (xpath = "//a[@id=\"CuttingClearance\"]/following-sibling::ul//span[text()=\"Cutting Clearance\"]")
	private WebElement SubCuttingClearance_SideBar;

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the topExpand_BTN
	 */
	public WebElement getTopExpand_BTN() {
		return TopExpand_BTN;
	}

	/**
	 * @return the fitupCompletion_SideBar
	 */
	public WebElement getFitupCompletion_SideBar() {
		return FitupCompletion_SideBar;
	}

	/**
	 * @return the fitupReport_SideBar
	 */
	public WebElement getFitupReport_SideBar() {
		return FitupReport_SideBar;
	}

	/**
	 * @return the pMICompletion_SideBar
	 */
	public WebElement getPMICompletion_SideBar() {
		return PMICompletion_SideBar;
	}

	/**
	 * @return the pMIReport_SideBar
	 */
	public WebElement getPMIReport_SideBar() {
		return PMIReport_SideBar;
	}

	/**
	 * @return the viewModifyPMI_SideBar
	 */
	public WebElement getViewModifyPMI_SideBar() {
		return ViewModifyPMI_SideBar;
	}

	/**
	 * @return the pMIReportInspection_SideBar
	 */
	public WebElement getPMIReportInspection_SideBar() {
		return PMIReportInspection_SideBar;
	}

	/**
	 * @return the cuttingClearance_SideBar
	 */
	public WebElement getCuttingClearance_SideBar() {
		return CuttingClearance_SideBar;
	}

	/**
	 * @return the subCuttingClearance_SideBar
	 */
	public WebElement getSubCuttingClearance_SideBar() {
		return SubCuttingClearance_SideBar;
	}
		
	
	
}
