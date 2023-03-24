package com.eva.vtiger.pages.or.marketing.leeds;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.functionality.reusablecodepage.ReusableCommanCodevtigerDependentBasePage;

public class OrLeadsLandingPage extends ReusableCommanCodevtigerDependentBasePage{

	@FindBy(xpath = "//img[@title='Create Lead...']//parent::a")
	protected WebElement clickCreateBT;
	
	private  WebDriverUtil WebUtil;
	
	public  OrLeadsLandingPage(WebDriverUtil WebUtil){
	super(WebUtil);
		this.WebUtil= WebUtil;
	PageFactory.initElements(WebUtil.getDriver(), this);

	}
}
