package com.eva.vitger.pages.or.salespage.leads;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.functionality.reusablecodepage.ReusableCommanCodevtigerDependentBasePage;

public class OrSales_LeadsLandingPage extends ReusableCommanCodevtigerDependentBasePage {

	public OrSales_LeadsLandingPage(WebDriverUtil webUtil) {
		super(webUtil);
	}

	@FindBy(xpath = "//a[text()='New']")
	protected WebElement newLinkClick;

	

}
