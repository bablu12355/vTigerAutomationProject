package com.evs.vtiger.functionality.reusablecodepage;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.eva.vtiger.or.reusablecodepage.OrReusableCommanCodevtigerDependentBasePage;
import com.eva.vtiger.pages.functionality.login.LoginPage;
import com.eva.vtiger.pages.functionality.myhomepage.home.HomePage;

public class ReusableCommanCodevtigerDependentBasePage extends OrReusableCommanCodevtigerDependentBasePage {

	private WebDriverUtil webUtil;

	public ReusableCommanCodevtigerDependentBasePage(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	}

	public void Searchfor(String inputValue, String elementName) {
		webUtil.usingWebElementSendKeys(SearchforElement, inputValue, elementName);

	}

	public void inSelectedDropdownMethod(String elementName, String dropdownElememntName) {
		webUtil.SelectByVisibleText(elementSelectedDD, elementName, dropdownElememntName);
	}

	public void searchNow() {
		webUtil.usingWebElementclickMethod(searchNowElement, "Search Now");
	}

	public void closePointer() {
		webUtil.usingWebElementclickMethod(closePointerBT, "Close Pointer");
	}

	public void gotToAdvanceSearch() {
		webUtil.usingWebElementclickMethod(advanceSearchBT, "Go to Advanced Search");
	}

	public void matchAllOfTheFollowing() {
		webUtil.usingWebElementclickMethod(clickMatchAllOfTheFollowing, "Match All of the Following");
	}

	public void matchAnyOfTheFollowing() {
		webUtil.usingWebElementclickMethod(clickAnyOfTheFollowing, " Match Any of the Following");
	}

	

	public void searchBoxFind() {
		webUtil.usingWebElementSendKeys(searchBoxBt, "Yadav", "Yadav");
		webUtil.usingWebElementclickMethod(ClickOnFindBt, "Find");
	}

//	public void alphaBatic(char alpha,String elementname) {
	// if (alpha >= 65 && alpha <= 90) {
//			webUtil.usingWebElementclickMethod(alphaElementclick, elementname);
//		}
//	}

}
