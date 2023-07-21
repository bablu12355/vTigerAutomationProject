package com.eva.vtiger.pages.or.marketing.campaign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrCreateCampaignLandingPage {

	@FindBy(xpath="//input[@name='campaignname']")
	protected WebElement campaignEd;
	
	@FindBy(xpath="//select[@name='campaigntype']")
	protected WebElement campaignTypeDD;
	
	@FindBy(id="sponsor")
	protected WebElement sponsorED;
	
	
	@FindBy(id="targetaudience")
	protected WebElement targetAudienceEd;
	
	@FindBy(xpath="//select[@name='campaignstatus']")
	protected WebElement campaignStatusDD;
	
	@FindBy(id="actualcost")
	protected WebElement actualCost;
	
	@FindBy(id="actualresponsecount")
	protected WebElement actualResponseCountED;
	
	@FindBy(xpath="//b[text()='Description Information']//parent::td//parent::tr//following-sibling::tr//following-sibling::tr//following-sibling::tr//div//input[@title='Save [Alt+S]']")
	protected WebElement saveBt;
	
	@FindBy(xpath="//b[text()='Description Information']//parent::td//parent::tr//following-sibling::tr//following-sibling::tr//following-sibling::tr//div//input[@title='Cancel [Alt+X]']")
	protected WebElement cancelBt;
	
	
	
	
}
