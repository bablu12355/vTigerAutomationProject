package com.eva.vtiger.pages.functionality.support.contacts;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vitger.pages.or.support.contacts.OrSupport_ContactsLandingPage;

public class Support_ContactsLandingPage extends OrSupport_ContactsLandingPage {

	private WebDriverUtil util;

	public Support_ContactsLandingPage(WebDriverUtil util) {
		super(util);
		this.util = util;

	}

	public void clickOnMassEdit() {
		util.usingWebElementclickMethod(massEditBt, "Mass Edit");
	}

	public void clickOnCheckBox() {
util.usingWebElementclickMethod(checkBoxBt, "Select All Check Box");
	}
}
