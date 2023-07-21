package com.eva.vtiger.pages.or.marketing.leeds;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.functionality.reusablecodepage.ReusableCommanCodevtigerDependentBasePage;

public class OrLeadsLandingPage extends ReusableCommanCodevtigerDependentBasePage{

	public OrLeadsLandingPage(WebDriverUtil webUtil) {
		super(webUtil);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//img[@title='Create Lead...']//parent::a")
	protected WebElement clickCreateBT;
	
	@FindBy(xpath = "//img[@alt='Import Leads']")
	protected WebElement clickImportLead;
 
}
