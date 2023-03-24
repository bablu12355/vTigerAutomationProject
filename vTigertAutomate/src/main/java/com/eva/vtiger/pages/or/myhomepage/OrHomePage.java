package com.eva.vtiger.pages.or.myhomepage;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrHomePage {


	@FindBy(xpath = "//a[text()='Marketing']")
	protected WebElement marketingMo;

	@FindBy(xpath = "//div[@id='Marketing_sub']//a[text()='Leads']")
	protected WebElement leadsBT;

	@FindBy(linkText = "Sales")
	protected WebElement salesMo;

	@FindBy(xpath = "//div[@id='Sales_sub']//a[text()='Invoice']")
	protected WebElement invoiceBT;

	@FindBy(xpath = "//a[text()='Support']")
	protected WebElement supportMo;

	@FindBy(xpath = "//div[@id='Support_sub']//a[text()='Contacts']")
	protected WebElement contactsBt;
	
	private WebDriverUtil webUtil;
	public OrHomePage(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	}
}
