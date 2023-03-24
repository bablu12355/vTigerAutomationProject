package org.jumia.vtiger.genericCode;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.hc.client5.http.impl.classic.MainClientExec;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverUtil {
	private  WebDriver driver; 
	private  ExtentTest extt;
	public WebDriver getDriver() {
		if(driver==null) {
		
			extt.log(Status.FAIL, driver+"not initialized got null");	
	
		}
	    return driver;
	}
     public WebDriver setDriver(WebDriver driver) {
	   this.driver=driver;
     return driver;
}
	/**
	 * this method is used to we can invoke our application
	 * @param browserName this parameter used to launch browser which browser you want to give name
	 * @param url this parameter used to generate url whatever you want to give url
	 */
	public  void launchBrower(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chroptions=	new ChromeOptions();
			chroptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chroptions);
			extt.log(Status.INFO,   MarkupHelper.createLabel(browserName + "browser launched succesfully", ExtentColor.INDIGO));
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			extt.log(Status.INFO,MarkupHelper.createLabel(browserName + "browser launched succesfully", ExtentColor.INDIGO));
	
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			extt.log(Status.INFO,MarkupHelper.createLabel(browserName + "browser launched succesfully", ExtentColor.INDIGO));
			
		} else {
			extt.log(Status.FAIL, MarkupHelper.createLabel(browserName
					+ "browser not launched, browser name is not valid, please check browser name and try again !",
					ExtentColor.RED));
		}

	}
