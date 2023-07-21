package testCaseLayer;

import org.testng.annotations.Test;

import pageLayer.LoginPage;
import utilLayer.WebUtil;

public class Whishlist_module_TC {
	
	 @Test
	public  void logOutVerification() {
		WebUtil util = new WebUtil();
		util.extentReport("AllproductOfCrazzyhub");
		util.createTestCase("Login verification");
		util.openBroswer("chrome");
		util.implicitWait(5);
		util.openURl("http://crazzyhub.com/");
		util.maximize();
		
		
		LoginPage log = new LoginPage(util);
		log.Account_ln();
		log.phon_No();
		log.Login();
		log.Otp_Bt();
		util.flush();
		util.click(log.otpSubmit, "OTP submit button");
			 
	 Whishlist  whish = new  Whishlist(util); 
		whish.Allproduct(); 
		util.flush();			
		
}
}
