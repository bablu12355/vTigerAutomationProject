package com.eva.vtiger.pages.functionality.marketing.leads;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.leeds.OrLeadsCreatePage;

public class LeadsCreatePage extends OrLeadsCreatePage {
 
	private  WebDriverUtil webUtil;
	
	public LeadsCreatePage(WebDriverUtil webUtil) {
	super(webUtil);
		this. webUtil= webUtil;
		

	 }
	public void enterValueInformation() {
		webUtil.usingWebElementSendKeys(firstNameEd, "Bablu1234", "First Name");
		webUtil.usingWebElementSendKeys(lastNameEd, "Yaduvanshi", "Last Name");
		webUtil.usingWebElementSendKeys(companyEd, "Expert View Automation", "Company");
		webUtil.usingWebElementSendKeys(titleED,"hii this is bablu yadav task to create leads", "Title");
		webUtil.usingWebElementSendKeys(mobileED, "6368993420", "Mobile");
		webUtil.usingWebElementSendKeys(emailED, "by862473@gmail.com", "Email");
		webUtil.usingWebElementSendKeys(streetEd, "Mahboobpur..Kukrauthi..Bhadohi","Street");
		webUtil.usingWebElementSendKeys(CountryEd, "India", "Country");
		webUtil.usingWebElementSendKeys(StateEd, "Uttar Pradesh", "State");
	}
	

	public void saveLeads() {
		enterValueInformation();
		webUtil.usingWebElementclickMethod(saveLeadsBt, "Click");
	}

	public void cancelLeads() {
		enterValueInformation();
		webUtil.usingWebElementclickMethod(cancelLeadsBt, "Click");
	}

}
