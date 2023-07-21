package org.jumia.vtiger.testScripts;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.jumia.vtiger.genericCode.ExcelDataUtil;
import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.eva.vtiger.pages.functionality.login.LoginPage;
import com.eva.vtiger.pages.functionality.myhomepage.home.HomePage;

public class BaseTestClass {

//	protected Map<String, String> mapRowData;
	protected WebDriverUtil webUtil;
	protected HomePage hmp;
	protected List<Map<String, String>> listTestdata;
	protected Object[][] dataTwoDArr;

	
	@BeforeTest(alwaysRun = true)
	public void generateExtentReport() {
		webUtil = new WebDriverUtil();
		webUtil.extentReport();
	}

	@AfterTest(alwaysRun = true)
	public void flushed() {
		webUtil.flushed();
	}
//@Parameters({"browser","url"})
	@BeforeClass(alwaysRun = true)
	public void launchBrowser( ) {
//		String st = m.getName();	
		webUtil.testCaseId("browser Launched");
//        webUtil.launchBrower(browser);
        
//        webUtil.hitUrl(url);
		webUtil.launchBrower(webUtil.getConfiValue("browser"));
		webUtil.hitUrl(webUtil.getConfiValue("url"));
	}

	@AfterClass(alwaysRun = true)
	public void closeTheBrowser() {
		webUtil.close();
	}

	@DataProvider
	public Object[][] getValue(Method m) {
		String st = m.getName();
		listTestdata = ExcelDataUtil.getAllDataFromExcel("ExcelData\\ReadData.xlsx", st);
		dataTwoDArr = new Object[listTestdata.size ()][1];
		for (int i = 0; i < listTestdata.size(); i++) {
			Object objmap = listTestdata.get(i);
			dataTwoDArr[i][0] = objmap;

		}
		return dataTwoDArr;
	}

	@BeforeMethod(alwaysRun = true)
	public void startFromLogin(Method m) {
		String st = m.getName();
		webUtil.testCaseId(st);
		LoginPage loginObj = new LoginPage(webUtil);
		hmp = loginObj.validLogin();

	}

	@AfterMethod(alwaysRun = true)
	public void logout(ITestResult i) {
		int status = i.getStatus();
		if (status == ITestResult.FAILURE) {
			webUtil.SnapShot("ScreenShot");
		}
		hmp.signOut();
//		webUtil.flushed();

	}

}
