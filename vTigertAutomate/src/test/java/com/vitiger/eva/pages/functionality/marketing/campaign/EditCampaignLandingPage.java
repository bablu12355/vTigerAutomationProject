package com.vitiger.eva.pages.functionality.marketing.campaign;

import java.util.Map;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.campaign.OrEditCampaignLandingPage;

public class EditCampaignLandingPage extends OrEditCampaignLandingPage {


	private WebDriverUtil webUtil;

	public EditCampaignLandingPage(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	public void basicInformation(Map<String, String> mapObj) {
		webUtil.usingWebElementSendKeys(campaignEd, mapObj.get("CampaignName"), "Campaign Name");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webUtil.selectByValueAttribute(campaignTypeDD, "Campaign Type", mapObj.get("CampaignType"));
		webUtil.usingWebElementSendKeys(targetAudienceEd, mapObj.get("TargetAudience"), "Target Audience");
		webUtil.usingWebElementSendKeys(sponsorED, mapObj.get("Sponsor"), "Sponsor");
		webUtil.selectByValueAttribute(campaignStatusDD, "Campaign Status",mapObj.get("CampaignStatus"));
		webUtil.usingWebElementSendKeys(actualCost,mapObj.get("ActualCost"), "Actual Cost");
		webUtil.usingWebElementSendKeys(actualResponseCountED,mapObj.get("ActualSalesCount"), "Actual Response Count");
	
	}

	public CampaignDetailLandingPage saveButton(Map<String, String> mapObj) {
		basicInformation(mapObj);
		webUtil.usingWebElementclickMethod(saveBt, "Save Button");
	return	new CampaignDetailLandingPage(webUtil);
	}

	public void cancelButton(Map<String, String> mapObj) {
		basicInformation(mapObj);
		webUtil.usingWebElementclickMethod(cancelBt, "Cancel Button");
	}
}


