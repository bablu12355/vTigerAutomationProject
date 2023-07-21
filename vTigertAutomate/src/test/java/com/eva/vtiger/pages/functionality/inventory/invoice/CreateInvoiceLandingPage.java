package com.eva.vtiger.pages.functionality.inventory.invoice;

import java.util.Map;

import org.jumia.vtiger.genericCode.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.eva.vtiger.pages.or.inventory.invoice.OrCreateInvoiceLandingPage;

public class CreateInvoiceLandingPage extends OrCreateInvoiceLandingPage {

	private WebDriverUtil webUtil;

	public CreateInvoiceLandingPage(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	public void enterValueDetail(Map<String, String> rowData) {
		webUtil.usingWebElementSendKeys(subjectED, rowData.get("Subject"), "Harbal Products");
		webUtil.usingWebElementSendKeys(customerEd, rowData.get("CustomerNo"), "Customer No");
		webUtil.usingWebElementclickMethod(contactNameSelectBt, "Contact No");
		webUtil.validateGetCurrentUrl("http://localhost:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&popuptype=specific&form=EditView");
	
		if (rowData.get("ContactNo").equalsIgnoreCase("Raman")) {
			webUtil.usingWebElementclickMethod(clickYadavRamanBt, "Yadav Raman");

		} else if (rowData.get("ContactNo").equalsIgnoreCase("Bablu")) {
		
			webUtil.usingWebElementclickMethod(clickYadavBabluBt, "Yadav Bablu");
		
		} else if (rowData.get("ContactNo").equalsIgnoreCase("Yadav")) {
	
			webUtil.usingWebElementclickMethod(clickYadavBt, "Yadav Bablu");
		
		}
		else {
			webUtil.getExtentTest().log(Status.FAIL, MarkupHelper.createLabel( "Contact No  cannot be none", ExtentColor.PURPLE));

		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webUtil.HandleAlertAccept();
		webUtil.validateGetCurrentUrl("http://localhost:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Inventory");
		webUtil.usingWebElementclickMethod(accountNameSelect, "Account Name Select Button");
		webUtil.validateGetCurrentUrl("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=");

		if (rowData.get("AccountNo").equalsIgnoreCase("Demo")) {
			webUtil.usingWebElementclickMethod(clickDemoVtigerClick, "Demo Vtiger Link");

		} else if (rowData.get("AccountNo").equalsIgnoreCase("Vtiger")) {
			webUtil.usingWebElementclickMethod(clickVtigerLink, "Vtiger");
		} else if (rowData.get("AccountNo").equalsIgnoreCase("VtigerUser")) {
			webUtil.usingWebElementclickMethod(clickVtigerUserLink, "VtigerUser Link ");

		} 
		
		else {
			webUtil.getExtentTest().log(Status.FAIL, MarkupHelper.createLabel("Account Name cannot be none", ExtentColor.PURPLE));
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webUtil.HandleAlertAccept();
		webUtil.validateGetCurrentUrl("http://localhost:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Inventory");

		webUtil.usingWebElementSendKeys(bill_streetED, rowData.get("Bill_street"), "Bill_street");
		webUtil.usingWebElementSendKeys(bill_poboxEd, rowData.get("Bill_pobox"), "Bill_pobox");
		webUtil.usingWebElementSendKeys(bill_cityEd, rowData.get("Bill_city"), "Bill_city");
		webUtil.usingWebElementSendKeys(bill_stateEd, rowData.get("Bill_state"), "Bill_state");
		webUtil.usingWebElementSendKeys(bill_codeEd, rowData.get("Bill_code"), "Bill_code");
		webUtil.usingWebElementSendKeys(bill_countryEd, rowData.get("Bill_country"), "Bill_country");
//		webUtil.usingWebElementSendKeys(saleOrder_nameEd,rowData.get( "SaleOrder_name"), "SaleOrder_name");
		webUtil.usingWebElementSendKeys(purchaseOrderEd, rowData.get("PurchaseOrder"), "PurchaseOrder");
		webUtil.usingWebElementSendKeys(salesCommissionEd, rowData.get("SalesCommission"), "SalesCommission");
		webUtil.usingWebElementSendKeys(shipping_addressEd, rowData.get("Shipping_address"), "Shipping_address");
		webUtil.usingWebElementSendKeys(ship_cityEd, rowData.get("Ship_city"), "Ship_city");
		webUtil.usingWebElementSendKeys(ship_stateEd, rowData.get("Ship_state"), "Ship_state");
		webUtil.usingWebElementSendKeys(ship_codeEd, rowData.get("Ship_code"), "Ship_code");
		webUtil.usingWebElementSendKeys(ship_countryEd, rowData.get("Ship_country"), "Ship_country");
		webUtil.usingWebElementSendKeys(qtyBt, rowData.get("Quantity"), "Quantity");

		webUtil.actionsClickMethod(seachIconClickBt, "Search Icon");

		webUtil.validateGetCurrentUrl("http://localhost:8888/index.php?module=Products&action=Popup&html=Popup_picker&select=enable&form=HelpDeskEditView&popuptype=inventory_prod&curr_row=1&&&return_module=Invoice&currencyid=1");

		webUtil.usingWebElementclickMethod(BrotherInkJetCartridgeLinkClick, "Brother Ink Jet Cartridge Link Click");

		webUtil.validateGetCurrentUrl("http://localhost:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Inventory");
	}

	public InvoiceDetailPage saveButton(Map<String, String> rowData) {
		enterValueDetail(rowData);
		webUtil.usingWebElementclickMethod(saveBt, "Save Button");
		return new InvoiceDetailPage(webUtil);
	}

	public void cancelButton(Map<String, String> rowData) {
		enterValueDetail(rowData);
		webUtil.usingWebElementclickMethod(cancelBt, "Cancel Button");
	}
}
