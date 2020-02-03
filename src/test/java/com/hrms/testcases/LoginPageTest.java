package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class LoginPageTest extends CommonMethods {

//	@Test(groups="smoke")
	public void login() {
		LoginPage login = new LoginPage();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

	}
	/*
	 * Navigate to HRMS Enter uid leave password field blank click login verify
	 * "Password cannot be empty" text close browser
	 */

//	@Test(groups="regression")
	public void negativeLogin() throws InterruptedException {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.loginBtn);
		String expectedError = "Password cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expectedError, "Error message text is not matched");
		Thread.sleep(5000);
	}

	@Test(dataProvider = "getData")
	public void multipleLogin(String uid, String pwd) throws InterruptedException {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard=new DashboardPageElements();
		
		sendText(login.username, uid );
		sendText(login.password, pwd);
		click(login.loginBtn);
		String welcomeText=dashboard.welcomeLnk.getText();
		Assert.assertTrue(welcomeText.contains(uid), "User with username "+uid+" was not able to login");
	}

	@DataProvider
	public Object[][] getData() {
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "Login");

	}

//	@Test
//	public void emptyPasswordLogin() {
//
//		LoginPage login = new LoginPage();
//		sendText(login.username, "Admin");
//		click(login.loginBtn);
//		WebElement errMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
//		String expected = "Password cannot be empty";
//		Assert.assertEquals(errMsg.getText(), expected);
//
//	}
//
//	@Test
//	public void emptyUserNameLogin() {
//
//		LoginPage login = new LoginPage();
//		sendText(login.password, "Hum@nhrm123");
//		click(login.loginBtn);
//		WebElement errMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
//		String expected = "Username cannot be empty";
//		Assert.assertEquals(errMsg.getText(), expected);
//
//	}
//
//	@Test
//	public void logoValidationTest() {
//		LoginPage login = new LoginPage();
//		boolean logo = login.syntaxLogo.isDisplayed();
//		Assert.assertTrue(logo, "Logo is not displayed");
//
//	}

}

/*
 * TC 1: HRMS blank password validation
 * 
 * Navigate to “http://166.62.36.207/humanresources/symfony/web/index” Enter
 * valid username and leave password field empty Click on login button Verify
 * error message with text “Password cannot be empty” is displayed
 * 
 * TC 2: HRMS blank username and password validation
 * 
 * Navigate to “http://166.62.36.207/humanresources/symfony/web/index” Leave
 * username and password field empty Click on login button Verify error message
 * with text “Username cannot be empty” is displayed
 * 
 * TC 2: HRMS blank username and password validation
 * 
 * Navigate to “http://166.62.36.207/humanresources/symfony/web/index” Enter
 * valid username and wrong password Click on login button Verify error message
 * with text “Invalid credentials” is displayed
 */
