package com.eva.vtiger.pages.functionality.login;

import java.util.Map;
import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.eva.vtiger.pages.functionality.myhomepage.home.HomePage;
import com.eva.vtiger.pages.or.login.LoginOR;

public class LoginPage extends LoginOR{

	private WebDriverUtil WebUtil;
	public LoginPage(WebDriverUtil WebUtil){
		this.WebUtil=WebUtil;
	PageFactory.initElements(WebUtil.getDriver(), this);
	}
	public HomePage  validLogin(Map<String, String> rowDataList) {
		String usernameData=rowDataList.get("Username");
		String passwordData=rowDataList.get("Password");
		WebUtil.usingWebElementSendKeys(getUserNameEd(), usernameData, "username");
		WebUtil.usingWebElementSendKeys(getUserPasswordEd(),passwordData , "userpassword");
		WebUtil.usingWebElementclickMethod(getLoginBt(), "Login Button");
		 return new HomePage(WebUtil);
	}
	public HomePage  validLogin() {
		WebUtil.usingWebElementSendKeys(getUserNameEd(), WebUtil.getConfiValue("username"), "username");
		WebUtil.usingWebElementSendKeys(getUserPasswordEd(),WebUtil.getConfiValue("password") , "userpassword");
		WebUtil.usingWebElementclickMethod(loginBt, "Login Button");
		 return new HomePage(WebUtil);
	}

	public HomePage invalidLogin() {
		WebUtil.usingWebElementSendKeys(getUserNameEd(), WebUtil.getConfiValue("user_name"), "username");
		WebUtil.usingWebElementSendKeys(getUserPasswordEd(),WebUtil.getConfiValue("user_pass"), "userpassword");
		WebUtil.usingWebElementclickMethod(getLoginBt(), "Login Button");
		return new HomePage(WebUtil);
	}

	public void changeColor(String login_theme) {
		WebUtil.selectByValueAttribute(getLogin_theme_Dd(), "Color Theme", login_theme);
	}

	public void changeLanguage(String login_language) {
		WebUtil.selectByValueAttribute(getLogin_theme_Dd(), "language", login_language);
	}
	public void valiadteUserName(String login_language) {
		WebUtil.selectByValueAttribute(getLogin_theme_Dd(), "language", login_language);
	}

}
