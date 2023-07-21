package com.eva.vtiger.pages.functionality.marketing.leads;

import java.util.Map;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.leeds.OrLeadsCreatePage;

public class LeadsCreatePage extends OrLeadsCreatePage {
 
	private  WebDriverUtil webUtil;
	
	public LeadsCreatePage(WebDriverUtil webUtil) {
		this. webUtil= webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	

	 }
	public void enterValueInformation(Map<String, String> rowDataList1) {
	String firstNameData=	rowDataList1.get("firstname");
	String lastNameData=	rowDataList1.get("lastname");
	String companyIdData=	rowDataList1.get("company");
	String titleData=	rowDataList1.get("Title");
	String mobileData=	rowDataList1.get("mobile");
	String emailData=	rowDataList1.get("emai_id");
	String streetData=	rowDataList1.get("street");
	String countryData=	rowDataList1.get("country");
	String stateData=	rowDataList1.get("State");

		webUtil.usingWebElementSendKeys(firstNameEd, firstNameData, "First Name");
		webUtil.usingWebElementSendKeys(lastNameEd, lastNameData, "Last Name");
		webUtil.usingWebElementSendKeys(companyEd,companyIdData, "Company");
		webUtil.usingWebElementSendKeys(titleED,titleData, "Title");
		webUtil.usingWebElementSendKeys(mobileED, mobileData, "Mobile");
		webUtil.usingWebElementSendKeys(emailED,emailData , "Email");
		webUtil.usingWebElementSendKeys(streetEd,streetData ,"Street");
		webUtil.usingWebElementSendKeys(CountryEd, countryData, "Country");
		webUtil.usingWebElementSendKeys(StateEd, stateData, "State");
	}
	

	public LeadsDetailLandingPage saveLeads(Map<String, String> rowDataList1) {
		enterValueInformation(rowDataList1);
		webUtil.usingWebElementclickMethod(saveLeadsBt, "Click");
	return 	new LeadsDetailLandingPage(webUtil);
	}

	public void cancelLeads(Map<String, String> rowDataList1) {
		enterValueInformation(rowDataList1);
		webUtil.usingWebElementclickMethod(cancelLeadsBt, "Click");
	}

}
