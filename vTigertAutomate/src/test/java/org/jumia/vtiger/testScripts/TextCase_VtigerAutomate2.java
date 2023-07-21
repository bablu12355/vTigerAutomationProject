package org.jumia.vtiger.testScripts;

import java.util.Map;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.eva.vtiger.listner.IRetryFailedTestCase;
import com.eva.vtiger.pages.functionality.marketing.leads.ImportLeadSelectCSVFileLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsCreatePage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsDetailLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsListMappingLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.MappingResultsLandingPage;
import com.vitiger.eva.pages.functionality.marketing.campaign.CampaignDetailLandingPage;
import com.vitiger.eva.pages.functionality.marketing.campaign.CampaignLandingPage;
import com.vitiger.eva.pages.functionality.marketing.campaign.CreateCampaignLandingPage;

public class TextCase_VtigerAutomate2 extends BaseTestClass{
	private Map<String, String> mapRowData;
	private CampaignDetailLandingPage cDLP;
	@Test(dataProvider = "getValue")
	public void verifyCreateCampaign(Object objMapData) {
		mapRowData = (Map<String, String>) objMapData;
		CampaignLandingPage clp = hmp.gotoMarketingCampaignsLandingPage();
		CreateCampaignLandingPage cCLP = clp.clickCampaignButton();
		cDLP = cCLP.saveButton(mapRowData);
		String expectedMessage = mapRowData.get("ExpextedErrorMessage");
		String scenario = mapRowData.get("Scenario");
		if (scenario.equalsIgnoreCase("Invalid")) {
			webUtil.validatePopUpText(expectedMessage);
			webUtil.HandleAlertAccept();
		} else {
			webUtil.validateText(cDLP.getCampaignName(), mapRowData.get("CampaignName"), "Rahul");
			webUtil.validateText(cDLP.validateTargetAudience(), mapRowData.get("TargetAudience"), "Robot 2.0");
		}

	}
}