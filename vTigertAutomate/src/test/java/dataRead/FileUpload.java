package dataRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class FileUpload {
	@Test(priority = 3)
	public void ReadDataFromExcel() {

		File fiObj = new File("C:\\Users\\Admin\\Desktop\\Data.xlsx");
		InputStream fileInputObj = null;
		Workbook wbook = null;
		try {
			fileInputObj = new FileInputStream(fiObj);
			wbook = new XSSFWorkbook(fileInputObj);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheetObj = wbook.getSheetAt(0);

		for (int i = 0; i <= sheetObj.getLastRowNum(); i++) {
			Row row = sheetObj.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cellobj = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				CellType celltype = cellobj.getCellType();
				String sData;
				if (celltype == celltype.NUMERIC) {
					Double dData = cellobj.getNumericCellValue();
					Integer intData = dData.intValue();
					sData = intData.toString();
				} else {
					sData = cellobj.getStringCellValue();
				}
				System.out.println(sData + "     ");

			}
			System.out.println("        ");

		}

	}

	@Test(priority = 2)
	public void differentWayReadDataFromExcel() {
		File fiObj = new File("C:\\Users\\Admin\\Desktop\\Data.xlsx");
		InputStream fileInputObj = null;
		Workbook wbook = null;
		try {
			fileInputObj = new FileInputStream(fiObj);
			wbook = new XSSFWorkbook(fileInputObj);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheetObj = wbook.getSheetAt(0);

		for (int i = 0; i <= sheetObj.getLastRowNum(); i++) {
			Row row = sheetObj.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cellobj = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				switch (cellobj.getCellType()) {
				case STRING:
					System.out.print(cellobj.getStringCellValue());
					break;

				case NUMERIC:
					System.out.print(cellobj.getNumericCellValue());
					break;

				case BOOLEAN:
					System.out.print(cellobj.getBooleanCellValue());
					break;
				}
				System.out.print("  |  ");
			}
			System.out.println();
		}
	}

	@Test(priority = 1)
	public void howtoReadFormulaData() {
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
		for (int i = 0; i <= sheetObj.getLastRowNum(); i++) {
			List<String> getSinglelistObj = new ArrayList<String>();
			Row row = sheetObj.getRow(i);
			for (int j = 0; j < row.getLastCellNum() - 1; j++) {
				Cell cellobj = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				CellType celltype = cellobj.getCellType();
				String sData;
				if (celltype == CellType.NUMERIC) {
					Double dData = cellobj.getNumericCellValue();
					Integer intData = dData.intValue();
					sData = intData.toString();
				} else {
					sData = cellobj.getStringCellValue();
				}
				System.out.print(sData + "     ");

			}
			System.out.println("        ");

			}
		}
	}

			