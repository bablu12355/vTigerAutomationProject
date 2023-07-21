package com.eva.vtiger.pages.functionality.marketing.leads;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.leeds.OrLeadsInformationLandingPage;

public class LeadsDetailLandingPage extends OrLeadsInformationLandingPage{

	private WebDriverUtil webUtil;
	
	public LeadsDetailLandingPage(WebDriverUtil webUtil) {
		this.webUtil= webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	}
	
	public void validateLeadsDetailInfo() {
		webUtil.validateText(LeadInformationtxt, "Lead Information", "Lead Information");
	}

	public void ValidateLeadNoLeadsDetailInfo() {
		webUtil.validateText(ExpertViewAutomation, "Expert View Automation", "Expert View Automation");
	}
}
