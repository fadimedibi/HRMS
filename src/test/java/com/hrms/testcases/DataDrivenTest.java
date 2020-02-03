package com.hrms.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class DataDrivenTest extends CommonMethods {
	
	@Test(dataProvider="getData")
	public void addEmployeeValidation(String firstName, String middleName, String lastName) {
	LoginPageElements login=new LoginPageElements();
	login.login("Admin","Syntax@123");

	DashboardPageElements dash=new DashboardPageElements();
	dash.navigateToAddEmployee();
	
	AddEmployeePageElements add=new AddEmployeePageElements();
	
	add.fName.sendKeys(firstName);
	add.mName.sendKeys(middleName);
	add.lName.sendKeys(lastName);
	
	jsClick(add.btnSave);
	
	Assert.assertEquals(add.personalDetail.getText(),firstName+" "+middleName+" "+lastName , "Name Does NOT Match");
	System.out.println("Employee added succesfully");
	takeScreenshot(firstName);
	}

	@DataProvider
	
	public Object[][] getData() throws Exception {
		
	String	filePath= "C:\\Users\\murat\\eclipse-workspace\\HRMS\\src\\test\\java\\com\\practice\\RegTestData.xlsx";
	FileInputStream fis=new FileInputStream(filePath);
	Workbook wbook=new XSSFWorkbook(fis);
	Sheet xlsheet=wbook.getSheet("sheet1");
	
	Object[][] data=new Object[4][3];
	for (int i = 1; i < data.length; i++) {
		for (int j = 0; j < data[i].length; j++) {
			data[i][j]=xlsheet.getRow(i).getCell(j).toString();
			
		}
		
	}
	
	
	return data;
	}
	
	
}
