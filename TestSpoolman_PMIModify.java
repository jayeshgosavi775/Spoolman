package com.pcpl.spoolman.production;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestSpoolman_PMIModify {
	
	WebDriver driver; 
	
	public TestSpoolman_PMIModify(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy (xpath = "//th[text()=\"Spool No.\"]//span")
	private WebElement SpoolNo3Dots;
	
	@FindBy (xpath = "//th[text()=\"PMI Fit Up Observation\"]//span")
	private WebElement PMIObservatios3Dots;
	
	@FindBy (xpath = "//td[@data-field=\"SpoolNo\"]")
	private List<WebElement> SpoolNo_List;
	
	@FindBy (xpath = "//input[@aria-owns=\"SubContrctId_listbox\"]")
	private WebElement SubContractor_DDTXT;
	
	@FindBy (xpath = "//a[@title=\"Edit\"]")
	private WebElement MainEdit_BTN;
	
	@FindBy (xpath = "//span[@class=\"fa fa-filter\"]/..")
	private WebElement MainFilter_BTN;
	
	@FindBy (xpath = "//span[@class=\"fa fa-save\"]/..")
	private WebElement MainSave_BTN;
	
	@FindBy (xpath = "//span[@class=\"fa fa-columns\"]/..")
	private WebElement MainColumnSetting_BTN;
	
	@FindBy (xpath = "//span[@class=\"fa fa-expand\"]/..")
	private WebElement MainFullscreen_BTN;
	
	@FindBy (xpath = "//input[@aria-label=\"Select all rows\"]")
	private WebElement SelectAllRows_Checkbox;
	
	@FindBy (xpath = "//td[@data-field=\"PmiFitUpObservation\"]")
	private List<WebElement> PMIobsList;
	
	@FindBy (xpath = "//input[@name=\"PmiFitUpObservation\"]/..")
	private WebElement PMIobs_DD;
	
	@FindBy (xpath = "//li[text()=\"Accepted\"]")
	private WebElement PMIobs_Accepted;
	
	@FindBy (xpath = "//li[text()=\"Rejected\"]")
	private WebElement PMIobs_Rejected;
	
	@FindBy (xpath = "//th[@data-title=\"Master Details\"]")
	private WebElement MasterDetails;
	
	@FindBy (id = "totalRecords")
	private WebElement TotalNoOfRecords;
	
	@FindBy (xpath = "(//i[@class=\"k-i-close k-icon\"])[1]")
	private WebElement MasterDetailsClose_BTN;
	
	@FindBy (id = "Search")
	private WebElement MasterOK_BTN;
	
	@FindBy (xpath = "//span[text()=\"Data Saved Successfully\"]")
	private WebElement PMIModifyDataSavedSuccessfully_POPUP;
	
	@FindBy (xpath = "//span[text()=\"Data Saved Successfully\"]/../button")
	private WebElement PMIModifyDataSavedSuccessfully_POPUPClose;

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the spoolNo3Dots
	 */
	public WebElement getSpoolNo3Dots() {
		return SpoolNo3Dots;
	}

	/**
	 * @return the pMIObservatios3Dots
	 */
	public WebElement getPMIObservatios3Dots() {
		return PMIObservatios3Dots;
	}

	/**
	 * @return the spoolNo_List
	 */
	public List<WebElement> getSpoolNo_List() {
		return SpoolNo_List;
	}

	/**
	 * @return the subContractor_DDTXT
	 */
	public WebElement getSubContractor_DDTXT() {
		return SubContractor_DDTXT;
	}

	/**
	 * @return the mainEdit_BTN
	 */
	public WebElement getMainEdit_BTN() {
		return MainEdit_BTN;
	}

	/**
	 * @return the mainFilter_BTN
	 */
	public WebElement getMainFilter_BTN() {
		return MainFilter_BTN;
	}

	/**
	 * @return the mainSave_BTN
	 */
	public WebElement getMainSave_BTN() {
		return MainSave_BTN;
	}

	/**
	 * @return the mainColumnSetting_BTN
	 */
	public WebElement getMainColumnSetting_BTN() {
		return MainColumnSetting_BTN;
	}

	/**
	 * @return the mainFullscreen_BTN
	 */
	public WebElement getMainFullscreen_BTN() {
		return MainFullscreen_BTN;
	}

	/**
	 * @return the masterDetails
	 */
	public WebElement getMasterDetails() {
		return MasterDetails;
	}

	/**
	 * @return the totalNoOfRecords
	 */
	public WebElement getTotalNoOfRecords() {
		return TotalNoOfRecords;
	}

	/**
	 * @return the selectAllRows_Checkbox
	 */
	public WebElement getSelectAllRows_Checkbox() {
		return SelectAllRows_Checkbox;
	}

	/**
	 * @return the pMIobsList
	 */
	public List<WebElement> getPMIobsList() {
		return PMIobsList;
	}

	/**
	 * @return the pMIobsList_DD
	 */
	public WebElement getPMIobsList_DD() {
		return PMIobs_DD;
	}

	/**
	 * @return the pMIobs_Accepted
	 */
	public WebElement getPMIobs_Accepted() {
		return PMIobs_Accepted;
	}

	/**
	 * @return the pMIobs_Rejected
	 */
	public WebElement getPMIobs_Rejected() {
		return PMIobs_Rejected;
	}

	/**
	 * @return the masterDetailsClose_BTN
	 */
	public WebElement getMasterDetailsClose_BTN() {
		return MasterDetailsClose_BTN;
	}

	/**
	 * @return the masterOK_BTN
	 */
	public WebElement getMasterOK_BTN() {
		return MasterOK_BTN;
	}

	/**
	 * @return the pMIModifyDataSavedSuccessfully_POPUP
	 */
	public WebElement getPMIModifyDataSavedSuccessfully_POPUP() {
		return PMIModifyDataSavedSuccessfully_POPUP;
	}

	/**
	 * @return the pMIModifyDataSavedSuccessfully_POPUPClose
	 */
	public WebElement getPMIModifyDataSavedSuccessfully_POPUPClose() {
		return PMIModifyDataSavedSuccessfully_POPUPClose;
	}
	
	

}
