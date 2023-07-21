package com.vitiger.eva.pages.functionality.marketing.campaign;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.campaign.OrCampaignDetailLandingpage;

public class CampaignDetailLandingPage extends OrCampaignDetailLandingpage {

	private WebDriverUtil webUtil;

	public CampaignDetailLandingPage(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	public EditCampaignLandingPage clickEditButton() {
		webUtil.usingWebElementclickMethod(clickEditButton, "Edit Button");
		return new EditCampaignLandingPage(webUtil);
	}
}
