package com.eva.vtiger.pages.or.marketing.leeds;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrMappingResultsLandingPage {

	@FindBy(xpath = "//input[@title='Finished']")
	protected WebElement clickFinishedBt;
	
	@FindBy(xpath = "//input[@title='Import More']")
	protected WebElement clickImportMoreBt;
	
	@FindBy(xpath = "//input[@title='Undo Last Import']")
	protected WebElement clickFUndoLastImportBt;
	
}
