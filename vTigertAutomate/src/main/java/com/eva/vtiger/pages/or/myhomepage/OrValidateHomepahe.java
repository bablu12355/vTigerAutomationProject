package com.eva.vtiger.pages.or.myhomepage;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrValidateHomepahe {

	@FindBy(xpath = "//a[text()='Linda']")
	protected WebElement lindaClick;

	private WebDriverUtil webUtil;

	public OrValidateHomepahe(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	}
}
