package com.eva.vtiger.pages.functionality.marketing.leads;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.leeds.OrLeadsLandingPage;
import com.evs.vtiger.functionality.reusablecodepage.ReusableCommanCodevtigerDependentBasePage;

public class LeadsLandingPage extends OrLeadsLandingPage {
	private WebDriverUtil WebUtil;

	public LeadsLandingPage(WebDriverUtil WebUtil) {
		super(WebUtil);
		this.WebUtil = WebUtil;

	}

	public void clickCreateAccountButton(String elementName) {
		WebUtil.usingWebElementclickMethod(clickCreateBT, elementName);

	}

}
