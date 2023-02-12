package org.jumia.vtiger.testScripts;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;

public class TextCase_VtigerAutomate {
	static WebDriverUtil webutil;

	public static void main(String[] args) {
		webutil=new WebDriverUtil();
		TextCase_VtigerAutomate web = new TextCase_VtigerAutomate();
		ExtentReports extr=webutil.extentReport();
		webutil.testCaseId(extr, "TC001");
		webutil.hitUrl("chrome", "http://localhost:8888");
		
		web.verifySizeOfElement();
		
		webutil.testCaseId(extr, "TC002");
		web.verifyLocationOfElement();

		webutil.testCaseId(extr, "TC003");
		web.verifyVCreateNewLeads();

		webutil.flushed(extr);
	}

	public void verifySizeOfElement() {
//		webutil = new WebDriverUtil();
		WebElement web = webutil.getWebElementLocatorXpath("user_name", "name");
		webutil.validateSizeOfAnyElement(web, "Username", 149, 22);

		WebElement web1 = webutil.getWebElementLocatorXpath("//input[@name='user_password']", "xpath");
		webutil.validateSizeOfAnyElement(web1, "Userpassword", 149, 22);

		WebElement web2 = webutil.getWebElementLocatorXpath("//input[@name='Login']", "xpath");
		webutil.validateSizeOfAnyElement(web2, "Login", 138, 40);
	}

	public void verifyLocationOfElement() {
//		webutil = new WebDriverUtil();

		WebElement web = webutil.getWebElementLocatorXpath("user_name", "name");
		webutil.validateLocationOfElement(web, "Username", 640, 230);

		WebElement web1 = webutil.getWebElementLocatorXpath("//input[@name='user_password']", "xpath");
		webutil.validateLocationOfElement(web1, "Userpassword", 640, 262);

		WebElement web2 = webutil.getWebElementLocatorXpath("//input[@name='Login']", "xpath");
		webutil.validateLocationOfElement(web2, "Login", 640, 350);

	}

	public void verifyVCreateNewLeads() {

		WebElement webE = webutil.getWebElementLocatorXpath("user_name", "name");
		webutil.usingWebElementSendKeys(webE, "admin", "username");

		WebElement webE1 = webutil.getWebElementLocatorXpath("//input[@name='user_password']", "xpath");
		webutil.usingWebElementSendKeys(webE1, "Bablu@123", "userpassword");

		WebElement webE2 = webutil.getWebElementLocatorXpath("//input[@name='Login']", "xpath");
		webutil.usingWebElementclickMethod(webE2, "Login Button");

		WebElement webE3 = webutil.getWebElementLocatorXpath("Marketing", "linkText");
		webutil.usingWebElementclickMethod(webE3, "Marketing");

		WebElement webE4 = webutil.getWebElementLocatorXpath("//table[@class='level2Bg']//td//a[text()='Leads']",
				"xpath");
		webutil.usingWebElementclickMethod(webE4, "Leads");

		WebElement webE5 = webutil.getWebElementLocatorXpath("//img[@title='Create Lead...']//parent::a", "xpath");
		webutil.usingWebElementclickMethod(webE5, "Plus Button");

		WebElement webE6 = webutil.getWebElementLocatorXpath("//input[@name='firstname']", "xpath");
		webutil.usingWebElementSendKeys(webE6, "Bablu", "First Name");

		WebElement webE7 = webutil.getWebElementLocatorXpath("//input[@name='lastname']", "xpath");
		webutil.usingWebElementSendKeys(webE7, "Yaduvanshi", "Last Name");

		WebElement webE8 = webutil.getWebElementLocatorXpath("//input[@name='company']", "xpath");
		webutil.usingWebElementSendKeys(webE8, "Expert View Automation", "Company");

		WebElement webE9 = webutil.getWebElementLocatorXpath("//input[@name='designation']", "xpath");
		webutil.usingWebElementSendKeys(webE9, "hii this is bablu yadav task to create leads", "Title");

		WebElement webE10 = webutil.getWebElementLocatorXpath("mobile", "id");
		webutil.usingWebElementSendKeys(webE10, "6368993420", "Mobile");

		WebElement webE11 = webutil.getWebElementLocatorXpath("email", "id");
		webutil.usingWebElementSendKeys(webE11, "by862473@gmail.com", "Email");

		WebElement webE12 = webutil.getWebElementLocatorXpath("//textarea[@name='lane']", "xpath");
		webutil.usingWebElementSendKeys(webE12, "Mahboobpur..Kukrauthi..Bhadohi", "Street");

		WebElement webE13 = webutil.getWebElementLocatorXpath("country", "id");
		webutil.usingWebElementSendKeys(webE13, "India", "Country");

		WebElement webE14 = webutil.getWebElementLocatorXpath("state", "id");
		webutil.usingWebElementSendKeys(webE14, "Uttar Pradesh", "State");

		WebElement webE15 = webutil.getWebElementLocatorXpath(
				"//b[contains(text(),'Description Information')]//parent::td//parent::tr//following-sibling::tr//following-sibling::td//following-sibling::div//input[@title='Save [Alt+S]']",
				"xpath");
		webutil.usingWebElementclickMethod(webE15, "Click");

	}
}
