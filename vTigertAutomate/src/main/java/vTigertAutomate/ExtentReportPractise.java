package vTigertAutomate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class ExtentReportPractise implements WebDriver{

	public static void main(String[] args) throws IOException {
		
//		Properties pr= new Properties();
//		FileInputStream fr= new FileInputStream("C:\\Users\\Admin\\Desktop\\MyFirstJava\\vTigertAutomate\\bablu.properties");
//
//		pr.load(fr);
//		 String a= pr.getProperty("username");
//		
		File fileObj = new File("Bablu.html");

		ExtentSparkReporter htmlReport = new ExtentSparkReporter(fileObj);

		ExtentReports extReport = new ExtentReports();
		extReport.setSystemInfo("os name is --", System.getProperty("os.name"));
		extReport.setSystemInfo("Username is --", System.getProperty("user.name"));
		extReport.setSystemInfo("server name is --", System.getProperty("QA server"));
		extReport.attachReporter(htmlReport);
		tc002(extReport);
	}

	public static void tc001(ExtentReports extReport) {
		ExtentTest extTest = extReport.createTest("Tc001");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		extTest.log(Status.INFO, "Chrome Browser Succesfully");
		driver.get("http://localhost:8888");
		extTest.log(Status.INFO, "Url navigate http:/localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		extTest.log(Status.INFO, "Username(admin) is entered succesfully in username Box");

		driver.findElement(By.name("user_password")).sendKeys("Bablu@123");
		extTest.log(Status.INFO, "Password(Bablu@123) is entered succesfully in Password Box");

		driver.findElement(By.name("Login")).click();
		extTest.log(Status.INFO, "Click Performed succesfully Login Button");

		boolean checkVisibilityOfMarket = driver.findElement(By.xpath("//a[text()='Marketing']")).isDisplayed();

		if (checkVisibilityOfMarket == true) {
			extTest.log(Status.PASS, "Marketing Button is visible Tc001 is passed");
		} else {
			extTest.log(Status.FAIL, "Marketing Button isn't visible Tc001 is failed");

		}
		extReport.flush();
	}

	public static void tc002(ExtentReports extReport1) throws IOException {
		ExtentTest extTest = extReport1.createTest("Tc002");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		extTest.log(Status.INFO, "Chrome Browser Succesfully");
		driver.get("http://localhost:8888");
		extTest.log(Status.INFO, "Url navigate http:/localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		extTest.log(Status.INFO, "Username(admin) is entered succesfully in username Box");

		driver.findElement(By.name("user_password")).sendKeys("Bablu@123");
		extTest.log(Status.INFO, "Password(Bablu@123) is entered succesfully in Password Box");

		driver.findElement(By.name("Login")).click();
		extTest.log(Status.INFO, "Click Performed succesfully Login Button");

		String act_title = driver.getTitle();
		extTest.log(Status.INFO,
				"user provide gettitle(admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM)");
		String expected_title = "admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";

		if (act_title.equals(expected_title)) {
			extTest.log(Status.PASS, "user is able to appear homepage,test case Tc002 passed");
		} else {
			extTest.log(Status.FAIL, "user isn't able to appear homepage,test case Tc002 failed");

		}
		TakesScreenshot tst = (TakesScreenshot) driver;
		File fl = tst.getScreenshotAs(OutputType.FILE);
		Date dt = new Date();
		long lg = dt.getTime();
		System.out.println(lg);
		File ft = new File("Bablu//yadav" + lg + ".png");
		Files.copy(fl,ft);

		extTest.addScreenCaptureFromPath(ft.getAbsolutePath());
		extReport1.flush();

	}

	public void get(String url) {
		// TODO Auto-generated method stub
		
	}

	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}
}
