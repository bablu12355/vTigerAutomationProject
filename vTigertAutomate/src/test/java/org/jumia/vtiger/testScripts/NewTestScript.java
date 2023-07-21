package org.jumia.vtiger.testScripts;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.eva.vtiger.pages.functionality.login.LoginPage;
import com.eva.vtiger.pages.functionality.myhomepage.home.HomePage;
import com.eva.vtiger.pages.functionality.salesPage.leads.NewCustomViewPage;
import com.eva.vtiger.pages.functionality.salesPage.leads.Sales_LeadsLandingPage;

public class NewTestScript {
	private WebDriverUtil webUtil ;
	public NewTestScript(WebDriverUtil webUtil ) {
		// TODO Auto-generated constructor stub
		this.webUtil=webUtil;
	}

	public void verifyNewCustomView(String tcID) {
		webUtil.testCaseId(tcID);
		webUtil.launchBrower(webUtil.getConfiValue("browser"));
		webUtil.hitUrl(webUtil.getConfiValue("url"));
		LoginPage loginPageObj = new LoginPage(webUtil);
		HomePage hmp= loginPageObj.validLogin();
		 Sales_LeadsLandingPage clickNewLink   =  hmp.goTosalesLandingPage();
		 NewCustomViewPage ncvp =   clickNewLink.clickNewCustomView();
	   	ncvp.saveNewCustomView();

		webUtil.flushed();
	}
}