/**
 * @Description This method is used to hit the URL
 * @param Url this parameter is used to pass the URL 
 */
    public void hitUrl(String Url) {
       try {
    	   driver.get(Url);
			extt.log(Status.INFO, MarkupHelper.createLabel(Url + "navigate successfully", ExtentColor.ORANGE));
		} catch (Exception e) {
			extt.log(Status.INFO, MarkupHelper.createLabel(Url + "navigate unsuccessfully", ExtentColor.ORANGE));
			e.printStackTrace();
		}
    }
	/**
	 * this method is used to take the screenshot 
	 * @param fileName this is parameter used to give the filename where you want to save your screenShot
	 */
	public  void SnapShot(String fileName) {
		TakesScreenshot tscreen = (TakesScreenshot) driver;
		File files = tscreen.getScreenshotAs(OutputType.FILE);
		String tcs = getTimeStamp();
		File file = new File(fileName + tcs + "SnapShot.png");
		try {
			Files.copy(files, file);
			extt.log(Status.INFO,
					MarkupHelper.createLabel("Takes ScreenShot is performed succesfully ", ExtentColor.GREY));
		} catch (IOException e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel("Takes ScreenShot isn't performed succesfully ", ExtentColor.RED));
			e.printStackTrace();
		}
		extt.addScreenCaptureFromPath(file.getAbsolutePath());
	}

	/**this method is used to get the current time  formate mm-dd-yyyy-hh-mm-ss
	 * @return this method returns current generate date which is string type 
	 */
	public static String getTimeStamp() {
		DateFormat df = new SimpleDateFormat("mm-dd-yyyy-hh-mm-ss");
		return df.format(new Date());

	}

	/**
	 * @param extReport1 we used this parameter to call createTest 
	 * if we will use this method then it will take ExtentReports reference variable as parameter then we will have to pass 
	 * @param testCaseName this parameter  used to name of testCase id we have to pass as string type argument 
	
	 */
	public void testCaseId( String testCaseName) {
		extt = extReport.createTest(testCaseName);
		extt.log(Status.INFO, MarkupHelper.createLabel(testCaseName + "generate successfully", ExtentColor.PINK));
	}

	/**
	 * this method is used flush all our report we can use flush end of the programing report
	 * @param this parameter is used to call flush method with ExtentReports reference variable 
	 */
	public  void flushed() {
	extReport.flush();
}
private	ExtentReports extReport;
	/**
	 * here we used this method to generate our programing report to give the message 
	 * @return this method return extReport which is ExtentReports class type 
	 */
	public void extentReport() {
		DateFormat df = new SimpleDateFormat("mm-dd-yyyy-hh-mm-ss");
		String timeStam = df.format(new Date());
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("ExtentReport" + timeStam + ".html");
		 extReport = new ExtentReports();
		extReport.setSystemInfo("os name is --", System.getProperty("os.name"));
		extReport.setSystemInfo("Username is --", System.getProperty("user.name"));
		extReport.setSystemInfo("server name is --", System.getProperty("QA server"));
		extReport.attachReporter(htmlReport);
	
	}

	/**this method is used to generate date which is used in our report to identify different report 
	 * @return this method returns timestamp which is string type and returns curent generated date 
	 */
	public String SimpledateFormatGegerate() {
		DateFormat df = new SimpleDateFormat("mm-dd-yyyy-hh-mm-ss");
		String timeStam = df.format(new Date());
		return timeStam;

	}

	/** this method is used to search the element on UI by locators
	 * @param locatorValue this parameter is used to give the locator value  of any element on UI 
	 * @param locatorType this parameter is used to give the type of locator value of any element on UI
	 * @return this method returns driver which is WebDriver Type
	 */
	public WebElement getWebElementLocatorXpath(String locatorValue, String locatorType) {
		WebElement webt = null;
		System.out.println(locatorType);

		try {
			if (locatorType.equalsIgnoreCase("xpath")) {
				webt = driver.findElement(By.xpath(locatorValue));
			} else if (locatorType.equalsIgnoreCase("linkText")) {
				webt = driver.findElement(By.linkText(locatorValue));
			} else if (locatorType.equalsIgnoreCase("name")) {
				webt = driver.findElement(By.name(locatorValue));
			} else if (locatorType.equalsIgnoreCase("className")) {
				webt = driver.findElement(By.className(locatorValue));
			} else if (locatorType.equalsIgnoreCase("cssSelector")) {
				webt = driver.findElement(By.cssSelector(locatorValue));
			} else if (locatorType.equalsIgnoreCase("tagName")) {
				webt = driver.findElement(By.tagName(locatorValue));
			} else if (locatorType.equalsIgnoreCase("id")) {
				webt = driver.findElement(By.id(locatorValue));
			} else if (locatorType.equalsIgnoreCase("parcialLinkText")) {
				webt = driver.findElement(By.partialLinkText(locatorValue));
			} else {
				extt.log(Status.FAIL,
						MarkupHelper.createLabel(locatorType + "Locator type is wrong.plzz Check", ExtentColor.PURPLE));
			}
		} catch (Exception e) {
			SnapShot("xpathSnapShot");
			e.printStackTrace();
		}
		return webt;
	}

	/**
	 * @discription:this method is use to search the multiple elements on UI By locator
	 * @param locatorValue this parameter is used to give the locator value of any element on UI
	 * @param locatorType this parameter is used to give the type of locator of locator value of any element on UI
	 * @return this method returns List of webElement 
	 */
	public List<WebElement> getListOfWebElementLocatorXpath(String locatorValue, String locatorType) {
		List<WebElement> webt = null;

		try {
			if (locatorType.equalsIgnoreCase("xpath")) {
				webt = driver.findElements(By.xpath(locatorValue));
			} else if (locatorType.equalsIgnoreCase("linkText")) {
				webt = driver.findElements(By.linkText(locatorValue));
			} else if (locatorType.equalsIgnoreCase("name")) {
				webt = driver.findElements(By.name(locatorValue));
			} else if (locatorType.equalsIgnoreCase("className")) {
				webt = driver.findElements(By.className(locatorValue));
			} else if (locatorType.equalsIgnoreCase("cssSelector")) {
				webt = driver.findElements(By.cssSelector(locatorValue));
			} else if (locatorType.equalsIgnoreCase("tagName")) {
				webt = driver.findElements(By.tagName(locatorValue));
			} else if (locatorType.equalsIgnoreCase("id")) {
				webt = driver.findElements(By.id(locatorValue));
			} else if (locatorType.equalsIgnoreCase("parcialLinkText")) {
				webt = driver.findElements(By.partialLinkText(locatorValue));
			} else {
				extt.log(Status.FAIL,
						MarkupHelper.createLabel(locatorType + "Locator type is wrong.plzz Check", ExtentColor.PURPLE));
			}
		} catch (Exception e) {
			SnapShot("List<WebElement>xpathSnapShot");
			e.printStackTrace();
		}
		return webt;
	}

	
	/**
	 * @discription:this method is used to check element to verify whether element is actionable or not
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give the elementName Which we are working on element that time  
	 * @return this method returns boolean
	 */
	public boolean checkElement(WebElement we, String elementName) {
		boolean status = false;
		if (we.isDisplayed() == true) {
			extt.log(Status.INFO, MarkupHelper.createLabel(elementName + " text is visible", ExtentColor.BROWN));
			if (we.isEnabled() == true) {
				extt.log(Status.INFO, MarkupHelper.createLabel(elementName + " text is Enable", ExtentColor.BROWN));
				status = true;
			} else {
				extt.log(Status.INFO, MarkupHelper.createLabel(elementName + " text isn't Enable", ExtentColor.BROWN));
			}
		} else {
			extt.log(Status.INFO, MarkupHelper.createLabel(elementName + " text isn't visible", ExtentColor.BROWN));
		}
		return status;
	}
	/**
	 *@discription:this method is used to select the element option from dropdown by using selectByValueAttribute method of select class 
		 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give the elementName which we are working on element that time
	 * @param valueAttributeToSelect this parameter is used to give the attribute value of any attribute type
	 */
	public void selectByValueAttribute(WebElement we, String elementName, String valueAttributeToSelect) {
		try {
//			WebElement we = getWebElementLocatorXpath(locatorValue, locatorType);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				Select selectObj = new Select(we);
				selectObj.selectByValue(valueAttributeToSelect);
				extt.log(Status.INFO, MarkupHelper.createLabel(valueAttributeToSelect + "is performed successfully",
						ExtentColor.LIME));
			}
		} catch (StaleElementReferenceException e) {
			extt.log(Status.INFO, MarkupHelper.createLabel(valueAttributeToSelect + "isn't performed successfully",
					ExtentColor.LIME));
			SnapShot(elementName);
			e.printStackTrace();

		} catch (Exception e) {
			extt.log(Status.INFO, MarkupHelper.createLabel(valueAttributeToSelect + "isn't performed successfully",
					ExtentColor.LIME));
			SnapShot(elementName);
			e.printStackTrace();
		}
	}

	/**
	 * @discription:this method is used to select the element option from dropdown by using SelectByIndex method of select class  
     *@param locatorValue this parameter is used to search the element on UI by locatorValue which type are webElement
	 * @param locatorType this parameter is used to search the element on UI by locatorType which type are webElement	 
	 * @param elementName this parameter is used to we have to give elementName which we are working on element that time 
	 * @param indexValueToSelect this parameter is used to give the indexing which element we want to select element option from dropDown 
	 */
	public void SelectByIndex(WebElement we, String elementName, int indexValueToSelect) {
		try {
//			WebElement we = getWebElementLocatorXpath(locatorValue, locatorType);
			boolean checkVisibility = checkElement(we, elementName);
			if (checkVisibility == true) {
				Select select = new Select(we);
				select.selectByIndex(indexValueToSelect);
				extt.log(Status.INFO,
						MarkupHelper.createLabel(indexValueToSelect + "is performed successfully", ExtentColor.GREY));
			}

		} catch (NoSuchElementException e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(indexValueToSelect + "isn't performed successfully", ExtentColor.GREY));
			SnapShot("ScreenShotOfIndexValueSelect");
			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(indexValueToSelect + "isn't performed successfully", ExtentColor.GREY));
			SnapShot("ScreenShotOfIndexValueSelect");
			e.printStackTrace();
		}
	}
	/**@discription:this method is used to select the element from dropdown by using SelectByVisibleText method of select class
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give the elementName which we are working on element that time
	 * @param VisibleToSelect this parameter is used to give the innertext value of any element which is present on dropdown option  
	 */
	public void SelectByVisibleText(WebElement we, String elementName, String VisibleToSelect) {
		try {
//			WebElement we = getWebElementLocatorXpath(locatorValue, locatorType);
			boolean checkVisibility = checkElement(we, elementName);
			if (checkVisibility == true) {
				Select select = new Select(we); 
				select.selectByVisibleText(VisibleToSelect);
				extt.log(Status.INFO,
						MarkupHelper.createLabel(elementName + "is performed Successfully", ExtentColor.CYAN));

			}
		} catch (NoSuchElementException e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(elementName + "isn't performed Successfully", ExtentColor.CYAN));
			SnapShot("ScreenShotOfIndexValueSelect");
			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(elementName + "isn't performed Successfully", ExtentColor.CYAN));
			SnapShot("ScreenShotOfIndexValueSelect");
			e.printStackTrace();
		}
	}
	public void HandleDropdown(WebElement we, String type, String value) {
//		WebElement web = getWebElementLocatorXpath(locatorValue, locatorType);
		Select select = new Select(we);
		switch (type) {

		case "index":
			select.selectByIndex(Integer.parseInt(value));
			extt.log(Status.INFO, MarkupHelper.createLabel(value + "is performed successfully", ExtentColor.CYAN));
			break;
		case "value":
			select.selectByIndex(Integer.parseInt(value));
			extt.log(Status.INFO, MarkupHelper.createLabel(value + "is performed successfully", ExtentColor.CYAN));
			break;
		case "visisbleText":
			select.selectByIndex(Integer.parseInt(value));
			extt.log(Status.INFO, MarkupHelper.createLabel(value + "is performed successfully", ExtentColor.CYAN));
			break;
		default:
			extt.log(Status.INFO, MarkupHelper.createLabel(value + "please pass the correct selection criteria....",
					ExtentColor.PINK));
		}
	}

	/**
	  @discription: this method is used to get first option element which is select in dropdown 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	*/
	public void GetFirstSelectedOptionSelect(WebElement we) {
		try {
//			WebElement web = getWebElementLocatorXpath(locatorValue, locatorType);
			Select select = new Select(we);
			WebElement getFirstOptionDropdown = select.getFirstSelectedOption();
			String selectOption = getFirstOptionDropdown.getText();
			extt.log(Status.INFO,
					MarkupHelper.createLabel("getFirstOptionDropdown" + "---" + selectOption, ExtentColor.BROWN));
		} catch (NoSuchElementException e) {
			extt.log(Status.INFO, MarkupHelper.createLabel("getFirstOptionDropdown" + "---", ExtentColor.BROWN));
			SnapShot("ScreenShotOfSelectOptionSelect");
			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO, MarkupHelper.createLabel("getFirstOptionDropdown" + "---", ExtentColor.BROWN));
			SnapShot("ScreenShotOfSelectOptionSelect");
			e.printStackTrace();
		}
	}

	/**
	 * @discription:this method is used to get all options which is present in dropdown
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 *  */
	public void GetdOptionSelect(WebElement we) {

		try {
			ArrayList<String> str = new ArrayList<String>();
//			WebElement web = getWebElementLocatorXpath(locatorValue, locatorType);

			Select select = new Select(we);
			List<WebElement> getAllOptionDropdown = select.getOptions();
			for (int i = 0; i < getAllOptionDropdown.size(); i++) {
				String getTestAllOptions = getAllOptionDropdown.get(i).getText();
				str.add(getTestAllOptions);
			}
			extt.log(Status.INFO,
					MarkupHelper.createLabel("Dropdrown Selected all Elemnet ...." + str, ExtentColor.PINK));
		} catch (NoSuchElementException e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel("Dropdrown not Selected all Elemnet ....", ExtentColor.PINK));

			SnapShot("ScreenShotOfSelectOptionSelect");
			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel("Dropdrown not Selected all Elemnet ....", ExtentColor.PINK));
			SnapShot("ScreenShotOfSelectOptionSelect");
			e.printStackTrace();
		}
	}

	/**
	 * @discription:this method is used to fetch innertext value of given element which element have innertext
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time 
	 * @return this method return String type
	 */
	public String getInnerTextValueWebElement(WebElement we, String elementName) {
		String innerText ="";
		try {
//			WebElement we = getWebElementLocatorXpath(locatorValue, locatorType);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				innerText = we.getText();
				extt.log(Status.INFO, MarkupHelper.createLabel(elementName + "is performed Successfully", ExtentColor.CYAN));
			}
		} catch (StaleElementReferenceException e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName + "isn't performed Successfully", ExtentColor.CYAN));
			SnapShot(elementName);
			e.printStackTrace();

		} catch (Exception e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName + "isn't performed Successfully", ExtentColor.CYAN));
			SnapShot(elementName);
			e.printStackTrace();
		}
		return innerText;
	}

	/**
	 * @discriptioin:this method is used to fetch any attribute value of any element
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time 
	 * @param getAttributeValue this parameter is used to give attribute value of any element as a string type
	 * @return this method return String 
	 */
	public String GetAttrinuteMethodWebElement(WebElement we, String elementName, String getAttributeValue) {
		String takeGetAttributeValue = null;
		try {
//			WebElement we = getWebElementLocatorXpath(locatorValue, locatorType);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				takeGetAttributeValue = we.getAttribute(getAttributeValue);
				System.out.println(takeGetAttributeValue);
				extt.log(Status.INFO,
						MarkupHelper.createLabel(elementName + "is performed Successfully", ExtentColor.CYAN));
			}
		} catch (StaleElementReferenceException e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(elementName + "isn't performed Successfully", ExtentColor.CYAN));
			SnapShot(elementName);
			e.printStackTrace();

		} catch (Exception e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(elementName + "isn't performed Successfully", ExtentColor.GREY));

			SnapShot(elementName);
			e.printStackTrace();
		}
		return takeGetAttributeValue;
	}

	/**
	 * @discription: this method is used to mouseOver on any element
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time 
	 */
	public void actionsMouseOver(WebElement we, String elementName) {
		try {
//			WebElement web = getWebElementLocatorXpath(locatorValue, locatorType);
			boolean checkElement = checkElement(we, elementName);
			if (checkElement == true) {
				Actions action = new Actions(driver);
				action.moveToElement(we).build().perform();
				extt.log(Status.INFO,MarkupHelper.createLabel(elementName + "is performed successfully", ExtentColor.ORANGE));

			}
		} catch (StaleElementReferenceException e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(elementName + "isn't performed successfully", ExtentColor.ORANGE));
			SnapShot(elementName);
			e.printStackTrace();

		} catch (Exception e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(elementName + "isn't performed successfully", ExtentColor.ORANGE));
			SnapShot(elementName);
			e.printStackTrace();
		}
	}

	/**
	 * @discription:this method is used to drag the element one place to drop another place
	 * @param we1 this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param we2 this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time 
	 */
	public void dragAndDropActionClass(WebElement we1, WebElement we2, String elementName) {
		try {
//		WebElement we=getWebElementLocatorXpath(locatorValue1, locatorType1);
//		WebElement we1=getWebElementLocatorXpath(locatorValue1, locatorType1);
		boolean checkElement = checkElement(we1, elementName);
		if (checkElement == true) {
			Actions action = new Actions(driver);
			action.dragAndDrop(we1, we2).build().perform();
		extt.log(Status.INFO,MarkupHelper.createLabel(elementName+ "DragAndDrop Action Performed Successfully", ExtentColor.BLUE));
		}
	}catch(NoSuchElementException e) {
		extt.log(Status.INFO,MarkupHelper.createLabel(elementName+ "DragAndDrop Action Performed UnSuccessfully", ExtentColor.BLUE));
		SnapShot(elementName);
	    e.printStackTrace();
	    
	}catch(Exception e) {
		extt.log(Status.INFO,MarkupHelper.createLabel(elementName+ "DragAndDrop Action Performed UnSuccessfully", ExtentColor.BLUE));
		SnapShot(elementName);
	    e.printStackTrace();
	    
	}
	}
	/**
	 * @discription:this method is used to right click on element 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time 
	 */
	public  void actionsClassRightClick(WebElement we,String elementName) {
		try{
//			WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
			boolean checkElement=checkElement(we, elementName);
	   if(checkElement==true) {
		   Actions action=  new Actions(driver);
	  action.contextClick(we).build().perform();
		extt.log(Status.INFO,MarkupHelper.createLabel(elementName+ "Right Click Action Performed Successfully", ExtentColor.BLUE));

	   }
		}catch(NoSuchElementException e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName+ "Right click action performed successfully ", ExtentColor.BLUE));
			SnapShot("ScreenShot From DragAndDrop");
		    e.printStackTrace();	
		}
		catch(Exception e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName+ "Right click action performed Unsuccessfully ", ExtentColor.BLUE));
			SnapShot("ScreenShot From DragAndDrop");
		    e.printStackTrace();	
		}
	}
	public  void actionsClassDoubleClick(WebElement we,String elementName) {
		try{
//			WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
			boolean checkElement=checkElement(we, elementName);
	   if(checkElement==true) {
		   Actions action=  new Actions(driver);
	  action.doubleClick(we).build().perform();
		extt.log(Status.INFO,MarkupHelper.createLabel(elementName+ "double click action   performed successfully ", ExtentColor.BLUE));

	   }
		}catch(NoSuchElementException e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName+ "double click action performed Unsuccessfully ", ExtentColor.BLUE));
			SnapShot("ScreenShot From DragAndDrop");
		    e.printStackTrace();	
		}
		catch(Exception e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName+ "double click action performed Unsuccessfully ", ExtentColor.BLUE));
			SnapShot("ScreenShot From DragAndDrop");
		    e.printStackTrace();	
		}	
	}
	/**
	 * @discription:this method is used to click on element by using actionsClickMethod
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this  parameter is used to we have to give elementName Which are we working on Element that time 
	 */
	public void actionsClickMethod(WebElement we, String elementName) {
		try {
//			WebElement web = getWebElementLocatorXpath(locatorValue, locatorType);
			boolean checkElement = checkElement(we, elementName);
			if (checkElement == true) {
				Actions action = new Actions(driver);
				action.click(we).build().perform();
				extt.log(Status.INFO,
						MarkupHelper.createLabel(elementName + " click performed successfully ", ExtentColor.ORANGE));
			}
		} catch (NoSuchElementException e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(elementName + " click performed unsuccessfully ", ExtentColor.RED));
			SnapShot(elementName);
			e.printStackTrace();

		} catch (Exception e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(elementName + " click performed unsuccessfully ", ExtentColor.RED));
			SnapShot(elementName);
			e.printStackTrace();
		}
	}

	/**
	 * @discription:this method is used to send the value in input box by using actionsSendkeysMethod
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param inputValue this parameter is used to give the value to input box
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time 
	 */
	public void actionsSendkeysMethod(WebElement we, String inputValue, String elementName)  {
		try {
//			WebElement weFind = getWebElementLocatorXpath(locatorValue, locatorType);
			boolean checkElement = checkElement(we, elementName);
			if (checkElement == true) {
				Actions action = new Actions(driver);
				we.clear();
				action.sendKeys(we, inputValue);
				extt.log(Status.INFO,
						MarkupHelper.createLabel(elementName + " click performed successfully on ", ExtentColor.GREEN));
			}

		} catch (StaleElementReferenceException e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(elementName + " click performed unsuccessfully on ", ExtentColor.GREEN));
			SnapShot(elementName);
			e.printStackTrace();

		} catch (Exception e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(elementName + " click performed unsuccessfully on ", ExtentColor.GREEN));
			SnapShot(elementName);
			e.printStackTrace();
		}
	}
	/**
	 * @discription:this metgod is used to send the value in input box by using WebElementSendKeysMethod 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param inputValue this parameter is used to give the value to input box
	 * @param elementName  this parameter is used to we have to give elementName Which are we working on Element that time 
	 */
	public void usingWebElementSendKeys(WebElement we, String inputValue, String elementName) {
		try {
//			WebElement weFind = getWebElementLocatorXpath(locatorValue, locatorType);
			boolean bl = checkElement(we, elementName);
			if (bl == true) {
//				weFind.clear();
				we.sendKeys(inputValue);
				extt.log(Status.INFO, MarkupHelper.createLabel(inputValue + " input in input box ", ExtentColor.BLUE));
			}
		} catch (StaleElementReferenceException e) {
			extt.log(Status.INFO, MarkupHelper.createLabel(inputValue + " not input in input box ", ExtentColor.BLUE));
			SnapShot(elementName);
			e.printStackTrace();

		} catch (Exception e) {
			extt.log(Status.INFO, MarkupHelper.createLabel(inputValue + " not input in input box ", ExtentColor.BLUE));
			SnapShot(elementName);
			e.printStackTrace();
		}
	}

	/**
	 * @discription this method is used to click on element by using WebElementclickMethod( 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time 
	 */
	public void usingWebElementclickMethod(WebElement we, String elementName) {

		try {
//		.	WebElement we = getWebElementLocatorXpath(locatorValue, locatorType);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				we.click();
				extt.log(Status.INFO,MarkupHelper.createLabel(elementName + " click performed successfully on ", ExtentColor.GREEN));
			}
		} catch (StaleElementReferenceException e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName + " click performed unsuccessfully on ", ExtentColor.GREEN));
			SnapShot(elementName);
			e.printStackTrace();

		} catch (Exception e) {
			extt.log(Status.INFO,
					MarkupHelper.createLabel(elementName + "  performed unsuccessfully on ", ExtentColor.GREEN));
			SnapShot(elementName);
			e.printStackTrace();
		}
	}

	/**
	 * @discription:this method is used to get the title of currnet webPage by using driver.getTitle();
	 * @param title this parameter is used to give the title of any webPage 
	 */
	public void validateGetTitleOFpage(String title) {
		if (driver.getTitle().contains(title)) {
			extt.log(Status.PASS,
					MarkupHelper.createLabel(title + " verify succesfully title of the page ", ExtentColor.BROWN));
		} else {
			extt.log(Status.PASS,
					MarkupHelper.createLabel(title + " verify unsuccesfully title of the page ", ExtentColor.BROWN));
		}
	}
	/**
	 * @discription:this method is used to get the URL of currnet webPage by using driver.getCurrentUrl();
	 * @param title this parameter is used to give the URL of any webPage 
	 */
	public void getUrlOfPage(String getCurrentUrl) {
		if (driver.getCurrentUrl().contains(getCurrentUrl)) {
			extt.log(Status.PASS, getCurrentUrl + " verify succesfully url of the page ");
		} else {
			extt.log(Status.FAIL, getCurrentUrl + " verify unsuccesfully url of the page ");
		}
	}
       	/**
     * @dicription: this method is used to handle the  frame by indexing using this methoddriver.switchTo().frame(frameIndex);
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param frameIndex this parameter is used to give the indexing number by which we can handle frame
	 */
	public void FrameIndexValue( int frameIndex) {
		try {
			driver.switchTo().frame(frameIndex);
		} catch (NoSuchElementException e) {
			e.printStackTrace();

		} catch (Exception e) {
			SnapShot("handleFrameIndexValue");
			e.printStackTrace();
		}

	}

	/**
	 *@dicription: this method is used to swich to parent frame by using this method driver.switchTo().parentFrame();
	 */
	public void handleParentFrame() {
		driver.switchTo().parentFrame();
	}

	/**
	 * @discription: this method is used to handle the frame NameOrId attribute 
	 * using this method driver.switchTo().frame(frameNameOrIdAtrribute);
	 * @param frameNameOrIdAtrribute this parameter is used to give name or id attribute value as a String format
	 */
	public void handleFrameNameOrIdAtrribute( String frameNameOrIdAtrribute) {
		try {
			driver.switchTo().frame(frameNameOrIdAtrribute);
		} catch (NoSuchElementException e) {
			e.printStackTrace();

		} catch (Exception e) {
			SnapShot("handleFrameIndexValue");
			e.printStackTrace();
		}
	}

	/**
	 * @discriptin: this method is used to handle the frame by WebElement Method 
	 * @param we this parameter is used to search the element on UI by locatorType and locatorValue which type are WebElement 
	 * @param frameWebElementMethod this method is used to give the reference variable of WebElement as a string type
	 */
	public void handleFrameWebElementMethod(String frameWebElementMethod) {
		try {
			driver.switchTo().frame(frameWebElementMethod);
		} catch (NoSuchElementException e) {
			e.printStackTrace();

		} catch (Exception e) {
			SnapShot("handleFrameWebElementMethod");
			e.printStackTrace();
		}
	}

	 /**
	 * @discription:this method is used to switch from the Iframe to main page 
	 */
	public  void defaultContent() {
		driver.switchTo().defaultContent();
	}
	
	 public void handleFrame(String type, String Value) {
		try {
			switch (type) {
			case "frameIndex":
				driver.switchTo().frame(Integer.parseInt(Value));
				break;

			case "frameNameOrId":
				driver.switchTo().frame(Value);
				break;

			case "frameIWebElement":
				driver.switchTo().frame(Value);
				break;

			default:
				System.out.println("Please select right criteria.....");
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();

		} catch (Exception e) {
			SnapShot("ravi");
			e.printStackTrace();
		}
	}

	/**
	 * @discription this method is used to dismiss the popup
	 */
	public void HandleAlertDismiss() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (UnhandledAlertException e) {
			e.printStackTrace();

		} catch (Exception e) {
			SnapShot("HandleAlertDismiss");
			e.printStackTrace();
		}
	}

	/**
	 * @discription:this method is used to handle the popup
	 */
	public void HandleAlertAccept() {
		try {
			driver.switchTo().alert().accept();
		} catch (UnhandledAlertException e) {
			e.printStackTrace();

		} catch (Exception e) {
			SnapShot("HandleAlertAccept");
			e.printStackTrace();
		}
	}

	/**
	 * @discription: this method is used to if you want to verity message in popup 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 */
	public void HandleAlertGetText() {
		try {
			driver.switchTo().alert().getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();

		} catch (Exception e) {
			SnapShot("HandleAlertText");
			e.printStackTrace();
		}
	}

	/**
	 * @discription: this method is used to send any value in popup 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param inputvalue this parameter is used to send any value in popup as a string type
	 */
	public void HandleAlertSendKeys(WebElement we, String inputvalue) {
		try {
//			WebElement we=getWebElementLocatorXpath( locatorValue,  locatorType);
			driver.switchTo().alert().sendKeys(inputvalue);

		} catch (NoSuchElementException e) {
			e.printStackTrace();

		} catch (Exception e) {
			SnapShot("HandleAlertSendKeys");
			e.printStackTrace();
		}
	}

	/**
	 * @discription: this method is used to  it will wait till the element is clickable or not
	 * only for that element which element you want 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param atimeOutInSecond this parameter is used to give the time session 
	 */
	public void waitForElementEnabled(WebElement we, int atimeOutInSecond) {
		try {
//			WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
			WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(atimeOutInSecond));
			exWait.until(ExpectedConditions.elementToBeClickable(we));
			extt.log(Status.INFO, "elementToBeClickable performed successfully");
		} catch (NoSuchElementException e) {
			extt.log(Status.INFO, "element not To Be Clickable performed unsuccessfully");
            SnapShot("waitForElementEnabled");
			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO, "element not To Be Clickable performed unsuccessfully");
            SnapShot("waitForElementEnabled");
			e.printStackTrace();
		}
	}

	/**
	 * @discription: this parameter is used to it will wait till the element visible or not 
	 * only for that element which element you want 
	 * @param locator 
	 * @param timeOutInSecond this parameter is used to give the time session 
	 */
	public void waitForElementVisibility(By locator, int timeOutInSecond) {
		try {
			WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecond));
			exWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			extt.log(Status.INFO,MarkupHelper.createLabel("visibilityOfElementLocated performed successfully", ExtentColor.PINK));

		} catch (NoSuchElementException e) {
			extt.log(Status.INFO, "visibility Of Element not to be Locate performed unsuccessfully");
            SnapShot("waitForElementVisibility");

			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO, "visibility Of Element not to be Locate performed unsuccessfully");
            SnapShot("waitForElementVisibility");
			e.printStackTrace();
		}
	}

	/**
	 * @discription:this parameter is used to it will wait till the element arrives or not 
	 * only fot that element which element you want
	 * @param locator
	 * @param timeOutInSecond this parameter is used to give the time session
	 */
	public void waitPresenceOfElementLocated(By locator, int timeOutInSecond) {
		try {
			WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecond));
			exWait.until(ExpectedConditions.presenceOfElementLocated(locator));
			extt.log(Status.INFO, "presenceOfElementLocated performed successfully");

		} catch (NoSuchElementException e) {
			extt.log(Status.INFO, "presence Of Element not to be Locate performed unsuccessfully");
            SnapShot("waitPresenceOfElementLocated");

			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO, "presence Of Element not to be Locate performed unsuccessfully");
            SnapShot("waitPresenceOfElementLocated");
			e.printStackTrace();
		}
	}

	/**
	 * @discription: this method is used to it will wait till the element invisible or not 
	 * only for that element which element you want            
	 * @param locator
	 * @param atimeOutInSecond this parameter is used to give the time session
	 */
	public void waitForInvisibilityOfElementLocated(By locator, int atimeOutInSecond) {
		try {
			WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(atimeOutInSecond));
			exWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			extt.log(Status.INFO, "invisibilityOfElementLocated performed successfully");

		} catch (NoSuchElementException e) {
			extt.log(Status.INFO, "invisibility Of Element not to be Locate performed unsuccessfully");
            SnapShot("waitForInvisibilityOfElementLocated");
			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO, "invisibility Of Element not to be Locate performed unsuccessfully");
            SnapShot("waitForInvisibilityOfElementLocated");
			e.printStackTrace();
		}
	}

	/**
	 * @discription: this method is used to click on element using javaScriptClick 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 */
	public void usingJavaScriptClick(String locatorValue, String locatorType) {
		WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("argumets[0].click();",we);
	}

	/**
	 * @discription: this method is used to send any value in input box using JavaScriptSendKeys
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param inputValue this parameter is used to give value 
	 */
	public void usingJavaScriptSendKeys(WebElement we, String inputValue) {
//		WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("argumets[0].value='" + inputValue + "'",we);
	}

	/** 
	 * @discription: this method is used to  scroll up and down which element you want to  scroll
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 */
	public void UsingSrcollUpDownMethod(String locatorValue, String locatorType) {
		WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();",we);

	}

	/**
	 * @discription:it is used once because it is associated with the driver as long as the driver has used it  
	 * @param timeOutInSecond this parameter is used to give the time session
	 */
	public void setImplicitlyWait(int timeOutInSecond) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutInSecond));
	}

	/**
	 * @discription: this method is used to verify the actualText and  expected text to given element 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param expectedText this parameter is used to verify the given element to actual element match or not 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time  
	 */
	public void validateText(WebElement we, String expectedText, String elementName) {
		String actualText =getInnerTextValueWebElement(we, elementName);
		if (actualText.equalsIgnoreCase(expectedText)) {
			extt.log(Status.PASS, elementName + "Text validate Pass. actualText -" + actualText + " && expectedtext -"+ expectedText);
		} else {
			extt.log(Status.FAIL, elementName + "Text validate Failed. actualText -" + actualText + " && expectedtext -"+ expectedText);

		}
	}

	/**
	 * @discription:this method is used to verify the actualText and ExpectedText to given attribute value
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time 
	 * @param attributeValue this parameter is used to verify the given any attribute value  to match actual value
	 * @param expectedAttributrValue
	 */
	public void validateAttributeValue(WebElement we, String elementName, String attributeValue,
			String expectedAttributrValue) {
		String actualAttributeValue = GetAttrinuteMethodWebElement(we, elementName, attributeValue);
		if (actualAttributeValue.equals(expectedAttributrValue)) {
			extt.log(Status.PASS, elementName + "Attribute validate Pass. actualAttributeValue -" + actualAttributeValue+ " && expectedAttributrValue -" + expectedAttributrValue);
		} else {
			extt.log(Status.FAIL, elementName + " Attribute validate Failed. actualAttributeValue -"+ actualAttributeValue + " && expectedAttributrValue -" + expectedAttributrValue);

		}

	}

	/**
	 * @discription: this parameter is used to verify the element is enabled or not 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time 
	 */
	public void validateElementEnabled(WebElement we, String elementName) {
//		WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
		boolean flag = we.isEnabled();
		if (flag == true) {
			extt.log(Status.PASS, elementName + " is enabled");
		} else {
			extt.log(Status.FAIL, elementName + " is enabled");

		}

	}

	/**
	 * @discription: this method is used to verify element disabled or not  
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time 
	 */
	public void validateElementDisabled(WebElement we, String elementName) {
//		WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
		boolean flag = we.isEnabled();
		if (flag == false) {
			extt.log(Status.PASS, elementName + " is Disabled");
		} else {
			extt.log(Status.FAIL, elementName + " is enabled");

		}
	}

	/**
	 * @discription: this method is used to element visible or not on UI
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time 
	 */
	public void validateElementVisible(WebElement we, String elementName) {
//		WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
		boolean flag = we.isDisplayed();
		if (flag == true) {
			extt.log(Status.PASS, elementName + " is visible");
		} else {
			extt.log(Status.FAIL, elementName + " is inVisible");

		}
	}

	/**
	 * @discription: this method used to element invisible or not on UI
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on Element that time
	 */
	public void validateElementInVisible(WebElement we, String elementName) {
//		WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
		boolean flag = we.isDisplayed();
		if (flag == false) {
			extt.log(Status.PASS, elementName + " is Invisible");
		} else {
			extt.log(Status.FAIL, elementName + " is visible");

		}
	}

	/**
	 * @discription: this method is used to check and verify weather check box is selected or not  
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param checkBox this parameter is used to we have to give checkBoxName Which are we working 
	 */
	public void validateCheckBoxSelected(WebElement we, String checkBox) {
//		WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
		boolean flag = we.isSelected();
		if (flag == true) {
			extt.log(Status.PASS, MarkupHelper.createLabel(checkBox + " is Selected", ExtentColor.INDIGO));
		} else {
			extt.log(Status.PASS, MarkupHelper.createLabel(checkBox + " is UnSelected", ExtentColor.INDIGO));

		}
	}
	/**
	 * @discription: this method is used to check and verify weather check box is Unselected or not  
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param checkBox this parameter is used to we have to give checkBoxName Which are we working 
	 */
	public void validateCheckBoxUnSelected(WebElement we, String checkBox) {
//		WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
		boolean flag = we.isSelected();
		if (flag == false) {
			extt.log(Status.PASS, MarkupHelper.createLabel(checkBox + " is UnSelected", ExtentColor.INDIGO));
		} else {
			extt.log(Status.PASS, MarkupHelper.createLabel(checkBox + " is Selected", ExtentColor.INDIGO));

		}
	}

	/**
	 * @discription: this method is used to goto previous page
	 */
	public void goToPeviousPage() {
		driver.navigate().back();
	}

	/**
	 *@discription this method is used to goto next page
	 */
	public void goToNextPage() {
		driver.navigate().forward();
	}

	/**
	 * @discription: this method is used to check the size of element 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give ElementName Which are we working on that time
	 * @return this method return Dimention class Object
	 */
	public Dimension sizeOfAnyElement(WebElement we, String elementName) {
		Dimension sizeOfElement = null;
		try {
//			WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
			boolean chechElement = checkElement(we, elementName);
			if (chechElement == true) {
				sizeOfElement = we.getSize();
				int height = sizeOfElement.getHeight();
				int width = sizeOfElement.getWidth();
				System.out.println("width.." + width + "height.." + height);
				extt.log(Status.INFO, MarkupHelper.createLabel(elementName + " width ..." + width + " height..." + height, ExtentColor.BROWN));
			} else {
				extt.log(Status.INFO,MarkupHelper.createLabel(elementName + "Element text size wrong", ExtentColor.BROWN));

			}
		} catch (NoSuchElementException e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName + "Element text size not found", ExtentColor.BROWN));
			SnapShot(elementName);
			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName + "Element text size not found", ExtentColor.BROWN));
			SnapShot(elementName);
			e.printStackTrace();
		}
		return sizeOfElement;
	}

	/**

	 * @discription:this method is used to validate the size of element 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementname Which are we working on that time
	 * @param width this parameter is used to give the width of the element 
	 * @param height this parameter is used to give the height of the element
	 */
	public void validateSizeOfAnyElement(WebElement we, String elementName, int width, int height) {
		try {
			Dimension expectedSize = new Dimension(width, height);
			Dimension actualSize = sizeOfAnyElement(we, elementName);
			if (actualSize.equals(expectedSize)) {
				extt.log(Status.PASS,MarkupHelper.createLabel(elementName + " Size of element Validate Pass. ActualSize-- "+ actualSize + " && " + " ExpectedSize " + expectedSize, ExtentColor.GREY));
			} else {
				extt.log(Status.FAIL,MarkupHelper.createLabel(elementName + " Size of element Validate failed. ActualSize-- "+ actualSize + " && " + " ExpectedSize " + expectedSize, ExtentColor.GREY));
			}
		} catch (NoSuchElementException e) {
			extt.log(Status.FAIL,MarkupHelper.createLabel(elementName + " Size of element Validate failed..", ExtentColor.GREY));
			SnapShot(elementName);
			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.FAIL,MarkupHelper.createLabel(elementName + " Size of element Validate failed..", ExtentColor.GREY));
			SnapShot(elementName);
			e.printStackTrace();
		}
	}

	/**
	 * @discription:this method is used to verify location of the element  
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on that time
	 * @return this method returns point Class Object
	 */
	public Point VerifylocationOfElement(WebElement we, String elementName) {
		Point elementLocation = null;
		try {
//			WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
			boolean chekElement = checkElement(we, elementName);
			if (chekElement == true) {
				elementLocation = we.getLocation();
				System.out.println("elementLocation" + elementLocation);
				int xLocation = elementLocation.getX();
				int yLocation = elementLocation.getY();
				extt.log(Status.INFO, MarkupHelper.createLabel(elementName + " xLocation ..." + xLocation + " yLocation..." + yLocation, ExtentColor.BROWN));
			} else {
				extt.log(Status.INFO,MarkupHelper.createLabel(elementName + " text location wrong", ExtentColor.BROWN));
			}
		} catch (NoSuchElementException e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName + " text location not found", ExtentColor.BROWN));
			SnapShot(elementName);
			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName + " text location not found", ExtentColor.BROWN));
			SnapShot(elementName);
			e.printStackTrace();
		}
		return elementLocation;
	}

	/**
	 * @discription: this method is used to validate location of the element 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on that time
	 * @param x this parameter is used to give x location of the element 
	 * @param y this parameter is used to give y location of the element 
	 */
	public void validateLocationOfElement(WebElement we, String elementName, int x, int y) {
		Point expectedLocation = new Point(x, y);
		Point actualLocation = VerifylocationOfElement(we, elementName);
		System.out.println("actualLocation.." + actualLocation);
		System.out.println("expectedLocation.." + expectedLocation);
		if (actualLocation.equals(expectedLocation)) {
			extt.log(Status.PASS,MarkupHelper.createLabel(elementName + " Location of element Validate Pass. actualLocation-- "+ actualLocation + " && " + " expectedLocation " + expectedLocation, ExtentColor.GREY));
		} else {
			extt.log(Status.FAIL,MarkupHelper.createLabel(elementName + " Location of element Validate Failed. actualLocation-- "+ actualLocation + " && " + " expectedLocation " + expectedLocation, ExtentColor.GREY));

		}
	}
	/**
	 * @discription:this method is used to verify the color of the element 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on that time
	 * @param ColorName this patameter is used to give color as a String type
	 * @return this method returns String 
	 */
	public String verifyElementOfColor(WebElement we, String elementName, String ColorName) {
		String actualColorOfElement = null; ;
		try {
//			WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
			boolean check = checkElement(we, elementName);
			if (check == true) {
				String colorOf = we.getCssValue(ColorName);
				actualColorOfElement = Color.fromString(colorOf).asHex();
				System.out.println("jjj"+actualColorOfElement);
				extt.log(Status.INFO, MarkupHelper.createLabel(elementName + " color of element is " + actualColorOfElement, ExtentColor.GREEN));
			}
		} catch (NoSuchElementException e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName + " color of element isn't found ", ExtentColor.GREEN));

			SnapShot(elementName);
			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName + " color of element isn't found ", ExtentColor.GREEN));
			SnapShot(elementName);
			e.printStackTrace();
		}
		return actualColorOfElement;
	}
	/**
	 * @discription: this method is used to validate color of the element 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on that time
	 * @param checkElementColor this parameter is used to we have to give color as a String 
	 * @param expectedColor
	 */
	public void ValidatElementOfColor(WebElement we, String elementName, String ColorName,
			String expectedColor) {
		String actualColor = verifyElementOfColor(we, elementName, ColorName);
		System.out.println("actualColor..." + actualColor);
		System.out.println("expectedColor...."+expectedColor);
		if (actualColor.equalsIgnoreCase(expectedColor)) {
			extt.log(Status.PASS,MarkupHelper.createLabel(elementName + " Color Of Element Validate pass. actualColor--"+ actualColor + "&&" + "ExpectedColor--" + expectedColor, ExtentColor.PURPLE));
		} else {
			extt.log(Status.FAIL,MarkupHelper.createLabel(elementName + " Color Of Element Validate failed. actualColor--"+ actualColor + "&&" + "ExpectedColor--" + expectedColor, ExtentColor.PURPLE));

		}

	}

	/**
	 * @discription: this method is used to verify background color of the element 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on that time
	 * @param backgroundColor this parameter is used to we have to give backgorund as a String type 
	 * @return
	 */
	public String VerifyBackgroundColorOfElement(WebElement we, String elementName, String backgroundColor) {
		String backgroungOf = null;
		try {
//			WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
			boolean checkElementVisibility = checkElement(we, elementName);
			if (checkElementVisibility == true) {
				backgroungOf = we.getCssValue(backgroundColor);
				String actualBackgroundColorOf = Color.fromString(backgroungOf).asHex();
				System.out.println("actualBackgroundColorOf...."+actualBackgroundColorOf);
				
				extt.log(Status.INFO, MarkupHelper.createLabel(elementName + " color of element is " + actualBackgroundColorOf, ExtentColor.GREEN));

			}
		} catch (NoSuchElementException e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName + " color of element isn't found", ExtentColor.GREEN));

			SnapShot(elementName);
			e.printStackTrace();
		} catch (Exception e) {
			extt.log(Status.INFO,MarkupHelper.createLabel(elementName + " color of element isn't found", ExtentColor.GREEN));

			SnapShot(elementName);
			e.printStackTrace();
		}
		return backgroungOf;
	}

	/**
	 * @discription: this parameter is used to validate backgound color of the element 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on that time
	 * @param backgroundColor this parameter is used towe have to give backgorund as a String type 
	 * @param  
	 */
	public void validateBackgroundColorOfElement(WebElement we, String elementName, String backgroundColor,
			String expextedBackgoundColor) {

		String actualBackground = VerifyBackgroundColorOfElement(we, elementName, backgroundColor);
		if (actualBackground.equals(expextedBackgoundColor)) {
			extt.log(Status.PASS,
					MarkupHelper.createLabel(elementName + "Backgound Color Of Element Validate pass. actualColor--"+ actualBackground + "&&" + "ExpectedColor--" + expextedBackgoundColor,ExtentColor.PURPLE));

		} else {
			extt.log(Status.PASS,MarkupHelper.createLabel(elementName + "Backgound Color Of Element Validate pass. actualColor--"+ actualBackground + "&&" + "ExpectedColor--" + expextedBackgoundColor,ExtentColor.PURPLE));

		}
	}
