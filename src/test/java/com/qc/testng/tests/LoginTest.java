package com.qc.testng.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends BaseIntegration{
	@BeforeSuite
	public void launchBrowser() throws IOException {
		setup();
	}
	@BeforeMethod
	public void locateElement() {
		email=driver.findElement(By.id("email"));
		email.clear();
		
		pass=driver.findElement(By.id("password"));
		pass.clear();
		
		signin=driver.findElement(By.id("submit"));
	}
	@Test(dataProvider="loginTestData")
	public void dologin(String testName, String uName,String uPass) {
		tName=testName;
		email.sendKeys(uName);
		pass.sendKeys(uPass);
		signin.click();
		
	}
	@AfterSuite
	public void doassert() {
		String actresult=driver.getTitle();
		String expResult;
		if (tName.equals("Both are Valid")){
			 expResult = "Queue Codes| Dashboard";
		}else {
			expResult="Queue Codes | Log in";
			
		}
		Assert.assertEquals(actresult,expResult);
		dologout();
	}
	public void dologout() {
		logout=driver.findElement(By.id("hlogout"));
		logout.click();
	}
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}