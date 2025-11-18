/**
 * AUTHOR - PUNIT MORE
 * DATE - 09-01-2024;
 * DESC - SPOOLMAN-ERMAN --> 9DOT-->PROJECT-->PRODUCTION-->FITUP COMPLETION-->VIEW MODIFY REPORT 
 * POM REPOSITORY
 * UPDATED - 
 */

package com.pcpl.spoolman.production;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestSpoolman_fcModiyReport {

	WebDriver driver;
	
	public TestSpoolman_fcModiyReport(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy (xpath = "//input[@aria-owns=\"ContractorID_listbox\"]")
	private WebElement SubContractor_DDTXT;
	
	@FindBy (xpath = "(//i[@class=\"fas fa-edit\"])[1]/..")
	private WebElement SelectionWindowEdit_BTN;
	
	@FindBy (xpath = "(//i[@class=\"fas fa-edit\"])[2]/..")
	private WebElement CreationWindowEdit_BTN;
	
	@FindBy (xpath = "//span[@class=\"fa fa-filter\"]/..")
	private WebElement Filter_BTN;
	
	@FindBy (xpath = "(//span[@class=\"fa fa-columns\"]/..)[1]")
	private WebElement SelectionColumnSetting_BTN;
	
	@FindBy (xpath = "(//span[@class=\"fa fa-columns\"]/..)[2]")
	private WebElement CreationColumnSetting_BTN;
	
	@FindBy (xpath = "(//span[@class=\"fa fa-expand\"]/..)[1]")
	private WebElement SelectionFullscrean_BTN;
	
	@FindBy (xpath = "(//span[@class=\"fa fa-expand\"]/..)[2]")
	private WebElement CreationFullscrean_BTN;
	
	@FindBy (xpath = "//span[@class=\"fa fa-compress\"]")
	private WebElement FitupCompletionCompress_BTN;
	
	@FindBy (xpath = "//span[@class=\"fa fa-file-alt\"]/..")
	private WebElement ReportDetails_BTN;
	
	@FindBy (xpath = "//span[@class=\"fa fa-trash-alt\"]/..")
	private WebElement CreationDelete_BTN;
	
	@FindBy (xpath = "//span[@class=\"fa fa-save\"]/..")
	private WebElement CreationSave_BTN;
	
	@FindBy (xpath = "//input[@aria-label=\"Select all rows\"]")
	private WebElement SelectAllRow;
	
	@FindBy (xpath = "(//input[@aria-label=\"Select row\"])[1]")
	private WebElement Select1stRow;
	
	@FindBy (xpath = "//input[@aria-owns=\"drpReportNoID_listbox\"]")
	private WebElement ReportNo_DDTXT;
	
	@FindBy (id = "btnSave")
	private WebElement ModifyReportSave_BTN;
	
	@FindBy (xpath = "(//i[@class=\"k-i-close k-icon\"])[1]")
	private WebElement ModifyClose_BTN;
	
	@FindBy (xpath = "(//th[text()=\"Report No.\"]//span)[1]")
	private WebElement ModifyReportNo3Dots;
	
	@FindBy (xpath = "//td[@data-field=\"Text\"]")
	private List<WebElement> ModifyReportNo_List;
	
	@FindBy (xpath = "//th[@data-field=\"Observation\"]")
	private WebElement Observation_Col;
	
	@FindBy (xpath = "(//td[@data-field=\"Observation\"])[1]")
	private WebElement FirstObservation;
	
	@FindBy (xpath = "((//td[@data-field=\"Observation\"])[1]//span)[1]")
	private WebElement Obsercation_DD;
	
	@FindBy (xpath = "//li[contains(text(),\"Accepted\")]")
	private WebElement Obs_Accepted;
	
	@FindBy (xpath = "//li[contains(text(),\"Rejected\")]")
	private WebElement Obs_Rejected;
	
	@FindBy (xpath = "//li[contains(text(),\"NotAssigned\")]")
	private WebElement Obs_NotAssigned;
	
	@FindBy (xpath = "//th[contains(text(),\"Observation\")]//span")
	private WebElement Observation3DOTS;
	
	@FindBy (xpath = "//th[contains(text(),\"Spool_No.\")]//span")
	private WebElement SpoolNo3DOTS;
	
	@FindBy (xpath = "//th[contains(text(),\"Joint No.\")]//span")
	private WebElement JointsNo3DOTS;
	
	@FindBy (xpath = "//td[@data-field=\"JointNumber\"]")
	private List<WebElement> JointNo_List;
	
	@FindBy (xpath = "//th[@data-field=\"Thickness\"]")
	private WebElement Thickness_Col;
	
	@FindBy (xpath = "(//td[@data-field=\"Thickness\"])[1]")
	private WebElement Thickness_1stRow;
	
	@FindBy (id = "Thickness")
	private WebElement Thickness_Input;
	
	@FindBy (xpath = "//th[@data-field=\"WeldLength\"]")
	private WebElement WeldLength_Col;
	
	@FindBy (xpath = "(//td[@data-field=\"WeldLength\"])[1]")
	private WebElement WeldLength_1stRow;
	
	@FindBy (id  = "WeldLength")
	private WebElement WeldLength_Input;
	
	@FindBy (xpath = "//th[contains(@data-field, 'FitUpRectificationDate')]")
	private WebElement FitUpRectificationDate_Col;
	
	
//	FILTER
	
	@FindBy (xpath = "//span[text()=\"Filter\"]")
	private WebElement FunnelFilter;
	
	@FindBy (xpath = "//input[@title=\"Value\"]")
	private WebElement FilterValue;
	
	@FindBy (xpath = "(//button[text()=\"Filter\"])")
	private WebElement FFFilter_BTN;
	
	@FindBy (xpath = "//button[text()=\"Clear\"]")
	private WebElement FFClear_BTN;
 
//	NO OF RECORDS;;;
	
	@FindBy (id = "ToptotalRecords")
	private WebElement SelectionTotalNoOfRecords;
	
	@FindBy (id = "BottomtotalRecords")
	private WebElement CreationtotalNoOfRecords;

	@FindBy (xpath = "(//div[@id=\"ViewModifyViewGridMore\"]//div)[8]/table//tbody//tr//input")
	private List<WebElement> CreationListSelected;
	
	@FindBy (xpath = "//td[@data-field=\"SpoolName\"]")
	private List<WebElement> CreationSpool_NoList;
	
	@FindBy (xpath = "//td[@data-field=\"JointNumber\"]")
	private List<WebElement> CreationJoint_NoList;
	
	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the subContractor_DDTXT
	 */
	public WebElement getSubContractor_DDTXT() {
		return SubContractor_DDTXT;
	}

	/**
	 * @return the selectionWindowEdit_BTN
	 */
	public WebElement getSelectionWindowEdit_BTN() {
		return SelectionWindowEdit_BTN;
	}

	/**
	 * @return the creationWindowEdit_BTN
	 */
	public WebElement getCreationWindowEdit_BTN() {
		return CreationWindowEdit_BTN;
	}

	/**
	 * @return the filter_BTN
	 */
	public WebElement getFilter_BTN() {
		return Filter_BTN;
	}

	/**
	 * @return the selectionColumnSetting_BTN
	 */
	public WebElement getSelectionColumnSetting_BTN() {
		return SelectionColumnSetting_BTN;
	}

	/**
	 * @return the creationColumnSetting_BTN
	 */
	public WebElement getCreationColumnSetting_BTN() {
		return CreationColumnSetting_BTN;
	}

	/**
	 * @return the selectionFullscrean_BTN
	 */
	public WebElement getSelectionFullscrean_BTN() {
		return SelectionFullscrean_BTN;
	}

	/**
	 * @return the creationFullscrean_BTN
	 */
	public WebElement getCreationFullscrean_BTN() {
		return CreationFullscrean_BTN;
	}

	/**
	 * @return the fitupCompletionCompress_BTN
	 */
	public WebElement getFitupCompletionCompress_BTN() {
		return FitupCompletionCompress_BTN;
	}

	/**
	 * @return the reportDetails_BTN
	 */
	public WebElement getReportDetails_BTN() {
		return ReportDetails_BTN;
	}

	/**
	 * @return the creationDelete_BTN
	 */
	public WebElement getCreationDelete_BTN() {
		return CreationDelete_BTN;
	}

	/**
	 * @return the creationSave_BTN
	 */
	public WebElement getCreationSave_BTN() {
		return CreationSave_BTN;
	}

	/**
	 * @return the selectAllRow
	 */
	public WebElement getSelectAllRow() {
		return SelectAllRow;
	}

	/**
	 * @return the select1stRow
	 */
	public WebElement getSelect1stRow() {
		return Select1stRow;
	}

	/**
	 * @return the reportNo_DDTXT
	 */
	public WebElement getReportNo_DDTXT() {
		return ReportNo_DDTXT;
	}

	/**
	 * @return the modifySave_BTN
	 */
	public WebElement getModifyReportSave_BTN() {
		return ModifyReportSave_BTN;
	}

	/**
	 * @return the modifyClose_BTN
	 */
	public WebElement getModifyClose_BTN() {
		return ModifyClose_BTN;
	}

	/**
	 * @return the modifyReportNo3Dots
	 */
	public WebElement getModifyReportNo3Dots() {
		return ModifyReportNo3Dots;
	}

	/**
	 * @return the modifyReportNo_List
	 */
	public List<WebElement> getModifyReportNo_List() {
		return ModifyReportNo_List;
	}

	/**
	 * @return the thickness_Col
	 */
	public WebElement getThickness_Col() {
		return Thickness_Col;
	}

	/**
	 * @return the thickness_1stRow
	 */
	public WebElement getThickness_1stRow() {
		return Thickness_1stRow;
	}

	/**
	 * @return the thickness_Input
	 */
	public WebElement getThickness_Input() {
		return Thickness_Input;
	}

	/**
	 * @return the weldLength_Col
	 */
	public WebElement getWeldLength_Col() {
		return WeldLength_Col;
	}

	/**
	 * @return the weldLength_1stRow
	 */
	public WebElement getWeldLength_1stRow() {
		return WeldLength_1stRow;
	}

	/**
	 * @return the weldLength_Input
	 */
	public WebElement getWeldLength_Input() {
		return WeldLength_Input;
	}

	/**
	 * @return the funnelFilter
	 */
	public WebElement getFunnelFilter() {
		return FunnelFilter;
	}

	/**
	 * @return the filterValue
	 */
	public WebElement getFilterValue() {
		return FilterValue;
	}

	/**
	 * @return the fFFilter_BTN
	 */
	public WebElement getFFFilter_BTN() {
		return FFFilter_BTN;
	}

	/**
	 * @return the fFClear_BTN
	 */
	public WebElement getFFClear_BTN() {
		return FFClear_BTN;
	}

	/**
	 * @return the selectionTotalNoOfRecords
	 */
	public WebElement getSelectionTotalNoOfRecords() {
		return SelectionTotalNoOfRecords;
	}

	/**
	 * @return the creationtotalNoOfRecords
	 */
	public WebElement getCreationtotalNoOfRecords() {
		return CreationtotalNoOfRecords;
	}

	/**
	 * @return the creationListSelected
	 */
	public List<WebElement> getCreationListSelected() {
		return CreationListSelected;
	}

	/**
	 * @return the creationSpool_NoList
	 */
	public List<WebElement> getCreationSpool_NoList() {
		return CreationSpool_NoList;
	}

	/**
	 * @return the creationJoint_NoList
	 */
	public List<WebElement> getCreationJoint_NoList() {
		return CreationJoint_NoList;
	}

	/**
	 * @return the observation_Col
	 */
	public WebElement getObservation_Col() {
		return Observation_Col;
	}

	/**
	 * @return the firstObservation
	 */
	public WebElement getFirstObservation() {
		return FirstObservation;
	}

	/**
	 * @return the obsercation_DD
	 */
	public WebElement getObsercation_DD() {
		return Obsercation_DD;
	}

	/**
	 * @return the obs_Accepted
	 */
	public WebElement getObs_Accepted() {
		return Obs_Accepted;
	}

	/**
	 * @return the obs_Rejected
	 */
	public WebElement getObs_Rejected() {
		return Obs_Rejected;
	}

	/**
	 * @return the obs_NotAssigned
	 */
	public WebElement getObs_NotAssigned() {
		return Obs_NotAssigned;
	}

	/**
	 * @return the observation3DOTS
	 */
	public WebElement getObservation3DOTS() {
		return Observation3DOTS;
	}

	/**
	 * @return the spoolNo3DOTS
	 */
	public WebElement getSpoolNo3DOTS() {
		return SpoolNo3DOTS;
	}

	/**
	 * @return the jointsNo3DOTS
	 */
	public WebElement getJointsNo3DOTS() {
		return JointsNo3DOTS;
	}

	/**
	 * @return the jointNo_List
	 */
	public List<WebElement> getJointNo_List() {
		return JointNo_List;
	}

	/**
	 * @return the fitUpRectificationDate_Col
	 */
	public WebElement getFitUpRectificationDate_Col() {
		return FitUpRectificationDate_Col;
	}
	
	
	
	
	
}
