package org.jumia.vtiger.testScripts;

import org.jumia.vtiger.genericCode.WebDriverUtil;

public class Runne {
	public static void main(String[] args) {
		WebDriverUtil w = null;
     
		try {
			w = new WebDriverUtil();
			w.extentReport();

			LoginPageTestCase lpTC = new LoginPageTestCase(w);
			lpTC.verifyLoginPageTestScript("TC001");

//		LeadsTestScript lts=	new	LeadsTestScript(w);
//		lts.verifyCreateLeads("VerifyCreateLead");

//		TestScript iTS=	new TestScript();
//		iTS.verifyCreateInvoice();
		
//		NewTestScript nts = new NewTestScript(w);
//		nts.verifyNewCustomView("tc002");

//		TableTestScript tts = new TableTestScript(w);
//		tts.verifyFirstName("tc003");

//		MassEditTestScript mets=new MassEditTestScript(w);
//		mets.verifyRecorsField("tc004");
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
		} finally {
			w.flushed();
		}
	}
}
