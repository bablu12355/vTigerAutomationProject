package com.eva.vtiger.pages.functionality.marketing.leads;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.leeds.OrMappingResultsLandingPage;

public class MappingResultsLandingPage extends OrMappingResultsLandingPage {

	private WebDriverUtil WebUtil;

	public MappingResultsLandingPage(WebDriverUtil WebUtil) {
		this.WebUtil = WebUtil;
		PageFactory.initElements(WebUtil.getDriver(), this);

	}
	public  void clickOnFinishedButton() {
		WebUtil.usingWebElementclickMethod(clickFinishedBt, "Finished");
	}
}
