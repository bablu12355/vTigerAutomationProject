package com.eva.vtiger.commanCode;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;

public class reusableCommanCode {
	private static WebDriverUtil webutil;

	public static void main(String[] args) {
		reusableCommanCode rcc = new reusableCommanCode();
		rcc.validateLogOut();
//		rcc.validateLogin();

	}

	public void validateLogin() {
		webutil = new WebDriverUtil();
		ExtentReports extr = webutil.extentReport();
		webutil.testCaseId(extr, "validateLogin");
		webutil.hitUrl("chrome", "http://localhost:8888");
		WebElement webE = webutil.getWebElementLocatorXpath("user_name", "name");
		webutil.usingWebElementSendKeys(webE, "admin", "username");

		WebElement webE1 = webutil.getWebElementLocatorXpath("//input[@name='user_password']", "xpath");
		webutil.usingWebElementSendKeys(webE1, "Bablu@123", "userpassword");

		WebElement webE2 = webutil.getWebElementLocatorXpath("//input[@name='Login']", "xpath");
		webutil.usingWebElementclickMethod(webE2, "Login Button");

	}

	public void validateLogOut() {
		validateLogin();
		WebElement web = webutil.getWebElementLocatorXpath("//a[text()='Sign Out']", "xpath");
		webutil.usingWebElementclickMethod(web, "Sign Out");
	}
}
