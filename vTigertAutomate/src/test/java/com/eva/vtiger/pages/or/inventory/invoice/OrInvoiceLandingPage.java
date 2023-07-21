package com.eva.vtiger.pages.or.inventory.invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrInvoiceLandingPage {

	@FindBy(xpath="//img[@title='Create Invoice...']")
	protected WebElement clickInvoiceCreateBt;
}
