package com.eva.vtiger.pages.or.myhomepage;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.functionality.reusablecodepage.ReusableCommanCodevtigerDependentBasePage;

public class OrValidateHomepahe extends ReusableCommanCodevtigerDependentBasePage {

	public OrValidateHomepahe(WebDriverUtil webUtil) {
		super(webUtil);
	}

	@FindBy(xpath = "//a[text()='Raman']")
	protected WebElement ramanClick;

	 
}
