package com.eva.vtiger.pages.or.inventory.invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrClickOnSelectContactName {

	
	@FindBy(xpath="//input[@name='contact_name']//following-sibling::img")
	protected WebElement contactNameSelectBt;
}
