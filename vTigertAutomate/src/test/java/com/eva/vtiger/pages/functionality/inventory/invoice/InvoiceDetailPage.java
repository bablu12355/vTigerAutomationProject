package com.eva.vtiger.pages.functionality.inventory.invoice;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.inventory.invoice.OrInvoiceDetailPage;

public class InvoiceDetailPage extends OrInvoiceDetailPage{

	private WebDriverUtil webUtil;

	public InvoiceDetailPage(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}
//	public  void validateSubject() {
//	webUtil.validateText(validateSubject, "Harbal Products", "Harbal Products");	
//	}
//	public void validateCustomerNo() {
//		webUtil.validateText(validateCustomerNo, "101", "101");
//	}
//	public void validateBillingAddress() {
//		webUtil.validateText(validateBillingAddress, "Washington", "Washington");
//	}
}
