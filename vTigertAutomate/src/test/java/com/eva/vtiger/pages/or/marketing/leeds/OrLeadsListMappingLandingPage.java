package com.eva.vtiger.pages.or.marketing.leeds;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrLeadsListMappingLandingPage {

	@FindBy(xpath = "//select[@id='colnum0']")
	protected WebElement clickcompanyDD;
		
	@FindBy(xpath = "//select[@id='colnum1']")
	protected WebElement clickLastNameDD;
	
	@FindBy(xpath = "//select[@id='colnum2']")
	protected WebElement clickFirstNameDD;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	protected WebElement clickImportNowButton;
	
	@FindBy(xpath = "//input[@class='crmbutton small cancel']")
	protected WebElement clickCancelButton;
	
	
	
	
	
	
	
	
}
