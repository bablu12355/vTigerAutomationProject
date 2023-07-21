package org.jumia.vtiger.testScripts;

import java.util.Map;

import org.jumia.vtiger.genericCode.ExcelDataUtil;

import org.testng.annotations.Test;

import com.eva.vtiger.listner.IRetryFailedTestCase;
import com.eva.vtiger.listner.ItestListnerTestcase;
import com.eva.vtiger.pages.functionality.inventory.invoice.CreateInvoiceLandingPage;
import com.eva.vtiger.pages.functionality.inventory.invoice.InvoiceDetailPage;
import com.eva.vtiger.pages.functionality.inventory.invoice.InvoiceLandingPage;

import com.eva.vtiger.pages.functionality.marketing.leads.ImportLeadSelectCSVFileLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsCreatePage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsDetailLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsListMappingLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.MappingResultsLandingPage;
import com.vitiger.eva.pages.functionality.marketing.campaign.CampaignDetailLandingPage;
import com.vitiger.eva.pages.functionality.marketing.campaign.CampaignLandingPage;
import com.vitiger.eva.pages.functionality.marketing.campaign.CreateCampaignLandingPage;
public class TestScript extends BaseTestClass {
	private Map<String, String> mapRowData;
	private CampaignDetailLandingPage cDLP;

	@Test(dataProvider = "getValue")
	public void verifyCreateInvoice(Object objMapData) {
		webUtil.setImplicitlyWait(4);
		mapRowData = (Map<String, String>) objMapData;
		InvoiceLandingPage iNLP = hmp.goToInventoryLandingPage();
		CreateInvoiceLandingPage cILP = iNLP.clickOnInvoiceButton();
		InvoiceDetailPage iDP = cILP.saveButton(mapRowData);
		String ExpectedError = mapRowData.get("ExpextedErrorMessage ");
		String scenarioResut = mapRowData.get("Scenario");
		if (scenarioResut.equalsIgnoreCase("Invalid")) {
			webUtil.validatePopUpText(ExpectedError);
			webUtil.HandleAlertAccept();
		} else {
			webUtil.validateText(iDP.getSubject(), mapRowData.get("Subject"), "Kirana Store");
			webUtil.validateText(iDP.getCustomerNo(), mapRowData.get("CustomerNo"), "330");
			webUtil.validateText(iDP.getBillingAddress(), mapRowData.get("Bill_street"), "Mahboobpur");
		}
	}

//	@Test(groups= {"Sanity"},dataProvider = "getValue")
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
	@Test(groups= {"Regression"},dataProvider = "getValue")
	public void verifyCreateLead(Object objMapData) {
		mapRowData = (Map<String, String>) objMapData;
		LeadsLandingPage lLp = hmp.goToMarketingLandingPage();
		LeadsCreatePage leadsCreate = lLp.clickCreateAccountButton("Click Button");
//		for (int i = 0; i < listTestdata.size(); i++) {
//			mapRowData = ExcelDataUtil.totalListData.get(i);
		LeadsDetailLandingPage lILP = leadsCreate.saveLeads(mapRowData);
		String expectedErrorMessage = mapRowData.get("ErrorMessage");
		String scenario = mapRowData.get("ScenarioType");
		if (scenario.equalsIgnoreCase("Invalid")) {
			webUtil.validatePopUpText(expectedErrorMessage);
			webUtil.HandleAlertAccept();
		} else {
			lILP.validateLeadsDetailInfo();
		}
	}

@Test(retryAnalyzer = IRetryFailedTestCase.class)
	public void verifyImportLead() {
//		System.out.println(10/0);
		LeadsLandingPage lLP = hmp.goToMarketingLandingPage();
		ImportLeadSelectCSVFileLandingPage iLFLP = lLP.clickOnImportLead("Import Lead");
		LeadsListMappingLandingPage lLMLP = iLFLP.clickOnNextButton();
		MappingResultsLandingPage mRLP = lLMLP.clickOnImportNowButton();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mRLP.clickOnFinishedButton();
	}
	@Test
public  void a() {
	System.out.println("method A "+Thread.currentThread().getId());
}
}
