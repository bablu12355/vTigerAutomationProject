package com.eva.vtiger.pages.functionality.support.contacts;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vitger.pages.or.support.contacts.OrMassEdit_RecordsFieldLandingPage;

public class MassEdit_RecordsFieldLandingPage extends OrMassEdit_RecordsFieldLandingPage {
	private WebDriverUtil util;

	public MassEdit_RecordsFieldLandingPage(WebDriverUtil util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);

	}

		
public  void enterValueInformation() {
	
	util.setImplicitlyWait(2);
	util.SelectByIndex(salutationDd, "Mr",4);
	
util.SelectByVisibleText(salutationDd, "Mr", "Mr.");
	
	util.selectByValueAttribute(salutationDd, "Mr", "Mr.");
	
	util.usingWebElementSendKeys(firstNameEd, "Bablu"," bablu");
	util.usingWebElementSendKeys(lastNameEd, "Yadav"," Yadav");
	util.usingWebElementSendKeys(AccountNameEd, "396181993402"," Account_Name");
	util.usingWebElementSendKeys(mobileEd, "6386993420"," Mobile");
	util.usingWebElementSendKeys(leadsSourceDd, "Employee"," Employee");
	util.usingWebElementSendKeys(emailEd, "by862473@gmail.com"," Email");
	util.usingWebElementSendKeys(assistantEd, "QA Tester"," Assistant");
	
}
public void saveButtonclick() {
	enterValueInformation();
	util.usingWebElementclickMethod(saveClick, "Save Button");
}

public void cancelButtonclick() {
	enterValueInformation();
	util.usingWebElementclickMethod(cancelClick, "Cancel Button");
}








}