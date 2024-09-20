package com.nithin.poi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Datadriven {

	@Test(dataProvider = "getData")
	public void loginTest(String name, String password) {
		
	System.out.println("Nithin first code edit");
	System.out.println("Nithin line 2");

	}

	public Object[][] getData() throws IOException {
//		converts data into string
		DataFormatter formatter = new DataFormatter();

//		create file input stream
		String path = "";
		FileInputStream fis = new FileInputStream(path);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

//	    get the row count
		int rowCount = sheet.getPhysicalNumberOfRows();

//	   get cloumns
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();

		Object[][] data = new Object[rowCount - 1][colCount];

		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {

				XSSFCell cell = row.getCell(j);

				data[i][j] = formatter.formatCellValue(cell);

			}
		}

//	    
		return data;
//		create the workbook 

	}

}
