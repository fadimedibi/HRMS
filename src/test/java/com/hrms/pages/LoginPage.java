package com.hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrms.testbase.BaseClass;

public class LoginPage extends BaseClass{

public	WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
public	WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
public	WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
public	WebElement syntaxLogo=driver.findElement(By.xpath("//div[@id='divLogo']/img"));
	
}
