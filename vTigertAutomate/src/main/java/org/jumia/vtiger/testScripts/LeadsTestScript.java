package org.jumia.vtiger.testScripts;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.eva.vtiger.pages.functionality.login.LoginPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsCreatePage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsInfomationLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsLandingPage;
import com.eva.vtiger.pages.functionality.myhomepage.home.HomePage;
import com.eva.vtiger.pages.functionality.salesPage.leads.NewCustomViewPage;
import com.eva.vtiger.pages.functionality.salesPage.leads.Sales_LeadsLandingPage;
import com.evs.vtiger.functionality.reusablecodepage.ReusableCommanCodevtigerDependentBasePage;

public class LeadsTestScript {

		private WebDriverUtil webUtil ;
		public LeadsTestScript(WebDriverUtil webUtil ) {
			// TODO Auto-generated constructor stub
			this.webUtil=webUtil;
		}
	public void verifyCreateLeads(String tcID) {
		webUtil.testCaseId(tcID);
		webUtil.launchBrower("chrome");
		webUtil.hitUrl( "http://localhost:8888/");
		LoginPage loginPageObj =new  LoginPage(webUtil);
		 loginPageObj.validLogin();
		 HomePage hmp=	new HomePage(webUtil);
		 hmp.goToMarketingLandingPage();
		 LeadsLandingPage leadsCreate=	new LeadsLandingPage(webUtil);
		 leadsCreate.Searchfor( "LEA20", "LEA20");
		leadsCreate.inSelectedDropdownMethod("Lead No", "Lead No");
		leadsCreate.searchNow();
		leadsCreate.clickCreateAccountButton("Click Button");
		LeadsCreatePage leadsCreate1 =  new LeadsCreatePage(webUtil);
		leadsCreate1.saveLeads();
		LeadsInfomationLandingPage leadsValidate = new LeadsInfomationLandingPage(webUtil);
		leadsValidate.validateLeadsDetailInfo();
		leadsValidate.ValidateLeadNoLeadsDetailInfo();
	
	}

}
