package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

	
public class AddEmployeePageTest extends CommonMethods {
@Test	
	public void addEmployeeValidation() {


	LoginPageElements login = new LoginPageElements();
	DashboardPageElements dashboard = new DashboardPageElements();
	AddEmployeePageElements add=new AddEmployeePageElements();
	
	
	sendText(login.username, ConfigsReader.getProperty("username"));
	sendText(login.password, ConfigsReader.getProperty("password"));
	click(login.loginBtn);
	click(dashboard.pim);
	click(dashboard.addEmp);
	sendText(add.fName,"Zamanlamasi");
	sendText(add.mName, "Cok");
	sendText(add.lName,"Manidar");
	click(add.btnSave);
	Assert.assertEquals(add.personalDetail.getText(), "Zamanlamasi Cok Manidar", "Name Does NOT Match");
	

}
}
