package com.eva.vtiger.or.reusablecodepage;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrReusableCommanCodevtigerDependentBasePage {
	@FindBy(xpath = "//input[@name='search_text']")
	protected WebElement SearchforElement;
	
	@FindBy(xpath = "//b[text()='In']//parent::td//following-sibling::td//select[@id='bas_searchfield']")
	protected WebElement elementSelectedDD;
	
	@FindBy(xpath = "//input[@name='submit']")
	protected WebElement searchNowElement;
	
	@FindBy(xpath = "//input[@name='submit']//parent::td//following-sibling::td[text()='[x]']")
	protected WebElement closePointerBT;
	
	@FindBy(xpath = "//a[text()='Go to Advanced Search']")
	protected WebElement advanceSearchBT;
	
	@FindBy(xpath = "//b[contains(text(),'Match Any of the Following')]")
	protected WebElement clickMatchAllOfTheFollowing;
	
	@FindBy(xpath = "//b[contains(text(),'Match Any of the Following')]")
	protected WebElement clickAnyOfTheFollowing;
	
	private WebDriverUtil webUtil;
		public OrReusableCommanCodevtigerDependentBasePage( WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
		}
}
