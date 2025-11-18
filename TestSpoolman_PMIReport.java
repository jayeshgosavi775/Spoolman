/**
 * AUTHOR - PUNIT MORE
 * DATE - --
 * DESC - SPOOLMAN-->SELECT PROJECT-->9DOT-->PRODUCT-->PMI REPORT...
 * UPDATED - 
 */

package com.pcpl.spoolman.production;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestSpoolman_PMIReport {

	WebDriver driver ;
	
	public TestSpoolman_PMIReport(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy (xpath = "//input[@aria-owns=\"SubContrctId_listbox\"]")
	private WebElement SubContractor_DDTXT;
	
	@FindBy (xpath = "(//i[@class=\"fas fa-edit\"])[1]/..")
	private WebElement SelectionWindowEdit_BTN;
	
	@FindBy (xpath = "(//i[@class=\"fas fa-edit\"])[2]/..")
	private WebElement CreationWindowEdit_BTN;
	
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
	
//	@FindBy (xpath = "//span[@class=\"fa fa-trash-alt\"]/..")
//	private WebElement CreationDelete_BTN;
	
	@FindBy (xpath = "//span[@class=\"fa fa-save\"]/..")
	private WebElement CreationSave_BTN;
	
	@FindBy (xpath = "//input[@aria-label=\"Select all rows\"]")
	private WebElement SelectAllRow;
	
	@FindBy (xpath = "(//input[@aria-label=\"Select row\"])[1]")
	private WebElement Select1stRow;
	
//	PMI REPORT;
	
	@FindBy (xpath = "(//th[text()=\"Spool No.\"]//span)[1]")
	private WebElement SelectionSpoolNo_3Dots;
	
//	@FindBy (xpath = "//div[@id=\"CreatePMIReportGrid\"]/div[3]/table/tbody/tr/td[4]")
	@FindBy (xpath = "//div[@id=\"CreatePMIReportGrid\"]/div[3]/table/tbody/tr/td[3]")
	private List<WebElement> SelectionSpoolNo_List;
	
	@FindBy (xpath = "(//th[text()=\"Spool No.\"]//span)[2]")
	private WebElement CreationSpoolNo_3Dots;
	
	@FindBy (xpath = "//div[@id=\"CreateReportGrid\"]/div[3]/table/tbody/tr/td[2]")
	private List<WebElement> CreationSpoolNo_List;
	
	@FindBy (id = "chkAutoGenrateReport")
	private WebElement AutoGenrateReport_CHECKBOX;
	
	@FindBy (xpath = "(//*[@id=\"drpPMIReportNo-list\"]/span/input)[13]")
	private WebElement ReportNoDDInput_DDTXT;
	
	@FindBy (xpath = "//input[@id=\"drpPMIReportNo\"]/..")
	private WebElement PMIReportNo_DD;
	
	@FindBy (xpath = "//div[@id=\"drpPMIReportNo-list\"]//span//input")
	private WebElement PMIReportNo_Input;
	
	@FindBy (xpath = "(//*[@id=\"drpPMIReportNo-list\"]/div[4]/div/button)")
	private WebElement PMIReportNo_AddBTN;
	
	@FindBy (id = "dtReportDate")
	private WebElement ReportDate_INPUT;
	
	@FindBy (xpath = "//input[@aria-owns=\"AssignWorkFlowDrpDwn_listbox\"]")
	private WebElement AssignWorkFlow_INPUT;
	
	@FindBy (id = "pmiAgency")
	private WebElement PMIAgency_INPUT;
	
	@FindBy (id = "inspectionAgency")
	private WebElement InspectionAgency_INPUT;
	
	@FindBy (id = "pmiEquipmentNo")
	private WebElement PMIEquipmentNo;
	
	@FindBy (id = "dtEquipmentDate")
	private WebElement EquipmentDate_INPUT;
	
	@FindBy (id = "serialNo")
	private WebElement SerialNo_INPUT;
	
	@FindBy (id = "dtLastServiceDate")
	private WebElement LastServiceDate_INPUT;
	
	@FindBy (id = "cr")
	private WebElement CR_INPUT;
	
	@FindBy (id = "mo")
	private WebElement MO_INPUT;
	
	@FindBy (id = "ni")
	private WebElement NI_INPUT;
	
	@FindBy (id = "mn")
	private WebElement MN_INPUT;
	
	@FindBy (id = "nb")
	private WebElement NB_INPUT;
	
	@FindBy (id = "ti")
	private WebElement TI_INPUT;
	
	@FindBy (id = "v")
	private WebElement V_INPUT;
	
	@FindBy (id = "fe")
	private WebElement FE_INPUT;
	
	@FindBy (id = "technique")
	private WebElement Technique_INPUT;
	
	@FindBy (id = "shopLocation")
	private WebElement ShopLocation_INPUT;
	
	@FindBy (xpath = "//button[text()=\"Save\"]")
	private WebElement PMIReportSave_BTN;
	
	@FindBy (xpath = "(//i[@class=\"k-i-close k-icon\"])[1]")
	private WebElement Close_BTN;
	
	//CREATION
	@FindBy (xpath = "//th[@data-field=\"PMIFitUpObservation\"]")
	private WebElement PMIFitUpObservation_Col;
	
	@FindBy (xpath = "//td[@data-field=\"PMIFitUpObservation\"]")
	private List<WebElement> PMIFitUpObservation_Fields;
	
	@FindBy (xpath = "//input[@name=\"PMIFitUpObservation\"]/..")
	private WebElement PMIFitUpObservation_Input;
	
	@FindBy (xpath = "//div[@class=\"k-list-scroller\"]//li[text()=\"Accepted\"]")
	private WebElement Obs_Accepted;
	
	@FindBy (xpath = /*"//li[text()=\"Rejected\"]"*/  "//div[@class=\"k-list-scroller\"]//li[text()=\"Rejected\"]")
	private WebElement Obs_Rejected;
	
	
	
//	total no of records
	
	@FindBy (id = "ToptotalRecords")
	private WebElement SelectionTotalNoOfRecords;
	
	@FindBy (id = "BottomtotalRecords")
	private WebElement CreationtotalNoOfRecords;
	
//	wait
	
	@FindBy (id = "pleaseWaitModal")
	private WebElement pmiPleaseWaitModal;
	
	
	

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
	 * @return the selectionSpoolNo_3Dots
	 */
	public WebElement getSelectionSpoolNo_3Dots() {
		return SelectionSpoolNo_3Dots;
	}

	/**
	 * @return the creationSpoolNo_3Dots
	 */
	public WebElement getCreationSpoolNo_3Dots() {
		return CreationSpoolNo_3Dots;
	}

	/**
	 * @return the selectionSpoolNo_List
	 */
	public List<WebElement> getSelectionSpoolNo_List() {
		return SelectionSpoolNo_List;
	}

	/**
	 * @return the creationSpoolNo_List
	 */
	public List<WebElement> getCreationSpoolNo_List() {
		return CreationSpoolNo_List;
	}

	/**
	 * @return the autoGenrateReport_CHECKBOX
	 */
	public WebElement getAutoGenrateReport_CHECKBOX() {
		return AutoGenrateReport_CHECKBOX;
	}

	/**
	 * @return the reportNoDDInput_DDTXT
	 */
	public WebElement getReportNoDDInput_DDTXT() {
		return ReportNoDDInput_DDTXT;
	}

	/**
	 * @return the reportDate_INPUT
	 */
	public WebElement getReportDate_INPUT() {
		return ReportDate_INPUT;
	}

	/**
	 * @return the pMIReportNo_DD
	 */
	public WebElement getPMIReportNo_DD() {
		return PMIReportNo_DD;
	}

	/**
	 * @return the pMIReportNo_Input
	 */
	public WebElement getPMIReportNo_Input() {
		return PMIReportNo_Input;
	}

	/**
	 * @return the pMIReportNo_AddBTN
	 */
	public WebElement getPMIReportNo_AddBTN() {
		return PMIReportNo_AddBTN;
	}

	/**
	 * @return the assignWorkFlow_INPUT
	 */
	public WebElement getAssignWorkFlow_INPUT() {
		return AssignWorkFlow_INPUT;
	}

	/**
	 * @return the pMIAgency_INPUT
	 */
	public WebElement getPMIAgency_INPUT() {
		return PMIAgency_INPUT;
	}

	/**
	 * @return the inspectionAgency_INPUT
	 */
	public WebElement getInspectionAgency_INPUT() {
		return InspectionAgency_INPUT;
	}

	/**
	 * @return the pMIEquipmentNo
	 */
	public WebElement getPMIEquipmentNo() {
		return PMIEquipmentNo;
	}

	/**
	 * @return the equipmentDate_INPUT
	 */
	public WebElement getEquipmentDate_INPUT() {
		return EquipmentDate_INPUT;
	}

	/**
	 * @return the serialNo_INPUT
	 */
	public WebElement getSerialNo_INPUT() {
		return SerialNo_INPUT;
	}

	/**
	 * @return the lastServiceDate_INPUT
	 */
	public WebElement getLastServiceDate_INPUT() {
		return LastServiceDate_INPUT;
	}

	/**
	 * @return the cR_INPUT
	 */
	public WebElement getCR_INPUT() {
		return CR_INPUT;
	}

	/**
	 * @return the mO_INPUT
	 */
	public WebElement getMO_INPUT() {
		return MO_INPUT;
	}

	/**
	 * @return the nI_INPUT
	 */
	public WebElement getNI_INPUT() {
		return NI_INPUT;
	}

	/**
	 * @return the mN_INPUT
	 */
	public WebElement getMN_INPUT() {
		return MN_INPUT;
	}

	/**
	 * @return the nB_INPUT
	 */
	public WebElement getNB_INPUT() {
		return NB_INPUT;
	}

	/**
	 * @return the tI_INPUT
	 */
	public WebElement getTI_INPUT() {
		return TI_INPUT;
	}

	/**
	 * @return the v_INPUT
	 */
	public WebElement getV_INPUT() {
		return V_INPUT;
	}

	/**
	 * @return the fE_INPUT
	 */
	public WebElement getFE_INPUT() {
		return FE_INPUT;
	}

	/**
	 * @return the technique_INPUT
	 */
	public WebElement getTechnique_INPUT() {
		return Technique_INPUT;
	}

	/**
	 * @return the shopLocation_INPUT
	 */
	public WebElement getShopLocation_INPUT() {
		return ShopLocation_INPUT;
	}

	/**
	 * @return the pMIReportSave_BTN
	 */
	public WebElement getPMIReportSave_BTN() {
		return PMIReportSave_BTN;
	}

	/**
	 * @return the close_BTN
	 */
	public WebElement getClose_BTN() {
		return Close_BTN;
	}

	
	
	
	
	
	/**
	 * @return the pMIFitUpObservation_Col
	 */
	public WebElement getPMIFitUpObservation_Col() {
		return PMIFitUpObservation_Col;
	}

	/**
	 * @return the pMIFitUpObservation_Fields
	 */
	public List<WebElement> getPMIFitUpObservation_Fields() {
		return PMIFitUpObservation_Fields;
	}

	/**
	 * @return the pMIFitUpObservation_Input
	 */
	public WebElement getPMIFitUpObservation_Input() {
		return PMIFitUpObservation_Input;
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

	
	
	
	
	
	
	
	
}
