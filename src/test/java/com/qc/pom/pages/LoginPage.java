package com.qc.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	this.driver= driver;	
	PageFactory.initElements(driver,this);	
	}
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id= "password")
	WebElement pass;
	
	@FindBy(id="submit")
	WebElement signin;
	
	public void enterEmail(String uName) {
		email.clear();
	
		email.sendKeys(uName);
	}
	public void enterPassword(String uPass) {
		pass.clear();
		pass.sendKeys(uPass);
	}
	
	public void clickonSignin() {
		signin.click();
		
	}
	public boolean veryfyLoginPageTitle() {
		String actTitle= driver.getTitle();
		return actTitle.equals("Queue Codes | Log in");
	}
	
	public  DashboardPage doLoginWithValid(String uName, String uPass) {
		enterEmail(uName);
		enterPassword(uPass);
		clickonSignin();
		return new DashboardPage(driver);
	}
	public  void  doLoginWithInValid(String uName, String uPass) {
		enterEmail(uName);
		enterPassword(uPass);
		clickonSignin();
		

}}
