package com.eva.vtiger.pages.or.login;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOR {

	@FindBy(name = "user_name")
	protected WebElement userNameEd;

	@FindBy(xpath = "//input[@name='user_password']")
	protected WebElement userPasswordEd;

	@FindBy(xpath = "//input[@name='Login']")
	protected WebElement loginBt;

	@FindBy(xpath = "//select[@name='login_theme']")
	protected WebElement login_theme_Dd;

	@FindBy(xpath = "//input[@name='login_language']")
	protected WebElement login_language_Dd;

	private WebDriverUtil WebUtil;
	public LoginOR(WebDriverUtil WebUtil){
		this.WebUtil=WebUtil;
		PageFactory.initElements(WebUtil.getDriver(), this);
	}
}
