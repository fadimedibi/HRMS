package com.practice;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLReadPractice {

	@Test
	public void read() throws Exception {
		String filePath= System.getProperty("user.dir")+"/src/test/java/com/practice/RegTestData.xlsx";
		
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wbook=new XSSFWorkbook(fis);//2007 files
		Sheet xlsheet=wbook.getSheet("Sheet1");
		Row row=xlsheet.getRow(0);
		Cell cell=row.getCell(0);
		String value=cell.toString();
		System.out.println(value);

		String value2=xlsheet.getRow(2).getCell(2).toString();

		System.out.println(value2);
	}
	
	
	
	
}
