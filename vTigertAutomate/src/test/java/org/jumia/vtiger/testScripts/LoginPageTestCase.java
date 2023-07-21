package org.jumia.vtiger.testScripts;

import java.util.List;
import java.util.Map;

import org.jumia.vtiger.genericCode.ExcelDataUtil;
import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.testng.annotations.Test;

import com.eva.vtiger.pages.functionality.login.LoginPage;
import com.eva.vtiger.pages.functionality.myhomepage.home.HomePage;

public class LoginPageTestCase {
	private WebDriverUtil webUtil;

	public LoginPageTestCase(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
	}
	public void verifyLoginPageTestScript(String tcId) {
		List<Map<String, String>> listTestdata = ExcelDataUtil.getAllDataFromExcel("ExcelData\\ReadData.xlsx","verifyLoginTestScript" );
		int mapCount = listTestdata.size();
		System.out.println(mapCount);
		webUtil.testCaseId(tcId);
		webUtil.launchBrower(webUtil.getConfiValue("browser"));
		webUtil.hitUrl(webUtil.getConfiValue("url"));
		for (int i = 0; i < mapCount; i++) {
			Map<String, String> mapRowData = ExcelDataUtil.totalListData.get(i);
			LoginPage loginObj = new LoginPage(webUtil);
			HomePage home=	loginObj.validLogin(mapRowData);
			String expectedErrorMessage = mapRowData.get("Error Message");
			String scenario = mapRowData.get("ScenarioType");
			if (scenario.equalsIgnoreCase("Invalid")) {
				webUtil.validateText(loginObj.getErrorMessage(), expectedErrorMessage, "Error Message");
			} else {
				webUtil.validateElementInVisible(home.getMarketingLink(), "Marketing Link Text");
			}
		}
		webUtil.close();
	}
}
