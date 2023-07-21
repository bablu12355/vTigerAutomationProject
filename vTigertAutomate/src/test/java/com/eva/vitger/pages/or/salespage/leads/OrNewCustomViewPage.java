package com.eva.vitger.pages.or.salespage.leads;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrNewCustomViewPage {

	@FindBy(name="viewName")
	protected WebElement ViewnameEd;

@FindBy(xpath="//input[@name='setDefault']")
protected WebElement setDefaultClick;;

@FindBy(xpath="//input[@name='setStatus']")
protected WebElement setStatusClick;

@FindBy(id="column1")
protected WebElement customerNoDd;

@FindBy(id="column2")
protected WebElement invoiceDateDd;
	
@FindBy(id="column3")
protected WebElement invoiceNoDd;

@FindBy(id="column4")
protected WebElement purchasOrderDd;

@FindBy(id="column5")
protected WebElement dueDateDd;

@FindBy(id="column6")
protected WebElement totalNoDd;

@FindBy(id="column7")
protected WebElement exciseDutyDd;

@FindBy(id="column8")
protected WebElement invoiceSubjectDd;

@FindBy(id="column9")
protected WebElement billingPostalCodeDd;

@FindBy(xpath="//select[@name='stdDateFilterField']")
protected WebElement invoiceDueDateDd;

@FindBy(xpath="//option[text()='Tomorrow']//parent::select")
protected WebElement TomorrowDd;

@FindBy(xpath="//input[@id='jscal_field_date_start']")
protected WebElement startDateEd;

@FindBy(xpath="//input[@id='jscal_field_date_end']")
protected WebElement endDateEd;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
protected WebElement saveBt;

@FindBy(xpath="//input[@title='Cancel [Alt+X]")
protected WebElement cancelBt;


}
