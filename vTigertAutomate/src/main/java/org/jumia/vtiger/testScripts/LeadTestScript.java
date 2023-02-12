package org.jumia.vtiger.testScripts;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.dockerjava.api.model.Driver;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadTestScript  {
	static WebDriver driver;

	public static void main(String[] args) {
		verifySearchLaeds();
	}

	public static void verifySearchLaeds() {
		WebDriverUtil gm = new WebDriverUtil();
		ExtentReports extReport = gm.extentReport();
        gm.testCaseId(extReport,"Verify Search Laeds");
		gm.hitUrl("chrome", "http://localhost:8888");
		WebElement webE=gm.getWebElementLocatorXpath("user_name","name" );
		gm.usingWebElementSendKeys(webE,"admin", "username");
	
		WebElement webE1=gm.getWebElementLocatorXpath("//input[@name='user_password']","xpath" );
		gm.usingWebElementSendKeys(webE1, "Bablu@123", "userpassword");
		
		gm.waitForElementVisibility(By.xpath("//input[@name='Login']"), 5 );
		
		WebElement we13 = gm.getWebElementLocatorXpath("//input[@name='Login']", "xpath");
		gm.usingWebElementclickMethod(we13, "Login Button");
		
		WebElement we5 = gm.getWebElementLocatorXpath("//td[@class='level2SelTab']//a[text()='Home']", "xpath");
//		gm.sizeOfAnyElement(we5, "Home");
		gm.validateSizeOfAnyElement(we5, "Home", 31, 12);
		
		WebElement we6 = gm.getWebElementLocatorXpath("//input[@value='Find']", "xpath");
//       gm.verifyElementOfColor(we6,"Find","color" );
		gm.ValidatElementOfColor(we6, "Find", "color", "#ffffff");
		
		WebElement we7 = gm.getWebElementLocatorXpath("//input[@value='Find']", "xpath");
		gm.VerifyBackgroundColorOfElement(we7, "Find", "background-color");
	
		WebElement we12=gm.getWebElementLocatorXpath("Marketing","linkText");
		gm.usingWebElementclickMethod(we12,"Marketing");
		gm.setImplicitlyWait(5);
	
		WebElement we = gm.getWebElementLocatorXpath("//div[@id='basicsearchcolumns_real']//select[@id='bas_searchfield']", "xpath");
		gm.SelectByVisibleText(we, "Campaign Name", "Campaign Name");
	
		WebElement we1 = gm.getWebElementLocatorXpath("search_field", "name");
		gm.GetdOptionSelect(we1);
	
		
		WebElement we2 = gm.getWebElementLocatorXpath("search_field", "name");
		gm.GetFirstSelectedOptionSelect(we2);
	
		WebElement we4 = gm.getWebElementLocatorXpath("124", "id");
		gm.validateCheckBoxUnSelected(we4, "CheckBoxUnselected");
	
		WebElement we3 = gm.getWebElementLocatorXpath("submit", "name");
		gm.actionsClickMethod(we3, "Submit");
		gm.setImplicitlyWait(5);
		
		gm.UsingSrcollUpDownMethod("//a[text()='Privacy Policy']", "xpath");
		
		WebElement we8 = gm.getWebElementLocatorXpath("//table[@class='small']//input[@value='Mass Edit']", "xpath");
//         gm.VerifyBackgroundColorOfElement(we8,"Mass Edit","background-color");
        gm.validateBackgroundColorOfElement(we8,"Mass Edit","background-color","#008000");
         	gm.goToPeviousPage();
    		gm.setImplicitlyWait(5);
       
		WebElement we9=gm.getWebElementLocatorXpath("//b[contains(text(),' Top Potentials')]","xpath");
		WebElement we10=gm.getWebElementLocatorXpath("//b[contains(text(),' Tag Cloud')]","xpath");

		gm.dragAndDropActionClass(we9, we10,"Top Protentials");
		
		WebElement web11= gm.getWebElementLocatorXpath("//a[text()='About Us']","xpath");
		gm.usingWebElementclickMethod(web11, "About Us");
		gm.getWindowHandles("vtiger CRM 5 - Free, Commercial grade Open Source CRM");

		WebElement we14=	gm.getWebElementLocatorXpath("close","name");
		gm.usingWebElementclickMethod(we14," About Us");
	extReport.flush();

	}

}
