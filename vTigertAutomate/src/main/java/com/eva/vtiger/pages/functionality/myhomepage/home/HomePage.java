package com.eva.vtiger.pages.functionality.myhomepage.home;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.functionality.marketing.leads.LeadsLandingPage;
import com.eva.vtiger.pages.functionality.salesPage.leads.Sales_LeadsLandingPage;
import com.eva.vtiger.pages.or.myhomepage.OrHomePage;

public class HomePage extends OrHomePage {
	private WebDriverUtil webUtil;
	public HomePage(WebDriverUtil webUtil) {
	super(webUtil);
		this.webUtil = webUtil;

	}

	public void goToMarketingLandingPage() {
		webUtil.actionsMouseOver(marketingMo, "Marketing Module");
		webUtil.usingWebElementclickMethod(leadsBT, "Leads");
	}

	public void goTosalesLandingPage() {
		webUtil.actionsMouseOver(salesMo, "Sales Link");
		webUtil.usingWebElementclickMethod(invoiceBT, "invoice");
		
	}

	public void goToSupportLandingPage() {
		webUtil.actionsMouseOver(supportMo, "Support Link");
		webUtil.usingWebElementclickMethod(contactsBt, "Click Contacts");
		
	}
}
