package org.jumia.vtiger.testScripts;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;

public class TextCase_VtigerAutomate {
	static WebDriverUtil webutil;

	@FindBy(name = "user_name")
	private WebElement userNameEd;

	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement userPasswordEd;;

	@FindBy(xpath = "//input[@name='Login']")
	private WebElement loginBt;
	
	@FindBy(linkText = "Marketing")
	private WebElement marketingMo;
	
	@FindBy(xpath = "//table[@class='level2Bg']//td//a[text()='Leads']")
	private WebElement leadsBt;;
	
	@FindBy(xpath = "//img[@title='Create Lead...']//parent::a")
	private WebElement plusBt;;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameEd;
  
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameEd;
	
	@FindBy(xpath="//input[@name='company']")
	private WebElement companyEd;
	
	@FindBy(xpath="//input[@name='designation']")
	private WebElement titleED;
	
	@FindBy(id="mobile")
	private WebElement mobileED;
	
	@FindBy(id="email")
	private WebElement emailED;
	
	@FindBy(xpath="//textarea[@name='lane']")
	private WebElement streetEd;
	
	@FindBy(id="country")
	private WebElement CountryEd;
	
	@FindBy(id="state")
	private WebElement StateEd;
	
	@FindBy(xpath="//b[contains(text(),'Description Information')]//parent::td//parent::tr//following-sibling::tr//following-sibling::td//following-sibling::div//input[@title='Save [Alt+S]']")
	private WebElement saveLeadsBt;
	
	public static void main(String[] args) {
		webutil=new WebDriverUtil();
		webutil.extentReport();
		webutil.testCaseId( "TC001");
		webutil.launchBrower("chrome");
		webutil.hitUrl("http://localhost:8888");
		TextCase_VtigerAutomate web=	PageFactory.initElements(webutil.getDriver(),TextCase_VtigerAutomate.class );
		
		web.verifySizeOfElement();
		
		webutil.testCaseId("TC002");
		web.verifyLocationOfElement();

		webutil.testCaseId( "TC003");
		web.verifyVCreateNewLeads();

		webutil.flushed();
	}

	public void verifySizeOfElement() {
		webutil.validateSizeOfAnyElement(userNameEd, "Username", 149, 22);
		webutil.validateSizeOfAnyElement(userPasswordEd, "Userpassword", 149, 22);
		webutil.validateSizeOfAnyElement(loginBt, "Login", 138, 40);
	}

	public void verifyLocationOfElement() {
		webutil.validateLocationOfElement(userNameEd, "Username", 640, 230);
		webutil.validateLocationOfElement(userPasswordEd, "Userpassword", 640, 262);
		webutil.validateLocationOfElement(loginBt ,"Login", 640, 350);

	}

	public void verifyVCreateNewLeads() {
		webutil.usingWebElementSendKeys(userNameEd, "admin", "username");
		webutil.usingWebElementSendKeys(userPasswordEd,"Bablu@123","userpassword");
		webutil.usingWebElementclickMethod(loginBt, "Login Button");
		webutil.usingWebElementclickMethod(marketingMo, "Marketing");
		webutil.usingWebElementclickMethod(leadsBt, "Leads");
		webutil.usingWebElementclickMethod(plusBt, "Plus Button");
		webutil.usingWebElementSendKeys(firstNameEd, "Bablu1234", "First Name");
		webutil.usingWebElementSendKeys(lastNameEd, "Yaduvanshi", "Last Name");
		webutil.usingWebElementSendKeys(companyEd, "Expert View Automation", "Company");
		webutil.usingWebElementSendKeys(titleED,"hii this is bablu yadav task to create leads", "Title");
		webutil.usingWebElementSendKeys(mobileED, "6368993420", "Mobile");
		webutil.usingWebElementSendKeys(emailED, "by862473@gmail.com", "Email");
		webutil.usingWebElementSendKeys(streetEd, "Mahboobpur..Kukrauthi..Bhadohi","Street");
		webutil.usingWebElementSendKeys(CountryEd, "India", "Country");
		webutil.usingWebElementSendKeys(StateEd, "Uttar Pradesh", "State");
		webutil.usingWebElementclickMethod(saveLeadsBt, "Click");

	}
}
