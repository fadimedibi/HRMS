package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriting {

	@Test
	public void write() throws IOException {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\practice/Hello.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet("Test");
		//if cell is not there, you need to create one
		sheet.getRow(0).createCell(2).setCellValue("Language");
		//if cell is there , grab the cell and update
		sheet.getRow(0).getCell(2).setCellValue("Instructor");
		sheet.getRow(1).createCell(2).setCellValue("weqas Haq");
		//if row is not there, you need to create one
		sheet.createRow(2).createCell(0).setCellValue("Syntax123");
		//once row is created you need to grab it
		sheet.getRow(2).createCell(1).setCellValue("TestNG");
		sheet.getRow(2).createCell(2).setCellValue("Diego");
		//bring object of FileOutputStream to write back into the Excel wile
		FileOutputStream fos=new FileOutputStream(filePath);
		book.write(fos);
		fos.close();
		book.close();
		fis.close();
	}
}
