package org.jumia.vtiger.testScripts;

import org.jumia.vtiger.genericCode.WebDriverUtil;

import com.eva.vtiger.pages.functionality.login.LoginPage;
import com.eva.vtiger.pages.functionality.myhomepage.home.HomePage;
import com.eva.vtiger.pages.functionality.support.contacts.MassEdit_RecordsFieldLandingPage;
import com.eva.vtiger.pages.functionality.support.contacts.Support_ContactsLandingPage;

public class MassEditTestScript {
		private WebDriverUtil webUtil ;
		public MassEditTestScript(WebDriverUtil webUtil ) {
			this.webUtil=webUtil;
		}
	public void verifyRecorsField(String tcID) {
		webUtil.testCaseId(tcID);
		webUtil.launchBrower(webUtil.getConfiValue("browser"));
		webUtil.hitUrl(webUtil.getConfiValue("url"));
		LoginPage loginPageObj = new LoginPage(webUtil);
		HomePage hmp = 	loginPageObj.validLogin();
		Support_ContactsLandingPage sclp=hmp.goToSupportLandingPage();
		sclp.clickOnCheckBox();
		sclp.clickOnMassEdit();
		MassEdit_RecordsFieldLandingPage mrflp=new MassEdit_RecordsFieldLandingPage(webUtil);
		mrflp.saveButtonclick();
	
	}
}
