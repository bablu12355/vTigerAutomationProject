package com.eva.vitger.pages.or.support.contacts;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrMassEdit_RecordsFieldLandingPage {

	@FindBy(xpath="//input[@name='firstname']")
	protected WebElement firstNameEd;

	@FindBy(xpath="//input[@name='lastname']")
	protected WebElement lastNameEd;
	
	@FindBy(xpath="//select[@name='salutationtype']")
	protected WebElement salutationDd;
	
	@FindBy(name="account_name")
	protected WebElement AccountNameEd;
	
	@FindBy(name="mobile")
	protected WebElement mobileEd;
	
	@FindBy(name="leadsource")
	protected WebElement leadsSourceDd;
	
	@FindBy(name="email")
	protected WebElement emailEd;
	
	@FindBy(name="assistant")
	protected WebElement assistantEd;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	protected WebElement saveClick;
	
	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	protected WebElement cancelClick;
	
	private WebDriverUtil util;

	public OrMassEdit_RecordsFieldLandingPage(WebDriverUtil util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}

}
