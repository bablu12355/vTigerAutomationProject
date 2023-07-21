package org.jumia.vtiger.testScripts;

import org.jumia.vtiger.genericCode.WebDriverUtil;

import com.eva.vtiger.pages.functionality.login.LoginPage;
import com.eva.vtiger.pages.functionality.myhomepage.home.HomePage;
import com.eva.vtiger.pages.functionality.myhomepage.home.ValidationHomePage;
import com.evs.vtiger.functionality.reusablecodepage.ReusableCommanCodevtigerDependentBasePage;

public class TableTestScript  {

		private WebDriverUtil webUtil ;
		public TableTestScript(WebDriverUtil webUtil ) {
			// TODO Auto-generated constructor stub
			this.webUtil=webUtil;
		}
	public void verifyFirstName(String tcID) {
		webUtil.testCaseId(tcID);
		webUtil.launchBrower("chrome");
		webUtil.hitUrl( "http://localhost:8888/");
		LoginPage loginPageObj =new LoginPage(webUtil);
	    loginPageObj.validLogin();
	    HomePage hmp=	new HomePage(webUtil);
	    hmp.goToSupportLandingPage();
		ReusableCommanCodevtigerDependentBasePage rccd=new ReusableCommanCodevtigerDependentBasePage(webUtil);
		rccd.Searchfor("Raman", "Raman");
		rccd.inSelectedDropdownMethod("First Name", "First Name");
		rccd.searchNow();
		ValidationHomePage validateHmp=	new ValidationHomePage(webUtil);
		validateHmp.validateFirstName();
		hmp.signOut();

	}
}
