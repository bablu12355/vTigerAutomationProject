package com.eva.vtiger.pages.functionality.inventory.invoice;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

public class AccountsLandingPage {

	private WebDriverUtil webUtil;

	public AccountsLandingPage(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}
	
}
