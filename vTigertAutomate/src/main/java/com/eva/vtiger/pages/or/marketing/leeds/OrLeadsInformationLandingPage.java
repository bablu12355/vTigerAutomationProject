package com.eva.vtiger.pages.or.marketing.leeds;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrLeadsInformationLandingPage {


	@FindBy(xpath = "//td[@class='dvtSelectedCell']")
	protected WebElement LeadInformationtxt;

	@FindBy(xpath = "//span[@id='dtlview_Company']")
	protected WebElement ExpertViewAutomation;

	private WebDriverUtil webUtil;
	
	public OrLeadsInformationLandingPage(WebDriverUtil webUtil) {
		this.webUtil= webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}
}
