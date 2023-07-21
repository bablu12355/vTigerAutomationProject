package com.eva.vtiger.pages.or.login;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOR {

	@FindBy(name = "user_name")
	private WebElement userNameEd;

	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement userPasswordEd;

	@FindBy(xpath = "//input[@name='Login']")
	protected WebElement loginBt;

	@FindBy(xpath = "//select[@name='login_theme']")
	private WebElement login_theme_Dd;

	@FindBy(xpath = "//input[@name='login_language']")
	private WebElement login_language_Dd;

	@FindBy(xpath = "//td[text()='User Name']")
	private WebElement userNameVt;

	@FindBy(xpath = "//font[@color='Brown']")
	private WebElement errorMessageST;

	public WebElement getErrorMessage() {
		return errorMessageST;
	}

	public WebElement getUserNameEd() {
		return userNameEd;
	}

	public WebElement getUserPasswordEd() {
		return userPasswordEd;
	}

	public WebElement getLoginBt() {
		return loginBt;
	}

	public WebElement getLogin_theme_Dd() {
		return login_theme_Dd;

	}
}
