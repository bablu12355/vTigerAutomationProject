package com.eva.vtiger.pages.or.inventory.invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrCreateInvoiceLandingPage {

	@FindBy(name="subject")
	protected WebElement subjectED;
	
	@FindBy(id="customerno")
	protected WebElement customerEd;
	
	@FindBy(xpath="//input[@name='contact_name']//following-sibling::img")
	protected WebElement contactNameSelectBt;
	
	@FindBy(linkText = "Yadav Raman")
	protected WebElement clickYadavRamanBt;
	
	@FindBy(xpath = "//td[text()='vtigerCRM Inc']//preceding-sibling::td//parent::tr//a[text()='Yadav Bablu']")
	protected WebElement clickYadavBabluBt;
	
	@FindBy(xpath = "//td[text()='gooduivtiger']//preceding-sibling::td[text()='President']//preceding-sibling::td//a")
	protected WebElement clickYadavBt;
	
	@FindBy(xpath = "//td[text()='EDFG Group Limited']//preceding-sibling::td[text()='Director Sales']//preceding-sibling::td//a")
	protected WebElement clickOnbabluYadavLink;
	
	@FindBy(xpath = "//td[text()='vtigerCRM Inc']//preceding-sibling::td//a")
	protected WebElement clickOnBablu;
	

	@FindBy(xpath="//input[@name='account_id']//following-sibling::img")
	protected WebElement accountNameSelect;
	
	@FindBy(id="all_contacts")
	protected WebElement shpwAllContactBt;
	
	@FindBy(xpath="//td[text()='Sunnyvale']//preceding-sibling::td//a[text()='vtiger']")
	protected WebElement clickVtigerLink;;
	
	@FindBy(xpath="//a[text()='vtigeruser']")
	protected WebElement clickVtigerUserLink;
	
	@FindBy(xpath ="//a[text()='demovtiger']")
	protected WebElement clickDemoVtigerClick;
	
	@FindBy(xpath ="//a[text()='vtigerCRM Inc']")
	protected WebElement clickVtigerCrmBt;
	
	@FindBy(xpath ="//a[text()='usable-vtiger']")
	protected WebElement clickUsable_VtigerBt;
	
	@FindBy(id="exciseduty")
	protected WebElement exciseDutyED;
	
	@FindBy(id="single_accountid")
	protected WebElement accountNameEd;
	
	@FindBy(id="qty1")
	protected WebElement qtyBt;
	
	@FindBy(id="searchIcon1")
	protected WebElement seachIconClickBt;
	
	@FindBy(linkText ="Brother Ink Jet Cartridge")
	protected WebElement BrotherInkJetCartridgeLinkClick;
	
	
	
	@FindBy(name="bill_street")
	protected WebElement bill_streetED;
	
	@FindBy(id="bill_pobox")
	protected WebElement bill_poboxEd;
	
	@FindBy(id="bill_city")
	protected WebElement bill_cityEd;
	
	@FindBy(id="bill_state")
	protected WebElement bill_stateEd;
	
	@FindBy(id="bill_code")
	protected WebElement bill_codeEd;
	
	@FindBy(id="bill_country")
	protected WebElement bill_countryEd;
	
	@FindBy(xpath="//input[@name='salesorder_name']")
	protected WebElement saleOrder_nameEd;
	
	@FindBy(id="vtiger_purchaseorder")
	protected WebElement purchaseOrderEd;
	
	@FindBy(id="salescommission")
	protected WebElement salesCommissionEd;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	protected WebElement shipping_addressEd;
	
	@FindBy(id="ship_city")
	protected WebElement ship_cityEd;
	
	@FindBy(id="ship_state")
	protected WebElement ship_stateEd;
	
	@FindBy(id="ship_code")
	protected WebElement ship_codeEd;
	
	@FindBy(id="ship_country")
	protected WebElement ship_countryEd;
	
	@FindBy(xpath="//b[text()='Invoice Information']//parent::td//parent::tr//preceding-sibling::tr//following-sibling::td//div//input[@title='Save [Alt+S]']")
	protected WebElement saveBt;
	
	@FindBy(xpath="//b[text()='Invoice Information']//parent::td//parent::tr//preceding-sibling::tr//following-sibling::td//div//input[@title='Cancel [Alt+X]']")
	protected WebElement cancelBt;
}
