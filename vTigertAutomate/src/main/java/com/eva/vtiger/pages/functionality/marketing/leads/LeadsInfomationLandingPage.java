package com.eva.vtiger.pages.functionality.marketing.leads;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.leeds.OrLeadsInformationLandingPage;

public class LeadsInfomationLandingPage extends OrLeadsInformationLandingPage{

	private WebDriverUtil webUtil;
	
	public LeadsInfomationLandingPage(WebDriverUtil webUtil) {
		super(webUtil);
		this.webUtil= webUtil;
	}
	
	public void validateLeadsDetailInfo() {
		webUtil.validateText(LeadInformationtxt, "Lead Information", "Lead Information");
	}

	public void ValidateLeadNoLeadsDetailInfo() {
		webUtil.validateText(ExpertViewAutomation, "Expert View Automation", "Expert View Automation");
	}
}
