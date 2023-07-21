package utilLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebUtil {

	private ExtentTest test;
	private WebDriver driver;
	private ExtentReports report;

	public WebDriver getDriver() {

		return driver;

	}

	/**
	 * @return
	 */
	public String dateFormate() {
		DateFormat df = new SimpleDateFormat("dd_MMM+yyyy_HH_mm_ss_z");
		return df.format(new Date());
	}
	public ExtentTest getExtentTest() {
		return test;
	}
	/**
	 * @param fileNameOfExtendeport
	 * @param teatCaseName
	 */
	public void extentReport(String fileNameOfExtendeport) {
		String time=dateFormate();
		ExtentSparkReporter sparkObj = new ExtentSparkReporter("automation\\"+fileNameOfExtendeport+time+".html");
		report = new ExtentReports();
		report.attachReporter(sparkObj);

	}


	///// -----------WebDriver--------interface////

	/**
	 * @param browser
	 * @param url
	 * @return
	 */
	public WebDriver openBroswer(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
			test.log(Status.INFO, " Browser launch successfully ");
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			test.log(Status.INFO, " Browser launch successfully ");

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			test.log(Status.INFO, " Browser launch successfully ");

		} else {
			test.log(Status.INFO, " Browser not launched Browser name is not valid .please ");
		}
		return driver;

	}

	public void openURl(String URL) {
		driver.get(URL);
		test.log(Status.INFO, "Url hit successfully");
	}

	/*
	 * We create the for the close method
	 */
	public void close() {
		driver.close();
		try {
			test.log(Status.INFO, "Browser closed  successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * for maximize method
	 */
	public void maximize() {
		try {
			driver.manage().window().maximize();
			test.log(Status.INFO, "window maximize successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * minimize method
	 */
	public void minimize() {
		try {
			driver.manage().window().minimize();
			test.log(Status.INFO, "Browser  minimize successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param url
	 */
	public void navigateURL(String url) {
		driver.get(url);
		test.log(Status.INFO, "URL Navigate" + url + "successfully");

	}

	public String  getTitle() {
		String title=driver.getTitle();
		return title;
	}

	///// -----------WebElement Interface-----////

	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @return
	 * 
	 * 
	 * 
	 *         /**
	 * @param locatorType
	 * @param locatorValue
	 * @param datavalue
	 * @param elementName
	 */
	public void inputTextValue(WebElement we, String datavalue, String elementName) {
		if (we.isDisplayed())
			if (we.isEnabled()) {
				we.clear();
				we.sendKeys(datavalue);
				test.log(Status.INFO, "intered  value in" + elementName + "box is syuccessfully");
			} else {
				test.log(Status.INFO, "not intered  value in" + elementName + "box is syuccessfully");
			}
	}

	public void flush() {
		report.flush();
	}

	/**
	 * @param locatorValue
	 * @param locatorType
	 * @param elementName
	 */
	public void click(WebElement we, String elementName) {
		if (we.isEnabled()) {
			we.click();
			test.log(Status.INFO, elementName + "  click sucessfully");

		} else {
			test.log(Status.FAIL, elementName + "not  click sucessfully");
		}
	}

	/**
	 * @param Value
	 * @param locatorValue
	 * @param locatorType
	 * @param elementName
	 * @throws Exception
	 */
	public void getinnerText(String Value, WebElement we, String elementName) {
		String innerText = "";
		if (we.isDisplayed())
			if (we.isEnabled()) {
				we.getText();
				test.log(Status.INFO, "get text successfully=" + innerText);
			} else {
				test.log(Status.FAIL, elementName + "not  found getText");
			}
	}

	/**
	 * @param Value
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @param i
	 * @param status
	 * @param we
	 * @return
	 * @throws Exception
	 */
	public void getinnerTextMultipleElements(String Value, WebElement we, String elementName, int i) {
		String innerText = "";
		List<WebElement> lstWe = getList(we, elementName);
		for (int i1 = 0; i < lstWe.size(); i++)
			;

		if (we.isDisplayed())
			if (we.isEnabled()) {
				WebElement We = lstWe.get(i);

				test.log(Status.INFO, "get text successfully=" + innerText);
			} else {
				test.log(Status.FAIL, elementName + "not  found getText");

			}
	}

	private List<WebElement> getList(WebElement we, String elementName) {

		return null;
	}

	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @param attributeValue
	 * @return
	 */
	public void getAttributeValue(WebElement we, String elementName, String attributeValue) {

		if (we.isDisplayed()) {
			attributeValue = we.getAttribute(elementName);
			we.getText();
			test.log(Status.INFO, elementName + "get text successfully=" + attributeValue);
		} else {
			test.log(Status.FAIL, elementName + "not found attributeValue);");
		}
	}

	/**
	 * @param locatorValue
	 * @param locatorType
	 * @param elementName
	 * @param background_colour
	 * @param colourHasValue
	 * @return
	 * @throws Exception
	 */
	public void CssValue(WebElement we, String elementName, String background_colour, String colourHasValue) {

	}

	/**
	 * @param locatorValue
	 * @param locatorType
	 * @param elementName
	 * @param dropDownAttribute
	 * @throws Exception
	 */
	public void SelectByVisible(WebElement we, String elementName, String dropDownAttribute) {

		Select sl = new Select(we);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				sl.selectByVisibleText(dropDownAttribute);
				test.log(Status.INFO, elementName + "Select Value in Dropdown Successfully");
			} else {
				test.log(Status.FAIL, elementName + "Not Select Value in " + elementName + "Dropdown");
			}
	}

	/**
	 * @param locatorValue
	 * @param locatorType
	 * @param elementName
	 * @param dropDownValue
	 * @throws Exception
	 */
	public void SelectByValue(WebElement we, String elementName, String dropDownValue) {

		Select sl = new Select(we);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				sl.selectByValue(dropDownValue);
				test.log(Status.INFO, elementName + "Select Value in Dropdown Successfully");
			} else {
				test.log(Status.FAIL, elementName + "Not Select Value in " + elementName + "Dropdown");
			}
	}

	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @param dropDownValue
	 */
	public void SelectByindex(WebElement we, String elementName, int dropDownValue) {

		Select sl = new Select(we);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				sl.selectByIndex(dropDownValue);
				test.log(Status.INFO, elementName + "Select Value in Dropdown Successfully");
			} else {
				test.log(Status.FAIL, elementName + "Not Select Value in " + elementName + "Dropdown");
			}
	}

	/**
	 * @param locatorValue
	 * @param locatorType
	 * @param elementName
	 * @param dropDownValue
	 * @throws Exception
	 */
	public void selectDeselectByValue(WebElement we, String elementName, String dropDownValue) {

		Select sl = new Select(we);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				sl.deselectByValue(dropDownValue);
				test.log(Status.INFO, elementName + "Deselect Value in Dropdown Successfully=" + dropDownValue);
			} else {
				test.log(Status.FAIL, elementName + "Not Deselect Value in " + elementName + "Dropdown");
			}
	}

	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @param dropDownValue
	 * @throws Exception
	 */
	public void selectDeselectByVisibleText(WebElement we, String elementName, String dropDownValue) {

		Select sl = new Select(we);
		if (we.isEnabled()) {
			sl.deselectByVisibleText(dropDownValue);
			test.log(Status.INFO, elementName + "Deselect Value in Dropdown Successfully=" + dropDownValue);
		} else {
			test.log(Status.FAIL, elementName + "Not Deselect Value in " + elementName + "Dropdown");
		}
	}

	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @param dropDownValue
	 * @throws Exception
	 */
	public void selectDeselectByindex(WebElement we, String elementName, int dropDownValue) {

		Select sl = new Select(we);
		if (we.isDisplayed()) {
			sl.deselectByIndex(dropDownValue);
			test.log(Status.INFO, elementName + "Deselect index in Dropdown Successfully=" + dropDownValue);
		} else {
			test.log(Status.FAIL, elementName + "Not Deselect index in " + elementName + "Dropdown");
		}
	}

	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @param dropDownValue
	 * @throws Exception
	 */
	public void DeselectAll(WebElement we, String elementName, int dropDownValue) {

		Select sl = new Select(we);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				sl.deselectAll();
				test.log(Status.INFO, elementName + "Deselect all in Dropdown Successfully=");
			} else {
				test.log(Status.FAIL, elementName + "Not Deselect all in");
			}
	}

	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @throws Exception
	 */
	public void FirstSelect(WebElement we, String elementName) throws Exception {

		Select sl = new Select(we);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				String getFSO = sl.getFirstSelectedOption().getText();
				test.log(Status.INFO,
						elementName + "getFirstSelectedOption Value in" + elementName + "Drodown is =" + getFSO);
			} else {
				test.log(Status.FAIL, elementName + "Not Deselect all in");
			}
	}

	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @throws Exception
	 */
	public void getAllSelectOptions(WebElement we, String elementName) {

		Select sl = new Select(we);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				List<WebElement> lst = sl.getAllSelectedOptions();
				for (int i = 0; i < lst.size(); i++) {
					String getOption = lst.get(i).getText();
					i++;
				}
				test.log(Status.INFO, "get one by one all selected options");
			} else {
				test.log(Status.FAIL, "getAllSelectedOptions Value in" + elementName + "Dropdown Successfully");
			}
	}

	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @throws Exception
	 */
	public void SelectGetOptions(WebElement we, String elementName) throws Exception {
		Select sl = new Select(we);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				List<WebElement> lst = sl.getOptions();
				for (int i = 0; i < lst.size(); i++) {
					String getOption = lst.get(i).getText();
					i++;
				}
				test.log(Status.INFO, "getAllOptions Value in" + elementName + "Dropdown Successfully");
			} else {
				test.log(Status.FAIL, "Not get First  Value in" + elementName + "Dropdown");
			}
	}
	////// -------Action Class------///////////

	//// /* Mouse Over *//////
	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 */
	public void mouseOver(WebElement we, String elementName) {

		Actions ac = new Actions(driver);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				ac.moveToElement(we).build().perform();
				test.log(Status.INFO, elementName + "MouseOver Successfully");
			} else {
				test.log(Status.FAIL, elementName + "not mouseOver");
			}
	}

	public void actionClick(WebElement we, String elementName) {
		try {
			new Actions(driver).click(we).build().perform();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void actionSendkey(WebElement we,  String elementName,String textBoxValue) {
		try {
			new Actions(driver).sendKeys(we).build().perform();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param locatorValue
	 * @param locatorType
	 * @param elementName
	 */
	public void actionClickAndHold(String locatorType, String locatorValue, String elementName) {

	}

	/**
	 * @param value
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @param value
	 */
	public void actioninputValue(WebElement we, String value, String elementName) {

		Actions act = new Actions(driver);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				act.moveToElement(we).sendKeys(value).build().perform();
				test.log(Status.INFO, "Send the value successfully");
			}else {
				test.log(Status.FAIL, " not Send the value successfully");
			}
	}




	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 */
	public void actionDoubleClick(WebElement we, String elementName) {

		Actions act = new Actions(driver);
		if (we.isDisplayed() == true)
			if (we.isEnabled() == true) {
				act.moveToElement(we).doubleClick().build().perform();
				test.log(Status.INFO, "by action double click is successfully");
			}else {
				test.log(Status.FAIL, "by action double click is not  successfully");
			}
	}

	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 */
	public void actionRightClick(WebElement we, String elementName) {

		Actions act = new Actions(driver);
		if (we.isDisplayed() == true)
			if (we.isEnabled() == true) {
				act.moveToElement(we).contextClick().build().perform();
			} else {
				test.log(Status.INFO, "by action right click is successfully");
			}else {
				test.log(Status.FAIL, "by action right click is not  successfully");

			}
	}

	/**
	 * @param locatorType1
	 * @param locatorValue1
	 * @param locatorType2
	 * @param locatorValue2
	 * @param elementName
	 * @param we
	 */
	public void dragAnddrop(String elementName, WebElement we1, WebElement we2) {

		Actions act = new Actions(driver);
		if (we1.isDisplayed() == true)
			if (we1.isEnabled() == true) {
				act.dragAndDrop(we1, we2).contextClick().build().perform();
				test.log(Status.INFO, "by action drag and drop is successfully");
			} else {
				test.log(Status.FAIL, "by action drag and drop is  not successfully");
			}
	}

	/**
	 * @param locatorType
	 * @param locatorValue
	 * @param elementName
	 * @param textBoxValue
	 */
	public void sendkeys(WebElement we, String elementName, String textBoxValue) {

		if (we.isDisplayed()) {
			test.log(Status.PASS, "element is Dsplayed");
			if (we.isEnabled() == true) {
				test.log(Status.PASS, "send the value Successfully");
				we.sendKeys(textBoxValue);

			} else {
				test.log(Status.FAIL, "the vlaue  is not send successfully");
			}
		}
	}


	public void implicitWait(int time) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		} catch (Exception e) {


		}

	}


	public void sleep(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (Exception e) {


		}

	}


	public void alertAccept() {
		driver.switchTo().alert().accept();
		test.log(Status.INFO, "Alert accepted successfully");
	}

	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
		test.log(Status.INFO, "Alert dismiss successfully");
	}

	public void alertsendKeys(String value) {
		driver.switchTo().alert().sendKeys(value);
		test.log(Status.INFO, value+" enter in alert successfully");
	}

	public String alertGetStringValue() {
		String alertgetText = driver.switchTo().alert().getText();
		test.log(Status.INFO, alertgetText+" Has been taken successfully");
		return alertgetText;

	}

	public void javaScriptSendKeys(WebElement we, String inputValue) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		we.clear();
		jse.executeScript("arguments[0].value='" + inputValue + "", we);
		System.out.println("value is Inputed successfully");

	}



	public void explicityWait(WebElement we, int timeInsecond) {
		if (we.isDisplayed() && we.isEnabled()) {
			WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(timeInsecond));
			explicitwait.until(ExpectedConditions.visibilityOf(we));
			test.log(Status.INFO,"sendkey successfully");
		}
	}

	public void fluentWait(WebElement we, int totalTime, int timeInterval) {

	}


	public void refreshWindow() {
		driver.navigate().refresh();
		test.log(Status.INFO, "Window refresh  successfully");
	}

	public void quit() {
		driver.quit();
		test.log(Status.INFO, "window quit successfully");
	}

	public void navigateBack() {
		driver.navigate().back();
		test.log(Status.INFO, " page navigatBack successfully");
	}

	public void navigateForword() {
		driver.navigate().forward();
		test.log(Status.INFO, "page navigated forward successfully");
	}

	public void createTestCase(String teatCaseName) {
		test = report.createTest(teatCaseName);
	}

}