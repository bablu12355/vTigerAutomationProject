package com.eva.vtiger.pages.functionality.salesPage.leads;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vitger.pages.or.salespage.leads.OrSales_LeadsLandingPage;
import com.evs.vtiger.functionality.reusablecodepage.ReusableCommanCodevtigerDependentBasePage;

public class Sales_LeadsLandingPage extends OrSales_LeadsLandingPage {
	private WebDriverUtil webUtil;
	public Sales_LeadsLandingPage(WebDriverUtil webUtil) {
		super(webUtil);
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	}

	public NewCustomViewPage clickNewCustomView() {
		webUtil.usingWebElementclickMethod(newLinkClick, "Click New Link");
		return new  NewCustomViewPage(webUtil);
	}

}