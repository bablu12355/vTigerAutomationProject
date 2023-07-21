package com.eva.vtiger.pages.functionality.myhomepage.home;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.functionality.inventory.invoice.InvoiceLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsLandingPage;
import com.eva.vtiger.pages.functionality.salesPage.leads.Sales_LeadsLandingPage;
import com.eva.vtiger.pages.functionality.support.contacts.Support_ContactsLandingPage;
import com.eva.vtiger.pages.or.myhomepage.OrHomePage;
import com.vitiger.eva.pages.functionality.marketing.campaign.CampaignLandingPage;

public class HomePage extends OrHomePage {
	private WebDriverUtil webUtil;

	public HomePage(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	public LeadsLandingPage goToMarketingLandingPage() {
		webUtil.actionsMouseOver(marketingMo, "Marketing Module");
		webUtil.usingWebElementclickMethod(leadsBT, "Leads");
		 return new LeadsLandingPage(webUtil);
	}
public  CampaignLandingPage gotoMarketingCampaignsLandingPage() {
	webUtil.actionsMouseOver(marketingMo, "Marketing Module");
	webUtil.usingWebElementclickMethod(campaignBt, "Campaigns");
	return new CampaignLandingPage(webUtil);
}
	public Sales_LeadsLandingPage goTosalesLandingPage() {
		webUtil.actionsMouseOver(salesMo, "Sales Link");
		webUtil.usingWebElementclickMethod(invoiceBT, "invoice");
		return new  Sales_LeadsLandingPage(webUtil);
	}

	public Support_ContactsLandingPage goToSupportLandingPage() {
		webUtil.actionsMouseOver(supportMo, "Support Link");
		webUtil.usingWebElementclickMethod(contactsBt, "Click Contacts");
	return 	new Support_ContactsLandingPage(webUtil);
		
	}
	public InvoiceLandingPage goToInventoryLandingPage() {
		webUtil.actionsMouseOver(inventoryBt, "Inventory Link");
		webUtil.usingWebElementclickMethod(invoiceBtClick, "Invoice Buton Click");
	return 	new InvoiceLandingPage(webUtil);
	}
	public void signOut() {
		webUtil.usingWebElementclickMethod(signOutBt, "Sign Out");
	}
}