/**
	*@discription: this method is used to validate title of the webPage
	 * @param expectedTitle this parameter is used to give title of the webPage
	 */
	public void getWindowHandles(String expectedTitle) {
		Set<String> getHandleValue = driver.getWindowHandles();
		for (String getHandleWindow : getHandleValue) {
			driver.switchTo().window(getHandleWindow);
			String actualWindow = driver.getTitle();
			if (actualWindow.equalsIgnoreCase(expectedTitle)) {
				break;
			}
			extt.log(Status.INFO,MarkupHelper.createLabel(expectedTitle + " is Title switch successfully", ExtentColor.BLUE));

		}

	}

	/**
	 * @discription: this methos is used to validate current URL of webPage
	 * @param expectedCurrentUrl this parameter is used to give current url of the page 
	 */
	public void validateGetCurrentUrl(String expectedCurrentUrl) {
		Set<String> getHandleValue = driver.getWindowHandles();
		for (String getHandleWindow : getHandleValue) {
			driver.switchTo().window(getHandleWindow);
			String actualWindow = driver.getCurrentUrl();
			if (actualWindow.equalsIgnoreCase(expectedCurrentUrl)) {
				extt.log(Status.INFO, MarkupHelper.createLabel(expectedCurrentUrl + " is CurrentUrl switch successfully", ExtentColor.BLUE));
				break;
			}

		}
	}

	/**
	 * this parameter is used to whether the select element supports multiple selection options at the same time or not 
	 * @param we this parameter is used to search the element by locatorType and locatorValue on UI  which type are webElement 
	 * @param elementName this parameter is used to we have to give elementName Which are we working on that time
	 */
	public void validateMultipleSelected(WebElement we, String elementName) {
		try {
//			WebElement we=getWebElementLocatorXpath(locatorValue, locatorType);
			boolean checkElement = checkElement(we, elementName);
			if (checkElement == true) {
				Select select = new Select(we);
				boolean multipleSelect = select.isMultiple();
				if (multipleSelect == true) {
					extt.log(Status.PASS,MarkupHelper.createLabel(elementName + "is multiple Selected option validate Pass" + multipleSelect,ExtentColor.PINK));
				} else {
					extt.log(Status.FAIL,MarkupHelper.createLabel(elementName + "is multiple Selected option validate failed" + multipleSelect,ExtentColor.PINK));
				}
			}
		} catch (NoSuchElementException e) {
			SnapShot("SnapshotIsMultiple");
			e.printStackTrace();
		} catch (Exception e) {
			SnapShot("SnapshotIsMultiple");
			e.printStackTrace();
		}
	}
 
	
	/**
	 * @discription: this method is used to close current window
	 */
	public  void close() {
	   driver .close();
}
/**
 * @discription: this method is used to maximize the current window
 */
public  void maximizeWindow() {
	driver.manage().window().maximize();
}
/**
 * @return
 */
public  String getTitlePage() {
	return	driver.getTitle();
   

}
}