package com.eva.vtiger.pages.or.inventory.invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrClickOnSelectAccountName {

	@FindBy(xpath="//input[@name='account_id']//following-sibling::img")
	protected WebElement accountNameSelect;
	
}
