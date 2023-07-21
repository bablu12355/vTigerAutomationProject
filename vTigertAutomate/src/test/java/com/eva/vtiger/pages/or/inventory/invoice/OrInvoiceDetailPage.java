package com.eva.vtiger.pages.or.inventory.invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrInvoiceDetailPage {

	@FindBy(xpath = "//a[text()='Yadav Raman']//parent::td[@id='mouseArea_Contact Name']")
	private WebElement ValidateYadavRaman;

	@FindBy(xpath = "//span[text()='Kirana Store']")
	private WebElement validateSubject;

	@FindBy(xpath = "//span[text()='330']")
	private WebElement validateCustomerNo;

	@FindBy(xpath = "//span[text()='Mahboobpur']")
	private WebElement validateBillingAddress;

	@FindBy(xpath = "//a[text()='Yadav Bablu']")
	private WebElement validateYadavBabluText;
	
	public WebElement getYadavbablu() {
		return validateYadavBabluText;
	}

	
	public WebElement getYadavRaman() {
		return ValidateYadavRaman;
	}

	public WebElement getCustomerNo() {
		return validateCustomerNo;

	}

	public WebElement getSubject() {
		return validateSubject;
	}

	public WebElement getBillingAddress() {
		return validateBillingAddress;
	}
}
