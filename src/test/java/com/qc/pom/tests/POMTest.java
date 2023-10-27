package com.qc.pom.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.DashboardPage;
import com.qc.pom.pages.LoginPage;

public class POMTest extends BaseIntegration{
	
	@Test(dataProvider = "loginTestData")
	public void doLogin(String testName, String uName, String uPass) {
		LoginPage login= new LoginPage(driver);
		if(testName.equals("Both are valid ")) {
		DashboardPage dash =login.doLoginWithValid(uName,uPass);
		Assert.assertTrue(dash.veryfyHomePageTitle());
		dash.logout();
	}else {
		login.doLoginWithInValid(uName, uPass);
		Assert.assertTrue(login.veryfyLoginPageTitle());
	}

	}
}
