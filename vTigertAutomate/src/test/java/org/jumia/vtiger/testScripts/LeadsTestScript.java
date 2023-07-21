package org.jumia.vtiger.testScripts;

import java.util.List;
import java.util.Map;

import org.jumia.vtiger.genericCode.ExcelDataUtil;
import org.jumia.vtiger.genericCode.WebDriverUtil;

import com.eva.vtiger.pages.functionality.login.LoginPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsCreatePage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsDetailLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsLandingPage;
import com.eva.vtiger.pages.functionality.myhomepage.home.HomePage;

public class LeadsTestScript {

	private WebDriverUtil webUtil;

	public LeadsTestScript(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
	}

	public void verifyCreateLeads(String tcID)  {
		List<Map<String, String>> listTestdata= ExcelDataUtil.getAllDataFromExcel( "ExcelData\\ReadLeadData.xlsx","Sheet1");
		int mapCount = listTestdata.size();
		System.out.println(mapCount);
		webUtil.testCaseId(tcID);
		webUtil.launchBrower(webUtil.getConfiValue("browser"));
		webUtil.hitUrl(webUtil.getConfiValue("url"));
		LoginPage loginObj = new LoginPage(webUtil);
		HomePage hmp=loginObj.validLogin();
		LeadsLandingPage lLp=hmp.goToMarketingLandingPage();
		LeadsCreatePage leadsCreate=	lLp.clickCreateAccountButton("Click Button");
		for (int i = 0; i < mapCount; i++) {
			Map<String, String> mapRowData = ExcelDataUtil.totalListData.get(i);
			LeadsDetailLandingPage lILP=	leadsCreate.saveLeads(mapRowData);
				String expectedErrorMessage = mapRowData.get("ErrorMessage");
				String scenario = mapRowData.get("ScenarioType");
				if (scenario.equalsIgnoreCase("Invalid")) {
					webUtil.validatePopUpText(expectedErrorMessage);
					webUtil.HandleAlertAccept();
				} else {
					lILP.validateLeadsDetailInfo();
				}
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			webUtil.close();
		}

	}
