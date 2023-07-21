package com.eva.vtiger.pages.or.marketing.campaign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrCampaignDetailLandingpage {

	
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement valiadteCampaignName;
	
	@FindBy(xpath="//span[@id='dtlview_Target Audience']")
	private WebElement TargetAudienceEd	;
	
	@FindBy(xpath="//div[@id=\"tblDescriptionInformation\"]//ancestor::tr//following-sibling::tr//td//input[@title=\"Edit [Alt+E]\"]")
	protected WebElement clickEditButton	;
	
	public  WebElement validateTargetAudience	() {
		return TargetAudienceEd;
	}
	public  WebElement getCampaignName() {
		return valiadteCampaignName;
	
	}
		
}
