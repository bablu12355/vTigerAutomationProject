package com.eva.vtiger.pages.functionality.marketing.leads;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.leeds.OrImportLeadSelectCSVFileLandingPage;

public class ImportLeadSelectCSVFileLandingPage extends OrImportLeadSelectCSVFileLandingPage {

	private WebDriverUtil WebUtil;

	public ImportLeadSelectCSVFileLandingPage(WebDriverUtil WebUtil) {
		this.WebUtil = WebUtil;
		PageFactory.initElements(WebUtil.getDriver(), this);

	}

	public void selectCSVfile() {
		System.out.println("hii");
WebUtil.usingWebElementSendKeys(clickOnChooseFile, "C:\\Users\\Admin\\Desktop\\mavenRepository\\vTigertAutomate\\ExcelData\\DataCSV.csv", "Data CSV File");
	}

	public LeadsListMappingLandingPage clickOnNextButton() {
		selectCSVfile();
		WebUtil.usingWebElementclickMethod(clickOnNextButton, "Next Button");
	return	new LeadsListMappingLandingPage(WebUtil);
	}

	public void cancelButton() {
		WebUtil.usingWebElementclickMethod(clickOnCancelButton, "Cancel Button");
	}
}
