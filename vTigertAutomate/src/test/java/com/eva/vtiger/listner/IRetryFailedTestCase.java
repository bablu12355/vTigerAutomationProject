package com.eva.vtiger.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryFailedTestCase implements IRetryAnalyzer {
	int counter = 3;
	int start = 0;

	@Override
	public boolean retry(ITestResult result) {
       if(start<=counter) {
    	   start++;
    	   System.out.println(result.getName());
    	   return true;
    	   
       }
		return false;
	}

}
