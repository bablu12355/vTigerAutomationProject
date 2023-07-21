package com.eva.vtiger.pages.functionality.inventory.invoice;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.inventory.invoice.OrClickOnSelectContactName;

public class clickOnSelectContactName extends OrClickOnSelectContactName {

	private WebDriverUtil webUtil;

	public clickOnSelectContactName(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}
	 public  void SelectContactName() {
			webUtil.usingWebElementclickMethod(contactNameSelectBt, "Contact_name Select Button");
	}
	
}
