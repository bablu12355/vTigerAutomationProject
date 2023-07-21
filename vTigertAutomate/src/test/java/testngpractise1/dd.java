package testngpractise1;

import java.util.List;
import java.util.Map;

import org.jumia.vtiger.genericCode.ExcelDataUtil;

public class dd {

	
	public static void main(String[] args) {
		List<Map<String, String>> listTestdata=	ExcelDataUtil.getAllDataFromExcel("ExcelData\\ReadData.xlsx", "verifyCreateLead");
		
		for (int i = 0; i < listTestdata.size(); i++) {
			Map<String, String>	mapRowData = ExcelDataUtil.totalListData.get(i);
			System.out.println(mapRowData);
			
	}
}
}