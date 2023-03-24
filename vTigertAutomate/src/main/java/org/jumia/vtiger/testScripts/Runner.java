package org.jumia.vtiger.testScripts;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

public class Runner {
	public static void main(String[] args) {

		WebDriverUtil w= new WebDriverUtil();
      	w.extentReport();
//		LeadsTestScript lts=	new	LeadsTestScript(w);
//		lts.verifyCreateLeads("tc001");
//		
//		NewTestScript nts = new NewTestScript(w);
//		nts.verifyNewCustomView("tc002");
//
//		TableTestScript tts = new TableTestScript(w);
//		tts.verifyFirstName("tc003");
//	
		MassEditTestScript mets=new MassEditTestScript(w);
		mets.verifyRecorsField("tc004");
		w.flushed();
	}
}
