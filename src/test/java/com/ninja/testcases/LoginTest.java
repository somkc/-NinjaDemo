package com.ninja.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ninja.base.Base;
import com.ninja.pages.Accountpage;
import com.ninja.pages.Homepage;
import com.ninja.pages.Loginpage;
import com.ninja.utils.Util;

public class LoginTest extends Base {
	Loginpage loginpage;
	Accountpage accountpage;
	Homepage homepage;
	
	public LoginTest() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void setup() throws IOException {
		
	intialize();
	 homepage=new Homepage();
	 loginpage=new Loginpage();
	 accountpage= new Accountpage();
	
	loginpage=homepage.navigateToLoginPage();
		
	}
	@Test(priority=1,dataProvider="loginData")
	public void verfiyValidLogin(String email,String pwd) throws IOException {
	
	// loginpage=new Loginpage();
	
	accountpage=loginpage.login(email, pwd);
	 //accountpage= new Accountpage();
	
	
	
		String expectedMessage="Edit your account information is not displaye";
		//Assert.assertEquals(actualMessage,expectedMessage);
		Assert.assertTrue(accountpage.getDisplayStatusofEditYourAccountInformationOption(), expectedMessage);
		
	}
	@Test(priority=2)
	public void validateWithoutCredentials() throws IOException {
		//Loginpage loginpage=new Loginpage();
		accountpage=loginpage.clickOnLoginButton();
		String actualMessage=loginpage.retrieveWarningMessage(); 
		String expectedMessage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualMessage.contains("Warning: No match for E-Mail Address and/or Password."),expectedMessage);
		
	}
	@Test(priority=3)
	public void verifyLoginWithInvalidCredentials() throws IOException {
		
		// loginpage=new Loginpage();
		
		accountpage=loginpage.login("random@gmail.com", "12345");
		 //accountpage= new Accountpage();
		
		
		
			String expectedMessage="Warning: No match for E-Mail Address and/or Password.";
			//Assert.assertEquals(actualMessage,expectedMessage);
			Assert.assertEquals(accountpage.retrieveEmailPasswordNotMatchingWarningMessage(), expectedMessage);
			
		}
	
	@DataProvider(name="loginData")
	public Object[][] supplyTestData() throws IOException {
		Object[][] data= Util.getTestDataFromExcel("Login");
		
		return data;
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
