package com.hrms.testcases;

import java.io.FileInputStream;

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
import com.hrms.utils.ConfigsReader;

public class AddEmployeeFromXLFile extends CommonMethods{
	@Test(dataProvider="RegTestData")

	public void AddEmployee(String firstname, String middlename, String lastname ) {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		AddEmployeePageElements add = new AddEmployeePageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		click(dashboard.pim);
		click(dashboard.addEmp);
		add.RegTestData(firstname, middlename, lastname);
		
		click(add.btnSave);
		
		Assert.assertEquals(add.personalDetail.getText(), firstname+" "+middlename+" "+lastname, "Name Does NOT Match");
		
		
		
		
		
	}

	@DataProvider(name="RegTestData")
	public Object[][] readData() throws Exception {

		String filePath = System.getProperty("user.dir") + "/src/test/java/com/practice/RegTestData.xlsx";

		FileInputStream fis = new FileInputStream(filePath);
		Workbook wbook = new XSSFWorkbook(fis);// 2007 files
		Sheet xlsheet = wbook.getSheet("Sheet1");
		Object array[][] = new Object[4][3];

		for (int i = 1; i <= array.length; i++) {
			for (int j = 0; j <= array[i].length; j++) {

				array[i][j] = xlsheet.getRow(i).getCell(j).toString();
			}
		}

		return array;
	}

}
