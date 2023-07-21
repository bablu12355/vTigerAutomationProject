package com.eva.vtiger.pages.or.inventory.invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrContactLandingPage {
	@FindBy(xpath = "//td[text()='VP Sales']//parent::tr")
	protected WebElement clickYadavRamanBt;

}
