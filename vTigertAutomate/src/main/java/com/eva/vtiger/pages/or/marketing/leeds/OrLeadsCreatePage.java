package com.eva.vtiger.pages.or.marketing.leeds;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrLeadsCreatePage {


	@FindBy(xpath="//input[@name='firstname']")
	protected WebElement firstNameEd;
  
	@FindBy(xpath="//input[@name='lastname']")
	protected WebElement lastNameEd;
	
	@FindBy(xpath="//input[@name='company']")
	protected WebElement companyEd;
	
	@FindBy(xpath="//input[@name='designation']")
	protected WebElement titleED;
	
	@FindBy(id="mobile")
	protected WebElement mobileED;
	
	@FindBy(id="email")
	protected WebElement emailED;
	
	@FindBy(xpath="//textarea[@name='lane']")
	protected WebElement streetEd;
	
	@FindBy(id="country")
	protected WebElement CountryEd;
	
	@FindBy(id="state")
	protected WebElement StateEd;
	
	@FindBy(xpath="//b[contains(text(),'Description Information')]//parent::td//parent::tr//following-sibling::tr//following-sibling::td//following-sibling::div//input[@title='Save [Alt+S]']")
	protected WebElement saveLeadsBt;
	
	@FindBy(xpath="//b[contains(text(),'Description Information')]//parent::td//parent::tr//following-sibling::tr//following-sibling::td//following-sibling::div//input[@title='Cancel [Alt+X]']")
	protected WebElement cancelLeadsBt;
	
	private  WebDriverUtil webUtil;
	
	public OrLeadsCreatePage(WebDriverUtil webUtil) {
		this. webUtil= webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	 }
}
