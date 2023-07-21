package org.jumia.vtiger.genericCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtil {
	public static List<Map<String, String>> totalListData;

	public static Workbook getWorkBookStatment(String filePath) {
		File fiObj = new File(filePath);
		InputStream fileInputObj = null;
		Workbook wbook = null;
		try {
			fileInputObj = new FileInputStream(fiObj);
			wbook = new XSSFWorkbook(fileInputObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wbook;

	}

	public static String getCellDataStatement(Row row, int cellNumber) {
		Cell cellobj = row.getCell(cellNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		CellType celltype = cellobj.getCellType();
		String sData;
		if (celltype == CellType.NUMERIC) {
			Double dData = cellobj.getNumericCellValue();
			Integer intData = dData.intValue();
			sData = intData.toString();
		} else if (celltype == CellType.FORMULA) {
			Double dData = cellobj.getNumericCellValue();
			Integer intData = dData.intValue();
			sData = intData.toString();
		} else if (celltype==CellType.ERROR){
			sData = cellobj.getStringCellValue();
		}else {
			sData = cellobj.getStringCellValue();
		}
		return sData;
	}

	public static List<Map<String, String>> getAllDataFromExcel(String filePath,String SheetName) {
		// getting object of workbook
		Workbook wbook = getWorkBookStatment(filePath);
		
		
		// getting object of sheet by sheetName
		Sheet sheetObj = wbook.getSheet(SheetName);
		// creating object of ArrayList that list will have object of map.
		// because we want to read data of every row as map.
		totalListData = new ArrayList<Map<String, String>>();
		// represent number of row.
		for (int i = 1; i <=sheetObj.getLastRowNum(); i++) {
			// creating Object of HashMap keep row data in map
			Map<String, String> mapObj = new HashMap<String, String>();
			// getting object of specified row number and this row will have data value
			// to put in Map
			Row row = sheetObj.getRow(i);
			// getting Row object of First row (Means column names)
			// and this data will be used as key name in map.
			Row firstRowObj = sheetObj.getRow(0);
			// Represent number of cell each row.
			if(row==null) {
				continue;
			}
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// getting cell data from first row (means column name)
				// this data will work as keysName
				String columnKey = getCellDataStatement(firstRowObj, j);
				// getting cell data from specified row (means column name)
				// this data will work as keysValue.
				String sData = getCellDataStatement(row, j);
				// Keeping column name as key and row value as data value
				mapObj.put(columnKey, sData);
			}
			// Adding map to list.
			totalListData.add(mapObj);

		}
		return totalListData;
	}

	public static Map<String, String> getRowData(int rowNumber,String SheetName,String filePath) {
		// getting object of workbook
		Workbook wbook = getWorkBookStatment( filePath);
		// getting object of sheet by sheetName
		Sheet sheetObj = wbook.getSheet(SheetName);
		// creating Object of HashMap keep row data in map
		Map<String, String> mapObj = new HashMap<String, String>();
		// getting object of specified row number and this row will have data value
		// to put in Map
		Row row = sheetObj.getRow(rowNumber);
		// getting Row object of First row (Means column names)
		// and this data will be used as key name in map.
		Row firstRowObj = sheetObj.getRow(0);
		// Represent number of cell each row.
		for (int j = 0; j <= row.getLastCellNum() - 1; j++) {
			// getting cell data from first row (means column name)
			// this data will work as keysName
			String columnKey = getCellDataStatement(firstRowObj, j);
			// getting cell data from specified row (means column name)
			// this data will work as keysValue.
			String sData = getCellDataStatement(row, j);
			// Keeping column name as key and row value as data value
			mapObj.put(columnKey, sData);
		}
		return mapObj;

	}
}
