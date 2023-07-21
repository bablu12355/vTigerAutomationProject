package com.eva.vtiger.listner;

import java.util.Properties;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ItestListnerTestcase implements ITestListener {
	private WebDriverUtil webUtil =new WebDriverUtil ();

	@Override
	public void onTestStart(ITestResult result) {
		webUtil.testCaseId(result.getName() );
		WebDriverUtil.extt.log(Status.INFO, MarkupHelper.createLabel(result + "generate successfully", ExtentColor.PINK));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		WebDriverUtil.extt.log(Status.INFO,MarkupHelper.createLabel(result.getName()  + "Test Case is successFully done", ExtentColor.INDIGO));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriverUtil.extt.log(Status.INFO,MarkupHelper.createLabel(result.getName()  + "Test Case  isn't  successFuly done", ExtentColor.INDIGO));
		webUtil.SnapShot("Failed Test Case..."+result.getName() );
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		WebDriverUtil.extt.log(Status.INFO,MarkupHelper.createLabel(result.getName() + "  is Test case Skipped", ExtentColor.INDIGO));

	}
	@Override
	public void onStart(ITestContext context) {
		webUtil.extentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		webUtil.flushed();
	}

}
