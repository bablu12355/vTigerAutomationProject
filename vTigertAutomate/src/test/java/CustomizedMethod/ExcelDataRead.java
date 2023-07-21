package CustomizedMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class ExcelDataRead {

	public static void main(String[] args) {
//		List<Map<String, String>>   s  =   getAllData();
//		System.out.print(s);
		getAllDataFromExcel();
	}

	public  static List<Map<String, String>>  getAllData() {
		File fiObj = new File("ExcelData\\Ram.xlsx");
		InputStream fileInputObj = null;
		Workbook wbook = null;
		try {
			fileInputObj = new FileInputStream(fiObj);
			wbook = new XSSFWorkbook(fileInputObj);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheetObj = wbook.getSheetAt(0);
		List<Map<String, String>> getDubleListObj = new ArrayList<Map<String, String>>();
		for (int i = 1; i <= sheetObj.getLastRowNum(); i++) {
			Map<String, String> mapObj = new HashMap<String, String>();
			Row row = sheetObj.getRow(i);
			Row row2 = sheetObj.getRow(0);

			for (int j = 0; j <= row2.getLastCellNum()-1; j++) {
				Cell cellobj = row2.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
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
				} else {

					sData = cellobj.getStringCellValue();

				}

				for (int t = 0; t <= row.getLastCellNum()-1; t++) {
					Cell cellobj1 = row.getCell(t, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					CellType celltype1 = cellobj1.getCellType();
					String sData1;
					if (celltype1 == CellType.NUMERIC) {
						Double dData1 = cellobj1.getNumericCellValue();
						Integer intData1 = dData1.intValue();
						sData1 = intData1.toString();
					} else if (celltype1 == CellType.FORMULA) {

						Double dData1 = cellobj1.getNumericCellValue();
						Integer intData1 = dData1.intValue();
						sData1 = intData1.toString();
					} else {

						sData1 = cellobj1.getStringCellValue();

					}

					mapObj.put(sData, sData1);
				}
				getDubleListObj.add(mapObj);
			}
			
		}
		return getDubleListObj;
	}

	public static Workbook getWorkBook(String filePath) {
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

	public static String getCellData(Row row, int cellNumber) {
		Cell cellobj = row.getCell(cellNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		CellType celltype = cellobj.getCellType();
		String sData;
		if (celltype == celltype.NUMERIC) {
			Double dData = cellobj.getNumericCellValue();
			Integer intData = dData.intValue();
			sData = intData.toString();
		} else if (celltype == celltype.FORMULA) {

			Double dData = cellobj.getNumericCellValue();
			Integer intData = dData.intValue();
			sData = intData.toString();
		} else {
			sData = cellobj.getStringCellValue();

		}
		return sData;
	}

	public static List<Map<String, String>> getAllDataFromExcel() {
		// getting object of  workbook
		Workbook wbook = getWorkBook("C:\\Users\\Admin\\Desktop\\TestcaseLogin.xlsx");
	// getting object  of sheet by  sheetName
		Sheet sheetObj = wbook.getSheetAt(0);
	// getting row count 
		List<Map<String, String>> totalListData = new ArrayList<Map<String, String>>();
		// represent number of row.
		// creating object of ArrayList that list will have object of  map. 
		// because we want to read data of every row as map.
		for (int i = 1; i <= sheetObj.getLastRowNum(); i++) {
		// creating Object of HashMap keep row data in map
			Map<String, String> mapObj = new HashMap<String, String>();
			// getting object of specified row number and this row will have data value 
			// to put in Map
			Row row = sheetObj.getRow(i);
			// getting Row object of First row (Means column names)
			// and this data will be used as key name in map.
			Row firstRowObj = sheetObj.getRow(0);
			//Represent number of cell each row.
			for (int j = 0; j <= row.getLastCellNum() - 1; j++) {
				//getting cell data from first row (means column name)
				// this data will work as keysName
				String columnKey = getCellData(firstRowObj, j);
				//getting cell data from specified  row (means column name)
				// this data will work as keysValue.
				String sData = getCellData(row, j);
				// Keeping column name as key and row value as data value
				mapObj.put(columnKey, sData);
			}
			// Adding map to list.
			totalListData.add(mapObj);

		}
		return totalListData;
	}

	public void main() {
		File fileObj = new File("C:\\Users\\Admin\\Desktop\\TestcaseLogin.xlsx");
		InputStream inputFileObj = null;
		Workbook workBookObj = null;
		try {
			inputFileObj = new FileInputStream(fileObj);
			workBookObj = new XSSFWorkbook(inputFileObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheetObj = workBookObj.getSheetAt(0);
		List<List<String>> getDubleListObj = new ArrayList<List<String>>();

		for (int i = 0; i <= sheetObj.getLastRowNum(); i++) { //// Represent the number of row
			List<String> getSingleListObj = new ArrayList<String>();
			Row rowObj = sheetObj.getRow(i);

			for (int j = 0; j < rowObj.getLastCellNum(); j++) { /// Represent number of column each row
				Cell cellObj = rowObj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				CellType cellTypeObj = cellObj.getCellType();
				String sDataObj = null;
				if (cellTypeObj == CellType.NUMERIC) {
					Double doubleObj = cellObj.getNumericCellValue();
					Integer intObj = doubleObj.intValue();
					sDataObj = intObj.toString();

				}
				getSingleListObj.add(sDataObj);
			}
			getDubleListObj.add(getSingleListObj);
		}

	}
}