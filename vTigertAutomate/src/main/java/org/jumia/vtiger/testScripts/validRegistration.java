package org.jumia.vtiger.testScripts;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;

public class validRegistration {

	public static void main(String[] args) {
		loginInstagram();
	}

	public static void loginInstagram() {
		WebDriverUtil webutil = new WebDriverUtil();
		ExtentReports extr = webutil.extentReport();
		webutil.testCaseId(extr, "TC001 login Instagram");
		webutil.hitUrl("chrome", "https://www.instagram.com/");
		WebElement web=webutil.getWebElementLocatorXpath("//input[@name='username']", "xpath");
		webutil.usingWebElementSendKeys(web, "by862473@gmail.com","usernamebox");
	
		WebElement web1=webutil.getWebElementLocatorXpath("//input[@name='password']", "xpath");
		webutil.usingWebElementSendKeys(web1, "12334444","passwordBox");
	
		WebElement web2=webutil.getWebElementLocatorXpath("//div[@class='_ab8w  _ab94 _ab99 _ab9f _ab9m _ab9p  _abak _abb8 _abbq _abb- _abcm']//button[@type='submit']", "xpath");
		webutil.usingWebElementclickMethod(web2, "login button");
		 
		WebElement web3=webutil.getWebElementLocatorXpath("//a[text()='Forgot password?']", "xpath");
        webutil.usingWebElementclickMethod(web3, "Forgot Button");
		
        WebElement web4=webutil.getWebElementLocatorXpath("//input[@name='cppEmailOrUsername']", "xpath");
		webutil.usingWebElementSendKeys(web4, "by862473@gmail.com", "Email");
       
//		webutil.setImplicitlyWait(5);
//		WebElement web5=webutil.getWebElementLocatorXpath("//div[@class='_ab8w  _ab94 _ab99 _ab9f _ab9m _ab9p  _abam _abb9 _abbr _abcm']//button[text()='Send login link']", "xpath");
//        webutil.usingWebElementclickMethod(web5, "Send login link");
		
//		webutil.hitUrl("chrome", "");

        
	       
//			webutil.setImplicitlyWait(5);
//			WebElement web5=webutil.getWebElementLocatorXpath("//div[@class='_ab8w  _ab94 _ab99 _ab9f _ab9m _ab9p  _abam _abb9 _abbr _abcm']//button[text()='Send login link']", "xpath");
//	        webutil.usingWebElementclickMethod(web5, "Send login link");
			
//			webutil.hitUrl("chrome", "");

        
        
        
        
        
        
        extr.flush();
	}

}
